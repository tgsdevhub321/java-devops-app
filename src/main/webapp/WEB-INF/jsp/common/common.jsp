 
        <!-- ===============================================-->
    <!--    Favicons-->
    <!-- ===============================================-->
    <link rel="icon" type="image/png" sizes="32x32" href="/resources/assets/img/favicons/favicon-32x32.png">
    <meta name="theme-color" content="#ffffff">
 
  <!-- ===============================================-->
    <!--    Stylesheets-->
    <!-- ===============================================-->
    <link href="/resources/assets/css/theme.css" rel="stylesheet" />
   
<!-- Flatpickr (if using Flatpickr for datepickers) -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
<script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">


<style>
    .fixed-header {
    position: fixed;
    top:0px;
    left: 0;
    box-shadow: none;
}

  nav.backdrop {
    background-color:  white   !important;   /* Apna desired background color */
    backdrop-filter: none !important;    /* Agar blur aa raha ho */
    box-shadow: rgba(149, 157, 165, 0.2) 0px 8px 24px !important;
}
.frfe {
		padding-top: 6rem;

		.ab-headd {
			color: #f1a501;
			height: 100px;
			width: 100%;
			display: flex;
			text-align: center;
			align-items: center;
			justify-content: center;
			font-size: 50px;
			text-shadow: 1px 2px 2px #222;

			span {
				z-index: 99;
			}
		}

		.hrgr {
			box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;
			padding: 30px 15px;
			border-radius: 16px;
			background-color: #fff1d7;
			color: #3e3d3d;
		}
	}

	@media (min-width:360px) and (max-width:768px) {
		.frfe {
			padding-top: 0rem;

			.ab-headd {
				font-size: 30px;

				span {
					z-index: 99;
				}
			}

			.hrgr {
				padding: 20px 15px;
			}
		}
		.fixed-header{
			position: inherit;
		}
	}

</style>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>