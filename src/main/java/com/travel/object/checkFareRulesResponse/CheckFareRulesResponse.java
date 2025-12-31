
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
    "flightChecked",
    "flightInvalid",
    "priceChange",
    "bagRecheckReq",
    "perPaxLuggageOptions",
    "responseStatus",
    "newPrice",
    "ancillaryServices",
    "bundleOffer"
})

public class CheckFareRulesResponse {

    @JsonProperty("flightChecked")
    private Boolean flightChecked;
    @JsonProperty("flightInvalid")
    private Boolean flightInvalid;
    @JsonProperty("priceChange")
    private Boolean priceChange;
    @JsonProperty("bagRecheckReq")
    private Boolean bagRecheckReq;
    @JsonProperty("perPaxLuggageOptions")
    private Boolean perPaxLuggageOptions;
    @JsonProperty("responseStatus")
    private ResponseStatus responseStatus;
    @JsonProperty("newPrice")
    private Double newPrice;
    @JsonProperty("ancillaryServices")
    private List<AncillaryService> ancillaryServices;
    @JsonProperty("bundleOffer")
    private BundleOffer bundleOffer;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("flightChecked")
    public Boolean getFlightChecked() {
        return flightChecked;
    }

    @JsonProperty("flightChecked")
    public void setFlightChecked(Boolean flightChecked) {
        this.flightChecked = flightChecked;
    }

    @JsonProperty("flightInvalid")
    public Boolean getFlightInvalid() {
        return flightInvalid;
    }

    @JsonProperty("flightInvalid")
    public void setFlightInvalid(Boolean flightInvalid) {
        this.flightInvalid = flightInvalid;
    }

    @JsonProperty("priceChange")
    public Boolean getPriceChange() {
        return priceChange;
    }

    @JsonProperty("priceChange")
    public void setPriceChange(Boolean priceChange) {
        this.priceChange = priceChange;
    }

    @JsonProperty("bagRecheckReq")
    public Boolean getBagRecheckReq() {
        return bagRecheckReq;
    }

    @JsonProperty("bagRecheckReq")
    public void setBagRecheckReq(Boolean bagRecheckReq) {
        this.bagRecheckReq = bagRecheckReq;
    }

    @JsonProperty("perPaxLuggageOptions")
    public Boolean getPerPaxLuggageOptions() {
        return perPaxLuggageOptions;
    }

    @JsonProperty("perPaxLuggageOptions")
    public void setPerPaxLuggageOptions(Boolean perPaxLuggageOptions) {
        this.perPaxLuggageOptions = perPaxLuggageOptions;
    }

    @JsonProperty("responseStatus")
    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    @JsonProperty("responseStatus")
    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    @JsonProperty("newPrice")
    public Double getNewPrice() {
        return newPrice;
    }

    @JsonProperty("newPrice")
    public void setNewPrice(Double newPrice) {
        this.newPrice = newPrice;
    }

    @JsonProperty("ancillaryServices")
    public List<AncillaryService> getAncillaryServices() {
        return ancillaryServices;
    }

    @JsonProperty("ancillaryServices")
    public void setAncillaryServices(List<AncillaryService> ancillaryServices) {
        this.ancillaryServices = ancillaryServices;
    }

    @JsonProperty("bundleOffer")
    public BundleOffer getBundleOffer() {
        return bundleOffer;
    }

    @JsonProperty("bundleOffer")
    public void setBundleOffer(BundleOffer bundleOffer) {
        this.bundleOffer = bundleOffer;
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
