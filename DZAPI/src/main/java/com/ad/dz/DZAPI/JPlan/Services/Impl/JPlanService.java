package com.ad.dz.DZAPI.JPlan.Services.Impl;


import java.util.ArrayList;
import java.util.Hashtable;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.ad.dz.DZAPI.JPlan.DTO.JPlanDTO;
import com.ad.dz.DZAPI.JPlan.Services.IJPlanService;
import com.ad.dz.DZAPI.SeatAvailability.DTO.SeatAvlbltyDTO;
import com.ad.dz.DZAPI.SeatAvailability.Service.ISeatAvlbltyService;
import com.ad.dz.DZAPI.TrainsBwStns.Service.ITrainsBwStnsService;

import com.ad.dz.DZAPI.TrainsBwStns.DTO.TrainsBwStnsDTO;

@Service
public class JPlanService implements IJPlanService{
	
	@Autowired ITrainsBwStnsService iTrainsBwStnsSrvc;
	@Autowired ISeatAvlbltyService iSeatAvlbltySrvc;
	
	@Override
	public Hashtable<String,String> info() 
	{
		Hashtable<String,String> ht= new Hashtable<String,String>();
		
		ht.put("API Name","DZAPI");
		ht.put("Function","DZAPI Helps Users to Plan their Complete Journey in One GO");
		ht.put("Developer","Arun Kumar");
		ht.put("E-Mail","arun.akdhiman@gmail.com");
		ht.put("Website","https://www.linkedin.com/in/dkumararun/");
		
		return ht;
	}

	@SuppressWarnings("unchecked")
	@Cacheable("planItCache")
	@Override
	public String planIt(ArrayList<JPlanDTO> jPlanList, String apiKey) 
	{
		StringBuffer sb = new StringBuffer("");
		
		/*
		 * Get Trains b/w Stations
		 */
		sb.append("{\"Journey Description\":\"");
		sb.append(jPlanList.get(0).getSrcStn());
		sb.append(" - ");
		
		for(int i = 0; i < jPlanList.size(); i++)
		{
			sb.append(jPlanList.get(i).getDestStn());
			if(i+1 < jPlanList.size())
				sb.append(" - ");
		}
		sb.append("\",\"Data\":[");
		
		for(int i=0; i< jPlanList.size(); i++)
		{
			sb.append(iTrainsBwStnsSrvc.getTrainsBwStns(new TrainsBwStnsDTO(jPlanList.get(i).getSrcStn(), jPlanList.get(i).getDestStn(), jPlanList.get(i).getjDate()), apiKey));
			if(i+1 < jPlanList.size())
				sb.append(",");
		}
		sb.append("]}");
		
		/*
		 * ERRORR Check!
		 */
		if(sb.toString().toUpperCase().contains("EXCEPTION"))
		{
			JSONObject jObj = new JSONObject();
			jObj.put("ERROR", "Some !ErrOr/Exception! Occured");
			return jObj.toString();
		}
		
		/*
		 * Filter by [fromHrs, toHrs]		 
		 */
		JSONParser parser = new JSONParser();
		JSONObject jObj = new JSONObject();
		try 
		{
			jObj = (JSONObject) parser.parse(sb.toString());
			JSONArray olTrains = new JSONArray();
			olTrains = (JSONArray) jObj.get("Data");	//Get ALL TRAINS : Data [] Array from response
			JSONObject jDataObj = new JSONObject();
			for(int i = 0; i < jPlanList.size(); i++)
			{
				jDataObj = new JSONObject();
				JSONObject trainInfo = new JSONObject();
				JSONArray jTrains= new JSONArray();
				
				jDataObj = (JSONObject) olTrains.get(i);	//Get List of Trains for each jPlan b/w 2 stns one-by-one
				
				jTrains = (JSONArray) jDataObj.get("trains");	//Get List of Trains for first srcStn To destStn
				
				boolean avlbltyFlg = jPlanList.get(i).getSeatAvlblChk();
				
				for(int j = 0; i < jTrains.size();)
				{
					trainInfo = (JSONObject) jTrains.get(j);
					boolean delFlag = false;
					if((trainInfo.get("src_departure_time").toString().compareTo(jPlanList.get(i).getjFromHrs()) <= 0) || (trainInfo.get("src_departure_time").toString().compareTo(jPlanList.get(i).getjToHrs()) >= 0))
					{
						delFlag = true;
					}
					if(delFlag)
						jTrains.remove(j);
					else
					{
						/*
						 * Check Seat Availability and Add result in Response JSON
						 */
						if(avlbltyFlg)
						{
						SeatAvlbltyDTO seatAvlbltyDTO = new SeatAvlbltyDTO(Integer.parseInt((String) trainInfo.get("number")), jPlanList.get(i).getSrcStn(), jPlanList.get(i).getDestStn(), jPlanList.get(i).getjDate(), jPlanList.get(i).getTrvlCls(), "GN - General Quota");
						JSONObject rsrvtnCheckObj = new JSONObject();
						String rsrvtnRes = iSeatAvlbltySrvc.chkAvlblty(seatAvlbltyDTO, apiKey);
						rsrvtnCheckObj = (JSONObject) parser.parse(rsrvtnRes);
						JSONArray avlbltyArray = new JSONArray();
						avlbltyArray = (JSONArray) rsrvtnCheckObj.get("availability");
						trainInfo.put("seat_avaiilability", avlbltyArray.get(0));
						}
						j++;
					}
					if(j == jTrains.size())
						break;
				}
				jDataObj.put("source", jPlanList.get(i).getSrcStn());
				jDataObj.put("destination", jPlanList.get(i).getDestStn());
				jDataObj.put("numOfTrains", jTrains.size());
				jDataObj.remove("total");
				jDataObj.remove("response_code");
				jDataObj.remove("debit");
			}
		}
		catch (Exception e) 
		{
			System.out.println(e);
			jObj.clear();
			jObj.put("EXCEPTION", e);
		}
		//return sb.toString();
		return jObj.toString();
	}
	
}
