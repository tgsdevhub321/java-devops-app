
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
    "hotelBookid",
    "bookingId",
    "hotelSupplier",
    "hotelId",
    "apiHotelId",
    "bookingToken",
    "hotelName",
    "completeAddress",
    "checkIn",
    "checkOut",
    "totalRoom",
    "totalNight"
})
public class BookedHotel {

    @JsonProperty("hotelBookid")
    private Integer hotelBookid;
    @JsonProperty("bookingId")
    private Integer bookingId;
    @JsonProperty("hotelSupplier")
    private String hotelSupplier;
    @JsonProperty("hotelId")
    private String hotelId;
    @JsonProperty("apiHotelId")
    private String apiHotelId;
    @JsonProperty("bookingToken")
    private String bookingToken;
    @JsonProperty("hotelName")
    private String hotelName;
    @JsonProperty("completeAddress")
    private String completeAddress;
    @JsonProperty("checkIn")
    private Timestamp checkIn;
    @JsonProperty("checkOut")
    private Timestamp checkOut;
    @JsonProperty("totalRoom")
    private Integer totalRoom;
    @JsonProperty("totalNight")
    private Integer totalNight;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("hotelBookid")
    public Integer getHotelBookid() {
        return hotelBookid;
    }

    @JsonProperty("hotelBookid")
    public void setHotelBookid(Integer hotelBookid) {
        this.hotelBookid = hotelBookid;
    }

    @JsonProperty("bookingId")
    public Integer getBookingId() {
        return bookingId;
    }

    @JsonProperty("bookingId")
    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    @JsonProperty("hotelSupplier")
    public String getHotelSupplier() {
        return hotelSupplier;
    }

    @JsonProperty("hotelSupplier")
    public void setHotelSupplier(String hotelSupplier) {
        this.hotelSupplier = hotelSupplier;
    }

    @JsonProperty("hotelId")
    public String getHotelId() {
        return hotelId;
    }

    @JsonProperty("hotelId")
    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    @JsonProperty("apiHotelId")
    public String getApiHotelId() {
        return apiHotelId;
    }

    @JsonProperty("apiHotelId")
    public void setApiHotelId(String apiHotelId) {
        this.apiHotelId = apiHotelId;
    }

    @JsonProperty("bookingToken")
    public String getBookingToken() {
        return bookingToken;
    }

    @JsonProperty("bookingToken")
    public void setBookingToken(String bookingToken) {
        this.bookingToken = bookingToken;
    }

    @JsonProperty("hotelName")
    public String getHotelName() {
        return hotelName;
    }

    @JsonProperty("hotelName")
    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    @JsonProperty("completeAddress")
    public String getCompleteAddress() {
        return completeAddress;
    }

    @JsonProperty("completeAddress")
    public void setCompleteAddress(String completeAddress) {
        this.completeAddress = completeAddress;
    }

    @JsonProperty("checkIn")
    public Timestamp getCheckIn() {
        return checkIn;
    }

    @JsonProperty("checkIn")
    public void setCheckIn(Timestamp checkIn) {
        this.checkIn = checkIn;
    }

    @JsonProperty("checkOut")
    public Timestamp getCheckOut() {
        return checkOut;
    }

    @JsonProperty("checkOut")
    public void setCheckOut(Timestamp checkOut) {
        this.checkOut = checkOut;
    }

    @JsonProperty("totalRoom")
    public Integer getTotalRoom() {
        return totalRoom;
    }

    @JsonProperty("totalRoom")
    public void setTotalRoom(Integer totalRoom) {
        this.totalRoom = totalRoom;
    }

    @JsonProperty("totalNight")
    public Integer getTotalNight() {
        return totalNight;
    }

    @JsonProperty("totalNight")
    public void setTotalNight(Integer totalNight) {
        this.totalNight = totalNight;
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
