package com.ad.dz.DZAPI.SeatAvailability.Service.Impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.simple.JSONObject;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ad.dz.DZAPI.SeatAvailability.DTO.SeatAvlbltyDTO;
import com.ad.dz.DZAPI.SeatAvailability.Service.ISeatAvlbltyService;

@Service
public class SeatAvlbltyService implements ISeatAvlbltyService{

	@SuppressWarnings("unchecked")
	@Cacheable("chkAvlbltyCache")
	@Override
	public String chkAvlblty(SeatAvlbltyDTO seatAvlbltyDTO, String apiKey) 
	{
		seatAvlbltyDTO.setQuota(seatAvlbltyDTO.getQuota().substring(0,seatAvlbltyDTO.getQuota().indexOf(' ')));
		try 
		{
			URL url = new URL("https://api.railwayapi.com/v2/check-seat/train/"+ seatAvlbltyDTO.getTrainNum() +"/source/"+ seatAvlbltyDTO.getSrcStn() +"/dest/"+ seatAvlbltyDTO.getDestStn() +"/date/"+ seatAvlbltyDTO.getjDate() +"/pref/"+ seatAvlbltyDTO.getTrvlCls() +"/quota/GN/apikey/"+ apiKey +"/");
			System.out.println(url);
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			String str = "";
			StringBuffer sx = new StringBuffer();
			while (null != (str = br.readLine())) {
				System.out.println(str);
				sx.append(str);
			}
			String x = sx.toString();
			return x;
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
			JSONObject jObj = new JSONObject();
			jObj.put("EXCEPTION", ex);
			return jObj.toString();
		} 
	}

}
