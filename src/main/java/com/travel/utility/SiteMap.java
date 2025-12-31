package com.travel.utility;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.travel.object.Pages;
import com.travel.object.sitmapdata.AllAirlines;

public class SiteMap
{	
	public void getSitemap(HttpServletRequest request){
		RestTemplate rest = new RestTemplate();
		ObjectMapper mapper = new ObjectMapper(); 
		Pages reqObj=new Pages();
		reqObj.setSiteId("39"); 
		reqObj.setPageType("Airline");
		String airlinePage=rest.postForObject("http://54.70.41.205/content/sitemap?authcode=farehuts", reqObj, String.class);
		//System.out.println("AirlinePageRS"+airlinePage);

		AllAirlines allAirlines=null;
		try
		{
			allAirlines = mapper.readValue(airlinePage, AllAirlines.class);
		}
		catch(Exception e){
			e.printStackTrace();
		}

		request.getSession().setAttribute("airlineMap", allAirlines.getResponse());

		reqObj.setSiteId("39");
		reqObj.setPageType("City");

		try {
			System.out.println("City Pages Request::--->  " + mapper.writeValueAsString(reqObj));
		} catch (Exception e) {
			e.printStackTrace();
		}

		airlinePage = rest.postForObject("http://54.70.41.205/content/sitemap?authcode=farehuts", reqObj, String.class);
		AllAirlines allCity = null;

		String fromCountry = "US"; // For US
		List<String> cityList = new ArrayList<String>();
		List<String> cityListDomestic = new ArrayList<String>();
		List<String> cityListInternational = new ArrayList<String>();

		try {
			allCity = mapper.readValue(airlinePage, AllAirlines.class);
			System.out.println("City Pages Response::--->  " + mapper.writeValueAsString(allCity));

			for (int i = 0; i < allCity.getResponse().size(); i++) {
				String toCountry = Utility.getCountryCodeWithAPI(allCity.getResponse().get(i).getPageValue());
				cityList.add(allCity.getResponse().get(i).getPageName());
				
				String entry = allCity.getResponse().get(i).getUrl() + ',' +allCity.getResponse().get(i).getPageValue() + ',' + allCity.getResponse().get(i).getPageName();
				if (fromCountry.equals(toCountry)) {
					cityListDomestic.add(entry);
				} else {
					cityListInternational.add(entry);
				}
			}

			System.out.println("Domestic City List ----->" + cityListDomestic);
			System.out.println("International City List ----->" + cityListInternational);

			request.getSession().setAttribute("domesticCityList", cityListDomestic);
			request.getSession().setAttribute("internationalCityList", cityListInternational);
			request.getSession().setAttribute("cityList", cityList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.getSession().setAttribute("cityMap", allCity.getResponse());

//		reqObj.setSiteId("39");
//		reqObj.setPageType("Deals");
//		airlinePage=rest.postForObject("http://54.70.41.205/content/sitemap?authcode=farehuts",reqObj,String.class);
//		//System.out.println("GenericPageRS"+airlinePage);
//		AllAirlines allGenric=null;
//		try
//		{
//			allGenric = mapper.readValue(airlinePage, AllAirlines.class);
//		}
//		catch(Exception e){
//			e.printStackTrace();
//		}
//		request.getSession().setAttribute("genericMap", allGenric.getResponse());
	}
}
