package com.ad.dz.DZAPI.TrainsBwStns.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ad.dz.DZAPI.TrainsBwStns.Service.ITrainsBwStnsService;
import com.ad.dz.DZAPI.TrainsBwStns.DTO.TrainsBwStnsDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/TrainsBwStns")
@Api(tags = "Trains Between Stations", value = "Find Trains between Two Stations", description = "Find Trains between Two Stations")
public class TrainBwStnsController {

	@Autowired ITrainsBwStnsService iTrainsBwStnsService;
	
	@ApiOperation(value="Find Trains B/w Stations", produces="application/json")
	@RequestMapping(value = "/CheckAvlblty/{apiKey}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String chkAvlblty(TrainsBwStnsDTO trainsBwStnsDTO, @PathVariable String apiKey)
	{
		return iTrainsBwStnsService.getTrainsBwStns(trainsBwStnsDTO,apiKey);
	}
}
