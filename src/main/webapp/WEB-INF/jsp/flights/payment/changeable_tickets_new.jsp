<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!--Select Eco_Details new-->
			 
				<c:set var="basicTicket" value="${bookingRequest.flightResult.fare.grandTotal}" scope="request" />
				<c:set var="originalTicket" value="${bookingRequest.flightResult.fare.grandOrgTotal}" scope="request" />
				<c:set var="totalPax" value="${bookingRequest.adults+bookingRequest.child+bookingRequest.infantsWs}" scope="request" />
				<c:set var="standardMarkup" value="${(bookingRequest.changeableTicketMarkupOne*totalPax)}" scope="request" />
				<c:set var="flexiMarkup" value="${(bookingRequest.changeableTicketMarkupTwo*totalPax)}" scope="request" />
				
				<c:choose>
					<c:when test="${bookingRequest.flightResult.fare.grandTotal >= bookingRequest.flightResult.fare.grandOrgTotal}">
						<c:set var="standardTicketDisplay" value="${basicTicket+(standardMarkup)}" scope="request" />
						<c:set var="flexiTicketDisplay" value="${basicTicket+(flexiMarkup)}" scope="request" />
						<c:set var="standardTicket" value="${standardMarkup}" scope="request" />
						<c:set var="flexiTicket" value="${flexiMarkup}" scope="request" />
					</c:when>
					<c:otherwise>
						<c:set var="standardTicketDisplay" value="${originalTicket+(standardMarkup)}" scope="request" />
						<c:set var="flexiTicketDisplay" value="${originalTicket+(flexiMarkup)}" scope="request" />
						<c:set var="standardTicket" value="${originalTicket-basicTicket+standardMarkup}" scope="request" />
						<c:set var="flexiTicket" value="${originalTicket-basicTicket+flexiMarkup}" scope="request" />
					</c:otherwise>
				</c:choose>
				
				<form:hidden path="changeableTicketAmount" id="changeableTicketAmount" value="0.00"/>
				<form:hidden path="changeableTickets" id="changeableTickets" value="No"/>
				<form:hidden path="changeableTicketType" id="changeableTicketType" value="Basic"/>
				<input type="hidden" id="grandTotal" value="${bookingRequest.flightResult.fare.grandTotal}" />
				
				<div class="p-secton-dt d-flex align-items-center justify-content-between">
                    <div class="d-flex align-items-center">
                      <img src="/resources/images/payment/recom.png" alt="">
                      <p class="mb-0">You have Selected <span id='tktTxt'>Basic Ticket</span></p>
                    </div>
                    <p class="mb-0 p-f86h">
                    	${websiteCurrency} <span id='tktcost'><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${basicTicket}"/></span>
                    </p>
                  </div>
                  <div class="p-dhfg8">
                    <div class="row">
                      
                      
                      <div class="col-md-4 col-lg-4 p-ty7u">
                        <div id="basic_tkt" class="p-tick active-p">
                          <div class="d-flex align-items-center justify-content-center">
                            <!-- <div class="p-doty"></div> -->
                            <p class="mb-0 ms-2 p-djrt">Basic Ticket</p>
                          </div>
                          <div class="p-djr">
                            <p class="mb-0">
                            ${websiteCurrency} <fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${basicTicket}" /> 
                            <span></span></p>
                          </div>
                          <hr>
                          <div class="d-flex align-items-center pb-1">
                            <img src="/resources/images/payment/tick.png" alt="">
                            <p class="mb-0 ms-2 p-hfu7">Personal item Included</p>
                          </div>
                          <div class="d-flex align-items-center py-1">
                            <img src="/resources/images/payment/incorrect.png" alt="">
                            <p class="mb-0 ms-2 p-hfu7">Changes Not Permitted</p>
                          </div>
                          <div class="d-flex align-items-center py-1">
                            <img src="/resources/images/payment/incorrect.png" alt="">
                            <p class="mb-0 ms-2 p-hfu7">Non Refundable</p>
                          </div>
                          <div class="d-flex align-items-center py-1">
                            <img src="/resources/images/payment/incorrect.png" alt="">
                            <p class="mb-0 ms-2 p-hfu7">No Seat Selection</p>
                          </div>
                          <div class="d-flex align-items-center pt-1">
                            <img src="/resources/images/payment/incorrect.png" alt="">
                            <p class="mb-0 ms-2 p-hfu7">Upgrades Not Permitted</p>
                          </div>
                          <button type="button" id="btnBasicTicket" onclick="addChangeTickets('Basic', '${basicTicket}', ${basicTicket});" class="btn btn-primary p-fry7 p-dxj">Selected</button>
                      </div>
                      </div>
                                            
                      <div class="col-md-4 col-lg-4 p-ty7u">
                        <div class="p-tick">
                          <div class="d-flex align-items-center justify-content-center">
                            <!-- <div class="p-doty"></div> -->
                            <p class="mb-0 ms-2 p-djrt">Standard Ticket</p>
                          </div>
                          <div class="p-djr">
                            <p class="mb-0">Add ${websiteCurrency}  
                            	<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${standardTicket}" />
                            <span></span></p>
                          </div>
                          <hr>
                          <div class="d-flex align-items-center pb-1">
                            <img src="/resources/images/payment/tick.png" alt="">
                            <p class="mb-0 ms-2 p-hfu7">Personal Item Included</p>
                          </div>
                          <div class="d-flex align-items-center py-1">
                            <img src="/resources/images/payment/tick.png" alt="">
                            <p class="mb-0 ms-2 p-hfu7">Carry On Bag Included</p>
                          </div>
                          <div class="d-flex align-items-center py-1">
                            <img src="/resources/images/payment/incorrect.png" alt="">
                            <p class="mb-0 ms-2 p-hfu7">Changes Not Permitted</p>
                          </div>
                          <div class="d-flex align-items-center py-1">
                            <img src="/resources/images/payment/incorrect.png" alt="">
                            <p class="mb-0 ms-2 p-hfu7">Non Refundable</p>
                          </div>
                          <div class="d-flex align-items-center py-1">
                            <img src="/resources/images/payment/incorrect.png" alt="">
                            <p class="mb-0 ms-2 p-hfu7">No Seat Selection</p>
                          </div>
                          <button type="button" id="btnStandardTicket" onclick="addChangeTickets('Standard', '${standardTicket}', ${standardTicketDisplay});" class="btn btn-primary p-fry7 p-dxj">Select</button>
                          
                      </div>
                      </div>
                      
                      
                      <div class="col-md-4 col-lg-4 p-ty7u">
                        <div class="p-tick">
                          <div class="d-flex align-items-center justify-content-center">
                            <!-- <div class="p-doty"></div> -->
                            <p class="mb-0 ms-2 p-djrt">Flexible Ticket</p>
                          </div>
                          <div class="p-djr">
                            <p class="mb-0">Add ${websiteCurrency}  
                            	<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${flexiTicket}" />
                            	<span></span>
			   </p>
                          </div>
                          <hr>
                          <div class="d-flex align-items-center pb-1">
                            <img src="/resources/images/payment/tick.png" alt="">
                            <p class="mb-0 ms-2 p-hfu7">Checked Bag Included</p>
                          </div>
                          <div class="d-flex align-items-center pb-1">
                            <img src="/resources/images/payment/tick.png" alt="">
                            <p class="mb-0 ms-2 p-hfu7">Carry On Bag Included</p>
                          </div>
                          <div class="d-flex align-items-center py-1">
                            <img src="/resources/images/payment/tick.png" alt="">
                            <p class="mb-0 ms-2 p-hfu7">Changes Permitted for a fee</p>
                          </div>
                          <div class="d-flex align-items-center py-1">
                            <img src="/resources/images/payment/tick.png" alt="">
                            <p class="mb-0 ms-2 p-hfu7">Seat Selection Allowed</p>
                          </div>
                          <div class="d-flex align-items-center py-1">
                            <img src="/resources/images/payment/tick.png" alt="">
                            <p class="mb-0 ms-2 p-hfu7">Upgrades Permitted</p>
                          </div>
                          <div class="d-flex align-items-center py-1">
                            <img src="/resources/images/payment/incorrect.png" alt="">
                            <p class="mb-0 ms-2 p-hfu7">Non Refundable</p>
                          </div>
                          <button type="button" id="btnFlexibleTicket" onclick="addChangeTickets('Flexible', '${flexiTicket}', ${flexiTicketDisplay});" class="btn btn-primary p-fry7 p-dxj">Select</button>
                      </div>
                      </div>
                      
                      <p class="p-fnjt9"><span>Disclaimer:</span> Airlines have a checked bag weight limits therefore for excess baggage you need to pay an extra fee at the airport. Additionally your international checked baggage size varies considerably depending on which airline you choose.</p>
                      </div>
                    </div>
                    

<script>

/* $(document).ready(function() {
	$('#btnBasicTicket').prop('checked', true);
}); */
$(document).ready(function() {
    $('.p-tick button').click(function() {
        // Remove 'active-p' class from all buttons' parents
        $('.p-tick').removeClass('active-p');
        
        // Reset all button texts to 'Select'
        $('.p-tick button').text('Select');
        
        // Add 'active-p' class to the clicked button's parent
        $(this).parent().addClass('active-p');
        
        // Change the clicked button text to 'Selected'
        $(this).text('Selected');
    });
});

</script>