
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
    "bookingId",
    "prodId",
    "searchId",
    "sessionId",
    "provider",
    "bookingBy",
    "bookingByType",
    "bookingStaus",
    "billingStatus",
    "ticketStatus",
    "bookingRemarks",
    "totalAmount",
    "pnrConfirmation",
    "pnrConfirmationUapi",
    "sourceMedia",
    "productType",
    "isLocked",
    "modifiedBy",
    "supplier",
    "mailIssued",
    "modifiedDate",
    "mobileNo", 
    "phoneNo",
    "emailId",
    "flexResult",
    "nearResult",
    "tripType",
    "cabinClass",
    "origin",
    "destination",
    "valCarrier",
    "travelDate",
    "paxFirstName",
    "paxMiddleName",
    "paxLastName",
    "adult",
    "child",
    "infant",
    "infantWs",
    "userIp",
    "device",
    "browser",
    "agentId",
    "userName"
   /*	"statusOnTkt",
   	"plStatus",
   	"plMargin"*/
    
})
public class BookingStatus {

    @JsonProperty("bookingId")
    private String bookingId;
    
  
    @JsonProperty("prodId")
    private Integer prodId;
    @JsonProperty("searchId")
    private String searchId;
    @JsonProperty("sessionId")
    private String sessionId;
    @JsonProperty("provider")
    private Integer provider;
    @JsonProperty("bookingBy")
    private String bookingBy;
    @JsonProperty("bookingByType")
    private String bookingByType;
    @JsonProperty("bookingStaus")
    private String bookingStaus;
    @JsonProperty("bookingRemarks")
    private String bookingRemarks;
    @JsonProperty("totalAmount")
    private String totalAmount;
    @JsonProperty("pnrConfirmation")
    private Object pnrConfirmation;
    @JsonProperty("pnrConfirmationUapi")
    private String pnrConfirmationUapi;
    @JsonProperty("sourceMedia")
    private String sourceMedia;
    @JsonProperty("productType")
    private String productType;
    @JsonProperty("isLocked")
    private Boolean isLocked;
    @JsonProperty("modifiedBy")
    private String modifiedBy;
    @JsonProperty("supplier")
    private String supplier;
    @JsonProperty("mailIssued")
    private Boolean mailIssued;
    @JsonProperty("modifiedDate")
    private Timestamp modifiedDate;
    @JsonProperty("mobileNo")
    private String mobileNo;
    @JsonProperty("phoneNo")
    private String phoneNo;
    @JsonProperty("emailId")
    private String emailId;
    @JsonProperty("flexResult")
    private Object flexResult;
    @JsonProperty("nearResult")
    private Object nearResult;
    @JsonProperty("tripType")
    private Integer tripType;
    @JsonProperty("cabinClass")
    private Integer cabinClass;
    @JsonProperty("origin")
    private String origin;
    @JsonProperty("destination")
    private String destination;
    @JsonProperty("valCarrier")
    private String valCarrier;
    @JsonProperty("travelDate")
    private Timestamp travelDate;
    @JsonProperty("paxFirstName")
    private String paxFirstName;
    @JsonProperty("paxMiddleName")
    private String paxMiddleName;
    @JsonProperty("paxLastName")
    private String paxLastName;
    @JsonProperty("adult")
    private Integer adult;
    @JsonProperty("child")
    private Integer child;
    @JsonProperty("infant")
    private Integer infant;
    @JsonProperty("infantWs")
    private Integer infantWs;
    @JsonProperty("userIp")
    private String userIp;
    @JsonProperty("device")
    private String device;
    @JsonProperty("browser")
    private String browser;
    @JsonProperty("agentId")
    private Integer agentId;
    @JsonProperty("userName")
	private String userName;
  /*  @JsonProperty("statusOnTkt")
	private String statusOnTkt;
    @JsonProperty("plStatus")
	private String plStatus;
    @JsonProperty("plMargin")
	private String plMargin;*/
	@JsonProperty("billingStatus")
    private String billingStatus;
	@JsonProperty("ticketStatus")
	private String ticketStatus;
	
	  @JsonProperty("paymentType")
		private String paymentType; 
		@JsonProperty("paymentStatus")
		private String paymentStatus;
		@JsonProperty("supplierS")
		private String supplierS;
		@JsonProperty("assignTo")
		private String assignTo;
		@JsonProperty("assignStatus")
		private String assignStatus;
		@JsonProperty("risk")
		private String risk; 	
	
    
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("bookingId")
    public String getBookingId() {
        return bookingId;
    }

    @JsonProperty("bookingId")
    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    @JsonProperty("prodId")
    public Integer getProdId() {
        return prodId;
    }

    @JsonProperty("prodId")
    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    @JsonProperty("searchId")
    public String getSearchId() {
        return searchId;
    }

    @JsonProperty("searchId")
    public void setSearchId(String searchId) {
        this.searchId = searchId;
    }

    @JsonProperty("sessionId")
    public String getSessionId() {
        return sessionId;
    }

    @JsonProperty("sessionId")
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @JsonProperty("provider")
    public Integer getProvider() {
        return provider;
    }

    @JsonProperty("provider")
    public void setProvider(Integer provider) {
        this.provider = provider;
    }

    @JsonProperty("bookingBy")
    public String getBookingBy() {
        return bookingBy;
    }

    @JsonProperty("bookingBy")
    public void setBookingBy(String bookingBy) {
        this.bookingBy = bookingBy;
    }

    @JsonProperty("bookingByType")
    public String getBookingByType() {
        return bookingByType;
    }

    @JsonProperty("bookingByType")
    public void setBookingByType(String bookingByType) {
        this.bookingByType = bookingByType;
    }

    @JsonProperty("bookingStaus")
    public String getBookingStaus() {
        return bookingStaus;
    }

    @JsonProperty("bookingStaus")
    public void setBookingStaus(String bookingStaus) {
        this.bookingStaus = bookingStaus;
    }

    @JsonProperty("bookingRemarks")
    public String getBookingRemarks() {
        return bookingRemarks;
    }

    @JsonProperty("bookingRemarks")
    public void setBookingRemarks(String bookingRemarks) {
        this.bookingRemarks = bookingRemarks;
    }

    @JsonProperty("totalAmount")
    public String getTotalAmount() {
        return totalAmount;
    }

    @JsonProperty("totalAmount")
    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    @JsonProperty("pnrConfirmation")
    public Object getPnrConfirmation() {
        return pnrConfirmation;
    }

    @JsonProperty("pnrConfirmation")
    public void setPnrConfirmation(Object pnrConfirmation) {
        this.pnrConfirmation = pnrConfirmation;
    }

    @JsonProperty("pnrConfirmationUapi")
    public String getPnrConfirmationUapi() {
        return pnrConfirmationUapi;
    }

    @JsonProperty("pnrConfirmationUapi")
    public void setPnrConfirmationUapi(String pnrConfirmationUapi) {
        this.pnrConfirmationUapi = pnrConfirmationUapi;
    }

    @JsonProperty("sourceMedia")
    public String getSourceMedia() {
        return sourceMedia;
    }

    @JsonProperty("sourceMedia")
    public void setSourceMedia(String sourceMedia) {
        this.sourceMedia = sourceMedia;
    }

    @JsonProperty("productType")
    public String getProductType() {
        return productType;
    }

    @JsonProperty("productType")
    public void setProductType(String productType) {
        this.productType = productType;
    }

    @JsonProperty("isLocked")
    public Boolean getIsLocked() {
        return isLocked;
    }

    @JsonProperty("isLocked")
    public void setIsLocked(Boolean isLocked) {
        this.isLocked = isLocked;
    }

    @JsonProperty("modifiedBy")
    public String getModifiedBy() {
        return modifiedBy;
    }

    @JsonProperty("modifiedBy")
    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @JsonProperty("supplier")
    public String getSupplier() {
        return supplier;
    }

    @JsonProperty("supplier")
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    @JsonProperty("mailIssued")
    public Boolean getMailIssued() {
        return mailIssued;
    }

    @JsonProperty("mailIssued")
    public void setMailIssued(Boolean mailIssued) {
        this.mailIssued = mailIssued;
    }

    @JsonProperty("modifiedDate")
    public Timestamp getModifiedDate() {
        return modifiedDate;
    }

    @JsonProperty("modifiedDate")
    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @JsonProperty("mobileNo")
    public String getMobileNo() {
        return mobileNo;
    }

    @JsonProperty("mobileNo")
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    @JsonProperty("phoneNo")
    public String getPhoneNo() {
        return phoneNo;
    }

    @JsonProperty("phoneNo")
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @JsonProperty("emailId")
    public String getEmailId() {
        return emailId;
    }

    @JsonProperty("emailId")
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @JsonProperty("flexResult")
    public Object getFlexResult() {
        return flexResult;
    }

    @JsonProperty("flexResult")
    public void setFlexResult(Object flexResult) {
        this.flexResult = flexResult;
    }

    @JsonProperty("nearResult")
    public Object getNearResult() {
        return nearResult;
    }

    @JsonProperty("nearResult")
    public void setNearResult(Object nearResult) {
        this.nearResult = nearResult;
    }

    @JsonProperty("tripType")
    public Integer getTripType() {
        return tripType;
    }

    @JsonProperty("tripType")
    public void setTripType(Integer tripType) {
        this.tripType = tripType;
    }

    @JsonProperty("cabinClass")
    public Integer getCabinClass() {
        return cabinClass;
    }

    @JsonProperty("cabinClass")
    public void setCabinClass(Integer cabinClass) {
        this.cabinClass = cabinClass;
    }

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

    @JsonProperty("valCarrier")
    public String getValCarrier() {
        return valCarrier;
    }

    @JsonProperty("valCarrier")
    public void setValCarrier(String valCarrier) {
        this.valCarrier = valCarrier;
    }

    @JsonProperty("travelDate")
    public Timestamp getTravelDate() {
        return travelDate;
    }

    @JsonProperty("travelDate")
    public void setTravelDate(Timestamp travelDate) {
        this.travelDate = travelDate;
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

    @JsonProperty("adult")
    public Integer getAdult() {
        return adult;
    }

    @JsonProperty("adult")
    public void setAdult(Integer adult) {
        this.adult = adult;
    }

    @JsonProperty("child")
    public Integer getChild() {
        return child;
    }

    @JsonProperty("child")
    public void setChild(Integer child) {
        this.child = child;
    }

    @JsonProperty("infant")
    public Integer getInfant() {
        return infant;
    }

    @JsonProperty("infant")
    public void setInfant(Integer infant) {
        this.infant = infant;
    }

    @JsonProperty("infantWs")
    public Integer getInfantWs() {
        return infantWs;
    }

    @JsonProperty("infantWs")
    public void setInfantWs(Integer infantWs) {
        this.infantWs = infantWs;
    }

    @JsonProperty("userIp")
    public String getUserIp() {
        return userIp;
    }

    @JsonProperty("userIp")
    public void setUserIp(String userIp) {
        this.userIp = userIp;
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
    
    
    public Integer getAgentId() {
		return agentId;
	}

	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}
	
	@JsonProperty("userName")
	public String getUserName() {
		return userName;
	}
	
	@JsonProperty("userName")
	public void setUserName(String userName) {
		this.userName = userName;
	}

/*	@JsonProperty("statusOnTkt")
	public String getStatusOnTkt() {
		return statusOnTkt;
	}
	@JsonProperty("statusOnTkt")
	public void setStatusOnTkt(String statusOnTkt) {
		this.statusOnTkt = statusOnTkt;
	}
	
	@JsonProperty("plStatus")
	public String getPlStatus() {
		return plStatus;
	}
	@JsonProperty("plStatus")
	public void setPlStatus(String plStatus) {
		this.plStatus = plStatus;
	}
	
	@JsonProperty("plMargin")
	public String getPlMargin() {
		return plMargin;
	}
	@JsonProperty("plMargin")
	public void setPlMargin(String plMargin) {
		this.plMargin = plMargin;
	}
*/
	@JsonProperty("billingStatus")
    public String getBillingStatus() {
		return billingStatus;
	}
    @JsonProperty("billingStatus")
	public void setBillingStatus(String billingStatus) {
		this.billingStatus = billingStatus;
	}
    @JsonProperty("ticketStatus")
	public String getTicketStatus() {
		return ticketStatus;
	}
    @JsonProperty("ticketStatus")
	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	
	@JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getSupplierS() {
		return supplierS;
	}

	public void setSupplierS(String supplierS) {
		this.supplierS = supplierS;
	}

	public String getAssignTo() {
		return assignTo;
	}

	public void setAssignTo(String assignTo) {
		this.assignTo = assignTo;
	}

	public String getAssignStatus() {
		return assignStatus;
	}

	public void setAssignStatus(String assignStatus) {
		this.assignStatus = assignStatus;
	}

	public String getRisk() {
		return risk;
	}

	public void setRisk(String risk) {
		this.risk = risk;
	}

	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

}
