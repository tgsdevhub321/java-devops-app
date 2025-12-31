package com.travel.controller;

import java.io.IOException;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
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
import com.travel.object.ClickTrackerRequest;
import com.travel.object.bookingrequest.BookingRequest;
import com.travel.object.bookingrequest.PassengerDetail;
import com.travel.object.checkFareRulesResponse.BundleOffer;
import com.travel.object.fareRules.CheckFareRules;
import com.travel.object.fareRules.FareRules;
import com.travel.object.flightresponse.Airline;
import com.travel.object.flightresponse.Airport;
import com.travel.object.flightresponse.Fare;
import com.travel.object.flightresponse.FlightResult;
import com.travel.object.flightresponse.InBound;
import com.travel.object.flightresponse.OtherBound;
import com.travel.object.flightresponse.OutBound;
import com.travel.object.searchRequest.FlightRequest;
import com.travel.object.searchRequest.Segment;
import com.travel.service.FlightService;
import com.travel.service.RestDataService;
import com.travel.utility.Utility;
import eu.bitwalker.useragentutils.UserAgent;

@Controller
public class FlightsMetaController {

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

	@Value("${siteName}")
	private String siteName;

	@Value("${siteId}")
	private int siteId;

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
	
	@GetMapping("/flights/to/service")
	public String googleLink(@ModelAttribute FlightSearch flightSearch, @ModelAttribute BookingRequest bookingRequest, HttpServletRequest request,Model model){
		
		System.out.println("<<<<<< FlightsMetaController :: /flights/to/service :: GoogleLink Calling..>>>>>>");

		try
		{
			StringBuffer url=request.getRequestURL();
			String query = request.getQueryString();
			if(StringUtils.hasText(query)){
				url.append('?').append(query);
			}
			System.out.println("FlightsMetaController :: Google Deeplink URL>>>>> "+url.toString());
		}
		catch(Exception e){
		}

		String Adult=request.getParameter("Adult");
		String Child=request.getParameter("Child"); 
		String Infant=request.getParameter("Infant");//Infant with Seat
		String InfantLap=request.getParameter("InfantLap");
		String PointOfSaleCountry=request.getParameter("PointOfSaleCountry");
		String UserCurrency=request.getParameter("UserCurrency");
		String grandTotal=request.getParameter("DisplayedPrice"); 
		String DisplayedPriceCurrency=request.getParameter("DisplayedPriceCurrency");
		String UserLanguage=request.getParameter("UserLanguage"); 
		String Refe=request.getParameter("ReferralId");
		String TripType=request.getParameter("TripType"); 
		String Slice1=request.getParameter("Slice1"); 

		bookingRequest.setCurrencyCode(UserCurrency);
		bookingRequest.setAdults(Integer.parseInt(Adult));

		try 
		{
			bookingRequest.setChild(Integer.parseInt(Child));
		} catch (Exception e3) {
			bookingRequest.setChild(0);
		}
		try {
			bookingRequest.setInfants(Integer.parseInt(InfantLap));
		} catch (Exception e2) {
			bookingRequest.setInfants(0);
		}

		try 
		{
			bookingRequest.setInfantsWs(Integer.parseInt(Infant));
		} catch (NumberFormatException e2) {
			bookingRequest.setInfantsWs(0);
		}

		bookingRequest.setSearchID(Refe);
		bookingRequest.setSiteID(siteId);
		bookingRequest.setProdID("1");
		bookingRequest.setBookingID("0");
		bookingRequest.setUserSessionID(Slice1);
		bookingRequest.setCurrencyCode(currency);
		String userBrowserDetails="userBrowserDetails";
		String device = "";
		try 
		{
			UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
			userBrowserDetails=userAgent.getOperatingSystem()+"-"+userAgent.getBrowser()+"-"+userAgent.getBrowserVersion();
			device = userAgent.getOperatingSystem().getDeviceType().getName();
			/*if(device.equalsIgnoreCase("Computer")){
				device="Desktop";
			}*/
		} catch (Exception e1) {
			userBrowserDetails = request.getHeader("user-agent");
		}

		bookingRequest.setDevice(device);
		bookingRequest.setBrowser(userBrowserDetails);
		List<PassengerDetail> passengerDetails=new ArrayList<PassengerDetail>();
		int travelerNo=0;
		for (int i = 0; i < bookingRequest.getAdults(); i++) {
			PassengerDetail paxDetail=new PassengerDetail();
			paxDetail.setPassengerType(1);
			passengerDetails.add(paxDetail);
			travelerNo++;
		}
		for (int i = 0; i < bookingRequest.getChild(); i++) {
			PassengerDetail paxDetail=new PassengerDetail();
			paxDetail.setPassengerType(2);
			passengerDetails.add(paxDetail);
			travelerNo++;
		}
		for (int i = 0; i < bookingRequest.getInfants(); i++) {
			PassengerDetail paxDetail=new PassengerDetail();
			paxDetail.setPassengerType(3);
			passengerDetails.add(paxDetail);
			travelerNo++;
		}
		for (int i = 0; i < bookingRequest.getInfantsWs(); i++) {
			PassengerDetail paxDetail=new PassengerDetail();
			paxDetail.setPassengerType(4);
			passengerDetails.add(paxDetail);
			travelerNo++;
		}

		bookingRequest.setPassengerDetails(passengerDetails);
		FlightResult selectedflight=new FlightResult();
		String origin1="";
		String destination1="";
		String origin=request.getParameter("Origin1");

		bookingRequest.setDepartDate(Utility.googleDateformat(request.getParameter("DepartureDate1")));
		String cabinId=	request.getParameter("Cabin1"); 
		String destination="";
		List<OutBound> outBound=new ArrayList<OutBound>();
		String outArray[]=Slice1.split(",");
		for (int i = 0; i < outArray.length; i++) {
			String count=outArray[i];
			OutBound outRoute=new OutBound();
			String Cabin1=request.getParameter("Cabin".concat(count)); 
			outRoute.setCabinClass(Utility.getCabinId(Cabin1));
			String Carrier1=request.getParameter("Carrier".concat(count));
			outRoute.setAirline(Carrier1);
			outRoute.setOrgAirline(Carrier1);
			outRoute.setOpratingAirline(Carrier1);

			String DepartureDate1=request.getParameter("DepartureDate".concat(count));
			try{
				DepartureDate1 = DepartureDate1.concat("T");
				String DepartureTime1=request.getParameter("DepartureTime".concat(count));
				DepartureDate1=DepartureDate1.concat(DepartureTime1).concat(":00");
			}catch(Exception e){}
			outRoute.setDepDate(DepartureDate1);
			System.out.println("FlightsMetaController::Slice1:: DepartureDate"+count+" :: "+DepartureDate1);

			try{
				String ArrivalDate1=request.getParameter("ArrivalDate".concat(count));
				ArrivalDate1=ArrivalDate1.concat("T");
				String ArrivalTime1=request.getParameter("ArrivalTime".concat(count));
				ArrivalDate1=ArrivalDate1.concat(ArrivalTime1).concat(":00");
				outRoute.setReachDate(ArrivalDate1);
				System.out.println("FlightsMetaController::Slice1:: ArrivalDate"+count+" :: "+ArrivalDate1);
			}
			catch(Exception e){}

			String Origin1=request.getParameter("Origin".concat(count)); 
			outRoute.setFromAirport(Origin1);
			String Destination1=request.getParameter("Destination".concat(count));
			outRoute.setToAirport(Destination1);
			destination=Destination1;
			String BookingCode1=request.getParameter("BookingCode".concat(count)); 
			outRoute.setResDesignCode(BookingCode1);
			String FlightNumber1=request.getParameter("FlightNumber".concat(count));
			outRoute.setFlightNo(FlightNumber1);
			outBound.add(outRoute);

		}

		bookingRequest.setReturnDate("");
		selectedflight.setOutBound(outBound);
		if(TripType.equalsIgnoreCase("RoundTrip") || TripType.equalsIgnoreCase("OpenJaw") || TripType.equalsIgnoreCase("MultiCity")){
			List<InBound> inBound=new ArrayList<InBound>();
			String Slice2=request.getParameter("Slice2"); 
			String inArray[]=Slice2.split(",");
			for (int i = 0; i < inArray.length; i++) {
				String count=inArray[i];
				InBound inRoute=new InBound();
				String Cabin1=request.getParameter("Cabin".concat(count)); 
				inRoute.setCabinClass(Utility.getCabinId(Cabin1));
				String Carrier1=request.getParameter("Carrier".concat(count));
				inRoute.setAirline(Carrier1);
				inRoute.setOrgAirline(Carrier1);
				inRoute.setOpratingAirline(Carrier1);

				String DepartureDate1=request.getParameter("DepartureDate".concat(count));
				try{
					DepartureDate1 = DepartureDate1.concat("T");
					String DepartureTime1=request.getParameter("DepartureTime".concat(count));
					DepartureDate1=DepartureDate1.concat(DepartureTime1).concat(":00");
				}catch(Exception e){}
				inRoute.setDepDate(DepartureDate1);
				System.out.println("FlightsMetaController::Slice2:: DepartureDate"+count+" :: "+DepartureDate1);

				try{
					String ArrivalDate1=request.getParameter("ArrivalDate".concat(count));
					ArrivalDate1=ArrivalDate1.concat("T");
					String ArrivalTime1=request.getParameter("ArrivalTime".concat(count));
					ArrivalDate1=ArrivalDate1.concat(ArrivalTime1).concat(":00");
					inRoute.setReachDate(ArrivalDate1);
					System.out.println("FlightsMetaController::Slice2:: ArrivalDate"+count+" :: "+ArrivalDate1);
				}catch(Exception e){}

				String Origin1=request.getParameter("Origin".concat(count)); 
				if(i==0){
					origin1=Origin1;
				}
				inRoute.setFromAirport(Origin1);
				String Destination1=request.getParameter("Destination".concat(count));
				inRoute.setToAirport(Destination1);
				if(i==0){
					//System.out.println("DepartureDate1#######"+DepartureDate1);
					bookingRequest.setReturnDate(Utility.googleDateformat(DepartureDate1.split("T")[0].toString()));//01/11/2022  2022-01-12
				}
				destination1=Destination1;
				String BookingCode1=request.getParameter("BookingCode".concat(count)); 
				inRoute.setResDesignCode(BookingCode1);
				String FlightNumber1=request.getParameter("FlightNumber".concat(count));
				inRoute.setFlightNo(FlightNumber1);
				inBound.add(inRoute);
			}
			selectedflight.setInBound(inBound);
		}

		List<List<OtherBound>> otherBounds=new ArrayList<List<OtherBound>>();

		try
		{
			List<OtherBound> otherBound = new ArrayList<OtherBound>();
			String Slice3=request.getParameter("Slice3"); 
			String inArray[]=Slice3.split(",");
			for (int i = 0; i < inArray.length; i++) {
				String count=inArray[i];
				OtherBound inRoute=new OtherBound();
				String Cabin1=request.getParameter("Cabin".concat(count)); 
				inRoute.setCabinClass(Utility.getCabinId(Cabin1));
				String Carrier1=request.getParameter("Carrier".concat(count));
				inRoute.setAirline(Carrier1);
				inRoute.setOrgAirline(Carrier1);
				inRoute.setOpratingAirline(Carrier1);

				String DepartureDate1=request.getParameter("DepartureDate".concat(count));
				try
				{
					DepartureDate1 = DepartureDate1.concat("T");
					String DepartureTime1=request.getParameter("DepartureTime".concat(count));
					DepartureDate1=DepartureDate1.concat(DepartureTime1).concat(":00");
				}catch(Exception e){}
				inRoute.setDepDate(DepartureDate1);
				System.out.println("FlightsMetaController::Slice3:: DepartureDate"+count+" :: "+DepartureDate1);

				try{
					String ArrivalDate1=request.getParameter("ArrivalDate".concat(count));
					ArrivalDate1=ArrivalDate1.concat("T");
					String ArrivalTime1=request.getParameter("ArrivalTime".concat(count));
					ArrivalDate1=ArrivalDate1.concat(ArrivalTime1).concat(":00");
					inRoute.setReachDate(ArrivalDate1);
					System.out.println("FlightsMetaController::Slice3:: ArrivalDate"+count+" :: "+ArrivalDate1);
				}catch(Exception e){}

				String Origin1=request.getParameter("Origin".concat(count)); 
				inRoute.setFromAirport(Origin1);
				String Destination1=request.getParameter("Destination".concat(count));
				inRoute.setToAirport(Destination1);
				String BookingCode1=request.getParameter("BookingCode".concat(count)); 
				inRoute.setResDesignCode(BookingCode1);
				String FlightNumber1=request.getParameter("FlightNumber".concat(count));
				inRoute.setFlightNo(FlightNumber1);
				otherBound.add(inRoute);
			}
			otherBounds.add(otherBound);

		}catch (Exception e) {
			// TODO: handle exception
		}

		try{
			for (int j = 4; j < 10; j++) {
				List<OtherBound> otherBound = new ArrayList<OtherBound>();
				String Slice3=request.getParameter("Slice"+j); 
				String inArray[]=Slice3.split(",");
				for (int i = 0; i < inArray.length; i++) {
					String count=inArray[i];
					OtherBound inRoute=new OtherBound();
					String Cabin1=request.getParameter("Cabin".concat(count)); 
					inRoute.setCabinClass(Utility.getCabinId(Cabin1));
					String Carrier1=request.getParameter("Carrier".concat(count));
					inRoute.setAirline(Carrier1);
					inRoute.setOrgAirline(Carrier1);
					inRoute.setOpratingAirline(Carrier1);

					String DepartureDate1=request.getParameter("DepartureDate".concat(count));
					try{
						DepartureDate1 = DepartureDate1.concat("T");
						String DepartureTime1=request.getParameter("DepartureTime".concat(count));
						DepartureDate1=DepartureDate1.concat(DepartureTime1).concat(":00");
					}catch(Exception e){}
					inRoute.setDepDate(DepartureDate1);
					System.out.println("FlightsMetaController::Slice4:: DepartureDate"+count+" :: "+DepartureDate1);

					try{
						String ArrivalDate1=request.getParameter("ArrivalDate".concat(count));
						ArrivalDate1=ArrivalDate1.concat("T");
						String ArrivalTime1=request.getParameter("ArrivalTime".concat(count));
						ArrivalDate1=ArrivalDate1.concat(ArrivalTime1).concat(":00");
						System.out.println("FlightsMetaController::Slice4:: ArrivalDate"+count+" :: "+ArrivalDate1);
						inRoute.setReachDate(ArrivalDate1);	
					}catch(Exception e){}

					String Origin1=request.getParameter("Origin".concat(count)); 
					inRoute.setFromAirport(Origin1);
					String Destination1=request.getParameter("Destination".concat(count));
					inRoute.setToAirport(Destination1);
					String BookingCode1=request.getParameter("BookingCode".concat(count)); 
					inRoute.setResDesignCode(BookingCode1);
					String FlightNumber1=request.getParameter("FlightNumber".concat(count));
					inRoute.setFlightNo(FlightNumber1);
					otherBound.add(inRoute);
				}
				otherBounds.add(otherBound);
			}

		}catch (Exception e) {
			// TODO: handle exception
		}

		selectedflight.setOtherBound(otherBounds);
		Fare fare =new Fare();
		fare.setGrandTotal(Double.valueOf(grandTotal));
		fare.setGrandOrgTotal(Double.valueOf(grandTotal));
		fare.setBagFees(0.0);
		fare.setMarkupType("US");
		fare.setMarkupID(1);
		selectedflight.setResultID(1);
		selectedflight.setCabinClass(selectedflight.getOutBound().get(0).getCabinClass());
		selectedflight.setFare(fare);
		//if(selectedflight.getOutBound().get(0).getOrgAirline().equalsIgnoreCase("TP")){
		//selectedflight.setGdsType(2);
		//}else{
		selectedflight.setGdsType(8);	////2
		//}
		selectedflight.setValCarrier(selectedflight.getOutBound().get(0).getOrgAirline());
		selectedflight.setFareType("RP");
		selectedflight.setAirline(selectedflight.getOutBound().get(0).getOrgAirline());
		selectedflight.setMaxSeat(7);
		bookingRequest.setFlightResult(selectedflight);

		ObjectMapper mapper = new ObjectMapper();
		try 
		{
			System.out.println("FlightsMetaController::GoogleLink:: BookingRequest :: "+mapper.writeValueAsString(bookingRequest));
			/////System.out.println("GoogleLink::SelectedFlight:"+mapper.writeValueAsString(selectedflight));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FlightRequest flightReq = flightService.getFlightDeepSearchRequest(request,TripType,origin,destination,origin1,destination1, otherBounds, bookingRequest.getAdults(),bookingRequest.getChild(),bookingRequest.getInfants(),bookingRequest.getInfantsWs(),bookingRequest.getDepartDate(),bookingRequest.getReturnDate(),cabinId,"google",Refe);
		
		try 
		{
			System.out.println("FlightsMetaController::GoogleLink:: FlightRequest :: "+mapper.writeValueAsString(flightReq));

		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getSession().setAttribute("flightRequest", flightReq);
		request.getSession().setAttribute("bookingRequest", bookingRequest);
		request.getSession().setAttribute("selectedflight", selectedflight);
		model.addAttribute("searchRequest", flightReq);
		
		//////// Call API Click Tracker ////////
		try
		{
			ClickTrackerRequest clickRequest = new ClickTrackerRequest();
			clickRequest.setSiteId(String.valueOf(siteId));
			clickRequest.setLanding_url("payment");
			clickRequest.setDevice(device);
			clickRequest.setSourceMedia(flightReq.getSource());
			clickRequest.setClick_tracker("google");
			clickRequest.setPrice(grandTotal);
			clickRequest.setUserIP(request.getRemoteAddr());
			clickRequest.setOrigin(origin);
			clickRequest.setDestination(destination);
			
			try
			{
				System.out.println(" FlightsMetaController::ClickTrackerRequest For [ " +bookingRequest.getSourceMedia()+" ] "+new ObjectMapper().writeValueAsString(clickRequest));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String clickResponse = flightService.clickTrackerSave(clickRequest);
			System.out.println("ClickResponse :: "+clickResponse); 

		}catch(Exception e){
			System.out.println(" =========== Error in ClickTrackerSave ========== ");
			e.printStackTrace();
		}
		
		////////Call API Click Tracker ////////
		
		return "midMetaPayment";

	}

	@PostMapping("/search/details/{searchId}")
	public String googlePaymentLink(@PathVariable String searchId, @ModelAttribute FlightSearch flightSearch, @ModelAttribute BookingRequest bookingRequest, HttpServletRequest request, Model model){

		System.out.println("<<<<<<<<<<< FlightsMetaController :: /search/details/{searchId} :: GooglePaymentLink Calling...... >>>>>>>>>>>>>");

		FlightResult selectedflight=(FlightResult) request.getSession().getAttribute("selectedflight");
		FlightRequest flightReq = (FlightRequest) request.getSession().getAttribute("flightRequest");
		bookingRequest = (BookingRequest) request.getSession().getAttribute("bookingRequest");
		ObjectMapper mapper = new ObjectMapper();
		try
		{
			request.getSession().removeAttribute("bookingDone");
			request.getSession().removeAttribute("enqueryDone");
			request.getSession().removeAttribute("enqueryPhoneNo");
		}catch(Exception e){ }

		try
		{
			System.out.println("FlightsMetaController::Googledeeplink :: bookingRequest:: "+mapper.writeValueAsString(bookingRequest));
			//System.out.println("Selectedflight:: "+mapper.writeValueAsString(selectedflight));
			System.out.println("FlightsMetaController::FlightSearchRequest:: "+mapper.writeValueAsString(flightReq));
		} 
		catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		CheckFareRules checkRules = new CheckFareRules();
		checkRules.setFlightResult(selectedflight);
		checkRules.setAdults(bookingRequest.getAdults());
		checkRules.setChild(bookingRequest.getChild());
		checkRules.setInfants(bookingRequest.getInfants());
		checkRules.setInfantsWs(bookingRequest.getInfantsWs());
		checkRules.setSiteId(bookingRequest.getSiteID());
		checkRules.setCurrencyCode(bookingRequest.getCurrencyCode());

		try
		{
			System.out.println("FlightsMetaController::CheckFareRules RQ:"+mapper.writeValueAsString(checkRules));
		} catch (IOException e) {
			e.printStackTrace();
		}

		String fareRules= flightService.getFlightMetaCheck(checkRules);
		System.out.println("FlightsMetaController::CheckFareRules-RS:"+fareRules);

		FareRules fareRulesObj=null;
		try 
		{
			fareRulesObj =	mapper.readValue(fareRules, FareRules.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try
		{
			if(fareRulesObj==null){
				System.out.println("<<<< Flight Not Found Case >>>>>>");

				CheckFareRules checkRulesAgain = new CheckFareRules();
				selectedflight.setGdsType(2); 
				checkRulesAgain.setFlightResult(selectedflight);
				checkRulesAgain.setAdults(bookingRequest.getAdults());
				checkRulesAgain.setChild(bookingRequest.getChild());
				checkRulesAgain.setInfants(bookingRequest.getInfants());
				checkRulesAgain.setInfantsWs(bookingRequest.getInfantsWs());
				checkRulesAgain.setSiteId(bookingRequest.getSiteID());
				checkRulesAgain.setCurrencyCode(bookingRequest.getCurrencyCode());

				try
				{
					System.out.println("FlightsMetaController::CheckFareRulesAgain RQ:"+mapper.writeValueAsString(checkRulesAgain));
				} catch (IOException e) {
					e.printStackTrace();
				}

				fareRules= flightService.getFlightMetaCheck(checkRules);
				System.out.println("FlightsMetaController::CheckFareRulesAgain-RS:"+fareRules);

				fareRulesObj=null;
				try 
				{
					fareRulesObj =	mapper.readValue(fareRules, FareRules.class);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}catch(Exception e){

		}

		if(fareRulesObj.isPriceChange()){
			System.out.println("<<<< Flight IsPriceChange Case >>>>>>");
			bookingRequest.setIsPriceChange(true);
		}
		else if(fareRulesObj.isFlightInvalid() || !fareRulesObj.isFlightChecked()){
			
			System.out.println("<<<< Flight Sold Out Case >>>>>>");
			model.addAttribute("IsSoldOut", fareRulesObj.isFlightInvalid());
			bookingRequest.setIsSoldOut(true);
			model.addAttribute("airlineList", Utility.getAirlines());
			flightSearch.setOrigin(restService.getAirportList(flightReq.getSegment().get(0).getOriginAirport()).get(0));
			flightSearch.setDestination(restService.getAirportList(flightReq.getSegment().get(0).getDestinationAirport()).get(0));
			flightSearch.setTripType("1");
			if(flightReq.getTripType()==2){
				flightSearch.setTripType("2");
			}

			flightSearch.setDepartDate(bookingRequest.getDepartDate());
			flightSearch.setReturnDate(bookingRequest.getReturnDate());
			flightSearch.setCabin(Utility.getCabin(flightReq.getCabinType()));
			flightSearch.setAdult(bookingRequest.getAdults());
			flightSearch.setChild(bookingRequest.getChild());
			flightSearch.setInfant(bookingRequest.getInfants());
			flightSearch.setInfantWs(bookingRequest.getInfantsWs());
			
			try 
			{
				model.addAttribute("searchString", new ObjectMapper().writeValueAsString(flightSearch).replace("Int'l", "Intl"));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "result";
		}

		//System.out.println("fareRulesObj.getFare().getGrandTotal():"+fareRulesObj.getFlightResult().getFare().getGrandTotal());
		//System.out.println("flight valid:"+fareRulesObj.isFlightInvalid());
		//System.out.println("flight isFlightChecked:"+fareRulesObj.isFlightChecked());
		//System.out.println("flight isPriceChange:"+fareRulesObj.isPriceChange());

		/*			if(fareRulesObj.isPriceChange()){

							System.out.println("<<<< Flight IsPriceChange Part >>>>>>");

							model.addAttribute("IsPriceChange", fareRulesObj.isPriceChange());
							flightSearch.setOrigin(restService.getAirportList(flightReq.getSegment().get(0).getOriginAirport()).get(0));
							flightSearch.setDestination(restService.getAirportList(flightReq.getSegment().get(0).getDestinationAirport()).get(0));
							flightSearch.setTripType("1");
							if(flightReq.getTripType()==2){
								flightSearch.setTripType("2");
							}
							flightSearch.setDepartDate(bookingRequest.getDepartDate());
							flightSearch.setReturnDate(bookingRequest.getReturnDate());
							flightSearch.setCabin(Utility.getCabin(flightReq.getCabinType()));
							flightSearch.setAdult(bookingRequest.getAdults());
							flightSearch.setChild(bookingRequest.getChild());
							flightSearch.setInfant(bookingRequest.getInfants());
							flightSearch.setInfantWs(bookingRequest.getInfantsWs());
							try {
					        	model.addAttribute("searchString", new ObjectMapper().writeValueAsString(flightSearch).replace("Int'l", "Intl"));
							} catch (JsonProcessingException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						   return "result";
							//return "";
						}
						else if(fareRulesObj.isFlightInvalid() || !fareRulesObj.isFlightChecked()){

					model.addAttribute("airlineList", Utility.getAirlines());
					flightSearch.setOrigin(restService.getAirportList(flightReq.getSegment().get(0).getOriginAirport()).get(0));
					flightSearch.setDestination(restService.getAirportList(flightReq.getSegment().get(0).getDestinationAirport()).get(0));
					flightSearch.setTripType("1");
					if(flightReq.getTripType()==2){
						flightSearch.setTripType("2");
					}
					flightSearch.setDepartDate(bookingRequest.getDepartDate());
					flightSearch.setReturnDate(bookingRequest.getReturnDate());
					flightSearch.setCabin(Utility.getCabin(flightReq.getCabinType()));
					flightSearch.setAdult(bookingRequest.getAdults());
					flightSearch.setChild(bookingRequest.getChild());
					flightSearch.setInfant(bookingRequest.getInfants());
					flightSearch.setInfantWs(bookingRequest.getInfantsWs());
					try {
			        	model.addAttribute("searchString", new ObjectMapper().writeValueAsString(flightSearch).replace("Int'l", "Intl"));
					} catch (JsonProcessingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				   return "result";
					//return "";
				}else{*/


		FlightResult selectedOrgflight = fareRulesObj.getFlightResult();

		List<Airline> airline  = fareRulesObj.getAirline();
		List<Airport> airport = fareRulesObj.getAirport();
		for (int i = 0; i < selectedOrgflight.getOutBound().size(); i++) {
			for (int j = 0; j < airline.size(); j++) {
				if(selectedOrgflight.getOutBound().get(i).getAirline().equalsIgnoreCase(airline.get(j).getCode())){
					selectedOrgflight.getOutBound().get(i).setAirlineName(airline.get(j).getName());
				}
			}
			for (int j = 0; j < airport.size(); j++) {
				if(airport.get(j).getAirportCode().equalsIgnoreCase(selectedOrgflight.getOutBound().get(i).getFromAirport())){
					selectedOrgflight.getOutBound().get(i).setFromAirportName(airport.get(j).getAirportName());
					selectedOrgflight.getOutBound().get(i).setFroCityName(airport.get(j).getCityName());
				}
				if(airport.get(j).getAirportCode().equalsIgnoreCase(selectedOrgflight.getOutBound().get(i).getToAirport())){
					selectedOrgflight.getOutBound().get(i).setToAirportName(airport.get(j).getAirportName());
					selectedOrgflight.getOutBound().get(i).setToCityName(airport.get(j).getCityName());
				}
			}
		}

		if(selectedOrgflight.getInBound() != null){
			for (int i = 0; i < selectedOrgflight.getInBound().size(); i++) {
				for (int j = 0; j < airline.size(); j++) {
					if(selectedOrgflight.getInBound().get(i).getAirline().equalsIgnoreCase(airline.get(j).getCode())){
						selectedOrgflight.getInBound().get(i).setAirlineName(airline.get(j).getName());
					}
				}
				for (int j = 0; j < airport.size(); j++) {
					if(airport.get(j).getAirportCode().equalsIgnoreCase(selectedOrgflight.getInBound().get(i).getFromAirport())){
						selectedOrgflight.getInBound().get(i).setFromAirportName(airport.get(j).getAirportName());
						selectedOrgflight.getInBound().get(i).setFroCityName(airport.get(j).getCityName());
					}
					if(airport.get(j).getAirportCode().equalsIgnoreCase(selectedOrgflight.getInBound().get(i).getToAirport())){
						selectedOrgflight.getInBound().get(i).setToAirportName(airport.get(j).getAirportName());
						selectedOrgflight.getInBound().get(i).setToCityName(airport.get(j).getCityName());
					} 
				}
			}
		}

		if(selectedOrgflight.getOtherBound() != null){
			for(int i = 0; i < selectedOrgflight.getOtherBound().size(); i++) {
				for(int j=0; j<selectedOrgflight.getOtherBound().get(i).size(); j++){

					for (int a = 0; a < airline.size(); a++) {
						if(selectedOrgflight.getOtherBound().get(i).get(j).getAirline().equalsIgnoreCase(airline.get(a).getCode())){
							selectedOrgflight.getOtherBound().get(i).get(j).setAirlineName(airline.get(a).getName());
						}
					}

					for (int a = 0; a < airport.size(); a++) {
						if(airport.get(a).getAirportCode().equalsIgnoreCase(selectedOrgflight.getOtherBound().get(i).get(j).getFromAirport())){
							selectedOrgflight.getOtherBound().get(i).get(j).setFromAirportName(airport.get(a).getAirportName());
							selectedOrgflight.getOtherBound().get(i).get(j).setFroCityName(airport.get(a).getCityName());
						}
						if(airport.get(a).getAirportCode().equalsIgnoreCase(selectedOrgflight.getOtherBound().get(i).get(j).getToAirport())){
							selectedOrgflight.getOtherBound().get(i).get(j).setToAirportName(airport.get(a).getAirportName());
							selectedOrgflight.getOtherBound().get(i).get(j).setToCityName(airport.get(a).getCityName());
						} 
					}
				}
			}
		}
		
		bookingRequest.setFlightResult(selectedOrgflight);
		bookingRequest.setChangeableTicketMarkupOne(changeableTicketMarkupOne);
		bookingRequest.setChangeableTicketMarkupTwo(changeableTicketMarkupTwo);
		bookingRequest.setCancelProtectDisplayAmount(cancelProtectDisplayAmount);
		bookingRequest.setWebcheckinAmount(webcheckinAmount);
		bookingRequest.setSurefundAmount(surefundAmount);
		bookingRequest.setSourceMedia(flightReq.getSource());
		
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
		String[] longMonths = new DateFormatSymbols().getMonths();
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
			System.out.println("FlightsMetaController::Meta Booking Request For Payment Page::"+mapper.writeValueAsString(bookingRequest));
			//System.out.println("Meta SelectedFlight For Payment Page::"+mapper.writeValueAsString(selectedflight));
			//System.out.println("Meta SelectedFlightNew For Payment Page::"+mapper.writeValueAsString(selectedOrgflight));
			System.out.println("Meta SearchRequest For Payment Page::"+mapper.writeValueAsString(flightReq));

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		request.getSession().setAttribute("bookingRequest", bookingRequest);
		request.getSession().setAttribute("selectedflight", selectedOrgflight);
		model.addAttribute("searchRequest", flightReq);
		model.addAttribute("bookingRequest", bookingRequest);
		return "/flights/payment/payment";
	}
	
	@GetMapping("/deeplink/result/{source}/{deeplinkId}/{flightId}")
	public String paymentMetaPage(@PathVariable String source, @PathVariable String deeplinkId, @PathVariable String flightId, @ModelAttribute BookingRequest bookingRequest,Model model,HttpServletRequest request){

		System.out.println("FlightsMetaController::PaymentMetaPage Calling..");
		System.out.println("FlightsMetaController::PaymentMetaDeepLink :: /deeplink/result/"+source+"/"+deeplinkId+"/"+flightId);
		String referrer = "";
		try
		{
			referrer = request.getHeader("referer");
			System.out.println("FlightsMetaController::PaymentCoreMetaPage Referrer Calling.."+referrer);

			if(referrer.contains("mobile-app.us.jetcost.com")){
				System.out.println("jetcost-mobile");
				referrer = "jetcost";
			}
			else if(referrer.contains("fly-scanner")){
				System.out.println("fly-scanner");
				referrer = "fly-scanner";
			}
			else if(referrer.contains("jetcost")){
				System.out.println("jetcost2");
				referrer = "jetcost";
			}
			else if(referrer.contains("jetradar")){
				System.out.println("jetradar");
				referrer = "jetradar";
			}
			else{
				referrer = referrer;
			}
		}catch(Exception e){
			referrer = "";
		}

		try
		{
			request.getSession().removeAttribute("bookingDone");
			request.getSession().removeAttribute("enqueryDone");
			request.getSession().removeAttribute("enqueryPhoneNo");
		}catch(Exception e){ }

		try
		{
			StringBuffer url=request.getRequestURL();
			String query = request.getQueryString();
			if(StringUtils.hasText(query)){
				url.append('?').append(query);
			}
			System.out.println("FlightsMetaController :: PaymentMetaDeepLink Full URL>>>>> "+url.toString());
		}
		catch(Exception e){

		}

		String redirectID = null;
		try{
			redirectID = request.getParameter("redirectID");
		}catch(Exception e){
			redirectID = null;
		}

		System.out.println("FlightsMetaController :: PaymentMetaDeepLink RedirectID :: "+redirectID);

		String userBrowserDetails="userBrowserDetails";
		String device = "";
		try 
		{
			UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
			userBrowserDetails=userAgent.getOperatingSystem()+"-"+userAgent.getBrowser()+"-"+userAgent.getBrowserVersion();
			device = userAgent.getOperatingSystem().getDeviceType().getName();
			/*if(device.equalsIgnoreCase("Computer")){
				device="Desktop";
			}*/
		} 
		catch (Exception e1) {
			userBrowserDetails = request.getHeader("user-agent");
		}

		bookingRequest.setDevice(device);
		bookingRequest.setBrowser(userBrowserDetails);
		bookingRequest.setSearchID(deeplinkId);
		//bookingRequest.setSourceMedia(source);
		bookingRequest.setCacheLocation(flightId);

		String searchID = null;
		try{
			searchID = request.getParameter("marker");
		}catch(Exception e){
			searchID = null;
		}

		System.out.println("Before SearchID[Marker] :: "+searchID);

		if(searchID!=null){
			searchID = searchID;
		}else{
			searchID = Utility.getAlphaNumericString(16);
		}

		System.out.println("After SearchID[Marker] :: "+searchID);

		bookingRequest.setCurrencyCode(currency);
		bookingRequest.setUserSessionID(searchID);
		bookingRequest.setUserIP(request.getRemoteAddr());
		//bookingRequest.setSourceMedia(source);
		bookingRequest.setCacheLocation(flightId);
		bookingRequest.setProdID("1");
		bookingRequest.setBookingID("0");	
		bookingRequest.setSourceMedia("");
		
		BundleOffer bundleOffer = null;
		
		bookingRequest = flightService.getMetaBookingRequest(bookingRequest);
		bookingRequest.setChangeableTicketMarkupOne(changeableTicketMarkupOne);
		bookingRequest.setChangeableTicketMarkupTwo(changeableTicketMarkupTwo);
		bookingRequest.setCancelProtectDisplayAmount(cancelProtectDisplayAmount);
		bookingRequest.setWebcheckinAmount(webcheckinAmount);
		bookingRequest.setSurefundAmount(surefundAmount);
		bookingRequest.setMetaredirectId(redirectID);
		bookingRequest.setBundleOffer(bundleOffer);

		FlightResult selectedflight=bookingRequest.getFlightResult();
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

		bookingRequest.setUserSessionID(searchID);
		bookingRequest.setUserIP(request.getRemoteAddr());

		//System.out.println(" BookingRequest SourceMedia:: "+bookingRequest.getSourceMedia()); 

		try 
		{
			System.out.println(" FlightsMetaController :: Meta Booking Request:: "+new ObjectMapper().writeValueAsString(bookingRequest));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		FlightRequest searchRequest = new FlightRequest();
		searchRequest.setAdults(bookingRequest.getAdults());

		searchRequest.setChild(bookingRequest.getChild());
		searchRequest.setInfants(bookingRequest.getInfants());
		searchRequest.setInfantsWs(bookingRequest.getInfantsWs());
		searchRequest.setSearchID(bookingRequest.getSearchID());
		searchRequest.setSiteId(bookingRequest.getSiteID());
		searchRequest.setSearchID(searchID);
		searchRequest.setTripType(1);

		List<Segment> segment = new ArrayList<Segment>();
		Segment departSegment = new Segment();
		departSegment.setOriginAirport(bookingRequest.getFlightResult().getOutBound().get(0).getFromAirport());
		departSegment.setDestinationAirport(bookingRequest.getFlightResult().getOutBound().get(bookingRequest.getFlightResult().getOutBound().size()-1).getToAirport());
		departSegment.setTravelDate(Utility.googleDateformat(bookingRequest.getFlightResult().getOutBound().get(0).getDepDate().split("T")[0].toString()));
		segment.add(departSegment);
		
		try 
		{
			if(bookingRequest.getFlightResult().getInBound().size()>0){
				Segment returnSegment = new Segment();
				returnSegment.setOriginAirport(bookingRequest.getFlightResult().getInBound().get(0).getFromAirport());
				returnSegment.setDestinationAirport(bookingRequest.getFlightResult().getInBound().get(bookingRequest.getFlightResult().getInBound().size()-1).getToAirport());
				returnSegment.setTravelDate(Utility.googleDateformat(bookingRequest.getFlightResult().getInBound().get(0).getDepDate().split("T")[0].toString()));
				segment.add(returnSegment);
				searchRequest.setTripType(2);
			}
		} catch (Exception e) {
		}
		
		searchRequest.setSegment(segment);
		searchRequest.setUserIP(bookingRequest.getUserIP());
		searchRequest.setDevice(device);
		searchRequest.setSource(bookingRequest.getSourceMedia());
		
		try 
		{
			System.out.println(" FlightsMetaController :: SearchRequest After Making:: "+new ObjectMapper().writeValueAsString(searchRequest));
		} 
		catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		////////Call API Click Tracker ////////
		
		try
		{
			if(bookingRequest.getSourceMedia().equalsIgnoreCase("jetradar")){
				referrer="jetradar";
			}
			
			ClickTrackerRequest clickRequest = new ClickTrackerRequest();
			clickRequest.setSiteId(String.valueOf(siteId));
			clickRequest.setLanding_url("payment");
			clickRequest.setDevice(device);
			clickRequest.setSourceMedia(bookingRequest.getSourceMedia());
			clickRequest.setClick_tracker(bookingRequest.getSourceMedia());
			clickRequest.setPrice(String.valueOf(bookingRequest.getFlightResult().getFare().getGrandTotal()));
			clickRequest.setUserIP(request.getRemoteAddr());
			clickRequest.setOrigin(bookingRequest.getFlightResult().getOutBound().get(0).getFromAirport());
			clickRequest.setDestination(bookingRequest.getFlightResult().getOutBound().get(bookingRequest.getFlightResult().getOutBound().size()-1).getToAirport());
			
			try
			{
				System.out.println(" ClickTrackerRequest For [ " +bookingRequest.getSourceMedia()+" ] "+new ObjectMapper().writeValueAsString(clickRequest));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String clickResponse = flightService.clickTrackerSave(clickRequest);
			System.out.println("FlightsMetaController::ClickResponse :: "+clickResponse);

		}catch(Exception e){
			System.out.println(" =========== Error in ClickTrackerSave ========== ");
			e.printStackTrace();
		}
		////////Call API Click Tracker ////////
		
		request.getSession().setAttribute("bookingRequest", bookingRequest);
		request.getSession().setAttribute("selectedflight", selectedflight);
		request.getSession().setAttribute("flightRequest", searchRequest);
		model.addAttribute("searchRequest", searchRequest);
		model.addAttribute("bookingRequest", bookingRequest);
		
		return "/flights/payment/payment";
	}
	
	@RequestMapping(value = "/searchFlight", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView deepLinkMeta(@ModelAttribute FlightSearch flightSearch, HttpServletRequest request, Model model){
		//ModelAndView mv = new ModelAndView("flightDeepLinkPage");
		ModelAndView mv = null;
		try
		{
			request.getSession().removeAttribute("bookingDone");
			request.getSession().removeAttribute("enqueryDone");
			request.getSession().removeAttribute("enqueryPhoneNo");
		}catch(Exception e){ }
		
		try
		{
			String referrer = request.getHeader("referer");
			System.out.println("FlightsMetaController::DeepLink Referrer Calling.."+referrer);
		}catch(Exception e){

		}
		
		try
		{
			StringBuffer url = request.getRequestURL();
			String query = request.getQueryString();
			if(StringUtils.hasText(query)){
				url.append('?').append(query);
			}
			System.out.println("FlightsMetaController :: Inline Deeplink URL>>>>> "+url.toString());
		}
		catch(Exception e){
		}

		String origin = "";
		String destination = "";
		String departDate = "";
		String returnDate = "";
		String tripType = "";
		String cabinClass = "";
		String utm_source = "";
		int adult = 0;
		int child = 0;
		int infant = 0;
		int infantWs = 0;
		int student = 0;
		int youths = 0;
		int senior = 0;

		try{
			origin = request.getParameter("origin");
		}catch(Exception e){
			origin= "";
		}

		try{
			destination = request.getParameter("destination");
		}catch(Exception e){
			destination= "";
		}
		
		try{
			departDate = request.getParameter("departDate");
		}catch(Exception e){
			departDate= "";
		}

		try{
			returnDate = request.getParameter("returnDate");
		}catch(Exception e){
			returnDate= "";
		}

		try{
			tripType = request.getParameter("tripType");
		}catch(Exception e){
			tripType= "";
		}

		try{
			cabinClass = request.getParameter("cabinClass");
		}catch(Exception e){
			cabinClass= "";
		}
		
		try{
			utm_source = request.getParameter("utm_source");
		}catch(Exception e){
			utm_source= "";
		}
		
		try{
			adult = Integer.parseInt(request.getParameter("adult"));
		}catch(Exception e){
			adult= 0;
		}
		
		try{
			child = Integer.parseInt(request.getParameter("child"));
		}catch(Exception e){
			child= 0;
		}

		try{
			infant = Integer.parseInt(request.getParameter("infant"));
		}catch(Exception e){
			infant= 0;
		}

		try{
			infantWs = Integer.parseInt(request.getParameter("infantWs"));
		}catch(Exception e){
			infantWs= 0;
		}

		try{
			student = Integer.parseInt(request.getParameter("student"));
		}catch(Exception e){
			student= 0;
		}
		
		try{
			youths = Integer.parseInt(request.getParameter("youths"));
		}catch(Exception e){
			youths= 0;
		}

		try{
			senior = Integer.parseInt(request.getParameter("senior"));
		}catch(Exception e){
			senior= 0;
		}
		
		int totalAdults = 1;
		try{
			totalAdults = adult+student+youths+senior;
		}catch(Exception e){
			totalAdults = 2;
		}
		
		System.out.println(" Origin :: "+origin);
		System.out.println(" Destination :: "+destination);
		System.out.println(" DepartDate :: "+departDate);
		System.out.println(" ReturnDate :: "+returnDate);
		System.out.println(" TripType :: "+tripType);
		System.out.println(" CabinClass :: "+cabinClass);
		System.out.println(" Utm_source :: "+utm_source);
		System.out.println(" Adult :: "+adult);
		System.out.println(" Child :: "+child);
		System.out.println(" Infant :: "+infant);
		System.out.println(" InfantWs :: "+infantWs);
		System.out.println(" Student :: "+student);
		System.out.println(" Youths :: "+youths);
		System.out.println(" Senior :: "+senior);
		System.out.println(" TotalAdults :: "+totalAdults);
		
		flightSearch.setOrigin(restService.getAirportList(origin).get(0));
		flightSearch.setDestination(restService.getAirportList(destination).get(0));
		flightSearch.setDepartDate(departDate);
		flightSearch.setReturnDate(returnDate);
		flightSearch.setTripType(tripType);
		flightSearch.setAdult(totalAdults);
		flightSearch.setChild(child);
		flightSearch.setInfant(infant);
		flightSearch.setInfantWs(infantWs);
		flightSearch.setCabin(cabinClass);
		flightSearch.setAirline("");
		flightSearch.setPageAirline(""); 
		flightSearch.setOrigin2("");flightSearch.setOrigin3("");flightSearch.setOrigin4("");flightSearch.setOrigin5("");flightSearch.setOrigin6("");
		flightSearch.setDestination2("");flightSearch.setDestination3("");flightSearch.setDestination4("");flightSearch.setDestination5("");flightSearch.setDestination6("");
		flightSearch.setDepartDate2("");flightSearch.setDepartDate3("");flightSearch.setDepartDate4("");flightSearch.setDepartDate5("");flightSearch.setDepartDate6("");
		
		FlightRequest searchRequest = new FlightRequest();
		searchRequest.setAdults(adult);
		searchRequest.setChild(child);
		searchRequest.setInfants(infant);
		searchRequest.setInfantsWs(infantWs);
		searchRequest.setSearchID(Utility.getAlphaNumericString(15));
		searchRequest.setSiteId(siteId);
		searchRequest.setTripType(1);

		List<Segment> segment = new ArrayList<Segment>();
		Segment departSegment = new Segment();
		departSegment.setOriginAirport(origin);
		departSegment.setDestinationAirport(destination);
		departSegment.setTravelDate(departDate);
		segment.add(departSegment);

		try 
		{
			if(Integer.parseInt(tripType)==2){
				Segment returnSegment = new Segment();
				returnSegment.setOriginAirport(destination);
				returnSegment.setDestinationAirport(origin);
				returnSegment.setTravelDate(returnDate);
				segment.add(returnSegment);
				searchRequest.setTripType(2);
			}
		} catch (Exception e) {
		}
		
		searchRequest.setSegment(segment);
		
		String userBrowserDetails="userBrowserDetails";
		String device = "";
		try {
			UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
			userBrowserDetails=userAgent.getOperatingSystem()+"-"+userAgent.getBrowser()+"-"+userAgent.getBrowserVersion();
			device = userAgent.getOperatingSystem().getDeviceType().getName();
			if(device.equalsIgnoreCase("Computer")){
				device="Desktop";
			}
		} catch (Exception e1) {
			userBrowserDetails = request.getHeader("user-agent");
		}
		
		searchRequest.setUserIP(request.getRemoteAddr());
		searchRequest.setDevice(device);
		searchRequest.setSource(utm_source);	//cheapflights
		searchRequest.setBrowser(userBrowserDetails); 
		searchRequest.setAirline("All");
		searchRequest.setCurrencyCode(currency);
		searchRequest.setFlexibleSearch(false);
		searchRequest.setIsNearBy(false);
		searchRequest.setLimit(200);
		searchRequest.setLocale("en");
		searchRequest.setMedia(utm_source);
		searchRequest.setRID("");
		searchRequest.setSearchDirectFlight(false);
		searchRequest.setServerIP("");
		searchRequest.setSID("");
		searchRequest.setSiteId(siteId);
		searchRequest.setClient(2);
		searchRequest.setCabinType(Utility.getCabinId(cabinClass)); 

		try 
		{
			System.out.println(" FlightsMetaController :: SearchRequest After Making:: "+new ObjectMapper().writeValueAsString(searchRequest));
		} 
		catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		//////// Call API Click Tracker ////////
		
		try
		{
			ClickTrackerRequest clickRequest = new ClickTrackerRequest();
			clickRequest.setSiteId(String.valueOf(siteId));
			clickRequest.setLanding_url("result");
			clickRequest.setDevice(device);
			clickRequest.setSourceMedia(utm_source);
			clickRequest.setClick_tracker("kayak");
			clickRequest.setPrice("0.00");
			clickRequest.setUserIP(request.getRemoteAddr());
			clickRequest.setOrigin(origin);
			clickRequest.setDestination(destination);
			
			try
			{
				System.out.println(" FlightsMetaController::DeepLink::ClickTrackerRequest For [ " +utm_source+" ] "+new ObjectMapper().writeValueAsString(clickRequest));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String clickResponse = flightService.clickTrackerSave(clickRequest);
			System.out.println("FlightsMetaController::ClickResponse :: "+clickResponse);

		}catch(Exception e){
			System.out.println(" =========== Error in ClickTrackerSave ========== ");
			e.printStackTrace();
		}
		
		model.addAttribute("flightSearch", flightSearch);
		model.addAttribute("flightRequest", searchRequest);
		request.getSession().setAttribute("flightSearch", flightSearch);
		request.getSession().setAttribute("flightRequest", searchRequest);
		
		System.out.println("utm_source::"+utm_source);
		
		if(utm_source.equalsIgnoreCase("skyscanner")){ 
			System.out.println("utm_source:: insider");
			mv = new ModelAndView("skyscanner_deeplink");
		}else{
			System.out.println("utm_source:: outer");
			mv = new ModelAndView("flightDeepLinkPage");
		}

		return mv;
	}

}
