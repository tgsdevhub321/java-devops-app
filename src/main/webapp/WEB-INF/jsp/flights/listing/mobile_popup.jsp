<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<style>
  
  #bgfade {
    position: fixed !important;
    left: 0;
    top: 0;
    background: rgba(0,0,0,.5);
    display: none;
    height: 100% !important;
    width: 100% !important;
    z-index: 999;
  }
  
  #mobile-boxes .window-pop {
      display: none;
      position: fixed;
      max-width: 400px;
      width: 100%;
      top: 50% !important;
      left: 50% !important;
      transform: translate(-50%, -50%);
      z-index: 10002;
      color: #000;
      line-height: 30px; 
      font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
  }
  
  .close-up {
    display: block;
    height: 30px;
    margin: 0 auto;
    opacity: .75;
    overflow: hidden;
    position: absolute;
    right: -4px;
    text-indent: 0;
    top: 5px;
    width: 30px;
  }
  
  .content_bx {  
    background-color: #fff;
    max-height: 300px;
    padding: 10px;
    border-radius: 20px 20px 0px 0px;
  }
  
  .visible-xs {
    display: none !important;
  }
  
  #mobile-boxes {
    display: none;
  }
  
  @media only screen and (max-width:1025px) {
    #mobile-boxes {
      display: block;
  }
  
  #mobile-boxes .window-pop {
      display: none;
      position: fixed;
      max-width: 400px;
      width: 100%;    
      left: 50% !important;
      top: 68% !important;
      transform: translate(-50%, -68%,);
      background: #fff;
      z-index: 1000;
      color: #000;
      max-height: 0px;
      font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;  
    }	
  
    .close-up {
    display: block;
    height: 30px;
    margin: 0 auto;
    opacity: .75;
    overflow: hidden;
    position: absolute;
    right: -5px !important;				
    top: 5px !important;
    text-indent: 0;
    width: 30px;
    }
   
  }
  </style>
  
  <div id="mobile-boxes">
      <div class="home-page-popup">
          <div id="mbl-dialog" class="window-pop">
              
              <a href="javascript:void(0);" id="close_iti_id" class="close-up"><img src="/resources/images/close.png" alt="img-close"></a>
              <div class="popup-dsgn-box">
                  <div class="content_bx">	
                          <div style="margin: 0 auto; width: 118px;"><img src="/resources/images/Newpopup.png" alt="cheap flight"></div>					
                          <div style="text-align: center;">								
                          <h2 style="margin-bottom: 0;">Hurry! Book the Flight Now</h2>
              		  <p style="margin-top: 0px;margin-bottom: 0;">This route has the maximum number of People Searching. Reserve right now!</p>	
			  <h2 style="margin-bottom: 0;"><a style="text-decoration: none; color: #0a2d72;" href="tel:<c:out value='${tollFree}'/>"><c:out value='${tollFree}'/></a></h2>		
                          </div>	
                  <div style="clear: both;"></div>
                  </div>
                  
              </div>
          </div>
          <div id="bgfade"></div>
      </div>
  </div>
  
<c:set var="tval" value="${flightSearch.tripType}" scope="request" />
<c:set var="smval" value="${websiteName}" scope="request" />
<c:set var="umval" value="${flightRequest.source}" scope="request" />
<c:set var="adval" value="${flightRequest.adults}" scope="request" />
<c:set var="chval" value="${flightRequest.child}" scope="request" />
<c:set var="ival" value="${flightRequest.infants}" scope="request" />
<c:set var="iwval" value="${flightRequest.infantsWs}" scope="request" />
<c:set var="clsval" value="1" scope="request" />
<c:choose>
	<c:when test="${flightSearch.cabin=='Economy'}"><c:set var="clsval" value="E" scope="request" /></c:when>
	<c:when test="${flightSearch.cabin=='PremiumEconomy'}"><c:set var="clsval" value="P" scope="request" /></c:when>
	<c:when test="${flightSearch.cabin=='Business'}"><c:set var="clsval" value="B" scope="request" /></c:when>
	<c:when test="${flightSearch.cabin=='First'}"><c:set var="clsval" value="F" scope="request" /></c:when>
</c:choose>

<c:set value="${fn:split(flightSearch.origin,',')[0]}" var="depval" />	
<c:set value="${fn:split(flightSearch.destination,',')[0]}" var="retval" />							
<c:set var="org" value="${fn:split(depval,'-')[0]}" scope="request" />
<c:set var="dest" value="${fn:split(retval,'-')[0]}" scope="request" />
<c:set var="depDate" value="${flightSearch.departDate}" scope="request" />
<c:if test="${flightSearch.tripType=='2'}"><c:set var="retDate" value="${flightSearch.returnDate}" scope="request" /></c:if>

<c:set var="url" value="https://www.fareslist.com/searchFlight/?org=${org}&des=${dest}&dDate=${depDate}&rDate=${retDate}&trip=${tval}&adt=${adval}&chd=${chval}&inf=${ival}&infWs=${iwval}&cls=${clsval}&sid=2&utm_source=${smval}" scope="request" />


<script type="text/javascript">
    $(document).ready(function() {
        $('.close-popup,.close-popups').on('click', function(e) {
            hidePopup();
        });
    });
    
    var popFlag = localStorage.getItem("popupShown") || "false";
    var lastVisitedURL = localStorage.getItem("lastVisitedURL") || "";
	
    function showPopup() {
        popFlag = "true";
        $('#mbl-dialog').css('display', 'block');
        $('#bgfade').css('display', 'block');
        var id = '#dialog';
        var maskHeight = $(document).height();
        var maskWidth = $(window).width();
        $('#mask').css({
            'width': maskWidth, 'height': maskHeight
        });
        $('#mask').fadeIn(1000);
        $('#mask').fadeTo("slow", 0.8);
        var winH = $(window).height();
        var winW = $(window).width();
        $(id).css('top', winH / 2 - $(id).height() / 2);
        $(id).css('left', winW / 2 - $(id).width() / 2);
        $(id).fadeIn(2000);
        localStorage.setItem("popupShown", popFlag);
        localStorage.setItem("lastVisitedURL", window.location.href);
    }
	
    	function hidePopup() {
        	$('#mbl-dialog').fadeOut(500);
    		$('#bgfade').fadeOut(500);
	    	setTimeout(function() {
	        	var dialog = document.getElementById('mbl-dialog');
	        	var mask = document.getElementById('bgfade');
	        	dialog.style.display = 'none';
	        	mask.style.display = 'none';
	        	dialog.style.setProperty('display', 'none', 'important');
	        	mask.style.setProperty('display', 'none', 'important');
	    	}, 200);
    	}
	
	function handleRedirection() {
	 	hidePopup();
        	setTimeout(function() {
        		window.open(window.location.href, '_blank');
        		window.open('${url}', '_self');
        	}, 200);
    	}
    
    	window.onload = function() {
        	var currentURL = window.location.href;
        	if (!popFlag || popFlag === "false" || lastVisitedURL !== currentURL) {
            		showPopup();
        	} else {
            		hidePopup();
        	}
    	}
    	
    	$('#close_iti_id,#close_iti_id_dn').on('click', function() {
        	hidePopup();
            	handleRedirection();
    	});
    
</script>  