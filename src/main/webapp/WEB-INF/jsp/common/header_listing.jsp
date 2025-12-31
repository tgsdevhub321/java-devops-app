 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tfn" uri="/WEB-INF/tld/tfn-functions.tld" %>

<nav class="navbar navbar-expand-lg navbar-light fixed-top py-3 pb-lg-3 d-block fixed-header shadow" data-navbar-on-scroll="data-navbar-on-scroll">
  <div class="container"><a class="navbar-brand m-0" href="/"><img src="/resources/assets/img/farescrew-logo.png" height="34" alt="logo" /></a>
    <button class="navbar-toggler d-none" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"> </span></button>
    <div class="collapse navbar-collapse border-lg-0 mt-4 mt-lg-0" id="navbarSupportedContent">
      <ul class="navbar-nav ms-auto pt-2 pt-lg-0 font-base align-items-lg-center align-items-start">
       
        <li class="nav-item px-3 px-xl-4">
        <c:set var="tollFree" value="${tfn:getTFN(utmSource, pageContext.request)}" scope="session" />
        <a class="btn btn-dark order-1 order-lg-0 fw-medium" href="tel:${tollFree}">${tollFree}</a></li>
       
      </ul>
    </div>
    <ul class="navbar-nav ms-auto pt-2 pt-lg-0 font-base align-items-lg-center align-items-start d-lg-none">
           
      <li class="nav-item px-0 px-xl-4">
      <c:set var="tollFree" value="${tfn:getTFN(utmSource, pageContext.request)}" scope="session" />
      <a class="btn btn-dark order-1 order-lg-0 fw-medium" href="tel:${tollFree}">${tollFree}</a></li>
      
    </ul>
  </div>
</nav>

      
<style>
  .fixed-top {
    position: inherit;
    z-index: 1030;
}
</style>