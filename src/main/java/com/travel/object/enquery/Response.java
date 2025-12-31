package com.travel.object.enquery;

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
    "agentId",
    "qsource",
    "qtype",
    "pnr",
    "airline",
    "paxName",
    "queryDate",
    "noPax",
    "sellingPrice",
    "buyingCost",
    "contactNo",
    "emailId",
    "dateOfTravel",
    "queryRat",
    "siteId",
    "supplier",
    "queryStatus"
})

public class Response {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("agentId")
    private Integer agentId;
    @JsonProperty("qsource")
    private String qsource;
    @JsonProperty("qtype")
    private String qtype;
    @JsonProperty("pnr")
    private String pnr;
    @JsonProperty("airline")
    private String airline;
    @JsonProperty("paxName")
    private String paxName;
    @JsonProperty("queryDate")
    private Long queryDate;
    @JsonProperty("noPax")
    private Integer noPax;
    @JsonProperty("sellingPrice")
    private Double sellingPrice;
    @JsonProperty("buyingCost")
    private Double buyingCost;
    @JsonProperty("contactNo")
    private String contactNo;
    @JsonProperty("emailId")
    private String emailId;
    @JsonProperty("dateOfTravel")
    private Long dateOfTravel;
    @JsonProperty("queryRat")
    private Integer queryRat;
    @JsonProperty("siteId")
    private Integer siteId;
    @JsonProperty("supplier")
    private String supplier;
    @JsonProperty("queryStatus")
    private String queryStatus;
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

    @JsonProperty("agentId")
    public Integer getAgentId() {
        return agentId;
    }

    @JsonProperty("agentId")
    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    @JsonProperty("qsource")
    public String getQsource() {
        return qsource;
    }

    @JsonProperty("qsource")
    public void setQsource(String qsource) {
        this.qsource = qsource;
    }

    @JsonProperty("qtype")
    public String getQtype() {
        return qtype;
    }

    @JsonProperty("qtype")
    public void setQtype(String qtype) {
        this.qtype = qtype;
    }

    @JsonProperty("pnr")
    public String getPnr() {
        return pnr;
    }

    @JsonProperty("pnr")
    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    @JsonProperty("airline")
    public String getAirline() {
        return airline;
    }

    @JsonProperty("airline")
    public void setAirline(String airline) {
        this.airline = airline;
    }

    @JsonProperty("paxName")
    public String getPaxName() {
        return paxName;
    }

    @JsonProperty("paxName")
    public void setPaxName(String paxName) {
        this.paxName = paxName;
    }

    @JsonProperty("queryDate")
    public Long getQueryDate() {
        return queryDate;
    }

    @JsonProperty("queryDate")
    public void setQueryDate(Long queryDate) {
        this.queryDate = queryDate;
    }

    @JsonProperty("noPax")
    public Integer getNoPax() {
        return noPax;
    }

    @JsonProperty("noPax")
    public void setNoPax(Integer noPax) {
        this.noPax = noPax;
    }

    @JsonProperty("sellingPrice")
    public Double getSellingPrice() {
        return sellingPrice;
    }

    @JsonProperty("sellingPrice")
    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    @JsonProperty("buyingCost")
    public Double getBuyingCost() {
        return buyingCost;
    }

    @JsonProperty("buyingCost")
    public void setBuyingCost(Double buyingCost) {
        this.buyingCost = buyingCost;
    }

    @JsonProperty("contactNo")
    public String getContactNo() {
        return contactNo;
    }

    @JsonProperty("contactNo")
    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    @JsonProperty("emailId")
    public String getEmailId() {
        return emailId;
    }

    @JsonProperty("emailId")
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @JsonProperty("dateOfTravel")
    public Long getDateOfTravel() {
        return dateOfTravel;
    }

    @JsonProperty("dateOfTravel")
    public void setDateOfTravel(Long dateOfTravel) {
        this.dateOfTravel = dateOfTravel;
    }

    @JsonProperty("queryRat")
    public Integer getQueryRat() {
        return queryRat;
    }

    @JsonProperty("queryRat")
    public void setQueryRat(Integer queryRat) {
        this.queryRat = queryRat;
    }

    @JsonProperty("siteId")
    public Integer getSiteId() {
        return siteId;
    }

    @JsonProperty("siteId")
    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    @JsonProperty("supplier")
    public String getSupplier() {
        return supplier;
    }

    @JsonProperty("supplier")
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    @JsonProperty("queryStatus")
    public String getQueryStatus() {
        return queryStatus;
    }

    @JsonProperty("queryStatus")
    public void setQueryStatus(String queryStatus) {
        this.queryStatus = queryStatus;
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
