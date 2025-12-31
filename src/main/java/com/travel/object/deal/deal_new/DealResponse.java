package com.travel.object.deal.deal_new;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DealResponse {

    @JsonProperty("fromCity")
    private String fromCity;

    @JsonProperty("toCity")
    private String toCity;

    @JsonProperty("departureDate")
    private String departureDate;

    @JsonProperty("departTime")
    private String departTime;

    @JsonProperty("arrivalDate")
    private String arrivalDate;

    @JsonProperty("arrivalTime")
    private String arrivalTime;

    @JsonProperty("stops")
    private int stops;

    @JsonProperty("price")
    private String price;

    @JsonProperty("airline")
    private String airline;

    @JsonProperty("airlineName")
    private String airlineName;

    @JsonProperty("cabinClass")
    private String cabinClass;

    @JsonProperty("searchDate")
    private String searchDate;

    @JsonProperty("tripType")
    private String tripType;
    
    @JsonProperty("froCityname")
    private String froCityname;

    @JsonProperty("toCityname")
    private String toCityname;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("id")
    private String id;

    @JsonProperty("domestic")
    private boolean domestic;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();
    
    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartTime() {
        return departTime;
    }

    public void setDepartTime(String departTime) {
        this.departTime = departTime;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getStops() {
        return stops;
    }

    public void setStops(int stops) {
        this.stops = stops;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getCabinClass() {
        return cabinClass;
    }

    public void setCabinClass(String cabinClass) {
        this.cabinClass = cabinClass;
    }

    public String getSearchDate() {
        return searchDate;
    }

    public void setSearchDate(String searchDate) {
        this.searchDate = searchDate;
    }

    public String getTripType() {
        return tripType;
    }

    public void setTripType(String tripType) {
        this.tripType = tripType;
    }

    public String getFroCityname() {
        return froCityname;
    }

    public void setFroCityname(String froCityname) {
        this.froCityname = froCityname;
    }

    public String getToCityname() {
        return toCityname;
    }

    public void setToCityname(String toCityname) {
        this.toCityname = toCityname;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isDomestic() {
        return domestic;
    }

    public void setDomestic(boolean domestic) {
        this.domestic = domestic;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
