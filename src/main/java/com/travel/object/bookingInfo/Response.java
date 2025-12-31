
package com.travel.object.bookingInfo;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "TransactionsDetails",
    "PassengerDetails",
    "SectorDetail",
    "BookingsHistory",
    "bookingDetail",
    "BookingsNotes",
    "FareDetail",
    "TraveloesMail", 
    "siteID",
    "invoiceNum",
    "isSaleShow",
    "isVcshow"
})

public class Response {

	@JsonProperty("invoiceNum")
	private String invoiceNum; 
	@JsonProperty("siteID")
	private String siteID;
	@JsonProperty("bookingDate")
	private Timestamp bookingDate;
	@JsonProperty("currency")
	private String currency;
    @JsonProperty("TransactionsDetails")
    private TransactionsDetails transactionsDetails;
    @JsonProperty("transDetail")
    private List<TransactionsDetails> transDetail;
    @JsonProperty("PassengerDetails")
    private List<PassengerDetail> passengerDetails = null;
    @JsonProperty("SectorDetail")
    private List<SectorDetail> sectorDetail = null;
    @JsonProperty("SectorDetailPrg")
    private List<SectorDetail> sectorDetailPrg = null;
    @JsonProperty("BookingsHistory")
    private List<BookingsHistory> bookingsHistory = null;
    @JsonProperty("bookingDetail")
    private BookingDetail bookingDetail;
    @JsonProperty("bookedHotel")
    private BookedHotel bookedHotel;
    @JsonProperty("roomDetail")
    private List<RoomDetail> roomDetail = null;
    @JsonProperty("BookingsNotes")
    private List<BookingsNote> bookingsNotes = null;
    @JsonProperty("FareDetail")
    private List<FareDetail> fareDetail = null;
    @JsonProperty("TravelMail")
    private List<TravelMail> traveloesMail = null;
    @JsonProperty("ancillary")
	private List<Ancillary> ancillary;
    @JsonProperty("isSaleShow")
    private boolean isSaleShow;
    @JsonProperty("isVcshow")
    private boolean isVcshow;
    
	@JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	@JsonProperty("isSaleShow")
    public boolean isSaleShow() {
		return isSaleShow;
	}
	@JsonProperty("isSaleShow")
	public void setSaleShow(boolean isSaleShow) {
		this.isSaleShow = isSaleShow;
	}
	@JsonProperty("isVcshow")
	public boolean isVcshow() {
		return isVcshow;
	}
	@JsonProperty("isVcshow")
	public void setVcshow(boolean isVcshow) {
		this.isVcshow = isVcshow;
	}

	@JsonProperty("TransactionsDetails")
    public TransactionsDetails getTransactionsDetails() {
        return transactionsDetails;
    }

    @JsonProperty("TransactionsDetails")
    public void setTransactionsDetails(TransactionsDetails transactionsDetails) {
        this.transactionsDetails = transactionsDetails;
    }

    @JsonProperty("PassengerDetails")
    public List<PassengerDetail> getPassengerDetails() {
        return passengerDetails;
    }

    @JsonProperty("PassengerDetails")
    public void setPassengerDetails(List<PassengerDetail> passengerDetails) {
        this.passengerDetails = passengerDetails;
    }

    @JsonProperty("SectorDetail")
    public List<SectorDetail> getSectorDetail() {
        return sectorDetail;
    }

    @JsonProperty("SectorDetail")
    public void setSectorDetail(List<SectorDetail> sectorDetail) {
        this.sectorDetail = sectorDetail;
    }

    @JsonProperty("BookingsHistory")
    public List<BookingsHistory> getBookingsHistory() {
        return bookingsHistory;
    }

    @JsonProperty("BookingsHistory")
    public void setBookingsHistory(List<BookingsHistory> bookingsHistory) {
        this.bookingsHistory = bookingsHistory;
    }

    @JsonProperty("bookingDetail")
    public BookingDetail getBookingDetail() {
        return bookingDetail;
    }

    @JsonProperty("bookingDetail")
    public void setBookingDetail(BookingDetail bookingDetail) {
        this.bookingDetail = bookingDetail;
    }

    @JsonProperty("bookedHotel")
    public BookedHotel getBookedHotel() {
        return bookedHotel;
    }

    @JsonProperty("bookedHotel")
    public void setBookedHotel(BookedHotel bookedHotel) {
        this.bookedHotel = bookedHotel;
    }

    @JsonProperty("roomDetail")
    public List<RoomDetail> getRoomDetail() {
        return roomDetail;
    }

    @JsonProperty("roomDetail")
    public void setRoomDetail(List<RoomDetail> roomDetail) {
        this.roomDetail = roomDetail;
    }

    @JsonProperty("BookingsNotes")
    public List<BookingsNote> getBookingsNotes() {
        return bookingsNotes;
    }

    @JsonProperty("BookingsNotes")
    public void setBookingsNotes(List<BookingsNote> bookingsNotes) {
        this.bookingsNotes = bookingsNotes;
    }

    @JsonProperty("FareDetail")
    public List<FareDetail> getFareDetail() {
        return fareDetail;
    }

    @JsonProperty("FareDetail")
    public void setFareDetail(List<FareDetail> fareDetail) {
        this.fareDetail = fareDetail;
    }

    @JsonProperty("TravelMail")
    public List<TravelMail> getTraveloesMail() {
        return traveloesMail;
    }

    @JsonProperty("TravelMail")
    public void setTraveloesMail(List<TravelMail> traveloesMail) {
        this.traveloesMail = traveloesMail;
    }

    @JsonProperty("ancillary")
	public List<Ancillary> getAncillary() {
		return ancillary;
	}
	
	@JsonProperty("ancillary")
	public void setAncillary(List<Ancillary> ancillary) {
		this.ancillary = ancillary;
	}
    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

	public String getSiteID() {
		return siteID;
	}

	public void setSiteID(String siteID) {
		this.siteID = siteID;
	}

	public String getInvoiceNum() {
		return invoiceNum;
	}

	public void setInvoiceNum(String invoiceNum) {
		this.invoiceNum = invoiceNum;
	}
	@JsonProperty("transDetail")
	public List<TransactionsDetails> getTransDetail() {
		return transDetail;
	}
	@JsonProperty("transDetail")
	public void setTransDetail(List<TransactionsDetails> transDetail) {
		this.transDetail = transDetail;
	}
	@JsonProperty("bookingDate")
	public Timestamp getBookingDate() {
		return bookingDate;
	}
	@JsonProperty("bookingDate")
	public void setBookingDate(Timestamp bookingDate) {
		this.bookingDate = bookingDate;
	}
    	 @JsonProperty("SectorDetailPrg")
	public List<SectorDetail> getSectorDetailPrg() {
		return sectorDetailPrg;
	}

	 @JsonProperty("SectorDetailPrg")
	public void setSectorDetailPrg(List<SectorDetail> sectorDetailPrg) {
		this.sectorDetailPrg = sectorDetailPrg;
	}

	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}
    
}
