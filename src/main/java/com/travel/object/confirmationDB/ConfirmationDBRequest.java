package com.travel.object.confirmationDB;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "referenceNum",
    "siteId"
})
	
public class ConfirmationDBRequest {
	
	@JsonProperty("referenceNum")
    private String referenceNum;
    @JsonProperty("siteId")
    private Integer siteId;
    
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public String getReferenceNum() {
		return referenceNum;
	}

	public void setReferenceNum(String referenceNum) {
		this.referenceNum = referenceNum;
	}

	public Integer getSiteId() {
		return siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}
    
    
}
