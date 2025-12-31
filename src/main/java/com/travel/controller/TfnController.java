package com.travel.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.travel.utility.WebsiteUtility;

@Controller
public class TfnController {

	@RequestMapping(value = "/getTFN", method = RequestMethod.POST)
	public @ResponseBody String getTFN(@RequestParam("utm_source") String utmSource, HttpServletRequest request, HttpSession session) {
	    String tfn = WebsiteUtility.tfnMap.get(utmSource);

	    // Optional: default TFN if not found
	    if (tfn == null) {
	        tfn = WebsiteUtility.homePageTfn; // default number
	    }

	    System.out.println("TFN Value for " + utmSource + ":: " + tfn);

	    return tfn;
	}
	
}
