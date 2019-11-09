package com.ad.dz.DZAPI.JPlan.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

@ApiModel(value = "JPlan", description = "Journey Plan Object")
public class JPlanDTO {

	@ApiParam(value = "Source Station Code", required = true)
	@ApiModelProperty(value = "Source Station Code", required = true)
	private String srcStn;
	
	@ApiParam(value = "Journey Date (DD-MM-YYYY)", required = true)
	@ApiModelProperty(value = "Journey Date (DD-MM-YYYY)", required = true)
	private String jDate;
	
	@ApiParam(value = "From Time(0-24hrs) [hh:mm:ss]", required = true)
	@ApiModelProperty(value = "From Time(0-24hrs) [hh:mm:ss]", required = true)
	private String jFromHrs;
	
	@ApiParam(value = "To Time(0-24hrs) [hh:mm:ss]", required = true)
	@ApiModelProperty(value = "To Time(0-24hrs) [hh:mm:ss]", required = true)
	private String jToHrs;
	
	@ApiParam(value = "Seat Availibility Check (boolean)", required = true)
	@ApiModelProperty(value = "Seat Availibility Check", required = true)
	private Boolean seatAvlblChk;
	
	@ApiParam(value = "Travelling Class", required = true)
	@ApiModelProperty(value = "Travelling Class", required = true)
	private String trvlCls;
	
	@ApiParam(value = "Destination Station Code", required = true)
	@ApiModelProperty(value = "Destination Station Code", required = true)
	private String destStn;
	
	public String getSrcStn() {
		return srcStn;
	}
	public void setSrcStn(String srcStn) {
		this.srcStn = srcStn;
	}
	public String getjDate() {
		return jDate;
	}
	public void setjDate(String jDate) {
		this.jDate = jDate;
	}
	public String getjFromHrs() {
		return jFromHrs;
	}
	public void setjFromHrs(String jFromHrs) {
		this.jFromHrs = jFromHrs;
	}
	public String getjToHrs() {
		return jToHrs;
	}
	public void setjToHrs(String jToHrs) {
		this.jToHrs = jToHrs;
	}
	public Boolean getSeatAvlblChk() {
		return seatAvlblChk;
	}
	public void setSeatAvlblChk(Boolean seatAvlblChk) {
		this.seatAvlblChk = seatAvlblChk;
	}
	public String getTrvlCls() {
		return trvlCls;
	}
	public void setTrvlCls(String trvlCls) {
		this.trvlCls = trvlCls;
	}
	public String getDestStn() {
		return destStn;
	}
	public void setDestStn(String destStn) {
		this.destStn = destStn;
	}
	
	@Override
	public String toString() {
		return "JPlan [srcStn=" + srcStn + ", jDate=" + jDate + ", jFromHrs=" + jFromHrs + ", jToHrs=" + jToHrs
				+ ", seatAvlblChk=" + seatAvlblChk + ", trvlCls=" + trvlCls + ", destStn=" + destStn + "]";
	}
	
}
