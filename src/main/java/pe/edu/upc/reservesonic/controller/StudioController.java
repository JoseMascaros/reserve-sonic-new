package pe.edu.upc.reservesonic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.reservesonic.model.entity.Studio;
import pe.edu.upc.reservesonic.service.crud.StudioService;

@Controller
@RequestMapping("/studios")
public class StudioController {
    @Autowired
    private StudioService studioService;

    @GetMapping
    public String list(Model model) {
        try {
            List<Studio> studios = studioService.getAll();
            model.addAttribute("studios", studios);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        return "studios/listStudios";
    }
}
