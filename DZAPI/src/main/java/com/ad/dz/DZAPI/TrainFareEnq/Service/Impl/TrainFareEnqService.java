package com.ad.dz.DZAPI.TrainFareEnq.Service.Impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.simple.JSONObject;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ad.dz.DZAPI.TrainFareEnq.DTO.TrainFareEnqDTO;
import com.ad.dz.DZAPI.TrainFareEnq.Service.ITrainFareEnqService;

@Service
public class TrainFareEnqService implements ITrainFareEnqService{

	@SuppressWarnings("unchecked")
	@Cacheable("getMyFareCache")
	@Override
	public String getMyFare(String apiKey, TrainFareEnqDTO trainFareEnqDTO) 
	{
		trainFareEnqDTO.setQuota(trainFareEnqDTO.getQuota().substring(0,trainFareEnqDTO.getQuota().indexOf(' ')));
		try 
		{
			URL url = new URL("https://api.railwayapi.com/v2/fare/train/"+ trainFareEnqDTO.getTrainNum() +"/source/"+ trainFareEnqDTO.getSrcStn() +"/dest/"+ trainFareEnqDTO.getDestStn() +"/age/"+ trainFareEnqDTO.getAge() +"/pref/"+ trainFareEnqDTO.getTrvlCls() +"/quota/"+ trainFareEnqDTO.getQuota() +"/date/"+ trainFareEnqDTO.getjDate() +"/apikey/"+ apiKey +"/");
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
