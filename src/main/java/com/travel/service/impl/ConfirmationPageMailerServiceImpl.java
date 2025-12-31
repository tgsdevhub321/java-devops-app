package com.travel.service.impl;

import java.security.SecureRandom;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.travel.service.ConfirmationPageMailerService;

@Service
public class ConfirmationPageMailerServiceImpl implements ConfirmationPageMailerService {

	@Override
	public String getEmailContent(String searchId, int siteId) {
		String emailBody = "";
		try {

			String url = "https://authorize.farehutz.ca/confirm/email/" + searchId + "/" + siteId;
			System.out.println("Fetching confirmation HTML from: " + url);
			disableSslVerification();
			RestTemplate restTemplate = new RestTemplate();
			emailBody = restTemplate.postForObject(url, null, String.class);

			System.out.println("email content post::" + emailBody);

			System.out.println("External confirmation page received successfully.");

		} catch (Exception ex) {
			System.err.println("Error calling external confirmation API: " + ex.getMessage());
			ex.printStackTrace();
			emailBody = "<h2>Unable to load confirmation page at the moment. Please try again later.</h2>";
		}
		return emailBody;
	}

	@Override
	public String getConfimationPageContent(String sessionId, int siteId) {
		String htmlResponse = "";
		try {
			String url = "https://authorize.farehutz.ca/confirm/page/" + sessionId + "/" + siteId;
			System.out.println("url: " + url);
			disableSslVerification();
			RestTemplate restTemplate = new RestTemplate();
			htmlResponse = restTemplate.postForObject(url, null, String.class);
			System.out.println("comfirmation page res post::" + htmlResponse);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return htmlResponse;
	}
	
	public static void disableSslVerification() throws Exception {
		TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
			public X509Certificate[] getAcceptedIssuers() {
				return new X509Certificate[0];
			}

			public void checkClientTrusted(X509Certificate[] certs, String authType) {
			}

			public void checkServerTrusted(X509Certificate[] certs, String authType) {
			}
		} };

		SSLContext sc = SSLContext.getInstance("TLS");
		sc.init(null, trustAllCerts, new SecureRandom());
		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

		HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);
	}

}
