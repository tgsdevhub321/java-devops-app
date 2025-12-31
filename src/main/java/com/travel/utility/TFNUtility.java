package com.travel.utility;

import javax.servlet.http.HttpServletRequest;

public class TFNUtility
{	
    public static String getTFN(String utmSource, HttpServletRequest request) {
        String tfn = WebsiteUtility.homePageTfn;
        try 
        {
        	utmSource=(String)request.getParameter("utm_source");
        	System.out.println("utmSource:"+utmSource);
        	if(utmSource == null) {
        		if(request.getSession().getAttribute("tollFree")!=null) {
        		    System.out.println("in session tfn:"+request.getSession().getAttribute("tollFree"));
        	        return (String)request.getSession().getAttribute("tollFree");
        	     }else {
        	    	 return tfn;
        	     }
        	}
        	else {
        	
        	tfn = WebsiteUtility.tfnMap.get(utmSource);
    	    // Optional: default TFN if not found
        	System.out.println("utmSource tfn:"+tfn);
    	    if (tfn == null) {
    	        tfn = WebsiteUtility.homePageTfn; // default number
    	    }
    	    
    	    try {
				if (tfn.isEmpty()) {
				    tfn = WebsiteUtility.homePageTfn; // default number
				}
			} catch (Exception e) {
			}
        	}
        } catch (Exception e) {
        	System.err.println("Error Reading TFN Data: " + e.getMessage());
            e.printStackTrace();
            tfn = WebsiteUtility.homePageTfn; // default number
        }
        request.getSession().setAttribute("tollFree", tfn);
        return tfn;
    }
}