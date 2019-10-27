package com.ad.dz.DZAPI.SeatAvailability.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

@ApiModel(value = "SeatAvailability", description = "Seat Availability Object")
public class SeatAvlbltyDTO {

	@ApiParam(value = "Train Number", required = true)
	@ApiModelProperty(value = "Train Number", required = true)
	private int trainNum;
	
	@ApiParam(value = "Source Station Code", required = true)
	@ApiModelProperty(value = "Source Station Code", required = true)
	private String srcStn;
	
	@ApiParam(value = "Destination Station Code", required = true)
	@ApiModelProperty(value = "Destination Station Code", required = true)
	private String destStn;
	
	@ApiParam(value = "Journey Date (DD-MM-YYYY)", required = true)
	@ApiModelProperty(value = "Journey Date (DD-MM-YYYY)", required = true)
	private String jDate;
	
	@ApiParam(value = "Travelling Class", required = true)
	@ApiModelProperty(value = "Travelling Class", required = true)
	private String trvlCls;
	
	@ApiParam(value = "Quota", required = true, allowableValues = "GN - General Quota, CK - Tatkal Quota, LD - Ladies Quota, DF - Defence Quota, PH - Parliament House Quota, FT - Foreign Tourist Quota, DP - Duty Pass Quota, SS - Female(above 45 Year)/Senior Citizen/Travelling alone, HP - Physically Handicapped Quota, RE - Railway Employee Staff on Duty for the train, YU - Yuva Quota, LB - Lower Birth Quota")
	@ApiModelProperty(value = "Quota (GN)", required = true)
	private String quota;
	
	public SeatAvlbltyDTO(int trainNum, String srcStn, String destStn, String jDate, String trvlCls, String quota) {
		super();
		this.trainNum = trainNum;
		this.srcStn = srcStn;
		this.destStn = destStn;
		this.jDate = jDate;
		this.trvlCls = trvlCls;
		this.quota = quota;
	}
	
	public int getTrainNum() {
		return trainNum;
	}
	public void setTrainNum(int trainNum) {
		this.trainNum = trainNum;
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
	public String getTrvlCls() {
		return trvlCls;
	}
	public void setTrvlCls(String trvlCls) {
		this.trvlCls = trvlCls;
	}
	public String getQuota() {
		return quota;
	}
	public void setQuota(String quota) {
		this.quota = quota;
	}
	@Override
	public String toString() {
		return "SeatAvlbltyDTO [trainNum=" + trainNum + ", srcStn=" + srcStn + ", destStn=" + destStn + ", jDate="
				+ jDate + ", trvlCls=" + trvlCls + ", quota=" + quota + "]";
	}
	
}
