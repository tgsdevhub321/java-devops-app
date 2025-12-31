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
    <title>Privacy Policy</title>
   
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
			<span>Privacy Policy</span>
		</div>
		<div class="container">	
			
			<div class="hrgr">
				<h1>Privacy Policy - Farescrew.com</h1>
				<p><strong>Effective Date: 26/11/2025</strong></p>

				<h2>1. Introduction</h2>
				<p>Farescrew.com ('FaresCrew,' 'we,' 'us,' or 'our') is owned and operated by ${websiteCompany}, a parent organization committed to protecting your personal information and ensuring transparency regarding our data practices. This Privacy Policy explains the manner in which your data is obtained, utilized, disclosed, held, stored, and transferred whenever you visit or use our website, mobile applications, customer service, booking services, promotional tools, newsletters, or any other facilities and services offered by FaresCrew (collectively referred to as the 'Services').</p>
				<p>By choosing to use Farescrew.com as well as submitting information to us, or interacting with any of our Services, you acknowledge that you fully understand and consent to the data handling practices described in this Privacy Policy along with our Terms & Conditions. You should discontinue use of our Services if you do not agree with any part of this policy.</p>

				<h2>2. Personal Information We Collect</h2>
				<p>FaresCrew gathers data that might list you directly, might be fairly related to you, or might be connected to your travel actions and preferences. The nature and the volume of personal data gathered can vary according to your use of our platform.</p>

				<h3>2.1 Identifying Information</h3>
				<p>Personal information that we gather includes your full name, email address, billing and residential address, phone numbers of contacts, date of birth, gender, and nationality. This information helps us to make reservations, accept payments, and authenticate you and provide you with customized travel services.</p>

				<h3>2.2 Travel-Related Identification</h3>
				<p>In making travel arrangements, you can be asked to provide passport numbers, visa details, government issued identification, frequent flyer numbers, known traveler numbers, emergency contact information and some other identifiers that are necessary to complete a reservation with an airline, hotel or other travel suppliers. This information is necessary to comply with airline, transportation, immigration, and legal requirements.</p>

				<h3>2.3 Financial and Transactional Information</h3>
				<p>To complete purchases, we collect payment card numbers, security codes, billing verification details as well as transaction history and any fraud prevention or verification results provided by payment processors. Although real card numbers can be stored safely with a third-party payment processor, we do keep some billing information in our records to keep and to comply with regulations.</p>

				<h3>2.4 Booking, Preference & Communication Details</h3>
				<p>As you interact with FaresCrew, we may collect information about your travel routes, destinations, accommodation choices, special meal preferences, accessibility needs, seating preferences, baggage selections, or any specific instructions you provide. Other data provided in customer service phone calls, emails, or chats remains in order to help them in service enhancement and subsequent engagements.</p>

				<h3>2.5 Device, Technical & Interaction Data</h3>
				<p>We automatically gather information regarding the device and browser used to access our Services. These are IP addresses, device identifiers, hardware models, operating systems, language settings, user-agent strings, the patterns of page views, browsing behavior, click behavior, scroll activity, session length, as well as referral URLs. This information assists in optimizing functionality, increasing the security of the platform, and performing trend analysis.</p>

				<h3>2.6 Advertising and Attribution Data</h3>
				<p>Some of the technologies that FaresCrew may implement are technologies that capture the interaction of users with advertisements both on and off our website. Such technologies follow ad views, clicks, conversions, cookie IDs, hashed identifiers (e.g., contact identifiers), advertising IDs (e.g., IDFA, GAID), and activity patterns across devices; these technologies are interconnected. This knowledge will be used to customize advertisements and gauge their performance.</p>

				<h2>3. How Personal Information Is Collected</h2>
				<p>Your information is gathered by us through different channels so that we can provide our services conveniently and properly manage the booking.</p>

				<h3>3.1 Direct Interactions Through Our Services</h3>
				<p>When you use Farescrew.com to search, book, alter or cancel trips, or in creating an account, subscribing to newsletters, and other promotions, or connecting with our team, you make voluntary contributions of personal information that are necessary to meet your requests.</p>

				<h3>3.2 Offline Channels</h3>
				<p>Data can also be gathered on voice conversations with customer service, email messages, or a face-to-face meeting with the licensed travel agents. Such in-person communication can be documented or tracked to ensure quality control and address a conflict.</p>

				<h3>3.3 Data Received from Other Sources</h3>
				<p>We may supplement the information you provide with data from third parties like airlines, hotel partners, travel consolidators, marketing affiliates, social media platforms when you integrate or interact using your accounts, fraud prevention agencies, or publicly available databases. This information is received within the guidelines of the legal systems.</p>

				<h2>4. Automatic Data Collection, Analytics & Tracking Technologies</h2>
				<p>To understand user behavior, enhance the performance of a platform, ensure customer security, and provide customized advertisements, FaresCrew depends on diverse technologies.</p>

				<h3>4.1 Cookies</h3>
				<p>To keep track of your preferences, maintain sessions, track trends, achieve quick checkouts, and help with fraud detection, cookies are stored on your device. The cookies can be either a session or a persistent cookie, based on the purpose.</p>

				<h3>4.2 Pixel Tags & Web Beacons</h3>
				<p>These tiny transparent images allow us to monitor activities like email open rates, navigation routes, advertisement clicks or patterns of page visits. They facilitate the success of marketing campaigns.</p>

				<h3>4.3 Software Development Kits (SDKs)</h3>
				<p>Our mobile apps can have SDKs that retrieve device identifiers, application usage history, crash history and application performance history. These assist in improving the functionality of the apps as well as compatibility between devices.</p>

				<h3>4.4 APIs & Integration Tools</h3>
				<p>To allow real-time updates, validate travel information or offer location based services, APIs gather configuration data.</p>

				<h3>4.5 Session Replay Technologies</h3>
				<p>There are tools which can be used to analyze user navigation behavior in our site such as mouse movement, the depth of scrolling, clicks and form interactions. This assists us in enhancing user experience and debugging issues.</p>

				<h3>4.6 IP Address Tracking & Geolocation</h3>
				<p>We study IP addresses to approximate geographical positioning and detect the signs of fraud and comply with the regional regulatory standards. GPS or WiFi signals can also be used to provide local travel advice or offers, should you permit it.</p>

				<h3>4.7 Aggregated & De-identified Data</h3>
				<p>We can sum or anonymize big data in order to create statistical data like the percentage of users booking flights to specific destinations. These revelations can no longer distinguish you as an individual.</p>

				<h2>5. How We Use Personal Information</h2>
				<p>The information gathered by FaresCrew has many vital and useful applications which are listed below.</p>

				<h3>5.1 Fulfilling Bookings & Travel Services</h3>
				<p>With your information, we are able to make, maintain, verify and modify your travel arrangements. This involves the exchange of information with airlines, hotels, car hire companies and others whose operations depend on the real identities and preferences of the travelers.</p>

				<h3>5.2 Customer Support & Communication</h3>
				<p>The information is used to answer your questions, potential troubleshooting, and confirmations, as well as to call and inform you of changes in your itinerary and offer timely service. The communication can be done via email, SMS, phone calls, or in-platform communication.</p>

				<h3>5.3 Administrative & Service Notifications</h3>
				<p>We may send legally required notifications, updates to terms, policy changes, account advisories, fraud alerts, or other essential communications.</p>

				<h3>5.4 Personalization, Recommendations & Marketing</h3>
				<p>FaresCrew can take your data to recommend travel ideas, offer deals, customize user interfaces, or make specific offers in accordance with your interests. Such efforts can be based on profiling, which will be based on the previous booking patterns.</p>

				<h3>5.5 Promotions, Contests & Sweepstakes</h3>
				<p>When you take part in campaigns, we apply your data to administer entries, share outcomes, establish eligibility, and provide prizes where we should. Other words can be used to regulate certain promotional activities.</p>

				<h3>5.6 Security, Fraud Detection & Prevention</h3>
				<p>To identify abnormal behavior, thwart unauthorized access, ensure system integrity, and protect your transactions, we examine usage patterns and device signals.</p>

				<h3>5.7 Legal & Compliance Purposes</h3>
				<p>Information could be utilized where necessary in order to adhere to the laws, address the legitimate demands, enforce contracts, address disputes, or safeguard the rights and safety of Farescrew, our customers, and other stakeholders.</p>

				<h3>5.8 Aggregated or Research Uses</h3>
				<p>Once identifiers have been eliminated, they can be used in business analytics, market research, forecasting and product development.</p>

				<h2>6. How Personal Information Is Shared</h2>
				<p>We may only disclose your information when the need arises, and this will be in accordance with this Privacy Policy.</p>

				<h3>6.1 Corporate Affiliates</h3>
				<p>Your data can be accessed by entities owned or run by  ${websiteCompany} to assist in operational functions, technical operations or analytics.</p>

				<h3>6.2 Travel Suppliers</h3>
				<p>Airlines, hotels, cruise lines, car rental companies, tour operators and other associated suppliers need your information to give tickets, authentication of identity and to get a confirmation on your travel bookings.</p>

				<h3>6.3 External Travel Partners</h3>
				<p>Authorized consolidators, aggregators, ticketing companies, and insurance providers receive only the information required to provide their specialized services.</p>

				<h3>6.4 Service Providers</h3>
				<p>Third party vendors supporting payment processing, data storage, security monitoring, fraud prevention, analytics, IT operations, marketing automation, or customer service may receive limited access to required information under strict confidentiality agreements.</p>

				<h3>6.5 Promotional Partners</h3>
				<p>If you participate in promotions, the sponsors or operators might demand your information to monitor such undertakings.</p>

				<h3>6.6 Social Media & Integration Tools</h3>
				<p>When you post on a social media account or decide to share content using social functions in these sites, your details can be shared as per your choices in your settings on those sites.</p>

				<h3>6.7 Public Content</h3>
				<p>Information you voluntarily post on public areas of Farescrew.com like reviews or comments might be visible to other members and the general population.</p>

				<h3>6.8 Business Transfers</h3>
				<p>In cases of mergers, acquisitions, bankruptcy, or restructuring, personal information may be transferred to the new controlling entity while maintaining privacy commitments.</p>

				<h3>6.9 Legal & Safety-Related Disclosures</h3>
				<ul>
					<span>We may share information when required:</span>
				<li>To comply with legal obligations</li>
				<li>To respond to subpoenas, court orders, or investigations</li>
				<li>To prevent fraud, identity theft, or harmful activities</li>
				<li>To enforce our Terms & Conditions</li>
				<li>To protect life, safety, or property</li>
				</ul>

				<h2>7. Third-Party Services & External Links</h2>
				<p>FaresCrew may include links to third-party websites, incorporate third-party widgets, and use partner websites for bookings. We are not responsible for their data collection, privacy, or security practices. The users should also consider the relevant privacy policies of any given third party services with which they may be engaging because they might have vastly different practices than us.</p>

				<h2>8. Advertising & Marketing Practices</h2>
				<p>FaresCrew partners with advertising networks, analytics businesses, and social media networks to deliver relevant ads and measure campaign success. The cookies, beacons, advertising IDs, or device matching technology can be used by our partners to identify your interactions with many devices or websites.</p>

				<p>You may be offered targeted ads based on:</p>
				<ul>
				<li>Browsing behavior</li>
				<li>Previous travel searches</li>
				<li>Engagement with emails</li>
				<li>Demographic insights</li>
				<li>Social media interactions</li>
				</ul>

				<p>Some advertising partners may receive hashed or encrypted identifiers for secure matching purposes.</p>

				<h3>Your Choices</h3>
				<p>You may control targeted advertising via:</p>
				<ul>
				<li>Browser settings</li>
				<li>Mobile device privacy settings</li>
				<li>Industry opt-out programs (e.g., NAI, DAA)</li>
				<li>Social platform ad preferences</li>
				</ul>
				<p>These opt-outs may vary in effectiveness depending on device or browser.</p>

				<h2>9. Security of Personal Information</h2>
				<p>We implement administrative, organizational, and technical controls that are intended to ensure that your personal data is not accessed, lost, abused, or disclosed to unauthorized persons. Such controls encompass encryption technology, restricted access control protocols, secure hosting environment, monitoring systems and industry-standard security controls.</p>
				<p>However, there is no internet source that can be one hundred percent safe. In case you feel that your account is being abused or accessed without authorization, then inform us without delay through the contact details that are given in this policy.</p>

				<h2>10. Marketing Communication Preferences</h2>
				<p>You can also opt out of marketing emails at any point by visiting the unsubscribe button of the promotional messages or by contacting us directly at ${websiteEmail}.</p>
				<p>It is important to note that by turning off marketing communications, we will not stop providing customers with important messages concerning bookings, security, or account operations.</p>

				<h2>11. Access, Correction & Deletion Rights</h2>
				<p>Depending on your jurisdiction, you may have the right to access your personal information, request corrections, or request deletion of certain data. Your identity may have to be checked before Farescrew meets such requests. Some information may be retained for legal, accounting, fraud prevention, or transactional record-keeping purposes.</p>
				<p>Requests may be submitted by contacting us at ${websiteEmail}.</p>

				<h2>12. Data Retention Practices</h2>
				<p>FaresCrew retains personal data for as long as required to fulfill the purposes outlined in this Privacy Policy. Retention can be furthered beyond the active usage periods when need to be met in legal or auditing requirements, in dispute resolution or record keeping in the company. Due to the nature of operations, backup systems could save part of the data over a long duration.</p>

				<h2>13. Children & Minors</h2>
				<p>FaresCrew Services are not intended for individuals under the age of eighteen. We do not knowingly collect information from minors. If we learn that data was collected from someone under 18, we will delete it promptly in compliance with applicable laws.</p>

				<h2>14. International Data Transfers</h2>
				<p>Your information may be transferred to or stored on servers located in the United States or other countries where data protection standards may differ. You consent to such transfers unless disallowed by your local laws by using our Services.</p>

				<h2>15. GDPR Notice</h2>
				<p>If you are located within the European Economic Area, you may have additional rights, including but not limited to:</p>
				<ul>
				<li>Right to data portability</li>
				<li>Right to restrict processing</li>
				<li>Right to object to processing</li>
				<li>Right to withdraw consent at any time</li>
				<li>Right to lodge complaints with a supervisory authority</li>
				</ul>
				<p>FaresCrew adheres to GDPR principles when handling data for users in these regions.</p>

				<h2>16. U.S. State-Specific Privacy Rights</h2>
				<p>Users residing in states with active consumer privacy laws'such as California, Virginia, Colorado, Utah, Connecticut, Texas, and others'may have rights including:</p>
				<ul>
				<li>Right to know categories and specific pieces of personal information collected</li>
				<li>Right to request deletion</li>
				<li>Right to request correction</li>
				<li>Right to opt out of 'sale' or 'sharing' of personal information</li>
				<li>Right to limit use of sensitive information</li>
				<li>Right to appeal decisions involving data requests</li>
				</ul>

				<h2>17. Canadian Privacy Rights</h2>
				<p>Canadian residents may request information regarding how their personal information is shared with affiliates or third parties for direct marketing purposes. They may also request access or corrections as permitted under Canadian privacy laws.</p>

				<h2>18. Sensitive Information</h2>
				<p>We ask that users refrain from submitting highly sensitive information such as Social Security numbers, financial account passwords, criminal history records, health or biometric data, or information revealing racial or religious affiliations unless expressly required for travel and requested through secure channels. Such data will only be processed when required by law.</p>

				<h2>19. Updates to This Privacy Policy</h2>
				<p>This Privacy Policy may be updated periodically to reflect changes in our operations, legal requirements, or technological advancements. Updates will be posted on this page, and the 'Effective Date' will indicate the most recent revision. Continued use of the Services after updates constitutes acceptance of the revised policy.</p>

				<h2>20. Contacting Us</h2>
				<p>For questions, concerns, or data requests related to this Privacy Policy, you may contact us using the following information:</p>
				<p>Farescrew.com<br>
				${websiteCompany}<br>
				${websiteAddress}<br>
				${websiteEmail}<br>
				${tollFree}</p>
				


        
        
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