package pe.edu.upc.reservesonic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.reservesonic.model.entity.Studio;

@Controller

public class HomeController {
    @RequestMapping("/")
    public String indexGet(Model model) {
        Studio studioSearch = new Studio();
        model.addAttribute("studioSearch", studioSearch);
        return "/home";
    }
}
