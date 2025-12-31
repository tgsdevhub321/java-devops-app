package com.travel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThemeController {

    @GetMapping("/themeA")
    public String loadThemeA(Model model) {
        model.addAttribute("theme", "themeA");
        return "themeA/index";
    }

    @GetMapping("/themeB")
    public String loadThemeB(Model model) {
        model.addAttribute("theme", "themeB");
        return "themeB/index";
    }
}
