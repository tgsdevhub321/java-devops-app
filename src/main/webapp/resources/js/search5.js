class ToggleManager {
  constructor(mapping) {
    this.mapping = mapping;
    this.boxes = mapping.map(m => document.querySelector(m.box));

    document.addEventListener("click", () => this.hideAll());

    mapping.forEach(m => {
      document.querySelectorAll(m.trigger).forEach(el => {
        el.addEventListener("click", e => {
          e.stopPropagation();
          this.hideAll();
          const box = document.querySelector(m.box);
          box.classList.remove("d-none");

          const input = box.querySelector("input[type='search']");
          if (input) setTimeout(() => input.focus(), 5);
        });
      });
    });
  }

  hideAll() {
    this.boxes.forEach(b => b.classList.add("d-none"));
  }
}

new ToggleManager([
	  { trigger: ".fromairport, .fromdeparture, .fromsearch-origin", box: "#fromSearch" },
	  { trigger: ".to, .todeparture, .tosearch-origin", box: "#toSearch" },
	  { trigger: ".traveller", box: "#travellerbox" }
	]);


class AirportSearch {
	  constructor(cfg) {
	    this.input = document.querySelector(cfg.input);
	    this.box = document.querySelector(cfg.box);
	    this.results = document.querySelector(cfg.results);
	    this.code = document.querySelector(cfg.code);
	    this.full = document.querySelector(cfg.full);
	    this.hidden = document.querySelector(cfg.hidden);

	    this.cache = {};
	    this.list = [];
	    this.index = -1;
	    this.timer = null;

	    this.input.addEventListener("keyup", e => this.onKey(e));
	  }

	  onKey(e) {
	    const q = this.input.value.trim();
	    if (["ArrowDown", "ArrowUp", "Enter"].includes(e.key)) return this.navigate(e.key);

	    if (q.length < 2) return (this.results.innerHTML = "");

	    clearTimeout(this.timer);
	    this.timer = setTimeout(() => this.fetch(q), 200);
	  }

	  fetch(q) {
	    if (this.cache[q]) return this.render(this.cache[q], q);
	    this.results.innerHTML = "<p>Searching...</p>";

	    fetch(`/getAirprotList/${q}`)
	      .then(r => r.json())
	      .then(d => {
	        this.cache[q] = d;
	        this.render(d, q);
	      })
	      .catch(() => (this.results.innerHTML = "<p>Error</p>"));
	  }

	  parse(txt) {
	    const f = txt.indexOf("-"),
	      l = txt.lastIndexOf("-"),
	      c = txt.indexOf(",");

	    return {
	      code: txt.slice(0, f).trim(),
	      city: txt.slice(f + 1, c).trim(),
	      name: txt.slice(c + 1, l).trim(),
	      country: txt.slice(l + 1).trim(),
	      full: txt
	    };
	  }

	  highlight(txt, q) {
	    return txt.replace(new RegExp(q, "gi"), m => `<mark>${m}</mark>`);
	  }

	  render(data, q) {
	    this.results.innerHTML = "";
	    this.list = data.map(d => this.parse(d));

	    if (!this.list.length) return (this.results.innerHTML = "<p>No results</p>");

	    this.list.forEach((a, i) => {
	      const div = document.createElement("div");
	      div.className = "dep-name-inner";
	      div.dataset.index = i;
	      div.innerHTML = `
	        <span><img src="resources/images/plane.png"></span>
	        <div>
	          <p>${this.highlight(`${a.city} (${a.code})`, q)}</p>
	          <p>${this.highlight(a.name, q)}</p>
	        </div>`;
	      div.onclick = () => this.select(a);
	      this.results.appendChild(div);
	    });
	  }

	  navigate(key) {
	    const items = [...this.results.children];
	    if (!items.length) return;

	    if (key === "ArrowDown") this.index = (this.index + 1) % items.length;
	    if (key === "ArrowUp") this.index = (this.index - 1 + items.length) % items.length;
	    if (key === "Enter") return items[this.index]?.click();

	    items.forEach((el, i) => el.classList.toggle("active", i === this.index));
	  }

	  select(a) {
	    this.code.textContent = a.code;
	    this.full.textContent = a.full;
	    this.hidden.value = a.full;
	    this.box.classList.add("d-none");
	    this.input.value = "";
	  }
	}


new AirportSearch({
	  input:"#fromInput", box:"#fromSearch", results:"#fromSearch .airport-results",
	  code:".departure.fromairport", full:".search-origin.fromairport", hidden:"#fromFullAirport"
	});

	new AirportSearch({
	  input:"#toInput", box:"#toSearch", results:"#toSearch .airport-results",
	  code:".departure.todeparture", full:".tosearch-origin.toairport", hidden:"#toFullAirport"
	});

	
	
