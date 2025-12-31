package com.travel.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;	
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.travel.bean.FlightSearch;
import com.travel.object.bookingrequest.BookingRequest;
import com.travel.object.bookingrequest.PassengerDetail;
import com.travel.object.checkFareRulesResponse.BundleOffer;
import com.travel.object.checkFareRulesResponse.CheckFareRulesResponse;
import com.travel.object.email.EmailFormat;
import com.travel.object.fareRules.CheckFareRules;
import com.travel.object.flightresponse.Airline;
import com.travel.object.flightresponse.Airport;
import com.travel.object.flightresponse.FlightResponse;
import com.travel.object.flightresponse.FlightResult;
import com.travel.object.searchRequest.FlightRequest;
import com.travel.service.ConfirmationDBService;
import com.travel.service.ConfirmationPageMailerService;
import com.travel.service.FlightService;
import com.travel.service.RestDataService;
import com.travel.utility.Utility;

import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FlightsController
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
	@Value("${siteId}")
	private int siteId;	
	@Value("${apiUrl}")
	private String apiUrl;
	@Value("${changeableTicketMarkupOne}")
	private Double changeableTicketMarkupOne;
	@Value("${changeableTicketMarkupTwo}")
	private Double changeableTicketMarkupTwo;
	@Value("${cancelProtectDisplayAmount}")
	private Double cancelProtectDisplayAmount;
	@Value("${webcheckinAmount}")
	private Double webcheckinAmount;
	@Value("${surefundAmount}")
	private Double surefundAmount;
	
	@Autowired
	ConfirmationDBService confirmationDBService;
	
	@Autowired
	ConfirmationPageMailerService confirmationPageMailerService;
	
	
	@GetMapping("/")
	public String homePage(@ModelAttribute FlightSearch flightSearch,  Model model){
		return "index";
	}
	
	@GetMapping("/flights")
	public String flightPage(@ModelAttribute FlightSearch flightSearch,  Model model){
		return "flights_ppc";
	}
	
	@PostMapping("/flight-listing/{searchId}")
	public String resultPage(@ModelAttribute FlightSearch flightSearch,  @PathVariable String searchId, HttpServletRequest request, Model model){
		ObjectMapper mapper = new ObjectMapper();

		System.out.println(" Flight Search Post Method Calling..... ");
		//System.out.println("Airline : " + flightSearch.getPageAirline());
		//System.out.println("getCabin : " + flightSearch.getCabin());
		System.out.println("Trip Type = " + flightSearch.getTripType());
		
		String utmSource="online";
		try {
			utmSource=(String) request.getSession().getAttribute("utm_source");
			if(utmSource.isEmpty() || utmSource ==null) {
				utmSource="online";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			utmSource="online";
		}
		
		flightSearch.setUtmSource(utmSource);
		
		try
		{
			System.out.println("FlightSearch Request:: "+mapper.writeValueAsString(flightSearch));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		FlightRequest flightReq = flightService.getFlightSearchRequest(flightSearch, request, searchId);
		try
		{
			System.out.println("Flight Request:: "+mapper.writeValueAsString(flightReq));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		//System.out.println(flightService.getFlightSearchResponse(flightReq));
		
		request.getSession().setAttribute("flightRequest", flightReq);
		request.getSession().setAttribute("flightSearch", flightSearch);
		model.addAttribute("airlineList", Utility.getAirlines());

		try 
		{
			model.addAttribute("searchString", new ObjectMapper().writeValueAsString(flightSearch).replace("Int'l", "Intl"));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return "flights/listing/result";
	}

	@GetMapping("/flight-listing/{searchId}")
	public String flightListing(@ModelAttribute FlightSearch flightSearch,  @PathVariable String searchId, HttpServletRequest request, Model model){

		System.out.println(" Flight Search Get Method Calling..... ");

		flightSearch = (FlightSearch) request.getSession().getAttribute("flightSearch");
		FlightRequest flightRequest = (FlightRequest) request.getSession().getAttribute("flightRequest");
		String utmSource="online";
		try {
			utmSource=(String) request.getSession().getAttribute("utm_source");
			if(utmSource.isEmpty() || utmSource ==null) {
				utmSource="online";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			utmSource="online";
		}
		
		flightSearch.setUtmSource(utmSource);
		
		try
		{
			System.out.println("FlightSearch JSON :: "+new ObjectMapper().writeValueAsString(flightSearch));
			System.out.println("FlightRequest JSON :: "+new ObjectMapper().writeValueAsString(flightRequest));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		model.addAttribute("airlineList", Utility.getAirlines());
		model.addAttribute("flightSearch", flightSearch);
		try {
			model.addAttribute("searchString", new ObjectMapper().writeValueAsString(flightSearch).replace("Int'l", "Intl"));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return "flights/listing/result";
	}

	@RequestMapping(value = {"/flight-listing-mid"}, method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView flightListingMid(@ModelAttribute FlightSearch flightSearch, HttpServletRequest request, @ModelAttribute BookingRequest bookingRequest, Model model){
		System.out.println(" flight-listing-mid calling ....... ");

		flightSearch = (FlightSearch) request.getSession().getAttribute("flightSearch");
		FlightRequest searchRequest = (FlightRequest) request.getSession().getAttribute("flightRequest");
		try
		{
			System.out.println("FlightSearch JSON :: "+new ObjectMapper().writeValueAsString(flightSearch));
			System.out.println("FlightRequest JSON :: "+new ObjectMapper().writeValueAsString(searchRequest));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		String searchResponse = flightService.getFlightSearchResponse(searchRequest);
		ObjectMapper mapper = new ObjectMapper();
		FlightResponse flightResponseObj = new FlightResponse();
		try
		{
			flightResponseObj = mapper.readValue(searchResponse, FlightResponse.class);
		}catch(Exception e){
			e.printStackTrace();
		}

		try 
		{
			request.getSession().setAttribute("sessionFlightResponse", mapper.readValue(searchResponse, FlightResponse.class));
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(" FlightResponse JSON Object:: "+flightResponseObj.getTraceId()); 

		String searchID = Utility.getAlphaNumericString(16);
		return new ModelAndView("redirect:/flight/payment/"+searchID+"/1");
	}

	@RequestMapping(value = "/flight/payment/{searchId}/{resultId}", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView paymentPage(@PathVariable String searchId, @PathVariable String resultId, @RequestParam(value = "mar", required = false) String mar, @ModelAttribute BookingRequest bookingRequest, Model model, HttpServletRequest request, ModelMap modelMap, HttpSession session){
		FlightResult selectedflight=new FlightResult();
		ModelAndView mv = new ModelAndView("/flights/payment/payment");
		String chkMarURL="false";
		try
		{
			request.getSession().removeAttribute("bookingDone");
			request.getSession().removeAttribute("enqueryDone");
			request.getSession().removeAttribute("enqueryPhoneNo");
			
			boolean hasMarTrue = "true".equalsIgnoreCase(mar);
		    if (hasMarTrue) {
		        System.out.println("mar=true is present");
		        chkMarURL="true";
		        
		    } else {
		        System.out.println("mar=true is NOT present");
		        chkMarURL="false";
		    }
		    

		}catch(Exception e){ }
		ObjectMapper mapper = new ObjectMapper();

		String tollFree = (String) session.getAttribute("tollFree");
		System.out.println("tollFree:: "+tollFree);
		//ModelMap modelMap = new ModelMap();
		/*System.out.println("bookingRequest Key:: "+modelMap.containsKey("bookingRequest"));
		System.out.println("bookingRequest Key11:: "+modelMap.get("bookingRequest"));
		BookingRequest bk= (BookingRequest) model.asMap().get("bookingRequest");
		System.out.println("Yes"+bk.getSearchID()+" && searchId"+searchId);
		if(modelMap.containsKey("bookingRequest")){
			System.out.println("Yes"+bookingRequest.getSearchID()+" && searchId"+searchId);

			if(bookingRequest.getSearchID().equalsIgnoreCase(searchId)){
				System.out.println("Yes Search Matched");
			}
		}*/

		//System.out.println(""+model.containsAttribute("bookingRequest"));
		//System.out.println(" model.containsAttribute(bookingRequest) "+model.containsAttribute("bookingRequest"));
		/*if(!model.containsAttribute("bookingRequest")) {

		}*/

		if(searchId.equalsIgnoreCase("coremeta")){
			String deeplinkId=resultId.split("-")[0];
			String flightId=resultId.split("-")[1];
			String userBrowserDetails="userBrowserDetails";
			String device = "";
			try {
				UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
				userBrowserDetails=userAgent.getOperatingSystem()+"-"+userAgent.getBrowser()+"-"+userAgent.getBrowserVersion();
				device = userAgent.getOperatingSystem().getDeviceType().getName();
			} catch (Exception e1) {
				userBrowserDetails = request.getHeader("user-agent");
			}

			bookingRequest.setDevice(device);
			bookingRequest.setBrowser(userBrowserDetails);
			bookingRequest.setSearchID(deeplinkId);
			bookingRequest.setSourceMedia(searchId);
			bookingRequest.setCacheLocation(flightId);

			bookingRequest = flightService.getMetaBookingRequest(bookingRequest);
			bookingRequest.setCurrencyCode(currency);
			bookingRequest.setDevice(device);
			bookingRequest.setBrowser(userBrowserDetails);
			bookingRequest.setSearchID(deeplinkId);
			bookingRequest.setUserSessionID(deeplinkId);
			bookingRequest.setUserIP(request.getRemoteAddr());
			//bookingRequest.setSourceMedia(searchId);
			bookingRequest.setCacheLocation(flightId);
			bookingRequest.setProdID("1");
			bookingRequest.setBookingID("0");
			selectedflight=bookingRequest.getFlightResult();
		}else{

			FlightRequest searchRequest = (FlightRequest) request.getSession().getAttribute("flightRequest");
			FlightResponse flightResult=new FlightResponse();
			try 
			{
				flightResult = (FlightResponse) request.getSession().getAttribute("sessionFlightResponse");
				System.out.println("flightResultStr : " + flightResult); 
				//flightResult = mapper.readValue(flightResultStr, FlightResult.class);
			} 
			catch (Exception e1) {
				e1.printStackTrace();
			}

			for (int i = 0; i < flightResult.getFlightResult().size(); i++) {
				if(flightResult.getFlightResult().get(i).getResultID() == Integer.parseInt(resultId)){
					selectedflight=flightResult.getFlightResult().get(i);
				}
			}

			List<Airline> airline  = flightResult.getAirline();
			List<Airport> airport = flightResult.getAirport();
			for (int i = 0; i < selectedflight.getOutBound().size(); i++) {
				for (int j = 0; j < airline.size(); j++) {
					if(selectedflight.getOutBound().get(i).getAirline().equalsIgnoreCase(airline.get(j).getCode())){
						selectedflight.getOutBound().get(i).setAirlineName(airline.get(j).getName());
					}
				}
				for (int j = 0; j < airport.size(); j++) {
					if(airport.get(j).getAirportCode().equalsIgnoreCase(selectedflight.getOutBound().get(i).getFromAirport())){
						selectedflight.getOutBound().get(i).setFromAirportName(airport.get(j).getAirportName());
						selectedflight.getOutBound().get(i).setFroCityName(airport.get(j).getCityName());
					}
					if(airport.get(j).getAirportCode().equalsIgnoreCase(selectedflight.getOutBound().get(i).getToAirport())){
						selectedflight.getOutBound().get(i).setToAirportName(airport.get(j).getAirportName());
						selectedflight.getOutBound().get(i).setToCityName(airport.get(j).getCityName());
					}
				}
			}

			if(selectedflight.getInBound() != null){
				for (int i = 0; i < selectedflight.getInBound().size(); i++) {
					for (int j = 0; j < airline.size(); j++) {
						if(selectedflight.getInBound().get(i).getAirline().equalsIgnoreCase(airline.get(j).getCode())){
							selectedflight.getInBound().get(i).setAirlineName(airline.get(j).getName());
						}
					}
					for (int j = 0; j < airport.size(); j++) {
						if(airport.get(j).getAirportCode().equalsIgnoreCase(selectedflight.getInBound().get(i).getFromAirport())){
							selectedflight.getInBound().get(i).setFromAirportName(airport.get(j).getAirportName());
							selectedflight.getInBound().get(i).setFroCityName(airport.get(j).getCityName());	
						}
						if(airport.get(j).getAirportCode().equalsIgnoreCase(selectedflight.getInBound().get(i).getToAirport())){
							selectedflight.getInBound().get(i).setToAirportName(airport.get(j).getAirportName());
							selectedflight.getInBound().get(i).setToCityName(airport.get(j).getCityName());
						} 
					}
				}
			}

			CheckFareRules checkRules = new CheckFareRules();
			checkRules.setFlightResult(selectedflight);
			checkRules.setAdults(searchRequest.getAdults());
			checkRules.setChild(searchRequest.getChild());
			checkRules.setInfants(searchRequest.getInfants());
			checkRules.setInfantsWs(searchRequest.getInfantsWs());
			checkRules.setSiteID(searchRequest.getSiteId());
			checkRules.setCurrencyCode(searchRequest.getCurrencyCode());
			//checkRules.setTripadd(true);

			try 
			{
				// get Search Request object as a json string
				String jsonStr = mapper.writeValueAsString(checkRules);
				System.out.println("Flight Controller::CheckRules JSON:: "+jsonStr);
			} catch (IOException e) {
				e.printStackTrace();
			}

			String fareRules = "";
			try
			{
				fareRules= flightService.getFlightFareRules(checkRules);
				System.out.println("Direct Payment FareRules Response::"+fareRules);
			}catch(Exception e){
				System.out.println(" Direct Payment FareRules Response Not Comming ");
				e.printStackTrace();
			}

			CheckFareRulesResponse checkRulesResponse = null;
			try 
			{
				checkRulesResponse = mapper.readValue(fareRules, CheckFareRulesResponse.class);
			} catch (IOException e) {
				e.printStackTrace();
			}

			String bundleStr = "";
			try
			{
				bundleStr = mapper.writeValueAsString(checkRulesResponse.getBundleOffer());
			}catch(Exception e){}

			BundleOffer bundleOffer = null;
			try
			{
				bundleOffer = mapper.readValue(bundleStr.toString(), BundleOffer.class);
			}catch(Exception e){

			}

			bookingRequest.setFlightResult(selectedflight);
			bookingRequest.setAdults(searchRequest.getAdults());
			bookingRequest.setChild(searchRequest.getChild());
			bookingRequest.setInfants(searchRequest.getInfants());
			bookingRequest.setInfantsWs(searchRequest.getInfantsWs());
			bookingRequest.setSearchID(searchRequest.getSearchID());
			bookingRequest.setSiteID(searchRequest.getSiteId());
			bookingRequest.setProdID("1");
			bookingRequest.setBookingID("0");
			bookingRequest.setUserSessionID(searchId);
			bookingRequest.setCurrencyCode(currency);
			bookingRequest.setBrowser(searchRequest.getBrowser());
			bookingRequest.setSourceMedia(searchRequest.getSource()); 
			bookingRequest.setChangeableTicketMarkupOne(changeableTicketMarkupOne);
			bookingRequest.setChangeableTicketMarkupTwo(changeableTicketMarkupTwo);
			bookingRequest.setCancelProtectDisplayAmount(cancelProtectDisplayAmount); 
			bookingRequest.setWebcheckinAmount(webcheckinAmount);	
			bookingRequest.setBundleOffer(bundleOffer);
			bookingRequest.setSurefundAmount(surefundAmount);

			List<PassengerDetail> passengerDetails = new ArrayList<PassengerDetail>();
			int travelerNo=0;
			for (int i = 0; i < searchRequest.getAdults(); i++) {
				PassengerDetail paxDetail=new PassengerDetail();
				paxDetail.setPassengerType(1);
				passengerDetails.add(paxDetail);
				travelerNo++;
			}
			for (int i = 0; i < searchRequest.getChild(); i++) {
				PassengerDetail paxDetail=new PassengerDetail();
				paxDetail.setPassengerType(2);
				passengerDetails.add(paxDetail);
				travelerNo++;
			}
			for (int i = 0; i < searchRequest.getInfants(); i++) {
				PassengerDetail paxDetail=new PassengerDetail();
				paxDetail.setPassengerType(3);
				passengerDetails.add(paxDetail);
				travelerNo++;
			}
			for (int i = 0; i < searchRequest.getInfantsWs(); i++) {
				PassengerDetail paxDetail=new PassengerDetail();
				paxDetail.setPassengerType(4);
				passengerDetails.add(paxDetail);
				travelerNo++;
			}

			bookingRequest.setPassengerDetails(passengerDetails);
			model.addAttribute("searchRequest", searchRequest);
		}

		ArrayList<String> title = new ArrayList<String>(); 
		title.add("Title"); 
		title.add("Mr"); 
		title.add("Mrs");  
		title.add("Miss"); 
		title.add("Dr"); 

		ArrayList<String> gender = new ArrayList<String>(); 
		gender.add("Select Gender");
		gender.add("Male"); 
		gender.add("Female"); 

		ArrayList<String> month = new ArrayList<String>(); 
		String[] shortMonths = new DateFormatSymbols().getShortMonths();
		month.add("Month");
		for (int i = 0; i < shortMonths.length-1; i++) {
			String shortMonth = shortMonths[i];
			month.add(shortMonth);
		}

		ArrayList<String> days = new ArrayList<String>();
		days.add("Day");
		for (int i = 1; i < 32; i++) {
			days.add(String.valueOf(i));
		}

		ArrayList<String> year = new ArrayList<String>(); 
		int years = Calendar.getInstance().get(Calendar.YEAR)-11;
		year.add("Year");
		for (int i = years; i > (years-100); i--) {
			year.add(String.valueOf(i));
		}

		ArrayList<String> childyear = new ArrayList<String>(); 
		int chyears = Calendar.getInstance().get(Calendar.YEAR)-2;
		childyear.add("Year");
		for (int i = chyears; i > (chyears-11); i--) {
			childyear.add(String.valueOf(i));
		}

		ArrayList<String> infyear = new ArrayList<String>(); 
		int infyears = Calendar.getInstance().get(Calendar.YEAR);
		infyear.add("Year");
		for (int i = infyears; i > (infyears-3); i--) {
			infyear.add(String.valueOf(i));
		}

		ArrayList<String> cardyear = new ArrayList<String>(); 
		years = Calendar.getInstance().get(Calendar.YEAR);
		cardyear.add("Year");
		for (int i = years; i < (years+50); i++) {
			cardyear.add(String.valueOf(i));
		}

		ArrayList<String> cardMonth = new ArrayList<String>(); 
		cardMonth.add("Month");
		cardMonth.add("Jan (01)");
		cardMonth.add("Feb (02)");
		cardMonth.add("Mar (03)");
		cardMonth.add("Apr (04)");
		cardMonth.add("May (05)");
		cardMonth.add("Jun (06)");
		cardMonth.add("Jul (07)");
		cardMonth.add("Aug (08)");
		cardMonth.add("Sep (09)");
		cardMonth.add("Oct (10)");
		cardMonth.add("Nov (11)");
		cardMonth.add("Dec (12)");

		ArrayList<String> cardtype = new ArrayList<String>(); 
		cardtype.add("Select a Card");
		cardtype.add("Visa");
		cardtype.add("Master Card");
		cardtype.add("American Express");
		cardtype.add("Diners Club");
		cardtype.add("Discover");
		cardtype.add("Carte Blanche");

		HashMap<String, ArrayList<String>> models = new HashMap<String, ArrayList<String>>();  
		models.put("title", title); 
		models.put("days", days); 
		models.put("month", month); 
		models.put("year", year); 
		models.put("chyear", childyear); 
		models.put("infyear", infyear); 
		models.put("cardyear", cardyear); 
		models.put("cardMonth", cardMonth);
		models.put("cardtype", cardtype);
		models.put("gender", gender);
		model.mergeAttributes(models);

		try 
		{
			System.out.println(" Direct Booking Object For Payment Page Print::"+mapper.writeValueAsString(bookingRequest));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("chkMarURL", chkMarURL);
		request.getSession().setAttribute("bookingRequest", bookingRequest);
		request.getSession().setAttribute("selectedflight", selectedflight);
		model.addAttribute("tollFree", tollFree);
		mv.addObject("bookingRequest", bookingRequest);
		return mv;
	}
	
	@PostMapping("/flight/payment/confirm")
	public ModelAndView flightPaymentMid(@ModelAttribute BookingRequest bookingRequest, HttpServletRequest request, Model model){

		System.out.println("<<<<<<<< FlightPaymentMid Calling >>>>>>>");
		
		ModelAndView mv = new ModelAndView("confirm_mid");
		FlightResult selectedflight=(FlightResult) request.getSession().getAttribute("selectedflight");
		FlightRequest searchRequest = (FlightRequest) request.getSession().getAttribute("flightRequest");
		ObjectMapper mapper = new ObjectMapper();
		try 
		{
			System.out.println("FlightPaymentMid::SelectedFlight From Session:: "+mapper.writeValueAsString(selectedflight));
			System.out.println("FlightPaymentMid::Booking Request From Session:: "+mapper.writeValueAsString(bookingRequest));
		} 
		catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		bookingRequest.setFlightResult(selectedflight);
		bookingRequest.setAdults(searchRequest.getAdults());
		bookingRequest.setChild(searchRequest.getChild());
		bookingRequest.setInfants(searchRequest.getInfants());
		bookingRequest.setInfantsWs(searchRequest.getInfantsWs());
		bookingRequest.setSearchID(searchRequest.getSearchID());
		bookingRequest.setSiteID(searchRequest.getSiteId());
		bookingRequest.setBookingID("0"); 
		bookingRequest.setUserSessionID(searchRequest.getSearchID());
		bookingRequest.setSourceMedia(searchRequest.getSource());
		bookingRequest.setCurrencyCode(currency);
		bookingRequest.setSiteID(searchRequest.getSiteId());
		bookingRequest.setUserIP(searchRequest.getUserIP());
		bookingRequest.setDevice(searchRequest.getDevice());
		bookingRequest.setDepartDate(searchRequest.getSegment().get(0).getTravelDate());
		
		for (int i = 0; i < bookingRequest.getPassengerDetails().size(); i++) {
			String dateOfBirth = bookingRequest.getPassengerDetails().get(i).getDateOfYear()+"-"+bookingRequest.getPassengerDetails().get(i).getDateOfMonth()+"-"+bookingRequest.getPassengerDetails().get(i).getDobDay();
			bookingRequest.getPassengerDetails().get(i).setDateOfBirth(dateOfBirth);
		}
		
				bookingRequest = flightService.saveBookingData(bookingRequest, searchRequest);

				System.out.println("ID -- " + bookingRequest.getBookingID());
				System.out.println("PAX Email IS -- " + bookingRequest.getEmailID());
				
				String emailBody ="";
				try {
					emailBody = confirmationPageMailerService.getEmailContent(searchRequest.getSearchID(), siteId);
				}catch (Exception e) {
					e.printStackTrace(); 
				}

				EmailFormat emailSend = new EmailFormat();
				emailSend.setFromEmail("support@rawfares.ca");
				emailSend.setToEmail(bookingRequest.getEmailID());
				emailSend.setBccEmail("booking@tgsventures.co.in");
				emailSend.setBookingID(bookingRequest.getBookingID());
				emailSend.setMailBody(emailBody);
				emailSend.setMailSubject("Congratulations!! Booking Acknowledgement - " + bookingRequest.getBookingID());

				try {
					mailService.SendMail(emailSend, "smtp.gmail.com", "465", "piin ljcs aoay dgzg");
				} catch (IOException e) {
					e.printStackTrace();
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}

		return mv;
	}
	
	@RequestMapping(value = {"/flight/confirm/{sessionId}/{randomId}"}, method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView flightConfirm(@PathVariable String sessionId, @PathVariable String randomId, HttpServletRequest request, Model model){

		System.out.println(" GetConfirmationDB To Book Calling..... "); 
		ModelAndView mv = new ModelAndView("confirmation");
		String htmlResponse = "";
		try {
			htmlResponse = confirmationPageMailerService.getConfimationPageContent(sessionId, siteId);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		model.addAttribute("htmlResponse", htmlResponse);
		return mv;
	}	
}