package com.ad.dz.DZAPI.TrainFareEnq.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ad.dz.DZAPI.TrainFareEnq.DTO.TrainFareEnqDTO;
import com.ad.dz.DZAPI.TrainFareEnq.Service.ITrainFareEnqService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/TrainFareEnquiry")
@Api(tags = "Train Fare Enquiry", value = "Train Fare Enquiry", description = "Train Fare Enquiry")
public class TrainFareEnqController {
	
	@Autowired ITrainFareEnqService iTrainFareEnqService;
	
	@ApiOperation(value="Train Fare Enquiry", produces="application/json")
	@RequestMapping(value = "/getMyFare/{apiKey}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String chkAvlblty(TrainFareEnqDTO trainFareEnqDTO, @PathVariable String apiKey)
	{
		return iTrainFareEnqService.getMyFare(apiKey, trainFareEnqDTO);
	}

}
