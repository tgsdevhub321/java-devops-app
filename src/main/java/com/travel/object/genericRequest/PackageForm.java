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
	"destination",
    "noOfDays",
    "noOfTravellers",
    "phoneNumber",
    "email"
})
public class PackageForm {

    @JsonProperty("fullName")
    private String fullName;
    @JsonProperty("destination")
    private String destination;
    @JsonProperty("noOfDays")
    private String noOfDays;
    @JsonProperty("noOfTravellers")
    private String noOfTravellers;
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

	public String getdestination() {
		return destination;
	}

	public void setdestination(String destination) {
		this.destination = destination;
	}

	public String getnoOfDays() {
		return noOfDays;
	}

	public void setnoOfDays(String noOfDays) {
		this.noOfDays = noOfDays;
	}

	public String getnoOfTravellers() {
		return noOfTravellers;
	}

	public void setnoOfTravellers(String noOfTravellers) {
		this.noOfTravellers = noOfTravellers;
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

	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
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
