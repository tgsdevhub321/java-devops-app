
package com.travel.object.confirmationDB;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "travelerNo",
    "passengerType",
    "title",
    "firstName",
    "middleName",
    "lastName",
    "dateOfBirth",
    "gender",
    "issueCountry",
    "paxTicket"
})
@Generated("jsonschema2pojo")
public class PassengerDetail {

    @JsonProperty("travelerNo")
    private Integer travelerNo;
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
    @JsonProperty("issueCountry")
    private String issueCountry;
    @JsonProperty("paxTicket")
    private String paxTicket;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("travelerNo")
    public Integer getTravelerNo() {
        return travelerNo;
    }

    @JsonProperty("travelerNo")
    public void setTravelerNo(Integer travelerNo) {
        this.travelerNo = travelerNo;
    }

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

    @JsonProperty("issueCountry")
    public String getIssueCountry() {
        return issueCountry;
    }

    @JsonProperty("issueCountry")
    public void setIssueCountry(String issueCountry) {
        this.issueCountry = issueCountry;
    }

    @JsonProperty("paxTicket")
    public String getPaxTicket() {
        return paxTicket;
    }

    @JsonProperty("paxTicket")
    public void setPaxTicket(String paxTicket) {
        this.paxTicket = paxTicket;
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
