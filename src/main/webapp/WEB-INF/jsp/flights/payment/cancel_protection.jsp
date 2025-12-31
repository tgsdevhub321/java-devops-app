<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:set var="totalCount" value="${bookingRequest.adults+bookingRequest.child+bookingRequest.infantsWs}" />
<c:set var="totalCancelProt" value="${(totalCount)*(bookingRequest.cancelProtectDisplayAmount)}" />
		
<div class="p-secton-dt d-flex align-items-center">
     <img src="/resources/images/payment/cancel.png" alt="">
     <p class="mb-0">Cancellation Protection</p>
   </div>
   <div class="p-4">
     <div class="row mb-3">
       <div class="col-md-9 col-lg-9 pe-0">
           <h4>Cancellation Protection</h4>
           <p class="mb-0 p-hut7">When you select the option of Best Purchase Guarantee, you are offered exclusive cancellation advantages!</p>
       </div>
       <div class="col-md-3 col-lg-3 ">
         <div class="p-dft76f">
           <p class="mb-0">Only <!-- ${websiteCurrency} 29.<sup>99</sup> -->
           	${websiteCurrency} <fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${bookingRequest.cancelProtectDisplayAmount}" />
           </p>
         </div>
       </div>
     </div>
     <h5>Additional Perks include</h5>	
     <div class="d-flex align-items-center pb-2">
       <img src="/resources/images/payment/tick.png" alt="">
       <p class="mb-0 ms-2 p-hfu73r">Cancellation without a fee and getting a full refund as well within 24 hours from booking.</p>
     </div>
     <div class="d-flex align-items-center pb-2">
       <img src="/resources/images/payment/tick.png" alt="">
       <p class="mb-0 ms-2 p-hfu73r">Option to lock in the cheapest and most incredible airfare before the crowd comes running after it.</p>
     </div>
     <div class="d-flex align-items-center pb-3">
       <img src="/resources/images/payment/tick.png" alt="">
       <p class="mb-0 ms-2 p-hfu73r">When there's an error in the reservation, simply cancel and rebook your flights with the correct information at no additional cost.</p>
     </div>
     <p id="yesCancel" class="p-97hr6" onClick="setCP('Add',${totalCancelProt})">
		<form:radiobutton path="cancellationProtectTaken" id="cpTakenYes" value="Yes" style="width: 0;"/>
		<label for="cpTakenYes">Yes, please add the benefits of Pre-Cancellation at ${websiteCurrency} <fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${totalCancelProt}" /></label>                    
     </p>
     <p id="noCancel" class="p-97hr6 mb-0" onClick="setCP('Remove',0.0)">
     	<form:radiobutton path="cancellationProtectTaken" id="cpTakenNo" value="No" style="width: 0;"/>
		<label for="cpTakenNo">No, I'd pass on the benefits but I'll consider it maybe later.</label>
	</p>

</div>
                  
<script>
	$(document).ready(function() {
	    $('#yesCancel').on('click', function() {
	        $('#cpTakenYes').prop('checked', true).change();
	    });
	    $('#noCancel').on('click', function() {
	        $('#cpTakenNo').prop('checked', true).change();
	    });
	    $('input[name="cancellationProtectTaken"]').on('change', function() {
	        if ($('#cpTakenYes').is(':checked')) {
	            $('#yesCancel').addClass('dvt6');
	            $('#noCancel').removeClass('dvt6');
	        } else {
	            $('#noCancel').addClass('dvt6');
	            $('#yesCancel').removeClass('dvt6');
	        }
	    });
	});
</script>