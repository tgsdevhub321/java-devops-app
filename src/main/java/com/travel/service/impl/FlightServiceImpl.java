package com.travel.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.travel.bean.FlightSearch;
import com.travel.object.ClickTrackerRequest;
import com.travel.object.ancillaryServices.AncillaryProduct;
import com.travel.object.bookingrequest.BookingRequest;
import com.travel.object.bookingrequest.BundleOption;
import com.travel.object.bookingresponse.BookingResponse;
import com.travel.object.deal.DealRequest;
import com.travel.object.deal.DealResponse;
import com.travel.object.fareRules.CheckFareRules;
import com.travel.object.flightresponse.OtherBound;
import com.travel.object.searchRequest.FlightRequest;
import com.travel.object.searchRequest.Segment;
import com.travel.service.FlightService;
import com.travel.service.RestDataService;
import com.travel.utility.Utility;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import eu.bitwalker.useragentutils.UserAgent;
import com.travel.object.ancillaryServices.Services;

@Service
public class FlightServiceImpl implements FlightService{

	@Value("${siteName}")
	private String siteName;

	@Value("${siteId}")
	private int siteId;

	@Value("${currency}")
	private String currency;

	@Value("${apiUrl}")
	private String apiUrl;
	
	@Value("${flightAPiUrl}")
	private String flightAPiUrl;

	@Value("${password}")
	private String password;
	
	@Value("${flightMetaAPIUrl}")
	private String flightMetaAPIUrl;
	
	@Autowired
	RestDataService restService;
	
	@Override
	public FlightRequest getFlightSearchRequest(FlightSearch flightSearch,HttpServletRequest request,String searchId) {

		FlightRequest flightRequest =new FlightRequest();
		List<Segment> segment = new ArrayList<Segment>();
		Segment departSegment = new Segment();
		if(flightSearch.getOrigin().length() == 3){
			flightSearch.setOrigin(restService.getAirportList(flightSearch.getOrigin()).get(0));
		}
		if(flightSearch.getDestination().length() == 3){
			flightSearch.setDestination(restService.getAirportList(flightSearch.getDestination()).get(0));
		}
		
		//System.out.println("flightSearch.getOrigin():: "+flightSearch.getOrigin());
		//System.out.println("flightSearch.getDestination():: "+flightSearch.getDestination());
		
		departSegment.setOriginAirport(flightSearch.getOrigin().substring(0, flightSearch.getOrigin().indexOf("-")));
		departSegment.setDestinationAirport(flightSearch.getDestination().substring(0, flightSearch.getDestination().indexOf("-")));
		//departSegment.setOriginCountry(flightSearch.getOrigin().substring(flightSearch.getOrigin().lastIndexOf("-")+1));
		//departSegment.setDestinationCountry(flightSearch.getDestination().substring(flightSearch.getDestination().lastIndexOf("-")+1));
		
		departSegment.setTravelDate(flightSearch.getDepartDate());
		segment.add(departSegment);
		if(flightSearch.getTripType().equalsIgnoreCase("2")){
			Segment returnSegment = new Segment();
			returnSegment.setOriginAirport(flightSearch.getDestination().substring(0, flightSearch.getDestination().indexOf("-")));
			returnSegment.setDestinationAirport(flightSearch.getOrigin().substring(0, flightSearch.getOrigin().indexOf("-")));
			//departSegment.setOriginCountry(flightSearch.getOrigin().substring(flightSearch.getOrigin().lastIndexOf("-")+1));
			//departSegment.setDestinationCountry(flightSearch.getDestination().substring(flightSearch.getDestination().lastIndexOf("-")+1));
			
			returnSegment.setTravelDate(flightSearch.getReturnDate());
			segment.add(returnSegment);
		}
		else if(flightSearch.getTripType().equalsIgnoreCase("3")){

			Segment segment2 = new Segment();
			segment2.setOriginAirport(flightSearch.getOrigin2().substring(0, flightSearch.getOrigin2().indexOf("-")));
			segment2.setDestinationAirport(flightSearch.getDestination2().substring(0, flightSearch.getDestination2().indexOf("-")));
			
			//departSegment.setOriginCountry(flightSearch.getOrigin2().substring(flightSearch.getOrigin2().lastIndexOf("-")+1));
			//departSegment.setDestinationCountry(flightSearch.getDestination2().substring(flightSearch.getDestination2().lastIndexOf("-")+1));
			
			segment2.setTravelDate(flightSearch.getDepartDate2());
			segment.add(segment2);
			if(flightSearch.getOrigin3() != null){
				Segment segment3 = new Segment();
				segment3.setOriginAirport(flightSearch.getOrigin3().substring(0, flightSearch.getOrigin3().indexOf("-")));
				segment3.setDestinationAirport(flightSearch.getDestination3().substring(0, flightSearch.getDestination3().indexOf("-")));
				segment3.setTravelDate(flightSearch.getDepartDate3());
				
				//departSegment.setOriginCountry(flightSearch.getOrigin3().substring(flightSearch.getOrigin3().lastIndexOf("-")+1));
				//departSegment.setDestinationCountry(flightSearch.getDestination3().substring(flightSearch.getDestination3().lastIndexOf("-")+1));
				
				segment.add(segment3);
				//System.out.println("4: " +flightSearch.getOrigin4());
				if(flightSearch.getOrigin4() != null && flightSearch.getOrigin4() != ""){
					Segment segment4 = new Segment();
					segment4.setOriginAirport(flightSearch.getOrigin4().substring(0, flightSearch.getOrigin4().indexOf("-")));
					segment4.setDestinationAirport(flightSearch.getDestination4().substring(0, flightSearch.getDestination4().indexOf("-")));
					segment4.setTravelDate(flightSearch.getDepartDate4());
					
					//departSegment.setOriginCountry(flightSearch.getOrigin4().substring(flightSearch.getOrigin4().lastIndexOf("-")+1));
					//departSegment.setDestinationCountry(flightSearch.getDestination4().substring(flightSearch.getDestination4().lastIndexOf("-")+1));
					
					segment.add(segment4);
					if(flightSearch.getOrigin5() != null && flightSearch.getOrigin5() != ""){
						Segment segment5 = new Segment();
						segment5.setOriginAirport(flightSearch.getOrigin5().substring(0, flightSearch.getOrigin5().indexOf("-")));
						segment5.setDestinationAirport(flightSearch.getDestination5().substring(0, flightSearch.getDestination5().indexOf("-")));
						segment5.setTravelDate(flightSearch.getDepartDate5());
						
						//departSegment.setOriginCountry(flightSearch.getOrigin5().substring(flightSearch.getOrigin5().lastIndexOf("-")+1));
						//departSegment.setDestinationCountry(flightSearch.getDestination5().substring(flightSearch.getDestination5().lastIndexOf("-")+1));
						
						segment.add(segment5);
						if(flightSearch.getOrigin6() != null && flightSearch.getOrigin6() != ""){
							Segment segment6 = new Segment();
							segment6.setOriginAirport(flightSearch.getOrigin6().substring(0, flightSearch.getOrigin6().indexOf("-")));
							segment6.setDestinationAirport(flightSearch.getDestination6().substring(0, flightSearch.getDestination6().indexOf("-")));
							segment6.setTravelDate(flightSearch.getDepartDate6());
							
							//departSegment.setOriginCountry(flightSearch.getOrigin6().substring(flightSearch.getOrigin6().lastIndexOf("-")+1));
							//departSegment.setDestinationCountry(flightSearch.getDestination6().substring(flightSearch.getDestination6().lastIndexOf("-")+1));
							
							segment.add(segment6);
						}
					}
				}
			}
		}
		
		flightRequest.setClient(siteId);
		flightRequest.setAdults(flightSearch.getAdult());
		flightRequest.setAirline("All");
		String userBrowserDetails="userBrowserDetails";
		String device = "";
		try 
		{
			UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
			userBrowserDetails=userAgent.getOperatingSystem()+"-"+userAgent.getBrowser()+"-"+userAgent.getBrowserVersion();
			device = userAgent.getOperatingSystem().getDeviceType().getName();
		} catch (Exception e1) {
			userBrowserDetails = request.getHeader("user-agent");
		}
		
		flightRequest.setBrowser(userBrowserDetails);
		flightRequest.setCabinType(Utility.getCabinId(flightSearch.getCabin()));
		flightRequest.setChild(flightSearch.getChild());
		flightRequest.setCurrencyCode(currency);
		flightRequest.setDevice(device);
		flightRequest.setFlexibleSearch(false);
		flightRequest.setInfants(flightSearch.getInfant());
		flightRequest.setInfantsWs(flightSearch.getInfantWs());
		flightRequest.setIsNearBy(false);
		flightRequest.setLimit(200);
		flightRequest.setLocale("en");
		flightRequest.setMedia(flightSearch.getUtmSource());	//siteName
		flightRequest.setRID("");
		flightRequest.setSearchDirectFlight(flightSearch.isDirectFlight());
		flightRequest.setSearchID(searchId);
		flightRequest.setSegment(segment);
		flightRequest.setServerIP("");
		flightRequest.setSID("");
		flightRequest.setSiteId(siteId);
		flightRequest.setSource(flightSearch.getUtmSource());	//"Online"
		flightRequest.setTripType(Integer.parseInt(flightSearch.getTripType()));
		flightRequest.setUserIP(request.getRemoteAddr());
		
		try
		{
			System.out.println(" FlightServiceImpl:: FlightSearchRequest JSON :: "+new ObjectMapper().writeValueAsString(flightRequest));
		}
		catch(Exception e){}
		
		return flightRequest;

	}
	
	@Override
	public String getFlightSearchResponse(FlightRequest flightRequest) {
		System.out.println(" FlightServiceImpl :: getFlightSearchResponse Method"); 
		ObjectMapper mapper = new ObjectMapper();
		try
		{
			System.out.println("FlightServiceImpl::FlightRequest JSON :: "+mapper.writeValueAsString(flightRequest));
		} 
		catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		RestTemplate rest = new RestTemplate();
		String res = rest.postForObject(flightAPiUrl+"/flightSearchs?authcode="+password, flightRequest, String.class);
		System.out.println(" FlightServiceImpl :: FlightSearchResponse::"+res);
		return res; 
	}
	
	@Override
	public BookingRequest getMetaBookingRequest(BookingRequest bookingRequest) {
		RestTemplate rest = new RestTemplate();
		bookingRequest.setSiteID(siteId);
		bookingRequest.setCurrencyCode(currency);

		ObjectMapper mapper = new ObjectMapper();
		try
		{
			System.out.println("BookingRequest JSON :: "+mapper.writeValueAsString(bookingRequest));
		} 
		catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		System.out.println("FlightServiceImpl:: API URL :: "+flightMetaAPIUrl+"/metaBookingRequest?authcode="+password);  
		String paymentRS = rest.postForObject(flightMetaAPIUrl+"/metaBookingRequest?authcode="+password, bookingRequest, String.class);
		System.out.println("FlightServiceImpl :: getMetaPaymentResponse:: "+paymentRS);
		
		try 
		{
			bookingRequest = mapper.readValue(paymentRS, BookingRequest.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try
		{
			System.out.println("FlightServiceImpl :: BookingRequest Response JSON :: "+mapper.writeValueAsString(bookingRequest));
		} 
		catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return bookingRequest; 
	}

	@Override
	public FlightRequest getFlightDeepSearchRequest(HttpServletRequest request,String type, String origin, String destination,String origin1, String destination1, List<List<OtherBound>> otherBounds, int adults, int children, int infants, int infantws, String departure, String retu, String cabin, String utm_source, String utm_medium) {

		System.out.println("FlightServiceImpl :: getFlightDeepSearchRequest Caling.....");

		FlightRequest flightRequest =new FlightRequest();
		List<Segment> segment = new ArrayList<Segment>();
		Segment departSegment = new Segment();

		departSegment.setOriginAirport(origin);
		departSegment.setDestinationAirport(destination);
		departSegment.setTravelDate(departure);
		segment.add(departSegment);

		if(type.equalsIgnoreCase("RT") || type.equalsIgnoreCase("RoundTrip") || type.equalsIgnoreCase("OpenJaw") || type.equalsIgnoreCase("MultiCity")){
			Segment returnSegment = new Segment();
			returnSegment.setOriginAirport(origin1);
			returnSegment.setDestinationAirport(destination1);
			returnSegment.setTravelDate(retu);
			segment.add(returnSegment);
		}

		if(type.equalsIgnoreCase("MultiCity")){
			for (int i = 0; i < otherBounds.size(); i++) {
				String originMc="";
				String destinationMc="";
				String departureDate="";
				for (int j = 0; j < otherBounds.get(i).size(); j++) {
					if(j==0){
						originMc=otherBounds.get(i).get(j).getFromAirport();
						departureDate=otherBounds.get(i).get(j).getDepDate();
						//System.out.println("departureDate11111>>"+departureDate);
					}
					destinationMc=otherBounds.get(i).get(j).getToAirport();
				}
				Segment returnSegment = new Segment();
				returnSegment.setOriginAirport(originMc);
				returnSegment.setDestinationAirport(destinationMc);
				//	System.out.println("departureDate22222>>"+departureDate);
				returnSegment.setTravelDate(Utility.googleDateformat(departureDate));
				segment.add(returnSegment);
			}
		}

		try
		{
			System.out.println("FlightServiceImpl:: getFlightDeepSearchRequest :: Segment:: "+new ObjectMapper().writeValueAsString(segment));
		}
		catch(Exception e){}
		
		flightRequest.setClient(siteId);
		flightRequest.setAdults(adults);
		flightRequest.setAirline("All");
		String userBrowserDetails="userBrowserDetails";
		String device = "";
		try 
		{
			UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
			userBrowserDetails=userAgent.getOperatingSystem()+"-"+userAgent.getBrowser()+"-"+userAgent.getBrowserVersion();
			device = userAgent.getOperatingSystem().getDeviceType().getName();
		} catch (Exception e1) {
			userBrowserDetails = request.getHeader("user-agent");
		}

		flightRequest.setBrowser(userBrowserDetails);
		flightRequest.setCabinType(Utility.getCabinId(cabin));
		flightRequest.setChild(children);
		flightRequest.setCurrencyCode(currency);
		flightRequest.setDevice(device);
		flightRequest.setFlexibleSearch(false);
		flightRequest.setInfants(infants);
		flightRequest.setInfantsWs(infantws);
		flightRequest.setIsNearBy(false);
		flightRequest.setLimit(200);
		flightRequest.setLocale("en");
		flightRequest.setMedia("Google");
		flightRequest.setRID("");
		flightRequest.setSearchDirectFlight(false);
		flightRequest.setSearchID(Utility.getAlphaNumericString(16));
		flightRequest.setSegment(segment);
		flightRequest.setServerIP("");
		flightRequest.setSID("");
		flightRequest.setSiteId(siteId);
		flightRequest.setSource(utm_source);
		flightRequest.setMedia(utm_medium);
		flightRequest.setTripType(1);
		if(type.equalsIgnoreCase("RT")){
			flightRequest.setTripType(2);
		}
		if(type.equalsIgnoreCase("RoundTrip")){
			flightRequest.setTripType(2);
		}
		if(type.equalsIgnoreCase("OpenJaw")){
			flightRequest.setTripType(2);
		}
		if(type.equalsIgnoreCase("MultiCity")){
			flightRequest.setTripType(3);
		}
		flightRequest.setUserIP(request.getRemoteAddr());
		
		try
		{
			System.out.println("FlightServiceImpl:: getFlightDeepSearchRequest :: FlightSearchRequest:: "+new ObjectMapper().writeValueAsString(flightRequest));
		}
		catch(Exception e){}

		return flightRequest;

	}

	@Override
	public String getLiveFlightSearchResponse(BookingRequest bookingRequest) {
		RestTemplate rest = new RestTemplate();
		String res = rest.postForObject(flightAPiUrl+"/customerRequests?authcode="+password, bookingRequest, String.class);
		return res; 
	}

	@Override
	public DealResponse getDealList() {
		RestTemplate rest = new RestTemplate();
		ObjectMapper mapper = new ObjectMapper();
		DealRequest dealRequest = new DealRequest();
		dealRequest.setAirline("");
		dealRequest.setCabinClass("Y");
		dealRequest.setCityName("");
		dealRequest.setCountryCode("US");
		dealRequest.setCountryName("US");
		dealRequest.setCurrency("USD");
		dealRequest.setDepartDate("");
		dealRequest.setFroCity("");
		dealRequest.setPage("");
		dealRequest.setToCity("");
		dealRequest.setTripType("2");
		dealRequest.setSiteId("1");
		System.out.println(apiUrl+"/travelsite/deals?authcode="+password);
		String dealResStr = rest.postForObject(apiUrl+"/travelsite/deals?authcode="+password, dealRequest, String.class);
		System.out.println("DealResStr:: "+dealResStr);
		DealResponse dealResponse = null;
		try {
			dealResponse =	mapper.readValue(dealResStr, DealResponse.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dealResponse;
	}
	
	@Override
	public String getFlightFareRules(CheckFareRules checkFareRules) {
		RestTemplate rest = new RestTemplate();
		String fareRules = rest.postForObject(flightAPiUrl+"/GetFlightFareRule?authcode="+password, checkFareRules, String.class);
		//String fareRules = rest.postForObject(flightAPiUrl+"/GetFlightFareRuleTest?authcode="+password, checkFareRules, String.class);
		return fareRules;
	}

	@Override
	public String getFlightMetaCheck(CheckFareRules checkFareRules) {
		RestTemplate rest = new RestTemplate();
		System.out.println("GetFlightMetaCheck :: "+flightAPiUrl+"/GetFlightMetaCheck?authcode="+password);
		String fareRules = rest.postForObject(flightAPiUrl+"/GetFlightMetaCheck?authcode="+password, checkFareRules, String.class);
		return fareRules;
	}
	
	@Override
	public String clickTrackerSave(ClickTrackerRequest saveRecodrs) {
		RestTemplate rest = new RestTemplate();
		String saveRecodrRS = rest.postForObject(apiUrl+"/back-end/clickTracker?authcode="+password, saveRecodrs, String.class);
		System.out.println("ClickTrackerSave Response::"+saveRecodrRS);
		return saveRecodrRS;
	}
	
	@Override
	public BookingRequest saveBookingData(BookingRequest bookingRequest, FlightRequest searchRequest){
		
		ObjectMapper mapper = new ObjectMapper();
		List<AncillaryProduct> ancillaryProductList = new ArrayList<AncillaryProduct>();
		
		System.out.println("ChangeableTickets:: "+bookingRequest.getChangeableTickets());
		if(bookingRequest.getChangeableTickets().equalsIgnoreCase("Yes")){
			AncillaryProduct ancillariesObj = new AncillaryProduct();
			List<Services> serviceList = new ArrayList<Services>();
			ancillariesObj.setMostPopular(true);
			ancillariesObj.setFullName(bookingRequest.getChangeableTicketType()+" Ticket");
			ancillariesObj.setName("CT");
			ancillariesObj.setPrice(bookingRequest.getChangeableTicketAmount());
			ancillariesObj.setProductId(0);
			ancillariesObj.setSelectionType("Yes");
			ancillariesObj.setSupplierLookup("");
			ancillariesObj.setSupplierNumber("");
			ancillariesObj.setConditionList(serviceList);
			ancillaryProductList.add(ancillariesObj);
			bookingRequest.setAncillaryProduct(ancillaryProductList);
		}
		
		System.out.println("CancellationProtectTaken:: "+bookingRequest.getCancellationProtectTaken());
		if(bookingRequest.getCancellationProtectTaken().equalsIgnoreCase("Yes,Yes")){
			bookingRequest.setCancellationProtectTaken("Yes"); 
		}
		
		if(bookingRequest.getCancellationProtectTaken().equalsIgnoreCase("Yes")){
			AncillaryProduct ancillariesObj = new AncillaryProduct();
			List<Services> serviceList = new ArrayList<Services>();
			ancillariesObj.setMostPopular(true);
			ancillariesObj.setFullName("Cancellation Protect");
			ancillariesObj.setName("CP");
			ancillariesObj.setPrice(bookingRequest.getCancellationProtectAmount());
			ancillariesObj.setProductId(0);
			ancillariesObj.setSelectionType("Yes");
			ancillariesObj.setSupplierLookup("");
			ancillariesObj.setSupplierNumber("");
			ancillariesObj.setConditionList(serviceList);
			ancillaryProductList.add(ancillariesObj);
			bookingRequest.setAncillaryProduct(ancillaryProductList);
		}
		
		System.out.println("WebcheckinTaken:: "+bookingRequest.getWebcheckinTaken());
		if(bookingRequest.getWebcheckinTaken().equalsIgnoreCase("Yes")){
			AncillaryProduct ancillariesObj = new AncillaryProduct();
			List<Services> serviceList = new ArrayList<Services>();
			ancillariesObj.setMostPopular(true);
			ancillariesObj.setFullName("Web CheckIn");
			ancillariesObj.setName("WC");
			ancillariesObj.setPrice(bookingRequest.getWebcheckinAmount());
			ancillariesObj.setProductId(0);
			ancillariesObj.setSelectionType("Yes");
			ancillariesObj.setSupplierLookup("");
			ancillariesObj.setSupplierNumber("");
			ancillariesObj.setConditionList(serviceList);
			ancillaryProductList.add(ancillariesObj);
			bookingRequest.setAncillaryProduct(ancillaryProductList);
		}
		
		System.out.println("BundleFareTaken:: "+bookingRequest.getBundleFareTaken());
		String btaken = "No";
		try{
			btaken = bookingRequest.getBundleFareTaken();
		}catch(Exception e){
			btaken="No";
		}
		
		if(bookingRequest.getBundleFareTaken()==null || btaken.equalsIgnoreCase("No")){
			bookingRequest.setBundleFareTaken("No"); 
		}
		
		if(bookingRequest.getBundleFareTaken().equalsIgnoreCase("Yes")){
			
			System.out.println("BundleFareOptId::"+bookingRequest.getBundleFareOptId());
			System.out.println("BundleOfferId::"+bookingRequest.getBundleOfferId());
			System.out.println("BundleFareAmount::"+bookingRequest.getBundleFareAmount());
			
			String[] idval = bookingRequest.getBundleFareOptId().split(",");
			BundleOption bundleOption = new BundleOption();
			bundleOption.setBundleOfferId(bookingRequest.getBundleOfferId());
			bundleOption.setPrice(bookingRequest.getBundleFareAmount());
			bundleOption.setBundleType("bundle"); 
			List<String> productList = new ArrayList<String>();
			for (int i = 0; i < idval.length; i++) {
				productList.add(idval[i]);
			}
			bundleOption.setProducts(productList);
			bookingRequest.setBundleOption(bundleOption);
		}
		
		String staken = "No";
		try{
			staken = bookingRequest.getSingleFareTaken();
		}catch(Exception e){
			staken="No";
		}
		
		if(bookingRequest.getSingleFareTaken()==null || staken.equalsIgnoreCase("No")){
			bookingRequest.setSingleFareTaken("No"); 
		}
		
		System.out.println("SingleFareTaken:: "+bookingRequest.getSingleFareTaken());
		if(bookingRequest.getSingleFareTaken().equalsIgnoreCase("Yes")){
			
			System.out.println("BundleOfferId::"+bookingRequest.getBundleOfferId());
			System.out.println("SingleFareAmount::"+bookingRequest.getSingleFareAmount());
			System.out.println("SingleFareOptId::"+bookingRequest.getSingleFareOptId());
			
			String[] idval = bookingRequest.getSingleFareOptId().split(",");
			BundleOption bundleOption = new BundleOption();
			bundleOption.setBundleOfferId(bookingRequest.getBundleOfferId());
			bundleOption.setPrice(bookingRequest.getSingleFareAmount());
			bundleOption.setBundleType("single"); 
			List<String> productList = new ArrayList<String>();
			for (int i = 0; i < idval.length; i++) {
				productList.add(idval[i]);
			}
			
			bundleOption.setProducts(productList);
			bookingRequest.setBundleOption(bundleOption);
			
		}
		
		System.out.println("SurefundTaken:: "+bookingRequest.getSurefundTaken());
		if(bookingRequest.getSurefundTaken().equalsIgnoreCase("Yes")){
			AncillaryProduct ancillariesObj = new AncillaryProduct();
			List<Services> serviceList = new ArrayList<Services>();
			ancillariesObj.setMostPopular(true);
			ancillariesObj.setFullName("Surefund");
			ancillariesObj.setName("SF");
			ancillariesObj.setPrice(bookingRequest.getSurefundAmount());
			ancillariesObj.setProductId(0);
			ancillariesObj.setSelectionType("Yes");
			ancillariesObj.setSupplierLookup("");
			ancillariesObj.setSupplierNumber("");
			ancillariesObj.setConditionList(serviceList);
			ancillaryProductList.add(ancillariesObj);
			bookingRequest.setAncillaryProduct(ancillaryProductList);
		}
		
		try 
		{
			System.out.println("Booking Request Finally::" + mapper.writeValueAsString(bookingRequest));
		} 
		catch (JsonProcessingException e1) {
			e1.printStackTrace();
		}
		
		String apiUrls = flightAPiUrl+"/BookingProcess?authcode="+password;  
		RestTemplate restTemplate = new RestTemplate();
		String bookingRes = restTemplate.postForObject(apiUrls, bookingRequest, String.class);
		//String bookingRes ="{\"bookingID\":\"FA190237\",\"PNR\":\"X\",\"flightResut\":{\"resultId\":6,\"valCarrier\":\"UA\",\"fareType\":\"RP\",\"gdsType\":13,\"cabinClass\":1,\"fare\":{\"adultFare\":0.0,\"childFare\":0.0,\"infantFare\":0.0,\"infantWsFare\":0.0,\"adultTax\":291.22422900000004,\"childTax\":0.0,\"infantTax\":0.0,\"infantWsTax\":0.0,\"adultMarkup\":0.0,\"childMarkup\":0.0,\"infantMarkup\":0.0,\"infantWsMarkup\":0.0,\"bagFees\":0.0,\"grandTotal\":291.22422900000004,\"markupID\":68462,\"markupType\":\"us\",\"totalMarkup\":-565.0657709999999,\"grandOrgTotal\":856.29,\"baseFare\":198.07422900000006,\"totalTax\":93.14999999999998,\"supplierBaseFare\":0.0,\"supplierTotalTax\":0.0,\"XeRate\":1.0,\"noPax\":0,\"ttlCharge\":0.0,\"issueFees\":0.0,\"atlFee\":0.0,\"cardFee\":0.0,\"onlnProfit\":0.0,\"ccAgntFee\":0.0,\"agntProfit\":0.0,\"ttlProfit\":0.0},\"currencyCode\":\"USD\",\"outBound\":[{\"SequenceNumber\":\"5\",\"airline\":\"UA\",\"orgAirline\":\"UA\",\"flightID\":\"\",\"flightNo\":\"756\",\"equipmentType\":\"Boeing 737-800\",\"equipmentTypeDes\":\"Boeing 737-800\",\"fromAirport\":\"TPA\",\"depDate\":\"2025-02-12T16:13:00\",\"toAirport\":\"DEN\",\"reachDate\":\"2025-02-12T18:20:00\",\"opratingAirline\":\"UA\",\"resDesignCode\":\"Econom\",\"sliceAndDiceCode\":\"1\",\"fromTerminal\":\"NA\",\"toTerminal\":\"NA\",\"cabinClass\":1,\"eft\":247,\"layOverTime\":85,\"fareType\":\"RP\",\"isETicketEligible\":false,\"airlineName\":\"United Airlines\",\"fromAirportName\":\"Tampa International Airport\",\"orgdepDate\":\"2025-02-12T16:13:00\",\"toAirportName\":\"Denver International Airport\",\"orgreachDate\":\"2025-02-12T18:20:00\",\"froCityName\":\"Tampa\",\"toCityName\":\"Denver\"},{\"SequenceNumber\":\"5\",\"airline\":\"UA\",\"orgAirline\":\"UA\",\"flightID\":\"\",\"flightNo\":\"2644\",\"equipmentType\":\"Boeing 737-800\",\"equipmentTypeDes\":\"Boeing 737-800\",\"fromAirport\":\"DEN\",\"depDate\":\"2025-02-12T19:45:00\",\"toAirport\":\"PSP\",\"reachDate\":\"2025-02-12T21:09:00\",\"opratingAirline\":\"UA\",\"resDesignCode\":\"Econom\",\"sliceAndDiceCode\":\"1\",\"fromTerminal\":\"NA\",\"toTerminal\":\"NA\",\"cabinClass\":1,\"eft\":144,\"fareType\":\"RP\",\"isETicketEligible\":false,\"airlineName\":\"United Airlines\",\"fromAirportName\":\"Denver International Airport\",\"orgdepDate\":\"2025-02-12T19:45:00\",\"toAirportName\":\"Palm Springs International Airport\",\"orgreachDate\":\"2025-02-12T21:09:00\",\"froCityName\":\"Denver\",\"toCityName\":\"Palm Springs\"}],\"inBound\":[{\"SequenceNumber\":\"5\",\"airline\":\"UA\",\"orgAirline\":\"UA\",\"flightID\":\"\",\"flightNo\":\"6129\",\"equipmentType\":\" Embraer 170\",\"equipmentTypeDes\":\" Embraer 170\",\"fromAirport\":\"PSP\",\"depDate\":\"2025-02-15T12:12:00\",\"toAirport\":\"IAH\",\"reachDate\":\"2025-02-15T17:22:00\",\"opratingAirline\":\"UA\",\"resDesignCode\":\"Econom\",\"sliceAndDiceCode\":\"2\",\"fromTerminal\":\"NA\",\"toTerminal\":\"NA\",\"cabinClass\":1,\"eft\":190,\"layOverTime\":63,\"fareType\":\"RP\",\"isETicketEligible\":false,\"airlineName\":\"United Airlines\",\"fromAirportName\":\"Palm Springs International Airport\",\"orgdepDate\":\"2025-02-15T12:12:00\",\"toAirportName\":\"George Bush Intercontinental Houston Airport\",\"orgreachDate\":\"2025-02-15T17:22:00\",\"froCityName\":\"Palm Springs\",\"toCityName\":\"Houston\"},{\"SequenceNumber\":\"5\",\"airline\":\"UA\",\"orgAirline\":\"UA\",\"flightID\":\"\",\"flightNo\":\"2093\",\"equipmentType\":\"Boeing 737-800\",\"equipmentTypeDes\":\"Boeing 737-800\",\"fromAirport\":\"IAH\",\"depDate\":\"2025-02-15T18:25:00\",\"toAirport\":\"TPA\",\"reachDate\":\"2025-02-15T21:36:00\",\"opratingAirline\":\"UA\",\"resDesignCode\":\"Econom\",\"sliceAndDiceCode\":\"2\",\"fromTerminal\":\"NA\",\"toTerminal\":\"NA\",\"cabinClass\":1,\"eft\":131,\"fareType\":\"RP\",\"isETicketEligible\":false,\"airlineName\":\"United Airlines\",\"fromAirportName\":\"George Bush Intercontinental Houston Airport\",\"orgdepDate\":\"2025-02-15T18:25:00\",\"toAirportName\":\"Tampa International Airport\",\"orgreachDate\":\"2025-02-15T21:36:00\",\"froCityName\":\"Houston\",\"toCityName\":\"Tampa\"}],\"flightId\":\"651acab6-886b-4f31-865b-0d8524fe0d10\",\"outEFT\":391,\"inEFT\":321,\"maxSeat\":9,\"airline\":\"UA\",\"bagOptionRef\":[1],\"booking_token\":\"H4sIAAAAAAAEAE3OwQqCQBAG4FcpFjy5MDO2pv9pOxSeQqwHaCHBIEKw4_Kzt6vEypz_n4_ZOVu2tMy9Pc3trZ2FxGgWTfKIMdZrZUJlNVu1V_pPdlyCC59iBSH-HZ1-9p8tq3EwiQmD6kj8OI0rMwsTsPgUjxCJxL-csGXhikksbCvKSOJhlWUX95768CUqQyQAAV2Tdw2u_TL4AT3K6ZT1AAAA\"},\"adults\":1,\"child\":0,\"infants\":0,\"infantsWs\":0,\"paymentDetails\":{\"cardCode\":\"Visa\",\"cardNumber\":\"4270825047343533\",\"cardHolderName\":\"Savannah A Baker\",\"expiryMonth\":\"1\",\"expiryYear\":\"2030\",\"cvvNo\":\"440\",\"country\":\"US\",\"address1\":\"28520 183rd Street\",\"address2\":\"\",\"city\":\"Leavenworth\",\"state\":\",KS\",\"postalCode\":\"66048\",\"maskCardNumber\":\"************3533\",\"amount\":0.0},\"passengerDetails\":[{\"passengerType\":1,\"title\":\"Miss\",\"firstName\":\"Amy\",\"middleName\":\"Lynn \",\"lastName\":\"Baker\",\"dateOfBirth\":\"1996-5-5\",\"gender\":2,\"dobDay\":\"5\",\"dateOfMonth\":\"5\",\"dateOfYear\":\"1996\",\"contactName\":\"\",\"contactNumber\":\"\",\"tsaPrecheck\":\"\",\"reDressNumber\":\"\"}],\"ispriceChange\":false,\"newPrice\":0.0,\"isCcv\":false,\"bookingStatus\":\"Failure\",\"responseStatus\":{\"status\":0,\"messege\":\"AUTH FAILURE\"},\"IsTimeChanged\":false,\"isticketeRun\":0,\"isticketeRunRet\":0}";
		System.out.println("Booking Response:: " + bookingRes);
		
		BookingResponse bookingResponse = null; 
		try
		{
			bookingResponse = mapper.readValue(bookingRes, BookingResponse.class);
			bookingRequest.setBookingID(bookingResponse.getBookingID());
			bookingRequest.setBookingStatus(bookingResponse.getBookingStatus()); 
		}
		catch(Exception e){

		}
		
		return bookingRequest;
		
	}
}