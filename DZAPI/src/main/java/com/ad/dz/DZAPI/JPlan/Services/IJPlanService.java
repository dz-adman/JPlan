package com.ad.dz.DZAPI.JPlan.Services;

import java.util.ArrayList;
import java.util.Hashtable;

import com.ad.dz.DZAPI.JPlan.DTO.JPlanDTO;

public interface IJPlanService 
{
	public Hashtable<String, String> info();
	public String planIt(ArrayList<JPlanDTO> jPlanList, String apiKey);
}
