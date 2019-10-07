package com.ad.dz.DZAPI.PNRCheck.Service.Impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.simple.JSONObject;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ad.dz.DZAPI.PNRCheck.Service.IPNRCheckService;

@Service
public class PNRCheckService implements IPNRCheckService{

	@SuppressWarnings("unchecked")
	@Cacheable("PNRChkCache")
	@Override
	public String PNRChk(String apiKey, String pnrNum)
	{
		try 
		{
			URL url = new URL("https://api.railwayapi.com/v2/pnr-status/pnr/"+ pnrNum +"/apikey/"+ apiKey +"/");
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
