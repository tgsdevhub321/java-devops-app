<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>About Us</title>
    <meta name="DESCRIPTION" content="${description}" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <link rel="canonical" href="${canonicalUrl}" />
	<link rel="icon" href="/resources/assets/img/favicons/favicon-32x32.png">
	
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

</head>
<body>
   <jsp:include page="common/header.jsp" />
  <!--   header container  -->

    <div class="screen-overlay" id="screenoverlay" onclick="hidesidenav()"></div>
    <!--Header Ends Here-->
    <section style="background:url(/resources/images/about_bnr.jpg)  ; background-position: center center; height: 200px;">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <div class="blog-head" >
                      
                </div>
            </div>
        </div>
    </section>
   <section>
    <div class="container mt-4">
        <div class="row">
            <div class="col-lg-12">
                
             
            </div>
        </div>
    </div>
   </section>
    <!--Footer Starts-->
	
	<footer>
   <jsp:include page="common/footer.jsp" />
  	</footer>
  	
	<script type="text/javascript" src="/resources/js/jquery-3.6.0.min.js"></script>
	<script type="text/javascript" src="/resources/js/jquery-ui.min_1.13.0.js"></script>
	<script type="text/javascript" src="/resources/js/jquery.validate.min.js"></script>
   	<script src="/resources/js/script.js"></script>
</body>

</html>