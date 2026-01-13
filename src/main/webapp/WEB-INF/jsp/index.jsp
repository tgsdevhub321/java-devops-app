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

    <!-- ===============================================-->
    <!--    Document Title-->
    <!-- ===============================================-->
      <title>${homeTitle}123</title>
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

	<link rel="alternate" href="https://www.farescrew.com/" hreflang="en" />
	<link rel="alternate" href="https://www.farescrew.com/" hreflang="x-default" />
	
	<link rel="icon" href="/favicon.ico" type="image/x-icon">
	<!-- Prevent social preview issues -->
	<meta property="og:locale" content="en_US">

</head>
<body>
<!-- ===============================================-->
    <!--    Main Content-->
    <!-- ===============================================-->
	
	
	
	<script type="application/ld+json">
	{
	  "@context": "https://schema.org",
	  "@type": "TravelAgency",
	  "name": "Farescrew",
	  "url": "https://www.farescrew.com",
	  "logo": "https://www.farescrew.com/images/logo.png",
	  "sameAs": [
	    "https://www.facebook.com/farescrew",
	    "https://twitter.com/farescrew",
	    "https://www.instagram.com/farescrew"
	  ],
	  "description": "Farescrew helps travelers book cheap flights, compare airline ticket prices, and find exclusive travel deals.",
	  "address": {
	    "@type": "PostalAddress",
	    "addressCountry": "US"
	  },
	  "contactPoint": {
	    "@type": "ContactPoint",
	    "telephone": "+1-888-509-2514",
	    "contactType": "customer support",
	    "areaServed": "USA"
	  }
	}
	</script>

	
	
       <main class="main" id="top">
    
   <jsp:include page="common/header.jsp" />
   
    <jsp:include page="common/search-engine.jsp" />

   <jsp:include page="common/usp.jsp" />

 <jsp:include page="common/deals.jsp" />

      <!-- ============================================-->
      <!-- <section> begin ============================-->
      <section id="booking">

        <div class="container">
          <div class="row align-items-center">
            <div class="col-lg-6">
              <div class="mb-4 text-start">
                <h5 class="text-secondary">123and Fast </h5>
                <h3 class="fs-xl-10 fs-lg-8 fs-7 fw-bold font-cursive text-capitalize">Discover & Book Your Next Destination with FaresCrew</h3>
              </div>
              <div class="d-flex align-items-start mb-3">
               
                <div class="flex-1">
                  <p class="mb-0">  singhhPlanning your next trip is easier with FaresCrew. Our platform brings together a wide selection of flights at competitive prices, giving you access to multiple airlines in one convenient place. You can instantly compare options and choose the best one without the hassle of searching across different sites.</p>
                </div>
              </div>
              <div class="d-flex align-items-start mb-3">
                
                <div class="flex-1">
                  <p class="mb-0">bcdWhether you're traveling for business or a personal getaway, FaresCrew helps you find the most suitable route, schedule, and fare with a smooth and straightforward search process. Everything you need to plan your journey is available in just a few clicks.</p>
                </div>
              </div>
              <div class="d-flex align-items-start mb-3">
                <div class="flex-1">
                  <p class="mb-0"> abcExplore flights to popular destinations as well as hidden travel gems with equal ease. We provide clear and transparent information throughout the booking process, helping you make confident decisions and enjoy a seamless travel experience from start to finish.</p>
                </div>
              </div>
            </div>
            <div class="col-lg-6 d-flex justify-content-center align-items-start">
              <div class="card position-relative shadow d-none" style="max-width: 370px;">
                <div class="position-absolute z-index--1 me-10 me-xxl-0" style="right:-160px;top:-210px;"> <img src="/resources/assets/img/steps/bg.png" style="max-width:550px;" alt="shape" /></div>
                <div class="card-body p-3"> <img class="mb-4 mt-2 rounded-2 w-100" src="/resources/assets/img/steps/booking-img.jpg" alt="booking" />
                  <div>
                    <h5 class="fw-medium">Trip To Greece</h5>
                    <p class="fs--1 mb-3 fw-medium">14-29 June | by Robbin joseph</p>
                    <div class="icon-group mb-4"> <span class="btn icon-item"> <img src="/resources/assets/img/steps/leaf.svg" alt=""/></span><span class="btn icon-item"> <img src="/resources/assets/img/steps/map.svg" alt=""/></span><span class="btn icon-item"> <img src="/resources/assets/img/steps/send.svg" alt=""/></span>
                    </div>
                    <div class="d-flex align-items-center justify-content-between">
                      <div class="d-flex align-items-center mt-n1"><img class="me-3" src="/resources/assets/img/steps/building.svg" width="18" alt="building" /><span class="fs--1 fw-medium">24 people going</span></div>
                      <div class="show-onhover position-relative">
                        <div class="card hideEl shadow position-absolute end-0 start-xl-50 bottom-100 translate-xl-middle-x ms-3" style="width: 260px;border-radius:18px;">
                          <div class="card-body py-3">
                            <div class="d-flex">
                              <div style="margin-right: 10px"> <img class="rounded-circle" src="/resources/assets/img/steps/favorite-placeholder.png" width="50" alt="favorite" /></div>
                              <div>
                                <p class="fs--1 mb-1 fw-medium">Ongoing </p>
                                <h5 class="fw-medium mb-3">Trip to rome</h5>
                                <h6 class="fs--1 fw-medium mb-2"><span>40%</span> completed</h6>
                                <div class="progress" style="height: 6px;">
                                  <div class="progress-bar" role="progressbar" style="width: 40%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                        <button class="btn"> <img src="/resources/assets/img/steps/heart.svg" width="20" alt="step" /></button>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="destinationimg">
                  <img src="/resources/assets/img/steps/destinationimg.png" alt="booking" width="100%" />
              </div>
            </div>
          </div>
        </div><!-- end of .container-->

      </section>
      <!-- <section> close ============================-->
      <!-- ============================================-->

 



      <div class="position-relative ">
        <div class="container">
          <div class="row row-cols-lg-5 row-cols-md-3 row-cols-2 flex-center">
            <div class="col-lg-12">
              <div class="card shadow-hover " style="border-radius:10px;">
                <div class="card-body text-center"> <img class="img-fluid" src="/resources/assets/img/partner/1.png" alt="" /></div>
              </div>
            </div>
          </div>
        </div>
      </div>
 <jsp:include page="common/subscribe.jsp" />
<!-- footer-section-start -->
 
<jsp:include page="common/footer.jsp" />
</main>
    <!-- ===============================================-->
    <!--    End of Main Content-->
    <!-- ===============================================-->




    <!-- ===============================================-->
    <!--    JavaScripts-->
    <!-- ===============================================-->
    <script src="vendors/@popperjs/popper.min.js"></script>
    <script src="vendors/bootstrap/bootstrap.min.js"></script>
    <script src="vendors/is/is.min.js"></script>
    <script src="https://polyfill.io/v3/polyfill.min.js?features=window.scroll"></script>
    <script src="vendors/fontawesome/all.min.js"></script>
    <script src="/resources/assets/js/theme.js"></script>


  </body>


</html>




