package com.travel.object.bookingInfo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ancillaryId",
    "bookingId",
    "supplierApi",
    "priceTypePax",
    "fullName",
    "shortName",
    "fareLadderText"
})
public class Ancillary {

	@JsonProperty("ancillaryId")
	private Integer ancillaryId;
	@JsonProperty("bookingId")
	private Integer bookingId;
	@JsonProperty("supplierApi")
	private String supplierApi;
	@JsonProperty("priceTypePax")
	private Double priceTypePax;
	@JsonProperty("fullName")
	private String fullName;
	@JsonProperty("shortName")
	private String shortName;
	@JsonProperty("fareLadderText")
	private String fareLadderText;
	
	@JsonProperty("booking_date_time")
	private String booking_date_time;
	
	@JsonProperty("siteId")
	private String siteId;
	@JsonProperty("invoiceNum")
	private String invoiceNum;
	@JsonProperty("supplier")
	private String supplier;
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("ancillaryId")
	public Integer getAncillaryId() {
		return ancillaryId;
	}
	@JsonProperty("ancillaryId")
	public void setAncillaryId(Integer ancillaryId) {
		this.ancillaryId = ancillaryId;
	}
	
	@JsonProperty("bookingId")
	public Integer getBookingId() {
		return bookingId;
	}
	@JsonProperty("bookingId")
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	@JsonProperty("supplierApi")
	public String getSupplierApi() {
		return supplierApi;
	}
	@JsonProperty("supplierApi")
	public void setSupplierApi(String supplierApi) {
		this.supplierApi = supplierApi;
	}
	
	@JsonProperty("priceTypePax")
	public Double getPriceTypePax() {
		return priceTypePax;
	}
	
	@JsonProperty("priceTypePax")
	public void setPriceTypePax(Double priceTypePax) {
		this.priceTypePax = priceTypePax;
	}
	
	@JsonProperty("fullName")
	public String getFullName() {
		return fullName;
	}
	
	@JsonProperty("fullName")
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	@JsonProperty("shortName")
	public String getShortName() {
		return shortName;
	}
	
	@JsonProperty("shortName")
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	
	@JsonProperty("fareLadderText")
	public String getFareLadderText() {
		return fareLadderText;
	}
	
	@JsonProperty("fareLadderText")
	public void setFareLadderText(String fareLadderText) {
		this.fareLadderText = fareLadderText;
	}
	/**
	 * @return the booking_date_time
	 */
	public String getBooking_date_time() {
		return booking_date_time;
	}
	/**
	 * @param booking_date_time the booking_date_time to set
	 */
	public void setBooking_date_time(String booking_date_time) {
		this.booking_date_time = booking_date_time;
	}

	@JsonProperty("siteId")
	public String getSiteId() {
		return siteId;
	}
	
	@JsonProperty("siteId")
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}


	@JsonProperty("invoiceNum")
	public String getInvoiceNum() {
		return invoiceNum;
	}
	
	@JsonProperty("invoiceNum")
	public void setInvoiceNum(String invoiceNum) {
		this.invoiceNum = invoiceNum;
	}
	
	@JsonProperty("supplier")
	public String getSupplier() {
		return supplier;
	}
	@JsonProperty("supplier")
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	@JsonProperty("status")
	public String getStatus() {
		return status;
	}
	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

	

}
