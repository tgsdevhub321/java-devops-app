<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html lang="en-US" dir="ltr">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Disclaimer</title>
   
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <link rel="canonical" href="${canonicalUrl}" />
	<link rel="icon" href="/resources/assets/img/favicons/favicon-32x32.png">
		<link rel="stylesheet" href="/resources/css/new/header-style.css?v=12" type="text/css" />
	
    <c:if test="${not empty oglocale}">
    <meta property="og:locale" content="${oglocale}" />
     </c:if>

	<c:if test="${not empty ogtype}">
	    <meta property="og:type" content="${ogtype}" />
	</c:if>
	
	<c:if test="${not empty ogtitle}">
	    <meta property="og:title" content="${ogtitle}" />
	</c:if>
	
	<c:if test="${not empty ogdescription}">
	    <meta property="og:description" content="${ogdescription}" />
	</c:if>
	
	<c:if test="${not empty ogurl}">
	    <meta property="og:url" content="${ogurl}" />
	</c:if>
	
	<c:if test="${not empty ogsite_name}">
	    <meta property="og:site_name" content="${ogsite_name}" />
	</c:if>
	
	<c:if test="${not empty ogimage}">
	    <meta property="og:image" content="${ogimage}" />
	</c:if>
	
	<c:if test="${not empty twittercard}">
	    <meta name="twitter:card" content="${twittercard}" />
	</c:if>
	
	<c:if test="${not empty twitterimage}">
	    <meta name="twitter:image" content="${twitterimage}" />
	</c:if>
	
	<c:if test="${not empty twittertitle}">
	    <meta name="twitter:title" content="${twittertitle}" />
	</c:if>
	
	<c:if test="${not empty twittersite}">
	    <meta name="twitter:site" content="${twittersite}" />
	</c:if>
	
	<c:if test="${not empty twitterdescription}">
	    <meta name="twitter:description" content="${twitterdescription}" />
	</c:if>

    <jsp:include page="common/common.jsp" />
	<style>
		.bg-holder {
    min-height: 500px !important;
	height: 500px !important;
}
	</style>

</head>
<body>
  <main class="main" id="top">
   <jsp:include page="common/header.jsp" />
 
	<section id="booking" class="frfe">
		<div class="bg-holder" style="background-image:url(/resources/assets/img/hero/herobg.png);">
		</div>
		<div class="ab-headd">
			<span>Disclaimer</span>
		</div>
		<div class="container">	
			
      <div class="hrgr">
        <h1>Disclaimer</h1>
     <p>You acknowledge and agree to the following disclaimers, in addition to our policies and terms of service, by using farescrew.com.</p>
 
     <h2>General Information</h2>
     <p>FaresCrew aims to provide accurate and up-to-date information in good faith. All information on FaresCrew is intended purely as general travel information and booking guidance. Although we strive to ensure that the information remains accurate, we cannot assure that it will always be up-to-date and comprehensive. Airlines, hotels, and other suppliers may update their travel information such as schedules, prices, and availability at any time.</p>
 
     <p>Farescrew.com does not bear any liability for typographical mistakes, pricing variations, or time differences presented by third-party service providers.</p>
 
     <h2>Third-Party Services</h2>
     <p>Farescrew.com serves as an intermediary between customers and travel providers. Reservations made through our platform are subject to the terms and conditions of the respective suppliers, including airlines, hotels, and other service providers. We cannot dictate service levels, business practices, or quality of performance of these third parties.</p>
 
     <h2>Pricing and Availability</h2>
     <p>All prices listed on Farescrew.com are subject to change without prior notice until the booking is confirmed. Fares include service charges, airline fees, and government-imposed taxes. Third-party suppliers control the availability of flights, hotels, and other travel services, and availability is subject to change at any time.</p>
 
     <h2>Our Liability</h2>
     <p>Farescrew.com will not be held responsible for any delays, cancellations, overbookings, accidents, losses, or damages resulting from actions or negligence by airlines, hotels, or other travel suppliers. We are not liable for additional costs incurred due to weather events, natural disasters, strikes, or any other circumstances beyond our control.</p>
 
     <p>Our liability is limited to the amount paid to Farescrew.com for the booking itself.</p>
 
     <h2>Cancellations and Refunds</h2>
     <p>Refunds and cancellations are subject to the policies of the airline or travel supplier, as well as applicable fare rules. Service fees paid to Farescrew.com are nonrefundable. For more information, see our Fees and Policies page.</p>
 
     <h2>External Website Links</h2>
     <p>Farescrew.com may contain links to third-party websites. These external sites are not under our control, and we are not responsible for their content, accuracy, or practices. We recommend reviewing their terms and conditions before engaging with any third-party site.</p>
 
     <h2>Updates to This Disclaimer</h2>
     <p>Farescrew.com reserves the right to revise or modify this disclaimer at any time, with or without prior notice. Changes take effect immediately upon being posted on our website.</p>
 
     <h2>Contact Information</h2>
     <p>If you have any doubts or inquiries about this disclaimer, please contact our customer care desk:</p>
 
     <p><strong>Farescrew.com</strong><br>
     ${websiteCompany}<br>
     ${tollFree}<br>
     ${websiteEmail}</p>
       </div>
		</div>
	</section>    
	
	
	<footer>
   <jsp:include page="common/footer.jsp" />
  	</footer>
  	</main>
	  <script src="vendors/@popperjs/popper.min.js"></script>
	  <script src="vendors/bootstrap/bootstrap.min.js"></script>
	  <script src="vendors/is/is.min.js"></script>
	  <script src="https://polyfill.io/v3/polyfill.min.js?features=window.scroll"></script>
	  <script src="vendors/fontawesome/all.min.js"></script>
	  <script src="/resources/assets/js/theme.js"></script>
</body>
 

   
 
</html>