package com.ad.dz.DZAPI.JPlan.Controller;

import java.util.ArrayList;
import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ad.dz.DZAPI.JPlan.DTO.JPlanDTO;
import com.ad.dz.DZAPI.JPlan.Services.IJPlanService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/JPlan")
@Api(tags = "Plan Journey", value = "Plan Your Journey", description = "Plan Your Journey")
public class JPlanController {

	@Autowired
	IJPlanService iJPlanService;

	@ApiOperation(value="DZAPI Info", produces="application/json")
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Hashtable<String,String> info()	//****RETURN A MAP THAT CONTAINS INFO. ABOUT DZAPI****
	{
		return iJPlanService.info();
	}

	@ApiOperation(value="Journey Plan", produces="application/json")
	@RequestMapping(value = "/journey/{apiKey}", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody String infox(@RequestBody ArrayList<JPlanDTO> jPlanList, @PathVariable String apiKey)
	{
		return iJPlanService.planIt(jPlanList, apiKey);
	}
}
