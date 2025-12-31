package com.travel.object.bookingrequest;

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
    "passengerType",
    "title",
    "firstName",
    "middleName",
    "lastName",
    "dateOfBirth",
    "gender",
    "dobDay",
    "dateOfMonth",
    "dateOfYear",
    "outwardLuggageOptions",
    "returnLuggageOptions",
    "contactName",
    "contactNumber",
    "tsaPrecheck",
    "reDressNumber",
    "splRequest"
})

public class PassengerDetail {
	
    @JsonProperty("passengerType")
    private Integer passengerType;
    @JsonProperty("title")
    private String title;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("middleName")
    private String middleName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("dateOfBirth")
    private String dateOfBirth;
    @JsonProperty("gender")
    private Integer gender;
    @JsonProperty("dobDay")
    private String dobDay;
    @JsonProperty("dateOfMonth")
    private String dateOfMonth;
    @JsonProperty("dateOfYear")
    private String dateOfYear;
    @JsonProperty("outwardLuggageOptions")
    private String outwardLuggageOptions;
    @JsonProperty("returnLuggageOptions")
    private String returnLuggageOptions;
    
    @JsonProperty("contactName")
    private String contactName;
	@JsonProperty("contactNumber")
    private String contactNumber;
    @JsonProperty("tsaPrecheck")
    private String tsaPrecheck;
    @JsonProperty("reDressNumber")
    private String reDressNumber;
    @JsonProperty("splRequest")
    private String splRequest;
    
    
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("passengerType")
    public Integer getPassengerType() {
        return passengerType;
    }

    @JsonProperty("passengerType")
    public void setPassengerType(Integer passengerType) {
        this.passengerType = passengerType;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }
    
    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("middleName")
    public String getMiddleName() {
        return middleName;
    }

    @JsonProperty("middleName")
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("dateOfBirth")
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    @JsonProperty("dateOfBirth")
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @JsonProperty("gender")
    public Integer getGender() {
        return gender;
    }

    @JsonProperty("gender")
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @JsonProperty("dobDay")
    public String getDobDay() {
        return dobDay;
    }

    @JsonProperty("dobDay")
    public void setDobDay(String dobDay) {
        this.dobDay = dobDay;
    }

    @JsonProperty("dateOfMonth")
    public String getDateOfMonth() {
        return dateOfMonth;
    }

    @JsonProperty("dateOfMonth")
    public void setDateOfMonth(String dateOfMonth) {
        this.dateOfMonth = dateOfMonth;
    }

    @JsonProperty("dateOfYear")
    public String getDateOfYear() {
        return dateOfYear;
    }

    @JsonProperty("dateOfYear")
    public void setDateOfYear(String dateOfYear) {
        this.dateOfYear = dateOfYear;
    }

    @JsonProperty("outwardLuggageOptions")
    public String getOutwardLuggageOptions() {
        return outwardLuggageOptions;
    }

    @JsonProperty("outwardLuggageOptions")
    public void setOutwardLuggageOptions(String outwardLuggageOptions) {
        this.outwardLuggageOptions = outwardLuggageOptions;
    }

    @JsonProperty("returnLuggageOptions")
    public String getReturnLuggageOptions() {
        return returnLuggageOptions;
    }

    @JsonProperty("returnLuggageOptions")
    public void setReturnLuggageOptions(String returnLuggageOptions) {
        this.returnLuggageOptions = returnLuggageOptions;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getTsaPrecheck() {
		return tsaPrecheck;
	}

	public void setTsaPrecheck(String tsaPrecheck) {
		this.tsaPrecheck = tsaPrecheck;
	}

	public String getReDressNumber() {
		return reDressNumber;
	}

	public void setReDressNumber(String reDressNumber) {
		this.reDressNumber = reDressNumber;
	}

	public String getSplRequest() {
		return splRequest;
	}

	public void setSplRequest(String splRequest) {
		this.splRequest = splRequest;
	}
}
