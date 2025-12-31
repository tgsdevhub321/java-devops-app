<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html lang="en-US" dir="ltr">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="/resources/css/dealspage.css">
	<link rel="icon" href="/resources/assets/img/favicons/favicon-32x32.png">

      <title>${homeTitle}</title>
      <meta name="DESCRIPTION" content="${description}" />
      <link rel="canonical" href="${canonicalUrl}" />
	    <jsp:include page="common/common.jsp" />
      
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

   
    
  <style>
    nav.backdrop {
      background-color:  white   !important;   /* Apna desired background color */
      backdrop-filter: none !important;    /* Agar blur aa raha ho */
      box-shadow: rgba(149, 157, 165, 0.2) 0px 8px 24px !important;
  }
  .row {
    width: 100%;
    margin: auto;
}
a:hover{
	text-decoration: none;
}
  </style>

</head>
<body>
       <main class="main" id="top">
    
   <jsp:include page="common/header.jsp" />
   

   				<jsp:include page="common/search-engine.jsp" />
                  
		   
		   <jsp:include page="common/usp.jsp" />
   
    
		   <jsp:include page="generic-deal.jsp">
		   				<jsp:param name="prefix" value="" />
		   			    <jsp:param name="pageValue" value="${pageResponse.pageValue}" />
		   				<jsp:param name="currency" value="CAD" />
		   				<jsp:param name="limit" value="9" />
		   		  </jsp:include>
		           
		       
		         <!-- deals with rawfares -->
		           <div class="deal-with-rawfares-main mt-3 mt-md-5 p-0 mb-3 mb-md-4 frfe"  id="booking" >
		               <div class="container">
						<div class="hrgr">
							<div class="row">
								<div class="col-12 mb-2">
									 <div class="raw-destination">
										 <h3>Book Cheap Flight Tickets Online</h3>
									 </div>
								 </div>
								 <div class="col-12">
									 <div class="flight-deals-txt">
									 ${pageResponse.contentData}
										
										
				 
									 </div>
								 </div>
								
							 </div>
						</div>
		                   
		               </div>
		           </div>
				 
				     
				
<jsp:include page="common/footer.jsp" />
</main>
    <script src="vendors/@popperjs/popper.min.js"></script>
    <script src="vendors/bootstrap/bootstrap.min.js"></script>
    <script src="vendors/is/is.min.js"></script>
    <script src="https://polyfill.io/v3/polyfill.min.js?features=window.scroll"></script>
    <script src="vendors/fontawesome/all.min.js"></script>
    <script src="/resources/assets/js/theme.js"></script>

  </body>

</html>