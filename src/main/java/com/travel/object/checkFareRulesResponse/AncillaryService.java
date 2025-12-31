
package com.travel.object.checkFareRulesResponse;

import java.util.LinkedHashMap;
import java.util.List;
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
    "supplierCode",
    "supplierApi",
    "modelType",
    "priceTypeRoute",
    "priceTypePax",
    "fullName",
    "shortName",
    "fareLadderText",
    "title",
    "titleImgRight",
    "description",
    "bttomDescription",
    "services",
    "owServiceText",
    "disclosureslink",
    "disclosuresMessage",
    "titleImgLeft",
    "subTitle",
    "yesMessage"
})
@Generated("jsonschema2pojo")
public class AncillaryService {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("supplierCode")
    private String supplierCode;
    @JsonProperty("supplierApi")
    private String supplierApi;
    @JsonProperty("modelType")
    private String modelType;
    @JsonProperty("priceTypeRoute")
    private String priceTypeRoute;
    @JsonProperty("priceTypePax")
    private String priceTypePax;
    @JsonProperty("fullName")
    private String fullName;
    @JsonProperty("shortName")
    private String shortName;
    @JsonProperty("fareLadderText")
    private String fareLadderText;
    @JsonProperty("title")
    private String title;
    @JsonProperty("titleImgRight")
    private String titleImgRight;
    @JsonProperty("description")
    private String description;
    @JsonProperty("bttomDescription")
    private String bttomDescription;
    @JsonProperty("services")
    private List<Service> services;
    @JsonProperty("owServiceText")
    private List<OwServiceText> owServiceText;
    @JsonProperty("disclosureslink")
    private String disclosureslink;
    @JsonProperty("disclosuresMessage")
    private String disclosuresMessage;
    @JsonProperty("titleImgLeft")
    private String titleImgLeft;
    @JsonProperty("subTitle")
    private String subTitle;
    @JsonProperty("yesMessage")
    private String yesMessage;
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

    @JsonProperty("supplierCode")
    public String getSupplierCode() {
        return supplierCode;
    }

    @JsonProperty("supplierCode")
    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    @JsonProperty("supplierApi")
    public String getSupplierApi() {
        return supplierApi;
    }

    @JsonProperty("supplierApi")
    public void setSupplierApi(String supplierApi) {
        this.supplierApi = supplierApi;
    }

    @JsonProperty("modelType")
    public String getModelType() {
        return modelType;
    }

    @JsonProperty("modelType")
    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

    @JsonProperty("priceTypeRoute")
    public String getPriceTypeRoute() {
        return priceTypeRoute;
    }

    @JsonProperty("priceTypeRoute")
    public void setPriceTypeRoute(String priceTypeRoute) {
        this.priceTypeRoute = priceTypeRoute;
    }

    @JsonProperty("priceTypePax")
    public String getPriceTypePax() {
        return priceTypePax;
    }

    @JsonProperty("priceTypePax")
    public void setPriceTypePax(String priceTypePax) {
        this.priceTypePax = priceTypePax;
    }

    @JsonProperty("fullName")
    public String getFullName() {
        return fullName;
    }

    @JsonProperty("fullName")
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @JsonProperty("shortName")
    public String getShortName() {
        return shortName;
    }

    @JsonProperty("shortName")
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @JsonProperty("fareLadderText")
    public String getFareLadderText() {
        return fareLadderText;
    }

    @JsonProperty("fareLadderText")
    public void setFareLadderText(String fareLadderText) {
        this.fareLadderText = fareLadderText;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("titleImgRight")
    public String getTitleImgRight() {
        return titleImgRight;
    }

    @JsonProperty("titleImgRight")
    public void setTitleImgRight(String titleImgRight) {
        this.titleImgRight = titleImgRight;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("bttomDescription")
    public String getBttomDescription() {
        return bttomDescription;
    }

    @JsonProperty("bttomDescription")
    public void setBttomDescription(String bttomDescription) {
        this.bttomDescription = bttomDescription;
    }

    @JsonProperty("services")
    public List<Service> getServices() {
        return services;
    }

    @JsonProperty("services")
    public void setServices(List<Service> services) {
        this.services = services;
    }

    @JsonProperty("owServiceText")
    public List<OwServiceText> getOwServiceText() {
        return owServiceText;
    }

    @JsonProperty("owServiceText")
    public void setOwServiceText(List<OwServiceText> owServiceText) {
        this.owServiceText = owServiceText;
    }

    @JsonProperty("disclosureslink")
    public String getDisclosureslink() {
        return disclosureslink;
    }

    @JsonProperty("disclosureslink")
    public void setDisclosureslink(String disclosureslink) {
        this.disclosureslink = disclosureslink;
    }

    @JsonProperty("disclosuresMessage")
    public String getDisclosuresMessage() {
        return disclosuresMessage;
    }

    @JsonProperty("disclosuresMessage")
    public void setDisclosuresMessage(String disclosuresMessage) {
        this.disclosuresMessage = disclosuresMessage;
    }

    @JsonProperty("titleImgLeft")
    public String getTitleImgLeft() {
        return titleImgLeft;
    }

    @JsonProperty("titleImgLeft")
    public void setTitleImgLeft(String titleImgLeft) {
        this.titleImgLeft = titleImgLeft;
    }

    @JsonProperty("subTitle")
    public String getSubTitle() {
        return subTitle;
    }

    @JsonProperty("subTitle")
    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    @JsonProperty("yesMessage")
    public String getYesMessage() {
        return yesMessage;
    }

    @JsonProperty("yesMessage")
    public void setYesMessage(String yesMessage) {
        this.yesMessage = yesMessage;
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
