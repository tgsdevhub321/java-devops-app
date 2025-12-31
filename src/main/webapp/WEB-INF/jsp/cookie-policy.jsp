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
    <title>Cookie Policy</title>
   
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
			<span>Cookie Policy</span>
		</div>
		<div class="container">	
			
            <div  class="hrgr">
       <p><strong>Last Updated:</strong> November 26, 2025</p>
       <p>This Cookie Policy explains how Farescrew.com (“we,” “us,” “our,” or “the website”) uses cookies and similar tracking technologies when you visit or interact with our website. FaresCrew is owned and operated by ${websiteCompany} which is located at ${websiteAddress}. You consent to our use of cookies as described in this policy by continuing to browse or use FaresCrew.com.</p>
   
       <h2>1. What Are Cookies?</h2>
       <p>Cookies are mini text files stored on your electronic device like a computer, tablet, or mobile on visiting a website. Cookies help improve your browsing experience by:</p>
       <ul>
           <li>Remembering your preferences</li>
           <li>Enabling essential site features</li>
           <li>Understanding how users interact with the website</li>
           <li>Delivering relevant content and advertisements</li>
       </ul>
   
       <h2>2. Types of Cookies We Use</h2>
       <h3>a. Essential (Strictly Necessary) Cookies</h3>
       <p>These cookies are important for the website to function properly. They enable core site features including:</p>
       <ul>
           <li>Secure login</li>
           <li>Page navigation</li>
           <li>Booking and checkout processes</li>
       </ul>
       <p>Without these cookies, certain parts of the site will not work.</p>
   
       <h3>b. Performance & Analytics Cookies</h3>
       <p>These cookies help us understand how visitors use our website. They allow us to:</p>
       <ul>
           <li>Monitor website traffic and usage patterns</li>
           <li>Improve website functionality and user experience</li>
           <li>Identify technical issues</li>
       </ul>
       <p>Tools such as Google Analytics or similar platforms may be used to collect non-identifiable, aggregated data.</p>
   
       <h3>c. Functional Cookies</h3>
       <p>These cookies remember your preferences to enhance your experience such as:</p>
       <ul>
           <li>Language settings</li>
           <li>Saved searches</li>
           <li>Display preferences</li>
       </ul>
       <p>They help personalize the website for returning users.</p>
   
       <h3>d. Advertising & Targeting Cookies</h3>
       <p>We may partner with third-party advertising networks that use cookies to:</p>
       <ul>
           <li>Deliver personalized travel ads</li>
           <li>Show relevant promotions</li>
           <li>Track marketing campaign performance</li>
           <li>Limit repetitive advertisements</li>
       </ul>
       <p>These cookies may track your browsing activity across websites.</p>
   
       <h3>e. Third-Party Cookies</h3>
       <p>Our website may contain content or features from third parties such as payment gateways, analytics tools, booking partners, or travel suppliers. These third parties may set their own cookies to:</p>
       <ul>
           <li>Track interactions</li>
           <li>Process bookings</li>
           <li>Provide embedded content</li>
           <li>Analyze performance</li>
       </ul>
       <p>Third-party cookies are subject to the privacy and cookie policies of their respective providers.</p>
   
       <h2>3. Why We Use Cookies</h2>
       <p>We use cookies to:</p>
       <ul>
           <li>Ensure smooth website performance</li>
           <li>Improve search and booking functions</li>
           <li>Enhance user experience</li>
           <li>Provide relevant offers and advertising</li>
           <li>Analyze website traffic and optimize content</li>
           <li>Maintain security and prevent fraud</li>
       </ul>
   
       <h2>4. Managing Your Cookie Preferences</h2>
       <p>You can control, block or delete cookies at any time through your browser settings. Most browsers allow you to:</p>
       <ul>
           <li>Disable all cookies</li>
           <li>Delete existing cookies</li>
           <li>Block third-party cookies</li>
           <li>Receive notifications when cookies are placed</li>
       </ul>
       <p>Please note:</p>
       <p>Disabling cookies may affect website functionality and limit your ability to use certain services including bookings and personalized features.</p>
       <p>For detailed management steps, refer to your browser’s support pages (Chrome, Firefox, Safari, Edge, etc.).</p>
   
       <h2>5. Do Not Track (DNT) Signals</h2>
       <p>Some browsers offer a “Do Not Track” setting. At this time, FaresCrew.com does not respond to DNT signals due to the lack of a uniform industry standard.</p>
   
       <h2>6. Updates to This Cookie Policy</h2>
       <p>We may update this Cookie Policy periodically to reflect changes in technology, regulations, or our practices. Updates will be posted on this page with a revised “Last Updated” date. Continued use of the website after changes implies acceptance of the updated policy.</p>
   
       <h2>7. Contact Us</h2>
       <p>If you have questions about this Cookie Policy or how we use cookies, please contact us at:</p>
       <p>Phone: ${tollFree}</p>
       <p>You can also mail us at:</p>
       <p>Email: ${websiteEmail}</p>
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