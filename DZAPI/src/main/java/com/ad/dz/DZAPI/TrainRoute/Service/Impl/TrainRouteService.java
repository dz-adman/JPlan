package com.ad.dz.DZAPI.TrainRoute.Service.Impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

import javax.net.ssl.X509TrustManager;

import org.json.simple.JSONObject;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ad.dz.DZAPI.TrainRoute.Service.ITrainRouteService;

@Service
public class TrainRouteService implements ITrainRouteService{

	@SuppressWarnings("unchecked")
	@Cacheable("routeChkCache")
	@Override
	public String routeChk(String apiKey, String trainNum) 
	{
		try 
		{
			// BY-PASS SSL for HTTPS Connection 	----Start
			TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}
			public void checkClientTrusted(X509Certificate[] certs, String authType) {
			}
			public void checkServerTrusted(X509Certificate[] certs, String authType) {
			}
			}};

			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
			// BY-PASS SSL for HTTPS Connection 	----End
			
			URL url = new URL("https://indianrailapi.com/api/v2/TrainSchedule/apikey/" + apiKey + "/TrainNumber/" + trainNum + "/");
			System.out.println(url);

			URLConnection con = url.openConnection();
			Reader reader = new InputStreamReader(con.getInputStream());
			BufferedReader br = new BufferedReader(reader);

			String str = "";
			StringBuffer sx = new StringBuffer();
			while ((str = br.readLine()) != null) {
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
