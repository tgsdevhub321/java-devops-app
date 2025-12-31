package com.travel.utility;

import com.travel.object.genericRequest.CarForm;
import com.travel.object.genericRequest.CruiseForm;
import com.travel.object.genericRequest.HotelForm;
/*import com.travel.object.genericRequest.HotelForm;*/
import com.travel.object.genericRequest.PackageForm;

public class OtherEmailer
{
	public String buildHotelFormEmail(HotelForm form){
		StringBuffer buffer=new StringBuffer(); 
		buffer.append("Full Name : "+form.getFullName()+"<br>");
		buffer.append("Check Id Date : "+form.getCheckInDate()+"<br>");
		buffer.append("Check Out Date : "+form.getCheckOutDate()+"<br>");
		buffer.append("No of Guests : "+form.getNoOfGuests()+"<br>");
		buffer.append("No of  Nights : "+form.getNoOfNights()+"<br>");
		buffer.append("Phone Number : "+form.getPhoneNumber()+"<br>");
		buffer.append("Email Address : "+form.getEmail()+"<br>");
		return buffer.toString();
	}
	
	public String buildCarFormEmail(CarForm form){
		StringBuffer buffer=new StringBuffer(); 
		buffer.append("Full Name : "+form.getFullName()+"<br>");
		buffer.append("Pick up Date : "+form.getPickUpDate()+"<br>");
		buffer.append("Pick up Time : "+form.getPickUpTime()+"<br>");
		buffer.append("Drop off Date : "+form.getDropOffDate()+"<br>");
		buffer.append("Drop off Time : "+form.getDropOffTime()+"<br>");
		buffer.append("Pick up Location : "+form.getPickUpLocation()+"<br>");
		buffer.append("Drop off Location : "+form.getDropOffLocation()+"<br>");
		buffer.append("Phone Number : "+form.getPhoneNumber()+"<br>");
		buffer.append("Email Address : "+form.getEmail()+"<br>");
		return buffer.toString();
	}
	
	/*public String buildCruiseFormEmail(CruiseForm form){
		StringBuffer buffer=new StringBuffer(); 
		buffer.append("Destination : "+form.getdestination()+"<br>");
		buffer.append("Cruise Line : "+form.getcruiseLine()+"<br>");
		buffer.append("Ship Name : "+form.getshipName()+"<br>");
		buffer.append("No of Nights : "+form.getnoOfNights()+"<br>");
		buffer.append("Full Name : "+form.getFullName()+"<br>");
		buffer.append("Email Address : "+form.getEmail()+"<br>");
		buffer.append("Phone Number : "+form.getPhoneNumber()+"<br>");
		return buffer.toString();
	}*/
	
	public String buildPackageFormEmail(PackageForm form){
		StringBuffer buffer=new StringBuffer(); 
		buffer.append("Destination : "+form.getdestination()+"<br>");
		buffer.append("No of Days : "+form.getnoOfDays()+"<br>");
		buffer.append("No of Travellers : "+form.getnoOfTravellers()+"<br>");
		buffer.append("Full Name : "+form.getFullName()+"<br>");
		buffer.append("Email Address : "+form.getEmail()+"<br>");
		buffer.append("Phone Number : "+form.getPhoneNumber()+"<br>");
		return buffer.toString();
	}
}