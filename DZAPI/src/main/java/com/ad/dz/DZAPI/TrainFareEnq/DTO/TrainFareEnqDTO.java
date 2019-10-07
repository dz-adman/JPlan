package com.ad.dz.DZAPI.TrainFareEnq.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;

@ApiModel(value = "TrainFareEnquiry", description = "Train Fare Enquiry Object")
public class TrainFareEnqDTO {
	
	@ApiParam(value = "Train Number", required = true)
	private int trainNum;
	
	@ApiParam(value = "Source Station Code", required = true)
	private String srcStn;
	
	@ApiParam(value = "Destination Station Code", required = true)
	private String destStn;
	
	@ApiParam(value = "Age of Passenger", required = true)
	private int age;
	
	@ApiParam(value = "Travelling Class", required = true)
	private String trvlCls;
	
	@ApiParam(value = "Quota", required = true, allowableValues = "GN - General Quota, CK - Tatkal Quota, LD - Ladies Quota, DF - Defence Quota, PH - Parliament House Quota, FT - Foreign Tourist Quota, DP - Duty Pass Quota, SS - Female(above 45 Year)/Senior Citizen/Travelling alone, HP - Physically Handicapped Quota, RE - Railway Employee Staff on Duty for the train, YU - Yuva Quota, LB - Lower Birth Quota")
	private String quota;
	
	public TrainFareEnqDTO(int trainNum, String srcStn, String destStn, int age, String trvlCls, String quota,
			String jDate) {
		super();
		this.trainNum = trainNum;
		this.srcStn = srcStn;
		this.destStn = destStn;
		this.age = age;
		this.trvlCls = trvlCls;
		this.quota = quota;
		this.jDate = jDate;
	}
	
	private String jDate;

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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTrvlCls() {
		return trvlCls;
	}
	public void setTrvlCls(String trvlCls) {
		this.trvlCls = trvlCls;
	}
	public String getjDate() {
		return jDate;
	}
	public void setjDate(String jDate) {
		this.jDate = jDate;
	}
	public String getQuota() {
		return quota;
	}
	public void setQuota(String quota) {
		this.quota = quota;
	}
	@Override
	public String toString() {
		return "TrainFareEnqDTO [trainNum=" + trainNum + ", srcStn=" + srcStn + ", destStn=" + destStn + ", age=" + age
				+ ", trvlCls=" + trvlCls + ", quota=" + quota + ", jDate=" + jDate + "]";
	}
	
}
