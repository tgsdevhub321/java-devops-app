<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<style>

.hero-section {
    padding-top: 7rem;
    position: relative;
}

.hero-bg-col {
    background-image: url('/resources/assets/img/hero/hero-img.png');
    background-size: contain;
    background-repeat: no-repeat;
    background-position: right center;
    min-height: 350px; /* adjust as needed */
}

.search-engine-wrapper {
   /*  background: #ffffff; */
    padding: 20px;
    border-radius: 12px;
    box-shadow: 0 10px 30px rgba(0,0,0,0.1);
}


.search-row {
    margin-top: -80px !important; /* pull search engine upward */
    z-index: 5;
    position: relative;
}

/* -----------------------------------------
   GLOBAL THEME VARIABLES
------------------------------------------ */
:root {
  --primary: #ff4d4d;
  --primary-hover: #e63e3e;
  --text-dark: #1a1a1a;
  --text-light: #6d6d6d;
  --bg-light: #ffffff;
  --bg-soft: #f4f6ff;
  --border-radius: 14px;
  --transition: 0.25s ease;
}

/* -----------------------------------------
   HERO SECTION
------------------------------------------ */
.hero-title {
  font-size: 3rem;
  font-weight: 800;
  color: var(--text-dark);
  line-height: 1.2;
}

.text-danger {
  color: var(--primary) !important;
}

/* -----------------------------------------
   TOP BUTTONS (Roundtrip / One-way)
------------------------------------------ */
.top-btn-sec .roundtripbtn {
  padding: 10px 18px;
  border-radius: var(--border-radius);
  background: var(--bg-soft);
  cursor: pointer;
  transition: var(--transition);
  border: 2px solid transparent;
}

.top-btn-sec .roundtripbtn:hover {
  background: var(--primary);
  color: #fff;
}

.roundtripbtn input[type="radio"] {
  accent-color: var(--primary);
}

/* -----------------------------------------
   FROM / TO INPUT BOXES
------------------------------------------ */
.depart-main,
.return-main {
 background: var(--bg-light);
    border-radius: var(--border-radius);
    padding: 14px 13px;
    border: 1px solid #eaeaea;
    transition: var(--transition);
    cursor: pointer;
    min-height: 83px;
}

/* background: var(--bg-light);
  border-radius: var(--border-radius);
  padding: 14px 18px;
  border: 1px solid #eaeaea;
  transition: var(--transition);
  cursor: pointer;
  min-height: 120px;*/
.depart-main:hover,
.return-main:hover,
.calendar-main:hover,
.traveller:hover {
  border-color: var(--primary);
  box-shadow: 0 6px 16px rgba(255, 77, 77, 0.2);
}

/* Labels */
.from,
.to {
  font-size: 0.85rem;
  color: var(--text-light);
  font-weight: 600;
}

/* Selected airport text */
.departure {
  font-size: 1.1rem;
  font-weight: 700;
  color: var(--text-dark);
}

.search-origin {
  font-size: 0.85rem;
  color: var(--text-light);
  text-overflow: ellipsis;
    overflow: hidden;
    white-space: nowrap;
}
.exchange-icon.exchange{
  position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    text-align: center;
    z-index: 99;
    width: fit-content;
}
.row > *{
  padding-right: 4px;
  padding-left: 4px;
}
/* -----------------------------------------
   SEARCH DROPDOWN LIST
------------------------------------------ */
.searchdep {
  width: 328px;
  background: #fff;
  border-radius: var(--border-radius);
  padding: 15px;
  border: 1px solid #e5e5e5;
  top: 105%;
  left: 0;
  z-index: 1000;
  box-shadow: 0 4px 15px rgba(0,0,0,0.08);
}
.airport-results {
  max-height: 200px;
  overflow-y: auto;
}
.search-sec{
  i.fa.fa-search{
    position: absolute;
    left: 21px;
  }
}

.searchdep input[type=search] {
  width: 100%;
  border: none;
  padding: 8px;
  padding-left: 25px;
  background: var(--bg-soft);
  border-radius: var(--border-radius);
}

/* Airport result item */
.dep-name-inner {
  padding: 10px;
  border-radius: var(--border-radius);
  transition: var(--transition);
}

.dep-name-inner:hover {
  background: var(--bg-soft);
  cursor: pointer;
}

/* -----------------------------------------
   DATE PICKER / CALENDAR BOXES
------------------------------------------ */
.calendar-main {
  padding: 14px 9px;
  background: var(--bg-light);
  border: 1px solid #eaeaea;
  border-radius: var(--border-radius);
  min-height: 83px;
}

/* -----------------------------------------
   TRAVELER BOX
------------------------------------------ */
.traveller {
  padding: 14px 9px;
  background: var(--bg-light);
  border-radius: var(--border-radius);
  border: 1px solid #eaeaea;
  min-height: 83px;
}
.air-name-txt {
    margin-left: 11px;
}
.adult-main h5 span {
    font-size: 12px;
}
.submit-btn button{
    border-radius: 8px;
    border: none;
    width: 100%;
    padding: 9px;
    background: #ff4d4d;
    color: white;
    font-weight: 500;
    font-size: 20px;
}
/* Inside dropdown */
.traveller-sec {
  background: #ffffff;
  padding: 20px;
  width: 445px;
  right: 0;
  border-radius: var(--border-radius);
  border: 1px solid #eaeaea;
  box-shadow: 0px 4px 16px rgba(0,0,0,0.12);
}

/* Buttons (+ / - ) */
.plus-minus button {
  width: 32px;
  height: 32px;
  border: none;
  background: var(--bg-soft);
  border-radius: 50%;
  font-size: 18px;
  font-weight: bold;
  transition: var(--transition);
}

.plus-minus button:hover {
  background: var(--primary);
  color: #fff;
}

/* -----------------------------------------
   CLASS SELECT BUTTONS
------------------------------------------ */
.seat-class button {
  width: 100%;
  padding: 10px;
  border-radius: var(--border-radius);
  border: 1px solid #eaeaea;
  background: var(--bg-soft);
  transition: var(--transition);
}

.seat-class button:hover {
  background: var(--primary);
  color: #fff;
}

/* -----------------------------------------
   SEARCH BUTTON
------------------------------------------ */
.search-main button {
  width: 100%;
  padding: 16px;
  min-height: 83px;
  background: var(--primary);
  color: #fff;
  border: none;
  border-radius: var(--border-radius);
  font-size: 26px;
  font-weight: 500;
  transition: var(--transition);
}

.search-main button:hover {
  background: var(--primary-hover);
}

@media (max-width: 767px) {
    .hero-bg-col .hero-title {
        display: none;
    }
    .exchange-icon.exchange {
      left: inherit;
      right: 0;
      transform: translate(-33%, -64%);
      width: fit-content;
      span img{
      rotate: 90deg;
    }
    }
    .traveller-sec {
        padding: 12px;
        width: 100%;
    }
    .seat-class button {
        font-size: 11px;
    }


}

</style>
 <section style="padding-top: 5rem;">
        <div class="bg-holder" style="background-image:url(/resources/assets/img/hero/herobg.png);">
        </div>
        <!--/.bg-holder-->
 <form:form modelAttribute="flightSearch" action="flight" method="POST">
							<form:hidden path="tripType" value="RT"/>
							<form:hidden path="pageAirline" value="" />
							<form:hidden path="cabin" id="cabin" value="Economy" />
							<form:hidden path="utmSource" id="utmSource" value="online" />
							<input id="hdFromDate" name="hdFromDate" value="" type="hidden" />
							<input id="hdToDate" name="hdToDate" value="" type="hidden" />
         
         <div class="container">

    <!-- ROW 1 : TEXT LEFT + IMAGE RIGHT -->
    <div class="row align-items-center">

        <!-- LEFT TEXT -->
        <div class="col-md-7 col-lg-6 text-md-start text-center pb-6">
            <h4 class="fw-bold text-danger mb-3">Best Destinations around the world</h4>
            <h1 class="hero-title d-none d-md-block">Travel, enjoy and live a new and full life</h1>
        </div>

        <!-- RIGHT HERO IMAGE (stays beside text) -->
        <div class="col-md-5 col-lg-6 hero-bg-col d-none d-md-block"></div>
       <!--  <div class="col-md-5 col-lg-6 text-end">
            <img class="pt-7 pt-md-0 hero-img" src="/resources/assets/img/hero/hero-img.png" alt="hero-header"/>
        </div> -->

    </div>

    <!-- ROW 2 : FULL-WIDTH SEARCH ENGINE -->
   <div class="row search-row">
    <div class="col-12">
        <div class="search-engine-wrapper w-100">
                
                       <div class="text-md-start"> 
                            <div class="row w-100 m-auto">
                                <div class="col-12 p-0 mb-2 mb-lg-3">
								  <div class="top-btn-sec d-flex justify-content-start align-items-center gap-3">
								    <div class="roundtripbtn round border-0 d-flex justify-content-start align-items-center gap-2">
								      <input name="round1" type="radio" id="round" value="roundTrip" checked>
								      <label for="round" class="mb-0">Round Trip</label>
								    </div>
								    <div class="roundtripbtn one border-0 d-flex justify-content-start align-items-center gap-2">
								      <input name="round1" type="radio" id="oneway" value="oneWay" >
								      <label for="oneway" class="mb-0">One-way</label>
								    </div>
								  </div>
								</div>
                                <div class="col-lg-4 p-0">
                                <div class="depart-sec-main ">
                                    <div class="row w-100 mx-auto position-relative">
                                    <div class="col-lg-6  mb-2 mb-lg-0 form-group">
                                        <div class="depart-main position-relative fromairport"> 
                                            <p class="mb-0 from fromairport" >From</p>
                                            <p class="mb-0 departure fromairport edtrdt">Origin </p>
                                            <p class="mb-0 search-origin fromairport"> Search Your Origin </p>
                                           	<form:hidden id="fromFullAirport" path="origin"/>
	                                        <div class="error-message" style="color:red;font-size:0.85em;"></div>        
                                            <div id="fromSearch" class="searchdep position-absolute d-none"> 
                                                <div class="search-sec d-flex justify-content-start align-items-center">
                                                    <i class="fa fa-search" aria-hidden="true"></i>
                                                      <input type="search" id="fromInput" placeholder="search"> 
                                                </div>
                                                <div class="destination-name"> 
                                                    <div class="top-city mt-3">
                                                        <p class="mb-0">Top Cities</p>
                                                    </div>
                                                     <div class="airport-results"></div>
                                                    <div class="dep-name-inner d-flex justify-content-start align-items-center d-none"> 
                                                        <span> <img src="/resources/images/plane.png"> </span>
                                                        <div class="air-name-txt">
                                                            <p class="mb-0 airport-city-name"> Delhi (DEL)</p>
                                                            <p class="mb-0 airport-name">Indira Gandhi International Airport</p>
                                                        </div>
                                                    </div>
                                                    <div class="dep-name-inner d-flex justify-content-start align-items-center d-none"> 
                                                        <span> <img src="/resources/images/plane.png"> </span>
                                                        <div class="air-name-txt">
                                                            <p class="mb-0 airport-city-name"> Delhi (DEL)</p>
                                                            <p class="mb-0 airport-name">Indira Gandhi International Airport</p>
                                                        </div>
                                                    </div>
                                                      <div class="dep-name-inner d-flex justify-content-start align-items-center d-none"> 
                                                        <span> <img src="/resources/images/plane.png"> </span>
                                                        <div class="air-name-txt">
                                                            <p class="mb-0 airport-city-name"> Delhi (DEL)</p>
                                                            <p class="mb-0 airport-name">Indira Gandhi International Airport</p>
                                                        </div>
                                                    </div>
                                                      <div class="dep-name-inner d-flex justify-content-start align-items-center d-none"> 
                                                        <span> <img src="/resources/images/plane.png"> </span>
                                                        <div class="air-name-txt">
                                                            <p class="mb-0 airport-city-name"> Delhi (DEL)</p>
                                                            <p class="mb-0 airport-name">Indira Gandhi International Airport</p>
                                                        </div>
                                                    </div>
                                                      <div class="dep-name-inner d-flex justify-content-start align-items-center d-none"> 
                                                        <span> <img src="/resources/images/plane.png"> </span>
                                                        <div class="air-name-txt">
                                                            <p class="mb-0 airport-city-name"> Delhi (DEL)</p>
                                                            <p class="mb-0 airport-name">Indira Gandhi International Airport</p>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="exchange-icon exchange">
                                      <span> <img src="/resources/images/exchange.png"> </span>
                                  </div>
                                    <div class="col-lg-6 mb-2 mb-lg-0 form-group">
                                        <div class="return-main position-relative todeparture"> 
                                            <p class="mb-0 from to todeparture">To</p>
                                            <p class="mb-0 departure todeparture edtrdt">Destination </p>
                                            <p class="mb-0 search-origin tosearch-origin todeparture toairport"> Search Your Origin </p>
                                             <form:hidden id="toFullAirport" path="destination" />
                                             
                                             <div id="toSearch" class="searchdep position-absolute  d-none"> 
                                                <div class="search-sec d-flex justify-content-start align-items-center">
                                                    <i class="fa fa-search" aria-hidden="true"></i>
                                                   <input type="search" id="toInput" placeholder="search">
                                                   <div class="error-message" style="color:red;font-size:0.85em;"></div>
                                                </div>
                                                <div class="destination-name"> 
                                                    <div class="top-city mt-3">
                                                        <p class="mb-0">Top Cities</p>
                                                    </div>
                                                     <div class="airport-results"></div>
                                                    <div class="dep-name-inner d-flex justify-content-start align-items-center d-none"> 
                                                        <span> <img src="/resources/images/plane.png"> </span>
                                                        <div class="air-name-txt">
                                                            <p class="mb-0 airport-city-name"> Delhi (DEL)</p>
                                                            <p class="mb-0 airport-name">Indira Gandhi International Airport</p>
                                                        </div>
                                                    </div>
                                                    <div class="dep-name-inner d-flex justify-content-start align-items-center d-none"> 
                                                        <span> <img src="/resources/images/plane.png"> </span>
                                                        <div class="air-name-txt">
                                                            <p class="mb-0 airport-city-name"> Delhi (DEL)</p>
                                                            <p class="mb-0 airport-name">Indira Gandhi International Airport</p>
                                                        </div>
                                                    </div>
                                                      <div class="dep-name-inner d-flex justify-content-start align-items-center d-none"> 
                                                        <span> <img src="/resources/images/plane.png"> </span>
                                                        <div class="air-name-txt">
                                                            <p class="mb-0 airport-city-name"> Delhi (DEL)</p>
                                                            <p class="mb-0 airport-name">Indira Gandhi International Airport</p>
                                                        </div>
                                                    </div>
                                                      <div class="dep-name-inner d-flex justify-content-start align-items-center d-none"> 
                                                        <span> <img src="/resources/images/plane.png"> </span>
                                                        <div class="air-name-txt">
                                                            <p class="mb-0 airport-city-name"> Delhi (DEL)</p>
                                                            <p class="mb-0 airport-name">Indira Gandhi International Airport</p>
                                                        </div>
                                                    </div>
                                                      <div class="dep-name-inner d-flex justify-content-start align-items-center d-none"> 
                                                        <span> <img src="/resources/images/plane.png"> </span>
                                                        <div class="air-name-txt">
                                                            <p class="mb-0 airport-city-name"> Delhi (DEL)</p>
                                                            <p class="mb-0 airport-name">Indira Gandhi International Airport</p>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    </div>
                                   
                                </div>
                                </div>
                                <div class="col-lg-8 p-0">
                                    <div class="row w-100 mx-auto">
                                        <div class="col-6 col-lg-3 mb-2 mb-lg-0   form-group">
                                            <div class="calendar-main calendardepart" style="cursor:pointer;">
                                                <p class="from mb-0">Departure</p>
                                                 <p class="departure mb-0"><span class="dep-day">--</span> <span class="dep-month-year">----</span></p>
                                                 <p class="search-origin mb-0 dep-weekday">----</p>
                                                 <form:hidden path="departDate" id="departDate" />
                                                  <div class="error-message" style="color:red;font-size:0.85em;"></div>
                                            </div>
                                        </div>
                                        <div class="col-6 col-lg-3 mb-2 mb-lg-0  form-group" >
                                            <div class="calendar-main calendarreturn" style="cursor:pointer;">
                                                <p class="from mb-0"> Return </p>
                                                 <p class="departure mb-0"><span class="ret-day">Select</span> <span class="ret-month-year">Return</span></p>
                                                 <p class="search-origin mb-0 ret-weekday">Date</p>
                                                   <form:hidden path="returnDate" id="returnDate" />
                                                   <div class="error-message" style="color:red;font-size:0.85em;"></div>
                                                  
                                            </div>
                                        </div>
                                        <div class="col-lg-3  mb-2 mb-lg-0">
                                             <div class="calendar-main traveller  position-relative">
                                                <p class="from mb-0">Traveler(s) &amp; Class</p>
                                                  <p class="departure mb-0"><span class="total-travelers">1</span> <span>Traveler</span></p>
                                                   <p class="search-origin mb-0 selected-class">Economy</p>

                                                <div class="traveller-sec position-absolute d-none" id="travellerbox">
                                                    <div class="row w-100 m-auto">
                                                        <div class="col-6 mb-3">
                                                            <div class="adult-main">
                                                                <h5 class="mb-0"> Adult  </h5>
                                                                <p class="mb-0 plus-minus d-flex align-items-center"><button type="button" class="dec" data-type="adult">-</button> <span> <form:input path="adult" readonly="true" class="number adult" value="1" style="width: 30px; text-align: center; border: 0;" />
                                                                      </span>  <button type="button" class="inc" data-type="adult">+</button> </p>
                                                            </div>
                                                        </div>
                                                        <div class="col-6 mb-3">
                                                            <div class="adult-main">
                                                                <h5 class="mb-0"> Child <span> (2-11 Years)</span> </h5>
                                                                <p class="mb-0 plus-minus d-flex align-items-center"><button type="button" class="dec" data-type="child">-</button> <span><form:input path="child" readonly="true" class="number child" value="0" style="width: 30px; text-align: center; border: 0;" /></span>  <button type="button" class="inc" data-type="child">+</button></p>
                                                            </div>
                                                        </div>
                                                        <div class="col-6 mb-3">
                                                            <div class="adult-main">
                                                                <h5 class="mb-0"> Infant <span>lap <br>(0-2 Years)</span> </h5>
                                                                <p class="mb-0 plus-minus d-flex align-items-center"> <button type="button" class="dec" data-type="infant">-</button> <span><form:input path="infant" class="number infant" readonly="true " value="0" style="width: 30px; text-align: center; border: 0;" /></span> <button type="button" class="inc" data-type="infant">+</button> </p>
                                                            </div>
                                                        </div>
                                                        <div class="col-6 mb-3">
                                                            <div class="adult-main">
                                                                <h5 class="mb-0"> Infant  <span>Seat <br>(0-2 Years)</span> </h5>
                                                                <p class="mb-0 plus-minus d-flex align-items-center"> <button type="button" class="dec" data-type="infantWs">-</button> <span><form:input path="infantWs" class="number infantWs" readonly="true" value="0" style="width: 30px; text-align: center; border: 0;" /></span>  <button type="button" class="inc" data-type="infantWs">+</button> </p>
                                                            </div>
                                                        </div>
                                                        <hr>
                                                        <div class="col-6 mb-3"><div class="seat-class"><button type="button" data-class="Economy">Economy</button></div></div>
										                <div class="col-6 mb-3"><div class="seat-class"><button type="button" data-class="Premium Economy">Premium Economy</button></div></div>
										                <div class="col-6 mb-3"><div class="seat-class"><button type="button" data-class="Business">Business</button></div></div>
										                <div class="col-6 mb-3"><div class="seat-class"><button type="button" data-class="First">First</button></div></div>
										                <div class="col-12"><div class="submit-btn"><button type="button" id="applyTravellers">Apply</button></div></div>
										            </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-3 ">
                                            <div class="search-main h-100">
                                            <button class="h-100" type="submit"> Submit </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
               </div>
            </div>
       
            </div>

        </div>
    </div>

</div>
         
         
         </form:form>
      </section>


   <script src="/resources/js/search.js"></script>	