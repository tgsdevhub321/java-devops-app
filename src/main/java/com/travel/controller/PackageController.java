package com.travel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.travel.bean.PackageQueryBean;
import net.sf.json.JSONObject;

@Controller
public class PackageController {
	
	@PostMapping("/submitQuery")	//, RedirectAttributes redirectAttributes
    public @ResponseBody JSONObject submitQuery(@RequestBody PackageQueryBean queryForm, Model model) {
		ObjectMapper mapper = new ObjectMapper();
		try
		{
			System.out.println("PackageQueryBean Request:: "+mapper.writeValueAsString(queryForm));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("message", "Query Submitted Successfully!");
		return jsonObject;
    }
}