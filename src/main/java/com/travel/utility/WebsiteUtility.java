package com.travel.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app")
public class WebsiteUtility {
	
	public static String homePageTitle="Cheap Flight Tickets, Airline Deals & Travel Offers | Farescrew";
	
	public static String DESCRIPTION="Book cheap flights and compare airline deals with Farescrew. Find the lowest airfare, last-minute tickets, and discounted travel packages in USA. Fast, secure, and easy booking.";
	
	public static String KEYWORD="cheap flights, flight booking, airline tickets, discount flights, airfare deals, travel deals, last minute flights, cheap airfare, low cost airlines.";
	
	public static String robots="noindex, follow";
	
	public static String oglocale="";
	public static String ogtype="website";
	public static String ogdescription="Search, compare, and book the cheapest flights and exclusive airline deals. Trusted travel booking with secure checkout.";
	public static String ogtitle="Cheap Flight Tickets, Airline Deals & Travel Offers | Farescrew";
	public static String ogurl="https://www.farescrew.com/";
	public static String ogsite_name="Farescrew";
	public static String ogimage="https://www.farescrew.com/images/og-cover.jpg";
	public static String ogimagealt="Farescrew - Cheap Flight Deals";
	public static String twittercard="summary_large_image";
	public static String twitterimage="https://www.farescrew.com/images/og-cover.jpg";
	public static String twittertitle="Cheap Flight Tickets, Airline Deals & Travel Offers | Farescrew";
	public static String twittersite="@Farescrew";
	public static String twitterdescription="Find cheap flights, compare airfare, and book secure travel deals worldwide at Farescrew.";
	
	public static String homePageTfn="+1-888-509-2514";
	public static String websiteName="farescrew.com";
	public static String websiteUrl="https://www.farescrew.com/";
	public static String websiteEmail="support@farescrew.com";
	public static String websiteSenderEmail="support@farescrew.com";
	public static String websiteReceiveEmail="booking@farescrew.com";
	public static String websiteEmailPassword="vpbb sweg ublp tdvj";
	public static String websiteCompany="Friendztravel UK Limited";
	public static String websiteAddress="1145 E 35th St Brooklyn New York 11210 USA";
	public static String copyRightYear="2022-2025";
	public static String websiteCurrency="USD";
	 // social media list (dynamic)
    public static List<SocialLink> social = new ArrayList<>();
    
    public static List<SocialLink> headeLink = new ArrayList<>();
    public static  Map<String, String> tfnMap = new HashMap<>();
  

    // static initializer OR you can fill it manually anywhere
    static {
        social.add(new SocialLink("facebook", "https://www.facebook.com/farescrew/","fab fa-facebook-f"));
        social.add(new SocialLink("twitter", "https://x.com/farescrew","fab fa-twitter"));
        social.add(new SocialLink("instagram", "https://www.instagram.com/farescrew/","fab fa-instagram"));
        // add more if needed
                
        headeLink.add(new SocialLink("Flight", "/flight","fa fa-instagram"));
        headeLink.add(new SocialLink("Hotel", "/hotel","fa fa-instagram"));
        headeLink.add(new SocialLink("Cars", "/cars","fa fa-instagram"));
        headeLink.add(new SocialLink("Cruise", "/cruise","fa fa-instagram"));
        headeLink.add(new SocialLink("Vacation", "/Packages","fa fa-instagram"));
        
        tfnMap.put("online", homePageTfn);
        tfnMap.put("skyscanner", homePageTfn);
        tfnMap.put("fclist", homePageTfn);
        tfnMap.put("newsletter", homePageTfn);
        tfnMap.put("admitad", homePageTfn);
        tfnMap.put("jetradar", homePageTfn);
        
    }
}
