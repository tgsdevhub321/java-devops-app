<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="mycase" uri="/WEB-INF/tld/string-utils.tld" %>

<style>
  .fs-134{
    font-size: 14px !important;
  }
</style>

  <!-- ============================================-->
      <!-- <section> begin ============================-->
      <section class="pb-0 pb-lg-4">

        <div class="container">
          <div class="row">
            <div class="col-lg-4 col-md-7 col-12 mb-4 mb-md-6 mb-lg-0 order-0"> <img class="mb-4" src="/resources/images/logo.png" width="150" alt="jadoo" />
              <p class="fs--1 text-secondary mb-0 fw-medium">Book your trip in minute, get full Control for much longer.</p>
            </div>
            <div class="col-lg-2 col-md-4 mb-4 mb-lg-0 order-lg-1 order-md-2">
              <h5 class="footer-heading-color fw-bold font-sans-serif mb-3 mb-lg-4">Contact</h5>
              <ul class="list-unstyled mb-0">
                <li class="mb-2"><a class="link-900 fs-134 fw-medium text-decoration-none" href="/aboutus">About</a></li>
				<li class="mb-2"><a class="link-900 fs-134 fw-medium text-decoration-none" href="/contactus">Contact</a></li>
				<li class="mb-2"><a class="link-900 fs-134 fw-medium text-decoration-none" href="/terms-and-conditions">Terms and Conditions</a></li>
				<li class="mb-2"><a class="link-900 fs-134 fw-medium text-decoration-none" href="/privacy-policy">Privacy Policy</a></li>
				<li class="mb-2"><a class="link-900 fs-134 fw-medium text-decoration-none" href="/disclaimer">Disclaimer</a></li>
				<li class="mb-2"><a class="link-900 fs-134 fw-medium text-decoration-none" href="/cookie-policy">Cookie Policy</a></li>
              <li class="mb-2"><a class="link-900 fs-134 fw-medium text-decoration-none" href="/sitemap">Sitemap</a></li>
                <!--  <li class="mb-2"><a class="link-900 fs-134 fw-medium text-decoration-none" href="#!">Mobile</a></li>-->
              </ul>
            </div>
			<div class="col-lg-2 col-md-4 mb-4 mb-lg-0 order-lg-3 order-md-4">
              <h5 class="footer-heading-color fw-bold font-sans-serif mb-3 mb-lg-4">Popular Domestic Flights</h5>
              <ul class="list-unstyled mb-0">
				<li class="mb-2"><a class="link-900 fs-134 fw-medium text-decoration-none" href="/city/flights-to-dallas-dal">Flights to Dallas</a></li>
				<li class="mb-2"><a class="link-900 fs-134 fw-medium text-decoration-none" href="/city/flights-to-las-vegas-las">Flights to Las Vegas</a></li>
				<li class="mb-2"><a class="link-900 fs-134 fw-medium text-decoration-none" href="/city/flights-to-miami-mia">Flights to Miami</a></li>
                <li class="mb-2"><a class="link-900 fs-134 fw-medium text-decoration-none" href="/city/flights-to-new-york-nyc">Flights to New York</a></li>
				<li class="mb-2"><a class="link-900 fs-134 fw-medium text-decoration-none" href="/city/flights-to-san-francisco-sfo">Flights to San Francisco</a></li>
              </ul>
            </div>
            <div class="col-lg-2 col-md-4 mb-4 mb-lg-0 order-lg-2 order-md-3">
              <h5 class="footer-heading-color fw-bold font-sans-serif mb-3 mb-lg-4">Popular International Flights</h5> 
              <ul class="list-unstyled mb-0">
                <li class="mb-2"><a class="link-900 fs-134 fw-medium text-decoration-none" href="/city/flights-to-auckland-akl">Flights to Auckland</a></li>
                <li class="mb-2"><a class="link-900 fs-134 fw-medium text-decoration-none" href="/city/flights-to-bali-dps">Flights to Bali</a></li>
                <li class="mb-2"><a class="link-900 fs-134 fw-medium text-decoration-none" href="/city/flights-to-dubai-dxb">Flights to Dubai</a></li>
				<li class="mb-2"><a class="link-900 fs-134 fw-medium text-decoration-none" href="/city/flights-to-london-lon">Flights to London</a></li>
                <li class="mb-2"><a class="link-900 fs-134 fw-medium text-decoration-none" href="/city/flights-to-tokyo-tyo">Flights to Tokyo</a></li>
              </ul>
            </div>
			
            <div class="col-lg-2 col-md-4 mb-4 mb-lg-0 order-lg-3 order-md-4">
              <h5 class="footer-heading-color fw-bold font-sans-serif mb-3 mb-lg-4">Popular Airlines</h5>
              <ul class="list-unstyled mb-0">
                <li class="mb-2"><a class="link-900 fs-134 fw-medium text-decoration-none" href="/flight/american-airlines-aa">American Airlines</a></li>
                <li class="mb-2"><a class="link-900 fs-134 fw-medium text-decoration-none" href="/flight/british-airways-ba">British Airways</a></li>
                <li class="mb-2"><a class="link-900 fs-134 fw-medium text-decoration-none" href="/flight/delta-air-lines-dl">Delta Air Lines</a></li>
				<li class="mb-2"><a class="link-900 fs-134 fw-medium text-decoration-none" href="/flight/emirates-airlines-ek">Emirates Airlines</a></li>
				<li class="mb-2"><a class="link-900 fs-134 fw-medium text-decoration-none" href="/flight/etihad-airways-ey">Etihad Airways</a></li>
              </ul>
            </div>
            <div class="col-lg-3 col-md-5 col-12 mb-4 mb-md-6 mb-lg-0 order-lg-4 order-md-1">
              <div class="icon-group mb-4"> 
                <c:forEach var="link" items="${socialLinks}">
                      <a class="text-decoration-none icon-item shadow-social" id="${link.name}" href="${link.url}"><i class="${link.icon}"> </i></a>
    		        </c:forEach>
              </div>
           
            </div>
          </div>
        </div><!-- end of .container-->

      </section>
      <!-- <section> close ============================-->
      <!-- ============================================-->


      <div class="py-5 text-center">
        <p class="mb-0 text-secondary fs--1 fw-medium">Copyrights &copy; ${copyRightYear} ${websiteName}, All Rights Reserved.</p>
      </div>
      
 <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&amp;family=Volkhov:wght@700&amp;display=swap" rel="stylesheet">