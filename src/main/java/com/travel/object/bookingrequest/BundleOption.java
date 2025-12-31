package com.travel.object.bookingrequest;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "currency",
    "bundle_offer_id",
    "client_reference_id",
    "price",
    "booking_reference",
    "products",
    "passengers",
    "customer"
})

public class BundleOption {

	@JsonProperty("bundle_offer_id")
    private String bundleOfferId;
    @JsonProperty("bundle_type") //bundle or single
    private String bundleType;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("products")
    private List<String> products;

    
    @JsonProperty("bundle_offer_id")
    public String getBundleOfferId() {
        return bundleOfferId;
    }

    @JsonProperty("bundle_offer_id")
    public void setBundleOfferId(String bundleOfferId) {
        this.bundleOfferId = bundleOfferId;
    }

    @JsonProperty("price")
    public Double getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(Double price) {
        this.price = price;
    }

    @JsonProperty("products")
    public List<String> getProducts() {
        return products;
    }

    @JsonProperty("products")
    public void setProducts(List<String> products) {
        this.products = products;
    }
    @JsonProperty("bundle_type")
	public String getBundleType() {
		return bundleType;
	}
    @JsonProperty("bundle_type")
	public void setBundleType(String bundleType) {
		this.bundleType = bundleType;
	}
}
