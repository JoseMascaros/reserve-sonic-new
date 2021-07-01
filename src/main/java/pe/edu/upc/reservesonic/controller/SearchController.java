package pe.edu.upc.reservesonic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.reservesonic.model.entity.Studio;
import pe.edu.upc.reservesonic.service.crud.StudioService;

@Controller
@RequestMapping("/search")
@SessionAttributes("studioSearch")
public class SearchController {
    @Autowired
    private StudioService studioService;

    @GetMapping("studios")
    public String searchStudios(Model model, @ModelAttribute("studioSearch") Studio studioSearch) {
        System.out.println(studioSearch.getName());
        try {
            List<Studio> studiosFound = studioService.findByNameStartingWith(studioSearch.getName());
            model.addAttribute("studiosFound", studiosFound);
            model.addAttribute("studioSearch", studioSearch);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }

        return "search/studios-result";
    }
}
