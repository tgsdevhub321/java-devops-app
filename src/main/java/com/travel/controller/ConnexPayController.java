package com.travel.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.travel.object.bookingInfo.BookingDetail;
import com.travel.object.bookingInfo.BookingRequest;
import com.travel.object.flightresponse.Fare;
import com.travel.object.flightresponse.FlightResult;

@RestController
public class ConnexPayController
{
	@Value("${crmapiUrl}")
	private String crmapiUrl;
	@Value("${password}")
	private String password;
	//@Value("${STRIPE_SECRET_KEY}")
	//private String secretKey;
	
	@GetMapping("/flight/payments/connexpay/{bid}")
	public ModelAndView PaymentLinkPage(@PathVariable("bid") String bid, @ModelAttribute com.travel.object.bookingrequest.BookingRequest bookingRequest, HttpServletRequest request, Model model){
		ModelAndView mv = new ModelAndView("flights/payment-link/payment_3d");
		System.out.println(" TID Encrypted Value Is :: "+bid);
		String fulValue = bid;
		String cardPayType="";
		try
		{
			int lengths = fulValue.length();
			cardPayType = fulValue.substring(lengths-1);
			System.out.println("CardPayType"+cardPayType);
			fulValue = fulValue.substring(0,lengths-15);
			fulValue = fulValue.substring(7);
			System.out.println("FulValue::"+fulValue);
		}catch(Exception e){
			e.printStackTrace();
			fulValue="";
			cardPayType="";
		}

		String decriptedTID = fulValue;
		bookingRequest.setBookingID(decriptedTID);

		ObjectMapper mapper = new ObjectMapper();
		RestTemplate restTemplate = new RestTemplate();
		BookingDetail getObj = new BookingDetail();
		getObj.setBookingId(decriptedTID);
		
		try
		{
			System.out.println("Show Single Booking Request::-- "+mapper.writeValueAsString(getObj));
		}catch(Exception e){

		}

		String apiUrls=crmapiUrl+"/back-end/viewbooking?authcode="+password;
		String bookingList= restTemplate.postForObject (apiUrls, getObj, String.class);
		System.out.println("single bkg getting response :--"+bookingList);
		BookingRequest bookingResponse = new BookingRequest();
		try
		{
			bookingResponse = mapper.readValue(bookingList, BookingRequest.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		double baseFare = bookingResponse.getResponse().get(0).getFareDetail().get(0).getBaseFare();
		double totalTax = bookingResponse.getResponse().get(0).getFareDetail().get(0).getTotalTax();
		double adultMarkup = bookingResponse.getResponse().get(0).getFareDetail().get(0).getAdultMarkup();
		double childMarkup = bookingResponse.getResponse().get(0).getFareDetail().get(0).getChildMarkup();
		double infantMarkup = bookingResponse.getResponse().get(0).getFareDetail().get(0).getInfantMarkup();
		double infantWSMarkup = bookingResponse.getResponse().get(0).getFareDetail().get(0).getInfantWsMarkup();
		double anclryAmount = 0.00;
		int ansize = 0;
		try
		{
			ansize = bookingResponse.getResponse().get(0).getAncillary().size();
		}catch(Exception e){
			ansize = 0;
		}
		
		if(ansize>0){
			for (int j = 0; j < ansize; j++) {
				anclryAmount = anclryAmount+bookingResponse.getResponse().get(0).getAncillary().get(j).getPriceTypePax();
			}
		}
		double amtToPay = 0.00;
		if(cardPayType.equalsIgnoreCase("N")){
			amtToPay = baseFare+totalTax;
		}else if(cardPayType.equalsIgnoreCase("M")){
			amtToPay=adultMarkup+childMarkup+infantMarkup+infantWSMarkup;
		}else if(cardPayType.equalsIgnoreCase("G")){
			amtToPay=baseFare+totalTax+adultMarkup+childMarkup+infantMarkup+infantWSMarkup+anclryAmount;
		}

		FlightResult flightResultObj = new FlightResult();
		Fare fareObj = new Fare();
		fareObj.setGrandTotal(amtToPay);
		flightResultObj.setFare(fareObj);
		bookingRequest.setFlightResult(flightResultObj);
		mv.addObject("bookingRequest", bookingRequest);
		return mv;
	}
	
	
}
