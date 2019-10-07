package com.ad.dz.DZAPI.TrainsBwStns.Service.Impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.simple.JSONObject;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ad.dz.DZAPI.TrainsBwStns.Service.ITrainsBwStnsService;
import com.ad.dz.DZAPI.TrainsBwStns.DTO.TrainsBwStnsDTO;

@Service
public class TrainBwStnsService implements ITrainsBwStnsService{

	@SuppressWarnings("unchecked")
	@Cacheable("getTrainsBwStnsCache")
	@Override
	public String getTrainsBwStns(TrainsBwStnsDTO trainsBwStnsDTO, String apiKey) 
	{	
		try 
		{
			URL url = new URL("https://api.railwayapi.com/v2/between/source/"+ trainsBwStnsDTO.getSrcStn() +"/dest/"+ trainsBwStnsDTO.getDestStn() +"/date/"+ trainsBwStnsDTO.getjDate() +"/apikey/"+ apiKey +"/");
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
