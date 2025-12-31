package com.travel.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.travel.object.bookingrequest.BookingRequest;
import com.travel.object.bookingrequest.PassengerDetail;
import com.travel.object.confirmationDB.*;
import com.travel.object.flightresponse.Fare;
import com.travel.object.flightresponse.FlightResult;
import com.travel.object.flightresponse.InBound;
import com.travel.object.flightresponse.OutBound;
import com.travel.service.ConfirmationDBService;

@Service
public class ConfirmationDBServiceImpl implements ConfirmationDBService
{	
	@Value("${password}")
	private String password;

	@Value("${siteId}")
	private int siteId;

	@Value("${apiUrl}")
	private String apiUrl;	
	
	@Override
	public BookingRequest getConfirmationService(BookingRequest bookingRequestNew, String sessionId){

		RestTemplate restTemplate = new RestTemplate();
		ObjectMapper mapper = new ObjectMapper();

		ConfirmationDBRequest confirmationDBObj = new ConfirmationDBRequest();  
		confirmationDBObj.setReferenceNum(sessionId);
		confirmationDBObj.setSiteId(siteId);
		//confirmationDBObj.setSiteId(12);

		try 
		{
			System.out.println("ConfirmationBooking Request Finally::" + mapper.writeValueAsString(confirmationDBObj));
		} 
		catch (JsonProcessingException e1) {
			e1.printStackTrace();
		}

		String confURL = apiUrl+"/booking-data/confirmation?authcode="+password;
		System.out.println("ConfirmURL:: "+confURL);

		String confirmationData= restTemplate.postForObject(confURL, confirmationDBObj,String.class);
		System.out.println("New Booking DB-Data Response :--"+confirmationData);

		ConfirmationResponse confirmationResponse = new ConfirmationResponse();
		try
		{
			confirmationResponse = mapper.readValue(confirmationData, ConfirmationResponse.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		FlightResult flightResultObj = new FlightResult();

		bookingRequestNew.setAdults(confirmationResponse.getResponse().getAdults());
		bookingRequestNew.setChild(confirmationResponse.getResponse().getChild());
		bookingRequestNew.setInfants(confirmationResponse.getResponse().getInfants());
		bookingRequestNew.setInfantsWs(confirmationResponse.getResponse().getInfantsWs());
		bookingRequestNew.setSearchID(confirmationResponse.getResponse().getSearchID());
		bookingRequestNew.setBookingID(confirmationResponse.getResponse().getBookingID());
		bookingRequestNew.setDepartDate(confirmationResponse.getResponse().getDepartDate());

		flightResultObj.setValCarrier(confirmationResponse.getResponse().getFlightResult().getValCarrier());
		flightResultObj.setFareType(confirmationResponse.getResponse().getFlightResult().getFareType());
		flightResultObj.setGdsType(confirmationResponse.getResponse().getFlightResult().getGdsType());
		flightResultObj.setCabinClass(confirmationResponse.getResponse().getFlightResult().getCabinClass());
		flightResultObj.setCurrencyCode(confirmationResponse.getResponse().getApiCurrencyCode());

		Fare fareObj =new Fare();

		fareObj.setAdultFare(confirmationResponse.getResponse().getFlightResult().getFare().getAdultFare());
		fareObj.setChildFare(confirmationResponse.getResponse().getFlightResult().getFare().getChildFare());
		fareObj.setInfantFare(confirmationResponse.getResponse().getFlightResult().getFare().getInfantFare());
		fareObj.setInfantWsFare(confirmationResponse.getResponse().getFlightResult().getFare().getInfantWsFare());

		fareObj.setAdultTax(confirmationResponse.getResponse().getFlightResult().getFare().getAdultTax());
		fareObj.setChildTax(confirmationResponse.getResponse().getFlightResult().getFare().getChildTax());
		fareObj.setInfantTax(confirmationResponse.getResponse().getFlightResult().getFare().getInfantTax());
		fareObj.setInfantWsTax(confirmationResponse.getResponse().getFlightResult().getFare().getInfantWsTax());

		fareObj.setAdultMarkup(confirmationResponse.getResponse().getFlightResult().getFare().getAdultMarkup());
		fareObj.setChildMarkup(confirmationResponse.getResponse().getFlightResult().getFare().getChildMarkup());
		fareObj.setInfantMarkup(confirmationResponse.getResponse().getFlightResult().getFare().getInfantMarkup());
		fareObj.setInfantWsMarkup(confirmationResponse.getResponse().getFlightResult().getFare().getInfantWsMarkup());

		fareObj.setBagFees(confirmationResponse.getResponse().getFlightResult().getFare().getBagFees());
		fareObj.setGrandTotal(confirmationResponse.getResponse().getFlightResult().getFare().getGrandTotal());
		fareObj.setMarkupID(confirmationResponse.getResponse().getFlightResult().getFare().getMarkupID());
		fareObj.setMarkupType(confirmationResponse.getResponse().getFlightResult().getFare().getMarkupType());
		fareObj.setTotalMarkup(confirmationResponse.getResponse().getFlightResult().getFare().getTotalMarkup());
		//fareObj.setGrandOrgTotal(confirmationResponse.getResponse().getFlightResult().getFare().getGrandOrgTotal());
		fareObj.setBaseFare(confirmationResponse.getResponse().getFlightResult().getFare().getBaseFare());
		fareObj.setTotalTax(confirmationResponse.getResponse().getFlightResult().getFare().getTotalTax());
		fareObj.setXeRate(confirmationResponse.getResponse().getFlightResult().getFare().getXeRate());

		int ancSize = 0;
		try
		{
			ancSize = confirmationResponse.getResponse().getAncillaryProduct().size();
		}catch(Exception e){
			ancSize = 0;
		}

		String changeableTickets = "No";
		String cancellationProtectTaken = "No";
		String webcheckinTaken = "No";
		String surefundTaken = "No";
		String changeableTicketType = "";
		double ctPrice=0.00;
		double cpPrice=0.00;
		double wcPrice=0.00;
		double sfPrice=0.00;
		if(ancSize>0){
			for (int i = 0; i < confirmationResponse.getResponse().getAncillaryProduct().size(); i++) {
				if(confirmationResponse.getResponse().getAncillaryProduct().get(i).getName().contains("CT")){
					changeableTickets = "Yes";
					ctPrice = confirmationResponse.getResponse().getAncillaryProduct().get(i).getPrice();
					changeableTicketType = confirmationResponse.getResponse().getAncillaryProduct().get(i).getFullName();
				}

				if(confirmationResponse.getResponse().getAncillaryProduct().get(i).getName().contains("CP")){
					cancellationProtectTaken = "Yes";
					cpPrice = confirmationResponse.getResponse().getAncillaryProduct().get(i).getPrice();
				}

				if(confirmationResponse.getResponse().getAncillaryProduct().get(i).getName().contains("WC")){
					webcheckinTaken = "Yes";
					wcPrice = confirmationResponse.getResponse().getAncillaryProduct().get(i).getPrice();
				}

				if(confirmationResponse.getResponse().getAncillaryProduct().get(i).getName().contains("SF")){
					surefundTaken = "Yes";
					sfPrice = confirmationResponse.getResponse().getAncillaryProduct().get(i).getPrice();
				}
			}
		}

		bookingRequestNew.setChangeableTickets(changeableTickets);
		bookingRequestNew.setChangeableTicketType(changeableTicketType);
		bookingRequestNew.setCancellationProtectTaken(cancellationProtectTaken);
		bookingRequestNew.setWebcheckinTaken(webcheckinTaken);
		bookingRequestNew.setChangeableTicketAmount(ctPrice);
		bookingRequestNew.setCancellationProtectAmount(cpPrice);
		bookingRequestNew.setWebcheckinAmount(wcPrice);
		bookingRequestNew.setSurefundAmount(sfPrice);
		bookingRequestNew.setSurefundTaken(surefundTaken);

		double grandOrgTotal = confirmationResponse.getResponse().getFlightResult().getFare().getGrandOrgTotal();
		if(ctPrice>0){

			double ct_usd = ctPrice/confirmationResponse.getResponse().getFlightResult().getFare().getXeRate();
			grandOrgTotal = grandOrgTotal+ct_usd;
		}

		if(cpPrice>0){
			double cp_usd = cpPrice/confirmationResponse.getResponse().getFlightResult().getFare().getXeRate();
			grandOrgTotal = grandOrgTotal+cp_usd;
		}

		if(wcPrice>0){
			double wc_usd = wcPrice/confirmationResponse.getResponse().getFlightResult().getFare().getXeRate();
			grandOrgTotal = grandOrgTotal+wc_usd;
		}

		if(sfPrice>0){
			double sf_usd = sfPrice/confirmationResponse.getResponse().getFlightResult().getFare().getXeRate();
			grandOrgTotal = grandOrgTotal+sf_usd;
		}
		fareObj.setGrandOrgTotal(grandOrgTotal);
		
		flightResultObj.setFare(fareObj);
		
		/*end ---- faretype*/

		List<OutBound> outBoundList = new ArrayList<OutBound>();
		List<InBound> inBoundList = new ArrayList<InBound>();
		OutBound outBoundObj = null;
		InBound inBoundObj = null;
		for(int i=0; i < confirmationResponse.getResponse().getFlightResult().getOutBound().size();i++)
		{	
			outBoundObj = new OutBound();
			outBoundObj.setAirline(confirmationResponse.getResponse().getFlightResult().getOutBound().get(i).getAirline());
			outBoundObj.setOrgAirline(confirmationResponse.getResponse().getFlightResult().getOutBound().get(i).getOrgAirline());
			outBoundObj.setFlightID(confirmationResponse.getResponse().getFlightResult().getOutBound().get(i).getFlightID());
			outBoundObj.setFlightNo(confirmationResponse.getResponse().getFlightResult().getOutBound().get(i).getFlightNo());
			outBoundObj.setEquipmentType(confirmationResponse.getResponse().getFlightResult().getOutBound().get(i).getEquipmentType());
			outBoundObj.setEquipmentTypeDes(confirmationResponse.getResponse().getFlightResult().getOutBound().get(i).getEquipmentTypeDes());
			outBoundObj.setFromAirport(confirmationResponse.getResponse().getFlightResult().getOutBound().get(i).getFromAirport());
			outBoundObj.setDepDate(confirmationResponse.getResponse().getFlightResult().getOutBound().get(i).getDepDate());
			outBoundObj.setToAirport(confirmationResponse.getResponse().getFlightResult().getOutBound().get(i).getToAirport());
			outBoundObj.setReachDate(confirmationResponse.getResponse().getFlightResult().getOutBound().get(i).getReachDate());
			outBoundObj.setOpratingAirline(confirmationResponse.getResponse().getFlightResult().getOutBound().get(i).getOpratingAirline());
			outBoundObj.setResDesignCode(confirmationResponse.getResponse().getFlightResult().getOutBound().get(i).getResDesignCode());
			outBoundObj.setFromTerminal(confirmationResponse.getResponse().getFlightResult().getOutBound().get(i).getFromTerminal());
			outBoundObj.setToTerminal(confirmationResponse.getResponse().getFlightResult().getOutBound().get(i).getToTerminal());
			outBoundObj.setCabinClass(confirmationResponse.getResponse().getFlightResult().getOutBound().get(i).getCabinClass());
			outBoundObj.setEft(confirmationResponse.getResponse().getFlightResult().getOutBound().get(i).getEft());
			outBoundObj.setEstimateTime(confirmationResponse.getResponse().getFlightResult().getOutBound().get(i).getEstimateTime());
			outBoundObj.setLayOverTime(confirmationResponse.getResponse().getFlightResult().getOutBound().get(i).getLayOverTime());
			outBoundObj.setFareType(confirmationResponse.getResponse().getFlightResult().getOutBound().get(i).getFareType());
			outBoundObj.setIsETicketEligible(confirmationResponse.getResponse().getFlightResult().getOutBound().get(i).getIsETicketEligible());
			outBoundObj.setAirlineName(confirmationResponse.getResponse().getFlightResult().getOutBound().get(i).getAirlineName());
			outBoundObj.setOrgdepDate(confirmationResponse.getResponse().getFlightResult().getOutBound().get(i).getOrgdepDate());
			outBoundObj.setReachDate(confirmationResponse.getResponse().getFlightResult().getOutBound().get(i).getReachDate());
			outBoundObj.setFromAirportName(confirmationResponse.getResponse().getFlightResult().getOutBound().get(i).getFromAirportName());
			outBoundObj.setToAirportName(confirmationResponse.getResponse().getFlightResult().getOutBound().get(i).getToAirportName());
			outBoundObj.setFroCityName(confirmationResponse.getResponse().getFlightResult().getOutBound().get(i).getFroCityName());
			outBoundObj.setToCityName(confirmationResponse.getResponse().getFlightResult().getOutBound().get(i).getToCityName());
			outBoundList.add(outBoundObj);
		}

		int inBoundSize = 0;
		try
		{
			inBoundSize = confirmationResponse.getResponse().getFlightResult().getInBound().size();
		}catch(Exception e){
			inBoundSize = 0;
		}
		
		if(inBoundSize>0){
			if(confirmationResponse.getResponse().getFlightResult().getInBound() !=null){
				for(int i=0; i < confirmationResponse.getResponse().getFlightResult().getInBound().size();i++)
				{	
					inBoundObj = new InBound();
					inBoundObj.setAirline(confirmationResponse.getResponse().getFlightResult().getInBound().get(i).getAirline());
					inBoundObj.setOrgAirline(confirmationResponse.getResponse().getFlightResult().getInBound().get(i).getOrgAirline());
					inBoundObj.setFlightID(confirmationResponse.getResponse().getFlightResult().getInBound().get(i).getFlightID());
					inBoundObj.setFlightNo(confirmationResponse.getResponse().getFlightResult().getInBound().get(i).getFlightNo());
					inBoundObj.setEquipmentType(confirmationResponse.getResponse().getFlightResult().getInBound().get(i).getEquipmentType());
					inBoundObj.setEquipmentTypeDes(confirmationResponse.getResponse().getFlightResult().getInBound().get(i).getEquipmentTypeDes());
					inBoundObj.setFromAirport(confirmationResponse.getResponse().getFlightResult().getInBound().get(i).getFromAirport());
					inBoundObj.setDepDate(confirmationResponse.getResponse().getFlightResult().getInBound().get(i).getDepDate());
					inBoundObj.setToAirport(confirmationResponse.getResponse().getFlightResult().getInBound().get(i).getToAirport());
					inBoundObj.setReachDate(confirmationResponse.getResponse().getFlightResult().getInBound().get(i).getReachDate());
					inBoundObj.setOpratingAirline(confirmationResponse.getResponse().getFlightResult().getInBound().get(i).getOpratingAirline());
					inBoundObj.setResDesignCode(confirmationResponse.getResponse().getFlightResult().getInBound().get(i).getResDesignCode());
					inBoundObj.setFromTerminal(confirmationResponse.getResponse().getFlightResult().getInBound().get(i).getFromTerminal());
					inBoundObj.setToTerminal(confirmationResponse.getResponse().getFlightResult().getInBound().get(i).getToTerminal());
					inBoundObj.setCabinClass(confirmationResponse.getResponse().getFlightResult().getInBound().get(i).getCabinClass());
					inBoundObj.setEft(confirmationResponse.getResponse().getFlightResult().getInBound().get(i).getEft());
					inBoundObj.setEstimateTime(confirmationResponse.getResponse().getFlightResult().getInBound().get(i).getEstimateTime());
					inBoundObj.setLayOverTime(confirmationResponse.getResponse().getFlightResult().getInBound().get(i).getLayOverTime());
					inBoundObj.setFareType(confirmationResponse.getResponse().getFlightResult().getInBound().get(i).getFareType());
					inBoundObj.setIsETicketEligible(confirmationResponse.getResponse().getFlightResult().getInBound().get(i).getIsETicketEligible());
					inBoundObj.setAirlineName(confirmationResponse.getResponse().getFlightResult().getInBound().get(i).getAirlineName());
					inBoundObj.setOrgdepDate(confirmationResponse.getResponse().getFlightResult().getInBound().get(i).getOrgdepDate());
					inBoundObj.setReachDate(confirmationResponse.getResponse().getFlightResult().getInBound().get(i).getReachDate());
					inBoundObj.setFromAirportName(confirmationResponse.getResponse().getFlightResult().getInBound().get(i).getFromAirportName());
					inBoundObj.setToAirportName(confirmationResponse.getResponse().getFlightResult().getInBound().get(i).getToAirportName());
					inBoundObj.setFroCityName(confirmationResponse.getResponse().getFlightResult().getInBound().get(i).getFroCityName());
					inBoundObj.setToCityName(confirmationResponse.getResponse().getFlightResult().getInBound().get(i).getToCityName());
					inBoundList.add(inBoundObj);
				}
			}
		}

		List<PassengerDetail> passengerDetailList = new ArrayList<PassengerDetail>();
		PassengerDetail passengerDetailObj = null;
		for(int i =0; i < confirmationResponse.getResponse().getPassengerDetails().size();i++)
		{
			passengerDetailObj = new PassengerDetail();
			passengerDetailObj.setPassengerType(confirmationResponse.getResponse().getPassengerDetails().get(i).getPassengerType());
			passengerDetailObj.setPassengerType(confirmationResponse.getResponse().getPassengerDetails().get(i).getPassengerType());
			passengerDetailObj.setFirstName(confirmationResponse.getResponse().getPassengerDetails().get(i).getFirstName());
			passengerDetailObj.setMiddleName(confirmationResponse.getResponse().getPassengerDetails().get(i).getMiddleName());
			passengerDetailObj.setLastName(confirmationResponse.getResponse().getPassengerDetails().get(i).getLastName());
			passengerDetailObj.setDateOfBirth(confirmationResponse.getResponse().getPassengerDetails().get(i).getDateOfBirth());
			passengerDetailObj.setGender(confirmationResponse.getResponse().getPassengerDetails().get(i).getGender());
			passengerDetailList.add(passengerDetailObj);
		}
		
		flightResultObj.setOutBound(outBoundList);
		flightResultObj.setInBound(inBoundList);
		
		int totalDepEft=0;
		int totalRtnEft=0;
		int totalDepLayOverTime=0;
		int totalRtnLayOverTime=0;
		int totalOutEft=0;
		int totalInEft=0;
		
		/*for (int k = 0; k < confirmationResponse.getResponse().getFlightResult().getOutBound().size(); k++) {
			totalDepLayOverTime += confirmationResponse.getResponse().getFlightResult().getOutBound().get(k).getLayOverTime();
			totalDepEft += confirmationResponse.getResponse().getFlightResult().getOutBound().get(k).getEft();
			totalOutEft = totalDepEft + totalDepLayOverTime;
		}
		
		if(inBoundSize>0){
			for (int k = 0; k < confirmationResponse.getResponse().getFlightResult().getInBound().size(); k++) {
				totalRtnLayOverTime += confirmationResponse.getResponse().getFlightResult().getInBound().get(k).getLayOverTime();
				totalRtnEft += confirmationResponse.getResponse().getFlightResult().getInBound().get(k).getEft();
				totalInEft = totalRtnEft+totalRtnLayOverTime;
			}
		}*/
		
		for(int k = 0; k < confirmationResponse.getResponse().getFlightResult().getOutBound().size(); k++) {
			Integer layOverTime = confirmationResponse.getResponse().getFlightResult().getOutBound().get(k).getLayOverTime();
			Integer eft = confirmationResponse.getResponse().getFlightResult().getOutBound().get(k).getEft();
			if (layOverTime != null) {
				totalDepLayOverTime += layOverTime;
			}
			if (eft != null) {
				totalDepEft += eft;
			}
		}
		totalOutEft = totalDepEft + totalDepLayOverTime;
		
		if(inBoundSize>0){
			for (int k = 0; k < confirmationResponse.getResponse().getFlightResult().getInBound().size(); k++) {
				Integer layOverTime = confirmationResponse.getResponse().getFlightResult().getInBound().get(k).getLayOverTime();
				Integer eft = confirmationResponse.getResponse().getFlightResult().getInBound().get(k).getEft();
				if(layOverTime != null) {
					totalRtnLayOverTime += layOverTime;
				}
				if(eft != null) {
					totalRtnEft += eft;
				}
			}
			totalInEft = totalRtnEft + totalRtnLayOverTime;
		}
		
		flightResultObj.setOutEFT(totalOutEft);
		flightResultObj.setInEFT(totalInEft);
		flightResultObj.setMaxSeat(confirmationResponse.getResponse().getFlightResult().getMaxSeat());
		flightResultObj.setAirline(confirmationResponse.getResponse().getFlightResult().getAirline());
		
		bookingRequestNew.setFlightResult(flightResultObj);
		bookingRequestNew.setPassengerDetails(passengerDetailList);

		bookingRequestNew.setPhoneNo(confirmationResponse.getResponse().getPhoneNo());
		bookingRequestNew.setMobileNo(confirmationResponse.getResponse().getMobileNo());
		bookingRequestNew.setEmailID(confirmationResponse.getResponse().getEmailID());

		bookingRequestNew.setAdults(confirmationResponse.getResponse().getAdults());
		bookingRequestNew.setChild(confirmationResponse.getResponse().getChild());
		bookingRequestNew.setInfants(confirmationResponse.getResponse().getInfants());
		bookingRequestNew.setInfantsWs(confirmationResponse.getResponse().getInfantsWs());
		bookingRequestNew.setSourceMedia(confirmationResponse.getResponse().getSourceMedia());

		try
		{
			System.out.println("New Booking Request  JSON :-- "+mapper.writeValueAsString(bookingRequestNew));
		}catch(Exception e){
			e.printStackTrace();
		}

		return bookingRequestNew;
	}

}
