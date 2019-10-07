package com.ad.dz.DZAPI.TrainFareEnq.Service;

import com.ad.dz.DZAPI.TrainFareEnq.DTO.TrainFareEnqDTO;

public interface ITrainFareEnqService {

	public String getMyFare(String apiKey, TrainFareEnqDTO trainFareEnqDTO);
}
