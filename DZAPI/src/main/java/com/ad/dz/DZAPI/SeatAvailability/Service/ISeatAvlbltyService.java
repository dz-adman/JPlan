package com.ad.dz.DZAPI.SeatAvailability.Service;

import com.ad.dz.DZAPI.SeatAvailability.DTO.SeatAvlbltyDTO;

public interface ISeatAvlbltyService {

	public String chkAvlblty(SeatAvlbltyDTO seatAvlbltyDTO, String apiKey);
	
}
