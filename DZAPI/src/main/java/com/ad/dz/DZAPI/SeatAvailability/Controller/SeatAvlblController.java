package com.ad.dz.DZAPI.SeatAvailability.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ad.dz.DZAPI.SeatAvailability.DTO.SeatAvlbltyDTO;
import com.ad.dz.DZAPI.SeatAvailability.Service.ISeatAvlbltyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/SeatAvlblty")
@Api(tags = "Seat Availability", value = "Check Seat Availability", description = "Check Seat Availability")
public class SeatAvlblController {
	
	@Autowired ISeatAvlbltyService iSeatAvlbltyService;
	
	@ApiOperation(value="Seat Availability Check", produces="application/json")
	@RequestMapping(value = "/CheckAvlblty/{apiKey}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String chkAvlblty(SeatAvlbltyDTO seatAvlbltyDTO, @PathVariable String apiKey)
	{
		return iSeatAvlbltyService.chkAvlblty(seatAvlbltyDTO,apiKey);
	}

}
