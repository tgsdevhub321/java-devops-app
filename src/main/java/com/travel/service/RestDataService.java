package com.travel.service;

import java.util.List;
import com.travel.object.farealert.FareAlertRequest;

public interface RestDataService {

	public List<String> getAirportList(String searchterm);
	public List<String> getCityList(String searchterm);
	public void setNewsletterSubscription(String email);
	public void setFareAlert(FareAlertRequest farealAlertRequest);
	public String getCountryCode(String airportCode);
}
