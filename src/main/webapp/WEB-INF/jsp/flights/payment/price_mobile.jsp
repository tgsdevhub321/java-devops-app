<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<input type="hidden" id="grandTotal" value="${bookingRequest.flightResult.fare.grandTotal}" />
<form:hidden path="cancellationProtectAmount" id="cancellationProtectAmount" value="0.00" />
<form:hidden path="cancellationProtectTaken" id="cancellationProtectTaken" value="No" />

<div class="detail-p">
    <div class="row align-items-center mx-auto clod-e">
      <div class="col-12 col-lg-12 ">
        <p class=" my-2 font-500 clrg1">Price Details (${websiteCurrency})</p>
      </div>
    </div>
    <div class="row align-items-center mx-auto clod-e">
      <div class="col-8 col-lg-8 ">
        <p class=" my-2 clrg2">${bookingRequest.adults} Traveler(s) : Adult </p>
      </div>
      <div class="col-4 col-lg-4 ">
        <p class=" my-2 font-500 clrg1 text-end">${websiteCurrency} <!-- 226.<sup>96</sup> --> 
        	<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.adults * (bookingRequest.flightResult.fare.adultFare+bookingRequest.flightResult.fare.adultTax+bookingRequest.flightResult.fare.adultMarkup)}" />
        </p>
      </div>
    </div>
    <c:if test="${bookingRequest.child > 0}">
    <div class="row align-items-center mx-auto clod-e">
      <div class="col-8 col-lg-8 ">
        <p class=" my-2 clrg2">${bookingRequest.child} Traveler(s) : Child </p>
      </div>
      <div class="col-4 col-lg-4 ">
        <p class=" my-2 font-500 clrg1 text-end">${websiteCurrency} <!-- 226.<sup>96</sup> --> 
        	<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.child * (bookingRequest.flightResult.fare.childFare+bookingRequest.flightResult.fare.childTax+bookingRequest.flightResult.fare.childMarkup)}" />
        </p>
      </div>
    </div>
    </c:if>
    <c:if test="${bookingRequest.infants > 0}">
    <div class="row align-items-center mx-auto clod-e">
      <div class="col-8 col-lg-8 ">
        <p class=" my-2 clrg2">${bookingRequest.infants} Traveler(s) : Infant (Lap) </p>
      </div>
      <div class="col-4 col-lg-4 ">
        <p class=" my-2 font-500 clrg1 text-end">${websiteCurrency} <!-- 226.<sup>96</sup> --> 
        	<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.infants * (bookingRequest.flightResult.fare.infantFare+bookingRequest.flightResult.fare.infantTax+bookingRequest.flightResult.fare.infantMarkup)}" />
        </p>
      </div>
    </div>
    </c:if>
    <c:if test="${bookingRequest.infantsWs > 0}">
    <div class="row align-items-center mx-auto clod-e">
      <div class="col-8 col-lg-8 ">
        <p class=" my-2 clrg2">${bookingRequest.infantsWs} Traveler(s) : Infant (Seat) </p>
      </div>
      <div class="col-4 col-lg-4 ">
        <p class=" my-2 font-500 clrg1 text-end">${websiteCurrency} <!-- 226.<sup>96</sup> --> 
        	<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.infantsWs * (bookingRequest.flightResult.fare.infantWsFare+bookingRequest.flightResult.fare.infantWsTax+bookingRequest.flightResult.fare.infantWsMarkup)}" />
        </p>
      </div>
    </div>
    </c:if>
    
    <div id="fareladderct" style="display:none;" class="row align-items-center mx-auto clod-e">
      <div class="col-8 col-lg-8 ">
        <p class=" my-2 clrg2"><span id="changeableText">Standard Ticket Fee</span><img id="removeChangeableText" onclick="addChangeTickets('Basic', '${basicTicket}', ${basicTicket});" class="ms-1" src="/resources/images/payment/dustbinn.png" alt=""></p>
      </div>
      <div class="col-4 col-lg-4 ">
        <p class=" my-2 font-500 clrg1 text-end">${websiteCurrency} <!-- 142.<sup>93</sup> --> <span id="ct_price"></span> </p>
      </div>
    </div>
    <div id="faresurefund" style="display:none;" class="row align-items-center mx-auto clod-e">
      <div class="col-8 col-lg-8 ">
        <p class=" my-2 clrg2">Surefund Ticket <img id="removeSurefundTkt" onClick="setSR('Remove',0.0)" class="ms-1" src="/resources/images/payment/dustbinn.png" alt=""></p>
      </div>
      <div class="col-4 col-lg-4 ">
        <p class=" my-2 font-500 clrg1 text-end">${websiteCurrency} <!-- 50.<sup>00</sup> --> <span id="sr_price"></span> </p>
      </div>
    </div>
    <div class="row align-items-center mx-auto clod-e" id="fareladderwc" style="display:none;">
      <div class="col-8 col-lg-8 ">
        <p class=" my-2 clrg2">Web Check-In Fee <img id="removeWebCheckIn" onclick="removeWebCheckin('Remove', 0.0);" class="ms-1" src="/resources/images/payment/dustbinn.png" alt=""></p>
      </div>
      <div class="col-4 col-lg-4 ">
        <p class=" my-2 font-500 clrg1 text-end">${websiteCurrency} <!-- 10.<sup>00</sup> --> <span id="wc_price"></span> </p>
      </div>
    </div>
    
    <div class="row align-items-center mx-auto clod-e" id="fareladdercp" style="display:none;">
      <div class="col-8 col-lg-8 ">
        <p class=" my-2 clrg2">Cancellation Protect Fee <img id="removeCancellation" onClick="removeCP('Remove',0.0)" class="ms-1" src="/resources/images/payment/dustbinn.png" alt=""></p>
      </div>
      <div class="col-4 col-lg-4 ">
        <p class=" my-2 font-500 clrg1 text-end">${websiteCurrency} <!-- 29.<sup>00</sup> --> <span id="cp_price"></span> </p>
      </div>
    </div>
    
    <div class="row align-items-center clod-e2 px-2">
      <div class="col-8 col-lg-8">
        <p class=" my-2 ">Total Amount</p>
      </div>
      <div class="col-4 col-lg-4 ">
        <p class=" my-2 font-500 text-end">${websiteCurrency} <!-- 408.<sup>89</sup> --> <span id="total_price"><fmt:formatNumber  type="number" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.flightResult.fare.grandTotal}" /></span> </p>
      </div>
    </div>
      
      <p class="p-ur74 "> <img src="/resources/images/payment/info.png" alt="" width="3%"><span class="font-500 ms-1">Note :</span> All Fares displayed are quoted in ${websiteCurrency}${bookingRequest.returnDate} and inclusive of base fare, taxes and all fees. Additional baggage fees may apply as per the airline policies.</p>

  </div>
  
  
  
 
              