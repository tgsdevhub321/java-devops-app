package com.travel.service.impl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.travel.object.Hotel_Citys;
import com.travel.object.Location;
import com.travel.object.SubscribeRequest;
import com.travel.object.farealert.FareAlertRequest;
import com.travel.service.RestDataService;

@Service
public class RestDataServiceImpl implements RestDataService{

	@Value("${flightAPiUrl}")
	String flightAPiUrl;
	
	@Value("${siteName}")
	private String siteName;
	
	@Value("${siteId}")
	private int siteId;
	
	@Value("${apiUrl}")
	String apiUrl;
	
	@Value("${password}")
	private String password;
	
	RestTemplate rest = new RestTemplate();
	ObjectMapper mapper = new ObjectMapper(); 
	
	@Override
	public List<String> getAirportList(String searchterm) {
		
		String url=flightAPiUrl+"/AirportList?authcode="+password.trim()+"&data="+searchterm;
		System.out.println("RestDataServiceImpl:: "+url);
		String airporStr = rest.getForObject(url, String.class);
		System.out.println("airporStr:: "+airporStr);
		List<String> airportList = new ArrayList<String>();
		try 
		{
			Location[] locationList =  mapper.readValue(airporStr, Location[].class);
			System.out.println("RestDataServiceImpl::locationList :: "+locationList.length);
			for (Location location : locationList) {
				//System.out.println(location.getAirportCode());
				//if (searchterm.equalsIgnoreCase(location.getAirportCode())) {
					airportList.add(location.getAirportCode()+"-"+location.getCityName()+", "+location.getAirportName()+"-"+location.getCountryCode());
				//}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return airportList;
	}
	
	@Override
	public List<String> getCityList(String searchterm) {
		
		System.out.println("search City Name --- "+ searchterm);
		String url="https://tgsapi.com/HotelEngine/Service/hotelCity?authcode="+password+"&data="+searchterm;
		System.out.println("RestDataServiceImpl:: "+url);
		String cityStr = rest.getForObject(url, String.class);
		System.out.println("cityStr:: "+cityStr);
		List<String> cityList = new ArrayList<String>();
		try 
		{
			Hotel_Citys[] hotelCityList =  mapper.readValue(cityStr, Hotel_Citys[].class);
			System.out.println("RestDataServiceImpl::HotelCityList :: "+hotelCityList.length);
			for (Hotel_Citys hotelCitys : hotelCityList) {
				//System.out.println(location.getAirportCode());
				
				/*if (searchterm.equalsIgnoreCase(hotelCitys.getCode())) {
					cityList.add(hotelCitys.getCode()+"-"+hotelCitys.getName()+"-"+hotelCitys.getCountryCode());
				}*/
				
				cityList.add(hotelCitys.getCode()+"-"+hotelCitys.getName()+"-"+hotelCitys.getCountryCode());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cityList;
	}
	
	@Override
	public String getCountryCode(String airportName){
		
		String url=flightAPiUrl+"/AirportList?authcode="+password.trim()+"&data="+airportName;
		System.out.println("RestDataServiceImpl::GetCountryCode::"+url);
		String airporStr = rest.getForObject(url, String.class);
		String countryCode = "";
		try 
		{
			Location[] locationList =  mapper.readValue(airporStr, Location[].class);
			//System.out.println("RestDataServiceImpl::locationList :: "+locationList.length);
			for (Location location : locationList) {
				//System.out.println(location.getAirportCode());
				if (airportName.equalsIgnoreCase(location.getAirportCode())) {
					countryCode = location.getCountryCode();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return countryCode;
	}
	
	
	
	
	@Override
	public void setNewsletterSubscription(String email) {
		System.out.println("email1111"+email);
		Date d = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = format.format(d);
		SubscribeRequest reqObj=new SubscribeRequest();
		reqObj.setDate(dateString);
		reqObj.setEmailid(email);
		reqObj.setStatus("active");
		reqObj.setSiteId(siteId);
		reqObj.setUrl(siteName);
		
		String response = rest.postForObject(apiUrl+"/backend/subscribe?authcode=ebooktrip",reqObj,String.class);
		System.out.println("subscribe response"+response);
	}

	@Override
	public void setFareAlert(FareAlertRequest farealAlertRequest) {
	String res = 	rest.postForObject(apiUrl+"/fare-alert/addFareAlert?authcode=ebooktrip", farealAlertRequest, String.class);
	System.out.println(res);
		
	}

}
