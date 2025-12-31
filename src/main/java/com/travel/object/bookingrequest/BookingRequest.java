package com.travel.object.bookingrequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.travel.object.ancillaryServices.AncillaryProduct;
import com.travel.object.checkFareRulesResponse.BundleOffer;
import com.travel.object.flightresponse.FlightResult;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "flightResult",
    "adults",
    "child",
    "infants",
    "infantsWs",
    "SearchID",
    "bookingID",
    "prodID",
    "departDate",
    "paymentDetails",
    "passengerDetails",
    "phoneNo",
    "mobileNo",
    "emailID",
    "siteID",
    "sourceMedia",
    "userIP",
    "device",
    "browser",
    "coupons",
    "couponsCode",
    "couponsAmt",
    "totalNight",
    "userSessionID",
    "CacheLocation",
    "returnDate",
    "currencyCode",
    "emailID1",
    "IsTimeChanged",
    "newPrice",
    "IsPriceChange",
    "IsSoldOut",
    "ancillaryProduct",
    "cancellationProtectTaken",
    "cancellationProtectAmount",
    "changeableTickets",
    "changeableTicketAmount",
    "changeableTicketMarkupOne",
    "changeableTicketMarkupOne",
    "changeableTicketType",
    "webcheckinAmount",
    "webcheckinTaken",
    "bundleOffer",
    "bundleOption",
    "metaredirectId",
    "invoiceID",
    "spliPayment",
    "enquiryId",
    "resultId"
})

public class BookingRequest
{	
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
    @JsonProperty("SearchID")
    private String searchID;
    @JsonProperty("bookingID")
    private String bookingID;
    @JsonProperty("prodID")
    private String prodID;
    @JsonProperty("departDate") 
    private String departDate;
    @JsonProperty("paymentDetails")
    private PaymentDetails paymentDetails;
    @JsonProperty("passengerDetails")
    private List<PassengerDetail> passengerDetails = null;
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
    @JsonProperty("device")
    private String device;
    @JsonProperty("browser")
    private String browser;
    @JsonProperty("coupons")
    private String coupons;
    @JsonProperty("couponsCode")
    private String couponsCode;
    @JsonProperty("couponsAmt")
    private Integer couponsAmt;
    @JsonProperty("totalNight")
    private Integer totalNight;
    @JsonProperty("userSessionID")
    private String userSessionID;
    @JsonProperty("CacheLocation")
    private String cacheLocation;
    @JsonProperty("returnDate")
    private String returnDate;
    @JsonProperty("currencyCode")
    private String currencyCode;
    @JsonProperty("emailID1")
    private String emailID1;
    @JsonProperty("IsTimeChanged")
    private Boolean isTimeChanged;
    @JsonProperty("newPrice")
    private Integer newPrice;
    private String bookingStatus;
    @JsonProperty("IsPriceChange")
    private Boolean isPriceChange=false;
    @JsonProperty("IsSoldOut")
    private Boolean isSoldOut=false;
    @JsonProperty("ancillaryProduct")
    private List<AncillaryProduct> ancillaryProduct = null;
    @JsonProperty("cancellationProtectTaken")
    private String cancellationProtectTaken;
    @JsonProperty("cancellationProtectAmount")
    private Double cancellationProtectAmount;
    @JsonProperty("cancelProtectDisplayAmount")
    private Double cancelProtectDisplayAmount;
    @JsonProperty("changeableTickets")
    private String changeableTickets;
    @JsonProperty("changeableTicketAmount")
    private Double changeableTicketAmount;
    @JsonProperty("changeableTicketMarkupOne")
    private Double changeableTicketMarkupOne;
    @JsonProperty("changeableTicketMarkupTwo")
    private Double changeableTicketMarkupTwo;
    @JsonProperty("changeableTicketType")
    private String changeableTicketType;
    @JsonProperty("webcheckinAmount")
    private Double webcheckinAmount;
    @JsonProperty("webcheckinTaken")
    private String webcheckinTaken;
    @JsonProperty("bundleOffer")
    private BundleOffer bundleOffer;
    @JsonProperty("bundleFareAmount")
    private Double bundleFareAmount;
    @JsonProperty("bundleFareTaken")
    private String bundleFareTaken;
    @JsonProperty("bundleFareOptId")
    private String bundleFareOptId;
    @JsonProperty("bundleOfferId")
    private String bundleOfferId;
    @JsonProperty("bundleOption")
    private BundleOption bundleOption;
    
    @JsonProperty("singleFareAmount")
    private Double singleFareAmount;
    @JsonProperty("singleBundleValue")
    private String singleBundleValue;
    @JsonProperty("singleFareTaken")
    private String singleFareTaken;
    @JsonProperty("singleFareOptId")
    private String singleFareOptId;
    @JsonProperty("metaredirectId")
    private String metaredirectId;
    private String invoiceID;
    
    @JsonProperty("enquiryId")
    private String enquiryId;
    
    @JsonProperty("resultId")
    private String resultId;
    
    @JsonProperty("surefundAmount")
    private Double surefundAmount;
    @JsonProperty("surefundTaken")
    private String surefundTaken;
    
    private List<MerchantChargeList> merchantChargeList = null;
    
    @JsonProperty("spliPayment")
	private List<PaymentDetails> spliPayment = null;
    
    private Boolean f9Display=false;
    
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    
    public Boolean getF9Display() {
		return f9Display;
	}
    
	public void setF9Display(Boolean f9Display) {
		this.f9Display = f9Display;
	}

	@JsonProperty("enquiryId")
    public String getEnquiryId() {
		return enquiryId;
	}
    
    @JsonProperty("enquiryId")
	public void setEnquiryId(String enquiryId) {
		this.enquiryId = enquiryId;
	}

	@JsonProperty("spliPayment")
    public List<PaymentDetails> getSpliPayment() {
		return spliPayment;
	}
    
    @JsonProperty("spliPayment")
	public void setSpliPayment(List<PaymentDetails> spliPayment) {
		this.spliPayment = spliPayment;
	}

	public List<MerchantChargeList> getMerchantChargeList() {
		return merchantChargeList;
	}

	public void setMerchantChargeList(List<MerchantChargeList> merchantChargeList) {
		this.merchantChargeList = merchantChargeList;
	}

	public String getInvoiceID() {
		return invoiceID;
	}

	public void setInvoiceID(String invoiceID) {
		this.invoiceID = invoiceID;
	}

	@JsonProperty("metaredirectId")
    public String getMetaredirectId() {
		return metaredirectId;
	}
    	
    @JsonProperty("metaredirectId")
	public void setMetaredirectId(String metaredirectId) {
		this.metaredirectId = metaredirectId;
	}
    
    @JsonProperty("singleFareOptId")
    public String getSingleFareOptId() {
		return singleFareOptId;
	}
    
    @JsonProperty("singleFareOptId")
	public void setSingleFareOptId(String singleFareOptId) {
		this.singleFareOptId = singleFareOptId;
	}

	@JsonProperty("singleFareTaken")
    public String getSingleFareTaken() {
		return singleFareTaken;
	}

    @JsonProperty("singleFareTaken")
	public void setSingleFareTaken(String singleFareTaken) {
		this.singleFareTaken = singleFareTaken;
	}

	@JsonProperty("singleBundleValue")
	public Double getSingleFareAmount() {
		return singleFareAmount;
	}
    
    @JsonProperty("singleBundleValue")
	public void setSingleFareAmount(Double singleFareAmount) {
		this.singleFareAmount = singleFareAmount;
	}

	@JsonProperty("singleFareAmount")
	public String getSingleBundleValue() {
		return singleBundleValue;
	}
	
	@JsonProperty("singleFareAmount")
	public void setSingleBundleValue(String singleBundleValue) {
		this.singleBundleValue = singleBundleValue;
	}

	@JsonProperty("bundleOption")
    public BundleOption getBundleOption() {
		return bundleOption;
	}
    
    @JsonProperty("bundleOption")
	public void setBundleOption(BundleOption bundleOption) {
		this.bundleOption = bundleOption;
	}

    @JsonProperty("bundleOfferId")
	public String getBundleOfferId() {
		return bundleOfferId;
	}

    @JsonProperty("bundleOfferId")
	public void setBundleOfferId(String bundleOfferId) {
		this.bundleOfferId = bundleOfferId;
	}
    
    @JsonProperty("bundleFareOptId")
    public String getBundleFareOptId() {
		return bundleFareOptId;
	}

    @JsonProperty("bundleFareOptId")
	public void setBundleFareOptId(String bundleFareOptId) {
		this.bundleFareOptId = bundleFareOptId;
	}
    
	@JsonProperty("bundleFareAmount")
    public Double getBundleFareAmount() {
		return bundleFareAmount;
	}
    
    @JsonProperty("bundleFareAmount")
	public void setBundleFareAmount(Double bundleFareAmount) {
		this.bundleFareAmount = bundleFareAmount;
	}

    @JsonProperty("bundleFareTaken")
	public String getBundleFareTaken() {
		return bundleFareTaken;
	}
    
    @JsonProperty("bundleFareTaken")
	public void setBundleFareTaken(String bundleFareTaken) {
		this.bundleFareTaken = bundleFareTaken;
	}

	@JsonProperty("bundleOffer")
    public BundleOffer getBundleOffer() {
		return bundleOffer;
	}
    
    @JsonProperty("bundleOffer")
	public void setBundleOffer(BundleOffer bundleOffer) {
		this.bundleOffer = bundleOffer;
	}

	@JsonProperty("changeableTicketType")
    public String getChangeableTicketType() {
		return changeableTicketType;
	}
    
    @JsonProperty("changeableTicketType")
	public void setChangeableTicketType(String changeableTicketType) {
		this.changeableTicketType = changeableTicketType;
	}
    
    @JsonProperty("changeableTicketMarkupOne")
    public Double getChangeableTicketMarkupOne() {
		return changeableTicketMarkupOne;
	}
    
    @JsonProperty("changeableTicketMarkupOne")
	public void setChangeableTicketMarkupOne(Double changeableTicketMarkupOne) {
		this.changeableTicketMarkupOne = changeableTicketMarkupOne;
	}
    
    @JsonProperty("changeableTicketMarkupTwo")
	public Double getChangeableTicketMarkupTwo() {
		return changeableTicketMarkupTwo;
	}
    
    @JsonProperty("changeableTicketMarkupTwo")
	public void setChangeableTicketMarkupTwo(Double changeableTicketMarkupTwo) {
		this.changeableTicketMarkupTwo = changeableTicketMarkupTwo;
	}
    
	@JsonProperty("webcheckinTaken")
    public String getWebcheckinTaken() {
		return webcheckinTaken;
	}

    @JsonProperty("webcheckinTaken")
	public void setWebcheckinTaken(String webcheckinTaken) {
		this.webcheckinTaken = webcheckinTaken;
	}

	@JsonProperty("webcheckinAmount")
    public Double getWebcheckinAmount() {
		return webcheckinAmount;
	}
    
    @JsonProperty("webcheckinAmount")
	public void setWebcheckinAmount(Double webcheckinAmount) {
		this.webcheckinAmount = webcheckinAmount;
	}

	@JsonProperty("changeableTicketAmount")
    public Double getChangeableTicketAmount() {
		return changeableTicketAmount;
	}

    @JsonProperty("changeableTicketAmount")
	public void setChangeableTicketAmount(Double changeableTicketAmount) {
		this.changeableTicketAmount = changeableTicketAmount;
	}

	@JsonProperty("changeableTickets")
    public String getChangeableTickets() {
		return changeableTickets;
	}
    
    @JsonProperty("changeableTickets")
	public void setChangeableTickets(String changeableTickets) {
		this.changeableTickets = changeableTickets;
	}
    
    @JsonProperty("cancelProtectDisplayAmount")
    public Double getCancelProtectDisplayAmount() {
		return cancelProtectDisplayAmount;
	}
    
    @JsonProperty("cancelProtectDisplayAmount")
	public void setCancelProtectDisplayAmount(Double cancelProtectDisplayAmount) {
		this.cancelProtectDisplayAmount = cancelProtectDisplayAmount;
	}
    
	@JsonProperty("cancellationProtectTaken")
    public String getCancellationProtectTaken() {
		return cancellationProtectTaken;
	}

    @JsonProperty("cancellationProtectTaken")
	public void setCancellationProtectTaken(String cancellationProtectTaken) {
		this.cancellationProtectTaken = cancellationProtectTaken;
	}

    @JsonProperty("cancellationProtectAmount")
	public Double getCancellationProtectAmount() {
		return cancellationProtectAmount;
	}
    
    @JsonProperty("cancellationProtectAmount")
	public void setCancellationProtectAmount(Double cancellationProtectAmount) {
		this.cancellationProtectAmount = cancellationProtectAmount;
	}

	@JsonProperty("ancillaryProduct")
    public List<AncillaryProduct> getAncillaryProduct() {
		return ancillaryProduct;
	}
    
    @JsonProperty("ancillaryProduct")
	public void setAncillaryProduct(List<AncillaryProduct> ancillaryProduct) {
		this.ancillaryProduct = ancillaryProduct;
	}
    
    @JsonProperty("IsPriceChange")
    public Boolean getIsPriceChange() {
		return isPriceChange;
	}

    @JsonProperty("IsPriceChange")
	public void setIsPriceChange(Boolean isPriceChange) {
		this.isPriceChange = isPriceChange;
	}

    @JsonProperty("IsSoldOut")
	public Boolean getIsSoldOut() {
		return isSoldOut;
	}

    @JsonProperty("IsSoldOut")
	public void setIsSoldOut(Boolean isSoldOut) {
		this.isSoldOut = isSoldOut;
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

    @JsonProperty("prodID")
    public String getProdID() {
        return prodID;
    }

    @JsonProperty("prodID")
    public void setProdID(String prodID) {
        this.prodID = prodID;
    }

    @JsonProperty("departDate")
    public String getDepartDate() {
        return departDate;
    }

    @JsonProperty("departDate")
    public void setDepartDate(String departDate) {
        this.departDate = departDate;
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

    @JsonProperty("device")
    public String getDevice() {
        return device;
    }

    @JsonProperty("device")
    public void setDevice(String device) {
        this.device = device;
    }

    @JsonProperty("browser")
    public String getBrowser() {
        return browser;
    }

    @JsonProperty("browser")
    public void setBrowser(String browser) {
        this.browser = browser;
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
    public Integer getCouponsAmt() {
        return couponsAmt;
    }

    @JsonProperty("couponsAmt")
    public void setCouponsAmt(Integer couponsAmt) {
        this.couponsAmt = couponsAmt;
    }

    @JsonProperty("totalNight")
    public Integer getTotalNight() {
        return totalNight;
    }

    @JsonProperty("totalNight")
    public void setTotalNight(Integer totalNight) {
        this.totalNight = totalNight;
    }

    @JsonProperty("userSessionID")
    public String getUserSessionID() {
        return userSessionID;
    }

    @JsonProperty("userSessionID")
    public void setUserSessionID(String userSessionID) {
        this.userSessionID = userSessionID;
    }

    @JsonProperty("CacheLocation")
    public String getCacheLocation() {
        return cacheLocation;
    }

    @JsonProperty("CacheLocation")
    public void setCacheLocation(String cacheLocation) {
        this.cacheLocation = cacheLocation;
    }

    @JsonProperty("returnDate")
    public String getReturnDate() {
        return returnDate;
    }

    @JsonProperty("returnDate")
    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    @JsonProperty("currencyCode")
    public String getCurrencyCode() {
        return currencyCode;
    }

    @JsonProperty("currencyCode")
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @JsonProperty("emailID1")
    public String getEmailID1() {
        return emailID1;
    }

    @JsonProperty("emailID1")
    public void setEmailID1(String emailID1) {
        this.emailID1 = emailID1;
    }

    @JsonProperty("IsTimeChanged")
    public Boolean getIsTimeChanged() {
        return isTimeChanged;
    }

    @JsonProperty("IsTimeChanged")
    public void setIsTimeChanged(Boolean isTimeChanged) {
        this.isTimeChanged = isTimeChanged;
    }

    @JsonProperty("newPrice")
    public Integer getNewPrice() {
        return newPrice;
    }

    @JsonProperty("newPrice")
    public void setNewPrice(Integer newPrice) {
        this.newPrice = newPrice;
    }

    	
    public String getBookingStatus() {
		return bookingStatus;
	}

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

	public String getResultId() {
		return resultId;
	}

	public void setResultId(String resultId) {
		this.resultId = resultId;
	}

	public Double getSurefundAmount() {
		return surefundAmount;
	}

	public void setSurefundAmount(Double surefundAmount) {
		this.surefundAmount = surefundAmount;
	}

	public String getSurefundTaken() {
		return surefundTaken;
	}

	public void setSurefundTaken(String surefundTaken) {
		this.surefundTaken = surefundTaken;
	}

	
}
