<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:set var="totalCount" value="${bookingRequest.adults+bookingRequest.child+bookingRequest.infantsWs}" />
<c:set var="totalSurefundAmount" value="${(totalCount)*(bookingRequest.surefundAmount)}" />
<form:hidden path="surefundAmount" id="surefundAmount" value="0.00"/>
<form:hidden path="surefundTaken" id="surefundTaken" value="No"/>

<div class="p-secton-dt2 d-flex align-items-center">
          <img src="/resources/images/payment/Outline.png" alt="">
          <p class="mb-0">Surefund Ticket</p>
          <button type="button" class="btn btn-primary p-fry7 mt-0 ms-3">Recommended</button> 
        </div>
        <div class="p-fjh85 py-3 px-4">
          <div class="row">
            <div class="col-md-5 col-lg-5">
              <div class="d-flex align-items-center pb-1">
                <img src="/resources/images/payment/tick.png" alt="">
                <p class="mb-0 ms-2 p-vng96">Illness / Injury (including Covid)</p>
              </div>
              <div class="d-flex align-items-center pb-1">
                <img src="/resources/images/payment/tick.png" alt="">
                <p class="mb-0 ms-2 p-vng96">Pre-existing Medical Condition</p>
              </div>
              <div class="d-flex align-items-center pb-1">
                <img src="/resources/images/payment/tick.png" alt="">
                <p class="mb-0 ms-2 p-vng96">Pregnancy Complication</p>
              </div>
              <div class="d-flex align-items-center pb-1">
                <img src="/resources/images/payment/tick.png" alt="">
                <p class="mb-0 ms-2 p-vng96">Demise of Immediate Family</p>
              </div>
              <div class="d-flex align-items-center pb-1">
                <img src="/resources/images/payment/tick.png" alt="">
                <p class="mb-0 ms-2 p-vng96">Public Transport Failure</p>
              </div>
            </div>
            <div class="col-md-4 col-lg-4">
              <div class="d-flex align-items-center pb-1">
                <img src="/resources/images/payment/tick.png" alt="">
                <p class="mb-0 ms-2 p-vng96">Flight Delay/Change </p>
              </div>
              <div class="d-flex align-items-center pb-1">
                <img src="/resources/images/payment/tick.png" alt="">
                <p class="mb-0 ms-2 p-vng96">Mechanical Breakdown </p>
              </div>
              <div class="d-flex align-items-center pb-1">
                <img src="/resources/images/payment/tick.png" alt="">
                <p class="mb-0 ms-2 p-vng96">Adverse Weather </p>
              </div>
              <div class="d-flex align-items-center pb-1">
                <img src="/resources/images/payment/tick.png" alt="">
                <p class="mb-0 ms-2 p-vng96">Home Emergency</p>
              </div>
              <p class="mb-0 ft6yg">And Many More...</p>
            </div>
            <div class="col-md-3 col-lg-3 ps-lg-4">
              <div class="p-dft76">
                <img src="/resources/images/payment/bill.png" alt="">
                <div class="p-sh">
                  <p class="mb-0 p-frytf">${websiteCurrency} 50.<sup>00</sup></p>
                  <p class="mb-0 p-d68uu">Per Person</p>
                </div>
              </div>
            </div>
          </div>
        </div>
        <p class="mb-0 p-ertyjuy">Upgrade your booking and receive a <span class="dfg5">100% refund</span> if you cannot attend and can evidence one of the many reasons in our <span class="gyr5"><a href="/terms-and-conditions" target="_blank" class="gyr5">Terms & Conditions</a>,</span> which you accept when you select a refundable Booking.</p>
        <div class="p-je7 pb-0">
          <div class="p-he7" id="btnYesRef" onclick="setSR('Add', ${totalSurefundAmount});">
            <div class="dou"></div>
            <p class="mb-0 p-kgt7">
            	<label style="cursor: pointer;"><input type="radio" value="" checked style="width: 0;"> 
            	<span>Yes,</span> Make my booking refundable</label>
            </p>
          </div>
          <div class="p-he7 active-g" id="btnNoRef" onclick="setSR('Remove', 0.0);">
            <div class="dou"></div>
            <p class="mb-0 p-kgt7">
            	<label style="cursor: pointer;"><input type="radio" value="" style="width: 0;"> 
            	<span>No,</span> Continue with a non-refundable booking</label>
            </p>
          </div>
        </div>
        <div class="b-dashed px-4 mt-3 mb-2"></div>
        <p class=" p-fr65">Upgrade your booking for a small increase of ${websiteCurrency} 50.<sup>00</sup> and receive a 100% refund if you cannot attend and can provide evidence for one of the many reasons in our <a href="/terms-and-conditions" target="_blank" class="gyr5">Terms & Conditions</a>, which you accept when you select a refundable Booking.</p>

