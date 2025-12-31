<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:set var="tripTypeVal" value="${flightRequest.tripType}" scope="request" />
<c:set var="totalPaxweb" value="${bookingRequest.adults+bookingRequest.child+bookingRequest.infants+bookingRequest.infantsWs}" scope="request" />
<c:set var="webchinAmTotal" value="${(bookingRequest.webcheckinAmount*tripTypeVal)*totalPaxweb}" scope="request" />
<fmt:formatNumber type="number" var="autoChkinAmount" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.webcheckinAmount}" />
<c:set var="fullValue" value="${fn:split(autoChkinAmount, '.')}" />
<c:set var="price1" value="${fullValue[0]}" />
<c:set var="price2" value="${fullValue[1]}" />
<form:hidden path="webcheckinAmount" id="webcheckinAmount" value="0.00"/>
<form:hidden path="webcheckinTaken" id="webcheckinTaken" value="No"/>


             
             <div class="p-secton-dt d-flex align-items-center">
                    <img src="/resources/images/payment/web.png" alt="">
                    <p class="mb-0">Web Check-In</p>
                  </div>
                  <div class="p-st4">
                    
                    <div class="row align-items-center">
                      <div class="col-md-8 col-lg-8">
                        <p class="mb-2 p-jsge">Save time rest easy with Web Check-in</p>
                        <div class="d-flex align-items-center pb-3">
                          <img src="/resources/images/payment/tick.png" alt="">
                          <p class="mb-0 ms-2 p-hfu73r">Avoid airlines fees for printing a boarding pass</p>
                        </div>
                        <div class="d-flex align-items-center pb-3">
                          <img src="/resources/images/payment/tick.png" alt="">
                          <p class="mb-0 ms-2 p-hfu73r">Get an assigned seat before reaching the airport*</p>
                        </div>
                        <div class="d-flex align-items-center pb-3">
                          <img src="/resources/images/payment/tick.png" alt="">
                          <p class="mb-0 ms-2 p-hfu73r">We'll check you in, so you don't have to remember</p>
                        </div>
                        <div class="d-flex align-items-center pb-0">
                          <img src="/resources/images/payment/tick.png" alt="">
                          <p class="mb-0 ms-2 p-hfu73r">Get ahead of the crowd by downloading the boarding pass</p>
                        </div>
                      </div>
                      <div class="col-md-4 col-lg-4 text-center">
                        <img src="/resources/images/payment/webchek.png" alt="">
                        <p class="p-edwt5t">${websiteCurrency} ${price1}<sup>.${price2}</sup></p>
                        <p class="p-edwt5">Each way per passenger</p>
                        
                        <button type="button" class="btn btn-primary p-edwt5w hi0g6" id="wciaddbtn" onclick="addWebCheckin('Add', ${webchinAmTotal});"> Add to booking </button>
                        <button type="button" class="btn btn-primary p-edwt5w hi0g5" id="wcibtnremove" style="display:none;" onclick="removeWebCheckin('Remove', 0.0);"> Remove <img src="/resources_new/images/payment/bin.png" alt=""></button>
                      </div>
                    </div>
                  </div>
                  <p class="mb-0 p-gt77"><span>Note :</span> Save time. Enjoy a more relaxed trip. Boarding pass will be emailed to your provided email ID. Print them and take them with
                    you. For Seats and Bags related queries, you can call us at +1-866-503-8818</p>