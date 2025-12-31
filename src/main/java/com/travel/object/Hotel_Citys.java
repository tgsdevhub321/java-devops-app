
package com.travel.object;

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
    "code", // cityId
    "name", // City Name
    "type", // as a Hotel
    "isHotel", // Status - 1
    "countryCode"
})
public class Hotel_Citys {

    @JsonProperty("code")
    private String code;
    @JsonProperty("name")
    private String name;
    @JsonProperty("type")
    private String type;
    @JsonProperty("isHotel")
    private int isHotel;
   
    @JsonProperty("countryCode")
    private String countryCode;
    
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    
    @JsonProperty("code")
    public String getCode() {
		return code;
	}
    @JsonProperty("code")
	public void setCode(String code) {
		this.code = code;
	}

    @JsonProperty("name")
	public String getName() {
		return name;
	}
    @JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}
    @JsonProperty("type")
	public String getType() {
		return type;
	}
    @JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}
    @JsonProperty("isHotel")
	public int getIsHotel() {
		return isHotel;
	}
    @JsonProperty("isHotel")
	public void setIsHotel(int isHotel) {
		this.isHotel = isHotel;
	}

	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

	@JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

}
