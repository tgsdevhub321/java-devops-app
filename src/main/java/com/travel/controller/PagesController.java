package com.travel.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.travel.bean.ContactForm;
import com.travel.bean.FlightSearch;
import com.travel.object.email.EmailFormat;
import com.travel.object.newsletter.NewsletterRequest;
import com.travel.object.pagerequest.PageRequest;
import com.travel.object.pageresponse.PageResponse;
import com.travel.object.review.ReviewRequest;
import com.travel.service.RestDataService;
import com.travel.utility.Emails;
import com.travel.utility.SiteMap;
import com.travel.utility.Utility;
import com.travel.utility.WebsiteUtility;

@Controller
public class PagesController {
	@Value("${pageApiUrl}")
	private String pageApiUrl;

	@Value("${apiUrl}")
	private String apiUrl;

	@Value("${siteName}")
	private String siteName;

	@Value("${siteId}")
	private int siteId;

	@Value("${password}")
	private String password;

	@Autowired
	MailController mailService;

	@GetMapping("/faqs")
	public String faqs() {
		return "faqs";
	}

	@GetMapping("/contactus")
	public String contactuss(@ModelAttribute ContactForm contactForm) {
		return "contact-us";
	}

	@GetMapping("/disclaimer")
	public String disclaimer(@ModelAttribute ContactForm contactForm) {
		return "disclaimer";
	}

	@PostMapping("/contactus/submit")
	public @ResponseBody String contactusPost(@RequestBody ContactForm contactForm, Model model) {

		System.out.println(contactForm.getFirstName());

		String status = "false";
		if (contactForm.getFirstName() == null || contactForm.getFirstName().isEmpty()) {
			return "FName";
		}
		if (contactForm.getLastName() == null || contactForm.getLastName().isEmpty()) {
			return "LName";
		}
		if (contactForm.getPhone() == null || contactForm.getPhone().isEmpty()) {
			return "MobName";
		}
		if (contactForm.getEmail() == null || contactForm.getEmail().isEmpty()) {
			return "EmlName";
		}
		if (contactForm.getMessage() == null || contactForm.getMessage().isEmpty()) {
			return "CmtName";
		}
		if (contactForm.getCapchaCode() == null
				|| !contactForm.getCapchaCode().equalsIgnoreCase(contactForm.getMatCapchaCode())) {
			return "capError";
		}

		Emails email = new Emails();
		String emailBody = email.buildContactEmail(contactForm);
		// System.out.println(emailBody);
		EmailFormat emailSend = new EmailFormat();
		emailSend.setBookingID("");
		emailSend.setFromEmail(WebsiteUtility.websiteSenderEmail);
		emailSend.setToEmail(WebsiteUtility.websiteReceiveEmail);
		emailSend.setCcEmail(WebsiteUtility.websiteReceiveEmail);
		// emailSend.setBccEmail("");
		emailSend.setMailBody(emailBody);
		emailSend.setMailSubject("Contact Us Query " + contactForm.getLastName());

		try {
			status = mailService.SendMail(emailSend, "smtp.gmail.com", "465", WebsiteUtility.websiteEmailPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "true";
	}

	@GetMapping("/aboutus")
	public String aboutus() {
		return "aboutus";
	}

	@GetMapping("/terms-and-conditions")
	public String termsandconditions() {
		return "terms-conditions";
	}

	@GetMapping("/privacy-policy")
	public String privacypolicy() {
		return "privacy-policy";
	}
	
	@GetMapping("/cookie-policy")
	public String cookie() {
		return "cookie-policy";
	}

	@GetMapping("/sitemap")
	public String sitemap(HttpServletRequest request) {
		com.travel.utility.SiteMap tc = new SiteMap();
		tc.getSitemap(request);
		return "sitemap";
	}

	@GetMapping("/city/flights-to-{page}")
	public String cities(@PathVariable("page") String page, @ModelAttribute FlightSearch flightSearch, @ModelAttribute ReviewRequest reviewRequest, Model model) {
		model.addAttribute("airlineList", Utility.getAirlines());
		System.out.println("PagesController::City::Page Value:: " + page);
		PageRequest pageRequest = new PageRequest();
		PageResponse pageResponse = new PageResponse();
		RestTemplate rest = new RestTemplate();
		ObjectMapper mapper = new ObjectMapper();
		String code = page.substring(page.lastIndexOf("-") + 1, page.length());
		String url = page.substring(0, page.lastIndexOf("-"));
		pageRequest.setPageType("City");
		pageRequest.setPageValue(code.toLowerCase());
		// pageRequest.setPageValue("as");
		pageRequest.setSiteId(String.valueOf(siteId));
		pageRequest.setUrl(url);
		try {
			System.out.println("City PageRequest:: " + mapper.writeValueAsString(pageRequest));
		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
		}

		String res = rest.postForObject(pageApiUrl + "/showcontent?authcode=" + password, pageRequest, String.class);
		// System.out.println("City Content:: "+res);
		try {
			pageResponse = mapper.readValue(res, PageResponse.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (pageResponse.getResponse().size() == 0) {
			return "redirect:/";
		}

		model.addAttribute("pageResponse", pageResponse.getResponse().get(0));
		flightSearch.setPageAirline(code.toUpperCase());

		return "cities";
	}

	@GetMapping("/flight/{page}")
	public String airlinePage(@PathVariable("page") String page, @ModelAttribute FlightSearch flightSearch,
			@ModelAttribute ReviewRequest reviewRequest, Model model) {
		System.out.println("PagesController::flight::Page Value:: " + page);
		PageRequest pageRequest = new PageRequest();
		PageResponse pageResponse = new PageResponse();
		RestTemplate rest = new RestTemplate();
		ObjectMapper mapper = new ObjectMapper();
		String code = page.substring(page.lastIndexOf("-") + 1, page.length());
		String url = page.substring(0, page.lastIndexOf("-"));
		pageRequest.setPageType("Airline");
		pageRequest.setPageValue(code.toLowerCase());
		// pageRequest.setPageValue("as");
		pageRequest.setSiteId(String.valueOf(siteId));
		pageRequest.setUrl(url);
		try {
			System.out.println("Airline PageRequest:: " + mapper.writeValueAsString(pageRequest));
		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
		}

		String res = rest.postForObject(pageApiUrl + "/showcontent?authcode=" + password, pageRequest, String.class);
		// System.out.println("City Content:: "+res);
		try {
			pageResponse = mapper.readValue(res, PageResponse.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (pageResponse.getResponse().size() == 0) {
			return "redirect:/";
		}

		model.addAttribute("pageResponse", pageResponse.getResponse().get(0));
		flightSearch.setPageAirline(code.toUpperCase());

		return "airline";
	}

	@PostMapping("/newsletter/submit")
	public @ResponseBody String newslettersubmit(@RequestBody NewsletterRequest newsletterRequest) {
		Date currDate = new Date();
		RestTemplate rest = new RestTemplate();
		ObjectMapper mapper = new ObjectMapper();
		newsletterRequest.setDate(currDate.toString());
		newsletterRequest.setSiteId(39);
		newsletterRequest.setStatus("Active");
		newsletterRequest.setUrl("https://www.farescrew.com");
		try {
			System.out.println("newsletterRequest::"+mapper.writeValueAsString(newsletterRequest));
		}catch (Exception e) {
			e.printStackTrace();
		}
		String res = rest.postForObject("https://tgsapi.com/subscribe/addNewsletter?authcode=farehuts", newsletterRequest, String.class);
		System.out.println(res);
		return "";

	}

	/********* Write Code on 19-March-2022 **********/

	public int getDayDiff(String date1, String date2) {
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
		float daysBetween = 0;
		try {
			Date dateBefore = myFormat.parse(date1);
			Date dateAfter = myFormat.parse(date2);
			long difference = dateAfter.getTime() - dateBefore.getTime();
			daysBetween = (difference / (1000 * 60 * 60 * 24));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return (int) daysBetween;
	}

	public static String getAirlineImg(String code) {
		HashMap<String, String> airlineCode = new HashMap<String, String>();
		airlineCode.put("AS", "Alaska.png");
		airlineCode.put("NK", "spirit.png");
		airlineCode.put("G4", "allegiant.png");
		airlineCode.put("LH", "Lufthansa.png");
		airlineCode.put("F9", "frontier.png");
		airlineCode.put("B6", "jetblue.png");
		airlineCode.put("HA", "hawaiian-airlines.png");
		airlineCode.put("AA", "american.png");
		airlineCode.put("UA", "united.png");
		airlineCode.put("SY", "sun-country-airlines.png");
		return airlineCode.get(code);
	}
}