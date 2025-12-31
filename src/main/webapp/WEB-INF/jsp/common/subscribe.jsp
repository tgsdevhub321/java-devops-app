  <!-- ============================================-->
      <!-- <section> begin ============================-->
      <section class="pt-6">

        <div class="container">
          <div class="py-8 px-5 position-relative text-center" style="background-color: rgba(223, 215, 249, 0.199);border-radius: 129px 20px 20px 20px;">
            <div class="position-absolute start-100 top-0 translate-middle ms-md-n3 ms-n4 mt-3"> <img src="/resources/assets/img/cta/send.png" style="max-width:70px;" alt="send icon" /></div>
            <div class="position-absolute end-0 top-0 z-index--1"> <img src="/resources/assets/img/cta/shape-bg2.png" width="264" alt="cta shape" /></div>
            <div class="position-absolute start-0 bottom-0 ms-3 z-index--1 d-none d-sm-block"> <img src="/resources/assets/img/cta/shape-bg1.png" style="max-width: 340px;" alt="cta shape" /></div>
            <div class="row justify-content-center">
              <div class="col-lg-8 col-md-10">
                <h2 class="text-secondary lh-1-7 mb-7">Subscribe to get information, latest news and other interesting offers about Cobham</h2>
				<form class="row g-3 align-items-center w-lg-75 mx-auto newsletter-form">
				  <div class="col-sm">
				      <div class="input-group-icon">
				        <input id="newsletterEmail" class="form-control form-little-squirrel-control"
				               type="email" placeholder="Enter email" aria-label="email" />
				        <img class="input-box-icon" src="/resources/assets/img/cta/email.png" width="17" alt="mail" />
				      </div>
				  </div>

				  <div class="col-sm-auto">
				    <button class="btn btn-danger orange-gradient-btn fs--1">Subscribe</button>
				  </div>
				  
				  <small id="emailError" class="mt-1" style="color:red; display:none;">
				    Please enter a valid email
				  </small>

				  <small id="emailSuccess" class="mt-1" style="color:green; display:none;">
				    Subscribed successfully!
				  </small>
				</form>
              </div>
            </div>
          </div>
        </div><!-- end of .container-->

      </section>
      <!-- <section> close ============================-->
      <!-- ============================================-->
	  <script>
	  document.querySelector(".newsletter-form").addEventListener("submit", function (e) {
	      e.preventDefault();

	      const emailInput = document.getElementById("newsletterEmail");
	      const email = emailInput.value.trim();

	      const errorMsg = document.getElementById("emailError");
	      const successMsg = document.getElementById("emailSuccess");

	      // Reset messages
	      errorMsg.style.display = "none";
	      successMsg.style.display = "none";

	      // Email validation regex
	      const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

	      if (!emailPattern.test(email)) {
	          errorMsg.style.display = "block";
	          errorMsg.textContent = "Please enter a valid email";
	          return;
	      }

	      // Payload
	      const data = { emailId: email };

	      // AJAX call
	      fetch("/newsletter/submit", {
	          method: "POST",
	          headers: { "Content-Type": "application/json" },
	          body: JSON.stringify(data)
	      })
	      .then(res => res.text())
	      .then(response => {
	          successMsg.style.display = "block";
	          successMsg.textContent = "Subscribed successfully!";
	          emailInput.value = ""; // clear input field
	      })
	      .catch(err => {
	          errorMsg.style.display = "block";
	          errorMsg.textContent = "Something went wrong. Try again.";
	      });
	  });
	  </script>

