package com.ad.dz.DZAPI.TrainsBwStns.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

@ApiModel(value = "TrainsBwStations", description = "Trains Between Stations Object")
public class TrainsBwStnsDTO {

	@ApiParam(value = "Source Station Code", required = true)
	@ApiModelProperty(value = "Source Station Code", required = true)
	private String srcStn;
	
	@ApiParam(value = "Destination Station Code", required = true)
	@ApiModelProperty(value = "Destination Station Code", required = true)
	private String destStn;
	
	@ApiParam(value = "Journey Date (DD-MM-YYYY)", required = true)
	@ApiModelProperty(value = "Journey Date (DD-MM-YYYY)", required = true)
	private String jDate;
	
	public TrainsBwStnsDTO(String srcStn, String destStn, String jDate) {
		super();
		this.srcStn = srcStn;
		this.destStn = destStn;
		this.jDate = jDate;
	}
	
	public String getSrcStn() {
		return srcStn;
	}
	public void setSrcStn(String srcStn) {
		this.srcStn = srcStn;
	}
	public String getDestStn() {
		return destStn;
	}
	public void setDestStn(String destStn) {
		this.destStn = destStn;
	}
	public String getjDate() {
		return jDate;
	}
	public void setjDate(String jDate) {
		this.jDate = jDate;
	}
	
	@Override
	public String toString() {
		return "TrainsBeStnsDTO [srcStn=" + srcStn + ", destStn=" + destStn + ", jDate=" + jDate + "]";
	}
	
}
