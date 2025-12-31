<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.text.SimpleDateFormat,java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ taglib prefix="deal" uri="/WEB-INF/tld/generic-deals.tld" %>

<%@ page import="java.time.ZonedDateTime" %>
<%@ page import="java.time.ZoneId" %>

<% 
		DateTimeFormatter disclamerDateFormat = DateTimeFormatter.ofPattern("MMM dd, yyyy");
   		LocalDate currentDate = LocalDate.now();
   		LocalDate before1day = currentDate.minusDays(1);
   		
        ZonedDateTime currentTimeEST = ZonedDateTime.now(ZoneId.of("America/New_York"));
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a z");
        String formattedTime = currentTimeEST.format(timeFormatter);
%>
<c:set var="prefix" value="${param.prefix}" />
<c:set var="pageValue" value="${param.pageValue}" />
<c:set var="currency" value="${param.currency}" />
<c:set var="limit" value="${param.limit}" />

<c:set var="dealResponse" value="${deal:getDeals(prefix, pageValue, currency, limit, pageContext.request)}" scope="session" />
   <!-- ${dealResponse}-->

<div class="cheap-flight-deals mt-md-4">
            <div class="container">
                <div class="row">
                    <div class="col-12 mb-4">
                        <div class="raw-destination">
                            <h3> Cheap Flight Deals </h3>
                           <p class="mb-0 provide"> Farescrew provides you with some incredible deals on airfares, which results in upgrading your overall travel experience. These deals are exclusive and are for a limited period only. So, don't wait any longer, grab them now!</p>
                        </div>
                    </div>
                    <c:if test="${dealResponse.size() > 0}">
                    
                    <c:forEach var="deal" items="${dealResponse}" varStatus="status">
                    
                    <div class="col-12 col-md-6 col-lg-4 mb-3 mb-md-4 deal-card">
					        <div class="cheap-dep-main">
					            <!-- Deal Content -->
					            
                    	<fmt:parseDate value="${deal.departureDate}" var="dDateObject" pattern="yyyy-MM-dd"/>
                    	<fmt:parseDate value="${deal.arrivalDate}" var="rDateObject" pattern="yyyy-MM-dd"/>
                    	<fmt:formatDate value="${dDateObject}" var="dddate" pattern="dd MMM yyyy"/>
                    	<fmt:formatDate value="${rDateObject}" var="rrdate" pattern="dd MMM yyyy"/>
                    				
                    	<a href="javascript:void(0);" onclick="SearchAirlineDeals('${deal.fromCity}','${deal.toCity}','${dddate}','${rrdate}','${deal.tripType}')">
						
					    <div class="row align-items-center py-2">
					                <!-- Top Date Row -->
					                
					                <c:set var="departureDateStr" value="${deal.departureDate}" />
								    <c:set var="arrivalDateStr" value="${deal.arrivalDate}" />
								
								    <%
								        String depDateStr = (String) pageContext.getAttribute("departureDateStr");
								        String arrDateStr = (String) pageContext.getAttribute("arrivalDateStr");
								
								        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
								        SimpleDateFormat monthDayFormat = new SimpleDateFormat("MMM d");
								        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
								
								        String depFormatted = "";
								        String arrFormatted = "";
								        String yearFormatted = "";
								
								        try {
								            if(depDateStr != null && !depDateStr.trim().isEmpty() && arrDateStr != null && !arrDateStr.trim().isEmpty()) {
								                Date depDate = inputFormat.parse(depDateStr);
								                Date arrDate = inputFormat.parse(arrDateStr);
								
								                depFormatted = monthDayFormat.format(depDate);
								                arrFormatted = monthDayFormat.format(arrDate);
								                yearFormatted = yearFormat.format(depDate); 
								            }
								        } catch (Exception e) {
								            depFormatted = depDateStr != null ? depDateStr : "";
								            arrFormatted = arrDateStr != null ? arrDateStr : "";
								            yearFormatted = "";
								        }
								    %>
					                
					                <div class="col-7 col-md-12">
					                    <div class="cheap-date">
					                        <c:choose>
											    <c:when test="${deal.tripType == 'OW'}">
											        <p class="mb-0 mb-lg-2"><%= depFormatted %><%= yearFormatted.isEmpty() ? "" : ", " + yearFormatted %></p>
											    </c:when>
											    <c:otherwise>
											        <p class="mb-0 mb-lg-2"><%= depFormatted %> - <%= arrFormatted %><%= yearFormatted.isEmpty() ? "" : ", " + yearFormatted %></p>
											    </c:otherwise>
											</c:choose>
										</div>
					                </div>
					
					                <!-- Main Info -->
					                <div class="col-12 col-md-8 mt-2">
					                    <div class="row">
					                        <div class="col-3">
					                            <div class="cfd-left">
					                                <p class="xyz mb-0">${deal.fromCity}</p>
					                                <p class="toronto mb-0">${deal.froCityname}</p>
					                            </div>
					                        </div>
					                        <div class="col-6">
					                            <div class="hr59w6">
					                                <img class="hr59w7" src="/resources/images/homepage/roundway.png" alt="">
					                                <p class="mb-0 pt-2 hr59w5">
					                                    ${deal.tripType == 'OW' ? 'One Way' : 'Round Trip'} 
					                                </p>
					                            </div>
					                        </div>
					                        <div class="col-3">
					                            <div class="cfd-left">
					                                <p class="xyz mb-0">${deal.toCity}</p>
					                                <p class="toronto mb-0">${deal.toCityname}</p>
					                            </div>
					                        </div>
					                    </div>
					                </div>
					
					                <!-- Price -->
					                
									<div class="col-5 col-md-4 mt-md-2">
									    <fmt:formatNumber value="${deal.price}" type="number" minFractionDigits="2" maxFractionDigits="2" var="formattedPrice"/>
									    <c:set var="priceParts" value="${fn:split(formattedPrice, '.')}"/>

									    <p class="mb-0 hr59w4 text-end">
									        $${priceParts[0]}<sup>.${priceParts[1]}*</sup>
									    </p>
									</div>
					               
					            </div>
					            
					        </div>
					         </a>
					    </div>
					    
					</c:forEach>
                    
                    
                    <!-- <div class="col-12 mb-3">
					    <div class="view-btn w-100 text-center">
					        <a href="#" class="w-100">
					            <span class="more"> View More </span>
					            <span class="less d-none"> View Less</span>
					        </a>
					    </div>
					</div> -->
                    
                    <div class="col-12">
                        <div class="fares-txt">
                            <p class="mb-0"> *All fares are quoted in USD. *All fares above were last found on: <span><%= before1day.format(disclamerDateFormat) %> at <%= formattedTime %></span> Fares are round trip/ one-way. Fares incl. all fuel surcharges, <span><a href="/taxes-and-fees" target="_blank">taxes & fees</a></span> and our <span>service fees</span>. Displayed fares are based on historical data, are subject to change and cannot be guaranteed at the time of booking. See all booking <span><a href="/terms-and-conditions" target="_blank">terms and conditions.</a></span></p>
                        </div>
                    </div>
                   </c:if>
                </div>
            </div>
        </div>