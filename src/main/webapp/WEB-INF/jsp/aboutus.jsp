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
    <title>About Us</title>
   
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <link rel="canonical" href="${canonicalUrl}" />
	<link rel="shortcut icon" href="/resources/assets/img/favicons/favicon-32x32.png" type="image/x-icon">
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
			<span>About Us</span>
		</div>
		<div class="container">	
			<div class="hrgr">
				<p>Farescrew.com is focused on helping travelers search as well as compare and book flights with ease. We know that sometimes it may be hard to plan a trip and that is why our portal is designed to help you in this process and offer you an opportunity to find the optimal airfare in a single convenient location. Whether you are travelling for leisure or work we aim to support you with tools that make decision making clearer and faster.</p>

				<p>Farescrew focuses on delivering a smooth experience. With comprehensive search features and an organized layout we help you filter through a variety of airlines and fare types to find choices that match your travel needs. We also put high emphasis on transparency where major information is presented in such a way that it can be easily understood.</p>
 
				<p>Farescrew believes travelers deserve a stress free journey right from the planning stage. That is why we continue improving our platform and enhancing the resources available to our users. Whether you need guidance during your search or assistance during booking our team is committed to providing reliable support.</p>
 
				<p>Our mission is to make flight booking more accessible and stress free so you can focus on enjoying the experience ahead. With a wide selection of fares and a commitment to user satisfaction Farescrew aims to be a trusted travel partner in your trip planning.</p>
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