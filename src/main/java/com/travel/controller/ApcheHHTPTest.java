package com.travel.controller;

import java.io.IOException;
import java.util.Base64;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ApcheHHTPTest {
	private static final String CLIENT_ID = "41AGeWT4l39qJi86iPQ9RYs6agEy5efW"; //"your-client-id";	//
    private static final String CLIENT_SECRET = "BsHMzWrHAUN0ASjl";	//"your-client-secret";
	private static final String TOKEN_URL = "https://api.trustpilot.com/v1/oauth/oauth-business-users-for-applications/accesstoken";
	private static final String INVITATION_URL = "https://api.trustpilot.com/v1/private/reviews/invitation";
	
	
	public static void main(String[] args) {
		try {
			// Obtain Access Token
			String accessToken = getAccessToken(CLIENT_ID, CLIENT_SECRET);

			// Create Invitation
			String invitationLink = createInvitation(accessToken, new InvitationData(
					"FA12345",
					"Sandy",
					new String[]{"tag1", "tag2"},
					"en-US",
					"sandy@gmail.com",
					"http://trustpilot.com"
					));
			
			System.out.println("InvitationLink:: "+invitationLink);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static String getAccessToken(String clientId, String clientSecret) throws IOException {
		String auth = clientId + ":" + clientSecret;
		String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());
		
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(TOKEN_URL);
		httpPost.setHeader("Authorization", "Basic " + encodedAuth);
		httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
		//httpPost.setEntity(new StringEntity("grant_type=client_credentials"));
		httpPost.setEntity(new StringEntity("grant_type=password&username=support@farehutz.us&password=Travel@789"));
		
		CloseableHttpResponse response = client.execute(httpPost);
		String responseBody = EntityUtils.toString(response.getEntity());
		response.close();
		client.close();

		if (response.getStatusLine().getStatusCode() != 200) {
			throw new RuntimeException("Failed to obtain access token: " + responseBody);
		}

		return parseAccessToken(responseBody);
	}
	
	private static String parseAccessToken(String responseBody) {
		int startIndex = responseBody.indexOf("access_token\":\"") + "access_token\":\"".length();
		int endIndex = responseBody.indexOf("\"", startIndex);
		return responseBody.substring(startIndex, endIndex);
	}

	private static String createInvitation(String accessToken, InvitationData invitationData) throws IOException {
		CloseableHttpClient client = HttpClients.createDefault();
		ObjectMapper objectMapper = new ObjectMapper();
		String requestBody = objectMapper.writeValueAsString(invitationData);

		HttpPost httpPost = new HttpPost(INVITATION_URL);
		httpPost.setHeader("Authorization", "Bearer " + accessToken);
		httpPost.setHeader("Content-Type", "application/json");
		httpPost.setEntity(new StringEntity(requestBody));

		CloseableHttpResponse response = client.execute(httpPost);
		String responseBody = EntityUtils.toString(response.getEntity());
		response.close();
		client.close();

		if (response.getStatusLine().getStatusCode() != 200) {
			throw new RuntimeException("Failed to create invitation: " + responseBody);
		}

		return responseBody;
	}
	
	public static class InvitationData {
		public String referenceId;
		public String name;
		public String[] tags;
		public String locale;
		public String email;
		public String redirectUri;

		public InvitationData(String referenceId, String name, String[] tags, String locale, String email, String redirectUri) {
			this.referenceId = referenceId;
			this.name = name;
			this.tags = tags;
			this.locale = locale;
			this.email = email;
			this.redirectUri = redirectUri;
		}
	}
}

