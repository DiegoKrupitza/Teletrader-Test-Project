package com.diegokrupitza.teletradertestproject.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Project: teletrader-test-project
 * Document: HomeController.java
 * Author: Diego Krupitza
 * Created: 03.07.18
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String home(ModelMap model) {
        return "home";
    }

}
