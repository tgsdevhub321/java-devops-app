// ----------------------------
// SEARCH BOX TOGGLE
// ----------------------------
const searchConfig = [
    { selectors: [".fromairport", ".fromdeparture", ".fromsearch-origin"], box: "#fromSearch" },
    { selectors: [".to", ".todeparture", ".tosearch-origin"], box: "#toSearch" },
    { selectors: [".traveller"], box: "#travellerbox" }
];

function initSearchBoxes() {
    const boxes = searchConfig.map(x => document.querySelector(x.box));

    searchConfig.forEach(cfg => {
        const triggers = document.querySelectorAll(cfg.selectors.join(","));
        const box = document.querySelector(cfg.box);

        triggers.forEach(el => {
            el.addEventListener("click", e => {
                e.stopPropagation();
                
                // Hide all
                boxes.forEach(b => b.classList.add("d-none"));

                // Show current
                box.classList.remove("d-none");

                // Focus input
                const input = box.querySelector("input[type='search']");
                if (input) setTimeout(() => input.focus(), 10);
            });
        });
    });

    // Click outside closes all
    document.addEventListener("click", () => {
        boxes.forEach(b => b.classList.add("d-none"));
    });
}

initSearchBoxes();


//----------------------------
//AIRPORT SEARCH MODULE
//----------------------------
let airportCache = {};

function setupAirportSearch(inputSel, listSel, codeSel, fullSel, hiddenSel, boxSel) {
 const input = document.querySelector(inputSel);
 const results = document.querySelector(listSel);
 const codeP = document.querySelector(codeSel);
 const fullP = document.querySelector(fullSel);
 const hidden = document.querySelector(hiddenSel);
 const box = document.querySelector(boxSel);

 let index = -1;
 let current = [];

 input.addEventListener("keyup", e => {
     const val = input.value.trim();
     if (["ArrowDown", "ArrowUp", "Enter"].includes(e.key)) {
         navigate(e.key);
         return;
     }
     if (val.length < 2) {
         results.innerHTML = "";
         return;
     }
     fetchResults(val);
 });

 function fetchResults(q) {
     if (airportCache[q]) return render(airportCache[q], q);

     results.innerHTML = `<p class="p-2">Searching...</p>`;
     fetch(`/getAirprotList/${q}`)
         .then(r => r.json())
         .then(data => {
             airportCache[q] = data;
             render(data, q);
         })
         .catch(() => results.innerHTML = `<p class="p-2 text-danger">Error loading</p>`);
 }

 function render(list, q) {
     results.innerHTML = "";
     current = [];

     if (!list?.length) {
         results.innerHTML = `<p class="p-2">No results</p>`;
         return;
     }

     list.forEach((raw, i) => {
         const parsed = parseAirport(raw);
         current.push(parsed);

         const div = document.createElement("div");
         div.className = "dep-name-inner d-flex align-items-center";
         div.dataset.index = i;

         div.innerHTML = `
             <span><img src="resources/images/plane.png"></span>
             <div class="air-name-txt">
                 <p class="airport-city-name">${highlight(parsed.city + " (" + parsed.code + ")", q)}</p>
                 <p class="airport-name">${highlight(parsed.airportName, q)}</p>
             </div>
         `;

         div.addEventListener("click", () => select(parsed));
         results.appendChild(div);
     });
 }

 function highlight(text, query) {
     return text.replace(new RegExp(query, "gi"), m => `<mark>${m}</mark>`);
 }

 function navigate(key) {
     if (!current.length) return;
     const items = [...results.children];

     if (key === "ArrowDown") index = (index + 1) % items.length;
     if (key === "ArrowUp") index = (index - 1 + items.length) % items.length;
     if (key === "Enter" && index >= 0) return select(current[index]);

     items.forEach((el, i) => el.classList.toggle("active", i === index));
 }

 function select(p) {
     codeP.textContent = p.code;
     fullP.textContent = p.fullValue;
     hidden.value = p.fullValue;
     results.innerHTML = "";
     box.classList.add("d-none");
     input.value = "";
 }
}

function parseAirport(raw) {
 const parts = raw.split("-");
 const code = parts[0].trim();
 const rest = parts[1];
 const idx = rest.indexOf(",");

 return {
     code,
     city: rest.substring(0, idx).trim(),
     airportName: rest.substring(idx + 1).trim(),
     country: parts[2]?.trim() || "",
     fullValue: raw
 };
}


//----------------------------
//EXCHANGE SWAP LOGIC
//----------------------------
document.querySelector('.exchange').addEventListener('click', () => {
 const from = document.getElementById("fromFullAirport");
 const to   = document.getElementById("toFullAirport");

 if (!from.value || !to.value) return;

 // Swap hidden
 [from.value, to.value] = [to.value, from.value];

 // Swap visible text
 const fromText = document.querySelector(".fromairport .search-origin");
 const toText   = document.querySelector(".tosearch-origin");
 [fromText.textContent, toText.textContent] = [toText.textContent, fromText.textContent];

 // Swap labels
 const fromLabel = document.querySelector(".fromairport .edtrdt");
 const toLabel   = document.querySelector(".todeparture .edtrdt");
 [fromLabel.textContent, toLabel.textContent] = [toLabel.textContent, fromLabel.textContent];
});



//-----------------------------------
//CALENDAR & DATE HANDLING (Slim Version)
//-----------------------------------
document.addEventListener("DOMContentLoaded", () => {

 const tripRadios = document.querySelectorAll('input[name="round1"]');
 const returnBox  = document.querySelector(".calendarreturn");

 const departHid  = document.getElementById("departDate");
 const returnHid  = document.getElementById("returnDate");
 const tripType   = document.getElementById("tripType");

 const depDay     = document.querySelector(".dep-day");
 const depMY      = document.querySelector(".dep-month-year");
 const depWeek    = document.querySelector(".dep-weekday");

 const retDay     = document.querySelector(".ret-day");
 const retMY      = document.querySelector(".ret-month-year");
 const retWeek    = document.querySelector(".ret-weekday");

 const today = new Date();

 const monthNames = ["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];
 const weekdayNames = ["Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"];

 function parts(d) {
     return {
         d: d.getDate(),
         m: monthNames[d.getMonth()],
         y: d.getFullYear(),
         w: weekdayNames[d.getDay()]
     };
 }

 function toMMDDYYYY(d) {
     return `${String(d.getMonth()+1).padStart(2,'0')}/${String(d.getDate()).padStart(2,'0')}/${d.getFullYear()}`;
 }

 function updateDepart(d) {
     const p = parts(d);
     depDay.textContent = p.d;
     depMY.textContent = `${p.m} ${p.y}`;
     depWeek.textContent = p.w;
     departHid.value = toMMDDYYYY(d);
 }

 function updateReturn(d) {
     if (!d) {
         retDay.textContent = "Select Return";
         retMY.textContent = "";
         retWeek.textContent = "Date";
         returnHid.value = "";
         return;
     }
     const p = parts(d);
     retDay.textContent = p.d;
     retMY.textContent = `${p.m} ${p.y}`;
     retWeek.textContent = p.w;
     returnHid.value = toMMDDYYYY(d);
 }

 // ---------- DEPART CALENDAR ----------
 const departCal = flatpickr(".calendardepart", {
     defaultDate: today,
     minDate: today,
     disableMobile: true,
     dateFormat: "Y-m-d",
     onChange: (dates) => {
         const d = dates[0];
         updateDepart(d);

         // update return min & jump month
         returnCal.set("minDate", d);
         returnCal.jumpToDate(d);

         // auto-open return if round
         if (document.querySelector('input[name="round1"]:checked')?.value === "roundTrip") {
             returnCal.open();
         }
     }
 });

 // ---------- RETURN CALENDAR ----------
 const returnCal = flatpickr(".calendarreturn", {
     defaultDate: null,
     minDate: today,
     disableMobile: true,
     clickOpens: false,
     dateFormat: "Y-m-d",
     onChange: (dates) => updateReturn(dates[0])
 });

 // ---------- TRIP TYPE CHANGE ----------
 function updateTripMode() {
     const round = document.querySelector('input[name="round1"]:checked')?.id === "round";

     tripType.value = round ? "2" : "1";

     if (round) {
         returnBox.classList.remove("disabled");
         returnCal.set("clickOpens", true);

         // preset return = depart +1
         if (departHid.value) {
             const [mm, dd, yyyy] = departHid.value.split("/");
             const d = new Date(`${yyyy}-${mm}-${dd}`);

             const next = new Date(d);
             next.setDate(d.getDate() + 1);

             updateReturn(next);
             returnCal.setDate(next);
             returnCal.jumpToDate(next);
             returnCal.set("minDate", d);
         }
     } else {
         returnBox.classList.add("disabled");
         returnCal.set("clickOpens", false);
         returnCal.clear();
         updateReturn(null);
     }
 }

 tripRadios.forEach(r => r.addEventListener("change", updateTripMode));

 // ---------- OPEN CALENDARS ----------
 document.querySelector(".calendardepart")
     .addEventListener("click", () => departCal.open());

 document.querySelector(".calendarreturn")
     .addEventListener("click", () => {
         if (!returnBox.classList.contains("disabled")) returnCal.open();
     });

 // Init
 updateDepart(today);
 updateTripMode();
});


//----------------------------------
//TRAVELLER & CLASS SELECTION (Clean Version)
//----------------------------------
document.addEventListener("DOMContentLoaded", () => {

 const box = document.getElementById("travellerbox");
 const main = document.querySelector(".calendar-main.traveller");

 const totalP = main.querySelector(".total-travelers");
 const classP = main.querySelector(".selected-class");
 const cabinInput = document.getElementById("cabin");

 let pax = { adult: 1, child: 0, infant: 0, infantWs: 0 };
 let travelClass = "Economy";

 // -------- Toggle Traveller Box --------
 main.querySelectorAll("p.from, p.departure, p.selected-class")
     .forEach(p => p.addEventListener("click", () => box.classList.toggle("d-none")));

 // -------- Prevent Close On Click Inside --------
 box.addEventListener("click", e => e.stopPropagation());

 // ---------- Increment / Decrement ----------
 box.querySelectorAll(".inc, .dec").forEach(btn => {
     btn.addEventListener("click", () => {
         const type = btn.dataset.type;
         let val = pax[type];
         const total = pax.adult + pax.child + pax.infant + pax.infantWs;

         if (btn.classList.contains("inc")) {
             if (total >= 9) return;
             if ((type === "infant" || type === "infantWs") && val >= pax.adult) return;
             val++;
         } else {
             if (type === "adult" && val <= 1) return;
             if (val <= 0) return;
             val--;
         }

         pax[type] = val;
         box.querySelector(`input.${type}`).value = val;
         updateSummary();
     });
 });

 // ---------- Seat Class ----------
 box.querySelectorAll(".seat-class button").forEach(btn => {
     btn.addEventListener("click", () => {
         travelClass = btn.textContent;
         cabinInput.value = travelClass;
         classP.textContent = travelClass;

         box.querySelectorAll(".seat-class button").forEach(b => b.classList.remove("selected"));
         btn.classList.add("selected");
     });
 });

 // ---------- Apply ----------
 document.getElementById("applyTravellers")
     .addEventListener("click", () => box.classList.add("d-none"));

 // ---------- Update Summary ----------
 function updateSummary() {
     const total = pax.adult + pax.child + pax.infant + pax.infantWs;
     totalP.textContent = total;
 }

 // Init
 updateSummary();
});
