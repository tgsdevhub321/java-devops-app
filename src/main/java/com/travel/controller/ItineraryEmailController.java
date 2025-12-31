package com.travel.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.travel.bean.QueryRequest;
import com.travel.object.ItineraryEmail;
import com.travel.object.email.EmailFormat;
import com.travel.object.enquery.EnqueryResponse;
import com.travel.utility.WebsiteUtility;

@Controller
public class ItineraryEmailController
{	
	@Autowired
	MailController mailService;
	@Value("${crmapiUrl}")
	private String crmapiUrl;
	@Value("${password}")
	private String password;
	
	@RequestMapping(value = "/itineraryEmail")
	public @ResponseBody String itineraryEmail(@RequestBody ItineraryEmail data, HttpServletRequest request) throws JsonProcessingException {
		System.out.println(" ItineraryEmail Calling..... ");
		
		RestTemplate restTemplate = new RestTemplate();
		ObjectMapper mapper = new ObjectMapper();
		try 
		{
			System.out.println("ItineraryEmail Data JSON :: "+new ObjectMapper().writeValueAsString(data));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		StringBuffer buffer = new StringBuffer(); 
		buffer.append("<html>");
		buffer.append("<body>");
		buffer.append("<table width='100%' border='0' cellpadding='0' cellspacing='0' style='max-width:700px;min-width:700px;margin:auto;border:1px solid #dddddd;font-family:Arial, Helvetica, sans-serif;'>");
		buffer.append("<tr>");	
		buffer.append("<td>");
		buffer.append("<a href='"+WebsiteUtility.websiteUrl+"' target='_blank'>");
		buffer.append("<img src='https://www.farehutz.us/resources/images/logo.png?v=12' style='height:50px;margin-left:15px;'>");
		buffer.append("</a>");
		buffer.append("</td>");
		buffer.append("<td style='text-align:right; color:#FF4500;font-family:Arial, Helvetica, sans-serif;font-weight:500;padding:10px 20px 0 0;'>");
		buffer.append("Call Us:<a href='tel:+18665038818' style='color:#17252A;font-size:20px;text-decoration:none;'>+1-866-503-8818</a>");
		buffer.append("</td>");
		buffer.append("</tr>");
		buffer.append("<tr>");
		buffer.append("<td colspan='2' style='background-color:#FF4500;height:30px;'></td>");
		buffer.append("</tr>");

		buffer.append("<tr>");
		buffer.append("<td colspan='2' style='text-align:center;font-size:22px;color:#17252A;font-weight:600;padding:5px;'>OutBound Details</td>");
		buffer.append("</tr>");

		buffer.append("<tr>");
		buffer.append("<td colspan='2' style='text-align:left;color:#666666;padding:5px;'>");
		buffer.append("From Airport - "+data.getOutFrom()+" ToAirport - "+data.getOutTo());
		buffer.append("</td>");
		buffer.append("</tr>");
		
		buffer.append("<tr>");
		buffer.append("<td colspan='2' style='text-align:left;color:#666666;padding:5px;'>");
		buffer.append("Departure Date - "+data.getOutdepDate()+" Arrival Date - "+data.getOutarvlDate());
		buffer.append("</td>");
		buffer.append("</tr>");

		buffer.append("<tr>");
		buffer.append("<td colspan='2' style='text-align:left;color:#666666;padding:5px;'>");
		buffer.append("Airline - "+data.getOutAirline()+" Class - "+getClass(data.getOutCls()));
		buffer.append("</td>");
		buffer.append("</tr>");
		
		buffer.append("<tr>");
		buffer.append("<td colspan='2' style='text-align:left;color:#666666;padding:5px;'>");
		buffer.append("Flight No - "+data.getOutFlt()+" Stops - "+data.getOutStops());
		buffer.append("</td>");
		buffer.append("</tr>");
		
		if(data.getInFrom()!=null && !data.getInFrom().trim().isEmpty()){
			
			buffer.append("<tr>");
			buffer.append("<td colspan='2' style='text-align:center;font-size:22px;color:#17252A;font-weight:600;padding:5px;'>InBound Details</td>");
			buffer.append("</tr>");
			
			buffer.append("<tr>");
			buffer.append("<td colspan='2' style='text-align:left;color:#666666;padding:5px;'>");
			buffer.append("From Airport - "+data.getInFrom()+" ToAirport - "+data.getInTo());
			buffer.append("</td>");
			buffer.append("</tr>");

			buffer.append("<tr>");
			buffer.append("<td colspan='2' style='text-align:left;color:#666666;padding:5px;'>");
			buffer.append("Departure Date - "+data.getIndepDate()+" Arrival Date - "+data.getInarvlDate());
			buffer.append("</td>");
			buffer.append("</tr>");

			buffer.append("<tr>");
			buffer.append("<td colspan='2' style='text-align:left;color:#666666;padding:5px;'>");
			buffer.append("Airline - "+data.getInAirline()+" Class - "+getClass(data.getInCls()));
			buffer.append("</td>");
			buffer.append("</tr>");

			buffer.append("<tr>");
			buffer.append("<td colspan='2' style='text-align:left;color:#666666;padding:5px;'>");
			buffer.append("Flight No - "+data.getInFlt()+" Stops - "+data.getInStops());
			buffer.append("</td>");
			buffer.append("</tr>");
		}
		
		double totalAmount = Double.valueOf(data.getAdultPrice());
		
		int totalPax = Integer.valueOf(data.getAdultNo());
		
		buffer.append("<tr>");
		buffer.append("<td colspan='2' style='text-align:left;color:#666666;padding:5px;'>");
		buffer.append("Adult - "+data.getAdultNo()+" Price - "+data.getAdultPrice());
		buffer.append("</td>");
		buffer.append("</tr>");
		
		if(data.getChildNo()>0){
			buffer.append("<tr>");
			buffer.append("<td colspan='2' style='text-align:left;color:#666666;padding:5px;'>");
			buffer.append("Child - "+data.getChildNo()+" Price - "+data.getChildPrice());
			buffer.append("</td>");
			buffer.append("</tr>");
			totalAmount = totalAmount+Double.valueOf(data.getChildPrice());
			totalPax = totalPax+Integer.valueOf(data.getChildNo());
		}
		
		if(data.getInfantNo()>0){
			buffer.append("<tr>");
			buffer.append("<td colspan='2' style='text-align:left;color:#666666;padding:5px;'>");
			buffer.append("Infant - "+data.getInfantNo()+" Price - "+data.getInfantPrice());
			buffer.append("</td>");
			buffer.append("</tr>");
			totalAmount = totalAmount+Double.valueOf(data.getInfantPrice());
			totalPax = totalPax+Integer.valueOf(data.getInfantNo());
		}
		
		if(data.getInfantWsNo()>0){
			buffer.append("<tr>");
			buffer.append("<td colspan='2' style='text-align:left;color:#666666;padding:5px;'>");
			buffer.append("InfantWS - "+data.getInfantWsNo()+" Price - "+data.getInfantWsPrice());
			buffer.append("</td>");
			buffer.append("</tr>");
			totalAmount = totalAmount+Double.valueOf(data.getInfantWsPrice());
			totalPax = totalPax+Integer.valueOf(data.getInfantWsNo());
		}
		
		buffer.append("<tr>");
		buffer.append("<td colspan='2' style='text-align:left;color:#666666;padding:5px;'>");
		buffer.append("Phone Number - "+data.getPhoneNo());
		buffer.append("</td>");
		buffer.append("</tr>");
		
		buffer.append("<tr>");
		buffer.append("<td colspan='2' style='text-align:left;color:#666666;padding:5px;'>");
		buffer.append("EmailID - "+data.getEmailId());
		buffer.append("</td>");
		buffer.append("</tr>");
		
		buffer.append("<tr>");
		buffer.append("<td colspan='2'><hr></td>");
		buffer.append("</tr>");
		buffer.append("<tr>");
		buffer.append("<td colspan='2' style='text-align:center;padding:3%;color:#17252A;font-size:15px;'>© Copyright 2017-2025 All right Reserved "+WebsiteUtility.websiteName+"</td>");
		buffer.append("</tr>");
		buffer.append("</table>");
		buffer.append("</body>");
		buffer.append("</html>");
		
		//System.out.println(buffer.toString());
		
		String formattedDate = "";
		try
		{
			LocalDateTime myDateObj = LocalDateTime.now();
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			formattedDate = myDateObj.format(myFormatObj);
			//System.out.println("After formatting: " + formattedDate);
		}catch(Exception e){
			formattedDate = "";
		}
		
		//2024-06-20 - 06/21/2024
		String outDates = data.getOutdepDate().split("T")[0];
		String departureDate = outDates.split("-")[1]+"/"+outDates.split("-")[2]+"/"+outDates.split("-")[0];
		System.out.println("DepartureDate:: "+departureDate);
		String returnDate = "";
		if(data.getInFrom() != null && !data.getInFrom().trim().isEmpty()) {
			try
			{
				String inDates = data.getIndepDate().split("T")[0];
				returnDate = inDates.split("-")[1]+"/"+inDates.split("-")[2]+"/"+inDates.split("-")[0];
				System.out.println("ReturnDate:: "+returnDate);
			}catch(Exception e){
				returnDate = "";
			}
		}
		else{
			returnDate=departureDate;
		}
		System.out.println("ReturnDate Outer :: "+returnDate);
		
		String enqueryDone = "No";
		try
		{
			enqueryDone = (String)request.getSession().getAttribute("enqueryDone");
			if(enqueryDone==null){
				enqueryDone = "No";
			}
		}catch(NullPointerException e){
			enqueryDone = "No";
		}
		catch(Exception e){
			enqueryDone = "No";
		}
		System.out.println("EnqueryDone :: "+enqueryDone);
		
		String enqueryId = "";
		String enqueryPhoneNo="";
		if(enqueryDone.equalsIgnoreCase("Yes")){
			System.out.println(" <<<<<<<<<<<<<<<<<<< Same Session To Enquery ID >>>>>>>>>>>>>>>>>>> ");
			enqueryId = (String)request.getSession().getAttribute("enqueryId");
			enqueryPhoneNo = (String)request.getSession().getAttribute("enqueryPhoneNo");
			
			if(enqueryPhoneNo.equalsIgnoreCase(data.getPhoneNo())){
				System.out.println(" <<<<<<<<<<<<<<<<<<< Same Session Enquery PhoneNo >>>>>>>>>>>>>>>>>>> ");
			}
			
		}else{
			System.out.println("<<<<<<<<<<<<<<<<<<<< New Session To Enquery >>>>>>>>>>>>>>>>>>>> ");
			String sourceMedia = "Online";
			if(data.getSourceMedia()!=null && !data.getSourceMedia().trim().isEmpty()){
				sourceMedia = data.getSourceMedia();
			}
			else{
				sourceMedia = "Online";
			}
			QueryRequest queryRequest = new QueryRequest();
			queryRequest.setAgentId(2);	//16647
			queryRequest.setQsource("Lead"); 	//Lead/Call
			queryRequest.setQtype("Air");
			queryRequest.setPnr("100");
			queryRequest.setAirline(data.getOutAirline()); 
			queryRequest.setPaxName(data.getEmailId());
			queryRequest.setNoPax(totalPax); 
			queryRequest.setQueryDate(formattedDate);
			queryRequest.setSellingPrice(totalAmount);
			queryRequest.setBuyingCost(totalAmount);
			queryRequest.setContactNo(data.getPhoneNo());
			queryRequest.setEmailId(data.getEmailId());
			queryRequest.setDateOfTravel(departureDate);
			queryRequest.setReturnDate(returnDate);
			queryRequest.setSiteId(2);
			queryRequest.setQueryStatus("New");	//Follow Up
			queryRequest.setSupplier(sourceMedia);
			
			queryRequest.setOutboundFromairport(data.getOutFrom());
			queryRequest.setOutboundToairport(data.getOutTo());
			queryRequest.setOutboundFlightNo(data.getOutFlt());
			queryRequest.setOutboundClass(getClass(data.getOutCls()));
			queryRequest.setOutboundAirline(data.getOutAirline()+"-"+data.getOutAirCode());
			queryRequest.setInboundFromairport(data.getInFrom());
			queryRequest.setInboundToairport(data.getInTo());
			queryRequest.setInboundFlightNo(data.getInFlt());
			queryRequest.setInboundClass(getClass(data.getInCls()));
			queryRequest.setInboundAirline(data.getInAirline()+"-"+data.getInAirCode());
			queryRequest.setAdult(data.getAdultNo());
			queryRequest.setChild(data.getChildNo());
			queryRequest.setInfant(data.getInfantNo());
			queryRequest.setInfantws(data.getInfantWsNo());
			queryRequest.setMco(0.00);
			
			System.out.println("Query Request JSON :-- "+mapper.writeValueAsString(queryRequest));	
			
			String queryUrl = crmapiUrl+"/query/addQuery?authcode="+password;
			String queryRes = restTemplate.postForObject(queryUrl, queryRequest, String.class);
			System.out.println("QueryResponse:: "+queryRes);
			
			EnqueryResponse enqueryResponse = new EnqueryResponse();
			try
			{
				enqueryResponse = mapper.readValue(queryRes, EnqueryResponse.class);
			} catch (JsonParseException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			enqueryId = String.valueOf(enqueryResponse.getResponse().getId());
			System.out.println("EnqueryId:: "+enqueryId);
			request.getSession().setAttribute("enqueryDone", "Yes");
			request.getSession().setAttribute("enqueryId", enqueryId);
			request.getSession().setAttribute("enqueryPhoneNo", data.getPhoneNo());
			
			EmailFormat emailSend = new EmailFormat();
			emailSend.setFromEmail(WebsiteUtility.websiteEmailPassword);
			emailSend.setToEmail("enquiry@tgsventures.co.in");
			emailSend.setBccEmail("enquiry@tgsventures.co.in");
			emailSend.setBookingID("0");
			emailSend.setMailBody(buffer.toString());
			emailSend.setMailSubject("Flight Itinerary Abandoned From "+WebsiteUtility.websiteName+"  "+formattedDate);
			String mailStatus = "";
			try 
			{
				mailStatus = mailService.SendMail(emailSend, "smtp.gmail.com", "465", "vpbb sweg ublp tdvj");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
			
			System.out.println("MailStatus::"+mailStatus);
		}
		
		return enqueryId;

	}
	
	public String getClass(String cls){
		String className = "";
		if(cls.equalsIgnoreCase("1")){
			className = "Economy";
		}
		else if(cls.equalsIgnoreCase("3")){
			className = "Business";
		}
		else if(cls.equalsIgnoreCase("4")){
			className = "First";
		}
		
		return className;
	}
}