package com.ad.dz.DZAPI.TrainRoute.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ad.dz.DZAPI.TrainRoute.Service.ITrainRouteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/trainRoute")
@Api(tags = "Train Route", value = "Get the Route Info. of the Train", description = "Get the Route Info. of the Train")
public class TrainRouteController {

	@Autowired ITrainRouteService iTrainRouteService;
	
	@ApiOperation(value="Get Train Route Info", produces="application/json")
	@RequestMapping(value = "/{apiKey}/{trainNum}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String RouteChk(@PathVariable String apiKey, @PathVariable String trainNum)
	{
		return iTrainRouteService.routeChk(apiKey, trainNum);
	}
}
