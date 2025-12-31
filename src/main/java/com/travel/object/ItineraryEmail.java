package com.travel.object;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "outAirline",
    "outFlt",
    "outCls",
    "outFrom",
    "outTo",
    "outdepDate",
    "outarvlDate",
    "outStops",
    "inAirline",
    "inFlt",
    "inCls",
    "inFrom",
    "inTo",
    "indepDate",
    "inarvlDate",
    "inStops",
    "adultNo",
    "childNo",
    "infantNo",
    "infantWsNo",
    "adultPrice",
    "childPrice",
    "infantPrice",
    "infantWsPrice",
    "phoneNo",
    "emailId",
    "sourceMedia",
    "outAirCode",
    "inAirCode"
})

public class ItineraryEmail
{	
    @JsonProperty("outAirline")
    private String outAirline;
    @JsonProperty("outFlt")
    private String outFlt;
    @JsonProperty("outCls")
    private String outCls;
    @JsonProperty("outFrom")
    private String outFrom;
    @JsonProperty("outTo")
    private String outTo;
    @JsonProperty("outdepDate")
    private String outdepDate;
    @JsonProperty("outarvlDate")
    private String outarvlDate;
    @JsonProperty("outStops")
    private String outStops;
    @JsonProperty("inAirline")
    private String inAirline;
    @JsonProperty("inFlt")
    private String inFlt;
    @JsonProperty("inCls")
    private String inCls;
    @JsonProperty("inFrom")
    private String inFrom;
    @JsonProperty("inTo")
    private String inTo;
    @JsonProperty("indepDate")
    private String indepDate;
    @JsonProperty("inarvlDate")
    private String inarvlDate;
    @JsonProperty("inStops")
    private String inStops;
    @JsonProperty("adultNo")
    private Integer adultNo;
    @JsonProperty("childNo")
    private Integer childNo;
    @JsonProperty("infantNo")
    private Integer infantNo;
    @JsonProperty("infantWsNo")
    private Integer infantWsNo;
    @JsonProperty("adultPrice")
    private String adultPrice;
    @JsonProperty("childPrice")
    private String childPrice;
    @JsonProperty("infantPrice")
    private String infantPrice;
    @JsonProperty("infantWsPrice")
    private String infantWsPrice;
    @JsonProperty("phoneNo")
    private String phoneNo;
    @JsonProperty("emailId")
    private String emailId;
    
    @JsonProperty("sourceMedia")
    private String sourceMedia;
    @JsonProperty("outAirCode")
    private String outAirCode;
    @JsonProperty("inAirCode")
    private String inAirCode;
    
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    
    @JsonProperty("outAirCode")
    public String getOutAirCode() {
		return outAirCode;
	}

    @JsonProperty("outAirCode")
	public void setOutAirCode(String outAirCode) {
		this.outAirCode = outAirCode;
	}

    @JsonProperty("inAirCode")
	public String getInAirCode() {
		return inAirCode;
	}

    @JsonProperty("inAirCode")
	public void setInAirCode(String inAirCode) {
		this.inAirCode = inAirCode;
	}

	@JsonProperty("sourceMedia")
    public String getSourceMedia() {
		return sourceMedia;
	}
    
    @JsonProperty("sourceMedia")
	public void setSourceMedia(String sourceMedia) {
		this.sourceMedia = sourceMedia;
	}

	@JsonProperty("outAirline")
	public String getOutAirline() {
		return outAirline;
	}
    
    @JsonProperty("outAirline")
	public void setOutAirline(String outAirline) {
		this.outAirline = outAirline;
	}
    
    @JsonProperty("outFlt")
	public String getOutFlt() {
		return outFlt;
	}
    
    @JsonProperty("outFlt")
	public void setOutFlt(String outFlt) {
		this.outFlt = outFlt;
	}
    
    @JsonProperty("outCls")
	public String getOutCls() {
		return outCls;
	}
    
    @JsonProperty("outCls")
	public void setOutCls(String outCls) {
		this.outCls = outCls;
	}
    
    @JsonProperty("outFrom")
	public String getOutFrom() {
		return outFrom;
	}
    
    @JsonProperty("outFrom")
	public void setOutFrom(String outFrom) {
		this.outFrom = outFrom;
	}
    
    @JsonProperty("outTo")
	public String getOutTo() {
		return outTo;
	}
    
    @JsonProperty("outTo")
	public void setOutTo(String outTo) {
		this.outTo = outTo;
	}
    
    @JsonProperty("outdepDate")
	public String getOutdepDate() {
		return outdepDate;
	}
    
    @JsonProperty("outdepDate")
	public void setOutdepDate(String outdepDate) {
		this.outdepDate = outdepDate;
	}
    
    @JsonProperty("outarvlDate")
	public String getOutarvlDate() {
		return outarvlDate;
	}
    
    @JsonProperty("outarvlDate")
	public void setOutarvlDate(String outarvlDate) {
		this.outarvlDate = outarvlDate;
	}
    
    @JsonProperty("outStops")
	public String getOutStops() {
		return outStops;
	}
    
    @JsonProperty("outStops")
	public void setOutStops(String outStops) {
		this.outStops = outStops;
	}
    
    @JsonProperty("inAirline")
	public String getInAirline() {
		return inAirline;
	}
    
    @JsonProperty("inAirline")
	public void setInAirline(String inAirline) {
		this.inAirline = inAirline;
	}
    
    @JsonProperty("inFlt")
	public String getInFlt() {
		return inFlt;
	}
    
    @JsonProperty("inFlt")
	public void setInFlt(String inFlt) {
		this.inFlt = inFlt;
	}
    
    @JsonProperty("inCls")
	public String getInCls() {
		return inCls;
	}
    
    @JsonProperty("inCls")
	public void setInCls(String inCls) {
		this.inCls = inCls;
	}
    
    @JsonProperty("inFrom")
	public String getInFrom() {
		return inFrom;
	}
    
    @JsonProperty("inFrom")
	public void setInFrom(String inFrom) {
		this.inFrom = inFrom;
	}
    
    @JsonProperty("inTo")
	public String getInTo() {
		return inTo;
	}
    
    @JsonProperty("inTo")
	public void setInTo(String inTo) {
		this.inTo = inTo;
	}
    
    @JsonProperty("indepDate")
	public String getIndepDate() {
		return indepDate;
	}
    
    @JsonProperty("indepDate")
	public void setIndepDate(String indepDate) {
		this.indepDate = indepDate;
	}
    
    @JsonProperty("inarvlDate")
	public String getInarvlDate() {
		return inarvlDate;
	}
    
    @JsonProperty("inarvlDate")
	public void setInarvlDate(String inarvlDate) {
		this.inarvlDate = inarvlDate;
	}
    
    @JsonProperty("inStops")
	public String getInStops() {
		return inStops;
	}
    
    @JsonProperty("inStops")
	public void setInStops(String inStops) {
		this.inStops = inStops;
	}
    
    @JsonProperty("adultNo")
	public Integer getAdultNo() {
		return adultNo;
	}

    @JsonProperty("adultNo")
	public void setAdultNo(Integer adultNo) {
		this.adultNo = adultNo;
	}

    @JsonProperty("childNo")
	public int getChildNo() {
		return childNo;
	}

    @JsonProperty("childNo")
	public void setChildNo(int childNo) {
		this.childNo = childNo;
	}

    @JsonProperty("infantNo")
	public int getInfantNo() {
		return infantNo;
	}

    @JsonProperty("infantNo")
	public void setInfantNo(int infantNo) {
		this.infantNo = infantNo;
	}

    @JsonProperty("infantWsNo")
	public int getInfantWsNo() {
		return infantWsNo;
	}

    @JsonProperty("infantWsNo")
	public void setInfantWsNo(int infantWsNo) {
		this.infantWsNo = infantWsNo;
	}

    @JsonProperty("adultPrice")
	public String getAdultPrice() {
		return adultPrice;
	}

    @JsonProperty("adultPrice")
	public void setAdultPrice(String adultPrice) {
		this.adultPrice = adultPrice;
	}

    @JsonProperty("childPrice")
	public String getChildPrice() {
		return childPrice;
	}

    @JsonProperty("childPrice")
	public void setChildPrice(String childPrice) {
		this.childPrice = childPrice;
	}

    @JsonProperty("infantPrice")
	public String getInfantPrice() {
		return infantPrice;
	}

    @JsonProperty("infantPrice")
	public void setInfantPrice(String infantPrice) {
		this.infantPrice = infantPrice;
	}

    @JsonProperty("infantWsPrice")
	public String getInfantWsPrice() {
		return infantWsPrice;
	}
    
    @JsonProperty("infantWsPrice")
	public void setInfantWsPrice(String infantWsPrice) {
		this.infantWsPrice = infantWsPrice;
	}
    
    @JsonProperty("phoneNo")
	public String getPhoneNo() {
		return phoneNo;
	}

    @JsonProperty("phoneNo")
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
    
    @JsonProperty("emailId")
	public String getEmailId() {
		return emailId;
	}

    @JsonProperty("emailId")
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Map<String, Object> getAdditionalProperties() {
		return additionalProperties;
	}

	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

}
