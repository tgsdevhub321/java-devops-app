package com.travel.object.bookingInfo;

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
    "bookingId",
    "trnsNo",
    "amount",
    "cardNo",
    "holderName",
    "expDate",
    "validFrom",
    "issueNo",
    "securityCode",
    "cardType",
    "country",
    "coutyState",
    "city",
    "postCode",
    "address",
    "cardCharges",
    "chargesType",
    "modifiedBy",
    "modifiedDate",
    "password",
    "ids",
    "cardStatus"
})
public class TransactionsDetails {

    @JsonProperty("bookingId")
    private Integer bookingId;
    @JsonProperty("trnsNo")
    private Object trnsNo;
    @JsonProperty("amount")
    private String amount;
    @JsonProperty("cardNo")
    private String cardNo;
    @JsonProperty("holderName")
    private String holderName;
    @JsonProperty("expDate")
    private String expDate;
    @JsonProperty("validFrom")
    private Object validFrom;
    @JsonProperty("issueNo")
    private Object issueNo;
    @JsonProperty("securityCode")
    private String securityCode;
    @JsonProperty("cardType")
    private String cardType;
    @JsonProperty("country")
    private String country;
    @JsonProperty("coutyState")
    private String coutyState;
    @JsonProperty("city")
    private String city;
    @JsonProperty("postCode")
    private String postCode;
    @JsonProperty("address")
    private String address;
    @JsonProperty("cardCharges")
    private String cardCharges;
    @JsonProperty("chargesType")
    private String chargesType;
    @JsonProperty("modifiedBy")
    private Object modifiedBy;
    @JsonProperty("modifiedDate")
    private Object modifiedDate;
    @JsonProperty("password")
    private Object password;
    @JsonProperty("ids")
    private Integer ids;
    @JsonProperty("cardStatus")
    private String cardStatus;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("cardStatus")
    public String getCardStatus() {
		return cardStatus;
	}
    
    @JsonProperty("cardStatus")
	public void setCardStatus(String cardStatus) {
		this.cardStatus = cardStatus;
	}

	@JsonProperty("ids")
    public Integer getIds() {
		return ids;
	}

    @JsonProperty("ids")
	public void setIds(Integer ids) {
		this.ids = ids;
	}
    
    @JsonProperty("bookingId")
    public Integer getBookingId() {
        return bookingId;
    }

    @JsonProperty("bookingId")
    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    @JsonProperty("trnsNo")
    public Object getTrnsNo() {
        return trnsNo;
    }

    @JsonProperty("trnsNo")
    public void setTrnsNo(Object trnsNo) {
        this.trnsNo = trnsNo;
    }

    @JsonProperty("amount")
    public String getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(String amount) {
        this.amount = amount;
    }

    @JsonProperty("cardNo")
    public String getCardNo() {
        return cardNo;
    }

    @JsonProperty("cardNo")
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    @JsonProperty("holderName")
    public String getHolderName() {
        return holderName;
    }

    @JsonProperty("holderName")
    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    @JsonProperty("expDate")
    public String getExpDate() {
        return expDate;
    }

    @JsonProperty("expDate")
    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    @JsonProperty("validFrom")
    public Object getValidFrom() {
        return validFrom;
    }

    @JsonProperty("validFrom")
    public void setValidFrom(Object validFrom) {
        this.validFrom = validFrom;
    }

    @JsonProperty("issueNo")
    public Object getIssueNo() {
        return issueNo;
    }

    @JsonProperty("issueNo")
    public void setIssueNo(Object issueNo) {
        this.issueNo = issueNo;
    }

    @JsonProperty("securityCode")
    public String getSecurityCode() {
        return securityCode;
    }

    @JsonProperty("securityCode")
    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    @JsonProperty("cardType")
    public String getCardType() {
        return cardType;
    }

    @JsonProperty("cardType")
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("coutyState")
    public String getCoutyState() {
        return coutyState;
    }

    @JsonProperty("coutyState")
    public void setCoutyState(String coutyState) {
        this.coutyState = coutyState;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("postCode")
    public String getPostCode() {
        return postCode;
    }

    @JsonProperty("postCode")
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("cardCharges")
    public String getCardCharges() {
        return cardCharges;
    }

    @JsonProperty("cardCharges")
    public void setCardCharges(String cardCharges) {
        this.cardCharges = cardCharges;
    }

    @JsonProperty("chargesType")
    public String getChargesType() {
        return chargesType;
    }

    @JsonProperty("chargesType")
    public void setChargesType(String chargesType) {
        this.chargesType = chargesType;
    }

    @JsonProperty("modifiedBy")
    public Object getModifiedBy() {
        return modifiedBy;
    }

    @JsonProperty("modifiedBy")
    public void setModifiedBy(Object modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @JsonProperty("modifiedDate")
    public Object getModifiedDate() {
        return modifiedDate;
    }

    @JsonProperty("modifiedDate")
    public void setModifiedDate(Object modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @JsonProperty("password")
    public Object getPassword() {
        return password;
    }

    @JsonProperty("password")
    public void setPassword(Object password) {
        this.password = password;
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
