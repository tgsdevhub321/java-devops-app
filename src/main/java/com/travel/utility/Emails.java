package com.travel.utility;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.travel.bean.ContactForm;
import com.travel.object.bookingrequest.BookingRequest;
import com.travel.object.searchRequest.FlightRequest;
import java.text.NumberFormat;

public class Emails
{	
	public String buildFlightEmail(BookingRequest bookingRequest, FlightRequest searchRequest, HttpServletRequest request){
		
		StringBuffer buffer = new StringBuffer();
		/*String sourceTFN = "+1-866-503-8818";
		if(bookingRequest.getSourceMedia().equalsIgnoreCase("google")){
			sourceTFN = "+1-866-503-8818";
		}else if(bookingRequest.getSourceMedia().equalsIgnoreCase("jetradar")){
			sourceTFN = "+1-866-503-8818";
		}else if(bookingRequest.getSourceMedia().equalsIgnoreCase("jetcost")){
			sourceTFN = "+1-866-503-8818";
		}else if(bookingRequest.getSourceMedia().equalsIgnoreCase("fclist")){
			sourceTFN = "+1-888-415-0834";
		}else if(bookingRequest.getSourceMedia().equalsIgnoreCase("skyscanner")){
			sourceTFN = "+1-800-720-9679";
		}else{
			sourceTFN = "+1-866-503-8818";
		}*/
		
		String sourceTFN = TFNUtility.getTFN(bookingRequest.getSourceMedia(), request);
		
		buffer.append("<html>");
		buffer.append("<body>");
		buffer.append("<table width='100%' border='0' cellpadding='0' cellspacing='0' style='max-width:700px;min-width:700px;margin:auto;border:1px solid #dddddd;font-family:Arial, Helvetica, sans-serif;'>");
		buffer.append("<tr>");
		buffer.append("<td style='background-color:#0a2d72'>");
		buffer.append("<a href='https://www.farehutz.us' target='_blank'>");
		buffer.append("<img src='https://www.farehutz.us/resources/images/logo.png?v=12' style='height:50px;margin-left:15px;'>");
		buffer.append("</a>");
		buffer.append("</td>");
		buffer.append("<td style='text-align:right; color:#fff;background-color:#0a2d72;font-family:Arial, Helvetica, sans-serif;font-weight:500;padding:10px 20px 0 0;'>");
		buffer.append("Call Us:<a href='tel:"+sourceTFN+"' style='color:#fff;font-size:20px;text-decoration:none;'>"+sourceTFN+"</a>");
		buffer.append("</td>");
		buffer.append("</tr>");
		
		buffer.append("<tr>");
		buffer.append("<td colspan='2' style='background-color:#0a2d72;height:30px;'></td>");
		buffer.append("</tr>");
		
		if(bookingRequest.getSourceMedia().equalsIgnoreCase("google")){
			if(bookingRequest.getChangeableTickets().equalsIgnoreCase("Yes")){
				
				buffer.append("<tr>");
				buffer.append("<td colspan='2' style='padding:15px 0;'><img src='https://www.farehutz.us/resources/images/confirm.png' style='margin:auto;display:block;' width='80px' height='80px'></td>");
				buffer.append("</tr>");
				buffer.append("<tr>");

				/////buffer.append("<td colspan='2' style='text-align:center;font-size:22px;color:#17252A;font-weight:600;padding:5px;'>Your Booking is "+bookingRequest.getBookingStatus()+"</td>");
				buffer.append("<td colspan='2' style='text-align:center;font-size:22px;color:#17252A;font-weight:600;padding:5px;'>BOOKING STATUS : IN PROGRESS</td>");
				buffer.append("</tr>");
				
				buffer.append("<tr>");
				buffer.append("<td colspan='2' style='text-align:center;color:#666666;padding:5px;'>");
				buffer.append("Your e-Tickets are Pending and will be sent to your email address with in 24 hours.");
				buffer.append("</td>");
				buffer.append("</tr>");

				buffer.append("<tr>");
				buffer.append("<td colspan='2' style='text-align:center;color:#666666;padding:5px;'>");
				buffer.append("For immediate help on your booking, please call us at <a style='color:#17252A;text-decoration:none;' href='tel:"+sourceTFN+"'>"+sourceTFN+"</a>");
				buffer.append("</td>");
				buffer.append("</tr>");
				
				buffer.append("<tr>");
				buffer.append("<td colspan='2' style='text-align:center;padding:5px;font-size:30px;color:#17252A;font-weight:600;'>");
				buffer.append("BOOKING ID : "+bookingRequest.getBookingID()+"");
				buffer.append("</td>");
				buffer.append("</tr>");
			}
			else
			{	
				if(bookingRequest.getFlightResult().getOutBound().get(0).getAirline().equalsIgnoreCase("AM")){
					
					buffer.append("<tr>");
					buffer.append("<td colspan='2' style='text-align:left; color:#4b4c4c;padding:20px;'>");
					buffer.append("<table width='100%' border='0' cellspacing='0' cellpadding='0'>");
					buffer.append("<tbody>");				
					buffer.append("<tr>");
					buffer.append("<td style='font-size: 18px; line-height:22px; color:#f27f13; padding: 2px 0px; display: flex;'>");
					buffer.append("<img src='https://www.farehutz.us/resources/images/confirm-yes.png' style='margin-right: 10px;' width='48' height='42' alt=''>");
					buffer.append("We are delighted to confirm your flight booking for your upcoming trip. Your ticket is subject to a one-hour ticketing time period.");
					buffer.append("If your booking is not ticketed within the specified one-hour time frame, a representative will attempt to contact you to provide further assistance and ensure a smooth booking process.");
					buffer.append("</td>");
					buffer.append("</tr>");
					buffer.append("</tbody>");
					buffer.append("</table>");				
					buffer.append("</td>");			
					buffer.append("</tr>");
					
				}else if(bookingRequest.getFlightResult().getOutBound().get(0).getAirline().equalsIgnoreCase("CM")){
					
					buffer.append("<tr>");
					buffer.append("<td colspan='2' style='text-align:left; color:#4b4c4c;padding:20px;'>");
					buffer.append("<table width='100%' border='0' cellspacing='0' cellpadding='0'>");
					buffer.append("<tbody>");				
					buffer.append("<tr>");
					buffer.append("<td style='font-size: 18px; line-height:22px; color:#f27f13; padding: 2px 0px; display: flex;'>");
					buffer.append("<img src='https://www.farehutz.us/resources/images/confirm-yes.png' style='margin-right: 10px;' width='48' height='42' alt=''>");
					buffer.append("We are delighted to confirm your flight booking for your upcoming trip. Your ticket is subject to a one-hour ticketing time period.");
					buffer.append("If your booking is not ticketed within the specified one-hour time frame, a representative will attempt to contact you to provide further assistance and ensure a smooth booking process.");
					buffer.append("</td>");
					buffer.append("</tr>");
					buffer.append("</tbody>");
					buffer.append("</table>");				
					buffer.append("</td>");			
					buffer.append("</tr>");
					
				}else if(bookingRequest.getFlightResult().getOutBound().get(0).getAirline().equalsIgnoreCase("LO")){
					
					buffer.append("<tr>");
					buffer.append("<td colspan='2' style='text-align:left; color:#4b4c4c;padding:20px;'>");
					buffer.append("<table width='100%' border='0' cellspacing='0' cellpadding='0'>");
					buffer.append("<tbody>");				
					buffer.append("<tr>");
					buffer.append("<td style='font-size: 18px; line-height:22px; color:#f27f13; padding: 2px 0px; display: flex;'>");
					buffer.append("<img src='https://www.farehutz.us/resources/images/confirm-yes.png' style='margin-right: 10px;' width='48' height='42' alt=''>");
					buffer.append("We are delighted to confirm your flight booking for your upcoming trip. Your ticket is subject to a one-hour ticketing time period.");
					buffer.append("If your booking is not ticketed within the specified one-hour time frame, a representative will attempt to contact you to provide further assistance and ensure a smooth booking process.");
					buffer.append("</td>");
					buffer.append("</tr>");
					buffer.append("</tbody>");
					buffer.append("</table>");				
					buffer.append("</td>");			
					buffer.append("</tr>");
					
				}else if(bookingRequest.getFlightResult().getOutBound().get(0).getAirline().equalsIgnoreCase("QR")){
					
					buffer.append("<tr>");
					buffer.append("<td colspan='2' style='padding:15px 0;'><img src='https://www.farehutz.us/resources/images/confirm.png' style='margin:auto;display:block;' width='80px' height='80px'></td>");
					buffer.append("</tr>");
					buffer.append("<tr>");

					buffer.append("<td colspan='2' style='text-align:center;font-size:22px;color:#17252A;font-weight:600;padding:5px;'>BOOKING STATUS : IN PROGRESS</td>");
					buffer.append("</tr>");
					
					buffer.append("<tr>");
					buffer.append("<td colspan='2' style='text-align:center;color:#666666;padding:5px;'>");
					buffer.append("Your e-Tickets are Pending and will be sent to your email address with in 24 hours.");
					buffer.append("</td>");
					buffer.append("</tr>");

					buffer.append("<tr>");
					buffer.append("<td colspan='2' style='text-align:center;color:#666666;padding:5px;'>");
					buffer.append("For immediate help on your booking, please call us at <a style='color:#17252A;text-decoration:none;' href='tel:"+sourceTFN+"'>"+sourceTFN+"</a>");
					buffer.append("</td>");
					buffer.append("</tr>");
					
					buffer.append("<tr>");
					buffer.append("<td colspan='2' style='text-align:center;padding:5px;font-size:30px;color:#17252A;font-weight:600;'>");
					buffer.append("BOOKING ID : "+bookingRequest.getBookingID()+"");
					buffer.append("</td>");
					buffer.append("</tr>");
					
				}else{
					
					buffer.append("<tr>");
					buffer.append("<td colspan='2' style='text-align:left; color:#4b4c4c;padding:20px;'>");
					buffer.append("<table width='100%' border='0' cellspacing='0' cellpadding='0'>");
					buffer.append("<tbody>");				
					buffer.append("<tr>");
					buffer.append("<td  style='font-size: 18px; line-height:22px; color:#f27f13; padding: 2px 0px; display: flex;'>");
					buffer.append("<img src='https://www.farehutz.us/resources/images/confirm-yes.png' style='margin-right: 10px;' width='48' height='42' alt=''> Your booking has declined. We know it can be frustrating when these things happen and are sorry for the inconvenience caused.</td>");
					buffer.append("</tr>");
					buffer.append("<tr>");
					buffer.append("<td style='color:#666; font-size: 18px; padding: 2px 0px;'>");
					buffer.append("Kindly be patient as we diligently process your flight reservation.");
					buffer.append("</td>");
					buffer.append("</tr>");
					buffer.append("<tr>");
					buffer.append("<td style='color:#666; font-size: 14px; padding: 2px 0px;'>");
					buffer.append("Potential causes for the transaction not proceeding are as follows:</td>");
					buffer.append("</tr>");
					buffer.append("<tr>");
					buffer.append("<td style='color:#666; font-size: 14px; padding: 2px 0px;'>");
					buffer.append("a) Rejection by your financial institution.");
					buffer.append("</td>");
					buffer.append("</tr>");
					buffer.append("<tr>");
					buffer.append("<td style='color:#666; font-size: 14px; padding: 2px 0px;'>");
					buffer.append("b) Incorrect card details or CVV input.");
					buffer.append("</td>");
					buffer.append("</tr>");
					buffer.append("<tr>");
					buffer.append("<td style='color:#666; font-size: 14px; padding: 2px 0px;'>");
					buffer.append("c) Alteration in fare and flight availability for the selected booking.");
					buffer.append("</td>");
					buffer.append("</tr>");	
					buffer.append("<tr>");	
					buffer.append("<td style='color:#666; font-size: 14px; padding: 2px 0px;'>");
					buffer.append("Please be aware that the initially quoted fares are subject to modification until ticket issuance.");
					buffer.append("</td>");
					buffer.append("</tr>");	
					buffer.append("<tr>");	
					buffer.append("<td style='color:#666; font-size: 14px; padding: 2px 0px;'>");
					buffer.append("Our commitment to delivering exemplary customer service is unwavering. A member of our travel team will contact you promptly. Alternatively, feel free to reach us at "+sourceTFN+" or via email at support@farehutz.us for getting resolution at the earliest.");
					buffer.append("</td>");
					buffer.append("</tr>");	
					
					buffer.append("</tbody>");
					buffer.append("</table>");				
					buffer.append("</td>");			
					buffer.append("</tr>");
					
				}
				
			}
		}else{
			
			buffer.append("<tr>");
			buffer.append("<td colspan='2' style='padding:15px 0;'><img src='https://www.farehutz.us/resources/images/confirm.png' style='margin:auto;display:block;' width='80px' height='80px'></td>");
			buffer.append("</tr>");
			buffer.append("<tr>");

			/////buffer.append("<td colspan='2' style='text-align:center;font-size:22px;color:#17252A;font-weight:600;padding:5px;'>Your Booking is "+bookingRequest.getBookingStatus()+"</td>");
			buffer.append("<td colspan='2' style='text-align:center;font-size:22px;color:#17252A;font-weight:600;padding:5px;'>BOOKING STATUS : IN PROGRESS</td>");
			buffer.append("</tr>");

			buffer.append("<tr>");
			buffer.append("<td colspan='2' style='text-align:center;color:#666666;padding:5px;'>");
			buffer.append("Your e-Tickets are Pending and will be sent to your email address with in 24 hours.");
			buffer.append("</td>");
			buffer.append("</tr>");

			buffer.append("<tr>");
			buffer.append("<td colspan='2' style='text-align:center;color:#666666;padding:5px;'>");
			buffer.append("For immediate help on your booking, please call us at <a style='color:#17252A;text-decoration:none;' href='tel:"+sourceTFN+"'>"+sourceTFN+"</a>");
			buffer.append("</td>");
			buffer.append("</tr>");
			
			buffer.append("<tr>");
			buffer.append("<td colspan='2' style='text-align:center;padding:5px;font-size:30px;color:#17252A;font-weight:600;'>");
			buffer.append("BOOKING ID : "+bookingRequest.getBookingID()+"");
			buffer.append("</td>");
			buffer.append("</tr>");
		}
		
		buffer.append("<tr>");
		buffer.append("<td colspan='2' style='background-color:#0a2d72;padding-left:15px;font-size:20px;color:#ffffff;font-weight:550;height:35px'>");
		buffer.append("Flight Summary");
		buffer.append("</td>");
		buffer.append("</tr>");
		buffer.append("<tr>");
		buffer.append("<td colspan='2'>");
		buffer.append("<table width='100%' border='0' cellpadding='0' cellspacing='0' style='background-color:#eeeeee;font-family:Arial, Helvetica, sans-serif;padding:5px 20px;'>");
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
		SimpleDateFormat dateformatTime = new SimpleDateFormat("hh:mm:a");
		SimpleDateFormat dateformatDate = new SimpleDateFormat("dd, MMM yyyy");

		DateFormat inputFormat  = new SimpleDateFormat("HH:mm");
		DateFormat outputFormat = new SimpleDateFormat("hh:mm a");
		buffer.append("<tr>");
		buffer.append("<td width='100%' colspan='3' style='color:#17252A;font-size:17px;font-weight:600;padding:10px 0;'>");
		buffer.append("Departure Flights <span style='font-size:16px;font-weight:400;'></span>");
		buffer.append("</td>");
		buffer.append("</tr>");
		
		for (int j = 0; j < bookingRequest.getFlightResult().getOutBound().size(); j++) {

			String depFroTimeStr ="";
			String depFroDateStr ="";
			String depToTimeStr ="";
			String depToDateStr ="";
			try 
			{
				Date depDate = dateformat.parse(bookingRequest.getFlightResult().getOutBound().get(j).getDepDate());
				//depFroTimeStr = dateformatTime.format(depDate);
				depFroTimeStr = outputFormat.format(inputFormat.parse(bookingRequest.getFlightResult().getOutBound().get(j).getDepDate().split("T")[1]));
				depFroDateStr = dateformatDate.format(depDate);

				Date reachDate = dateformat.parse(bookingRequest.getFlightResult().getOutBound().get(j).getReachDate());
				//depToTimeStr = dateformatTime.format(reachDate);
				depToTimeStr = outputFormat.format(inputFormat.parse(bookingRequest.getFlightResult().getOutBound().get(j).getReachDate().split("T")[1]));
				depToDateStr = dateformatDate.format(reachDate);

			} catch (ParseException e) {
				// TODO Auto-generated catch block 
				e.printStackTrace();
			}

			buffer.append("<tr>");
			buffer.append("<td style='display:flex;align-items:center;font-size:15px;padding:5px;color:#444444'><img src='https://www.farehutz.us/resources/images/airline-logo/"+bookingRequest.getFlightResult().getOutBound().get(j).getAirline()+".png' width='50px' height='30px'> "+bookingRequest.getFlightResult().getOutBound().get(j).getAirlineName()+"</td>");
			buffer.append("<td style='text-align:center;font-size:14px;font-weight:550;padding:5px;color:#444444'>Flight No: <span style='font-size:13px;font-weight:400;'>"+bookingRequest.getFlightResult().getOutBound().get(j).getFlightNo()+"</span></td>");
			String cabin = "";
			if(bookingRequest.getFlightResult().getOutBound().get(j).getCabinClass() == 1){
				cabin = "Economy";
			}
			else if(bookingRequest.getFlightResult().getOutBound().get(j).getCabinClass() == 2){
				cabin = "Premium Economy";
			}
			else if(bookingRequest.getFlightResult().getOutBound().get(j).getCabinClass() == 3){
				cabin = "Business";
			}
			else if(bookingRequest.getFlightResult().getOutBound().get(j).getCabinClass() == 4){
				cabin = "First";
			}
			buffer.append("<td style='text-align:right;font-size:14px;font-weight:550;padding:5px;color:#444444'>Class : <span style='font-size:13px;font-weight:400;'>"+cabin+"</span></td>");
			buffer.append("</tr>");
			buffer.append("<tr>");
			buffer.append("<td style='padding:5px;color:#666666;'>"+depFroDateStr+","+depFroTimeStr+"</td>");
			try
			{
				buffer.append("<td style='text-align:center;padding:5px;color:#666666;'><img src='https://www.farehutz.us/resources/images/clocko.png' width='14px;' height='14px;'>"+Utility.timeConversion(bookingRequest.getFlightResult().getOutBound().get(j).getEft())+"</td>");
			}catch(Exception e){
				buffer.append("<td style='text-align:center;padding:5px;color:#666666;'></td>");
			}

			buffer.append("<td style='text-align:right;padding:5px;color:#666666;'>"+depToDateStr+","+depToTimeStr+"</td>");
			buffer.append("</tr>");
			buffer.append("<tr>");
			buffer.append("<td style='padding:5px;color:#17252A;font-weight:550;'>"+bookingRequest.getFlightResult().getOutBound().get(j).getFromAirport()+"<span style='font-weight:400;color:#444444;'>("+bookingRequest.getFlightResult().getOutBound().get(j).getFroCityName()+")</span></td>");
			buffer.append("<td style='text-align:center;padding:5px;'><img src='https://www.farehutz.us/resources/images/rightarrow.png' width='30px;' height='30px;'></td>");
			buffer.append("<td style='padding:5px;color:#17252A;font-weight:550;text-align:right;'>"+bookingRequest.getFlightResult().getOutBound().get(j).getToAirport()+"<span style='font-weight:400;color:#444444'>("+bookingRequest.getFlightResult().getOutBound().get(j).getToCityName()+")</span></td>");
			buffer.append("</tr>");
			buffer.append("<tr>");
			buffer.append("<td style='font-size:15px;padding:0 5px;color:#444444'>"+bookingRequest.getFlightResult().getOutBound().get(j).getFromAirportName()+"</td>");
			buffer.append("<td style='text-align:center;font-size:14px;font-weight:550;padding:0 5px;color:#444444'>Non-Stop</td>");
			buffer.append("<td style='text-align:right;font-size:15px;padding:0 5px;color:#444444'>"+bookingRequest.getFlightResult().getOutBound().get(j).getToAirportName()+"</td>");
			buffer.append("</tr>");
			buffer.append("<tr style='height:10px;'></tr>");

			try
			{
				if(bookingRequest.getFlightResult().getOutBound().get(j).getLayOverTime() > 0){
					buffer.append("<tr style='height:30px;'>");
					buffer.append("<td><hr style='border:dashed #999999;border-width:0 0 1px 0'></td>");
					buffer.append("<td style='text-align:center;color:#666666;font-size:13px;font-weight:500;'><img src='/resources/images/clocko.png' width='13px;' height='13px;'> "+Utility.timeConversion(bookingRequest.getFlightResult().getOutBound().get(j).getLayOverTime())+" layover in "+bookingRequest.getFlightResult().getOutBound().get(j).getToCityName()+" ("+bookingRequest.getFlightResult().getOutBound().get(j).getToAirport()+")</td>");
					buffer.append("<td><hr style='border:dashed #999999;border-width:0 0 1px 0'></td>");
					buffer.append("</tr>");
				}
			}catch(Exception e){

			}
		}
		
		if(searchRequest.getTripType() != 1){
			buffer.append("<tr>");
			buffer.append("<td width='100%' colspan='3' style='color:#17252A;font-size:17px;font-weight:600;padding:10px 0;'>");
			if(searchRequest.getTripType() == 2)
				buffer.append("Return Flights <span style='font-size:16px;font-weight:400;'></span>");
			else if(searchRequest.getTripType() == 3)
				buffer.append("Departure Flights <span style='font-size:16px;font-weight:400;'></span>");
			buffer.append("</td>");
			buffer.append("</tr>");
			for (int j = 0; j < bookingRequest.getFlightResult().getInBound().size(); j++) {

				String depFroTimeStr ="";
				String depFroDateStr ="";
				String depToTimeStr ="";
				String depToDateStr ="";
				try {
					Date depDate = dateformat.parse(bookingRequest.getFlightResult().getInBound().get(j).getDepDate());
					//depFroTimeStr = dateformatTime.format(depDate);
					depFroTimeStr = outputFormat.format(inputFormat.parse(bookingRequest.getFlightResult().getInBound().get(j).getDepDate().split("T")[1]));
					depFroDateStr = dateformatDate.format(depDate);

					Date reachDate = dateformat.parse(bookingRequest.getFlightResult().getInBound().get(j).getReachDate());
					//depToTimeStr = dateformatTime.format(reachDate);
					depToTimeStr = outputFormat.format(inputFormat.parse(bookingRequest.getFlightResult().getInBound().get(j).getReachDate().split("T")[1]));
					depToDateStr = dateformatDate.format(reachDate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}

				buffer.append("<tr>");
				buffer.append("<td style='display:flex;align-items:center;font-size:15px;padding:5px;color:#444444'><img src='https://www.farehutz.us/resources/images/airline-logo/"+bookingRequest.getFlightResult().getInBound().get(j).getAirline()+".png' width='50px' height='30px'> "+bookingRequest.getFlightResult().getInBound().get(j).getAirlineName()+"</td>");
				buffer.append("<td style='text-align:center;font-size:14px;font-weight:550;padding:5px;color:#444444'>Flight No: <span style='font-size:13px;font-weight:400;'>"+bookingRequest.getFlightResult().getInBound().get(j).getFlightNo()+"</span></td>");
				String cabin = "";
				if(bookingRequest.getFlightResult().getInBound().get(j).getCabinClass() == 1){
					cabin = "Economy";
				}
				else if(bookingRequest.getFlightResult().getInBound().get(j).getCabinClass() == 2){
					
				}
				else if(bookingRequest.getFlightResult().getInBound().get(j).getCabinClass() == 3){
					cabin = "Business";
				}
				else if(bookingRequest.getFlightResult().getInBound().get(j).getCabinClass() == 4){
					cabin = "First";
				}
				
				buffer.append("<td style='text-align:right;font-size:14px;font-weight:550;padding:5px;color:#444444'>Class : <span style='font-size:13px;font-weight:400;'>"+cabin+"</span></td>");
				buffer.append("</tr>");
				buffer.append("<tr>");
				buffer.append("<td style='padding:5px;color:#666666;'>"+depFroDateStr+","+depFroTimeStr+"</td>");

				try{
					buffer.append("<td style='text-align:center;padding:5px;color:#666666;'><img src='https://www.farehutz.us/resources/images/clocko.png' width='14px;' height='14px;'>"+Utility.timeConversion(bookingRequest.getFlightResult().getInBound().get(j).getEft())+"</td>");
				}catch(Exception e){
					buffer.append("<td style='text-align:center;padding:5px;color:#666666;'></td>");
				}
				buffer.append("<td style='text-align:right;padding:5px;color:#666666;'>"+depToDateStr+","+depToTimeStr+"</td>");
				buffer.append("</tr>");
				buffer.append("<tr>");
				buffer.append("<td style='padding:5px;color:#17252A;font-weight:550;'>"+bookingRequest.getFlightResult().getInBound().get(j).getFromAirport()+"<span style='font-weight:400;color:#444444;'>("+bookingRequest.getFlightResult().getInBound().get(j).getFroCityName()+")</span></td>");
				buffer.append("<td style='text-align:center;padding:5px;'><img src='https://www.farehutz.us/resources/images/rightarrow.png' width='30px;' height='30px;'></td>");
				buffer.append("<td style='padding:5px;color:#17252A;font-weight:550;text-align:right;'>"+bookingRequest.getFlightResult().getInBound().get(j).getToAirport()+"<span style='font-weight:400;color:#444444'>("+bookingRequest.getFlightResult().getInBound().get(j).getToCityName()+")</span></td>");
				buffer.append("</tr>");
				buffer.append("<tr>");
				buffer.append("<td style='font-size:15px;padding:0 5px;color:#444444'>"+bookingRequest.getFlightResult().getInBound().get(j).getFromAirportName()+"</td>");
				buffer.append("<td style='text-align:center;font-size:14px;font-weight:550;padding:0 5px;color:#444444'>Non-Stop</td>");
				buffer.append("<td style='text-align:right;font-size:15px;padding:0 5px;color:#444444'>"+bookingRequest.getFlightResult().getInBound().get(j).getToAirportName()+"</td>");
				buffer.append("</tr>");
				buffer.append("<tr style='height:10px;'></tr>");
				try{
					if(bookingRequest.getFlightResult().getInBound().get(j).getLayOverTime() > 0){
						buffer.append("<tr style='height:30px;'>");
						buffer.append("<td><hr style='border:dashed #999999;border-width:0 0 1px 0'></td>");
						buffer.append("<td style='text-align:center;color:#666666;font-size:13px;font-weight:500;'><img src='/resources/images/clocko.png' width='13px;' height='13px;'> "+Utility.timeConversion(bookingRequest.getFlightResult().getInBound().get(j).getLayOverTime())+" layover in "+bookingRequest.getFlightResult().getInBound().get(j).getToCityName()+" ("+bookingRequest.getFlightResult().getInBound().get(j).getToAirport()+")</td>");
						buffer.append("<td><hr style='border:dashed #999999;border-width:0 0 1px 0'></td>");
						buffer.append("</tr>");
					}}catch(Exception e){}
			}
		}
		if(searchRequest.getTripType() == 3)
		{
			for (int j = 0; j < bookingRequest.getFlightResult().getOtherBound().size(); j++) {
				buffer.append("<tr>");
				buffer.append("<td width='100%' colspan='3' style='color:#17252A;font-size:17px;font-weight:600;padding:10px 0;'>");
				buffer.append("Departure Flights <span style='font-size:16px;font-weight:400;'></span>");
				buffer.append("</td>");
				buffer.append("</tr>");
				for (int i = 0; i < bookingRequest.getFlightResult().getOtherBound().get(j).size(); i++) {

					String depFroTimeStr ="";
					String depFroDateStr ="";
					String depToTimeStr ="";
					String depToDateStr ="";
					try {
						Date depDate = dateformat.parse(bookingRequest.getFlightResult().getOtherBound().get(j).get(i).getDepDate());
						//depFroTimeStr = dateformatTime.format(depDate);
						depFroTimeStr = outputFormat.format(inputFormat.parse(bookingRequest.getFlightResult().getOtherBound().get(j).get(i).getDepDate().split("T")[1]));
						depFroDateStr = dateformatDate.format(depDate);

						Date reachDate = dateformat.parse(bookingRequest.getFlightResult().getOtherBound().get(j).get(i).getReachDate());
						//depToTimeStr = dateformatTime.format(reachDate);
						depToTimeStr = outputFormat.format(inputFormat.parse(bookingRequest.getFlightResult().getOtherBound().get(j).get(i).getReachDate().split("T")[1]));
						depToDateStr = dateformatDate.format(reachDate);
					} catch (ParseException e) {
						// TODO Auto-generated catch block 
						e.printStackTrace();
					}

					buffer.append("<tr>");
					buffer.append("<td style='display:flex;align-items:center;font-size:15px;padding:5px;color:#444444'><img src='https://www.farehutz.us/resources/images/airline-logo/"+bookingRequest.getFlightResult().getOtherBound().get(j).get(i).getAirline()+".png' width='50px' height='30px'> "+bookingRequest.getFlightResult().getOtherBound().get(j).get(i).getAirlineName()+"</td>");
					buffer.append("<td style='text-align:center;font-size:14px;font-weight:550;padding:5px;color:#444444'>Flight No: <span style='font-size:13px;font-weight:400;'>"+bookingRequest.getFlightResult().getOtherBound().get(j).get(i).getFlightNo()+"</span></td>");
					String cabin = "";
					if(bookingRequest.getFlightResult().getOtherBound().get(j).get(i).getCabinClass() == 1){
						cabin = "Economy";
					}
					else if(bookingRequest.getFlightResult().getOtherBound().get(j).get(i).getCabinClass() == 2){

					}
					else if(bookingRequest.getFlightResult().getOtherBound().get(j).get(i).getCabinClass() == 3){
						cabin = "Business";
					}
					else if(bookingRequest.getFlightResult().getOtherBound().get(j).get(i).getCabinClass() == 4){
						cabin = "First";
					}

					buffer.append("<td style='text-align:right;font-size:14px;font-weight:550;padding:5px;color:#444444'>Class : <span style='font-size:13px;font-weight:400;'>"+cabin+"</span></td>");
					buffer.append("</tr>");
					buffer.append("<tr>");
					buffer.append("<td style='padding:5px;color:#666666;'>"+depFroDateStr+","+depFroTimeStr+"</td>");

					try
					{
						buffer.append("<td style='text-align:center;padding:5px;color:#666666;'><img src='https://www.farehutz.us/resources/images/clocko.png' width='14px;' height='14px;'>"+Utility.timeConversion(bookingRequest.getFlightResult().getOtherBound().get(j).get(i).getEft())+"</td>");
					}catch(Exception e){
						buffer.append("<td style='text-align:center;padding:5px;color:#666666;'></td>");
					}

					buffer.append("<td style='text-align:right;padding:5px;color:#666666;'>"+depToDateStr+","+depToTimeStr+"</td>");
					buffer.append("</tr>");
					buffer.append("<tr>");
					buffer.append("<td style='padding:5px;color:#17252A;font-weight:550;'>"+bookingRequest.getFlightResult().getOtherBound().get(j).get(i).getFromAirport()+"<span style='font-weight:400;color:#444444;'>("+bookingRequest.getFlightResult().getOtherBound().get(j).get(i).getFroCityName()+")</span></td>");
					buffer.append("<td style='text-align:center;padding:5px;'><img src='https://www.farehutz.us/resources/images/rightarrow.png' width='30px;' height='30px;'></td>");
					buffer.append("<td style='padding:5px;color:#17252A;font-weight:550;text-align:right;'>"+bookingRequest.getFlightResult().getOtherBound().get(j).get(i).getToAirport()+"<span style='font-weight:400;color:#444444'>("+bookingRequest.getFlightResult().getOtherBound().get(j).get(i).getToCityName()+")</span></td>");
					buffer.append("</tr>");
					buffer.append("<tr>");
					buffer.append("<td style='font-size:15px;padding:0 5px;color:#444444'>"+bookingRequest.getFlightResult().getOtherBound().get(j).get(i).getFromAirportName()+"</td>");
					buffer.append("<td style='text-align:center;font-size:14px;font-weight:550;padding:0 5px;color:#444444'>Non-Stop</td>");
					buffer.append("<td style='text-align:right;font-size:15px;padding:0 5px;color:#444444'>"+bookingRequest.getFlightResult().getOtherBound().get(j).get(i).getToAirportName()+"</td>");
					buffer.append("</tr>");
					buffer.append("<tr style='height:10px;'></tr>");

					try
					{
						if(bookingRequest.getFlightResult().getOtherBound().get(j).get(i).getLayOverTime() > 0){
							buffer.append("<tr style='height:30px;'>");
							buffer.append("<td><hr style='border:dashed #999999;border-width:0 0 1px 0'></td>");
							buffer.append("<td style='text-align:center;color:#666666;font-size:13px;font-weight:500;'><img src='/resources/images/clocko.png' width='13px;' height='13px;'> "+Utility.timeConversion(bookingRequest.getFlightResult().getOtherBound().get(j).get(i).getLayOverTime())+" layover in "+bookingRequest.getFlightResult().getOtherBound().get(j).get(i).getToCityName()+" ("+bookingRequest.getFlightResult().getOtherBound().get(j).get(i).getToAirport()+")</td>");
							buffer.append("<td><hr style='border:dashed #999999;border-width:0 0 1px 0'></td>");
							buffer.append("</tr>");
						}
					}catch(Exception e){}
				}

			}
		}

		buffer.append("</table>");
		buffer.append("</td>");
		buffer.append("</tr>");
		buffer.append("<tr>");
		buffer.append("<td colspan='2' style='background-color:#0a2d72;padding-left:15px;font-size:20px;color:#ffffff;font-weight:550;height:35px'>");
		buffer.append("Traveler(s) Details");
		buffer.append("</td>");
		buffer.append("</tr>");
		buffer.append("<tr>");
		buffer.append("<td colspan='2'>");
		buffer.append("<table width='100%' border='0' cellpadding='0' cellspacing='0' style='font-family:Arial, Helvetica, sans-serif;padding:5px 0px;'>");
		buffer.append("<tr style='background-color:#dddddd;text-align:center;font-weight:550;'>");
		buffer.append("<td style='padding:5px;'>S.No.</td>");
		buffer.append("<td style='padding:5px;'>Name</td>");
		buffer.append("<td style='padding:5px;'>Gender</td>");
		buffer.append("<td style='padding:5px;'>DOB</td>");
		buffer.append("</tr>");

		for (int k = 0; k < bookingRequest.getPassengerDetails().size(); k++) {
			buffer.append("<tr style='background-color:#ffffff;text-align:center;font-weight:400;'>");
			buffer.append("<td style='padding:5px;'>"+(k+1)+"</td>");
			buffer.append("<td style='padding:5px;'>"+bookingRequest.getPassengerDetails().get(k).getFirstName()+" "+bookingRequest.getPassengerDetails().get(k).getMiddleName()+" "+bookingRequest.getPassengerDetails().get(k).getLastName()+"</td>");
			
			if(bookingRequest.getPassengerDetails().get(k).getGender()==1){
				buffer.append("<td style='padding:5px;'>Male</td>");
			}
			else{
				buffer.append("<td style='padding:5px;'>Female</td>");
			}
			
			buffer.append("<td style='padding:5px;'>"+bookingRequest.getPassengerDetails().get(k).getDateOfMonth()+"/"+bookingRequest.getPassengerDetails().get(k).getDobDay()+"/"+bookingRequest.getPassengerDetails().get(k).getDateOfYear()+"</td>");
			buffer.append("</tr>");
		}
		
		buffer.append("</table>");
		buffer.append("</td>");
		buffer.append("</tr>");
		buffer.append("<tr>");
		buffer.append("<td colspan='2' style='background-color:#0a2d72;padding-left:15px;font-size:20px;color:#ffffff;font-weight:550;height:35px'>");
		buffer.append("Contact Details");
		buffer.append("</td>");
		buffer.append("</tr>");
		buffer.append("<tr>");
		buffer.append("<td colspan='2'>");
		buffer.append("<table width='100%' border='0' cellpadding='0' cellspacing='0' style='font-family:Arial, Helvetica, sans-serif;padding:5px 0px;'>");
		buffer.append("<tr style='background-color:#dddddd;text-align:center;font-weight:550;'>");
		buffer.append("<td style='padding:5px;'>Billing Phone</td>");
		buffer.append("<td style='padding:5px;'>Alternate Phone</td>");
		buffer.append("<td style='padding:5px;'>Email</td>");
		buffer.append("</tr>");
		buffer.append("<tr style='background-color:#ffffff;text-align:center;font-weight:400;'>");
		buffer.append("<td style='padding:5px;'>"+bookingRequest.getPhoneNo()+"</td>");
		buffer.append("<td style='padding:5px;'>"+bookingRequest.getMobileNo()+"</td>");
		buffer.append("<td style='padding:5px;'>"+bookingRequest.getEmailID()+"</td>");
		buffer.append("</tr>");
		buffer.append("</table>");
		buffer.append("</td>");
		buffer.append("</tr>");
		buffer.append("<tr>");
		buffer.append("<td colspan='2' style='background-color:#0a2d72;padding-left:15px;font-size:20px;color:#ffffff;font-weight:550;height:35px'>");
		buffer.append("Price Details");
		buffer.append("</td>");
		buffer.append("</tr>");
		buffer.append("<tr>");
		buffer.append("<td colspan='2'>");
		buffer.append("<table width='100%' border='0' cellpadding='0' cellspacing='0' style='font-family:Arial, Helvetica, sans-serif;padding:5px 10px;'>");
		
		DecimalFormat format = new DecimalFormat("#0.00");
		String dollarSign = "$";
		double adultTotal = bookingRequest.getFlightResult().getFare().getAdultFare()+bookingRequest.getFlightResult().getFare().getAdultMarkup()+bookingRequest.getFlightResult().getFare().getAdultTax();
		double childTotal = bookingRequest.getFlightResult().getFare().getChildFare()+bookingRequest.getFlightResult().getFare().getChildMarkup()+bookingRequest.getFlightResult().getFare().getChildTax();
		double infantTotal = bookingRequest.getFlightResult().getFare().getInfantFare()+bookingRequest.getFlightResult().getFare().getInfantMarkup()+bookingRequest.getFlightResult().getFare().getInfantTax();
		double infantWsTotal = bookingRequest.getFlightResult().getFare().getInfantWsFare()+bookingRequest.getFlightResult().getFare().getInfantWsMarkup()+bookingRequest.getFlightResult().getFare().getInfantWsTax();

		buffer.append("<tr style='color:#17252A;font-weight:550'>");
		buffer.append("<td style='padding:5px;'><span>"+bookingRequest.getAdults()+"</span> Traveler(s): <span>Adult</span></td>");
		buffer.append("<td style='padding:5px;text-align:right;'>"+dollarSign+""+format.format((adultTotal*bookingRequest.getAdults()))+"</td>");
		buffer.append("</tr>");
		buffer.append("<tr style='color:#17252A;font-weight:400;font-size:14px;'>");
		buffer.append("<td style='padding:5px;'>Flight Charges per adult</td>");
		buffer.append("<td style='padding:5px;text-align:right;'>"+dollarSign+""+format.format(adultTotal)+"</td>");
		buffer.append("</tr>");

		/*buffer.append("<tr style='color:#17252A;font-weight:400;font-size:14px;'>");
		buffer.append("<td style='padding:5px;'>Taxes & Fees per adult</td>");
		buffer.append("<td style='padding:5px;text-align:right;'>"+dollarSign+""+format.format((bookingRequest.getFlightResult().getFare().getAdultMarkup()+bookingRequest.getFlightResult().getFare().getAdultTax()))+"</td>");
		buffer.append("</tr>");*/

		if(bookingRequest.getChild() > 0){
			buffer.append("<tr>");
			buffer.append("<td colspan='2'><hr></td>");
			buffer.append("</tr>");
			buffer.append("<tr style='color:#17252A;font-weight:550'>");
			buffer.append("<td style='padding:5px;'><span>"+bookingRequest.getChild()+"</span> Traveler(s): <span>Child</span></td>");
			buffer.append("<td style='padding:5px;text-align:right;'>"+dollarSign+""+format.format((bookingRequest.getChild()*childTotal))+"</td>");
			buffer.append("</tr>");
			buffer.append("<tr style='color:#17252A;font-weight:400;font-size:14px;'>");
			buffer.append("<td style='padding:5px;'>Flight Charges per Child</td>");
			buffer.append("<td style='padding:5px;text-align:right;'>"+dollarSign+""+format.format(childTotal)+"</td>");
			buffer.append("</tr>");

			/*buffer.append("<tr style='color:#17252A;font-weight:400;font-size:14px;'>");
			buffer.append("<td style='padding:5px;'>Taxes & Fees per Child</td>");
			buffer.append("<td style='padding:5px;text-align:right;'>"+dollarSign+""+format.format((bookingRequest.getFlightResult().getFare().getChildMarkup()+bookingRequest.getFlightResult().getFare().getChildTax()))+"</td>");
			buffer.append("</tr>");*/
		}
		
		if(bookingRequest.getInfants() > 0){
			buffer.append("<tr>");
			buffer.append("<td colspan='2'><hr></td>");
			buffer.append("</tr>");
			buffer.append("<tr style='color:#17252A;font-weight:550'>");
			buffer.append("<td style='padding:5px;'><span>"+bookingRequest.getInfants()+"</span> Traveler(s): <span>Infant</span></td>");
			buffer.append("<td style='padding:5px;text-align:right;'>"+dollarSign+""+format.format((bookingRequest.getInfants()*infantTotal))+"</td>");
			buffer.append("</tr>");
			buffer.append("<tr style='color:#17252A;font-weight:400;font-size:14px;'>");
			buffer.append("<td style='padding:5px;'>Flight Charges per Infant</td>");
			buffer.append("<td style='padding:5px;text-align:right;'>"+dollarSign+""+format.format(infantTotal)+"</td>");
			buffer.append("</tr>");
			
			/*buffer.append("<tr style='color:#17252A;font-weight:400;font-size:14px;'>");
			buffer.append("<td style='padding:5px;'>Taxes & Fees per Infant</td>");
			buffer.append("<td style='padding:5px;text-align:right;'>"+dollarSign+""+format.format((bookingRequest.getFlightResult().getFare().getInfantMarkup()+bookingRequest.getFlightResult().getFare().getInfantTax()))+"</td>");
			buffer.append("</tr>");*/
		}
		
		if(bookingRequest.getInfantsWs() > 0){
			buffer.append("<tr>");
			buffer.append("<td colspan='2'><hr></td>");
			buffer.append("</tr>");
			buffer.append("<tr style='color:#17252A;font-weight:550'>");
			buffer.append("<td style='padding:5px;'><span>"+bookingRequest.getInfantsWs()+"</span> Traveler(s): <span>Infant(WS)</span></td>");
			buffer.append("<td style='padding:5px;text-align:right;'>"+dollarSign+""+format.format((bookingRequest.getInfantsWs()*infantWsTotal))+"</td>");
			buffer.append("</tr>");
			buffer.append("<tr style='color:#17252A;font-weight:400;font-size:14px;'>");
			buffer.append("<td style='padding:5px;'>Flight Charges per Infant(WS)</td>");
			buffer.append("<td style='padding:5px;text-align:right;'>"+dollarSign+""+format.format(infantWsTotal)+"</td>");
			buffer.append("</tr>");

			/*buffer.append("<tr style='color:#17252A;font-weight:400;font-size:14px;'>");
			buffer.append("<td style='padding:5px;'>Taxes & Fees per Infant(WS)</td>");
			buffer.append("<td style='padding:5px;text-align:right;'>"+dollarSign+""+format.format((bookingRequest.getFlightResult().getFare().getInfantMarkup()+bookingRequest.getFlightResult().getFare().getInfantTax()))+"</td>");
			buffer.append("</tr>");*/
		}
		
		double ctPrice=0.00;
		if(bookingRequest.getChangeableTickets().equalsIgnoreCase("Yes")){
			ctPrice = bookingRequest.getChangeableTicketAmount();
			buffer.append("<tr>");
			buffer.append("<td colspan='2'><hr></td>");
			buffer.append("</tr>");
			buffer.append("<tr style='color:#17252A;font-weight:550'>");
			buffer.append("<td style='padding:5px;'> "+bookingRequest.getChangeableTicketType()+" Ticket Fee </td>");
			buffer.append("<td style='padding:5px;text-align:right;'>$"+format.format(bookingRequest.getChangeableTicketAmount())+"</td>");
			buffer.append("</tr>");
		}
		
		double cpPrice=0.00;
		if(bookingRequest.getCancellationProtectTaken().equalsIgnoreCase("Yes")){
			cpPrice = bookingRequest.getCancellationProtectAmount();
			buffer.append("<tr>");
			buffer.append("<td colspan='2'></td>");
			buffer.append("</tr>");
			buffer.append("<tr style='color:#17252A;font-weight:550'>");
			buffer.append("<td style='padding:5px;'> Cancellation Protect Fee </td>");
			buffer.append("<td style='padding:5px;text-align:right;'>$"+format.format(bookingRequest.getCancellationProtectAmount())+"</td>");
			buffer.append("</tr>");
		}
		
		double wcPrice=0.00;
		if(bookingRequest.getWebcheckinTaken().equalsIgnoreCase("Yes")){
			wcPrice = bookingRequest.getWebcheckinAmount();
			buffer.append("<tr>");
			buffer.append("<td colspan='2'></td>");
			buffer.append("</tr>");
			buffer.append("<tr style='color:#17252A;font-weight:550'>");
			buffer.append("<td style='padding:5px;'> Web Check-In Fee </td>");	
			buffer.append("<td style='padding:5px;text-align:right;'>$"+format.format(wcPrice)+"</td>");
			buffer.append("</tr>");
		}
		
		/*double bnPrice=0.00;
		if(bookingRequest.getBundleFareTaken().equalsIgnoreCase("Yes")){
			bnPrice = bookingRequest.getBundleFareAmount();
			buffer.append("<tr>");
			buffer.append("<td colspan='2'></td>");
			buffer.append("</tr>");
			buffer.append("<tr style='color:#17252A;font-weight:550'>");
			buffer.append("<td style='padding:5px;'> Bundle Fare </td>");
			buffer.append("<td style='padding:5px;text-align:right;'>$"+format.format(bnPrice)+"</td>");
			buffer.append("</tr>");
		}

		double snPrice=0.00;
		if(bookingRequest.getSingleFareTaken().equalsIgnoreCase("Yes")){
			snPrice = bookingRequest.getSingleFareAmount();
			buffer.append("<tr>");
			buffer.append("<td colspan='2'></td>");
			buffer.append("</tr>");
			buffer.append("<tr style='color:#17252A;font-weight:550'>");
			buffer.append("<td style='padding:5px;'> "+bookingRequest.getSingleBundleValue()+" </td>");
			buffer.append("<td style='padding:5px;text-align:right;'>$"+format.format(snPrice)+"</td>");
			buffer.append("</tr>");
		}*/
		
		buffer.append("<tr style='color:#17252A;font-weight:550;background-color:#eeeeee;'>");
		buffer.append("<td style='padding:5px;'>Final Total</td>");
		buffer.append("<td style='padding:5px;text-align:right;'>"+dollarSign+""+format.format(bookingRequest.getFlightResult().getFare().getGrandTotal()+ctPrice+cpPrice+wcPrice)+"</td>");
		buffer.append("</tr>");
		buffer.append("<tr style='text-align:center;font-size:13px;color:#333;'>");
		buffer.append("<td colspan='2' style='padding:5px;'>NOTE: All Fares displayed are quoted in USD and inclusive of base fare, taxes and all fees. Additional baggage fees may apply as per the airline policies.</td>");
		buffer.append("</tr>");
		buffer.append("</table>");
		buffer.append("</td>");
		buffer.append("</tr>");
		buffer.append("<tr>");
		buffer.append("<td colspan='2'><hr></td>");
		buffer.append("</tr>");
		buffer.append("<tr style='text-align:center;font-weight:550;'>");
		buffer.append("<td style='padding-top:20px;'>");
		buffer.append("<a href='https://www.farehutz.us/privacy-policy' target='_blank' style='color:#0a2d72;text-decoration:none;'>Privacy Policy</a>");
		buffer.append("</td>");
		buffer.append("<td style='padding-top:20px;'>");
		buffer.append("<a href='https://www.farehutz.us/contactus' target='_blank' style='color:#0a2d72;text-decoration:none;'>Support</a>");
		buffer.append("</td>");
		buffer.append("</tr>");
		buffer.append("<tr style='text-align:center;font-size:14px;color:#666666'>");
		buffer.append("<td style='padding:20px 15px 0 15px;'>");
		buffer.append("We are dedicated towards protecting your privacy. See our privacy policy for details.");
		buffer.append("</td>");
		buffer.append("<td style='padding:20px 15px 0 15px;'>");
		buffer.append("Contact our customer support team by phone & email 24x7 Toll Free "+sourceTFN+".");
		buffer.append("</td>");
		buffer.append("</tr>");
		
		buffer.append("<tr style='text-align:center;font-size:18px;color:#666666;font-weight:500;'>");
		buffer.append("<td colspan='2' style='padding-top:40px'>");
		buffer.append("Flight Booking Terms & Policies");
		buffer.append("</td>");
		buffer.append("</tr>");
		
		buffer.append("<tr>");
		buffer.append("<td colspan='2'>");
		buffer.append("<table width='100%' border='0' cellpadding='0' cellspacing='0' style='padding:5px 20px;'>");
		buffer.append("<tr>");
		buffer.append("<td width='100%' colspan='2' style='color:#666666;font-size:17px;font-weight:500;padding:10px 0;'>Booking Policy:</td>");
		buffer.append("</tr>");
		buffer.append("<tr>");
		buffer.append("<td width='100%' colspan='2' style='font-size:14px;color:#999999;font-weight:400;font-family:Arial, Helvetica, sans-serif;'>");
		buffer.append("The above itinerary and agency reference number is for information only.");
		buffer.append("</td>");
		buffer.append("</tr>");

		buffer.append("<tr>");
		buffer.append("<td width='100%' colspan='2' style='font-size:14px;color:#999999;font-weight:400;font-family:Arial, Helvetica, sans-serif;'>");
		buffer.append("You would receive your E-tickets and airlines confirmation in a separate email.");
		buffer.append("</td>");
		buffer.append("</tr>");

		buffer.append("<tr>");
		buffer.append("<td width='100%' colspan='2' style='font-size:14px;color:#999999;font-weight:400;font-family:Arial, Helvetica, sans-serif;'>");
		buffer.append("Your tickets will be issued once the payment is charged. Fares are not guranteed untill the payment is charged.");
		buffer.append("</td>");
		buffer.append("</tr>");

		buffer.append("<tr>");
		buffer.append("<td width='100%' colspan='2' style='font-size:14px;color:#999999;font-weight:400;font-family:Arial, Helvetica, sans-serif;'>");
		buffer.append("All booking and fares are not guaranteed until ticketed.");
		buffer.append("</td>");
		buffer.append("</tr>");

		buffer.append("<tr>");
		buffer.append("<td width='100%' colspan='2' style='font-size:14px;color:#999999;font-weight:400;font-family:Arial, Helvetica, sans-serif;'>");
		buffer.append("Your credit card may be billed in multiple/split charges totaling the above amount.");
		buffer.append("</td>");
		buffer.append("</tr>");

		buffer.append("<tr>");
		buffer.append("<td width='100%' colspan='2' style='font-size:14px;color:#999999;font-weight:400;font-family:Arial, Helvetica, sans-serif;'>");
		buffer.append("The payment would be processed after billing verification and authentication done by our card verification team if required.");
		buffer.append("</td>");
		buffer.append("</tr>");

		buffer.append("<tr>");
		buffer.append("<td width='100%' colspan='2' style='font-size:14px;color:#999999;font-weight:400;font-family:Arial, Helvetica, sans-serif;'>");
		buffer.append("If there is a problem with processing the payment, you would be notified instantly.");
		buffer.append("</td>");
		buffer.append("</tr>");

		buffer.append("<tr>");
		buffer.append("<td width='100%' colspan='2' style='font-size:14px;color:#999999;font-weight:400;font-family:Arial, Helvetica, sans-serif;'>");
		buffer.append("In case you do not receive an email or call within 24 hours of making this reservation. Then please call us on the number mentioned on the https://www.farehutz.us ("+sourceTFN+").");
		buffer.append("</td>");
		buffer.append("</tr>");

		buffer.append("<tr>");
		buffer.append("<td width='100%' colspan='2' style='font-size:14px;color:#999999;font-weight:400;font-family:Arial, Helvetica, sans-serif;'>");
		buffer.append("We strongly recommend all travelers to confirm the status of their flight at least 24-48 hours before departure.");
		buffer.append("</td>");
		buffer.append("</tr>");

		buffer.append("<tr>");
		buffer.append("<td width='100%' colspan='2' style='color:#666666;font-size:17px;font-weight:500;padding:10px 0;'>Change Rules:</td>");
		buffer.append("</tr>");

		buffer.append("<tr>");
		buffer.append("<td width='100%' colspan='2' style='font-size:14px;color:#999999;font-weight:400;font-family:Arial, Helvetica, sans-serif;'>");
		buffer.append("Changes (travel dates): All Changes will incur an administrative fee from the airline and agency in addition to the fare difference.");
		buffer.append("</td>");
		buffer.append("</tr>");

		buffer.append("<tr>");
		buffer.append("<td width='100%' colspan='2' style='font-size:14px;color:#999999;font-weight:400;font-family:Arial, Helvetica, sans-serif;'>");
		buffer.append("Changes (name): All tickets are nontransferable. All Changes will incur an administrative fee from the airline and agency in addition to the fare change.");
		buffer.append("</td>");
		buffer.append("</tr>");

		buffer.append("<tr>");
		buffer.append("<td width='100%' colspan='2' style='font-size:14px;color:#999999;font-weight:400;font-family:Arial, Helvetica, sans-serif;'>");
		buffer.append("Cancel / Refund: Not allowed.");
		buffer.append("</td>");
		buffer.append("</tr>");

		buffer.append("<tr>");
		buffer.append("<td width='100%' colspan='2' style='color:#666666;font-size:17px;font-weight:500;padding:10px 0;'>Flight Rules and Restrictions:</td>");
		buffer.append("</tr>");

		buffer.append("<tr>");
		buffer.append("<td width='100%' colspan='2' style='font-size:14px;color:#999999;font-weight:400;font-family:Arial, Helvetica, sans-serif;'>");
		buffer.append("Farehutz advises all passengers to ensure to have all travel documents including Passports, and required visas issued and presented at the time of travel."); 
		buffer.append("</td>");
		buffer.append("</tr>");

		buffer.append("<tr>");
		buffer.append("<td width='100%' colspan='2' style='font-size:14px;color:#999999;font-weight:400;font-family:Arial, Helvetica, sans-serif;'>");
		buffer.append("Farehutz advises all passengers to review your tickets and itinerary upon receipt. All times shown in the itinerary are local times."); 
		buffer.append("</td>");
		buffer.append("</tr>");

		buffer.append("<tr>");
		buffer.append("<td width='100%' colspan='2' style='font-size:14px;color:#999999;font-weight:400;font-family:Arial, Helvetica, sans-serif;'>");
		buffer.append("All passengers are recommended to be present at the airport 3 hours prior to departure for international departures, and 2 prior to domestic travel."); 
		buffer.append("</td>");
		buffer.append("</tr>");

		buffer.append("<tr>");
		buffer.append("<td width='100%' colspan='2' style='font-size:14px;color:#999999;font-weight:400;font-family:Arial, Helvetica, sans-serif;'>");
		buffer.append("All International flights must be reconfirmed 72 hours prior to departure."); 
		buffer.append("</td>");
		buffer.append("</tr>");

		buffer.append("<tr>");
		buffer.append("<td width='100%' colspan='2' style='font-size:14px;color:#999999;font-weight:400;font-family:Arial, Helvetica, sans-serif;'>");
		buffer.append("All tickets returned for refund or reissue in addition to any applicable airline charges."); 
		buffer.append("</td>");
		buffer.append("</tr>");
		
		buffer.append("<tr>");
		buffer.append("<td width='100%' colspan='2' style='font-size:14px;color:#999999;font-weight:400;font-family:Arial, Helvetica, sans-serif;'>");
		buffer.append("Farehutz does not assume responsibility for and will not compensate passengers for travel interruptions caused by matters beyond our control including those caused by Acts of God and Nature, overbooking and or changes made by carriers/hotels/car rental companies/tour operators, etc."); 
		buffer.append("</td>");
		buffer.append("</tr>");
		
		buffer.append("<tr>");
		buffer.append("<td width='100%' colspan='2' style='font-size:14px;color:#999999;font-weight:400;font-family:Arial, Helvetica, sans-serif;'>");
		buffer.append("Farehutz has made passenger completely aware of the importance of travel insurance and the conditions that apply to tickets."); 
		buffer.append("</td>");
		buffer.append("</tr>");
		
		buffer.append("<tr>");
		buffer.append("<td width='100%' colspan='2' style='font-size:14px;color:#999999;font-weight:400;font-family:Arial, Helvetica, sans-serif;'>");
		buffer.append("Farehutz will not be responsible for any expense incurred as a result of the refusal to purchase travel insurance."); 
		buffer.append("</td>");
		buffer.append("</tr>");
		
		buffer.append("<tr>");
		buffer.append("<td width='100%' colspan='2' style='font-size:14px;color:#999999;font-weight:400;font-family:Arial, Helvetica, sans-serif;'>");
		buffer.append("International/Domestic Passengers are responsible for all travel documentation including visas. Visas may be required for the entire journey both for the destination and/or transit. Visas must be secured before ticket issue. Tickets cannot be refunded for failure to obtain a visa"); 
		buffer.append("</td>");
		buffer.append("</tr>");

		buffer.append("<tr>");
		buffer.append("<td width='100%' colspan='2' style='font-size:14px;color:#999999;font-weight:400;font-family:Arial, Helvetica, sans-serif;'>");
		buffer.append("Please make a note of this number or print this email for your records. This is a confirmation of your booking request. We will send you the ticket shortly."); 
		buffer.append("</td>");
		buffer.append("</tr>");

		buffer.append("</table>");
		buffer.append("</td>");
		buffer.append("</tr>");
		
		buffer.append("<tr>");
		buffer.append("<td colspan='2'><hr></td>");
		buffer.append("</tr>");
		buffer.append("<tr>");
		buffer.append("<td colspan='2' style='text-align:center;padding:3%;color:#17252A;font-size:15px;'>© Copyright 2017-2024 All right Reserved Farehutz.us</td>");
		buffer.append("</tr>");
		buffer.append("</table>");
		buffer.append("</body>");
		buffer.append("</html>");

		return buffer.toString();
	}

	public String getDecimal2(double value){
		NumberFormat nf= NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		//System.out.println("Double Value upto 2 decimal places: " +nf.format(value));
		return nf.format(value);
	}

	public String buildContactEmail(ContactForm form){
		StringBuffer buffer=new StringBuffer(); 
		buffer.append("First Name : "+form.getFirstName()+"<br>");
		buffer.append("Last Name : "+form.getLastName()+"<br>");
		buffer.append("Email : "+form.getEmail()+"<br>");
		buffer.append("Phone : "+form.getPhone()+"<br>");
		buffer.append("Message : "+form.getMessage()+"<br>");
		return buffer.toString();
	}

}
