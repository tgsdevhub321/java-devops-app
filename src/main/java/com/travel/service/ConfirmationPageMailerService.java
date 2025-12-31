package com.travel.service;

public interface ConfirmationPageMailerService {
	
	public String getEmailContent(String searchId, int siteId);
	public String getConfimationPageContent(String sessionId, int siteId);

}
