<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

	<style type="text/css">

        body {
          margin: 0;
          font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol";
          font-size: 1rem;
          font-weight: 400;
          line-height: 1.5;
          color: #212529;
          text-align: left;
        }
                #mask {
                    position: fixed !important;
                    left: 0;
                    top: 0;
                    background-color: rgba(0,0,0,.75);
                    display: none;
                    height: 100% !important;
                    width: 100% !important;
                    z-index: 999;
                }
        
                #boxed .window {
                    display: none;
                    position: fixed;
                    z-index: 999999999;
                    width: 650px;
                    top: 50% !important;
                    left: 50% !important;
                    transform: translate(-50%, -50%);
                }
                
                .text-success2 {
                    color: #0b4075;
                    font-size: 20px;
                    text-transform: uppercase;
                    font-weight: 600;
                    border-bottom: solid 1px #ee372b;
                    padding-bottom: 6px;
                }
        
                .closed {
                    display: block;
                    height: 30px;
                    margin: 0 auto;
                    /*opacity: .75;*/
                    overflow: hidden;
                    position: absolute;
                    right: -18px;
                    text-indent: 0;
                    top: -10px;
                    width: 30px;
                }
                .wish12 {
                    position: absolute;
                    right: 0;
                    top: 0px;
                    z-index: 2;
                    width: 400px;
                }
        
                .content_set2 {
                    margin-top: 25px;
                    display: table;
                    width: 100%;
                }
        
                .content_bxmain {
                    height: 100%; /*calc(86vh - 80px)*/
                    background-color: #fff;
                }
        
                .content_left {
                    width: 100%;
                    float: left;
                }
        
                .content_right {
                    width: 100%;
                    float: left;
                }
        
                .visible-xs {
                    display: none !important;
                }
        
                .count-content-list {
                    padding: 10px 15px 10px;
                    color: #3b3b3b;
                }
                
                .logos {margin:0  0 12px 0; text-align: center;}
                .logos img {width: 140px; }
        
                .limit_time {
                    float: right;                    
                    text-align: right;
                }
                
                .limit_time .block-time {
                    font-size: 13px;
                    margin-bottom: 0px;
                    color: #333;
                    display: flex;
                    align-items: center;
                    justify-content: space-between;
                }
        
                .block-time .time-limited {
                        color: #333;
                    }
        
                
                .Enddeal p {
                    margin: 0px;
                }
        
                .block-time .timerr {
                    font-size: 24px;
                    font-weight: 500;
                    min-height: 23px;
                    color: #cf2a2f;
                }
        
                .fare-special {
                    margin:0 0 15px 0;
                    float:right;
                }
        
                    .price-hot {
                        font-size: 12px;
                        /*float: right;*/
                        text-align: right;
                        line-height: 2em;
                    }
        
                    .txt-special {
                        color: #404040;
                        font-size: 15px;
                        font-weight: 500;
                    }
        
                .type-tripclass {
                    font-size: 13px;
                    margin-bottom: 15px;
                    text-align: center;
                }
        
                .section-itenerary {
                    min-height: 50px;
                    line-height: 1.8em;
                    display: flex;
                    justify-content: space-between;
                }
        
                .relative {
                    position: relative;
                }
        
                .section-itenerary .arrow-trip-type {
                    border-bottom: 1px solid #404040;
                    display: block;
                    width: 50%;
                    position: absolute;
                    left: 50%;
                    top: 47%;
                    transform: translate(-50%,-50%);
                }
        
                .section-itenerary .icon-trip-type {
                    position: absolute;
                    left: 50%;
                    top: 52%;
                    transform: translate(-50%,-50%);
                    background: #fff;
                    padding: 0 5px;
                }
                
                .section-itenerary .icon-trip-type img { width: 50px;}
        
                .city-code2.right {
                    float: right;
                    text-align: right;
                }
        
                .section-itenerary .city-code2 {
                    font-size: 14px;
                    text-transform: uppercase;
                    font-weight: 500;
                    color: #404040;
                    line-height: 20px;
                }
        
                .name-city {
                    font-size: 12px;
                    font-weight: 500;
                    margin-bottom: 13px;
                    display: flex;
                    justify-content: space-between;
                }
        
                .name-city .name-return {
                        float: right;
                        /* text-align: right; */
                    }
        
                .callnow-btn a {
                    background: #f1a501;
                    color: #000;
                    padding: 10px 5px;
                    text-align: center;
                    display: block;
                    border-radius: 5px;
                    font-size: 20px;
                    margin-bottom: 5px;
                    text-decoration: none;
                    max-width: 300px;
                    width: 100%;
                    margin: 0 auto;
                }
                .callnow-btn a:hover {
                    background: #000;
					color: #f1a501;
                    
                }
        
                .txt-disclaimer {
                    color: #000;
                    text-align: center;
                    font-size: 12px;
                    padding: 10px 0;
                }
        
                .section-itenerary .city-code2 b {
                    font-size: 20px;
                    display: block;
                }
        
                .txt-special b {
                    font-size: 18px;
                    display: block;
                }
        
                .price-hot b {
                    color: #3ab54a;
                    display: block;
                    font-size: 28px;
                }
        
                /******************************************************************/
                /** RESONSIVE CSS START **/
                @media only screen and (max-width:1025px) {
                    #boxed .window {
                        display: none;
                        width: 100%;
                        left: 0 !important;
                        top: 0px !important;
                    }
        
                    #boxed {
                        display: none;
                    }
        
                    .content_bxmain {
                        width: 90%;
                        margin: 10px auto;
                    }
        
                    .content_left {
                        width: 100%;
                        float: left;
                    }
        
                    .content_right {
                        width: 100%;
                        float: left;
                    }
                }
        
                @media (max-width:767px) {
                    .hidden-xs,
                    .hide {
                        display: none !important
                    }
        
                    .visible-xs {
                        display: block !important;
                    }
        
                    .count-content-list {
                        padding: 6px 15px 0;
                    }			
                    .closed {			
                     right: 0px;			
                     top: 0px;			
                    }
        
                    .limit_time {
                        float: right;
                        position: absolute;
                        top: 38px;
                        right: 40px;
                    }
                    .logos {margin: 20px 0; text-align: left;}
                    .limit_time .block-time {
                    font-size: 12px;
                    color: #333;
                    line-height: 20px;
                    }
                    .fare-special {
                        position: absolute;
                        right: 25px;
                        margin:15px;
                    }
                    .txt-special{
                        width:50%;
                    }
                }
                .popup-ne{
                 z-index: 999999;
                }
        .gthht{
            text-align: center;
            font-size: 18px;
            font-weight: 500;
        }
            </style>
	<div id="boxed" class="hide" data-backdrop="static" data-keyboard="false">
		<div class="home-page-popup">
			<div style="display: none;" id="dialog" class="window">
				<a href="javaScript:void(0);" id="close_id" onClick="close_dilog(this.id)" class="closed">
					<img src="/resources/images/close.png" alt="cheap flight">
				</a>
				<div class="popup-dsgn-box">
					<div class="content_bxmain">						
						<div class="content_right">
							<div class="count-content-list">
								<div class="logos">
										<img src="/resources/images/logo.png" alt="logo"/>
									</div>
									<p class="gthht">Exclusive Flight Deals you won't find online.</p>

									<c:set value="${fn:split(flightSearch.origin,',')[0]}" var="deaprt1" />
									<c:set value="${fn:split(deaprt1,'-')[1]}" var="deaprt2" />
									<c:set value="${fn:split(flightSearch.destination,',')[0]}" var="return1" />
									<c:set value="${fn:split(return1,'-')[1]}" var="return2" />
										
									<c:set value="${fn:split(flightSearch.origin,',')[1]}" var="deptcountry1" />
									<c:set value="${fn:split(deptcountry1,'-')[1]}" var="deptcountry2" />
									<c:set value="${fn:split(flightSearch.destination,',')[1]}" var="retcountry1" />
									<c:set value="${fn:split(retcountry1,'-')[1]}" var="retcountry2" />
									
									<fmt:parseDate value="${flightSearch.departDate}" var="deptDateObj" pattern="MM/dd/yyyy" />
									<fmt:formatDate value="${deptDateObj}" var="deptDate" pattern="MMM dd yyyy" />
									<fmt:parseDate value="${flightSearch.returnDate}" var="retDateObj" pattern="MM/dd/yyyy" />
									<fmt:formatDate value="${retDateObj}" var="returnDate" pattern="MMM dd yyyy" />
									
									<c:set value="RoundTrip" var="tripValue" />
									<c:if test="${flightSearch.tripType=='1'}"><c:set value="OneWay" var="tripValue" /></c:if>
									<c:if test="${flightSearch.tripType=='2'}"><c:set value="RoundTrip" var="tripValue" /></c:if>
									
                                    <div style="display: flex; justify-content: space-between;">
                                       
                                            <div class="txt-special">
                                                Special fare to
                                                <b>${return2}</b>
                                            </div>
											<c:set var="minFare" value="${param.fare}" />
											
                                            <div class="fare-special">
                                                <div class="price-hot">
                                                    Special Fare
                                                    <b class="ng-binding">${minFare}</b>
                                                </div>
                                            </div>   
											
											<!--<div class="fare-special">
                                                <div class="price-hot">
                                                    Get upto
                                                    <b class="ng-binding">60% off</b>
                                                </div>
                                            </div>-->                                        
    
                                        <div class="limit_time">
                                            <div class="block-time">
                                                <div class="Enddeal">
                                                    <p>Limited Time Offer!</p>
                                                    <div class="timerr count-time Timer" id="timer"></div>
                                                    Ends in &nbsp;
                                                </div>
                                            </div>
                                        </div>
                                    </div>
								
								<div class="type-tripclass ng-binding">${tripValue}, ${flightSearch.cabin}</div>
								<div class="section-itenerary relative">
									<!--Trip arrow-->
									<div class="arrow-trip-type"> </div>
									<span class="icon-trip-type"><img src="/resources/images/round-trip.png" alt="trip"></span>
									<div class="city-code2">
										Depart<b>${fn:split(flightSearch.origin,'-')[0]}</b>
									</div>
									<div class="city-code2 right">
										<c:if test="${flightSearch.tripType=='2'}"><div>Return&nbsp;</div></c:if>
										<b>${fn:split(flightSearch.destination,'-')[0]}</b>
									</div>
									

								</div>

								<div class="name-city">
									<div class="depart-name">
										${deaprt2} (${deptcountry2}) <br> ${deptDate} 
									</div>
									<div class="name-return">
										${return2} (${retcountry2}) <c:if test="${flightSearch.tripType=='2'}"><br>${returnDate}</c:if> <br>
									</div>
								</div>

								<!--TFN Dynamic Start-->
								<div class="callnow-btn">
									<a href="tel:<c:out value='${tollFree}'/>" id="callTracker">Call Now <c:out value='${tollFree}'/></a>
								</div>
								<!--TFN Dynamic End -->
								<div class="txt-disclaimer">* Fares are subject to seat availability and not guaranteed until ticketed.</div>
								
                                <!-- <div style="display: flex; align-items: center; justify-content: center;">
                                    <img src="/resources/images/img_fourtstar.png?567" style="height: auto;" alt="Logo">
                                    <div style="padding: 0 10px;">1,214 reviews on</div>
                                    <img src="/resources/images/img_onestar.png?34434" style="height: auto;" alt="Logo">
                                    </div> -->

                                
								
							</div>
						</div>
						<div style="clear: both;"></div>
					</div>

				</div>
			</div>
			<div id="mask"></div>
		</div>
	</div>
    <div class="count-top-icon pointer uc-minimize-strip" id="reopen_ucb" onClick="close_min(this.id)" style="display: none;">
		<div class="strip-content ng-binding" style="display: flex;">
			<p style="margin: 11px;">upto 60% off* <span id="timer1" class="Timer1"></span></p>
		</div>
	</div>
	
	<script>
		$(document).ready(function() {
		    $('#boxed').hide();
		    setTimeout(function() {
		        $('#boxed').show();
		        $('#boxed .window').css('top', '-100%').animate({
		            top: '8%',
		            left: '25%'
		        }, 1000);
		    }, 15000); // 15 seconds in milliseconds
		    $('#close_id').on('click', function() {
		        $('#boxed').hide();
		    });
		    
		    $('#close_min').on('click', function() {
		        $('#boxed').show();
		    });
		    
		});
	</script>
	
	<script type="text/javascript">
		var timeoutHandle;
		function countdown(minutes, seconds) {
			function tick() {
				var counter = document.getElementById("timer");
				counter.innerHTML = minutes.toString() + "m " + (seconds < 10 ? "0" : "") + String(seconds) + "s";
				seconds--;
				if (seconds >= 0) {
					timeoutHandle = setTimeout(tick, 1000);
				} else {
					if (minutes >= 1) {
						setTimeout(function () {
							countdown(minutes - 1, 59);
						}, 1000);
					}
				}
				if (seconds <= 0 && minutes == 0) {
					document.getElementById("boxes").style.display = 'none';
                		}
			}
			tick();
		}

		countdown(15, 00);
	</script>
    <script type="text/javascript">
		var timeoutHandle1;
		function countdown1(minutes1, seconds1) {
			function tick1() {
				var counter1 = document.getElementById("timer1");
				counter1.innerHTML = minutes1.toString() + "m " + (seconds1 < 10 ? "0" : "") + String(seconds1) + "s";
				seconds1--;
				if (seconds1 >= 0) {
					timeoutHandle1 = setTimeout(tick1, 1000);
				} else {
					if (minutes1 >= 1) {
						setTimeout(function () {
							countdown1(minutes1 - 1, 59);
						}, 1000);
					}
				}
				if (seconds1 <= 0 && minutes1 == 0) {
                    			document.getElementById("reopen_ucb").style.display = 'none';
                		}
			}
			tick1();
		}
		countdown1(15, 00);
	</script>
	
	<style>

		.count-top-icon {
			position: fixed;
			bottom: 0px;
			border-radius: 3px;
			padding: 0px 10px 0 2px;
			color: #000;
            background: #f1a501;
			font-weight: 600;
			transition: width 2s;
			-webkit-transition: width 2s;
			left: 10px;
			cursor: pointer;
			z-index: 2;
		}
            .count-top-icon img {
                width: 45px !important;
				margin-top: 5px;
            }
			.count-top-icon .strip-content {
				font-size: 18px;
				text-align: left;
			}
            .count-top-icon .tel-icon {
                width: 30px !important;
				height: 30px !important;
            }
			.count-top-icon .Timer1 {
				font-size: 14px;
				font-weight: 400;
				border-left: 1px solid #fff;
				margin: 0px 0px 0px 10px;
                padding: 0 5px 0 10px;
			}

	</style>
