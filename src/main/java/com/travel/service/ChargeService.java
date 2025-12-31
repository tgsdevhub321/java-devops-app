package com.travel.service;

import java.text.ParseException;

public interface ChargeService 
{
	public String getChargeService(String bookingId, String invoiceID, double amount, String description, String returnDate) throws ParseException;
	
}
