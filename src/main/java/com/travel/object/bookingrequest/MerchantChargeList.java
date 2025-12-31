package com.travel.object.bookingrequest;

import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "bookingId",
    "merchantName",
    "amount",
    "cardNumber"
})

public class MerchantChargeList {
	
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("bookingId")
    private Integer bookingId;
    @JsonProperty("merchantName")
    private String merchantName;
    @JsonProperty("amount")
    private String amount;
    @JsonProperty("cardNumber")
    private String cardNumber;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();
    
    @JsonProperty("cardNumber")
    public String getCardNumber() {
		return cardNumber;
	}
    
    @JsonProperty("cardNumber")
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
    
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("bookingId")
    public Integer getBookingId() {
        return bookingId;
    }

    @JsonProperty("bookingId")
    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    @JsonProperty("merchantName")
    public String getMerchantName() {
        return merchantName;
    }

    @JsonProperty("merchantName")
    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    @JsonProperty("amount")
    public String getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(String amount) {
        this.amount = amount;
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

