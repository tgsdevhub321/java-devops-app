<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>	
<html>
<head>
    <title>Contact Us</title>
    <link rel="stylesheet" href="/resources/css/default.css?v=2.7">
	<link rel="stylesheet" href="/resources/css/bootstrap.min.css" type="text/css" />
    <link rel="stylesheet" href="/resources/css/font/bootstrap-icons.css" type="text/css">
    <link rel="stylesheet" href="/resources/css/home/main-style.css" type="text/css" />
	<link rel="stylesheet" href="/resources/css/new/header-style.css" type="text/css" />
    <link rel="stylesheet" href="/resources/css/new/footer-style.css" type="text/css" />
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Lato&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Mukta:200,300,400,500,600,700,800&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="icon" href="/resources/assets/img/favicons/favicon-32x32.png">

	
	<script src="/resources/js/jquery-1.11.1.min.js"></script>
    <script src="/resources/js/jquery.validate.min.js"></script>
    <style>
        .ee-navbar-items li:nth-child(1) a::after{transform:scaleX(1);}
		.error{border: 1px solid red !important;}
	</style>
<jsp:include page="tag-manager-head.jsp" />

<jsp:include page="common/common.jsp" />
	<style>
		
@media screen and (max-width:768px) {
		.rgr{
			width: 100%;
		}
		.maffp{
	height: 150px;
}
	}
		.bg-holder {
    min-height: 500px !important;
	height: 500px !important;
}

</style>
</head>

<body>

<%  
    String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXTZabcdefghiklmnopqrstuvwxyz";
    StringBuffer sb = new StringBuffer();  
    for (int i = 1; i <= 6; i++) {
        int randomIndex = (int) (Math.random() * chars.length());
        sb.append(chars.charAt(randomIndex));
    }
    String cap = sb.toString();
%>


   <jsp:include page="tag-manager-body.jsp" /> 
	<!--Header Area Starts Here-->
   <!--   header container  -->
      <jsp:include page="common/header.jsp" /> 
  <!--   header container  -->
  <section id="booking" class="frfe">
	<div class="bg-holder" style="background-image:url(/resources/assets/img/hero/herobg.png);">
	</div>
	<div class="ab-headd">
		<span>Contact Us</span>
	</div>
	<div class="container">	
		<div class="hrgr">
			<div class="contactus">
				<div class="contact-details">
					<h3>Contact Us </h3>
					<span><i class="fa fa-map-marker"></i> &nbsp; ${websiteAddress}  </span>
					<span><i class="fa fa-envelope"></i> &nbsp;<a href="mailto:support@farescrew.com">${websiteEmail}</a></span>
					<span><i class="fa fa-phone"></i> &nbsp;<a href="tel:+1-888-805-5267">${homePageTfn}</a></span>			
				   
					<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3047.882827990874!2d-73.94429532411289!3d40.62617264286572!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x89c244abf8309863%3A0x1d34cce2d7e3fbe3!2s1145%20E%2035th%20St%2C%20Brooklyn%2C%20NY%2011210%2C%20USA!5e1!3m2!1sen!2sin!4v1765527832011!5m2!1sen!2sin" width="100%" height="450" style="border:0;" class="maffp" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
					<br>
					<br>
				</div>
				<div class="contact-form">
					<h3>Get in Touch with Us </h3>
					
					<form:form modelAttribute="contactForm" action="/contactus/submit" method="post" id="contactForm" onsubmit="return validation()">
					
						<div class="flname">
							<div><label>First Name</label><br>
							<form:input type="text" path="firstName" oninput="this.value = this.value.replace(/[^a-zA-Z\s\-_]/g, '')" class="textOnly" /></div>
							<div><label>Last Name</label><br><form:input type="text" path="lastName" oninput="this.value = this.value.replace(/[^a-zA-Z\s\-_]/g, '')" class="textOnly" /></div>
						</div>
						<div class="phonemail">
							<div><label>Phone No.</label><br><form:input type="text" path="phone" oninput="this.value = this.value.replace(/[^0-9]/g, '')" class="numbersOnly" /></div>
							<div><label>Email</label><br><form:input type="text" path="email" /></div>
						</div>
						<div class="comment">
							<label>Your Comment</label>
							<form:textarea path="message"></form:textarea>
						</div>
						
						<div class="flname">
							<div>
								<form:input type="text" path="capchaCode" />
							</div>
							<div style="background-color: #ffefef;width: 45%;text-align: center;height: 36px;">
								<h2 style="font-size: 28px;"><s><i><font face="casteller"><%= cap %></font></i></s></h2>
								<form:input type="hidden" path="matCapchaCode" value="<%= cap %>" readonly="readonly" />
							</div>
						</div>
						<div id="divSubmit" class="submit-form">
							<button type="submit">Submit</button>
						</div>
						<div id="loader" style="display: none;">
							<img src="/resources/images/loader.gif" alt="Loading..." style="width: 30px;"/>
						</div>
					   
					</form:form>
					<div id="reviewSuccess"></div>
				</div>
			</div>
		</div>
	</div>
</section>   
    
    <!--Footer Starts-->
    <footer>
    	 <jsp:include page="common/footer.jsp" /> 
  	</footer>
	
</body>
<script src="vendors/@popperjs/popper.min.js"></script>
<script src="vendors/bootstrap/bootstrap.min.js"></script>
<script src="vendors/is/is.min.js"></script>
<script src="https://polyfill.io/v3/polyfill.min.js?features=window.scroll"></script>
<script src="vendors/fontawesome/all.min.js"></script>
<script src="/resources/assets/js/theme.js"></script>
<script>
$('.numbersOnly').keyup(function () {
        	    if (this.value != this.value.replace(/[^0-9\.]/g, '')) {
        	       this.value = this.value.replace(/[^0-9\.]/g, '');
        	    }
        	});
$('.textOnly').keyup(function () {
        		  if (this.value != this.value.replace(/[^a-zA-Z ]+/g, '')) {
        		       this.value = this.value.replace(/[^a-zA-Z ]+/g, '');
        		    }
        	});			
$("#contactForm").validate({
		 rules:{
			 firstName : {
				 required : true
			 },
			 lastName :{
				 required : true
			 },
			 email :{
				 required : true,
				 email : true
			 },
			 phone :{
				 required : true
			 },
			 message :{
				 required : true
			 }
			 ,
			 capchaCode :{
				 required : true
			 }
		 },
		  errorPlacement: function(error, element) {   },
		   submitHandler: function(form) {
					var data = {
							firstName: $("#firstName").val(),
							lastName: $("#lastName").val(),
							email : $("#email").val(),
							phone : $("#phone").val(),
							message : $("#message").val(),
							capchaCode : $("#capchaCode").val(),
							matCapchaCode : $("#matCapchaCode").val()
							
								}
							$.ajax({
								url: '/contactus/submit',
								type: 'post',
								contentType: 'application/json; charset=utf-8',
								data: JSON.stringify(data),
								dataType: "text",
								beforeSend: function() {
							        $("#loader").show();
							        $("#divSubmit").hide();
							        $("#reviewSuccess").text("");
							    },
								success: function(response) {
									//alert(response)
									$("#loader").hide();
									$("#divSubmit").show();
									if(response == 'true')
									{
										$("#reviewSuccess").text("Contact Query Submit Successfully!").css("color", "green");
										$("#firstName").val('');
										$("#lastName").val('');
										$("#email").val('');
										$("#phone").val('');
										$("#message").val('');
										$("#capchaCode").val('');
									}
									else if(response == 'FName')
									$("#reviewSuccess").text("First Name can not be blank!").css("color", "red");
									else if(response == 'LName')
									$("#reviewSuccess").text("Last Name can not be blank!").css("color", "red");
									else if(response == 'MobName')
									$("#reviewSuccess").text("Mobile Number can not be blank!").css("color", "red");
									else if(response == 'EmlName')
									$("#reviewSuccess").text("Email Id can not be blank!").css("color", "red");
									else if(response == 'CmtName')
									$("#reviewSuccess").text("Comment can not be blank!").css("color", "red");
									else if(response == 'capError')
									$("#reviewSuccess").text("Incorrect CAPTCHA. Please try again!").css("color", "red");
									else
									$("#reviewSuccess").text("Some Technical Issue Please try later!").css("color", "red");	
								}
							});
							
				
		  }
	 })
	 
</script> 
</html>