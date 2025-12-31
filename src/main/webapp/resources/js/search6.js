document.addEventListener("click", e => {
  if (!e.target.closest(".exchange")) return;

  const from = document.getElementById("fromFullAirport");
  const to = document.getElementById("toFullAirport");

  if (!from.value || !to.value) return;

  [from.value, to.value] = [to.value, from.value];

  const fromTxt = document.querySelector(".fromairport .search-origin");
  const toTxt = document.querySelector(".tosearch-origin");

  [fromTxt.textContent, toTxt.textContent] = [toTxt.textContent, fromTxt.textContent];
});


document.addEventListener("click", e => {
	  const box = document.getElementById("travellerbox");
	  const main = document.querySelector(".calendar-main.traveller");

	  // open panel
	  if (main.contains(e.target)) {
	    box.classList.toggle("d-none");
	    return;
	  }

	  // click inside box → stop
	  if (box.contains(e.target)) return;

	  // outside → close
	  box.classList.add("d-none");
	});

	let pax = { adult:1, child:0, infant:0, infantWs:0 };

	document.getElementById("travellerbox").addEventListener("click", e => {
	  const btn = e.target.closest(".inc,.dec");
	  if (!btn) return;

	  const type = btn.dataset.type;
	  const total = Object.values(pax).reduce((a,b) => a+b);

	  if (btn.classList.contains("inc")) {
	    if (total >= 9) return;
	    if ((type === "infant" || type === "infantWs") && pax[type] >= pax.adult) return;
	    pax[type]++;
	  } else {
	    if (type === "adult" && pax[type] === 1) return;
	    if (pax[type] === 0) return;
	    pax[type]--;
	  }

	  document.querySelector(`input.${type}`).value = pax[type];
	  document.querySelector(".total-travelers").textContent =
	    Object.values(pax).reduce((a,b)=>a+b);
	});

	
	document.addEventListener("DOMContentLoaded", () => {
		  const round = () => document.querySelector("#round").checked;
		  const depH = document.getElementById("departDate");
		  const retH = document.getElementById("returnDate");

		  const retBox = document.querySelector(".calendarreturn");

		  const toMM = d =>
		    `${String(d.getMonth()+1).padStart(2,"0")}/${String(d.getDate()).padStart(2,"0")}/${d.getFullYear()}`;

		  const depCal = flatpickr(".calendardepart", {
		    defaultDate: new Date(),
		    disableMobile: true,
		    onChange: ([d]) => {
		      depH.value = toMM(d);
		      retCal.set("minDate", d);
		      retCal.jumpToDate(d);
		      if (round()) retCal.open();
		    }
		  });

		  const retCal = flatpickr(".calendarreturn", {
		    disableMobile: true,
		    clickOpens: false,
		    onChange: ([d]) => (retH.value = toMM(d))
		  });

		  document.addEventListener("click", e => {
		    if (e.target.closest(".calendardepart")) return depCal.open();
		    if (round() && e.target.closest(".calendarreturn")) return retCal.open();
		  });

		  document.querySelectorAll('input[name="round1"]').forEach(r =>
		    r.addEventListener("change", () => {
		      if (round()) {
		        retBox.classList.remove("disabled");
		        retCal.set("clickOpens", true);

		        const d = new Date(depH.value);
		        d.setDate(d.getDate() + 1);

		        retH.value = toMM(d);
		        retCal.setDate(d);
		      } else {
		        retCal.clear();
		        retH.value = "";
		        retBox.classList.add("disabled");
		        retCal.set("clickOpens", false);
		      }
		    })
		  );
		});

	
	