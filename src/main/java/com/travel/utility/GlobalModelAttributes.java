package com.travel.utility;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.travel.service.CanonicalResolver;

@ControllerAdvice
public class GlobalModelAttributes {

	private final WebsiteUtility appProperties;

	public GlobalModelAttributes(WebsiteUtility appProperties) {
		this.appProperties = appProperties;
	}

	@Autowired
    CanonicalResolver resolver;

    @ModelAttribute
    public void addCanonicalToModel(HttpServletRequest request, Model model) {
        String canonical = resolver.getCanonicalUrl(request);
        model.addAttribute("canonicalUrl", canonical);
    }
    
	@ModelAttribute("homeTitle")
	public String appTitle() {
		return appProperties.homePageTitle;
	}
	@ModelAttribute("homePageTfn")
	public String appHomePageTfn() {
		return appProperties.homePageTfn;
	}
	@ModelAttribute("websiteCurrency")
	public String websiteCurrency() {
		return appProperties.websiteCurrency;
	}
	@ModelAttribute("websiteName")
	public String websiteName() {
		return appProperties.websiteName;
	}
	@ModelAttribute("websiteEmail")
	public String websiteEmail() {
		return appProperties.websiteEmail;
	}
	@ModelAttribute("websiteCompany")
	public String websiteCompany() {
		return appProperties.websiteCompany;
	}
	@ModelAttribute("websiteAddress")
	public String websiteAddress() {
		return appProperties.websiteAddress;
	}

	@ModelAttribute("copyRightYear")
	public String copyRightYear() {
		return appProperties.copyRightYear;
	}

	@ModelAttribute("socialLinks")
	public List<SocialLink> socialLinks() {
		return appProperties.social;
	}
	
	@ModelAttribute("headeLink")
	public List<SocialLink> headeLink() {
		return appProperties.headeLink;
	}
	
	
	@ModelAttribute("description")
	public String DESCRIPTION(){
		return appProperties.DESCRIPTION;
	}
	
	@ModelAttribute("oglocale")
	public String getOglocale() {
		return appProperties.oglocale;
	}
	@ModelAttribute("ogtype")
	public String getOgtype() {
		return appProperties.ogtype;
	}
	@ModelAttribute("ogtitle")
	public String ogtitle() {
		return appProperties.ogtitle;
	}
	
	@ModelAttribute("ogdescription")
	public String getOgdescription() {
		return appProperties.ogdescription;
	}
	@ModelAttribute("ogurl")
	public String getOgurl() {
		return appProperties.ogurl;
	}
	@ModelAttribute("ogsite_name")
	public String getOgsite_name() {
		return appProperties.ogsite_name;
	}
	@ModelAttribute("ogimage")
	public String getOgimage() {
		return appProperties.ogimage;
	}
	@ModelAttribute("twittercard")
	public String getTwittercard() {
		return appProperties.twittercard;
	}
	@ModelAttribute("twitterimage")
	public String getTwitterimage() {
		return appProperties.twitterimage;
	}
	@ModelAttribute("twittertitle")
	public String getTwittertitle() {
		return appProperties.twittertitle;
	}
	@ModelAttribute("twittersite")
	public String getTwittersite() {
		return appProperties.twittersite;
	}
	@ModelAttribute("twitterdescription")
	public String getTwitterdescription() {
		return appProperties.twitterdescription;
	}
}
