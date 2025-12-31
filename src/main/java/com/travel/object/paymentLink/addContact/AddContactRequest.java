package com.travel.object.paymentLink.addContact;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"bookingId",
	"agentId",
	"phoneNum",
	"mobileNum"
})

public class AddContactRequest 
{
	@JsonProperty("bookingId")
	private String bookingId;
	@JsonProperty("agentId")
	private String agentId;
	@JsonProperty("phoneNum")
	private String phoneNum;
	@JsonProperty("mobileNum")
	private String mobileNum;

	@JsonProperty("bookingId")
	public String getBookingId() {
		return bookingId;
	}

	@JsonProperty("bookingId")
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	@JsonProperty("agentId")
	public String getAgentId() {
		return agentId;
	}

	@JsonProperty("agentId")
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	@JsonProperty("phoneNum")
	public String getPhoneNum() {
		return phoneNum;
	}

	@JsonProperty("phoneNum")
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	@JsonProperty("mobileNum")
	public String getMobileNum() {
		return mobileNum;
	}

	@JsonProperty("mobileNum")
	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

}