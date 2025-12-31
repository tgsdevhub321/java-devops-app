package com.travel.object.flightresponse;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"id",
	"airline",
	"from_country",
	"to_country",
	"cabin",
	"carryOnBag",
	"carryOnBagDet",
	"checkedBagF",
	"checkedBagFirst",
	"checkedBagS",
	"checkedBagSecond",
	"weightperKg",
	"personalItem",
	"carryOn",
	"checkedBag",
	"fareType",
	"isActive"
})
@Generated("jsonschema2pojo")
public class BaggageInformation {

	@JsonProperty("id")
	private Integer id;
	@JsonProperty("airline")
	private String airline;
	@JsonProperty("from_country")
	private String fromCountry;
	@JsonProperty("to_country")
	private String toCountry;
	@JsonProperty("cabin")
	private String cabin;
	@JsonProperty("carryOnBag")
	private String carryOnBag;
	@JsonProperty("carryOnBagDet")
	private String carryOnBagDet;
	@JsonProperty("checkedBagF")
	private String checkedBagF;
	@JsonProperty("checkedBagFirst")
	private String checkedBagFirst;
	@JsonProperty("checkedBagS")
	private String checkedBagS;
	@JsonProperty("checkedBagSecond")
	private String checkedBagSecond;
	@JsonProperty("weightperKg")
	private String weightperKg;
	@JsonProperty("personalItem")
	private String personalItem;
	@JsonProperty("carryOn")
	private String carryOn;
	@JsonProperty("checkedBag")
	private String checkedBag;
	@JsonProperty("fareType")
	private String fareType;
	@JsonProperty("isActive")
	private String isActive;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}

	@JsonProperty("airline")
	public String getAirline() {
		return airline;
	}

	@JsonProperty("airline")
	public void setAirline(String airline) {
		this.airline = airline;
	}

	@JsonProperty("from_country")
	public String getFromCountry() {
		return fromCountry;
	}

	@JsonProperty("from_country")
	public void setFromCountry(String fromCountry) {
		this.fromCountry = fromCountry;
	}

	@JsonProperty("to_country")
	public String getToCountry() {
		return toCountry;
	}

	@JsonProperty("to_country")
	public void setToCountry(String toCountry) {
		this.toCountry = toCountry;
	}

	@JsonProperty("cabin")
	public String getCabin() {
		return cabin;
	}

	@JsonProperty("cabin")
	public void setCabin(String cabin) {
		this.cabin = cabin;
	}

	@JsonProperty("carryOnBag")
	public String getCarryOnBag() {
		return carryOnBag;
	}

	@JsonProperty("carryOnBag")
	public void setCarryOnBag(String carryOnBag) {
		this.carryOnBag = carryOnBag;
	}

	@JsonProperty("carryOnBagDet")
	public String getCarryOnBagDet() {
		return carryOnBagDet;
	}

	@JsonProperty("carryOnBagDet")
	public void setCarryOnBagDet(String carryOnBagDet) {
		this.carryOnBagDet = carryOnBagDet;
	}

	@JsonProperty("checkedBagF")
	public String getCheckedBagF() {
		return checkedBagF;
	}

	@JsonProperty("checkedBagF")
	public void setCheckedBagF(String checkedBagF) {
		this.checkedBagF = checkedBagF;
	}

	@JsonProperty("checkedBagFirst")
	public String getCheckedBagFirst() {
		return checkedBagFirst;
	}

	@JsonProperty("checkedBagFirst")
	public void setCheckedBagFirst(String checkedBagFirst) {
		this.checkedBagFirst = checkedBagFirst;
	}

	@JsonProperty("checkedBagS")
	public String getCheckedBagS() {
		return checkedBagS;
	}

	@JsonProperty("checkedBagS")
	public void setCheckedBagS(String checkedBagS) {
		this.checkedBagS = checkedBagS;
	}

	@JsonProperty("checkedBagSecond")
	public String getCheckedBagSecond() {
		return checkedBagSecond;
	}

	@JsonProperty("checkedBagSecond")
	public void setCheckedBagSecond(String checkedBagSecond) {
		this.checkedBagSecond = checkedBagSecond;
	}

	@JsonProperty("weightperKg")
	public String getWeightperKg() {
		return weightperKg;
	}

	@JsonProperty("weightperKg")
	public void setWeightperKg(String weightperKg) {
		this.weightperKg = weightperKg;
	}

	@JsonProperty("personalItem")
	public String getPersonalItem() {
		return personalItem;
	}

	@JsonProperty("personalItem")
	public void setPersonalItem(String personalItem) {
		this.personalItem = personalItem;
	}

	@JsonProperty("carryOn")
	public String getCarryOn() {
		return carryOn;
	}

	@JsonProperty("carryOn")
	public void setCarryOn(String carryOn) {
		this.carryOn = carryOn;
	}

	@JsonProperty("checkedBag")
	public String getCheckedBag() {
		return checkedBag;
	}

	@JsonProperty("checkedBag")
	public void setCheckedBag(String checkedBag) {
		this.checkedBag = checkedBag;
	}

	@JsonProperty("fareType")
	public String getFareType() {
		return fareType;
	}

	@JsonProperty("fareType")
	public void setFareType(String fareType) {
		this.fareType = fareType;
	}

	@JsonProperty("isActive")
	public String getIsActive() {
		return isActive;
	}

	@JsonProperty("isActive")
	public void setIsActive(String isActive) {
		this.isActive = isActive;
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