 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tfn" uri="/WEB-INF/tld/tfn-functions.tld" %>


 <nav class="navbar navbar-expand-lg navbar-light fixed-top py-3 py-lg-5 d-block fixed-header px-0" data-navbar-on-scroll="data-navbar-on-scroll">
        <div class="container align-items-center">
          <a class="navbar-brand m-0" href="/"><img src="/resources/images/logo.png"  alt="logo" /></a>
          
           <ul class="navbar-nav ms-auto pt-2 pt-lg-0 font-base align-items-lg-center align-items-start d-lg-none ">
           
           <li class="nav-item px-0 px-xl-4">
           <c:set var="tollFree" value="${tfn:getTFN(utmSource, pageContext.request)}" scope="session" />
           <a class="btn btn-outline-dark order-1 order-lg-0 fw-medium" href="tel:${tollFree}">${tollFree}</a></li> 
         </ul>
         <button class="navbar-toggler d-lg-none p-0 ps-2 mt-2" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"> </span></button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav rgr ms-auto py-2 pt-lg-0 font-base align-items-lg-center align-items-start ">
               <!-- <c:forEach var="link" items="${headeLink}">
       	        <li class="nav-item px-3 px-xl-4"><a class="nav-link fw-medium" aria-current="page" href="${link.url}">${link.name}</a></li>
    	       </c:forEach> -->
              <li class="nav-item px-3 px-xl-4 d-lg-block d-none">
              <c:set var="tollFree" value="${tfn:getTFN(utmSource, pageContext.request)}" scope="session" />
              <a class="btn btn-outline-dark order-1 order-lg-0 fw-medium" href="tel:${tollFree}">${tollFree}</a></li>
              
            </ul>
          </div>
         
        </div>
      </nav>
      
<style>
  
@media screen and (max-width:768px) {


  .bg-light {
    background-color: #ffffff !important;
}
.navbar-collapse {
    position: absolute;
    top: 46px;
    background: white;
    z-index: 999;
    width: 100%;
    left: 0;
}
}
</style>