<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="mycase" uri="/WEB-INF/tld/string-utils.tld" %>
<!DOCTYPE html>
<html ng-app="FlightApp">
	<link rel="shortcut icon" href="/resources/assets/img/favicons/favicon-32x32.png" type="image/x-icon">
<input type="hidden" value="${flightRequest.searchID}" id="searchID">
	<input type="hidden" value="${searchString}" id="searchString">

	<input type="hidden" value="${flightSearch.departDate}" id="fdateObject">
	<input type="hidden" value="${flightSearch.returnDate}" id="tdateObject">
	
	<input type="hidden" value='${flightRequest.cabinType}' id="searchCabinType">
	<input type="hidden" value='${flightRequest.adults}' id="searchAdult">
	<input type="hidden" value='${flightRequest.child}' id="searchChild">
	<input type="hidden" value='${flightRequest.infants}' id="searchInfantLap">
	<input type="hidden" value='${flightRequest.infantsWs}' id="searchInfantSt">
	
	<c:set value="${fn:split(flightSearch.origin,',')[0]}" var="deaprtc1" />
	<c:set value="${fn:split(deaprtc1,'-')[0]}" var="deaprtCode" />

	<c:set value="${fn:split(flightSearch.destination,',')[0]}" var="returnc1" />
	<c:set value="${fn:split(returnc1,'-')[0]}" var="returnCode" />
	
	<c:set value="${flightSearch.departDate}" var="departDateStr" />
	<fmt:parseDate value="${departDateStr}" var="departDate" pattern="MM/dd/yyyy" />
	<fmt:formatDate value="${departDate}" pattern="MMM dd" var="formattedDepartDate" />
	
	<c:set value="${flightSearch.returnDate}" var="returnDateStr" />
	<fmt:parseDate value="${returnDateStr}" var="returnDate" pattern="MM/dd/yyyy" />
	<fmt:formatDate value="${returnDate}" pattern="MMM dd" var="formattedReturnDate" />
<head><c:set var="sentenceCase" value="${mycase:SentenceCase(websiteName)}" scope="session" />
<title>${sentenceCase}- Result Page</title>
<meta name="DESCRIPTION" content="Compare flight prices, airlines, and travel options from ${deaprtCode} to ${returnCode} instantly. Find the best deals and book faster with real-time, personalized flight results.
" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="canonical" href="${canonicalUrl}" />
	
<link rel="stylesheet" type="text/css" href="/resources/css/ani.css?v=1.0">
<script src="/resources/js/jquery-1.11.1.min.js"></script>
<script src="/resources/js/jquery-ui.js"></script>
<script src="/resources/js/jquery.validate.min.js"></script>
<script src="/resources/js/angular.min.js"></script>
<script src="/resources/js/ng-infinite-scroll.min.js"></script>
<link rel="stylesheet" href="/resources/css/jquery-ui.css?v=1710248">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="/resources/css/new/flight-engine-style.css?v=14112024578">
<link rel="stylesheet" href="/resources/css/new/main-style.css?v=14112024">
<link rel="stylesheet" href="/resources/css/new/footer-style.css">
<link rel="stylesheet" href="/resources/css/new/flight-listing.css?v=23122024">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,400;1,500;1,600;1,700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="/resources/css/new/header-style.css?v=12" type="text/css" />
 <link rel="stylesheet" href="/resources/css/home.css">
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
<script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
<style>
.tab-buttons {
	display: none;
}
#divMatrix
{
	height:450px; background: #f9f9f9;
}
.offer-event{
    background: rgba(0,0,0,0) linear-gradient(87deg, #C80028 0%, #C80028 18%, #C80128 43%, #F73347 63%, #C80128 100%) 0% 0% no-repeat padding-box;
    background-size: auto;
    background-size: auto;
    color: white !important; 
    font-size: 13px;
    margin-bottom: 4px;
}

</style>

<script type="text/javascript">
function engineshow()
{
    document.getElementById('enginehide').style.display="none";
    document.getElementById('jekhri').style.display="block";
    document.getElementById('screenoverlay2').style.display="block";
}
function enginehide()
{
    document.getElementById('enginehide').style.display="flex";
    document.getElementById('jekhri').style.display="none";
    document.getElementById('screenoverlay2').style.display="none";
}

	$(document).ready(function(){    
	   $("#jekhri").hide();
	});
</script>

<style>
.even {background-color: #f0f0f0;}
.odd {background-color: #ffffff;}
</style>
<jsp:include page="../../tag-manager-head.jsp" />
</head>
<body ng-controller="FlightCntrl">

	<jsp:include page="../../tag-manager-body.jsp" />
	<jsp:include page="utmHandler.jsp" />
	<!--Header Area Starts Here-->
	
	<jsp:include page="../../common/header_listing.jsp" />

	

	<!--Header Area End Here-->

	<div class="screen-overlay" id="screenoverlay" onclick="hidesidenav();"></div>
	<div id="screenoverlay2" onclick="enginehide();"></div>
	<!--Header Ends Here-->
	<!--Engine Area Starts Here-->
	

	<!--Start Engine Area Ends Result Area starts-->
	<section class="header-spac">
		<div class="container">
			<div class="row w-100 m-auto">
				<div id="jekhri" class="col-lg-12 px-lg-0">
						<jsp:include page="../../engine-new.jsp" />
				</div>
				<div class="fehead" id="enginehide">
                    <div class="dhrf">
						<div class="trip-details">
							<p class="mb-0">${deaprtCode}</p> 
							<img class="tj5i" src="/resources/images/ph-rout.png" alt=""> 
							<p class="mb-0 me-2"><span class="jhger3">-</span> ${returnCode}</p> 
							<p class="mb-0 rf6uj67">| ${formattedDepartDate} <span id="spnRtnDate">- ${formattedReturnDate}</span> |</p>
						</div>
						<span class="etr5h84" id="mobTraveler"></span>
					</div>
                    <a id="aMobile" onclick="engineshow()">Edit</a>
                    <a id="aDesktop" onclick="engineshow()">Edit</a>
                </div>
			</div>
		</div>
	</section>

	<div class="LazyLoaderBox" ng-if="resultLoader == true">
		<span> 
			<img class="L_img" src="/resources/images/icons/flight_loader.gif" alt="Loader Image">
		</span>
		<p class="place_code">
			<span id="loader_From"></span> <span class="">&nbsp;&nbsp; to &nbsp;&nbsp;</span> <span id="loader_To"></span>
		</p>
		<p class="wait_text">Please wait, while we are searching the best fares for you...</p>
	</div>
	
	
    
	<section class="wsrur">
		<div class="container">
			<div class="row justify-content-center">
				<a onclick="filtershow()"><div class="mob-filter text-center wr45swe4" ng-if="resultLoader == true || flightsResponse.flightResult.length > 0">
					<h6 class="mb-0 dsfhy d-flex align-items-center">
						<i class="fa fa-filter"></i> Filters
						<p></p>
					</h6>
				</div></a>

				<!-- start filter ==========================-->
				<div id="leftu" class="col-lg-3 rfy54" ng-if="resultLoader == true || flightsResponse.flightResult.length > 0">
					<div class="bg-white dxgewet sedtgsea mb-lg-0 mb-2">
						<img class="hru85" src="/resources/images/cross.png" alt="" onclick="filterhide()">
						
						<div class="d-flex justify-content-end placeholder-item">
							<p class="uyre6k" ng-click="resetFilters();">Reset</p>
						</div>
						<div class="right-box d-flex align-items-start placeholder-item">
							<img class="icon-lerft" src="/resources/images/filter.png" alt="">
							<div class="right-inner-box">
								<h6 class="mb-2 font-clrf">Filter results</h6>
								<p class="font-re-s gtuj">Found {{filteredFlights.length}} Results.</p>
							</div>
						</div>
					</div><div class="bg-white dxgewet sedtgsea mb-lg-0 mb-2">
						<div class="right-box d-flex align-items-start placeholder-item">
							<img class="icon-lerft" src="/resources/images/stop.png"
								alt="">
							<div class="right-inner-box">
								<h6 class="mb-2 font-clrf">Stop(s)</h6>
								<div class="gtuj1">
									
									<label ng-repeat="stop in stopsList" ng-if="stop.count > 0">
									<div class="d-flex justify-content-between font-re-s align-items-center">
										<div class="d-flex align-items-center">
											<input class="form-check-input dfyhdry me-1 mt-0" type="checkbox" value="" id="flexCheckChecked" ng-model="selectedStops[stop.value]">
											<p class="mb-0 ms-1">{{stop.name}}</p>
										</div>
										<p class="mb-0 ms-1 d-flex align-items-center"> <span class="me-1">${websiteCurrency}</span> <!-- {{stop.fare | currency:'':2}} -->
											{{getAirlineFareBase(stop.fare)}}<sup>.{{getAirlineFareSuper(stop.fare)}}</sup>
										</p>
									</div>
									</label>

								</div>
							</div>
						</div>
					</div><div class="bg-white dxgewet sedtgsea mb-lg-0 mb-2">
						<div class="right-box d-flex align-items-start placeholder-item">
							<img class="icon-lerft" src="/resources/images/depart.png" alt="">
							<div class="right-inner-box">
								<h6 class="mb-2 font-clrf">Departure From</h6>
								<p class="font-re-s gtuj"><!-- New York - USA --> ${fn:split(flightSearch.origin,',')[0]}</p>
								<div class="row gtuj">
									<div class="col-3 col-lg-3 ps-0">
										<div class="ugbj">
											<button class="dertotg" id="dep-ermorning-time">
												<img src="/resources/images/0-6.png" alt="">
											</button>
											<p class="swtsws456">00-06</p>
										</div>
									</div>
									<div class="col-3 col-lg-3 ps-0">
										<div class="ugbj">
											<button class="dertotg" id="dep-morning-time">
												<img src="/resources/images/6-12.png" alt="">
											</button>
											<p class="swtsws456">06-12</p>
										</div>
									</div>
									<div class="col-3 col-lg-3 ps-0">
										<div class="ugbj">
											<button class="dertotg" id="dep-afternoon-time">
												<img src="/resources/images/12-6.png" alt="">
											</button>
											<p class="swtsws456">12-18</p>
										</div>
									</div>
									<div class="col-3 col-lg-3 ps-0">
										<div class="ugbj">
											<button class="dertotg" id="dep-evening-time">
												<img src="/resources/images/6-0.png" alt="">
											</button>
											<p class="swtsws456">18-00</p>
										</div>
									</div>
								</div>
							</div>
						</div>
					
						<div class="right-box d-flex align-items-start placeholder-item" ng-if="tripType == '2'">
							<img class="icon-lerft" src="/resources/images/return.png" alt="">
							<div class="right-inner-box">
								<h6 class="mb-2 font-clrf">Return From</h6>
								<p class="font-re-s gtuj"> ${fn:split(flightSearch.destination,',')[0]}</p>
								<div class="row gtuj">
									<div class="col-3 col-lg-3 ps-0">
										<div class="ugbj">
											<button class="dertotg" id="rtn-ermorning-time">
												<img src="/resources/images/0-6.png" alt="">
											</button>
											<p class="swtsws456">00-06</p>
										</div>
									</div>
									<div class="col-3 col-lg-3 ps-0">
										<div class="ugbj ">
											<button class="dertotg" id="rtn-morning-time">
												<img src="/resources/images/6-12.png" alt="">
											</button>
											<p class="swtsws456">06-12</p>
										</div>
									</div>
									<div class="col-3 col-lg-3 ps-0">
										<div class="ugbj ">
											<button class="dertotg" id="rtn-afternoon-time">
												<img src="/resources/images/12-6.png" alt="">
											</button>
											<p class="swtsws456">12-18</p>
										</div>
									</div>
									<div class="col-3 col-lg-3 ps-0">
										<div class="ugbj ">
											<button class="dertotg" id="rtn-evening-time">
												<img src="/resources/images/6-0.png" alt="">
											</button>
											<p class="swtsws456">18-00</p>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div><div class="bg-white dxgewet sedtgsea mb-lg-0 mb-2">
						<div class="right-box d-flex align-items-start placeholder-item">
							<img class="icon-lerft" src="/resources/images/fares.png"
								alt="">
							<div class="right-inner-box">
								<h6 class="mb-2 font-clrf">Fares</h6>
								<div class="slider">
									<div class="slider-head" id="price-range">${websiteCurrency} 50 -
										${websiteCurrency} 150</div>
									<div class="dual-slider" id="price-slider">
										<input min="50" value="50" step="1" type="range" class="price"
											id="min-slider"> <input max="100" value="100"
											step="1" type="range" class="price" id="max-slider">
									</div>
								</div>
							</div>
						</div>
					</div><div class="bg-white dxgewet sedtgsea mb-lg-0 mb-5">
						<div class="right-box d-flex align-items-start placeholder-item cdgryt67">
							<img class="icon-lerft" src="/resources/images/airline.png"
								alt="">
							<div class="right-inner-box" id="airline">
								<h6 class="mb-2 font-clrf">Airlines</h6>
								<label ng-repeat="airline in airlineFilterList">
									<div class="d-flex font-re-s align-items-center justify-content-between">
										<div class="d-flex align-items-center">
											<input class="form-check-input dfyhdry me-1 mt-0" type="checkbox" value="" ng-click="onclickAirline(airline.code)">
											<p class="mb-0 ms-1 uhbfe urh5">{{getAirlineName(airline.code)}}</p>
										</div>
										<p class="mb-0 ms-1 d-flex align-items-center"><span class="me-1">${websiteCurrency} </span>{{getAirlineFareBase(airline.fare)}}<sup>.{{getAirlineFareSuper(airline.fare)}}</sup></p>
									</div>
								</label>
								
							</div>
						</div>
						<div class="right-box d-flex align-items-start placeholder-item cdgryt67">
							<img class="icon-lerft" src="/resources/images/depart.png"
								alt="">
							<div class="right-inner-box">
								<h6 class="mb-2 font-clrf">Depart Airports</h6>
								<label ng-repeat="depart in departAirports">
									<div class="d-flex font-re-s align-items-center justify-content-between">
										<div class="d-flex align-items-center">
											<input class="form-check-input dfyhdry me-1 mt-0" type="checkbox" value="" ng-model="selectedDepartAirports[depart.airport]">
											<p class="mb-0 ms-1 uhbfe urh5">{{getAirportName(depart.airport)}}</p>
										</div>
									<p class="mb-0 ms-1 d-flex align-items-center"><span class="me-1">${websiteCurrency} </span> {{getAirlineFareBase(depart.fare)}}<sup>.{{getAirlineFareSuper(depart.fare)}}</sup>
									</p>
								
								</div>
								</label>
							</div>
						</div>
						<div class="right-box d-flex align-items-start placeholder-item cdgryt67" ng-if="tripType == '2'">
							<img class="icon-lerft" src="/resources/images/return.png" alt="">
							<div class="right-inner-box">
								<h6 class="mb-2 font-clrf">Return Airports</h6>
								<label ng-repeat="return in returnAirports">
									<div class="d-flex font-re-s align-items-center justify-content-between">
										<div class="d-flex align-items-center">
										<input class="form-check-input dfyhdry me-1 mt-0" type="checkbox" value="" ng-model="selectedReturnAirports[return.airport]">
										<p class="mb-0 ms-1 uhbfe urh5">{{getAirportName(return.airport)}}</p>
										</div>
										<p class="mb-0 ms-1 d-flex align-items-center"><span class="me-1">${websiteCurrency} </span>
											{{getAirlineFareBase(return.fare)}}<sup>.{{getAirlineFareSuper(return.fare)}}</sup>
										</p>
									</div>
								</label>
								
								
							</div>
						</div>

						<div class="right-box d-flex align-items-start placeholder-item cdgryt67" id="departLayoverAirport">
							<img class="icon-lerft" src="/resources/images/depart.png" alt="">
							<div class="right-inner-box">
								<h6 class="mb-2 font-clrf">Departure Layover airport</h6>
								<label ng-repeat="layover in depLayAirports">
									<div class="d-flex font-re-s align-items-center">
										<input class="form-check-input dfyhdry me-1 mt-0" type="checkbox" value="" ng-click="onClickDepLayover(layover)">
										<p class="mb-0 ms-1 uhbfe">{{getAirportName(layover)}}</p>
									</div>
								</label>
							</div>
						</div>

						<div class="right-box d-flex align-items-start placeholder-item cdgryt67"
							id="returnLayoverAirport" ng-if="tripType == '2'">
							<img class="icon-lerft" src="/resources/images/return.png"
								alt="">
							<div class="right-inner-box">
								<h6 class="mb-2 font-clrf">Return Layover airport</h6>
								<label ng-repeat="layover in retLayAirports">
									<div class="d-flex font-re-s align-items-center">
										<input class="form-check-input dfyhdry me-1 mt-0" type="checkbox" value="" ng-click="onClickRetLayover(layover)">
										<p class="mb-0 ms-1 uhbfe">{{getAirportName(layover)}}</p>
									</div>
								</label>
							</div>
						</div>
						<div class="hiden-mof desk-hide ewtew">
							<button onclick="filterhide()" type="submit" class="btn btn-primary sdeyady"><span >Apply</span></button>
						</div>
					</div>
				</div>

				<!-- end filter -->

				<!--start right result-->

				<div class="col-lg-9 ed54t46">
					<div class="sec-matrix hutd67 matrix" ng-if="flightsResponse.flightResult.length > 0">
						<div ng-if="resultLoader == true">
							<div id="divMatrix" class="row w-100 m-auto"></div>
						</div>
						
						<div class="matrix-head-row">
							<div class="edtujes mb-0">Our Best Options</div>
							<div class="matrix-slide-button-container edtujes" ng-if="matrix.length > 5">
								<button type="button" class="matrix-slide-button" id="slideLeft" ng-click="matrixLeftClick();" style="background-color: #f1a501">
									<i class="fa fa-angle-left"></i>
								</button>
								<button type="button" class="matrix-slide-button" id="slideRight" ng-click="matrixRightClick();" style="background-color: #f1a501">
									<i class="fa fa-angle-right"></i>
								</button>
							</div>
						</div>
						<div class="row w-100 m-auto">
							<div class="col-lg-3 fhyfy p-0">
								<div class="eithn">
									<p class="mb-0 foent justify-content-center font-500 wte56">Airline Matrix</p>
                                    <p class="mb-0 foent1 font-500">Non Stop</p>
                                    <p class="mb-0 foent1 font-500">1 Stop</p>
                                    <p class="mb-0 foent1 border-0 font-500">2+ Stop</p>
								</div>
							</div>
							<div class="col-lg-9 p-0 fhyfy1">
								<div class="eithn2" ng-repeat="matrix in matrix" id="matrixdiv{{$index}}" ng-class="{'even': $index % 2 === 0, 'odd': $index % 2 !== 0}">
									<div class="foent" ng-click="onclickAirlineMat(matrix.airline, $index)">
										<img src="/resources/images/airline-logo/{{matrix.airline}}.png">
										<p class="mb-0 ">{{getAirlineName(matrix.airline)}}</p>
									</div>

									<div class="rate-col" ng-repeat="stoprice in matrix.stoprice">
											<p class="mb-0 foent1" ng-if="stoprice.fare > 0" ng-click="filterMatrixClick(matrix.airline,stoprice.fare,stoprice.stop);">
											${websiteCurrency} {{getAirlineFareBase(stoprice.fare)}}<sup>.{{getAirlineFareSuper(stoprice.fare)}}</sup>
											</p>
											<p class="mb-0 foent1">---</p> 
									</div>
								</div>
								
								
								
							</div>
							
							
						</div>
					</div>

					<p class="awrw68" ng-if="flightsResponse.flightResult.length > 0">
						<span class="sdgtg4">Note :</span> *All Fares displayed are quoted
						in ${websiteCurrency} and inclusive of base fare, taxes and all fees. Additional
						baggage fees may apply as per the airlines Policies.
					</p>

					<!-- Phone Only Deals  -->
					<div ng-if="flightsResponse.flightResult.length > 0">
						<c:if test="${IsSoldOut=='true'}">
							<p
								style="color:blue;text-align:center;font-size:15px;font-weight: 500;">
								We're sorry. The fare for the flights you selected just sold
								out. Please select another itinerary.</p>
							<br />
						</c:if>
					</div>

					<div class="ri329tn4">
						<!-- ================== start loader after search static value-->
						<div ng-show="resultLoader">
							<div class="result-block placeholder-item" ng-repeat="x in staticLoader | limitTo:5">
								<div class="pricerow">
									<div class="pricetag">
										<span class="tp">${websiteCurrency} 220.<sup>13</sup></span><span class="dp"></span>
										<div class="ppa1">Price per adult(taxes & fees included)</div>
										<div class="ppa2">Price/Adult</div>
									</div>
									<button type="button">Select</button>
									<div class="fdetails1">
										<img src="/resources/images/airline-logo/UA.png?123">&nbsp;&nbsp;
										<div>
											<span class="fliname">Vistara</span>
										</div>
									</div>
								</div>
								<hr>
								<div class="departure">
									<div class="deprow">
										<span>Departure</span> <a href="#"><i class="fa fa-briefcase"></i>&nbsp;Baggage Fees</a>
									</div>
									<div class="flirow">
										<div class="fdetails2">
											<img src="/resources/images/airline-logo/UA.png?3423">&nbsp&nbsp
											<div>
												<span class="fliname">Vistara</span><span class="flinum">Flight 706</span>
											</div>
										</div>
										<div class="tadetails">
											<div class="a1d">
												<div>
													<span class="sname">DEL</span><span class="fname"> Delhi,IGI Airport</span>
												</div>
												<div>
													<span class="date">Sun,Mar 01 </span>&nbsp<span class="time"> 05:10 pm</span>
												</div>
											</div>
											<i class="fa fa-long-arrow-right" style="font-size:30px;margin-top:5px;color:#17252A"></i>
												<div class="a2d">
												<div>
													<span class="sname">IXC</span><span class="fname"> Chandigarh,Chandigarh</span>
												</div>
												<div>
													<span class="date">Sun,Mar 01 </span>&nbsp<span class="time">06:15 pm</span>
												</div>
											</div>
										</div>
										<div class="cwdetails">
											<span class="wayd">Non Stop</span><span class="classd">Economy</span>
										</div>
									</div>
								</div>
								<div class="durarow">
									<span><i class="fa fa-clock-o"></i> Flight Duration: 1h 5m</span> <span><i class="fa fa-clock-o"></i> Total Trip Time: 1h 5m</span>
								</div>
								<div class="bookbtnrow">
									<button type="button">Book</button>
								</div>
							</div>
						</div>
						<!-- end loader after search -->

						<!-- end flight details ==============================-->
					</div>
					<!-- end one fare ===================-->
					<input type="hidden" value="" id="minFarePrice" />
					<div class="snifr5 mt-0" ng-if="flightsResponse.flightResult.length > 0">
					    <input type="hidden" value="{{minFare}}" id="minFarePrice" />
						<label class="are7u6 activate" ng-click="switchSort('fare.grandTotal');" style="cursor: pointer;">
							<input type="radio" name="hfilter" checked="checked" style="visibility: hidden; width: 0;">
							<img class="hif544" src="/resources/images/recon.png" alt="">
							<img class="hif54" src="/resources/images/recon1.png" alt="">
							<div class="horizon-filter-by">Recommended<div class="horizon-filter-price">
								${websiteCurrency} {{getAirlineFareBase(minFare)}}<sup>.{{getAirlineFareSuper(minFare)}}</sup>
							</div></div>
							<div class="hfborder"></div>
						</label>
						<label class="are7u6" ng-click="switchSort('fare.grandTotal');" style="cursor: pointer;">
							<input type="radio" name="hfilter" style="visibility: hidden; width: 0;">
							<img class="hif544" src="/resources/images/cheap.png" alt="">
							<img class="hif54" src="/resources/images/cheap1.png" alt="">
							<div class="horizon-filter-by">Cheapest<div class="horizon-filter-price">
							${websiteCurrency} 
								{{getAirlineFareBase(minFare)}}<sup>.{{getAirlineFareSuper(minFare)}}</sup>
							</div></div>
							<div class="hfborder"></div>
						</label>
						<label class="are7u6" ng-click="switchSort('totalEFT');" style="cursor: pointer;">
							<input type="radio" name="hfilter" style="visibility: hidden; width: 0;" style="cursor: pointer;">
							<img class="hif544" src="/resources/images/clock.png" alt="">
							<img class="hif54" src="/resources/images/clock1.png" alt="">
							<div class="horizon-filter-by">Shortest<div class="horizon-filter-price">
							${websiteCurrency} <!-- {{shortestFlightFare | currency:'':2}} -->
							{{getAirlineFareBase(shortestFlightFare)}}<sup>.{{getAirlineFareSuper(shortestFlightFare)}}</sup>
							</div></div>
							<div class="hfborder"></div>
						</label>
						<label class="are7u6" ng-click="switchSort('alternate');" ng-if="alternateFlightFare>0" style="cursor: pointer;">
							<input type="radio" name="hfilter" style="visibility: hidden; width: 0;">
							<div class="hficon"><i class="fa fa-calendar-o"></i></div>
							<div class="horizon-filter-by">Alternate Dates<div class="horizon-filter-price">${websiteCurrency} 
							<!-- {{alternateFlightFare | currency:'':2}} -->
								{{getAirlineFareBase(alternateFlightFare)}}<sup>.{{getAirlineFareSuper(alternateFlightFare)}}</sup>
							</div></div>
							<div class="hfborder"></div>
						</label>
					</div>

					<div infinite-scroll="LoadMore()">
					
					<div ng-repeat="flight in filteredFlights = (flightsResponse.flightResult |filter:priceRange |filter:dptTimeRange |filter:retTimeRange |filter:stopsFilter |filter:airlinesFilter |filter:departAirportFilter |filter:returnAirportFilter |filter:depLayFilter|filter:retLayFilter|filter:matrixFilter|orderBy:sortKey:reverse) | limitTo:numberOfResult">
				
						<div class="ri329tn4" >
				
								<div class="row align-items-center w-100 mx-auto bg-white">
									
									<div class="col-lg-9">
										<div class="hdr95">
											<div class="row hgery rela12 tyu765 tyu76d" ng-init="outLength=flight.outBound.length">
												<div class="col-4 col-lg-4">
													<div class="d-flex align-items-center">
														<img class="me-2 e654tgy7" src="/resources/images/airline-logo/{{flight.outBound[0].airline}}.png" style="width: 36px;">
														<!-- <p class="mb-0 cvyh65">American <br>Airline</p> -->
														<p class="mb-0 cvyh65">{{getAirlineName(flight.outBound[0].airline)}}</p>
													</div>
												</div>
												<div class="col-8 col-lg-8 ps-0">
													<div class="dor45">
														<div class="row align-items-center">
															<div class="col-4 col-lg-4">
																<p class="mb-0 rf6u4 dtr64">{{flight.outBound[0].fromAirport}} <br class="saehr"> {{flight.outBound[0].depDate | date:'hh:mm a'}}</p>
																<p class="mb-0 wq4ww5 huy97">{{flight.outBound[0].depDate | date:'EEE, MMM dd'}}</p>
															</div>
															<div class="col-4 col-lg-4 text-center sdtet">
																<p class="mb-0 ed65re"><!-- 9h 54m -->{{flight.outEFT | minToHour}}</p>
																<div class="bgyu6">
																
																	<div class="utrrt0" ng-if="outLength == 1"></div>
																	<div class="utrrt" ng-if="outLength == 2"></div>
																	<div ng-if="outLength > 2">
																		<div class="utrrt1"></div>
																		<div class="utrrt2"></div>
																	</div>
																	
																	<div class="d-flex flex-column bg-white kirjr4" ng-if="outLength > 1">
																		<div class="d-flex align-items-center my-1" ng-repeat="outbound in flight.outBound" ng-if="outLength > 1 && $index < outLength - 1">
																			<div class="dfjg8">
																				<p class="mb-0" ng-if="outbound.layOverTime > 0">Layover Time</p>
																				<p class="mb-0">Stop {{$index+1}}</p>
																			</div>
																			<div class="djhfut">
																				<p class="mb-0" ng-if="outbound.layOverTime > 0">
																					{{outbound.layOverTime | minToHour}}
																				</p>
																				<p class="mb-0"><!-- CLT --> {{getCityName(outbound.toAirport)}} ({{outbound.toAirport}})</p>
																			</div>
																		</div>
																	</div>
																</div>
																<p class="mb-0 ed65re" ng-if="outLength == 1">Non Stop</p>
																<p class="mb-0 ed65re" ng-if="outLength > 1">{{outLength-1}} Stop</p>
															</div>
															<div class="col-4 col-lg-4">
																<p class="mb-0 rf6u4">{{flight.outBound[outLength-1].toAirport}} <br class="saehr">
																	{{flight.outBound[outLength-1].reachDate | date:'hh:mm a'}}</p>
																<p class="mb-0 wq4ww5 hutd67">
																	<!-- Fri, Aug 30 -->
																	{{flight.outBound[outLength-1].reachDate | date:'EEE, MMM dd'}}
																</p>
															</div>
														</div>
													</div>
												</div>
											</div>

											<div class="row hgery rela12 tyu765 tyu76" ng-if="flight.inBound.length > 0">
												<div class="col-4 col-lg-4">
													<div class="d-flex align-items-center">
														<!-- <img class="me-2 e654tgy7" src="/resources/images/air.png" alt=""> -->
														<img class="me-2 e654tgy7" src="/resources/images/airline-logo/{{flight.inBound[0].airline}}.png"
															style="width: 36px;">
														<p class="mb-0 cvyh65">{{getAirlineName(flight.inBound[0].airline)}}</p>
													</div>
												</div>
												
												
												<div class="col-8 col-lg-8 ps-0" ng-init="inLength=flight.inBound.length">
													<div class="dor45">
														<div class="row align-items-center">
															<div class="col-4 col-lg-4">
																<p class="mb-0 rf6u4 dtr64">{{flight.inBound[0].fromAirport}} <br class="saehr">{{flight.inBound[0].depDate | date:'hh:mm a'}}</p>
																<p class="mb-0 wq4ww5 huy97">{{flight.inBound[0].depDate | date:'EEE, MMM dd'}}</p>
																<span class="alternate-dates" ng-if="compareReturnDates(flight.inBound[0].depDate | date:'MM/dd/yyyy')">Alternate Date</span>
															</div>
															<div class="col-4 col-lg-4 text-center sdtet">
																<p class="mb-0 ed65re">
																	<!-- 9h 54m -->
																	{{flight.inEFT | minToHour}}
																</p>
																<div class="bgyu6">
																
																	<div class="utrrt0" ng-if="inLength == 1"></div>
																	<div class="utrrt" ng-if="inLength == 2"></div>
																	<div ng-if="inLength > 2">
																		<div class="utrrt1"></div>
																		<div class="utrrt2"></div>
																	</div>
																	<div class="d-flex flex-column bg-white kirjr4" ng-if="inLength > 1">
																		<div class="d-flex align-items-center my-1" ng-repeat="inbound in flight.inBound" ng-if="inLength > 1 && $index < inLength - 1">
																			<div class="dfjg8">
																				<p class="mb-0" ng-if="inbound.layOverTime > 0">Layover Time</p>
																				<p class="mb-0">Stop {{$index+1}}<!-- {{inLength-1}} --></p>
																			</div>
																			<div class="djhfut">
																				<p class="mb-0" ng-if="inbound.layOverTime > 0">
																					{{inbound.layOverTime | minToHour}}
																				</p>
																				<p class="mb-0"><!-- CLT --> {{getCityName(inbound.toAirport)}} ({{inbound.toAirport}})</p>
																			</div>
																			</div>
																		</div>
																	</div>
																<p class="mb-0 ed65re" ng-if="inLength == 1">Non Stop</p>
																<p class="mb-0 ed65re" ng-if="inLength > 1">{{inLength-1}} Stop</p>
															</div>
															<div class="col-4 col-lg-4">
																<p class="mb-0 rf6u4">{{flight.inBound[inLength-1].toAirport}}<br class="saehr">
																	{{flight.inBound[inLength-1].reachDate | date:'hh:mm a'}}</p>
																<p class="mb-0 wq4ww5 hutd67">{{flight.inBound[inLength-1].reachDate | date:'EEE, MMM dd'}}</p>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
										
										<div ng-repeat="otherbound in flight.otherBound">
											<div class="flight-info-row">
												<div class="flight-info-airline">
													<img src="/resources/images/airline-logo/{{otherbound[0].airline}}.png">
													<span>&nbsp;{{getAirlineName(otherbound[0].airline)}}</span>
												</div>
												<div class="flight-info-daydate"> {{otherbound[0].depDate | date:'EEE, MMM dd'}}</div>
												<div class="flight-info-fromtodura" ng-init="otherlen=otherbound.length">
													<div class="flight-info-from">
														<div class="from-time">{{otherbound[0].depDate | date:'hh:mm a'}}</div>
														<div class="from-city" title="{{getCityName(otherbound[0].fromAirport)}}">{{otherbound[0].fromAirport}}</div>
													</div>
													<div class="flight-info-durastop" ng-init="totalEft=0">
														<div ng-repeat="otherEft in otherbound">
															<div ng-init="totalEft=totalEft+otherEft.eft">
																<div class="flight-duration" ng-if="$last">{{totalEft | minToHour}}</div>
															</div>
														</div>
														<div class="flight-stop-graph">
															<div class="stop-dot" ng-if="otherlen > 1">
																<div class="stop-tool">
																	<div class="stoplay-head">
																		<span>Stop {{otherlen-1}}</span> <span>Layover Time</span>
																	</div>
																	<div class="stoplay-val">
																		<span title="{{getCityName(otherbound[0].toAirport)}}">{{otherbound[0].toAirport}}</span>
																		<span>{{otherbound[0].layOverTime | minToHour}}</span>
																	</div>
																</div>
															</div>
														</div>
														<div class="flight-stop" ng-if="otherlen == 1">Non Stop</div>
														<div class="flight-stop" ng-if="otherlen > 1">{{otherlen-1}} Stop</div>
													</div>
													<div class="flight-info-to">
														<!--  <div class="plus-day">next day</div> -->
														<div class="to-time">{{otherbound[otherlen-1].reachDate | date:'hh:mm a'}}</div>
														<div class="to-city" title="{{getCityName(otherbound[otherlen-1].toAirport)}}">{{otherbound[otherlen-1].toAirport}}</div>
													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="col-lg-3 ">
										<div class="hbig85g">
											<div>
												<p class="mb-1 fdy65te">
													<!-- ${websiteCurrency} 340.<sup>90</sup> -->
													${websiteCurrency} <!-- {{(flight.fare.adultFare+flight.fare.adultTax+flight.fare.adultMarkup) | currency:'':2}} -->
													
													{{getBaseFare(flight.fare.adultFare,flight.fare.adultTax,flight.fare.adultMarkup)}}<sup>.{{getBaseFareDecimal(flight.fare.adultFare,flight.fare.adultTax,flight.fare.adultMarkup)}}</sup>
												</p>
												<p class="mb-1 ty77r5">Price per Person</p>
												<p class="mb-1 ji7jrt">(incl, taxes & fees)</p>
												<span class="hideOnPhone priceoncntl">{{flight.fare.markupID}},{{flight.fare.adultMarkup}},{{flight.gdsType}}</span>
											</div>
											
											<button type="button" class="edt6564" ng-click="paymentPage(flight.resultId);">
												<span>Select </span>
											</button>
										</div>
									</div>
								</div>
								<div class="j84">
									<img src="/resources/images/line-3.png" alt="">
								</div>
							
							<div class="hgt94h bg-white">
								<p class="mb-0 de5u4fty" id="gye45_1" ng-click="showFlightDetails($index);">
									Flight Details <i id="rotateArrow_{{$index}}" class="fa fa-angle-down" aria-hidden="true"></i>
								</p>

								<div class="fg938rf bg-white" id="flightdetailexpandcollaps_{{$index}}">
									<img class="srfw67" ng-click="hideFlightDetails($index);" src="/resources/images/cross.png" alt="" style="cursor: pointer;">

									<!----------------- start Departure -------------------->

									<div ng-repeat="outbound in flight.outBound">
										<h5 class="mb-3 yu86" ng-if="$index == 0">Departure</h5>
										<div class="row rela12 mt-3">
																						
											<div class="col-lg-9">
												<div class="bjyur69">
													<div class="row">
														<div class="col-lg-4">
															<div class="d-flex align-items-start mb-1">
																<!-- <img class="me-2 e654tgy7" src="/resources/images/air.png" alt=""> -->
																<img class="me-2 e654tgy7" src="/resources/images/airline-logo/{{outbound.airline}}.png" style="width: 36px;">
																<div class="hor56">
																	<p class="mb-0 cvyh65">{{getAirlineName(outbound.airline)}}</p>
																	<div class="d-flex">
																		<p class="mb-0 drt6yju">Flight {{outbound.flightNo}} | Aircraft</p>
																		<div class="rela12 dft65">
																			<p class="mb-0 w5g4q2">{{outbound.equipmentType}}</p>
																			<div ng-init="eqptpDeslen=outbound.equipmentTypeDes">
																				<div class="bg-white kirjr43" ng-if="eqptpDeslen !== ''">
																					<p class="mb-0 dt54t">{{outbound.equipmentTypeDes}}</p>
																				</div>
																			</div>
																		</div>
																	</div>
																</div>
															</div>
															<!-- <div class="d-flex align-items-start shfirt "> -->
															<div class="d-flex align-items-start" ng-if="outbound.airline !== outbound.opratingAirline">
																<p class="mb-1 dt54t ty75y o-utw">Operated by : </p>
																<p class="mb-1 dt54t ty75y">
																	{{getAirlineName(outbound.opratingAirline)}}</p>
															</div>
														</div>
														<div class="col-lg-8">
															<div class="dor45">
																<div
																	class="row align-items-center justify-content-around">
																	<div class="col-lg-5 trt64 h9h49 text-center">
																		<p class="mb-0 rf6u4">
																			<!-- 04:29PM --> {{outbound.depDate | date:'hh:mm a'}}
																		</p>
																		<p class="mb-0 tyuf57">{{outbound.depDate | date:'EEE, MMM dd'}}</p>
																		<p class="mb-0 h8yhb5 fu75rh">{{getCityName(outbound.fromAirport)}} <!-- ({{outbound.fromAirport}}) --></p>
																	</div>
																	<div class="col-lg-2 t64ghu h9h49">
																		<div class="bgyu64"></div>
																	</div>
																	<div class="col-lg-5 ty75g h9h49 text-center">
																		<p class="mb-0 rf6u4">{{outbound.reachDate | date:'hh:mm a'}}
																			<!-- <sup class="sred56" ng-if="getDayCount(outbound.depDate, outbound.reachDate) >=1">
																				+{{getDayCount(outbound.depDate, outbound.reachDate)}} Day{{getDayCount(outbound.depDate, outbound.reachDate) >= 2 ? 's' : ''}}</sup> -->
																				
																				<sup class="sred56" ng-if="getDayCount(outbound.depDate, outbound.reachDate) >=1">
																				+{{getDayCount(outbound.depDate, outbound.reachDate)}} Day{{getDayCount(outbound.depDate, outbound.reachDate) >= 2 ? 's' : ''}}</sup>
																		</p>
																		<p class="mb-0 tyuf57">{{outbound.reachDate | date:'EEE, MMM dd'}}</p>
																		<p class="mb-0 h8yhb5 fu75rh">{{getCityName(outbound.toAirport)}} <!-- ({{outbound.toAirport}}) --></p>
																	</div>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
											<div class="col-6 col-lg-3 gr5t6j4">
												<div class="hiegr7">
													<p class="mb-0 tyuf57">
														<span class="fg6534" style="font-size: 12px;">{{getCabinName(outbound.cabinClass)}}</span>
													</p>
													<!-- <p class="mb-0 tyuf57"> Baggage : <span class="fg6534">1PC</span> </p> -->
												</div>
											</div>
										</div>
										<div class="row mt-2">
											<div class="col-6 col-lg-9">
												<p class="mb-0 h8yhb5 d65w4">Flight Duration:
													{{outbound.eft | minToHour}}</p>
											</div>
											<div class="col-6 col-lg-3" ng-if="$last">
												<p class="mb-0 h8yhb5 d65w4 ">Total Trip Time:
													{{flight.outEFT | minToHour}}</p>
											</div>
										</div>
										<div class="rela d54yd my-3" ng-if="($index+1) != flight.outBound.length">
											<p class="mb-0 djgur74"> <img src="/resources/images/clk.png" alt="">
												<!-- 3h 57m layover in Dallas-Forth (DFW) -->
												{{outbound.layOverTime | minToHour}} layover in {{getCityName(outbound.toAirport)}} ({{outbound.toAirport}})
											</p>
										</div>
									</div>

									<!-- --------------start Return-------------------- -->
									<div class="stop-divider" ng-if="flight.inBound.length > 0">
										<hr class="wser5e">
									</div>

									<div ng-repeat="inbound in flight.inBound">
										<h5 class="mb-3 yu86" ng-if="$index == 0 && tripType == '2'">Return</h5>
										
										<div class="row rela12 mt-3">
																						
											<div class="col-lg-9">
												<div class="bjyur69">
													<div class="row">
														<div class="col-lg-4">
															<div class="d-flex align-items-start mb-1">
																<img class="me-2 e654tgy7" src="/resources/images/airline-logo/{{inbound.airline}}.png" style="width: 36px;">
																<div class="hor56">
																	<p class="mb-0 cvyh65">{{getAirlineName(inbound.airline)}}</p>
																	<div class="d-flex">
																		<p class="mb-0 drt6yju">Flight
																			{{inbound.flightNo}} | Aircraft</p>
																		<div class="rela12 dft65">
																			<p class="mb-0 w5g4q2">{{inbound.equipmentType}}</p>

																			<!-- <div class="bg-white kirjr43">
																				<p class="mb-0 dt54t">{{inbound.equipmentTypeDes}}</p>
																			</div> -->
																			
																			<div ng-init="eqptpRtnlen=inbound.equipmentTypeDes">
																				<div class="bg-white kirjr43" ng-if="eqptpRtnlen != ''">
																					<p class="mb-0 dt54t">{{inbound.equipmentTypeDes}}</p>
																				</div>
																			</div>
																			
																		</div>
																	</div>
																</div>
															</div>
															<div class="d-flex align-items-start shfirt" ng-if="outbound.airline !== outbound.opratingAirline">
																<p class="mb-1 dt54t ty75y o-utw">Operated by : </p>
																<p class="mb-1 dt54t ty75y">{{getAirlineName(inbound.opratingAirline)}}</p>
															</div>

														</div>
														<div class="col-lg-8">
															<div class="dor45">
																<div
																	class="row align-items-center justify-content-around">
																	<div class="col-lg-5 trt64 h9h49 text-center">
																		<p class="mb-0 rf6u4">{{inbound.depDate | date:'hh:mm a'}}</p>
																		<p class="mb-0 tyuf57">{{inbound.depDate | date:'EEE, MMM dd'}}</p>
																		<p class="mb-0 h8yhb5 fu75rh">{{getCityName(inbound.fromAirport)}}
																			<!-- ({{inbound.fromAirport}}) --></p>
																		
																	</div>
																	<div class="col-lg-2 t64ghu h9h49 text-center">
																		<div class="bgyu64"></div>
																	</div>
																	<div class="col-lg-5 ty75g h9h49 text-center">
																		<p class="mb-0 rf6u4">{{inbound.reachDate | date:'hh:mm a'}}
																			<sup class="sred56" ng-if="getDayCount(inbound.depDate, inbound.reachDate) >=1">+{{getDayCount(inbound.depDate, inbound.reachDate)}} Day</sup>
																		</p>
																		<p class="mb-0 tyuf57">{{inbound.reachDate | date:'EEE, MMM dd'}}</p>
																		<p class="mb-0 h8yhb5 fu75rh">{{getCityName(inbound.toAirport)}}
																			<!-- ({{inbound.toAirport}}) --></p>
																		
																	</div>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
											<div class="col-6 col-lg-3 gr5t6j4">
												<div class="hiegr7">
													<p class="mb-0 tyuf57 ">
														<span class="fg6534" style="font-size: 12px;">{{getCabinName(inbound.cabinClass)}}</span>
													</p>
													<!-- <p class="mb-0 tyuf57">Baggage : <span class="fg6534">1PC</span></p> -->
												</div>
											</div>
										</div>
										<div class="row mt-2">
											<div class="col-6 col-lg-9">
												<p class="mb-0 h8yhb5 d65w4">Flight Duration:
													{{inbound.eft | minToHour}}</p>
											</div>
											<div class="col-6 col-lg-3" ng-if="$last">
												<p class="mb-0 h8yhb5 d65w4 ">Total Trip Time:
													{{flight.inEFT | minToHour}}</p>
											</div>
										</div>
										<div class="rela d54yd my-3" ng-if="($index+1) != flight.inBound.length">
											<p class="mb-0 djgur74"> <img src="/resources/images/clk.png" alt="">
												{{inbound.layOverTime | minToHour}} layover in
												{{getCityName(inbound.toAirport)}} ({{inbound.toAirport}})
											</p>
										</div>
									</div>
									<!-- end return -->
								</div>
							</div>
						</div>
						</div>
						
						<div class="noRsltFound" ng-if="filteredFlights.length == 0">
							No Result Please Change Search Criteria or &nbsp;<a href="javascript:void(0);" ng-click="resetFilters();"> Reset Filters</a>.
						</div>
						
					</div>
					<!-- end loader after 1 scroll -->
					<button type="button" id="loadmore" ng-if="filteredFlights.length > 0 && filteredFlights.length > numberOfResult" ng-click="LoadMore();">
						<i class="fa fa-spinner"></i>Load More
					</button>
				</div>
			</div>
		</div>
	</section>
 
	<style type="text/css">
.noRsltFound {
	font-size: 20px;
	text-align: center;
	height: 20vh;
	display: flex;
	justify-content: center;
	align-items: center;
	font-family: -apple-system, BlinkMacSystemFont, Arial, Helvetica Neue,
		Segoe UI, Roboto, sans-serif;
}

@media ( max-width :768px) {
	.noRsltFound {
		height: calc(90vh - 100px);
		margin-top: 100px;
	}
}
</style>

	
	<jsp:include page="../../timeoutPopup.jsp" />
	
	<!--<jsp:include page="../../flights/listing/uc_popup.jsp" />-->
	
	<jsp:include page="../../flights/listing/uc_popup.jsp">
	    <jsp:param name="fare" value="${websiteCurrency} {{getAirlineFareBase(discountedMinFare)}}<sup>.{{getAirlineFareSuper(discountedMinFare)}}</sup>" />
	</jsp:include>

    
    <footer class="bg-white">
        <div class="container">
            <div class="row justify-content-center text-center align-items-center">
                <div class="col-lg-12">
                    <p class="my-2 fotrd">Copyright @${copyRightYear} ${websiteName}. All rights reserved. <img src="/resources/images/payment-type.png" alt=""> <img src="/resources/images/pcidcs.png" alt=""></p>
                </div>
            </div>
        </div>
    </footer>
</body>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript" src="/resources/js/jquery-ui.min_1.13.0.js"></script>
<script type="text/javascript" src="/resources/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="/resources/js/index.js"></script>
<script src="/resources/js/flight-result.js?1311243456"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js" integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.js"></script>

<script>
    $(document).ready(function() {

    var classId =  $("#searchCabinType").val();
    var sAdult =  $("#searchAdult").val();
    $("#adult").val(sAdult);
    var sChild =  $("#searchChild").val();
    $("#child").val(sChild);
    var sIntfLap =  $("#searchInfantLap").val();
    $("#infant").val(sIntfLap);
    var sIntSt =  $("#searchInfantSt").val();
    $("#infantWs").val(sIntSt);
    
    var totalCount = Number(sAdult)+Number(sChild)+Number(sIntfLap)+Number(sIntSt);
    
	console.log("totalCount = "+totalCount);

	if(classId==1){
	cabin = "Economy";
	}
	else if(classId==2){
	cabin = "PremiumEconomy";
	}
	else if(classId==3){
	cabin = "Business";
	}
	else if(classId==4){
	cabin = "First";
	}
	
	$("input[name='classtype'][value='" + cabin + "']").prop("checked", true);
	$(".traveller").text(totalCount);
	console.log("totalCount = "+totalCount);
	if(totalCount==1){
		$(".traveller").val(totalCount+" Traveler, "+cabin);
    	$("#mobTraveler").text(totalCount + " Traveler, " + cabin);
    	$(".travellers").text("Adult");
	}
	if(totalCount >1){
		$(".traveller").val(totalCount+" Traveler (s), "+cabin);
    	$("#mobTraveler").text(totalCount + " Traveler (s), " + cabin);
    	$(".travellers").text("Traveler (s)");
	}
	  $(".cabins").text(cabin);
    $("#cabin").val(cabin);
    
    
    // Process origin location
    const orgLocString = $("#origin").val();
    const orgparts = orgLocString.split(",");
    const orglocationPart = orgparts[0].trim().split("-");
    const orgairportCode = orglocationPart[0].trim();
    const orgcityName = orglocationPart[1].trim();
    const orgnameAndCountry = orgparts[1].trim();

    // Update the UI with origin details
    $("#fAirportCode").text(orgairportCode);
    $("#fCityName").text(orgcityName);
    $("#fNamewithContry").text(orgnameAndCountry);
    $("#closeDep").show();

    $('.sdgsg').stop(true, true).css('z-index', '10').show().animate({
        top: '0'
    }, 500);

    // Process destination location
    const destLocString = $("#destination").val();
    const destparts = destLocString.split(",");
    const destlocationPart = destparts[0].trim().split("-");
    const destairportCode = destlocationPart[0].trim();
    const destcityName = destlocationPart[1].trim();
    const destnameAndCountry = destparts[1].trim();

    // Update the UI with destination details
    $("#tAirportCode").text(destairportCode);
    $("#tCityName").text(destcityName);
    $("#tNamewithContry").text(destnameAndCountry);
    $("#closeRtn").show();

    $('.sdgsg1').stop(true, true).css('z-index', '10').show().animate({
        top: '0'
    }, 500);
    
    $("#orgClick").click(function() {
        $('.sdgsg').hide();
        $("#opnDep").show();
    });

    // Handle destination click event
    $("#destClick").click(function() {
        $("#opnRtn").show();
        $('.sdgsg1').hide();
		$("#desValidation").hide();
    });


   // Process departure date
			const departDate = $("#fdateObject").val();
			const updatedDepDateStr = departDate.replace(/,\s*$/, '');
			
			console.log("hd_departDate --> " + updatedDepDateStr);
			
			const updatedDepDate = new Date(updatedDepDateStr);
			
			if (!isNaN(updatedDepDate.getTime())) {
			    $("#departDate").val(updatedDepDateStr);
			
			    const day = updatedDepDate.getDate();
			    const monthNames = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
			    const month = monthNames[updatedDepDate.getMonth()];
			    const year = updatedDepDate.getFullYear();
			    const dayOfWeek = updatedDepDate.toLocaleString('default', { weekday: 'long' });
			
			    $('#depDayNum').text(day);
			    $('#depDayMonth').text(month);
			    $('#depDayYear').text(dayOfWeek + ', ' + year);
			
			    console.log("depDayNum --> " + day);
			    console.log("depDayMonth --> " + month);
			    console.log("depDayYear --> " + dayOfWeek + ', ' + year);
			} else {
			    console.error("Invalid date format: " + updatedDepDateStr);
			}
			
			// Process return date
			function processReturnDate() {
        const returnDate = $("#tdateObject").val();
        
        console.log("tdateObject = <> " + returnDate);
        
        if (!returnDate) {
		    console.log("The date is empty.");
		    $('#tab1').prop('checked', false);
		    $('#tab2').prop('checked', true);
		    $("#returnDate").val();
	        $("#rtnDayNum").text("?");
	        $("#rtnDayMonth").text("Book Round Trip");
	        $("#rtnDayYear").text("to save extra");
	        
		} else {
		    const updatedReturnDateStr = returnDate.replace(/,\s*$/, ''); // Remove last comma
	        console.log("hd_returnDate --> " + updatedReturnDateStr);
	        const updatedReturnDate = new Date(updatedReturnDateStr);
	        
	        if (!isNaN(updatedReturnDate.getTime())) {
	            $("#returnDate").val(updatedReturnDateStr);
	        
	            const day = updatedReturnDate.getDate();
	            const monthNames = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
	            const month = monthNames[updatedReturnDate.getMonth()];
	            const year = updatedReturnDate.getFullYear();
	            const dayOfWeek = updatedReturnDate.toLocaleString('default', { weekday: 'long' });
	        
	            $('#rtnDayNum').text(day);
	            $('#rtnDayMonth').text(month);
	            $('#rtnDayYear').text(dayOfWeek + ', ' + year);
	        
	            console.log("rtnDayNum --> " + day);
	            console.log("rtnDayMonth --> " + month);
	            console.log("rtnDayYear --> " + dayOfWeek + ', ' + year);
	        } else {
	            console.error("Invalid date format: " + updatedReturnDateStr);
	        }
		}
    }

    processReturnDate();
	
    $("#tab1").click(function() {
        $("div#ru84").removeClass("wstdxt");
        processReturnDate(); // Call the function to process the return date again
		$("#returnDate").val();
		$("#rtnDayNum").text("?");
		$("#rtnDayMonth").text("Book Round Trip");
		$("#rtnDayYear").text("to save extra");
    });
    
    var tType = $("#tripType").val();
		if (tType == "1") {
    
    	$("#spnRtnDate").hide();
    	console.log("tripType res 1");
    
        $('#tab2').prop('checked', true);
        $("div#ru84").addClass("wstdxt");
	        console.log("one");
	        $("#tripType").val(1);
	        $("#rtnDayNum").text("?");
	        $("#rtnDayMonth").text("Book Round Trip");
	        $("#rtnDayYear").text("to save extra");
    } else if (tType == "2") {
    	$("#spnRtnDate").show();
        $('#tab1').prop('checked', true);
        console.log("tripType res 2");
    }
});
    	
</script>
<script>
	$(document).ready(function() {
	    $('.matrix .disrt').each(function(index) {
	        if (index % 2 === 1) {
	            $(this).removeClass('disrt');
	        }
	    });
	});
	$(document).ready(function() {
	    $('.wr45swe4').on('click', function() {
	        $(this).toggleClass('active');
	        $('.col-lg-3.edtrf6.hutd67').toggle();
	    });
	});
</script>

<script>
		$(document).ready(function() {
		    /* $('#boxed').hide(); */
		    document.getElementById("boxed").style.display = "none";
		    document.getElementById("dialog").style.display = "none";
		    setTimeout(function() {
		    document.getElementById("mask").style.display = "block";
			document.getElementById("dialog").style.display = "block";
			document.getElementById("close_id").style.display = "block";
			document.getElementById("reopen_ucb").style.display = "none";
			document.getElementById("boxed").style.display = "block";
		    }, 25000); // 15 seconds in milliseconds
		    $('#close_id').on('click', function() {
		        /* $('#boxed').hide(); */
		        document.getElementById("boxed").style.display = "none";
		        document.getElementById("dialog").style.display = "none";
		    });
		});
	</script>
</html>