package com.travel.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import com.travel.object.bookingrequest.BookingRequest;
import com.travel.object.liveresult.LiveResultResponse;
import com.travel.service.FlightService;
import com.travel.service.RestDataService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class FlightsLiveController
{
	@Autowired
	FlightService flightService;
	
	@Autowired
	MailController mailService;
	
	@Autowired
	RestDataService restService;
	
	@Value("${flightAPiUrl}")
	private String flightAPiUrl;
	
	@Value("${currency}")
	private String currency;

	@Value("${password}")
	private String password;
	@GetMapping("/flight/livelink/{searchId}/{resultId}/{star}/{comment}")
	public @ResponseBody String selectCustomerPage(@PathVariable String searchId,@PathVariable int resultId,@PathVariable int star,@PathVariable String comment,@ModelAttribute BookingRequest bookingRequest,Model model,HttpServletRequest request){
		bookingRequest.setBookingID(String.valueOf(resultId));
		bookingRequest.setSearchID(searchId);
		bookingRequest.setSourceMedia("flight");
		
		String apiUrls=flightAPiUrl+"/customerRequests?authcode="+password;
		System.out.println("apiUrls:"+apiUrls);
		RestTemplate restTemplate = new RestTemplate();
		String bookingRes= restTemplate.postForObject (apiUrls,bookingRequest,String.class);
		System.out.println("BookingRequest response : " + bookingRes);
		ObjectMapper mapper = new ObjectMapper();
		LiveResultResponse liveResponse = new LiveResultResponse();
		try
		{
			liveResponse = mapper.readValue(bookingRes, LiveResultResponse.class);
		} 
		catch(Exception e){
		e.printStackTrace();
		}
		
		for (int i = 0; i < liveResponse.getLiveflightResult().size(); i++) {
			if(liveResponse.getLiveflightResult().get(i).getResultID()==star){
			if(comment.equalsIgnoreCase("x")){
				if(liveResponse.getLiveflightResult().get(i).getConsId().equalsIgnoreCase("1")){
					System.out.println("inside");
					liveResponse.getLiveflightResult().get(i).setConsId("0");
				}else{
					liveResponse.getLiveflightResult().get(i).setConsId("1");
				}
				 
			}else{
				liveResponse.getLiveflightResult().get(i).setBookingToken(comment);
				
		}
			}
		}
		liveResponse.setBookingID(resultId);
		liveResponse.setSearchID(searchId);
		liveResponse.setSourceMedia("1");
		//liveResponse.setEmailID(emailID);
		try {
			System.out.println("get query:"+mapper.writeValueAsString(liveResponse));
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		 apiUrls=flightAPiUrl+"/CustomerLink?authcode="+password;  
		 bookingRes= restTemplate.postForObject (apiUrls,liveResponse,String.class);
		System.out.println("booking response : " + bookingRes);
	return "ok";	
	}
		
}
