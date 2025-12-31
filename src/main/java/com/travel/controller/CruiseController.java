package com.travel.controller;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.travel.bean.CruiseForm;
import com.travel.object.email.EmailFormat;
import com.travel.utility.CruiseFormMailer;
import com.travel.utility.WebsiteUtility;

@Controller
public class CruiseController {
	
	@Autowired
	MailController mailService;
	
	@GetMapping("/cruise")
	public String showCruise(@ModelAttribute CruiseForm cruiseForm){
		System.out.println("CruiseController Calling...");
		return "cruise";
	}
	
	@RequestMapping(value = "/cruise/submit", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody String submitCruiseForm(@RequestBody CruiseForm cruiseForm, Model model) {
		System.out.println("CruiseForm calling...");
		try {
			System.out.println("CruiseForm:: " + new ObjectMapper().writeValueAsString(cruiseForm));
		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
		}

		String emailBody = CruiseFormMailer.cruiseMail(cruiseForm);

		EmailFormat emailSend = new EmailFormat();
		emailSend.setFromEmail(WebsiteUtility.websiteSenderEmail);
		emailSend.setToEmail(WebsiteUtility.websiteSenderEmail);
		emailSend.setCcEmail(WebsiteUtility.websiteSenderEmail);
		emailSend.setMailSubject("Cruise Form Submission from " + cruiseForm.getFullName());
		emailSend.setMailBody(emailBody);

		String status = "";
		try {
			status = mailService.SendMail(emailSend, "smtp.gmail.com", "465", WebsiteUtility.websiteEmailPassword);
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}

		System.out.println("status:" + status);
		if(status=="true"){
			System.out.println("Email sent to support team");
		}else{
			System.out.println("Email failed to sent.");
		}
		
		return status;
    }
}