package com.travel.service;

import com.travel.object.bookingrequest.BookingRequest;

public interface ConfirmationDBService {

	public BookingRequest getConfirmationService(BookingRequest bookingRequestNew, String sessionId);
	
}
