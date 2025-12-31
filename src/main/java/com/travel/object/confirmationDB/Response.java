package com.travel.object.confirmationDB;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.travel.object.ancillaryServices.AncillaryProduct;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "SearchID",
    "bookingID",
    "departDate",
    "flightResult",
    "adults",
    "child",
    "infants",
    "infantsWs",
    "paymentDetails",
    "passengerDetails",
    "perPaxLuggageOptions",
    "phoneNo",
    "mobileNo",
    "emailID",
    "siteID",
    "sourceMedia",
    "userIP",
    "coupons",
    "couponsCode",
    "couponsAmt",
    "userSessionID",
    "apiCurrencyCode",
    "ancillaryProduct",
    "isticketeRun",
    "isticketeRunRet",
    "serviceCharge",
    "bookingStatus",
    "ancillaryProduct"
})

public class Response {

    @JsonProperty("SearchID")
    private String searchID;
    @JsonProperty("bookingID")
    private String bookingID;
    @JsonProperty("departDate")
    private String departDate;
    @JsonProperty("flightResult")
    private FlightResult flightResult;
    @JsonProperty("adults")
    private Integer adults;
    @JsonProperty("child")
    private Integer child;
    @JsonProperty("infants")
    private Integer infants;
    @JsonProperty("infantsWs")
    private Integer infantsWs;
    @JsonProperty("paymentDetails")
    private PaymentDetails paymentDetails;
    @JsonProperty("passengerDetails")
    private List<PassengerDetail> passengerDetails;
    @JsonProperty("perPaxLuggageOptions")
    private Boolean perPaxLuggageOptions;
    @JsonProperty("phoneNo")
    private String phoneNo;
    @JsonProperty("mobileNo")
    private String mobileNo;
    @JsonProperty("emailID")
    private String emailID;
    @JsonProperty("siteID")
    private Integer siteID;
    @JsonProperty("sourceMedia")
    private String sourceMedia;
    @JsonProperty("userIP")
    private String userIP;
    @JsonProperty("coupons")
    private String coupons;
    @JsonProperty("couponsCode")
    private String couponsCode;
    @JsonProperty("couponsAmt")
    private Double couponsAmt;
    @JsonProperty("userSessionID")
    private String userSessionID;
    @JsonProperty("apiCurrencyCode")
    private String apiCurrencyCode;
    @JsonProperty("ancillaryProduct")
    private List<AncillaryProduct> ancillaryProduct = null;
    @JsonProperty("isticketeRun")
    private Integer isticketeRun;
    @JsonProperty("isticketeRunRet")
    private Integer isticketeRunRet;
    @JsonProperty("serviceCharge")
    private Double serviceCharge;
    @JsonProperty("bookingStatus")
    private String bookingStatus;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("SearchID")
    public String getSearchID() {
        return searchID;
    }

    @JsonProperty("SearchID")
    public void setSearchID(String searchID) {
        this.searchID = searchID;
    }

    @JsonProperty("bookingID")
    public String getBookingID() {
        return bookingID;
    }

    @JsonProperty("bookingID")
    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    @JsonProperty("departDate")
    public String getDepartDate() {
        return departDate;
    }

    @JsonProperty("departDate")
    public void setDepartDate(String departDate) {
        this.departDate = departDate;
    }

    @JsonProperty("flightResult")
    public FlightResult getFlightResult() {
        return flightResult;
    }

    @JsonProperty("flightResult")
    public void setFlightResult(FlightResult flightResult) {
        this.flightResult = flightResult;
    }

    @JsonProperty("adults")
    public Integer getAdults() {
        return adults;
    }

    @JsonProperty("adults")
    public void setAdults(Integer adults) {
        this.adults = adults;
    }

    @JsonProperty("child")
    public Integer getChild() {
        return child;
    }

    @JsonProperty("child")
    public void setChild(Integer child) {
        this.child = child;
    }

    @JsonProperty("infants")
    public Integer getInfants() {
        return infants;
    }

    @JsonProperty("infants")
    public void setInfants(Integer infants) {
        this.infants = infants;
    }

    @JsonProperty("infantsWs")
    public Integer getInfantsWs() {
        return infantsWs;
    }

    @JsonProperty("infantsWs")
    public void setInfantsWs(Integer infantsWs) {
        this.infantsWs = infantsWs;
    }

    @JsonProperty("paymentDetails")
    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }

    @JsonProperty("paymentDetails")
    public void setPaymentDetails(PaymentDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    @JsonProperty("passengerDetails")
    public List<PassengerDetail> getPassengerDetails() {
        return passengerDetails;
    }

    @JsonProperty("passengerDetails")
    public void setPassengerDetails(List<PassengerDetail> passengerDetails) {
        this.passengerDetails = passengerDetails;
    }

    @JsonProperty("perPaxLuggageOptions")
    public Boolean getPerPaxLuggageOptions() {
        return perPaxLuggageOptions;
    }

    @JsonProperty("perPaxLuggageOptions")
    public void setPerPaxLuggageOptions(Boolean perPaxLuggageOptions) {
        this.perPaxLuggageOptions = perPaxLuggageOptions;
    }

    @JsonProperty("phoneNo")
    public String getPhoneNo() {
        return phoneNo;
    }

    @JsonProperty("phoneNo")
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @JsonProperty("mobileNo")
    public String getMobileNo() {
        return mobileNo;
    }

    @JsonProperty("mobileNo")
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    @JsonProperty("emailID")
    public String getEmailID() {
        return emailID;
    }

    @JsonProperty("emailID")
    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    @JsonProperty("siteID")
    public Integer getSiteID() {
        return siteID;
    }

    @JsonProperty("siteID")
    public void setSiteID(Integer siteID) {
        this.siteID = siteID;
    }

    @JsonProperty("sourceMedia")
    public String getSourceMedia() {
        return sourceMedia;
    }

    @JsonProperty("sourceMedia")
    public void setSourceMedia(String sourceMedia) {
        this.sourceMedia = sourceMedia;
    }

    @JsonProperty("userIP")
    public String getUserIP() {
        return userIP;
    }

    @JsonProperty("userIP")
    public void setUserIP(String userIP) {
        this.userIP = userIP;
    }

    @JsonProperty("coupons")
    public String getCoupons() {
        return coupons;
    }

    @JsonProperty("coupons")
    public void setCoupons(String coupons) {
        this.coupons = coupons;
    }

    @JsonProperty("couponsCode")
    public String getCouponsCode() {
        return couponsCode;
    }

    @JsonProperty("couponsCode")
    public void setCouponsCode(String couponsCode) {
        this.couponsCode = couponsCode;
    }

    @JsonProperty("couponsAmt")
    public Double getCouponsAmt() {
        return couponsAmt;
    }

    @JsonProperty("couponsAmt")
    public void setCouponsAmt(Double couponsAmt) {
        this.couponsAmt = couponsAmt;
    }

    @JsonProperty("userSessionID")
    public String getUserSessionID() {
        return userSessionID;
    }

    @JsonProperty("userSessionID")
    public void setUserSessionID(String userSessionID) {
        this.userSessionID = userSessionID;
    }

    @JsonProperty("apiCurrencyCode")
    public String getApiCurrencyCode() {
        return apiCurrencyCode;
    }

    @JsonProperty("apiCurrencyCode")
    public void setApiCurrencyCode(String apiCurrencyCode) {
        this.apiCurrencyCode = apiCurrencyCode;
    }
    
    @JsonProperty("ancillaryProduct")
    public List<AncillaryProduct> getAncillaryProduct() {
		return ancillaryProduct;
	}
    
    @JsonProperty("ancillaryProduct")
	public void setAncillaryProduct(List<AncillaryProduct> ancillaryProduct) {
		this.ancillaryProduct = ancillaryProduct;
	}

    @JsonProperty("isticketeRun")
    public Integer getIsticketeRun() {
        return isticketeRun;
    }

    @JsonProperty("isticketeRun")
    public void setIsticketeRun(Integer isticketeRun) {
        this.isticketeRun = isticketeRun;
    }

    @JsonProperty("isticketeRunRet")
    public Integer getIsticketeRunRet() {
        return isticketeRunRet;
    }

    @JsonProperty("isticketeRunRet")
    public void setIsticketeRunRet(Integer isticketeRunRet) {
        this.isticketeRunRet = isticketeRunRet;
    }

    @JsonProperty("serviceCharge")
    public Double getServiceCharge() {
        return serviceCharge;
    }

    @JsonProperty("serviceCharge")
    public void setServiceCharge(Double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    @JsonProperty("bookingStatus")
    public String getBookingStatus() {
        return bookingStatus;
    }

    @JsonProperty("bookingStatus")
    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
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
