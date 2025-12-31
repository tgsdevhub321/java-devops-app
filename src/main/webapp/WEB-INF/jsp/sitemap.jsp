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
    <title>Sitemap</title>
   
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

	
    <link rel="stylesheet" href="/resources/css/home.css">
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
   <style>
    /*********** Site Map Page Css Start ********************/
    .sitemap-heading {color: #000; font-size: 18px; font-weight: 600; font-family: 'Lato', sans-serif; margin-bottom: 20px; margin: 8px 0px;}
    .smlink-row {display: flex; flex-wrap: wrap; margin-top: 5px;background-color: white; padding:0px 8px 10px;}
    .smlink-row ul {padding: 0; margin: 0;}
    .smlink-row li {display: inline-block; width: 31%; margin-bottom: 20px; margin-right: 1%; vertical-align: top;}
    .smlink-row li i {color: #053d99; margin-right: 8px;}
    .smlink-col {width: 100%; margin-right: 0}
    .smlink-col a {color: #161515; text-decoration: none;}
    .smlink-col a:hover {text-decoration: underline;}
    
    @media only screen and (max-width:767px) {
        .smlink-row li {width: 100%; margin-right: 0;}
    }
    /*********** Site Map Page Css Start ********************/
    </style>
   <section id="booking" class="frfe">
    <div class="bg-holder" style="background-image:url(/resources/assets/img/hero/herobg.png);">
    </div>
    <div class="ab-headd">
        <span>Sitemap</span>
    </div>
    <div class="container">	
        
        <div class="hrgr">

            <div class="smlink-row">
                <h2 class="sitemap-heading">Traveler Assistance </h2>
                <div class="smlink-col">
                <ul>
                      <li><a href="/aboutus">About Us</a></li>
                      <!--<li><a href="/refund-and-cancellation-policy">Refund Policy</a></li>-->
                      <li><a href="/terms-and-conditions">Terms &amp; Conditions</a></li>
                      <li><a href="/privacy-policy">Privacy Policy</a></li>
                      <li><a href="/cookie-policy">Cookie Policy</a></li> 
                        <li><a href="/disclaimer">Disclaimer</a></li>  
                      <li><a href="/contactus">Contact Us</a></li>
                </ul>
             </div>
          </div>
          
          
		  
		 		 <div class="smlink-row">
		                  <h2 class="sitemap-heading">Popular Domestic Flights</h2>
		                  <div class="smlink-col">
		                  <ul>
							<c:forEach var="domesticCity" items="${domesticCityList}">
							    <c:set var="domesticParts" value="${fn:split(domesticCity, ',')}" />
							    <c:set var="domesticUrl" value="${domesticParts[0]}" />
							    <c:set var="domesticPageValue" value="${domesticParts[1]}" />
							    <c:set var="domesticPageName" value="${domesticParts[2]}" />

							    <!-- Fix double hyphens -->
								<c:set var="cleanDomesticUrl"
								           value="${fn:replace(fn:replace(fn:toLowerCase(fn:trim(domesticUrl)), ' ', '-'), '--', '-')}" />

							    <li>
							        <a href="/city/flights-to-${cleanDomesticUrl}-${fn:toLowerCase(domesticPageValue)}">
							            Flights to ${domesticPageName}
							        </a>
							    </li>
							</c:forEach>
		                  </ul>
		               </div>
		            </div>
					
					<div class="smlink-row">
		                  <h2 class="sitemap-heading">Popular International Flights</h2>
		                  <div class="smlink-col">
		                  <ul>
							<c:forEach var="internationalCity" items="${internationalCityList}">
								<c:set var="internationalParts" value="${fn:split(internationalCity, ',')}" />
								<c:set var="internationalUrl" value="${internationalParts[0]}" />
								<c:set var="internationalPageValue" value="${internationalParts[1]}" />
								<c:set var="internationalPageName" value="${internationalParts[2]}" />
								<c:set var="cleanInternationalUrl" value="${fn:replace(fn:replace(fn:toLowerCase(fn:trim(internationalUrl)), ' ', '-'), '--', '-')}" />
								<li>
									<a href="/city/flights-to-${fn:replace(fn:toLowerCase(cleanInternationalUrl), ' ', '-')}-${fn:toLowerCase(internationalPageValue)}"> Flights to ${internationalPageName} </a>
								</li>
							</c:forEach>
		                  </ul>
		               </div>
		            </div>
					
					<div class="smlink-row">
					                <h2 class="sitemap-heading">Popular Airlines</h2>
					                <div class="smlink-col">
					                <ul>
					                      <c:forEach var="airUrl" items="${airlineMap}" varStatus="indexed">
											<li>
											    <a href="/flight/${fn:replace(fn:toLowerCase(airUrl.url), ' ', '-')}-${fn:toLowerCase(airUrl.pageValue)}">
											        ${airUrl.pageName}
											    </a>
											</li>

					                    </c:forEach>
					                </ul>
					             </div>
					          </div>
    
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