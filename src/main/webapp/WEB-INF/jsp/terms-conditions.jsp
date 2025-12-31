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
    <title>Terms & Conditions</title>
   
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
			<span>Terms and Conditions</span>
		</div>
		<div class="container">	
			
            <div class="hrgr">
                <h1>Terms and Conditions - Farescrew.com</h1>
       <p><strong>Last Updated:</strong> November 26, 2025</p>
   
       <p>Welcome to Farescrew.com (“FaresCrew,” “we,” “us,” “our”). Farescrew.com is owned and operated by 
       ${websiteCompany} with its main office located at [OFFICE ADDRESS]. You (“user,” “customer,” “you”) 
       agree to these Terms and Conditions by accessing or using our website and services which include flight 
       bookings, hotel reservations, cruise packages and vacation packages. Please read them carefully. You must 
       stop using the website immediately if you do not agree.</p>
   
       <h2>Acceptance of Terms</h2>
       <p>By using this website and our services, you accept that you are at least 18 years old and legally capable 
       of entering into binding agreements. Continued use of farescrew.com constitutes acceptance of the most 
       recent version of these Terms. You are responsible for maintaining the confidentiality of your account and 
       payment details. You agree not to use our services for any unlawful as well as fraudulent or unauthorized 
       purposes.</p>
   
       <h2>Scope of Services</h2>
       <p>Farescrew.com acts as an online travel platform enabling users to search, compare and book:</p>
       <ul>
           <li>Flights</li>
           <li>Hotels &amp; accommodations</li>
           <li>Cruise packages</li>
           <li>Vacation packages</li>
           <li>Other related travel services</li>
       </ul>
   
       <p>We do not own, operate or control airlines, hotels, cruise lines, transport companies or tour operators. 
       All travel components are fulfilled by third-party suppliers and their policies apply to your bookings. We 
       act as an intermediary between you and these travel suppliers. We are not the provider of these services 
       and are not responsible for their function.</p>
   
       <h2>Booking Terms</h2>
       <p>When you make a booking:</p>
       <ul>
           <li>You enter into a binding contract with the relevant supplier like airline, hotel, cruise line, tour operator, etc.</li>
           <li>FaresCrew is not liable for service quality, schedule changes, cancellations, overbooking, property standards or any experience delivered by the supplier.</li>
           <li>Supplier-specific rules including check-in requirements, refund eligibility, baggage restrictions, resort fees, cruise documentation requirements and health protocols apply in full.</li>
       </ul>
   
       <p><strong>For hotels and packages:</strong><br>
       Room types, amenities, inclusions and taxes vary by supplier. Some hotels may charge additional mandatory fees 
       (resort fees, cleaning charges, city taxes), payable directly at the property.</p>
   
       <p><strong>For cruises:</strong><br>
       Passengers must meet all passport, visa, identification and health requirements. Cruise lines may deny boarding 
       for non-compliance.</p>
   
       <h2>Pricing &amp; Payments</h2>
       <ul>
           <li>Prices are dynamic and may change until payment is completed.</li>
           <li>Taxes as well as surcharges and additional fees may apply.</li>
           <li>Third-party payment gateways may be used for processing transactions.</li>
           <li>You authorize us or our partners to charge your payment method for the full booking amount.</li>
           <li>Post-purchase price fluctuations do not qualify for refunds.</li>
       </ul>
   
       <h2>Changes, Cancellations &amp; Refunds</h2>
       <p>All changes or cancellations must comply with the supplier’s policies which may include:</p>
       <ul>
           <li>Nonrefundable or non-changeable fares</li>
           <li>Cancellation penalties</li>
           <li>Fare/tariff differences</li>
           <li>No-show fees</li>
       </ul>
   
       <p>Farescrew.com may charge service fees for cancellations, modifications or special assistance. These 
       service fees are nonrefundable.</p>
   
       <p>Hotel bookings, cruise packages and vacation packages may have stricter cancellation rules, especially 
       for:</p>
       <ul>
           <li>Promotional deals</li>
           <li>Last-minute bookings</li>
           <li>Group bookings</li>
           <li>Holiday-season travel</li>
       </ul>
   
       <p>We strongly recommend reviewing all terms before completing the purchase.</p>
   
       <h2>Travel Requirements</h2>
       <p>You are solely responsible for ensuring compliance with all travel requirements, including:</p>
       <ul>
           <li>Valid passports and visas</li>
           <li>COVID-19 or other health documentation</li>
           <li>Cruise boarding requirements</li>
           <li>Airline security rules</li>
           <li>Hotel check-in age requirements &amp; ID verification</li>
           <li>Insurance (optional but recommended)</li>
       </ul>
   
       <p>Farescrew.com bears no responsibility for denied boarding or entry refusal or travel disruptions due to 
       non-compliance.</p>
   
       <h2>User Accounts &amp; Information</h2>
       <p>If you create an account, you agree to:</p>
       <ul>
           <li>Provide accurate information</li>
           <li>Maintain confidentiality of login credentials</li>
           <li>Be responsible for all activities under your account</li>
       </ul>
   
       <p>We may suspend or terminate accounts for misuse or violation of these Terms.</p>
   
       <h2>Intellectual Property</h2>
       <p>All branding, design, content, images and software on farescrew.com are protected intellectual property. 
       You may not copy, alter, reproduce or distribute any content without written permission.</p>
   
       <h2>Third-Party Links</h2>
       <p>Our website may include links, banners or references to third-party websites, platforms or service providers 
       for your convenience. These external sites are not owned, operated or controlled by farescrew.com. We do not 
       endorse, monitor or guarantee the accuracy, safety or reliability of any third-party content, nor do we assume 
       responsibility for:</p>
   
       <ul>
           <li>Their terms of use, privacy practices or data handling</li>
           <li>The quality or delivery of services, products or information offered</li>
           <li>Any transactions or communications you conduct with third-party providers</li>
       </ul>
   
       <p>Once you leave farescrew.com, you are subject to the policies and practices of the external site. Accessing 
       or interacting with third-party links is done at your own risk and we recommend reviewing their terms and 
       privacy policies before engaging with them.</p>
   
       <h2>Limitation of Liability</h2>
       <p>To the fullest extent permitted by law:</p>
       <ul>
           <li>Farescrew.com is not liable for direct, indirect, incidental or consequential damages arising from the use of our website or services.</li>
           <li>We do not guarantee uninterrupted website access or error-free operation.</li>
           <li>We are not responsible for acts, omissions or failures of airlines, hotels, cruise lines or package operators.</li>
       </ul>
       <p>Your sole remedy for dissatisfaction with our website is to stop using it.</p>
   
       <h2>Indemnification</h2>
       <p>You agree to indemnify and hold harmless farescrew.com, its employees, agents and affiliates from any claims, 
       losses, damages or expenses arising from:</p>
       <ul>
           <li>Your use of the website</li>
           <li>Your failure to comply with travel requirements or supplier terms</li>
           <li>Your violation of these Terms</li>
       </ul>
   
       <h2>Privacy Policy</h2>
       <p>Your use of farescrew.com is governed by our Privacy Policy, which outlines how we collect, use and protect 
       your personal data.</p>
   
       <h2>FaresCrew Text Message Terms and Conditions</h2>
       <p>When entering your contact information on farescrew.com or agreeing to receive communications from us, you 
       consent to receiving text messages including OTPs, service updates, promotional information or other relevant 
       content. Texts may be automated and you may opt out at any time.</p>
   
       <h3>1. Message Security</h3>
       <p>Text messages, including OTPs, are sent without encryption and may carry privacy risks. By participating, you 
       acknowledge these risks.</p>
   
       <h3>2. Opt-Out Option</h3>
       <p>Reply “STOP” to any message or contact customer service to opt out. You will receive a final confirmation text.</p>
   
       <h3>3. Usage Terms</h3>
       <ul>
           <li><strong>Message Frequency:</strong> Depends on your activity, bookings or promotions.</li>
           <li><strong>Account Responsibility:</strong> You confirm you own the number and will update it if changed.</li>
           <li><strong>Delivery Limitations:</strong> Delays or failures may occur; we are not liable.</li>
           <li><strong>Carrier Restrictions:</strong> Not all carriers support the service.</li>
       </ul>
   
       <h3>4. Costs and Charges</h3>
       <p>Farescrew.com does not charge for texts, but carrier message/data rates may apply.</p>
   
       <h3>5. Data Collection and Use</h3>
       <p>Data collected includes your phone number, carrier info and message details. This is used to enhance service. 
       See our Privacy Policy for more.</p>
   
       <h3>6. Liability and Indemnification</h3>
       <p>You agree to indemnify FaresCrew from issues arising due to failure to update your contact information.</p>
   
       <h3>7. Message Services Termination</h3>
       <p>We may suspend or terminate your participation at any time, including if your mobile service ends.</p>
   
       <h2>13. Modifications to Terms</h2>
       <p>We may update or revise these Terms at any time. Continued use of farescrew.com means you accept the updated 
       Terms.</p>
   
       <h2>14. Contact Information</h2>
       <p>Email: ${websiteEmail}</p>
       <p>Phone number: ${tollFree}</p>
       <p>Address: ${websiteAddress}</p>
   
       <p>Your trust and satisfaction remain our priority as we work to provide you with a seamless travel experience.</p>
   
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