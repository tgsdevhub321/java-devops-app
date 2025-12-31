// Register all search pairs here
const searchGroups = [
    { triggers: ".fromairport, .fromdeparture, .fromsearch-origin", box: "#fromSearch" },
    { triggers: ".to, .todeparture, .tosearch-origin", box: "#toSearch" },
    { triggers: ".traveller, .traveller, .traveller", box: "#travellerbox" }
];


function initSearchToggles(groups) {
    const boxes = groups.map(g => document.querySelector(g.box));

    groups.forEach(group => {
        const triggers = document.querySelectorAll(group.triggers);
        const targetBox = document.querySelector(group.box);

        triggers.forEach(trigger => {
            trigger.addEventListener("click", (e) => {

                e.stopPropagation();

                // Hide all boxes
                boxes.forEach(b => b.classList.add("d-none"));

                // Show current box
                targetBox.classList.remove("d-none");

                // 🟢 Put cursor in the input field
                const input = targetBox.querySelector("input[type='search']");
                 if (input) {
				        input.value = "";     // ✅ clear old value
				        input.focus();        // ✅ focus every time
				    }

                /*if (input) {
                    setTimeout(() => input.focus(), 10); 
                }*/
            });
        });
    });

    // Hide all when clicking outside
   document.addEventListener("click", (e) => {
    boxes.forEach(b => {
        if (!b.contains(e.target)) {
            b.classList.add("d-none");
        }
    });
});

}

// Init
initSearchToggles(searchGroups);

//Airport  

let airportCache = {};

function setupAirportSearch(inputSelector, resultsSelector, codePSelector, fullPSelector, hiddenSelector, searchBoxSelector) {
    const input = document.querySelector(inputSelector);
    const resultsBox = document.querySelector(resultsSelector);
    const codeP = document.querySelector(codePSelector);
    const fullP = document.querySelector(fullPSelector);
    const hiddenInput = document.querySelector(hiddenSelector);
    const searchBox = document.querySelector(searchBoxSelector);

    let activeIndex = -1;
    let currentResults = [];
    let typingTimer;

    input.addEventListener("keyup", function(e) {
        const query = input.value.trim();

        if (["ArrowDown", "ArrowUp", "Enter"].includes(e.key)) {
            handleKeyboardNav(e.key);
            return;
        }

        if (query.length < 2) {
            resultsBox.innerHTML = "";
            return;
        }

        clearTimeout(typingTimer);
        typingTimer = setTimeout(() => {
            fetchAirportList(query);
        }, 250);
    });

    function fetchAirportList(query) {
        if (airportCache[query]) {
            renderResults(airportCache[query], query);
            return;
        }

        resultsBox.innerHTML = `<p class='p-2 text-muted'>Searching...</p>`;

        fetch(`/getAirprotList/${query}`)
            .then(res => res.json())
            .then(data => {
                airportCache[query] = data;
                renderResults(data, query);
            })
            .catch(() => {
                resultsBox.innerHTML = `<p class='p-2 text-danger'>Error loading data</p>`;
            });
    }

    function renderResults(data, query) {
        resultsBox.innerHTML = "";
        currentResults = [];

        if (!data || data.length === 0) {
            resultsBox.innerHTML = `<p class='p-2 text-muted'>No results found</p>`;
            return;
        }

        data.forEach((raw, index) => {
            const parsed = parseAirportString(raw);
            currentResults.push(parsed);

            const div = document.createElement("div");
            div.className = "dep-name-inner d-flex justify-content-start align-items-center";
            div.dataset.index = index;

            div.innerHTML = `
                <span><img src="resources/images/plane.png"></span>
                <div class="air-name-txt">
                    <p class="mb-0 airport-city-name">${highlight(parsed.city + " (" + parsed.code + ")", query)}</p>
                    <p class="mb-0 airport-name">${highlight(parsed.airportName, query)}</p>
                </div>
            `;

           // div.addEventListener("click", () => selectAirport(parsed));
            div.addEventListener("click", (e) => {
			    e.stopPropagation();      // 🔥 KEY LINE
			    selectAirport(parsed);
			});

            resultsBox.appendChild(div);
        });
    }

    function highlight(text, query) {
        const reg = new RegExp(query, "gi");
        return text.replace(reg, match => `<mark>${match}</mark>`);
    }

    function handleKeyboardNav(key) {
        if (currentResults.length === 0) return;

        const items = Array.from(resultsBox.children);

        if (key === "ArrowDown") {
            activeIndex = (activeIndex + 1) % items.length;
        } else if (key === "ArrowUp") {
            activeIndex = (activeIndex - 1 + items.length) % items.length;
        } else if (key === "Enter") {
            if (activeIndex >= 0) {
                selectAirport(currentResults[activeIndex]);
                searchBox.classList.add("d-none");
            }
            return;
        }

        items.forEach((el, i) => el.classList.toggle("active", i === activeIndex));
    }

    function selectAirport(parsed) {
        console.log("selectAirport called", parsed);

        codeP.innerText = parsed.code;
        fullP.innerText = parsed.fullValue;
        hiddenInput.value = parsed.fullValue;

        resultsBox.innerHTML = "";


        activeIndex = -1;

        console.log("Hiding search box", searchBox);
        searchBox.classList.add("d-none"); // Hide dropdown
        //searchBox.style.display = "none";
        //input.value = "";
        document.body.click();

    }

}

// Parse airport string
function parseAirportString(raw) {
    const fullValue = raw;
    const firstDash = raw.indexOf("-");
    const lastDash = raw.lastIndexOf("-");
    const comma = raw.indexOf(",");

    const code = raw.substring(0, firstDash).trim();
    const city = raw.substring(firstDash + 1, comma).trim();
    const airportName = raw.substring(comma + 1, lastDash).trim();
    const country = raw.substring(lastDash + 1).trim();

    return { code, city, airportName, country, fullValue };
}

document.addEventListener('click', (e) => {
    const fromSearch = document.querySelector("#fromSearch");
    const toSearch = document.querySelector("#toSearch");
    const fromInput = document.querySelector("#fromInput");
    const toInput = document.querySelector("#toInput");

    if (!fromSearch.contains(e.target) && e.target !== fromInput) {
        fromSearch.classList.add("d-none");
    }

    if (!toSearch.contains(e.target) && e.target !== toInput) {
        toSearch.classList.add("d-none");
    }
});
setupAirportSearch(
	    "#fromInput",
	    "#fromSearch .airport-results",
	    ".departure.fromairport",
	    ".search-origin.fromairport",
	    "#fromFullAirport",
	    "#fromSearch"  // Must be exactly matching your dropdown container ID
	);

	setupAirportSearch(
	    "#toInput",
	    "#toSearch .airport-results",
	    ".departure.todeparture",
	    ".tosearch-origin.toairport",
	    "#toFullAirport",
	    "#toSearch"   // Ditto
	);
	
	
	function formatDate_MMDDYYYY(date) {
	    const mm = String(date.getMonth() + 1).padStart(2, "0");
	    const dd = String(date.getDate()).padStart(2, "0");
	    const yyyy = date.getFullYear();
	    return mm + "/" + dd + "/" + yyyy;
	}
	//handle date pickers
	
	document.addEventListener("DOMContentLoaded", () => {
		  const tripTypeRadios = document.querySelectorAll('input[name="round1"]');
		  const returnCalendar = document.querySelector(".calendarreturn");

		  const departDateHidden = document.getElementById("departDate");
		  const returnDateHidden = document.getElementById("returnDate");

		  const depDay = document.querySelector(".dep-day");
		  const depMonthYear = document.querySelector(".dep-month-year");
		  const depWeekday = document.querySelector(".dep-weekday");

		  const retDay = document.querySelector(".ret-day");
		  const retMonthYear = document.querySelector(".ret-month-year");
		  const retWeekday = document.querySelector(".ret-weekday");

		  const today = new Date();

		  function formatDateParts(date) {
		    const day = date.getDate();
		    const monthNames = ["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];
		    const month = monthNames[date.getMonth()];
		    const year = date.getFullYear();
		    const weekdayNames = ["Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"];
		    const weekday = weekdayNames[date.getDay()];
		    return { day, month, year, weekday };
		  }

		  function updateDepartureDisplay(date) {
		    const { day, month, year, weekday } = formatDateParts(date);
		    depDay.textContent = day;
		    depMonthYear.textContent = `${month} ${year}`;
		    depWeekday.textContent = weekday;
		    departDateHidden.value = formatDate_MMDDYYYY(date);
		  }

		  function updateReturnDisplay(date) {
		    if (!date) {
		      retDay.textContent = "Select Return";
		      retMonthYear.textContent = "";
		      retWeekday.textContent = "Date";
		      returnDateHidden.value = "";
		      return;
		    }
		    const { day, month, year, weekday } = formatDateParts(date);
		    retDay.textContent = day;
		    retMonthYear.textContent = `${month} ${year}`;
		    retWeekday.textContent = weekday;
		    returnDateHidden.value = formatDate_MMDDYYYY(date);

		  }

		  const departFlatpickr = flatpickr(".calendardepart", {
		    defaultDate: today,
		    minDate: today,
		    dateFormat: "Y-m-d",
		    disableMobile: true, 
		    onChange: function(selectedDates) {
		      const selected = selectedDates[0];
		      updateDepartureDisplay(selected);

		      // set min date for return
		      returnFlatpickr.set("minDate", selected);
		      returnFlatpickr.jumpToDate(selected);
		      // auto open return for round trip
		      if (document.querySelector('input[name="round1"]:checked').value === "roundTrip") {
		        returnFlatpickr.open();
		      }
		    }
		  });

		  const returnFlatpickr = flatpickr(".calendarreturn", {
		    defaultDate: null,
		    minDate: today,
		    dateFormat: "Y-m-d",
		    disableMobile: true, 
		    onChange: function(selectedDates) {
		      const selected = selectedDates[0];
		      updateReturnDisplay(selected);
		    },
		    clickOpens: false
		  });

		  function updateReturnState() {
		    const isRoundTrip = document.querySelector('input[name="round1"]:checked').id === "round";
		    const tripTypeInput = document.getElementById("tripType");
		    const departDateHidden = document.getElementById("departDate");
		    if (isRoundTrip) {
		      returnCalendar.classList.remove("disabled");
		      returnFlatpickr.set("clickOpens", true);
		      tripTypeInput.value = "2";
		      
		      // ⭐ Set Return Date = Departure Date + 1 ⭐
		      const departDateValue = departDateHidden.value;  // MM-DD-YYYY
		      if (departDateValue) {
		        const [mm, dd, yyyy] = departDateValue.split("/");
		        const departDate = new Date(`${yyyy}-${mm}-${dd}`);

		        const nextDay = new Date(departDate);
		        nextDay.setDate(departDate.getDate() + 1);

		        updateReturnDisplay(nextDay);
		        returnFlatpickr.setDate(nextDay);
		        returnFlatpickr.jumpToDate(nextDay);
		        returnFlatpickr.set("minDate", departDate);
		      }
		      
		    } else {
		    	 tripTypeInput.value = "1";
		      returnCalendar.classList.add("disabled");
		      returnFlatpickr.clear();
		      updateReturnDisplay(null);
		      returnFlatpickr.set("clickOpens", false);
		    }
		  }

		  tripTypeRadios.forEach(radio => {
		    radio.addEventListener("change", updateReturnState);
		  });

		  // initialize state
		  updateReturnState();

		  // open calendars on click
		  document.querySelector(".calendardepart").addEventListener("click", () => departFlatpickr.open());
		  document.querySelector(".calendarreturn").addEventListener("click", () => {
		    if (!returnCalendar.classList.contains("disabled")) returnFlatpickr.open();
		  });

		  updateDepartureDisplay(today);
		  
		  if (document.querySelector("#round").checked) {
		    const nextDay = new Date(today);
		    nextDay.setDate(today.getDate() + 1);

		    updateReturnDisplay(nextDay);
		    returnFlatpickr.setDate(nextDay);
		  }
		});


	
	
	// traveller and class
	document.addEventListener("DOMContentLoaded", () => {
		
		 
	    const travellerMain = document.querySelector(".calendar-main.traveller");
	    const travellerBox = document.getElementById("travellerbox");
	    const totalTravelersP = travellerMain.querySelector(".total-travelers");
	    const selectedClassP = travellerMain.querySelector(".selected-class");
	    const cabinInput = document.getElementById("cabin");
	    let counts = { adult: 1, child: 0, infant: 0, infantWs: 0 };
	    let travelClass = "Economy";

	    // Toggle traveller box when clicking top section
	    travellerMain.querySelectorAll("p.from, p.departure, p.selected-class").forEach(p => {
	        p.addEventListener("click", () => {
	            travellerBox.classList.toggle("d-none");
	        });
	    });

	    // Stop propagation for all buttons inside traveller box
	    travellerBox.querySelectorAll("button").forEach(btn => {
	        btn.addEventListener("click", e => e.stopPropagation());
	    });

	    // Increment / Decrement
	    travellerBox.querySelectorAll(".inc, .dec").forEach(btn => {
	        btn.addEventListener("click", () => {
	            const type = btn.dataset.type;
	            let val = counts[type];

	            const total = counts.adult + counts.child + counts.infant + counts.infantWs;

	            if (btn.classList.contains("inc")) {
	                if (total >= 9) return;
	                if ((type === "infant" || type === "infantWs") && val >= counts.adult) return;
	                val++;
	            } else {
	                if (type === "adult" && val <= 1) return;
	                if ((type === "child" || type === "infant" || type === "infantWs") && val <= 0) return;
	                val--;
	            }

	            counts[type] = val;
	            travellerBox.querySelector(`input.${type}`).value = val;
	            updateSummary();
	        });
	    });

	    // Class selection
	    travellerBox.querySelectorAll(".seat-class button").forEach(btn => {
	        btn.addEventListener("click", () => {
	            travelClass = btn.textContent;
	            cabinInput.value = travelClass;
	            travellerBox.querySelectorAll(".seat-class button").forEach(b => b.classList.remove("selected"));
	            btn.classList.add("selected");
	            selectedClassP.textContent = travelClass;
	        });
	    });

	    // Apply button
	    document.getElementById("applyTravellers").addEventListener("click", () => {
	        travellerBox.classList.add("d-none");
	    });

	    function updateSummary() {
	        const total = counts.adult + counts.child + counts.infant + counts.infantWs;
	        totalTravelersP.textContent = total;
	    }

	    updateSummary();
	});

	document.querySelector('.exchange').addEventListener('click', function () {

	    // Swap hidden inputs
	    const fromInput = document.getElementById("fromFullAirport");
	    const toInput   = document.getElementById("toFullAirport");

	 // ⭐ STOP if any value is empty
	    if (!fromInput.value || !toInput.value) {
	        console.log("Exchange blocked: From or To is empty");
	        return;   // stop function
	    }
	    let fromValue = fromInput.value;
	    let toValue   = toInput.value;

	    fromInput.value = toValue;
	    toInput.value   = fromValue;

	    // Swap visible text fields
	    const fromTextEl = document.querySelector(".fromairport .search-origin");
	    const toTextEl   = document.querySelector(".tosearch-origin");

	    let fromText = fromTextEl.textContent;
	    let toText   = toTextEl.textContent;

	    fromTextEl.textContent = toText;
	    toTextEl.textContent   = fromText;

	    // Swap labels "From" ↔ "To"
	    const fromLabelEl = document.querySelector(".fromairport .edtrdt");
	    const toLabelEl   = document.querySelector(".todeparture .edtrdt");

	    let fromLabel = fromLabelEl.textContent;
	    let toLabel   = toLabelEl.textContent;

	    fromLabelEl.textContent = toLabel;
	    toLabelEl.textContent   = fromLabel;
	});
 
	document.addEventListener("DOMContentLoaded", function() {
	    const form = document.getElementById("flightSearch");

	    form.addEventListener("submit", function(e) {
	        e.preventDefault();

	        // Clear previous errors
	        form.querySelectorAll(".form-group input").forEach(input => {
	            input.classList.remove("error");

	            const errBox = input.nextElementSibling;
	            if (errBox && errBox.classList.contains("error-message")) {
	                errBox.innerText = "";
	            }
	        });

	        let valid = true;

	        const origin = document.getElementById("fromFullAirport");
	        const destination = document.getElementById("toFullAirport");
	        const departDate = document.getElementById("departDate");
	        const returnDate = document.getElementById("returnDate");
	        const tripType = document.querySelector('input[name="triptype"]:checked')?.value;

	        // Origin validation
	        if (!origin.value.trim()) {
	            origin.classList.add("error");
	            origin.nextElementSibling.innerText = "Please select origin.";
	            valid = false;
	        }

	        // Destination validation
	        if (!destination.value.trim()) {
	            destination.classList.add("error");
	            destination.nextElementSibling.innerText = "Please select destination.";
	            valid = false;
	        } else if (origin.value.trim() && origin.value.trim() === destination.value.trim()) {
	            destination.classList.add("error");
	            destination.nextElementSibling.innerText = "Origin and destination cannot be the same.";
	            valid = false;
	        }

	        // Depart date validation
	        if (!departDate.value) {
	            departDate.classList.add("error");
	            departDate.nextElementSibling.innerText = "Please select departure date.";
	            valid = false;
	        }

	        // Return date validation for round trip
	        if (tripType === "round" && (!returnDate.value || returnDate.value === "?")) {
	            returnDate.classList.add("error");
	            returnDate.nextElementSibling.innerText = "Return date cannot be blank.";
	            valid = false;
	        }

	        if (!valid) return;

	        // Optional: random string for action
	        const randomStr = Math.random().toString(36).substring(2, 17);
	        form.action = "/flight-listing/" + randomStr;
	        form.submit();
	    });
	});


