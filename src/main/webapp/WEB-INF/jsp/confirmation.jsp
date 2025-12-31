<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tfn" uri="/WEB-INF/tld/tfn-functions.tld" %>

<jsp:useBean id="now" class="java.util.Date" />
<fmt:formatDate value="${now}" pattern="yyyy" var="currentYear" />



<!DOCTYPE html>
<html>
    <head>
        <title>Flight Confirmation</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0">
		<link rel="icon" href="/resources/assets/img/favicons/favicon-32x32.png">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
		<style>
			.expertisetalk span {
			    display: block;
			    color: #303030;
			    font-family: Poppins;
			    font-size: 11px;
			    font-style: normal;
			    font-weight: 400;
			    line-height: normal;
			    letter-spacing: -0.33px;
			}
			.expertisetalk a {
			    text-decoration: none;
			    font-family: Poppins;
			    font-size: 20px;
			    font-style: normal;
			    font-weight: 600;
			    line-height: normal;
			    background: linear-gradient(270deg, #406BE0 0%, #163A9C 100%);
			    background-clip: text;
			    -webkit-background-clip: text;
			    -webkit-text-fill-color: transparent;
			}
			.call_icon {
			    display: none;
			}

			.mjuh{
				max-width:1100px;
				/* max-width: 945px; */
			}
			.liku{
				color:#515151;
				font-size:14px;
			}
			.lo-im{
				width:170px;
			}
			@media only screen and (max-width: 767px) {
				.lo-im{
					width:145px;
				}
			    .call_icon {
					text-align:right;
			        display: block;
			        position: absolute;
			        right: 16px;
			    }
				.home_number {
				    text-decoration: none;
				    font-size: 14px;
				    font-weight: bold;
				    background: linear-gradient(270deg, #406BE0 0%, #163A9C 100%);
				    background-clip: border-box;
				    background-clip: text;
				    -webkit-background-clip: text;
				    -webkit-text-fill-color: transparent;
				    color: #303030 !important;
				}
				.call277 {
				    color: #303030;
				    font-size: 11px !important;
				    text-align: right;
				}
				.mob-hide {
				    display: none !important;
				}
				.liku{
					font-size:10px;
				}
				
			}

			@media only screen and (max-width: 1025px) {
			    .expertisetalk {
			        width: 224px;
			        position: absolute;
			        right: 60px;
			        display: none !important;
			    }
			}
        </style>
		<body>
		<nav class="navbar navbar-expand-lg sjdhf">
  <div class="container mjuh">
   <div class="upper-logo">  <a class="navbar-brand" href="/"><img src="/resources/images/logo.png" class="lo-im" alt="Logo"></a> </div>
   <div class="call_icon">			
		<a class="home_number" href="tel:+1-111-111-1111">
		+1-111-111-1111
		</a>
		 <div class="call277"> <span class="phone">
                       <img src="https://imgfolders.com/common/cali.png" style="width: 15px;">
                        
                        </span>Call 24/7 Toll Free</div>	 
		</div>

	<div class="expertisetalk mob-hide"> 
			<div style="display: flex; align-items: center;">
			  <span class="callicon">
				<img src="https://imgfolders.com/common/call_blue.png" alt="Phone" class="me-1">
			  </span> 
			  <div>		  
				<c:set var="tollFree" value="${tfn:getTFN(utmSource, pageContext.request)}" scope="session" />
			  <a href="tel:${tollFree}" title="Call Us 24/7 for Lowest Airfares">${tollFree}</a> 
			  <span>Call Us 24/7 for Lowest Airfares </span> 
			</div>
			</div>		
		</div>
	

		
  </div>
</nav>
				
			
			${htmlResponse}
			
					<footer class="my-lg-3 my-2">
			                <div class="copy-right-bg">
						  <div class="container  mjuh">
							<div class="row ">
							  <div class="col-12 text-center">

								<p class="mb-0 liku">
									Copyright &copy; ${currentYear}, farescrew. All rights reserved.
								</p>

							  </div>
							</div>
						  </div>
						</div>
			<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
			</body>
			</head>
			</html>