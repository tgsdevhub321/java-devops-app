
package com.travel.object.genericRequest;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "fullName",
    "checkInDate",
    "checkOutDate",
    "noOfGuests",
    "noOfNights",
    "phoneNumber",
    "email"
})
public class HotelForm {

    @JsonProperty("fullName")
    private String fullName;
    @JsonProperty("checkInDate")
    private String checkInDate;
    @JsonProperty("checkOutDate")
    private String checkOutDate;
    @JsonProperty("noOfGuests")
    private String noOfGuests;
    @JsonProperty("noOfNights")
    private String noOfNights;
    @JsonProperty("phoneNumber")
    private String phoneNumber;
    @JsonProperty("email")
    private String email;
    
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}
	public String getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public String getNoOfGuests() {
		return noOfGuests;
	}
	public void setNoOfGuests(String noOfGuests) {
		this.noOfGuests = noOfGuests;
	}
	public String getNoOfNights() {
		return noOfNights;
	}
	public void setNoOfNights(String noOfNights) {
		this.noOfNights = noOfNights;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
