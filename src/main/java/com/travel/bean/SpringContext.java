package com.travel.bean;

public class SpringContext
{	
	private String apiUrl;
	private String currency;
	private String address;
	private String tfnNumber; 
	private String domain ;
	private String domainName;
	private String copyRight; 
	private int siteId;
	private String flightLink ;
	private String password;
	
	public SpringContext(){

	}
	
	public SpringContext(String apiUrl){ 
		this.apiUrl=apiUrl;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFlightLink() {
		return flightLink;
	}

	public void setFlightLink(String flightLink) {
		this.flightLink = flightLink;
	}
	
	/**
	 * @return the apiUrl
	 */
	public String getApiUrl() {
		return apiUrl;
	}

	/**
	 * @param apiUrl the apiUrl to set
	 */
	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTfnNumber() {
		return tfnNumber;
	}

	public void setTfnNumber(String tfnNumber) {
		this.tfnNumber = tfnNumber;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}
	
	public String getCopyRight() {
		return copyRight;
	}

	public void setCopyRight(String copyRight) {
		this.copyRight = copyRight;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public int getSiteId() {
		return siteId;
	}

	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}

}
