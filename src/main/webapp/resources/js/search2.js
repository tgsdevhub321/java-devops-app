const toggles = [
  { trg: ".fromairport, .fromdeparture, .fromsearch-origin", box: "#fromSearch" },
  { trg: ".to, .todeparture, .tosearch-origin", box: "#toSearch" },
  { trg: ".traveller", box: "#travellerbox" }
];

(function () {
  const boxes = toggles.map(t => document.querySelector(t.box));

  toggles.forEach(t => {
    document.querySelectorAll(t.trg).forEach(el => {
      el.addEventListener("click", e => {
        e.stopPropagation();
        boxes.forEach(b => b.classList.add("d-none"));
        const b = document.querySelector(t.box);
        b.classList.remove("d-none");
        const inp = b.querySelector("input[type='search']");
        if (inp) setTimeout(() => inp.focus(), 5);
      });
    });
  });

  document.addEventListener("click", () => boxes.forEach(b => b.classList.add("d-none")));
})();


function airportSearch(cfg) {
	  const inp = document.querySelector(cfg.input);
	  const box = document.querySelector(cfg.box);
	  const res = document.querySelector(cfg.results);
	  const code = document.querySelector(cfg.code);
	  const full = document.querySelector(cfg.full);
	  const hid = document.querySelector(cfg.hidden);

	  let list = [], idx = -1, cache = {}, timer;

	  inp.addEventListener("keyup", e => {
	    const q = inp.value.trim();
	    if (["ArrowDown","ArrowUp","Enter"].includes(e.key)) return nav(e.key);
	    if (q.length < 2) return res.innerHTML = "";

	    clearTimeout(timer);
	    timer = setTimeout(() => fetchList(q), 200);
	  });

	  function fetchList(q) {
	    if (cache[q]) return show(cache[q], q);
	    res.innerHTML = `<p>Searching...</p>`;
	    fetch(`/getAirprotList/${q}`)
	      .then(r => r.json())
	      .then(d => (cache[q] = d, show(d, q)))
	      .catch(() => res.innerHTML = `<p>Error</p>`);
	  }

	  function parse(t) {
	    const f = t.indexOf("-"), l = t.lastIndexOf("-"), c = t.indexOf(",");
	    return {
	      code: t.slice(0, f).trim(),
	      city: t.slice(f+1, c).trim(),
	      name: t.slice(c+1, l).trim(),
	      country: t.slice(l+1).trim(),
	      full: t
	    };
	  }

	  function show(data, q) {
	    res.innerHTML = "";
	    list = data.map(parse);
	    if (!list.length) return res.innerHTML = `<p>No results</p>`;

	    list.forEach((a, i) => {
	      const d = document.createElement("div");
	      d.className = "dep-name-inner";
	      d.dataset.i = i;
	      d.innerHTML = `
	        <span><img src="resources/images/plane.png"></span>
	        <div>
	          <p>${mark(`${a.city} (${a.code})`, q)}</p>
	          <p>${mark(a.name, q)}</p>
	        </div>`;
	      d.onclick = () => select(a);
	      res.appendChild(d);
	    });
	  }

	  const mark = (t, q) => t.replace(new RegExp(q, "gi"), m => `<mark>${m}</mark>`);

	  function nav(k) {
	    const items = [...res.children];
	    if (!items.length) return;
	    if (k === "ArrowDown") idx = (idx + 1) % items.length;
	    if (k === "ArrowUp") idx = (idx - 1 + items.length) % items.length;
	    if (k === "Enter") return items[idx]?.click();
	    items.forEach((el, i) => el.classList.toggle("active", i === idx));
	  }

	  function select(a) {
	    code.textContent = a.code;
	    full.textContent = a.full;
	    hid.value = a.full;
	    box.classList.add("d-none");
	    inp.value = "";
	  }
	}

	// Init
	airportSearch({
	  input:"#fromInput", box:"#fromSearch", results:"#fromSearch .airport-results",
	  code:".departure.fromairport", full:".search-origin.fromairport", hidden:"#fromFullAirport"
	});

	airportSearch({
	  input:"#toInput", box:"#toSearch", results:"#toSearch .airport-results",
	  code:".departure.todeparture", full:".tosearch-origin.toairport", hidden:"#toFullAirport"
	});

	
	document.addEventListener("DOMContentLoaded", () => {
		  const round = () => document.querySelector('input[name="round1"]:checked')?.id === "round";
		  const retBox = document.querySelector(".calendarreturn");
		  const depH = document.getElementById("departDate");
		  const retH = document.getElementById("returnDate");

		  const toMM = d => `${String(d.getMonth()+1).padStart(2,'0')}/${String(d.getDate()).padStart(2,'0')}/${d.getFullYear()}`;

		  function disp(sel, d) {
		    const n = ["Sun","Mon","Tue","Wed","Thu","Fri","Sat"];
		    const m = ["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];
		    document.querySelector(sel+"-day").textContent = d?.getDate() ?? "Select Return";
		    document.querySelector(sel+"-month").textContent = d ? `${m[d.getMonth()]} ${d.getFullYear()}` : "";
		    document.querySelector(sel+"-week").textContent = d ? n[d.getDay()] : "Date";
		  }

		  const depCal = flatpickr(".calendardepart", {
		    defaultDate: new Date(),
		    disableMobile:true,
		    onChange:([d]) => {
		      depH.value = toMM(d);
		      retCal.set("minDate", d);
		      retCal.jumpToDate(d);
		      disp(".dep", d);
		      if (round()) retCal.open();
		    }
		  });

		  const retCal = flatpickr(".calendarreturn", {
		    disableMobile:true,
		    clickOpens:false,
		    onChange:([d]) => (retH.value = toMM(d), disp(".ret", d))
		  });

		  document.querySelector(".calendardepart").onclick = () => depCal.open();
		  document.querySelector(".calendarreturn").onclick = () => round() && retCal.open();

		  document.querySelectorAll('input[name="round1"]').forEach(r => 
		    r.onchange = () => {
		      if (round()) {
		        retBox.classList.remove("disabled");
		        retCal.set("clickOpens", true);
		        const d = new Date(depH.value);
		        d.setDate(d.getDate()+1);
		        retH.value = toMM(d);
		        retCal.setDate(d);
		        disp(".ret", d);
		      } else {
		        retCal.clear();
		        retH.value = "";
		        disp(".ret", null);
		        retBox.classList.add("disabled");
		        retCal.set("clickOpens", false);
		      }
		    }
		  );
		});

	
	document.addEventListener("DOMContentLoaded", () => {
		  const box = document.getElementById("travellerbox");
		  const main = document.querySelector(".calendar-main.traveller");
		  const total = main.querySelector(".total-travelers");
		  const cls = main.querySelector(".selected-class");
		  const cabin = document.getElementById("cabin");

		  let pax = { adult:1, child:0, infant:0, infantWs:0 };

		  main.onclick = () => box.classList.toggle("d-none");
		  box.onclick = e => e.stopPropagation();

		  const update = () => total.textContent = Object.values(pax).reduce((a,b)=>a+b);
		  update();

		  box.querySelectorAll(".inc,.dec").forEach(btn => {
		    btn.onclick = () => {
		      const t = btn.dataset.type;
		      const totalP = Object.values(pax).reduce((a,b)=>a+b);
		      if (btn.classList.contains("inc")) {
		        if (totalP >= 9) return;
		        if ((t === "infant" || t==="infantWs") && pax[t] >= pax.adult) return;
		        pax[t]++;
		      } else {
		        if (t==="adult" && pax[t]===1) return;
		        if (pax[t]===0) return;
		        pax[t]--;
		      }
		      box.querySelector(`input.${t}`).value = pax[t];
		      update();
		    };
		  });

		  box.querySelectorAll(".seat-class button").forEach(btn => {
		    btn.onclick = () => {
		      cls.textContent = cabin.value = btn.textContent;
		      box.querySelectorAll(".seat-class button").forEach(b => b.classList.remove("selected"));
		      btn.classList.add("selected");
		    };
		  });

		  document.getElementById("applyTravellers").onclick = () => box.classList.add("d-none");
		});

	
	