package com.travel.object;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"siteId",
	"sourceMedia",
	"device",
	"landing_url",
	"click_tracker",
	"price",
	"fromDate",
	"toDate",
	"userIP",
	"origin",
	"destination"
})

public class ClickTrackerRequest {
	
	@JsonProperty("siteId")
	private String siteId;
	@JsonProperty("sourceMedia")
	private String sourceMedia;
	@JsonProperty("device")
	private String device;
	@JsonProperty("landing_url")
	private String landing_url;
	@JsonProperty("click_tracker")
	private String click_tracker;
	@JsonProperty("price")
	private String price;
	@JsonProperty("fromDate")
	private String fromDate;
	@JsonProperty("toDate")
	private String toDate;
	@JsonProperty("userIP")
	private String userIP;
	@JsonProperty("origin")
	private String origin;
	@JsonProperty("destination")
	private String destination;
	
	@JsonProperty("origin")
	public String getOrigin() {
		return origin;
	}

	@JsonProperty("origin")
	public void setOrigin(String origin) {
		this.origin = origin;
	}

	@JsonProperty("destination")
	public String getDestination() {
		return destination;
	}
	
	@JsonProperty("destination")
	public void setDestination(String destination) {
		this.destination = destination;
	}

	@JsonProperty("userIP")
	public String getUserIP() {
		return userIP;
	}
	
	@JsonProperty("userIP")
	public void setUserIP(String userIP) {
		this.userIP = userIP;
	}
	
	@JsonProperty("siteId")
	public String getSiteId() {
		return siteId;
	}
	
	@JsonProperty("siteId")
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	
	@JsonProperty("sourceMedia")
	public String getSourceMedia() {
		return sourceMedia;
	}
	
	@JsonProperty("sourceMedia")
	public void setSourceMedia(String sourceMedia) {
		this.sourceMedia = sourceMedia;
	}
	
	@JsonProperty("device")
	public String getDevice() {
		return device;
	}
	
	@JsonProperty("device")
	public void setDevice(String device) {
		this.device = device;
	}
	
	@JsonProperty("landing_url")
	public String getLanding_url() {
		return landing_url;
	}
	
	@JsonProperty("landing_url")
	public void setLanding_url(String landing_url) {
		this.landing_url = landing_url;
	}
	
	@JsonProperty("click_tracker")
	public String getClick_tracker() {
		return click_tracker;
	}
	@JsonProperty("click_tracker")
	public void setClick_tracker(String click_tracker) {
		this.click_tracker = click_tracker;
	}
	
	@JsonProperty("price")
	public String getPrice() {
		return price;
	}
	
	@JsonProperty("price")
	public void setPrice(String price) {
		this.price = price;
	}
	
	@JsonProperty("fromDate")
	public String getFromDate() {
		return fromDate;
	}
	
	@JsonProperty("fromDate")
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	
	@JsonProperty("toDate")
	public String getToDate() {
		return toDate;
	}
	
	@JsonProperty("toDate")
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
}
