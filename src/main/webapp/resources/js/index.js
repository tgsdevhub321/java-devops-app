$(document).ready(function(){
	
	let rotationDegree = 0;
	var numberOfMonthValue;
	$(window).resize(function () {
	    if ($(window).width() < 768) {
	        numberOfMonthValue = 1;
	    } else {
	        numberOfMonthValue = 2;
	    }
	    $("#departDate").datepicker("option", "numberOfMonths", numberOfMonthValue);
        $("#returnDate").datepicker("option", "numberOfMonths", numberOfMonthValue);
        
	}).trigger('resize');
	
	var currentDate = new Date();
	
	$("#departDate").val(currentDate);
	$("#departDate").val($.datepicker.formatDate( "mm/dd/yy", currentDate));
	currentDate.setDate(currentDate.getDate()+7)
	
	$("#returnDate").val(currentDate);
	$("#returnDate").val($.datepicker.formatDate( "mm/dd/yy", currentDate));
	
	$("input[name='triptype']").click(function(){
		   var triptype = $(this).val();
		   $("#tripType").val(triptype);
		   
		   //console.log("triptype ===> "+triptype);
		   
		   if(triptype == '1'){
			  // $("#returnDate").prop("disabled", true);
			   $("#returnDiv").hide();
			   $("#departDiv").removeClass("col-50");
		   }
		   else if(triptype == '2'){
			   
			   $('#returnDate').val($("#returnDate").val());
			   //$("#returnDate").prop("disabled", false);
			   $("#returnDiv").show();
			   $("#departDiv").addClass("col-50");
			   $("#returnDate").datepicker("change", {
				   minDate : $('#departDate').datepicker("getDate")
			   });
		   }
	})
	   
	var getData = function (request, response) {
			/*$("#depLoader").show();*/
		
     		$.getJSON("/getAirprotList/" + request.term,function (data) {response(data);});
     		$('#opnDep').hide();
     		$("#opnRtn").hide();
     		
     		$('.side-con').removeClass('active-list');
     		$('.side-con').removeClass('active-list1');
     		
    	};
    
    	var selectItem = function (event, ui) {
    	
    	var locationString = ui.item.value;
    	var parts = locationString.split(",");
        var locationPart = parts[0].trim().split("-");
        var airportCode = locationPart[0].trim(); // "JFK"
        var cityName = locationPart[1].trim(); // "New York"
        var nameAndCountry = parts[1].trim();
        
        if (this.id === "origin") {
        	
        	$("#closeDep").show();
        	
            $("#fAirportCode").text(airportCode);
            $("#fCityName").text(cityName);
            $("#fNamewithContry").text(nameAndCountry);
            
            console.log("Airport Code: " + airportCode);
            console.log("City Name: " + cityName);
            console.log("Name with Country: " + nameAndCountry);
            
            $('.sdgsg').stop(true, true).css('z-index', '10').show().animate({
                top: '0'
            }, 500);
            
        } else if (this.id === "destination") {
        	
        	$("#closeRtn").show();
        	
            $("#tAirportCode").text(airportCode);
            $("#tCityName").text(cityName);
            $("#tNamewithContry").text(nameAndCountry);
            
            console.log("t Airport Code: " + airportCode);
            console.log("t City Name: " + cityName);
            console.log("t Name with Country: " + nameAndCountry);
            
            $('.sdgsg1').stop(true, true).css('z-index', '10').show().animate({
                top: '0'
            }, 500);
        }
        
        /*$("#depLoader").hide();*/
        
    	$(this).val(ui.item.value);
        if(this.id == "origin"){
			setTimeout(function() {
               $("#destination").focus();
            }, 100);
        }
    }
    
	$("#origin").autocomplete({
		source: getData,
        select: selectItem,
        minLength: 3,
		autoFocus: true
    });
	
	$("#destination").autocomplete({
		source: getData,
        select: selectItem,
        minLength: 3,
		autoFocus: true
    });
	
	$("#closeDep").click(function(){
		$("#origin").val("");
		$("#closeDep").hide();
		$("#origin").focus();
	});
	$("#closeRtn").click(function(){
		$("#destination").val("");
		$("#closeRtn").hide();
		$("#destination").focus();
	});
	
	$("#swap_arow").click(function(){
		rotationDegree += 180;
		$('#exchangeImage').css('transform', 'rotate(' + rotationDegree + 'deg)');
        
		var fromCity = $("#origin").val();
		var toCity = $("#destination").val();
		$("#origin").val(toCity);
		$("#destination").val(fromCity);
		
		const fAirportCode = $('#fAirportCode').text();
        const fCityName = $('#fCityName').text();
        const fNamewithCountry = $('#fNamewithContry').text();
        const tAirportCode = $('#tAirportCode').text();
        const tCityName = $('#tCityName').text();
        const tNamewithCountry = $('#tNamewithContry').text();

        $('#fAirportCode').text(tAirportCode);
        $('#fCityName').text(tCityName);
        $('#fNamewithContry').text(tNamewithCountry);

        $('#tAirportCode').text(fAirportCode);
        $('#tCityName').text(fCityName);
        $('#tNamewithContry').text(fNamewithCountry);
        
	});
	
	$("#departDate").datepicker({
	    minDate: new Date(),
	    maxDate: "+11M",
	    numberOfMonths: numberOfMonthValue,
	   
	    onSelect: function(date, event) {
	    	
	    	console.log("departDate - "+date);
	    	
	    	$("#hdToDate").val(date);
	    	
	        $("#departDate").val($.datepicker.formatDate("mm/dd/yy", new Date(date)));
	        $("#depDayNum").text($.datepicker.formatDate("dd", new Date(date)));
	        $("#depDayMonth").text($.datepicker.formatDate("MM", new Date(date)));
	        $("#depDayYear").text($.datepicker.formatDate("DD, yy", new Date(date)));
	        
	        
	        $("#returnDate").val();
	        $("#rtnDayNum").text("?");
	        $("#rtnDayMonth").text("Book Round Trip");
	        $("#rtnDayYear").text("to save extra");
	    },
	    onClose: function(date) {
			var checkedValue = $('input[name="triptype"]:checked').val();
	        console.log('Selected trip type:', checkedValue);
		 
	        if(checkedValue == 2)
        	{
	        	$('#returnDate').datepicker("option","minDate", new Date(date));
				$('#returnDate').datepicker('show');
        	}
	        else
        	{
	        	$('#returnDate').datepicker('hide');
        	}
	    },
	    beforeShowDay: function(date) {
	        var startDate = $('#departDate').datepicker("getDate");
	        var endDate = $('#returnDate').datepicker("getDate");
	        
	        var className = '';
	        if (startDate && (date.getTime() === startDate.getTime())) {
	            className = "start-date"; // Highlight start date
	        } else if (endDate && (date.getTime() === endDate.getTime())) {
	            className = "end-date"; // Highlight end date
	        } else if (startDate && endDate && (startDate < date && date < endDate)) {
	            className = "between-date"; // Highlight dates between start and end
	        }
	        return [true, className]; // Enable the date and apply the class
	    }
	});

	$("#returnDate").datepicker({
	    minDate: new Date(),
	    maxDate: "+11M",
	    numberOfMonths: numberOfMonthValue,
	    onSelect: function(date, event) {
	    	
	    	console.log("returnDate - "+date);
	    	
	    	$("#rtnValidToDate").hide();
	    	
	         $("#tripType").val(2);
	    	
	    	$("#hd_returnDate").val();
	    	
	        $("#returnDate").val($.datepicker.formatDate("mm/dd/yy", new Date(date)));
	        $("#rtnDayNum").text($.datepicker.formatDate("dd", new Date(date)));
	        $("#rtnDayMonth").text($.datepicker.formatDate("MM", new Date(date)));
	        $("#rtnDayYear").text($.datepicker.formatDate("DD, yy", new Date(date)));
	    },
	    beforeShowDay: function(date) {
	        var startDate = $('#departDate').datepicker("getDate");
	        var endDate = $('#returnDate').datepicker("getDate");
	        var className = '';

	        if (startDate) {
	            if (date.getTime() === startDate.getTime()) {
	                className = "start-date"; // Highlight the start date
	            } else if (endDate && date.getTime() === endDate.getTime()) {
	                className = "end-date"; // Highlight the end date
	            } else if (endDate && (startDate < date && date < endDate)) {
	                className = "between-date"; // Highlight dates between start and end
	            }
	        }
	        return [true, className]; // Enable the date and apply the class
	    }
	})
	
	 $('#returnDate').click(function() {
         console.log("rtn data");
         $("div#ru84").removeClass("wstdxt");
         
         $('#tab1').prop('checked', true);
         
         $("#tripType").val(2);
         
         	/*var date = new Date();
		    date.setDate(date.getDate() + 7);
		    $("#rtnDayNum").text($.datepicker.formatDate("dd", date));
		    $("#rtnDayMonth").text($.datepicker.formatDate("MM", date));
		    $("#rtnDayYear").text($.datepicker.formatDate("DD, yy", date));*/
         
         	$("#returnDate").val();
	        $("#rtnDayNum").text("?");
	        $("#rtnDayMonth").text("Book Round Trip");
	        $("#rtnDayYear").text("to save extra");
     });
     
	
	$("#orgClick").click(function(){
		console.log("dep click");
		$("#opnDep").show();
		
		/*var locationString = $("#origin").val();
    	var parts = locationString.split(",");
        var locationPart = parts[0].trim().split("-");
        var airportCode = locationPart[0].trim(); // "JFK"
        var cityName = locationPart[1].trim(); // "New York"
        var nameAndCountry = parts[1].trim();
        
        $("#fAirportCode1").text(airportCode);
        $("#fCityName1").text(cityName);
        $("#fNamewithContry1").text(nameAndCountry);
        
        console.log("cAirport Code: " + airportCode);
        console.log("cCity Name: " + cityName);
        console.log("cName with Country: " + nameAndCountry);*/
		
	});	
	
	$("#destClick").click(function(){
		$("#opnRtn").show();
	});	
	
	
	$("input[name='classtype']").click(function(){
		  var classtype = $(this).val();
		  
		  console.log('Selected class type:', classtype);
		  
		  $("#cabin").val(classtype);
		  calculateTravller();
	})
	
	function calculateTravller(){
		   
			var tttt=$("#txtTraveler").val();
			console.log("txtTraveler = "+tttt);
		
		   var adult = $("#adult").val();
		   
		   var child = $("#child").val();
		   var infant = $("#infant").val();
		   var infantWs = $("#infantWs").val();
		   var totalCount = Number(adult)+Number(child)+Number(infant)+Number(infantWs);
		   
		   console.log('Selected totalCount:', totalCount);
		   
		   var classtype =  $("#cabin").val();
		   
		   console.log("cabin = "+classtype);
		   
		   $("input[name=classtype][value="+classtype+"]").prop('checked', true);
		   if(classtype == 'PremiumEconomy'){
			classtype = "Premium Economy";
			}	
		   if(totalCount == 1){
		   $(".traveller").html(totalCount);
		   $(".travellers").html(" Adult");
		   }
		   else{
		   $(".traveller").html(totalCount);
		   $(".travellers").html(" Traveler(s) ");
		   }
		   $(".cabins").html(classtype);
	  }
	
	$(".addicons.minus").click(function(){
		  var pax = $(this).data("value");
		   var adult = $("#adult").val();
		   var child = $("#child").val();
		   var infant = $("#infant").val();
		   var infantWs = $("#infantWs").val();
		   var totalCount = Number(adult)+Number(child)+Number(infant)+Number(infantWs);
		   
			   if(pax == 'adult'){
				   adult = Number(adult)-1;
				   if(adult > 0)
				   $("#adult").val(adult);
				   if(infant > adult && adult > 0)
					 $("#infant").val(adult); 
					if(infantWs > adult && adult > 0)
					 $("#infantWs").val(adult);
			   }
			   else if(pax == 'child'){
				   child = Number(child)-1;
				   if(child >= 0)
				   $("#child").val(child);
			   }
			   else if(pax == 'infant'){
				   infant = Number(infant)-1;
				   if(infant >= 0)
				   $("#infant").val(infant);
			   }
			   else if(pax == 'infantWs'){
				   infantWs = Number(infantWs)-1;
				   if(infantWs >= 0)
				   $("#infantWs").val(infantWs);
			   }
		   $("#error").hide();
		   calculateTravller();
	  })
	  
	  $(".addicons.plus").click(function(){
		   var pax = $(this).data("value");
		   var adult = $("#adult").val();
		   var child = $("#child").val();
		   var infant = $("#infant").val();
		   var infantWs = $("#infantWs").val();
		   var totalCount = Number(adult)+Number(child)+Number(infant)+Number(infantWs);
		   if( totalCount < 9){
			   if(pax == 'adult'){
				   adult = Number(adult)+1;
				   $("#adult").val(adult);
			   }
			   else if(pax == 'child'){
				   child = Number(child)+1;
				   $("#child").val(child);
			   }
			   else if(pax == 'infant'){
				   infant = Number(infant)+1;
				   if(infant <= adult)
				   $("#infant").val(infant);
			       else
				   $("#error").text("Infant lap can't be greater than adult").show();		
			   }
			   else if(pax == 'infantWs'){
				   infantWs = Number(infantWs)+1;
				   if(infantWs <= adult)
				   $("#infantWs").val(infantWs);
				   else
				   $("#error").text("Infant on seat can't be greater than adult").show();	
			   }
		   }
		   else{
			   $("#error").text("Total traveler can't be greater than 9").show();	
		   }
		   calculateTravller();
	 })
	 
	 
	 /* end ========================================================================================================*/
	 
	 $(".done_button,.searchwindowclose").click(function(){
			$(".traveller_block").hide();
			$(".search_overlay").hide();
			$(".traveller_click").removeClass("activefield");
			calculateTravller();
	});
	
	$(".traveller_click").click(function(){
		$(".traveller_block").show();
		$(".search_overlay").show();
		$(this).addClass("activefield");
		$("#ui-datepicker-div").hide();
	});
	
	var formData = $("#flightSearch").serialize();
	function randomString() {
			for (var t = "", e = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789", n = 0; n < 15; n++) t += e.charAt(Math.floor(Math.random() * e.length));
			return t
	}
	
	var randomStr = randomString();
	$.validator.messages.required = '';
	
	$("#flightSearch").validate({
		 rules:{
			 origin : {
				 required : true
			 },
			 destination : {
				 required : true
			 },
			 departDate: {
			  required: true,
			 },
			 returnDate: {
			  required: true,
			 }
		 },
		 errorPlacement: function(error, element) {   },
		 submitHandler: function(form) {
			   
			 if($("#origin").val() == $("#destination").val()){
				 /*alert("From airport & To airport must be different.");*/
				 $("#desValidation").show();
				 $("#desValidation").html("Source and Destination can not be same");
				 return false;
			 }
			
			 	var checkedValue = $('input[name="triptype"]:checked').val();
		        console.log('Selected trip type:', checkedValue);
			 
		        if(checkedValue == 2)
	        	{
		        	console.log("#returnDate = "+$("#returnDate").val());
		        	var checkedValue = $("#rtnDayNum").text();
		        	
		        	console.log("#returnDate = "+$("#rtnDayNum").text());
		        	
		        	if(checkedValue == "?")
	        		{
		        		$("#desValidation").hide();
		        			console.log("#no");
		        			$("#rtnValidToDate").show();
		        			$("#rtnValidToDate").html("Return date can not be blank");
						 
						 return false;
	        		}
		        	else
	        		{
		        		console.log("#yes");
		        		$("#rtnValidToDate").hide();
	        		}	
	        	}
			 
			 if(formData == $("#flightSearch").serialize()){
				 $(".sameSearch").show();
			 }
			else{
				form.action='/flight-listing/'+randomStr;
				form.submit();
			 }
		  }
	 })
	 
	 $("#flightSearch").on('submit',function(event){
		$("#flightSearch").validate();
	 })
});


function ValidateEmail(mail) 
{
	if (/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/.test(mail))
	{
		return true;
	}
    return false;
}

function newsalertsubmit(){
	var newsEmail = $("#subscribeEmail").val();
	
	if(newsEmail == '') {
		$("#subscribeError").text("Please enter email").css('color', 'red').show();
		$("#subscribeError").delay(5000).fadeOut('slow');
		return false;
	}
	
	var test = ValidateEmail(newsEmail);
	if(test){
		var data = {emailId: newsEmail}
		$.ajax({
			url: '/newsletter/submit',
			type: 'post',
			contentType: 'application/json; charset=utf-8',
			data: JSON.stringify(data),
			dataType: "text",
			success: function(response) {
				var newsRes = JSON.parse(response);
				if(newsRes.baseResponse.status == 1)
				$("#subscribeError").text("You Have Registered Susccessfully!").css("color", "green");
				else
				$("#subscribeError").text("Some Technical Issue Please try later!").css("color", "red");	
			}
		});
	}
	else{
		$("#subscribeError").text("Please Enter Valid Email").css("color","red");
	}
	$("#subscribeError").delay(10000).fadeOut('slow');
}

function engineshow()
{
    document.getElementsByClassName('fehead')[0].style.display="none";
    document.getElementsByClassName('flight-engine')[0].style.display="block";
    document.getElementById('screenoverlay2').style.display="block";
}

function enginehide()
{
    document.getElementsByClassName('fehead')[0].style.display="flex";
    document.getElementsByClassName('flight-engine')[0].style.display="none";
    document.getElementById('screenoverlay2').style.display="none";
}
function filterhide()
{
    var filter=document.getElementsByClassName('filter')[0];
    var fabtn=document.getElementsByClassName('fapply')[0];
    filter.style.height='0';
    fabtn.style.height='0';
}
function filtershow()
{	
	$("#leftu").show();
	$('body').css({
        'overflow': 'hidden',
        'height': '100%'
    });
}
function filterhide()
{	
	$("#leftu").hide();
	$('body').css({
        'overflow': '',
        'height': ''
    });
}
function engineshow()
{	
	$("#tabFlight").show();
	
	$(".jyrd").hide();
	
	$('.fehead').attr('style', 'display: none !important');
	$('#jekhri').attr('style', 'display: block !important');
	
	$("#jekhri").show();
	$('body').css({
        'overflow': 'hidden',
        'height': '100%'
    });
	
}
function enginehide()
{	
	$("#tabFlight").hide();
	
	$('.fehead').attr('style', 'display: flex !important');
	$('#jekhri').attr('style', 'display: none !important');
	
	$("#jekhri").hide();
	$('body').css({
        'overflow': '',
        'height': ''
    });
}

function engineshowDsk()
{	
	$("#tabFlight").show();
	
	$(".jyrd").hide();
	
	$('.fehead').attr('style', 'display: none !important');
	$('#jekhri').attr('style', 'display: block !important');
	
	$("#jekhri").show();
	$('body').css({
        'overflow': '',
        'height': ''
    });
}
function ftype(t,n)
{
    var container=document.getElementsByClassName('filter-item');
    var type=document.getElementsByClassName('ftype');
    for(i=0;i<container.length;i++)
    {
        container[i].style.visibility='hidden';
    }
    for(j=0;j<type.length;j++)
    {
        type[j].setAttribute('class','ftype');
    }
    t.style.visibility='visible';
    type[parseInt(n)].setAttribute('class','ftype filtertypeactive')
}


function ShowAirlinesSearchMobile(button,fromCityName, toCityName, fromDate, toDate) {
	
	/*alert("From City "+fromCityName+", To City"+toCityName+", fromDate "+fromDate +", toDate "+toDate);*/
	$("#origin").val(fromCityName);
	$("#destination").val(toCityName);
	$("#departDate").val(fromDate);
	$("#returnDate").val(toDate);
	$("#adult").val(1);
	$("#child").val(0);
	$("#infant").val(0);
	$("#infantWs").val(0);
	$("#classtype").val("Economy");
	$("#flightSearch").submit();
}
function SearchOnDeals(fCity, tCity, fDate, tDate) {
	
	alert("fCity - "+fCity+", tCity - "+ tCity+", fDate - "+fDate +", tDate - "+tDate);
	
	$("#origin").val(fCity);
	$("#destination").val(tCity);
	$("#departDate").val(fDate);
	$("#returnDate").val(tDate);
	$("#adult").val(1);
	$("#child").val(0);
	$("#infant").val(0);
	$("#infantWs").val(0);
	$("#classtype").val("Economy");
	$("#flightSearch").submit();
}