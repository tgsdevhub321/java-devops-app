package com.travel.bean;

public class GenericDealRequest {

    private String[] filters;
    private String limit;
    private String currency;

    public GenericDealRequest() {
    }

    public GenericDealRequest(String[] filters, String limit, String currency) {
        this.filters = filters;
        this.limit = limit;
        this.currency = currency;
    }

    public String[] getFilters() {
        return filters;
    }

    public void setFilters(String[] filters) {
        this.filters = filters;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String string) {
        this.limit = string;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

}
