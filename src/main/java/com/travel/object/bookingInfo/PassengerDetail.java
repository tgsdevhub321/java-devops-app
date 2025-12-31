
package com.travel.object.bookingInfo;

import java.sql.Timestamp;
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
    "passengerDetailId",
    "bookingId",
    "title",
    "paxFirstName",
    "paxMiddleName",
    "paxLastName",
    "frequentFlyerNo",
    "passportNo",
    "nationality",
    "expiryDate",
    "placeOfIssue",
    "placeOfBirth",
    "paxDob",
    "paxType",
    "paxSex",
    "modifiedBy",
    "modifiedDate",
    "pax_ticket",
    "seatNo"
})
public class PassengerDetail {

    @JsonProperty("passengerDetailId")
    private Integer passengerDetailId;
    @JsonProperty("bookingId")
    private Integer bookingId;
    @JsonProperty("title")
    private String title;
    @JsonProperty("paxFirstName")
    private String paxFirstName;
    @JsonProperty("paxMiddleName")
    private String paxMiddleName;
    @JsonProperty("paxLastName")
    private String paxLastName;
    @JsonProperty("frequentFlyerNo")
    private String frequentFlyerNo;
    @JsonProperty("passportNo")
    private Object passportNo;
    @JsonProperty("nationality")
    private Object nationality;
    @JsonProperty("expiryDate")
    private Timestamp expiryDate;
    @JsonProperty("placeOfIssue")
    private String placeOfIssue;
    @JsonProperty("placeOfBirth")
    private String placeOfBirth;
    @JsonProperty("paxDob")
    private Timestamp paxDob;
    @JsonProperty("paxType")
    private Integer paxType;
    @JsonProperty("paxSex")
    private Integer paxSex;
    @JsonProperty("modifiedBy")
    private String modifiedBy;
    @JsonProperty("modifiedDate")
    private Timestamp modifiedDate;
    @JsonProperty("pax_ticket")
    private String paxTicket;
    @JsonProperty("seatNo")
    private Object seatNo;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("passengerDetailId")
    public Integer getPassengerDetailId() {
        return passengerDetailId;
    }

    @JsonProperty("passengerDetailId")
    public void setPassengerDetailId(Integer passengerDetailId) {
        this.passengerDetailId = passengerDetailId;
    }

    @JsonProperty("bookingId")
    public Integer getBookingId() {
        return bookingId;
    }

    @JsonProperty("bookingId")
    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("paxFirstName")
    public String getPaxFirstName() {
        return paxFirstName;
    }

    @JsonProperty("paxFirstName")
    public void setPaxFirstName(String paxFirstName) {
        this.paxFirstName = paxFirstName;
    }

    @JsonProperty("paxMiddleName")
    public String getPaxMiddleName() {
        return paxMiddleName;
    }

    @JsonProperty("paxMiddleName")
    public void setPaxMiddleName(String paxMiddleName) {
        this.paxMiddleName = paxMiddleName;
    }

    @JsonProperty("paxLastName")
    public String getPaxLastName() {
        return paxLastName;
    }

    @JsonProperty("paxLastName")
    public void setPaxLastName(String paxLastName) {
        this.paxLastName = paxLastName;
    }

    @JsonProperty("frequentFlyerNo")
    public String getFrequentFlyerNo() {
        return frequentFlyerNo;
    }

    @JsonProperty("frequentFlyerNo")
    public void setFrequentFlyerNo(String frequentFlyerNo) {
        this.frequentFlyerNo = frequentFlyerNo;
    }

    @JsonProperty("passportNo")
    public Object getPassportNo() {
        return passportNo;
    }

    @JsonProperty("passportNo")
    public void setPassportNo(Object passportNo) {
        this.passportNo = passportNo;
    }

    @JsonProperty("nationality")
    public Object getNationality() {
        return nationality;
    }

    @JsonProperty("nationality")
    public void setNationality(Object nationality) {
        this.nationality = nationality;
    }

    @JsonProperty("expiryDate")
    public Timestamp getExpiryDate() {
        return expiryDate;
    }

    @JsonProperty("expiryDate")
    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }

    @JsonProperty("placeOfIssue")
    public String getPlaceOfIssue() {
        return placeOfIssue;
    }

    @JsonProperty("placeOfIssue")
    public void setPlaceOfIssue(String placeOfIssue) {
        this.placeOfIssue = placeOfIssue;
    }

    @JsonProperty("placeOfBirth") 
    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    @JsonProperty("placeOfBirth")
    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    @JsonProperty("paxDob")
    public Timestamp getPaxDob() {
        return paxDob;
    }

    @JsonProperty("paxDob")
    public void setPaxDob(Timestamp paxDob) {
        this.paxDob = paxDob;
    }

    @JsonProperty("paxType")
    public Integer getPaxType() {
        return paxType;
    }

    @JsonProperty("paxType")
    public void setPaxType(Integer paxType) {
        this.paxType = paxType;
    }

    @JsonProperty("paxSex")
    public Integer getPaxSex() {
        return paxSex;
    }

    @JsonProperty("paxSex")
    public void setPaxSex(Integer paxSex) {
        this.paxSex = paxSex;
    }

    @JsonProperty("modifiedBy")
    public String getModifiedBy() {
        return modifiedBy;
    }

    @JsonProperty("modifiedBy")
    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @JsonProperty("modifiedDate")
    public Timestamp getModifiedDate() {
        return modifiedDate;
    }

    @JsonProperty("modifiedDate")
    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @JsonProperty("pax_ticket")
    public String getPaxTicket() {
        return paxTicket;
    }

    @JsonProperty("pax_ticket")
    public void setPaxTicket(String paxTicket) {
        this.paxTicket = paxTicket;
    }

    @JsonProperty("seatNo")
    public Object getSeatNo() {
        return seatNo;
    }

    @JsonProperty("seatNo")
    public void setSeatNo(Object seatNo) {
        this.seatNo = seatNo;
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
