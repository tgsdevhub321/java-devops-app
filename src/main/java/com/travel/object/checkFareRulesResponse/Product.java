
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
    "category",
    "id",
    "name",
    "pricing_type",
    "pricing",
    "bundled_pricing",
    "price",
    "bundled_price",
    "icon_url",	
    "images",
    "description",
    "short_description",
    "quantity",
    "age_categories",
    "cancellation_policy",
    "refundable_until"
})

public class Product {

    @JsonProperty("category")
    private String category;
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("pricing_type")
    private String pricingType;
    @JsonProperty("pricing")
    private Pricing pricing;
    @JsonProperty("bundled_pricing")
    private BundledPricing bundledPricing;
    @JsonProperty("price")
    private String price;
    @JsonProperty("bundled_price")
    private String bundledPrice;
    @JsonProperty("icon_url")
    private String iconUrl;
    @JsonProperty("images")
    private List<Image> images;
    @JsonProperty("description")
    private String description;
    @JsonProperty("short_description")
    private String shortDescription;
    @JsonProperty("quantity")
    private Integer quantity;
    @JsonProperty("age_categories")
    private List<String> ageCategories;
    @JsonProperty("cancellation_policy")
    private String cancellationPolicy;
    @JsonProperty("refundable_until")
    private String refundableUntil;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("category")
    public String getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(String category) {
        this.category = category;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("pricing_type")
    public String getPricingType() {
        return pricingType;
    }

    @JsonProperty("pricing_type")
    public void setPricingType(String pricingType) {
        this.pricingType = pricingType;
    }

    @JsonProperty("pricing")
    public Pricing getPricing() {
        return pricing;
    }

    @JsonProperty("pricing")
    public void setPricing(Pricing pricing) {
        this.pricing = pricing;
    }

    @JsonProperty("bundled_pricing")
    public BundledPricing getBundledPricing() {
        return bundledPricing;
    }

    @JsonProperty("bundled_pricing")
    public void setBundledPricing(BundledPricing bundledPricing) {
        this.bundledPricing = bundledPricing;
    }

    @JsonProperty("price")
    public String getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(String price) {
        this.price = price;
    }

    @JsonProperty("bundled_price")
    public String getBundledPrice() {
        return bundledPrice;
    }

    @JsonProperty("bundled_price")
    public void setBundledPrice(String bundledPrice) {
        this.bundledPrice = bundledPrice;
    }

    @JsonProperty("icon_url")
    public String getIconUrl() {
        return iconUrl;
    }

    @JsonProperty("icon_url")
    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    @JsonProperty("images")
    public List<Image> getImages() {
        return images;
    }

    @JsonProperty("images")
    public void setImages(List<Image> images) {
        this.images = images;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("short_description")
    public String getShortDescription() {
        return shortDescription;
    }

    @JsonProperty("short_description")
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    @JsonProperty("quantity")
    public Integer getQuantity() {
        return quantity;
    }

    @JsonProperty("quantity")
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @JsonProperty("age_categories")
    public List<String> getAgeCategories() {
        return ageCategories;
    }

    @JsonProperty("age_categories")
    public void setAgeCategories(List<String> ageCategories) {
        this.ageCategories = ageCategories;
    }

    @JsonProperty("cancellation_policy")
    public String getCancellationPolicy() {
        return cancellationPolicy;
    }

    @JsonProperty("cancellation_policy")
    public void setCancellationPolicy(String cancellationPolicy) {
        this.cancellationPolicy = cancellationPolicy;
    }

    @JsonProperty("refundable_until")
    public String getRefundableUntil() {
        return refundableUntil;
    }

    @JsonProperty("refundable_until")
    public void setRefundableUntil(String refundableUntil) {
        this.refundableUntil = refundableUntil;
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
