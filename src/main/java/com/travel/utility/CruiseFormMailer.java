package com.travel.utility;

import com.travel.bean.CruiseForm;

public class CruiseFormMailer {
	
	public static String cruiseMail(CruiseForm cruiseForm) {

	    StringBuilder sb = new StringBuilder();

	    sb.append("<html><body>");
	    sb.append("<h2>Travel Inquiry Details</h2>");
	    sb.append("<table style='border-collapse: collapse; width: 100%;'>");

	    sb.append("<tr><td><strong>Destination:</strong></td><td>")
	      .append(cruiseForm.getDestination()).append("</td></tr>");

	    sb.append("<tr><td><strong>Travel Month:</strong></td><td>")
	      .append(cruiseForm.getTravelMonth()).append("</td></tr>");

	    sb.append("<tr><td><strong>Nights:</strong></td><td>")
	      .append(cruiseForm.getNights()).append("</td></tr>");

	    sb.append("<tr><td><strong>Cruise Line:</strong></td><td>")
	      .append(cruiseForm.getCruiseLine()).append("</td></tr>");

	    sb.append("<tr><td><strong>Full Name:</strong></td><td>")
	      .append(cruiseForm.getFullName()).append("</td></tr>");

	    sb.append("<tr><td><strong>Email:</strong></td><td>")
	      .append(cruiseForm.getEmail()).append("</td></tr>");

	    sb.append("<tr><td><strong>Phone Number:</strong></td><td>")
	      .append(cruiseForm.getPhoneNumber()).append("</td></tr>");

	    sb.append("<tr><td><strong>Remark:</strong></td><td>")
	      .append(cruiseForm.getRemark()).append("</td></tr>");

	    sb.append("</table>");
	    sb.append("</body></html>");

	    return sb.toString();
	}

}
