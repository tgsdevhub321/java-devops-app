<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
#exchangeImage {
    transition: transform 0.5s ease; /* Smooth transition */
}
.ui-datepicker .start-date .ui-state-default {
  background: #005dba;
}
.ui-datepicker td.end-date a,
.ui-datepicker td.start-date a {
  background: #005dba;
  color: #fff;
}
.ui-datepicker .between-date {
  background: #d9e7ff;
  color: #333;
}
.ui-datepicker .between-date .ui-state-default a {
  color: #333;
}
</style>
<form:form modelAttribute="flightSearch" action="flight" method="POST">

<form:hidden path="tripType" />
<form:hidden path="pageAirline" />
<form:hidden path="cabin" id="cabin" value="Economy" />
<form:hidden path="utmSource" id="utmSource" value="online" />

<input id="tripType" name="triptype" value="2" type="hidden" />
<input id="hdFromDate" name="hdFromDate" value="" type="hidden" />
<input id="hdToDate" name="hdToDate" value="" type="hidden" />

<!-- <input id="tripType" name="triptype" value="2" type="hidden" /> -->
                   
                    <div class="bg-white rounded tgfuftg fjut4">
                        <img class="hru852 fggrsg" src="/resources/images/cross.png" alt="" onclick="enginehide()">
                        <div class="tab-buttons px-lg-4 pt-lg-4 pt-2 px-2">
                            <button class="tab-btn active" content-id="home">
                                <i class="fa fa-plane" aria-hidden="true"></i>  Flights
                            </button>
                           
                          </div>
                          <hr class="jyrd">
                          <div class=" hfrgr">
                            <div class=" text-black pb-2 d-flex align-items-center">
                                <!-- <input type="radio" id="tab1" name="tab" value="2" checked > -->
                                <input class="me-1" checked="checked" id="tab1" name="triptype" type="radio" value="2">
                                <label class="me-2" for="tab1">Round Trip</label>
                                <!-- <input class="ms-2" type="radio" id="tab2" value="1" name="tab"> -->
                                <input class="me-1" id="tab2" name="triptype" type="radio" value="1">
                                <label for="tab2">One Way</label>
                            </div>
                                 
                                    <div class="gitrs align-items-start gap-2 bposg">
                                        <div class="d-flex gap-2 align-items-start bposg">
                                           <div class="rela">
                                           	
                                            	<div id="orgClick" class="ewrtf wtte">
	                                                <div class="dikhrg">
	                                                	<form:input id="origin" path="origin" class="form-control ewrtf1" value="" placeholder="Flying From" oninput="validateCharOnly(this)" />
	                                                 	<!-- <div id="depLoader" class="spinner center" style="display: none;">
			                                                  <div class="spinner-blade"></div>
			                                                  <div class="spinner-blade"></div>
			                                                  <div class="spinner-blade"></div>
			                                                  <div class="spinner-blade"></div>
			                                                  <div class="spinner-blade"></div>
			                                                  <div class="spinner-blade"></div>
			                                                  <div class="spinner-blade"></div>
			                                                  <div class="spinner-blade"></div>
			                                                  <div class="spinner-blade"></div>
			                                                  <div class="spinner-blade"></div>
			                                                  <div class="spinner-blade"></div>
			                                                  <div class="spinner-blade"></div>
			                                              </div> -->
			                                              <img id="closeDep" class="hgers3" src="/resources/images/cross.png" alt="">
	                                                </div>
	                                                <div class="side-con  sdgsg p-2" style="display: none !important">
		                                                 <div class="row align-items-center w-100">
		                                                     <div class="col-3 col-lg-3 ">
		                                                         <p id="fAirportCode" class="szet1 mb-0 text-center">CHC</p>
		                                                     </div>
		                                                     <div class="col-9 col-lg-9 pe-0 border-start">
		                                                         <p id="fCityName" class="szet2 mb-0">Christchurch Airport</p>
		                                                         <p id="fNamewithContry" class="szet3 mb-0">Christchurch -NZ</p>
		                                                     </div>
		                                                 </div>
	                                                </div>
                                               </div>
                                               
                                               
                                               <div id="opnDep" class="setry635">
                                                                                              
                                                    <div id="depList1" onclick="depList1('JFK-New York, John F Kennedy -US');" class="side-con  rela edtfsf34  mb-2 p-2">
                                                        <div class="row align-items-center w-100">
                                                            <div class="col-3 col-lg-3 ">
                                                                <p id="fAirportCode1" class="szet1 mb-0 text-center">JFK</p>
                                                            </div>
                                                            <div class="col-9 col-lg-9 pe-0 border-start">
                                                                <p id="fCityName1" class="szet2 mb-0">New York</p>
                                                                <p id="fNamewithContry1" class="szet3 mb-0">John F Kennedy -US</p>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div id="depList2" onclick="depList2('MIA-Miami, Miami -US');" class="side-con  rela edtfsf34  mb-2 p-2">
                                                        <div class="row align-items-center w-100">
                                                            <div class="col-3 col-lg-3 ">
                                                                <p class="szet1 mb-0 text-center">MIA</p>
                                                            </div>
                                                            <div class="col-9 col-lg-9 pe-0 border-start">
                                                                <p class="szet2 mb-0">Miami</p>
                                                                <p class="szet3 mb-0">Miami -US</p>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div id="depList3" onclick="depList3('LAX-Los Angeles, Los Angeles -US');" class="side-con  rela edtfsf34  mb-2 p-2">
                                                        <div class="row align-items-center w-100">
                                                            <div class="col-3 col-lg-3 ">
                                                                <p class="szet1 mb-0 text-center">LAX</p>
                                                            </div>
                                                            <div class="col-9 col-lg-9 pe-0 border-start">
                                                                <p class="szet2 mb-0">Los Angeles</p>
                                                                <p class="szet3 mb-0">Los Angeles -US</p>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div id="depList4" onclick="depList4('LAS-Las Vegas, McCarran -US');" class="side-con  rela edtfsf34  mb-2 p-2">
                                                        <div class="row align-items-center w-100">
                                                            <div class="col-3 col-lg-3 ">
                                                                <p class="szet1 mb-0 text-center">LAS</p>
                                                            </div>
                                                            <div class="col-9 col-lg-9 pe-0 border-start">
                                                                <p class="szet2 mb-0">Las Vegas</p>
                                                                <p class="szet3 mb-0">McCarran -US</p>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div id="depList5" onclick="depList5('SFO-San Francisco, San Francisco -US');" class="side-con  rela edtfsf34  mb-2 p-2">
                                                        <div class="row align-items-center w-100">
                                                            <div class="col-3 col-lg-3 ">
                                                                <p class="szet1 mb-0 text-center">SFO</p>
                                                            </div>
                                                            <div class="col-9 col-lg-9 pe-0 border-start">
                                                                <p class="szet2 mb-0">San Francisco</p>
                                                                <p class="szet3 mb-0">San Francisco -US</p>
                                                            </div>
                                                        </div>
                                                    </div>
                                               </div>
                                           </div>
                                           <div class="sted34" id="swap_arow">
                                            <img id="exchangeImage" src="/resources/images/exchng.png" alt="">
                                           </div>
                                           <div class="rela">
                                            <div id="destClick" class="ewrtf wtte1">
                                            <div class="dikhrg">
                                                <form:input path="destination" class="form-control ewrtf1" value="" placeholder="Flying To" oninput="validateCharOnly(this)" />
                                             	<img id="closeRtn" class="hgers3" src="/resources/images/cross.png" alt="">
                                             	
                                             </div>
                                             	
                                             	
                                                <div class="side-con sdgsg1 p-2" style="display: none !important">
                                                        <div class="row align-items-center w-100">
                                                            <div class="col-3 col-lg-3">
                                                                <p id="tAirportCode" class="szet1 mb-0 text-center">CHC</p>
                                                            </div>
                                                            <div class="col-9 col-lg-9 pe-0 border-start">
                                                            
                                                                <p id="tCityName" class="szet2 mb-0">Christchurch Airport</p>
                                                                <p id="tNamewithContry" class="szet3 mb-0">Christchurch -NZ</p>
                                                            </div>
                                                        </div>
                                                </div>
                                               </div>
                                               
                                               <div id="opnRtn" class="setry635">
                                                	<div id="rtnList1" onclick="rtnList1('JFK-New York, John F Kennedy -US');" class="side-con rela edtfsf34 mb-2 p-2">
                                                        <div class="row align-items-center w-100">
                                                            <div class="col-3 col-lg-3 ">
                                                                <p id="fAirportCode1" class="szet1 mb-0 text-center">JFK</p>
                                                            </div>
                                                            <div class="col-9 col-lg-9 pe-0 border-start">
                                                                <p id="fCityName1" class="szet2 mb-0">New York</p>
                                                                <p id="fNamewithContry1" class="szet3 mb-0">John F Kennedy -US</p>
                                                            </div>
                                                        </div>
                                                    </div>
                                                     <div id="rtnList2" onclick="rtnList2('MIA-Miami, Miami -US');" class="side-con  rela edtfsf34  mb-2 p-2">
                                                        <div class="row align-items-center w-100">
                                                            <div class="col-3 col-lg-3 ">
                                                                <p class="szet1 mb-0 text-center">MIA</p>
                                                            </div>
                                                            <div class="col-9 col-lg-9 pe-0 border-start">
                                                                <p class="szet2 mb-0">Miami</p>
                                                                <p class="szet3 mb-0">Miami -US</p>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div id="rtnList3" onclick="rtnList3('LAX-Los Angeles, Los Angeles -US');" class="side-con  rela edtfsf34  mb-2 p-2">
                                                        <div class="row align-items-center w-100">
                                                            <div class="col-3 col-lg-3 ">
                                                                <p class="szet1 mb-0 text-center">LAX</p>
                                                            </div>
                                                            <div class="col-9 col-lg-9 pe-0 border-start">
                                                                <p class="szet2 mb-0">Los Angeles</p>
                                                                <p class="szet3 mb-0">Los Angeles -US</p>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div id="rtnList4" onclick="rtnList4('LAS-Las Vegas, McCarran -US');" class="side-con  rela edtfsf34  mb-2 p-2">
                                                        <div class="row align-items-center w-100">
                                                            <div class="col-3 col-lg-3 ">
                                                                <p class="szet1 mb-0 text-center">LAS</p>
                                                            </div>
                                                            <div class="col-9 col-lg-9 pe-0 border-start">
                                                                <p class="szet2 mb-0">Las Vegas</p>
                                                                <p class="szet3 mb-0">McCarran -US</p>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div id="rtnList5" onclick="rtnList5('SFO-San Francisco, San Francisco -US');" class="side-con  rela edtfsf34  mb-2 p-2">
                                                        <div class="row align-items-center w-100">
                                                            <div class="col-3 col-lg-3 ">
                                                                <p class="szet1 mb-0 text-center">SFO</p>
                                                            </div>
                                                            <div class="col-9 col-lg-9 pe-0 border-start">
                                                                <p class="szet2 mb-0">San Francisco</p>
                                                                <p class="szet3 mb-0">San Francisco -US</p>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    
                                                 </div>
                                                 <div class="refnt6" id="desValidation" style="color: red; font-size: 12px;"></div>
                                                   
                                           </div>
                                           
                                        </div>
                                        
                                    <!-- <div id="two-inputs">
                                          <input id="date-depart" size="20" value=""> 
                                          <input id="date-return" size="20" value="">
                                      </div> -->
                                      
                                       
                                        <div class="rela">
                                            <div id="two-inputs" class="d-flex gap-2 align-items-center jksdt">
                                                <div class="ewrtf erte">
                                                    <form:input path="departDate" class="dgdga" id="departDate" placeholder="Select your date" readonly="true" />
                                                    <%-- <form:hidden path="departDate" id="hd_departDate" value="" /> --%>
                                                    
                                                    <div class="side-con p-lg-2">
                                                        <div class="row align-items-center w-100">
                                                            <div class="col-3 col-lg-3 wsta">
                                                                <p class="szet1 mb-0 text-center" id="depDayNum">18</p>
                                                            </div>
                                                            <div class="col-9 col-lg-9 pe-0 border-start">
                                                                <p class="szet2 mb-0" id="depDayMonth">September</p>
                                                                <p class="szet3 mb-0" id="depDayYear">Wednesday, 2024</p>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                
                                                <div class="ewrtf erte" id="ru84">
                                                    <form:input path="returnDate" placeholder="Select your date" class="dgdga" id="returnDate" readonly="true" />
                                                    <%--<form:hidden path="returnDate" id="hd_returnDate" value="" /> --%>
                                                    <div class="side-con p-lg-2">
                                                        <div class="row align-items-center w-100">
                                                            <div class="col-3 col-lg-3 wsta">
                                                                <p class="szet1 mb-0 text-center" id="rtnDayNum">18</p>
                                                            </div>
                                                            <div class="col-9 col-lg-9 pe-0 border-start">
                                                                <p class="szet2 mb-0" id="rtnDayMonth">September</p>
                                                                <p class="szet3 mb-0" id="rtnDayYear">Wednesday, 2024</p>
                                                            </div>
                                                            
                                                        </div>
                                                        
                                                    </div>
                                                    
                                                </div>
                                                <div class="ewrtf " id="dirf45">

                                                    <div class="side-con p-lg-2" >
                                                        <div class="row align-items-center w-100">
                                                            <div class="col-3 col-lg-3 wsta">
                                                                <p class="szet1 mb-0 text-center traveller">01</p>
                                                            </div>
                                                            <div class="col-9 col-lg-9 pe-0 border-start">
                                                                <p class="szet2 mb-0 travellers">Adult</p>
                                                                <p class="szet3 mb-0 cabins">Economy</p>
                                                            </div>
                                                            
                                                        </div>
                                                    </div>

                                                    <p class="arwsfw mb-0 mob-hide txtTraveler" id="dirf45">
                                                        <!-- <input type="text" value="1 Traveler Economy" name="coach" class="coach" class="field-input traveller cursor" readonly> -->
                                                        <input type="text" value="1 Traveler Economy" class="field-input traveller cursor txtTraveler" readonly>
                                                            <i class="fa fa-angle-down edsge mob-hide txtTraveler" aria-hidden="true"></i>
                                                    </p>
                                                   
                                                </div>
                                                 
                                                <div class="sdgyi mob-hide" id="w4rws2">
                                                    <div class="row">
                                                        <div class="col-lg-7 deydsy">
                                                            <h3 class="iwehf7">Traveler</h3>
                                                            
    
                                                            <div class="dfyhj">
                                                                <div class="row align-items-center">
                                                                    <div class="col-6 col-lg-6">
                                                                        <p class="mb-0 astatr34">Adults</p>
                                                                        <p class="mb-0 dsyyrt7">12 years & above</p>
                                                                    </div>
                                                                    <div class="col-6 col-lg-6 p-0">
                                                                        <div class="d-flex justify-content-center">
                                                                            <p class="astsa addicons minus" data-value="adult">-</p>
                                                                            <p class="dfgryh">
                                                                            <form:input path="adult" readonly="true" class="number" value="1" style="width: 10px;font-weight: 600;border: 0;" /></p>
                                                                            <p class="astsa addicons plus" data-value="adult">+</p>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="dfyhj">
                                                                <div class="row align-items-center">
                                                                    <div class="col-6 col-lg-6">
                                                                        <p class="mb-0 astatr34">Children</p>
                                                                        <p class="mb-0 dsyyrt7">2 to 11 years</p>
                                                                    </div>
                                                                    <div class="col-6 col-lg-6 p-0">
                                                                        <div class="d-flex justify-content-center">
                                                                            <p class="astsa addicons minus" data-value="child">-</p>
                                                                            <p class="dfgryh"><form:input path="child" readonly="true" class="number" value="0" style="width: 10px;font-weight: 600;border: 0;" /></p>
                                                                            <p class="astsa addicons plus" data-value="child">+</p>
                                                                        </div>
                                                                        
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="dfyhj">
                                                                <div class="row align-items-center">
                                                                    <div class="col-6 col-lg-6">
                                                                        <p class="mb-0 astatr34">Infant(s) (Lap)</p>
                                                                        <p class="mb-0 dsyyrt7">Under 2 years</p>
                                                                    </div>
                                                                    <div class="col-6 col-lg-6 p-0">
                                                                        <div class="d-flex justify-content-center">
                                                                            <p class="astsa addicons minus" data-value="infant">-</p>
                                                                            <p class="dfgryh"><form:input path="infant" class="number" readonly="true" value="0" style="width: 10px;font-weight: 600;border: 0;" /></p>
                                                                            <p class="astsa addicons plus" data-value="infant">+</p>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="dfyhj">
                                                                <div class="row align-items-center">
                                                                    <div class="col-6 col-lg-6">
                                                                        <p class="mb-0 astatr34">Infant(s) (Seat)</p>
                                                                        <p class="mb-0 dsyyrt7">Under 2 years</p>
                                                                    </div>
                                                                    <div class="col-6 col-lg-6 p-0">
                                                                        <div class="d-flex justify-content-center">
                                                                            <p class="astsa addicons minus" data-value="infantWs">-</p>
                                                                            <p class="dfgryh"><form:input path="infantWs" class="number" readonly="true" value="0" style="width: 10px;font-weight: 600;border: 0;" /></p>
                                                                            <p class="astsa addicons plus" data-value="infantWs">+</p>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="col-lg-5">
                                                            <h3 class="iwehf7">Cabin</h3>
                                                            <div class="form-check">
                                                            <label class="form-check-label travllr-cab">
                                                            <input type="radio" name="classtype" checked="" value="Economy">
                                                                Economy</label>
                                                              </div>
                                                              <div class="form-check"> 
                                                              <label class="form-check-label travllr-cab">
                                                                <input type="radio" name="classtype" value="PremiumEconomy">
                                                                  Premium Economy
                                                                </label>
                                                              </div>
                                                              <div class="form-check">
                                                              <label class="form-check-label travllr-cab">
                                                                <input type="radio" name="classtype" value="Business">
                                                                  Business
                                                                </label>
                                                              </div>
                                                              <div class="form-check">
                                                                <label class="form-check-label travllr-cab">
                                                                <input type="radio" name="classtype" value="First">
                                                                  First
                                                                </label>
                                                              </div>
                                                              
                                                        </div>
                                                    </div>
                                                    <button type="button" class="btn btn-primary d-flex ms-auto" id="segtsg2">Apply</button>
                                                        </div>
                                            </div>
                                            <div class="refnt6" id="rtnValidToDate" style="color: red; font-size: 12px; position: relative; text-align: right;"></div>
                                        </div> 
                                        
                                        
                                        <button type="submit" class="btn btn-primary sdeyady"><span class="desk-hide">Search Flights</span> <i class="fa fa-search mob-hide" aria-hidden="true"></i></button>
                                         <!-- <a href="listing.html">
                                            
                                         </a> -->
                                    </div>
	                          </div>
	                    </div>
	                    
	    		</form:form>
	    		                           
<script>
    $(document).ready(function(){
    	
    	var tType = $("#tripType").val();
	    if (tType == "1") {
	        $("#tripType").val(1);
	    } else {
	        $("#tripType").val(2);
	    }
    
    	
	    window.depList1 = function(value) {
	        setDepActiveList('#depList1', value);
	    };
	    window.depList2 = function(value) {
	        setDepActiveList('#depList2', value);
	    };
	    window.depList3 = function(value) {
	        setDepActiveList('#depList3', value);
	    };
	    window.depList4 = function(value) {
	        setDepActiveList('#depList4', value);
	    };
	    window.depList5 = function(value) {
	        setDepActiveList('#depList5', value);
	    };
	    function setDepActiveList(selectedId, value) {
	    
	    	console.log("origin value - "+value);
	        $('.side-con').removeClass('active-list');
	        $(selectedId).addClass('active-list');
	        $('#origin').val(value);
	        $('#opnDep').hide();
	        
	        var locationString = value;
	    	var parts = locationString.split(",");
	        var locationPart = parts[0].trim().split("-");
	        var airportCode = locationPart[0].trim();
	        var cityName = locationPart[1].trim();
	        var nameAndCountry = parts[1].trim();
	        
	        $("#fAirportCode").text(airportCode);
            $("#fCityName").text(cityName);
            $("#fNamewithContry").text(nameAndCountry);
            $("#closeDep").show();
            
            $('.sdgsg').stop(true, true).css('z-index', '10').show().animate({
                top: '0'
            }, 500);
		}
    
    
    	window.rtnList1 = function(value) {
	        setRtnActiveList('#rtnList1', value);
	    };
	    window.rtnList2 = function(value) {
	        setRtnActiveList('#rtnList2', value);
	    };
	    window.rtnList3 = function(value) {
	        setRtnActiveList('#rtnList3', value);
	    };
	    window.rtnList4 = function(value) {
	        setRtnActiveList('#rtnList4', value);
	    };
	    window.rtnList5 = function(value) {
	        setRtnActiveList('#rtnList5', value);
	    };
	    function setRtnActiveList(selectedId, value) {
	    
	        $('.side-con').removeClass('active-list1');
	        $(selectedId).addClass('active-list1');
	        $('#destination').val(value);
	        $('#opnRtn').hide();
	        
	        var locationString = value;
	    	var parts = locationString.split(",");
	        var locationPart = parts[0].trim().split("-");
	        var airportCode = locationPart[0].trim();
	        var cityName = locationPart[1].trim();
	        var nameAndCountry = parts[1].trim();
	        
	        $("#tAirportCode").text(airportCode);
            $("#tCityName").text(cityName);
            $("#tNamewithContry").text(nameAndCountry);
            $("#closeRtn").show();
            
            $('.sdgsg1').stop(true, true).css('z-index', '10').show().animate({
                top: '0'
            }, 500);
		}
		
	   $(document).click(function(event) {
		    var target = $(event.target);
		    if (!target.closest('#opnDep').length && !target.is('#origin')) {
		        $('#opnDep').hide();
		    }
		    if (!target.closest('#opnRtn').length && !target.is('#destination')) {
		        $('#opnRtn').hide();
		    }
		    if (!target.closest('#w4rws2').length && !target.is('.txtTraveler')) {
		        $('#w4rws2').hide();
		    }
		});
		$("#origin").click(function() {
		    $('#opnRtn, #w4rws2, #ui-datepicker-div').hide();
		});
		
		$("#destination").click(function() {
		    $('#opnDep, #w4rws2, #ui-datepicker-div').hide();
		});
		
		$("#departDate").click(function() {
		    $('#opnDep, #opnRtn, #w4rws2').hide();
		});
		
		$("#returnDate").click(function() {
		    $('#opnDep, #opnRtn, #w4rws2').hide();
		});
		
		$(".txtTraveler").click(function() {
		    $('#opnDep, #opnRtn, #ui-datepicker-div').hide();
		});
	    
    	$("#closeDep").hide();
    	$("#closeRtn").hide();
    
		const today = new Date();
        today.setDate(today.getDate() + 0);

        const day = today.getDate();
		const monthNames = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
		const month = monthNames[today.getMonth()];
		const year = today.getFullYear();
		const dayOfWeek = today.toLocaleString('default', { weekday: 'long' });
		
		$('#depDayNum').text(day);
		$('#depDayMonth').text(month);
		$('#depDayYear').text(dayOfWeek + ', ' + year);
		
		console.log("departDate --->>> "+$("#departDate").val());
		
		const rtnToday = new Date();
		rtnToday.setDate(rtnToday.getDate() + 7);
        	const rtnDay = rtnToday.getDate();
		const rtnMonthNames = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
		const rtnMonth = rtnMonthNames[rtnToday.getMonth()];
		const rtnYear = rtnToday.getFullYear();
		const rtnDayOfWeek = rtnToday.toLocaleString('default', { weekday: 'long' });
		
		$('#rtnDayNum').text(rtnDay);
		$('#rtnDayMonth').text(rtnMonth);
		$('#rtnDayYear').text(rtnDayOfWeek + ', ' + rtnYear);
            
            
	    $("#dirf45").click(function(){
	        $("#w4rws2").show();
	    });
	    $("#segtsg2").click(function(){
	        $("#w4rws2").hide();
	    });
	    $("#tab2").click(function(){
	        $("div#ru84").addClass("wstdxt");
	        console.log("one");
	        $("#rtnValidToDate").hide();
	        $("#tripType").val(1);
	        $("#rtnDayNum").text("?");
	        $("#rtnDayMonth").text("Book Round Trip");
	        $("#rtnDayYear").text("to save extra");
	    });
	    $("#tab1").click(function(){
	     console.log("two");
	     
	     $("#tripType").val(2);
	     
	        $("div#ru84").removeClass("wstdxt");
		    
		    $("#returnDate").val();
	        $("#rtnDayNum").text("?");
	        $("#rtnDayMonth").text("Book Round Trip");
	        $("#rtnDayYear").text("to save extra");
	    });
	});
	
	function validateCharOnly(input) {
        input.value = input.value.replace(/[^a-zA-Z\s]/g, '');
    	}
   </script>

   
  