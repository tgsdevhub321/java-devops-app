<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="tfn" uri="/WEB-INF/tld/tfn-functions.tld"%>
<%@ taglib prefix="airline" uri="/WEB-INF/tld/airline-functions.tld"%>
<%@ taglib prefix="mycase" uri="/WEB-INF/tld/string-utils.tld" %>
<!DOCTYPE html>
<html ng-app="flightPayment">
    <head>
    	<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, viewport-fit=cover" />
        	<link rel="icon" href="/resources/assets/img/favicons/favicon-32x32.png">
        	<c:set var="sentenceCase" value="${mycase:SentenceCase(websiteName)}" scope="session" />
        	<title>${sentenceCase} - Payment Page</title>
        	<link rel="stylesheet" href="/resources/css/bootstrap.min.css" />	
			<link rel="stylesheet" href="/resources/css/responsive.css" />	
        	<link rel="stylesheet" href="/resources/css/fontawesome.all.min.css" /> 
        	<link rel="stylesheet" href="/resources/css/navber.css" />		
        	<link rel="stylesheet" href="/resources/css/payment.css?v=240326345678" />
			<link rel="stylesheet" href="/resources/css/result.css?25-Feb_2023">
			<link rel="stylesheet" href="/resources/css/font/bootstrap-icons.css" type="text/css">	
			<link rel="stylesheet" href="/resources/css/home/header-style.css" type="text/css" />	
			<link rel="stylesheet" href="/resources/css/header_footer.css?v=12">
        	<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
        	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        	<script src="/resources/js/jquery-3.6.0.min.js"></script> 
			<script src="/resources/js/jquery.validate.min.js"></script>
			<script src="/resources/js/jquery.creditCardValidator.js"></script>
        	<script src="/resources/js/angular.min.js"></script>
        	<script type="text/javascript" src="/resources/js/flights/payment/payment.js?v=0811202455678"></script>
			<script src="/resources/js/flights/payment/ancillaries.js?v=08112024"></script>
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
			
	    	<style type="text/css">
		    .outboundDetail{display:none;}
		    .inboundDetail{display:none;}
		    .error-message{color: red; font-size: 12px; font-weight: normal !important;}
		    .p-disclaimer {float: left; width: 100%; background-color: #fff;padding: 2px 9px 10px; }
		    .p-disclaimer p {font-size: 12px; color: #222; border: 1px solid #90c5f9;border-radius: 5px;padding: 6px;margin: 10px 0px; }
		    .error-messages-agree {color: red; display: block; margin-top: 5px;  }
		    .ajiwrh {background: #f1a501;color: white;position: sticky;width: 100%;bottom: 0;left: 0;padding: 15px 12px;display: none;}
      		.jhdgt {font-weight: 600;}
      		@media only screen and (max-width: 600px) {.ajiwrh {display: block;}}
	    	</style>
	    	<script>
			function goBack() {
		  		window.history.back();
			}
			</script>
			
			<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
	    	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	    	<link rel="stylesheet" href="/resources/css/new/flight-listing.css?v=1234">
	    	<link rel="stylesheet" href="/resources/css/new/payment.css?v=12345678">
      		<link rel="preconnect" href="https://fonts.googleapis.com">
      		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
      		<link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,400;1,500;1,600;1,700&display=swap" rel="stylesheet">   
    		<link rel="stylesheet" href="/resources/css/new/header-style.css?v=12" type="text/css" />
    </head>
     <c:set var="tollFree" value="${tfn:getTFN(utmSource, pageContext.request)}" scope="session" />
    <body ng-controller="flightPaymentCntrl">
	
	<!-- Header Area -->
	<c:choose>
		<c:when test="${bookingRequest.currencyCode=='AUD'}"><c:set var="sourceTFN" value="+64-9-873-0777" scope="request" /></c:when>
		<c:otherwise><c:set var="sourceTFN" value="${tollFree}" scope="request" /></c:otherwise>
	</c:choose>
	
	<jsp:include page="../../common/header_listing.jsp" />

<fmt:setLocale value="en_US" scope="session"/>
<form:form method="POST" action="/flight/payment/confirm" modelAttribute="bookingRequest" novalidate="novalidate">
<input type="hidden" id="sessionId" value="${bookingRequest.searchID}">

<c:set var="outCount" value="0" scope="request" />
<c:set var="inCount" value="0" scope="request" />
<c:forEach var="outboundList" items="${bookingRequest.flightResult.outBound}">
	<c:set var="outCount" value="${outCount+1}" />
</c:forEach>
<c:forEach var="inboundList" items="${bookingRequest.flightResult.inBound}">
	<c:set var="inCount" value="${inCount+1}" />
</c:forEach>

<input type="hidden" id="out_aircode_hdn" value="${bookingRequest.flightResult.outBound[0].airline}" />
<input type="hidden" id="out_airline_hdn" value="${bookingRequest.flightResult.outBound[0].airlineName}" />
<input type="hidden" id="out_flt_hdn" value="${bookingRequest.flightResult.outBound[0].flightNo}" />
<input type="hidden" id="out_cls_hdn" value="${bookingRequest.flightResult.outBound[0].cabinClass}" />
<input type="hidden" id="out_from_hdn" value="${bookingRequest.flightResult.outBound[0].fromAirport}" />
<input type="hidden" id="out_to_hdn" value="${bookingRequest.flightResult.outBound[outCount-1].toAirport}" />
<input type="hidden" id="out_ddate_hdn" value="${bookingRequest.flightResult.outBound[0].depDate}" />
<input type="hidden" id="out_adate_hdn" value="${bookingRequest.flightResult.outBound[outCount-1].reachDate}" />
<input type="hidden" id="out_stop_hdn" value="${bookingRequest.flightResult.outBound.size()-1}" />
	
<input type="hidden" id="in_aircode_hdn" value="${bookingRequest.flightResult.inBound[0].airline}" />
<input type="hidden" id="in_airline_hdn" value="${bookingRequest.flightResult.inBound[0].airlineName}" />
<input type="hidden" id="in_flt_hdn" value="${bookingRequest.flightResult.inBound[0].flightNo}" />
<input type="hidden" id="in_cls_hdn" value="${bookingRequest.flightResult.inBound[0].cabinClass}" />
<input type="hidden" id="in_from_hdn" value="${bookingRequest.flightResult.inBound[0].fromAirport}" />
<input type="hidden" id="in_to_hdn" value="${bookingRequest.flightResult.inBound[inCount-1].toAirport}" />
<input type="hidden" id="in_ddate_hdn" value="${bookingRequest.flightResult.inBound[0].depDate}" />
<input type="hidden" id="in_adate_hdn" value="${bookingRequest.flightResult.inBound[inCount-1].reachDate}" />
<input type="hidden" id="in_stop_hdn" value="${bookingRequest.flightResult.inBound.size()-1}" />

<input type="hidden" id="adultNo" value="${bookingRequest.adults}" />
<input type="hidden" id="childNo" value="${bookingRequest.child}" />
<input type="hidden" id="infantNo" value="${bookingRequest.infants}" />
<input type="hidden" id="infantsWsNo" value="${bookingRequest.infantsWs}" />

<input type="hidden" id="adultPrice" value="${bookingRequest.adults * (bookingRequest.flightResult.fare.adultFare+bookingRequest.flightResult.fare.adultTax+bookingRequest.flightResult.fare.adultMarkup)}" />
<input type="hidden" id="childPrice" value="${bookingRequest.child * (bookingRequest.flightResult.fare.childFare+bookingRequest.flightResult.fare.childTax+bookingRequest.flightResult.fare.childMarkup)}" />
<input type="hidden" id="infantPrice" value="${bookingRequest.infants * (bookingRequest.flightResult.fare.infantFare+bookingRequest.flightResult.fare.infantTax+bookingRequest.flightResult.fare.infantMarkup)}" />
<input type="hidden" id="infantWsPrice" value="${bookingRequest.infantsWs * (bookingRequest.flightResult.fare.infantWsFare+bookingRequest.flightResult.fare.infantWsTax+bookingRequest.flightResult.fare.infantWsMarkup)}" />

<input type="hidden" id="tripTypeId" value="${flightRequest.tripType}" />
<input type="hidden" id="ageDate" value="${bookingRequest.flightResult.inBound[0].depDate}" />
<form:hidden path="metaredirectId" value="${bookingRequest.metaredirectId}"/>
<input type="hidden" id="sourceName" value="${bookingRequest.sourceMedia}" />
<form:hidden path="enquiryId" value="" />

<section >
        <div class="container">
            <div class="row mt-4">
              <div class="col-lg-8 p-hfr4">
                <div class="d-flex align-items-center ">
                  <img src="/resources/images/payment/rev.png" alt="">
                  <p class="mb-0 p-dnt">Review Your Booking</p>
                </div>
                
                <c:if test="${bookingRequest.isPriceChange==true}">
						<div class="" style="background:#FFFFE0;border-style: solid;border-color: orange;">
							<c:set var="totalPrice" value="${bookingRequest.flightResult.fare.grandTotal/(bookingRequest.adults+bookingRequest.child+bookingRequest.infants+bookingRequest.infantsWs)}" scope="request" />
							<div style="text-align:center;font-weight:500;margin:10px;">
								Fare has been adjusted by the airline! Sometimes this can happen when inventory changes quickly, or an airline is updating the database. 
								The new price has been adjusted to average per passenger (Total: <b style="color:#da2000;">${websiteCurrency} <fmt:formatNumber  type="number" minFractionDigits="2" maxFractionDigits="2" value="${totalPrice}" /></b>). 
								Please continue with the booking below or <a href="/">Click here</a> to find an alternative flight.
							</div>
						</div></br>
				</c:if>
				
                <div class="p-secton-rt">
                  <div class="p-secton-dt d-flex align-items-center ">
                    <img src="/resources/images/payment/s-flight.png" alt="">
                    <p class="mb-0">Selected Flight</p>
                  </div>
                  <div class="hdr95 rela px-3 py-3">
                    
                    
             <c:forEach var="outboundList" items="${bookingRequest.flightResult.outBound}" varStatus="count">
                    <div class="d-flex align-items-center mb-2">
                        <c:if test="${count.first}"> <img src="/resources/images/payment/out-b.png" alt="">
                        <p class="mb-0 p-ghju">Departure</p></c:if>
                      </div>
                    
                    <div class="row rela12">
                     
                     
                      <div class="col-lg-9">
                          <div class="bjyur69">
                              <div class="row">
                                  <div class="col-lg-4">
                                      <div class="d-flex align-items-start mb-1">
                                          <img class="me-2 e654tgy7" src="/resources/images/airline-logo/${outboundList.airline}.png" alt="" style="width: 35px;">
                                          <div class="hor56">
                                              <p class="mb-0 cvyh65"><!-- American Airline -->${outboundList.airlineName}</p>
                                              <div class="d-flex">
                                                  <p class="mb-0 drt6yju p-sjr7">Flight ${outboundList.flightNo} | Aircraft</p>
                                                  <div class="rela12 dft65">
                                                      <p class="mb-0 w5g4q2 p-sjr7">${outboundList.equipmentType}</p>
                                                      
                                                      <c:if test="${outboundList.equipmentTypeDes != null && outboundList.equipmentTypeDes != ''}">
	                                                      <div class="bg-white kirjr43">
	                                                          <p class="mb-0 dt54t">${outboundList.equipmentTypeDes}</p>
	                                                          <!-- <p class="mb-0 h8yhb5">STD SEATS</p> -->
	                                                      </div>
                                                      </c:if>
                                                  </div>
                                              </div>
                                          </div>
                                      </div>
										
                                      <c:if test="${outboundList.airline != outboundList.opratingAirline}">
                                      <div class="d-flex align-items-start">
                                        <p class="mb-1 dt54t ty75y o-utw">Operated by :</p>
                                      	<p class="mb-1 dt54t ty75y"><c:out value="${airline:getAirlineName(outboundList.opratingAirline)}" /></p>
                                      </div>
                                      </c:if>
                                      
                                  </div>
                                  <div class="col-lg-8">
                                      <div class="dor45">
                                          <div class="row align-items-center justify-content-around">
                                              <div class="col-lg-5 trt64 h9h49 text-center">
                                                  <p class="mb-0 rf6u4"><!-- 04:29PM -->
													<c:set var="depDate" value="${fn:replace(outboundList.depDate, 'T', ' ')}" />
													<fmt:parseDate value="${depDate}" var="dateObject" pattern="yyyy-MM-dd HH:mm:ss" />
													<fmt:formatDate value="${dateObject}" pattern="hh:mm a" />
                                                  </p>
                                                  <p class="mb-0 tyuf57"><!-- Fri, Aug 30 -->
                                                  	<fmt:formatDate value="${dateObject}" pattern="EEE, MMM dd" />
                                                  </p>
                                                  <p class="mb-0 h8yhb5 fu75rh"><!-- New York (JFK) -->
                                                  	${outboundList.fromAirportName} (${outboundList.fromAirport})
                                                  </p>
                                              </div>
                                              <div class="col-lg-2 t64ghu h9h49">
                                                  <div class="bgyu64"></div>
                                              </div>
                                              <div class="col-lg-5 ty75g h9h49 text-center">
                                                  <p class="mb-0 rf6u4"><!-- 07:25PM -->
													<c:set var="arrDate" value="${fn:replace(outboundList.reachDate, 'T', ' ')}" />
													<fmt:parseDate value="${arrDate}" var="arrDateObject" pattern="yyyy-MM-dd HH:mm:ss" />
													<fmt:formatDate value="${arrDateObject}" pattern="hh:mm a" />
													<sup class="sred56" id="dayCountDisplay_${count.index}"></sup>
													
													<input type="hidden" value="${outboundList.depDate}" id="hdDepDate_${count.index}">
												    	<input type="hidden" value="${outboundList.reachDate}" id="hdArrDate_${count.index}">
												    
													
                                                  </p>
                                                  <p class="mb-0 tyuf57"><!-- Fri, Aug 30 -->
                                                  	<fmt:formatDate value="${arrDateObject}" pattern="EEE, MMM dd" />
                                                  </p>
                                                  <p class="mb-0 h8yhb5 fu75rh"><!-- Dallas-Fort Worth (DFW) -->
                                                  	${outboundList.toAirportName} (${outboundList.toAirport})
                                                  </p>
                                                  
                                              </div>
                                          </div>
                                      </div>
                                  </div>
                                  
                              </div>
                              
                          </div>
                      </div>
                      <div class="col-6 col-lg-3 gr5t6j4">
                      
			           <%-- <c:if test="${count.first}"> --%>

	                      
	                          <div class="hiegr7 ">
	                              <p class="mb-0 tyuf57"><span class="fg6534" style="font-size: 12px;"><script>document.write(getCabin(<c:out value='${outboundList.cabinClass}'/>))</script></span> </p>
	                              <!-- <p class="mb-0 tyuf57">Baggage : <span class="fg6534">1PC</span> </p> -->
	                          </div>
			            <%-- </c:if> --%>

                     </div>
                  </div>
                  
                  
                  <div class="row mt-2">
                      <div class="col-6 col-lg-9">
                          <p class="mb-0 h8yhb5 d65w4">Flight Duration: <!-- 2h 1m -->
                          	<script>document.write(timeConvert(<c:out value='${outboundList.eft}' />))</script>
                          </p>
                      </div>
                      <c:if test="${count.last}">
	                      <div class="col-6 col-lg-3">
	                      	<p class="mb-0 h8yhb5 d65w4">Total Trip Time: <script>document.write(timeConvert(<c:out value='${bookingRequest.flightResult.outEFT}' />))</script></p>
	                      </div>
                      </c:if>
                  </div>
                 
                  <c:if test="${outboundList.layOverTime > 0 }">
                  <div class="rela d54yd my-3">
                      <p class="mb-0 djgur74"><img src="/resources/images/payment/clk.png" alt=""> <!-- 3h 57m layover in Dallas-Forth (DFW) -->
                      	<script>document.write(timeConvert(<c:out value='${outboundList.layOverTime}' />))</script> layover in ${outboundList.toCityName} (${outboundList.toAirport})
                      </p>
                  </div>
                  </c:if>
          	</c:forEach>
                  
                  
                    <c:if test="${fn:length(bookingRequest.flightResult.inBound)>0}">
                    <hr class="b-dashed px-4">
                    <c:forEach var="inboundList" items="${bookingRequest.flightResult.inBound}" varStatus="count">
	                    <div class="d-flex align-items-center mb-2">
	                      	<c:if test="${count.first}">
	                      		<c:if test="${flightRequest.tripType == 2}"><img src="/resources/images/payment/in-b.png" alt=""><p class="mb-0 p-ghju"> Return</p></c:if>	
                            <c:if test="${flightRequest.tripType == 3}"><img src="/resources/images/payment/in-b.png" alt=""> Departure</c:if>
                        </c:if>
	                    </div>
                    <div class="row rela12">
                      
                      
                      <div class="col-lg-9">
                          <div class="bjyur69">
                              <div class="row">
                                  <div class="col-lg-4">
                                      <div class="d-flex align-items-start mb-1">
                                          
                                          <img class="me-2 e654tgy7" src="/resources/images/airline-logo/${inboundList.airline}.png" alt="" style="width: 35px;">
                                          <div class="hor56">
                                              <p class="mb-0 cvyh65"><!-- American Airline --> ${inboundList.airlineName}</p>
                                              <div class="d-flex">
                                                  <p class="mb-0 drt6yju p-sjr7">Flight ${inboundList.flightNo} | Aircraft</p>
                                                  <div class="rela12 dft65">
                                                      <p class="mb-0 w5g4q2 p-sjr7">${inboundList.equipmentType}</p>
                                                      <c:if test="${inboundList.equipmentTypeDes != null && inboundList.equipmentTypeDes != ''}">
	                                                      <div class="bg-white kirjr43">
	                                                          <p class="mb-0 dt54t">${inboundList.equipmentTypeDes}</p>
	                                                          <!-- <p class="mb-0 h8yhb5">STD SEATS</p> -->
	                                                      </div>
                                                      </c:if>
                                                  </div>
                                              </div>
                                          </div>
                                      </div>
                                      
                                      <c:if test="${inboundList.airline != inboundList.opratingAirline}">
	                                      <div class="d-flex align-items-start">
	                                        <p class="mb-1 dt54t ty75y o-utw">Operated by :</p>
	                                      	<p class="mb-1 dt54t ty75y"> <c:out value="${airline:getAirlineName(inboundList.opratingAirline)}" /></p>
	                                      </div>
                                      </c:if>
                                      
                                  </div>
                                  <div class="col-lg-8">
                                      <div class="dor45">
                                          <div class="row  align-items-center justify-content-around">
                                              <div class="col-lg-5 trt64 h9h49 text-center">
                                                  <p class="mb-0 rf6u4"><!-- 04:29PM -->
                                                  	<c:set var="depDate" value="${fn:replace(inboundList.depDate, 'T', ' ')}" />
													<fmt:parseDate value="${depDate}" var="dateObject" pattern="yyyy-MM-dd HH:mm:ss" />
													<fmt:formatDate value="${dateObject}" pattern="hh:mm a" />
                                                  </p>
                                                  <p class="mb-0 tyuf57"><!-- Fri, Aug 30 -->
                                                  	<fmt:formatDate value="${dateObject}" pattern="EEE, MMM dd" />
                                                  </p>
                                                  <p class="mb-0 h8yhb5 fu75rh"><!-- New York (JFK) -->
                                                  	${inboundList.fromAirportName} (${inboundList.fromAirport})
                                                  </p>
                                                  
                                              </div>
                                              <div class="col-lg-2  t64ghu h9h49">
                                                  <div class="bgyu64"></div>
                                              </div>
                                              <div class="col-lg-5 ty75g h9h49 text-center">
                                                  <p class="mb-0 rf6u4"><!-- 07:25PM -->
                                                  	<c:set var="arrDate" value="${fn:replace(inboundList.reachDate, 'T', ' ')}" />
													<fmt:parseDate value="${arrDate}" var="arrDateObject" pattern="yyyy-MM-dd HH:mm:ss" />
													<fmt:formatDate value="${arrDateObject}" pattern="hh:mm a" />
													<sup class="sred56" id="dayCountDisplayRtn_${count.index}"></sup>
													<input type="hidden" value="${inboundList.depDate}" id="hdRtnDepDate_${count.index}">
												    <input type="hidden" value="${inboundList.reachDate}" id="hdRtnArrDate_${count.index}">
                                                  </p>
                                                  <p class="mb-0 tyuf57"><!-- Fri, Aug 30 -->
                                                  	<fmt:formatDate value="${arrDateObject}" pattern="EEE, MMM dd" />
                                                  </p>
                                                  <p class="mb-0 h8yhb5 fu75rh"><!-- Dallas-Fort Worth (DFW) -->
                                                  	${inboundList.toAirportName} (${inboundList.toAirport})
                                                  </p>
                                                  
                                              </div>
                                          </div>
                                      </div>
                                  </div>
                              </div>
                          </div>
                      </div>
                      <div class="col-6 col-lg-3 gr5t6j4">
	                          <div class="hiegr7">
	                              <p class="mb-1 tyuf57 "><span class="fg6534" style="font-size: 12px;"><script>document.write(getCabin(<c:out value='${inboundList.cabinClass}'/>))</script></span> </p>
	                              <!-- <p class="mb-0 tyuf57 ">Baggage : <span class="fg6534">1PC</span> </p> -->
	                          </div>
	                      </div>
                  </div>
                  
                  
                  <div class="row mt-2">
                      <div class="col-6 col-lg-9">
                          <p class="mb-0 h8yhb5 d65w4">Flight Duration: <script>document.write(timeConvert(<c:out value='${inboundList.eft}' />))</script></p>
                      </div>
                      <c:if test="${count.last}">
	                      <div class="col-6 col-lg-3">
	                      	<p class="mb-0 h8yhb5 d65w4">Total Trip Time: <script>document.write(timeConvert(<c:out value='${bookingRequest.flightResult.inEFT}' />))</script></p>
	                      </div>
                      </c:if>
                  </div>
                  <c:if test="${inboundList.layOverTime > 0 }">
	                  <div class="rela d54yd my-3">
	                      <p class="mb-0 djgur74"><img src="/resources/images/payment/clk.png" alt=""><!--  3h 57m layover in Dallas-Forth (DFW) -->
	                      	<script>document.write(timeConvert(<c:out value='${inboundList.layOverTime}' />))</script> layover in ${inboundList.toCityName} (${inboundList.toAirport})
	                      </p>
	                  </div>
                  </c:if>
                  </c:forEach>
                  </c:if>
                  </div>
                </div>
                <div class="p-secton-rt">
                  <div class="p-secton-dt d-flex align-items-center ">
                    <img src="/resources/images/payment/cont.png" alt="">
                    <p class="mb-0">Contact Details</p>
                  </div>
                  <div class="p-4">
                    <div class="row">
                      <div class="col-md-6 col-lg-6">
                          <label for="exampleFormControlInput1" class="form-label">Mobile Number<span class="p-xdfr">*</span></label>
                          <!-- <input type="email" class="form-control p-hfur" id="exampleFormControlInput1" placeholder="Billing Phone"> -->
                          <form:input path="phoneNo" id="phoneNo" minlength="10"  maxlength="10" class="form-control p-hfur" placeholder="Billing Phone"  />
                      </div>
                      <div class="col-md-6 col-lg-6 stset">
                          <label for="exampleFormControlInput1" class="form-label">Email Address<span class="p-xdfr">*</span></label>
                          <form:input path="emailID" id="emailID" class="form-control p-hfur" placeholder="Email ID" />
                      </div>
                    </div>
                  </div>
                </div>
                
                <div class="p-secton-rt">
                  <jsp:include page="changeable_tickets_new.jsp" /> 
                </div>
                <div class="p-secton-rt d-none">
                  	<jsp:include page="surefund_ticket.jsp" /> 
                </div>
                <div class="p-secton-rt">
                  <jsp:include page="web-checkin.jsp" /> 
                </div>

                <div class="p-secton-rt">
                  <div class="p-secton-dt d-flex align-items-center ">
                    <img src="/resources/images/payment/passen.png" alt="">
                    <p class="mb-0">Passenger Information</p>
                  </div>
                  
                  <div class="p-sdhr4 p-3">
                    <p class="mb-0 p-jng8">Please enter traveler's name and date of birth exactly as shown on the passport (for international flights) or valid government-issued photo ID (for domestic flights) to be used on your trip. Also note that name changes are not permitted after booking.</p>
                  </div>
                  <hr class="my-0">
                  <div class="p-rjt6 py-3 px-4">
                    <c:forEach items="${bookingRequest.passengerDetails}" var="passenger" varStatus="indexed">
	                    <div class="row">
	                    <p class="mb-1 p-jj786">Passenger : <span><c:out value="${indexed.index+1}"/>
	                    	<c:if test="${passenger.passengerType == 1}">Adult 
	                        	<form:hidden path="passengerDetails[${indexed.index}].passengerType" value="1" /> 
	                        	<input type="hidden" id="passengerDetails${indexed.index}" value="Adult">
	                        </c:if>
							<c:if test="${passenger.passengerType == 2}">Child 
								<form:hidden path="passengerDetails[${indexed.index}].passengerType" value="2" />
								<input type="hidden" id="passengerDetails${indexed.index}" value="Child">	
							</c:if>
							<c:if test="${passenger.passengerType == 3}">Infant (on lap) 
								<form:hidden path="passengerDetails[${indexed.index}].passengerType" value="3" />
								<input type="hidden" id="passengerDetails${indexed.index}" value="InfantLap">
							</c:if>
							<c:if test="${passenger.passengerType == 4}">Infant (on seat) 
								<form:hidden path="passengerDetails[${indexed.index}].passengerType" value="4" />
								<input type="hidden" id="passengerDetails${indexed.index}" value="InfantSeat">
							</c:if>
						
	                    </span></p>
	                      <div class="col-md-6 col-lg-3 mb-2">
	                          <label for="inputState" class="form-label p-dhnr">Title<span class="p-xdfr">*</span></label>
	                          	<form:select path="passengerDetails[${indexed.index}].title" class="form-select p-hfur">
	                            	<option value="">Select </option>
	                            	<option value="Mr">Mr</option>
	                            	<option value="Mrs">Mrs</option>
	                            	<option value="Miss">Miss</option>
                          		</form:select>
	                      </div>
	                      <div class="col-md-6 col-lg-3 mb-2">
	                        <label for="exampleFormControlInput12" class="form-label p-dhnr ">First name<span class="p-xdfr">*</span></label>
	                        <form:input path="passengerDetails[${indexed.index}].firstName" placeholder="First Name" class="form-control textOnly p-hfur bg_input inputfieldset" />	                        
	                      </div>
	                      <div class="col-md-6 col-lg-3 mb-2">
	                        <label for="exampleFormControlInput13" class="form-label p-dhnr">Middle name</label>
	                        <!-- <input type="name" class="form-control p-hfur " id="exampleFormControlInput13" placeholder="Middle name"> -->
	                        <form:input path="passengerDetails[${indexed.index}].middleName" placeholder="Middle Name" class="form-control p-hfur textOnly" />
	                      </div>
	                      <div class="col-md-6 col-lg-3 mb-2">
	                        <label for="exampleFormControlInput14" class="form-label p-dhnr ">Last name<span class="p-xdfr">*</span></label>
	                        <!-- <input type="name" class="form-control p-hfur " id="exampleFormControlInput14" placeholder="Last name"> -->
	                        <form:input path="passengerDetails[${indexed.index}].lastName" placeholder="Last Name" class="form-control p-hfur textOnly" />
	                      </div>
	                      <div class="col-md-6 col-lg-3 mb-2">
	                        <label for="inputState" class="form-label p-dhnr ">Gender<span class="p-xdfr">*</span></label>
	                        <form:select path="passengerDetails[${indexed.index}].gender" class="form-select p-hfur">
								<c:forEach items="${gender}" var="curCategory" varStatus="loop">
									<form:option value="${loop.index}">${curCategory}</form:option>
								</c:forEach>
							</form:select>
					
	                      </div>
	                      <div class="col-md-6 col-lg-5 mb-2">
	                        <label for="inputState" class="form-label p-dhnr ">Date of Birth<span class="p-xdfr">*</span></label>
	                        <div class="d-flex">
                            <div>
	                          	<form:select path="passengerDetails[${indexed.index}].dobDay" id="paxdob${indexed.index}" class="form-select p-hfur u790"  items="${days}" />
                            </div>
                              
                             <div>
	                          	<form:select  path="passengerDetails[${indexed.index}].dateOfMonth" class="form-select p-hfur o-8i9" id="paxdom${indexed.index}">
                              
                              <c:forEach items="${month}" var="curCategory" varStatus="loop">
                          		<option value="${loop.index}">${curCategory}</option>
                        		</c:forEach>
                          </form:select>
                          </div>
                            <div> 

                            
	                          	<c:if test="${passenger.passengerType == 1}">
                              <form:select path="passengerDetails[${indexed.index}].dateOfYear" id="paxdoy${indexed.index}" class="form-select p-hfur t7834" items="${year}" />
                              </c:if>
                            <c:if test="${passenger.passengerType == 2}">
                              <form:select path="passengerDetails[${indexed.index}].dateOfYear" id="paxdoy${indexed.index}" class="form-select p-hfur t7834" items="${chyear}" />
                            </c:if>
                            <c:if test="${passenger.passengerType == 3}">
                              <form:select path="passengerDetails[${indexed.index}].dateOfYear" id="paxdoy${indexed.index}" class="form-select p-hfur t7834"  items="${infyear}" />
                            </c:if>
                            <c:if test="${passenger.passengerType == 4}">
                              <form:select path="passengerDetails[${indexed.index}].dateOfYear" id="paxdoy${indexed.index}" class="form-select p-hfur t7834" items="${infyear}" />
                            </c:if>
                          </div>

	                        </div>
	                      </div>
	                      <div id="error-message${indexed.index}"></div>
	                      <hr class="b-dashed2 mt-0 mb-2">
	                      
	                      <div class="d-flex align-items-center mt-2 mb-2">
                          	<img id="p-minus${indexed.index}" src="/resources/images/payment/minus.png" alt="">
                          	<img id="p-plus${indexed.index}" src="/resources/images/payment/plus.png" alt="">

                          	<p class="mb-0 ms-2 p-jj786"><span>Optional Request</span> (TSA Precheck/Redress Number)</p>
                        	</div>
                        <div id="p-uyd${indexed.index}">
                          <p class="p-sbr4">Emergency Contact Information</p>
                        <div class="row m-auto p-0">
                          <div class="col-md-6 col-lg-6 mb-3">
                            <form:input path="passengerDetails[${indexed.index}].contactName" placeholder="Emergency Contact Name" class="form-control p-hfur1" />
                          </div>
                          <div class="col-md-6 col-lg-6 mb-3">
                            <!-- <input type="text" class="form-control p-hfur1" placeholder="Emergency Contact Number" aria-label="Last name"> -->
                            <form:input path="passengerDetails[${indexed.index}].contactNumber" placeholder="Emergency Contact Number" class="form-control p-hfur1" />
                          </div>
                               <div class="col-md-4 col-lg-4 mb-3 rela">
					<select path="passengerDetails[${indexed.index}].splRequest" id="specialRequest" class="form-select p-hfur1 me-2">
	                            	<option value="">Select </option>
	                            	<option value="1">No Special services Requested</option>
	                            	<option value="2">Blind Passenger</option>
	                            	<option value="3">Bassinet for Infant</option>
	                            	<option value="4">Deaf Passenger</option>
	                            	<option value="5">Stretcher Assistance</option>
	                            	<option value="6">Wheelchair - Cannot walk up stairs nor to the seat . Must be carried</option>
	                            	<option value="7">Wheelchair - Cannot walk up stairs nor to the seat</option>
	                            	<option value="8">Wheelchair - Cannot walk up stairs but is able to walk to the seat</option>
                          		</select>						
                          </div>
                          <div class="col-md-4 col-lg-4 mb-3 rela eater">
                            <!-- <input type="text" class="form-control p-hfur1" placeholder="TSA Precheck" aria-label="Last name"> -->
                            <form:input path="passengerDetails[${indexed.index}].tsaPrecheck" placeholder="TSA Precheck" class="form-control p-hfur1" />
                            <div class="p-j86">
                              <img src="/resources/images/payment/info.png"  alt="">
                              <div class="uy897"> 
                                <div class="p-se5"></div>
                                <p class="mb-0">If you are a member of a trusted traveler program such as TSA PreCheck, Global Entry, NEXUS, or SENTRI, enter your number here.</p>
                              </div>
                            </div>
                          </div>
                          <div class="col-md-4 col-lg-4 mb-3 rela ">
                            
                            <form:input path="passengerDetails[${indexed.index}].reDressNumber" placeholder="Redress Number" class="form-control p-hfur1" />
                            <div class="p-j86">
                              <img src="/resources/images/payment/info.png"  alt="">
                              <div class="uy897"> 
                                <div class="p-se5"></div>
                                <p class="mb-0">If you are a member of a trusted traveler program such as TSA PreCheck, Global Entry, NEXUS, or SENTRI, enter your number here.</p>
                              </div>
                            </div>
                          </div>
                     
                          <div class="col-lg-12">
                            <p class="mb-0 p-rj5"><span class="font-500 text-black">Note:</span> All the mentioned services are totally based on airline confirmation and we are not liable to take any responsibility
                              if the airline cancels your request. </p>
                          </div>
                        
                        </div>
                        <hr class="b-dashed2  mb-2">
                    </div>
	                     </div>
                     </c:forEach>
                     
                  </div>
                  
                </div>
                               
                
                <div class="p-secton-rt">
                	<jsp:include page="cancel_protection.jsp" />
                	
                </div>
                
                <c:if test="${bookingRequest.sourceMedia!='Online'}">
                
                <div class="p-secton-rt">
                  <div class="p-secton-dt d-flex align-items-center ">
                    <img src="/resources/images/payment/payment.png" alt="">
                    <p class="mb-0">Payment and Billing (Secure SSL Encrpted Transaction) </p>
                  </div>
                  <div class="p-4">
                    <div class="row mb-3 justify-content-center align-items-center">
                      <div class="col-lg-4 text-lg-center">
                          <p class="mb-0 font-500">Credit/Debit Card No<span class="p-xdfr">*</span></p>
                      </div>
                      <div class="col-lg-7 rela">
                        <!-- <input type="text" class="form-control p-hfur1" placeholder="Credit/Debit Card No." aria-label="Last name"> -->
                        
                          <form:hidden path="paymentDetails.cardCode" id="paymentDetails-cardCode" value="Visa" />
                          <form:hidden id="paymentDetails_CardNumber" path="paymentDetails.cardNumber" name="Payments.CardNumber" />
                          <form:input id="paymentDetails_MaskCardNumber" path="paymentDetails.maskCardNumber" class="form-control p-hfur1 card-type" placeholder="Credit/Debit Card No." style="background-image:none;" maxlength="16" />
                        
                        
                        <!-- <div class="p-j86">
                          <img src="/resources/images/payment/gpay.png" alt="">
                          
                        </div> -->
                      </div>
                    </div>
                    <div class="row mb-3 justify-content-center align-items-center">
                      <div class="col-lg-4 text-lg-center">
                          <p class="mb-0 font-500">Card Holder's Name<span class="p-xdfr">*</span></p>
                      </div>
                      <div class="col-lg-7">
                        <!-- <input type="text" class="form-control p-hfur1" placeholder="Card Holder's Name" aria-label="Last name"> -->
                        <form:input id="paymentDetails_cardHolderName" path="paymentDetails.cardHolderName" class="form-control p-hfur1" placeholder="Card Holder's Name" />
                      </div>
                    </div>
                    <div class="row mb-3 justify-content-center align-items-center">
                      <div class="col-lg-4 text-lg-center">
                          <p class="mb-0 font-500">Expiration Date/CVV<span class="p-xdfr">*</span></p>
                      </div>
                      <div class="col-lg-7 ">
                        <div class="d-flex gaier">
                         <div>
                          <form:select path="paymentDetails.expiryMonth" id="paymentDetails_ExpiryMonth" class="form-select p-hfur1  ">
                            <c:forEach items="${cardMonth}" var="curExp" varStatus="loop">
                              <option value="${loop.index}">${curExp}</option>
                            </c:forEach>
                        </form:select>
                         </div>
                          <div>
                            <form:select id="paymentDetails_ExpiryYear" path="paymentDetails.expiryYear" items="${cardyear}" class="form-select p-hfur1  " />
                          </div>
                         <div>
                          <form:password id="paymentDetails_CvvNo" path="paymentDetails.cvvNo" class="form-control p-hfur1 we5e" placeholder="CVV" maxlength="4" />
                         </div>
                        </div>
                      </div>
                    </div>
                    <div class="row px-lg-5">
                      <div class="col-12 col-lg-6">
                      </div>
                      <div class="col-12 col-lg-6 d-lg-flex justify-content-end align-items-center">
                        <img src="/resources/images/payment/gate.png" alt="" >
                      </div>
                    </div>


                  </div>
                  
                </div>
                </c:if>
                
                
                
                <div class="p-secton-rt">
                  <div class="p-secton-dt d-flex align-items-center ">
                    <img src="/resources/images/payment/billing.png" alt="">
                    <p class="mb-0">Billing Information</p>
                  </div>
                  <div class="p-4">
                    <div class="row">
                      <div class="col-lg-6 mb-2">
                          <label for="exampleFormControlInput1" class="form-label">Street Address<span class="p-xdfr">*</span></label>
                          <form:input path="paymentDetails.address1" id="paymentDetails_address1" class="form-control p-hfur" placeholder="Address" />
                      </div>
                      <div class="col-lg-6 mb-2">
                          <label for="exampleFormControlInput1" class="form-label">Apt/Suit<span class="p-xdfr">*</span></label>
                          <form:input path="paymentDetails.address2" id="paymentDetails_address2" class="form-control p-hfur" placeholder="Near by Address" />
                      </div>
                      <div class="col-md-6 col-lg-6 mb-2">
                        <label for="inputState" class="form-label ">City<span class="p-xdfr">*</span></label>
                        <form:input path="paymentDetails.city" id="paymentDetails_city" class="form-control p-hfur" placeholder="City/ Town" />
                      </div>
                      <div class="col-md-6 col-lg-6 mb-2">
                        <label for="inputState" class="form-label ">Country<span class="p-xdfr">*</span></label>
                        <form:select path="paymentDetails.country" id="paymentDetails_Country" class="form-select p-hfur" ng-options="opt.Name for opt in countryList track by opt.ID" ng-model="selectedCountry" >
                         </form:select>
                      </div>
                      <div class="col-md-6 col-lg-6 mb-2" id="stateInp" ng-hide="IsHidden">
                        <label for="inputState" class="form-label ">State</label>
                        <form:input path="paymentDetails.state" id="paymentDetails_state1" class="form-select p-hfur" placeholder="State/ Province"/>
                      </div>
                      <div class="col-md-6 col-lg-6 mb-2" id="stateSel" ng-hide="IsShow">
                        <label for="inputState" class="form-label ">State</label>
                        <form:select path="paymentDetails.state" id="paymentDetails_state2" class="form-select p-hfur" ng-options="opt.Name for opt in usState track by opt.ID" ng-model="selectedItem"> </form:select>
                      </div>
                      <div class="col-md-6 col-lg-6 mb-2">
                        <label for="exampleFormControlInput1" class="form-label">Postal/Zip Code<span class="p-xdfr">*</span></label>
                        <form:input path="paymentDetails.postalCode" id="paymentDetails_postalCode" class="form-control p-hfur" placeholder="Postal/Zip Code"/>
                    </div>
                    <div class="col-lg-6 ">
                      <label for="exampleFormControlInput1" class="form-label">Billing Number (Associated with bank)<span class="p-xdfr">*</span></label>
                      <form:input path="mobileNo" id="mobileNo" minlength="10" maxlength="10" class="form-control p-hfur" placeholder="Billing Mobile"  />
                  </div>
                    </div>
                  </div>
                  
                </div>
                
              </div>

              <div class="col-lg-4 p-shr7">
                
                <div class="p-y68y">
                
                <c:if test="${searchRequest.device == 'Mobile'}">
					<jsp:include page="price_mobile.jsp" />
				</c:if>
				
				<c:if test="${searchRequest.device == 'Computer' || searchRequest.device == 'Desktop'}">
					<jsp:include page="price_desktop.jsp" />
				</c:if>
                  
                  <div class="detail-p mt-3" >
                    <p class="p-ajf85">Book With <img src="/resources/images/logo.png" alt="" width="35%"></p>
                    <img src="/resources/images/payment/left.png" alt="" >
                  </div>
                		
                  <!--<p class="mt-3 mb-1 p-sr4 ">We are loved by all of Our Customers</p>
                  <div class="d-flex align-items-center pb-3">
                    <div class="d-flex align-items-center">
                      <img src="/resources/images/payment/star.png" alt="">
                      <img src="/resources/images/payment/star.png" alt="">
                      <img src="/resources/images/payment/star.png" alt="">
                      <img src="/resources/images/payment/star.png" alt="">
                      <img src="/resources/images/payment/star1.png" alt="">
                    </div>
                    <p class="mb-0 p-jed85 ms-1">1,214 Reviews on  </p>
                    <div class="d-flex p-dwst align-items-center">
                      <img class="mx-1" src="/resources/images/payment/str.png" alt="">
                      <p class="mb-0">Trustpilot</p>
                    </div>
                  </div>-->
                  	<span style="color:#f9f9f9;"> Mark:<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${(bookingRequest.flightResult.fare.totalMarkup)}" /> </span>
			<span style="color:#f9f9f9;">${bookingRequest.flightResult.fare.markupID}, G-${bookingRequest.flightResult.gdsType}</span>
		</div>
                	
                </div>
                
              </div>
              
			<div class="my-3 dtw6" style="max-width: 865px; width: 100%;">Kindly read the <a href="/terms-and-conditions" target="_blank" class="tcshow mx-2 srtfet">Terms & Conditions</a> and agree the same.</div>
				
              <div style="max-width: 865px; width: 100%;">
                <div class="p-secton-rt p-3">
                  <div class="p-oko">                  
                  <p class="mb-0 clrg">
                  	Review and book your trip
					Please review your travel details to make sure the dates and times are correct. Please check your spelling. Names of passengers on the flight must exactly match a government-issued photo ID. Please review your booking conditions:
					Fair rules:
					Pay to choose your seat
					Pay to carry a handbag
					Pay to bring checked luggage
					Cancellations not allowed:
					Change according to airline policy
					Personal item according to airline policy
					Seat selection is based on the sole discretion of the airlines.
					Hand luggage according to airline policy
					Checked baggage according to airline policy
					Cancellations not allowed
					It depends on the cabin and the airline's policy fare to change
					We understand that sometimes plans change. We do not charge a cancellation or change fee. Where the airline charges such fees in accordance with its own policies, the cost will be passed on to you.
					Tickets are non-refundable and non-transferable. Name changes are not permitted. Please read the full penalty rules for changes and cancellations. Read important information about airline liability limitations. Prices may not include baggage fees or other charges charged directly by the airline. Fares are not guaranteed until ticket is issued.
                  </p>
                                   
                  </div>

			           <div class="p-okoo" id="checkbox-container">
                  	<div class="d-lg-flex" style="margin-top:12px;">
                  		<div class="d-flex wrwsr align-items-center" >	
                    		<input type="checkbox" class="form-check-input highligt me-1 my-0 wrwr3" name="agree" id="iagree">
                  			<p class="mb-0 clrg fr6h">By clicking Book Now, I agree that I have read and accepted ${sentenceCase}  <a href="/terms-and-conditions" target="_blank" class="tcshow mx-2 srtfet">Terms and Conditions</a> and 
                          <a href="/privacy-policy" target="_blank" class="ppshow ms-2 srtfet">Privacy Policy</a> </p>
                  		</div>						
                 	</div>
                 </div>

                </div>
		
                <p class="my-3 dtw6"></p>
                                
                <button type="submit" onClick="confirmFlight();" id="candbb" class="btn p-uyghy" disabled>Confirm & Book</button>
                
                <div class="text-center">
                  <h3 class="p-ji9y">Secure Booking</h3>
                  <p class="mb-1 boyjf">We Use secure transmission and encrypted storage to protect your personal information.</p>
                </div>
              </div>
            </div>
        </div>
      </section>
 </form:form>
      
      <div class="visible-xs">
      	<div class="bottom-call-bar2" style="bottom: 0px;">    
    		<a id="a_contactNo" href="tel:<c:out value='${sourceTFN}'/>">
        		<div class="call-text">Call &amp; Get Unpublished Flight Deals!</div>
        		<div class="PH_contactNo2"><c:out value='${sourceTFN}'/></div>
        	</a> 
		</div>
    	</div>
      <footer class="bg-white">
        <div class="container">
            <div class="row justify-content-center text-center align-items-center">
                <div class="col-lg-12">
                    <p class="my-2 fotrd">Copyright @${copyRightYear}, ${websiteName}. All rights reserved. <img src="/resources/images/fotr.png" alt=""></p>
                </div>
            </div>
        </div>
    </footer>
    
    <section class="ajiwrh">
        <div class="container">
          <div class="row">
            <div class="col-8">
              <p class="mb-0 ">Total Amount</p>
            </div>
            <div class="col-4">
              <p class="mb-0 jhdgt">${websiteCurrency} <span id="tp_mob_ftr"><fmt:formatNumber  type="number" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.flightResult.fare.grandTotal}" /></span></p>
            </div>
          </div>
        </div>
    </section>
    
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js" integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q" crossorigin="anonymous"></script>
<script>
     $(document).ready(function(){
         $(".hi0g6").click(function(){
             $(".hi0g5").show();
             $(".hi0g6").hide();
         });
         $(".hi0g5").click(function(){
             $(".hi0g6").show();
             $(".hi0g5").hide();
         });
               
         $("img[id^='p-minus']").each(function(){
            var index = $(this).attr('id').replace('p-minus', '');
            var $minus = $("#p-minus" + index);
            var $plus = $("#p-plus" + index);
            var $uyd = $("#p-uyd" + index); 
            $minus.hide();
            $plus.show();
            $uyd.hide();
    
            $minus.click(function(){
                $plus.show();
                $uyd.hide();
                $minus.hide();
            });
		
            $plus.click(function(){
                $uyd.show();
                $plus.hide();
                $minus.show();
            });
        });
    });
</script>
<script>
      $('#iagree').click(function(){
   		if($(this).is(':checked')){
       		$('#candbb').attr("disabled", false);
       	} 
       	else{
       		$('#candbb').attr("disabled", true);
      	}
	});
</script>
   	
<script>
  $('.form-select').on('change', function() {
  if ($(this).val()) {
	return $(this).css('color', '#212529');
  } else {
	return $(this).css('color', '#7B7B7B');
  }
});
</script>
<script>
  document.querySelector('.ajiwrh').addEventListener('click', function () {
    if (window.innerWidth <= 768) { // Apply only for mobile view
      const priceSection = document.querySelector('.detail-p');
      const priceSectionTop = priceSection.getBoundingClientRect().top + window.scrollY;
      const offset = 50;
      const scrollToPosition = priceSectionTop - offset;
      window.scrollTo({ top: scrollToPosition, behavior: 'smooth' });
    }
  });
</script>

</html>