
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
    "roomid",
    "hotelBookid",
    "fareId",
    "rateKey",
    "bedTypeId",
    "bedDescription",
    "cancellationPolicy",
    "nonRefundable",
    "roomType",
    "boardCode",
    "boardFullName",
    "paymentType",
    "roomTitle"
})
public class RoomDetail {

    @JsonProperty("roomid")
    private Integer roomid;
    @JsonProperty("hotelBookid")
    private Integer hotelBookid;
    @JsonProperty("fareId")
    private Integer fareId;
    @JsonProperty("rateKey")
    private String rateKey;
    @JsonProperty("bedTypeId")
    private String bedTypeId;
    @JsonProperty("bedDescription")
    private String bedDescription;
    @JsonProperty("cancellationPolicy")
    private String cancellationPolicy;
    @JsonProperty("nonRefundable")
    private String nonRefundable;
    @JsonProperty("roomType")
    private String roomType;
    @JsonProperty("boardCode")
    private String boardCode;
    @JsonProperty("boardFullName")
    private String boardFullName;
    @JsonProperty("paymentType")
    private String paymentType;
    @JsonProperty("roomTitle")
    private String roomTitle;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("roomid")
    public Integer getRoomid() {
        return roomid;
    }

    @JsonProperty("roomid")
    public void setRoomid(Integer roomid) {
        this.roomid = roomid;
    }

    @JsonProperty("hotelBookid")
    public Integer getHotelBookid() {
        return hotelBookid;
    }

    @JsonProperty("hotelBookid")
    public void setHotelBookid(Integer hotelBookid) {
        this.hotelBookid = hotelBookid;
    }

    @JsonProperty("fareId")
    public Integer getFareId() {
        return fareId;
    }

    @JsonProperty("fareId")
    public void setFareId(Integer fareId) {
        this.fareId = fareId;
    }

    @JsonProperty("rateKey")
    public String getRateKey() {
        return rateKey;
    }

    @JsonProperty("rateKey")
    public void setRateKey(String rateKey) {
        this.rateKey = rateKey;
    }

    @JsonProperty("bedTypeId")
    public String getBedTypeId() {
        return bedTypeId;
    }

    @JsonProperty("bedTypeId")
    public void setBedTypeId(String bedTypeId) {
        this.bedTypeId = bedTypeId;
    }

    @JsonProperty("bedDescription")
    public String getBedDescription() {
        return bedDescription;
    }

    @JsonProperty("bedDescription")
    public void setBedDescription(String bedDescription) {
        this.bedDescription = bedDescription;
    }

    @JsonProperty("cancellationPolicy")
    public String getCancellationPolicy() {
        return cancellationPolicy;
    }

    @JsonProperty("cancellationPolicy")
    public void setCancellationPolicy(String cancellationPolicy) {
        this.cancellationPolicy = cancellationPolicy;
    }

    @JsonProperty("nonRefundable")
    public String getNonRefundable() {
        return nonRefundable;
    }

    @JsonProperty("nonRefundable")
    public void setNonRefundable(String nonRefundable) {
        this.nonRefundable = nonRefundable;
    }

    @JsonProperty("roomType")
    public String getRoomType() {
        return roomType;
    }

    @JsonProperty("roomType")
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    @JsonProperty("boardCode")
    public String getBoardCode() {
        return boardCode;
    }

    @JsonProperty("boardCode")
    public void setBoardCode(String boardCode) {
        this.boardCode = boardCode;
    }

    @JsonProperty("boardFullName")
    public String getBoardFullName() {
        return boardFullName;
    }

    @JsonProperty("boardFullName")
    public void setBoardFullName(String boardFullName) {
        this.boardFullName = boardFullName;
    }

    @JsonProperty("paymentType")
    public String getPaymentType() {
        return paymentType;
    }

    @JsonProperty("paymentType")
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    @JsonProperty("roomTitle")
    public String getRoomTitle() {
        return roomTitle;
    }

    @JsonProperty("roomTitle")
    public void setRoomTitle(String roomTitle) {
        this.roomTitle = roomTitle;
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
