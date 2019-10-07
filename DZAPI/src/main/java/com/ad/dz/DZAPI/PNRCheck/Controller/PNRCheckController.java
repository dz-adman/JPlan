package com.ad.dz.DZAPI.PNRCheck.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ad.dz.DZAPI.PNRCheck.Service.IPNRCheckService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/PNRCheck")
@Api(tags = "PNR Status", value = "Check PNR Status", description = "Check PNR Status")
public class PNRCheckController 
{

	@Autowired IPNRCheckService iPNR_ChkService;
	
	@ApiOperation(value="Seat Availability Check", produces="application/json")
	@RequestMapping(value = "/{apiKey}/{pnrNum}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String PNRChk(@PathVariable String apiKey, @PathVariable String pnrNum)
	{
		return iPNR_ChkService.PNRChk(apiKey, pnrNum);
	}
}
