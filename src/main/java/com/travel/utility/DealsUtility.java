package com.travel.utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.travel.bean.GenericDealRequest;
import com.travel.object.deal.deal_new.DealResponse;

public class DealsUtility {
	
	public static List<DealResponse> getDeals(String prefix, String pageValue, String currency, String limit,  HttpServletRequest request) {
		System.out.println("dealsType::"+prefix+"-"+pageValue+"-"+currency+"-"+limit);
		
		String url = "https://funnelsutra.com//redis/getDealsByFilters";
		
		GenericDealRequest genericDealRequest = new GenericDealRequest();
		
		genericDealRequest.setFilters(new String[]{prefix + pageValue});
		genericDealRequest.setCurrency(currency);
		genericDealRequest.setLimit(limit);
		
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			System.out.println("genericDealRequest::"+mapper.writeValueAsString(genericDealRequest));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("url::"+url);
		
		RestTemplate restTemplate = new RestTemplate();
		
		
		DealResponse[] response = null;

		try {
		    response = restTemplate.postForObject(url, genericDealRequest, DealResponse[].class);
		    System.out.println("response::"+mapper.writeValueAsString(response));
		} catch (Exception e) {
		    e.printStackTrace();
		}

		List<DealResponse> flightDeals = response != null ? Arrays.asList(response) : new ArrayList<>();
		
		return flightDeals;
	}

}
