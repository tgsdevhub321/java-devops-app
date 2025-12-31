package com.travel.object.checkFareRulesResponse;

import java.util.LinkedHashMap;
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
    "id",
    "currency",
    "fee",
    "passengers_count",	
    "products",
    "expires_at",
    "terms_url"
})

public class BundleOffer {

    @JsonProperty("id")
    private String id;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("fee")
    private Fee fee;
    @JsonProperty("passengers_count")
    private Integer passengersCount;
    @JsonProperty("products")
    private List<Product> products;
    @JsonProperty("expires_at")
    private String expiresAt;
    @JsonProperty("terms_url")
    private String termsUrl;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("fee")
    public Fee getFee() {
        return fee;
    }

    @JsonProperty("fee")
    public void setFee(Fee fee) {
        this.fee = fee;
    }

    @JsonProperty("passengers_count")
    public Integer getPassengersCount() {
        return passengersCount;
    }

    @JsonProperty("passengers_count")
    public void setPassengersCount(Integer passengersCount) {
        this.passengersCount = passengersCount;
    }

    @JsonProperty("products")
    public List<Product> getProducts() {
        return products;
    }

    @JsonProperty("products")
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @JsonProperty("expires_at")
    public String getExpiresAt() {
        return expiresAt;
    }

    @JsonProperty("expires_at")
    public void setExpiresAt(String expiresAt) {
        this.expiresAt = expiresAt;
    }

    @JsonProperty("terms_url")
    public String getTermsUrl() {
        return termsUrl;
    }

    @JsonProperty("terms_url")
    public void setTermsUrl(String termsUrl) {
        this.termsUrl = termsUrl;
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
