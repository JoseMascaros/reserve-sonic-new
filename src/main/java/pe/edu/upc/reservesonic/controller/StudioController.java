package pe.edu.upc.reservesonic.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.reservesonic.model.entity.District;
import pe.edu.upc.reservesonic.model.entity.Studio;
import pe.edu.upc.reservesonic.service.crud.DistrictService;
import pe.edu.upc.reservesonic.service.crud.StudioService;

@Controller
@RequestMapping("/studios")
@SessionAttributes("studioEdit")
public class StudioController {

	@Autowired
	private StudioService studioService;
	
	@Autowired
	private DistrictService districtService;

	@GetMapping
	public String list(Model model) {
		try {
			List<Studio> studios = studioService.getAll();
			model.addAttribute("studios", studios);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "studios/listStudio";
	}

	// Id's
	@GetMapping("{id}/viewStudio") // GET: /studios/{id}
	public String findById(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<Studio> optional = studioService.findById(id);
			if (optional.isPresent()) {
				model.addAttribute("studio", optional.get());
				//return "studios/viewStudio";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/studios";
	}

	@GetMapping("{id}/editStudio") // GET: /studios/{id}/edit
	public String findById2(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<Studio> optional = studioService.findById(id);
			if (optional.isPresent()) {
				model.addAttribute("studioEdit", optional.get());
				List<District> listDistricts = districtService.getAll();
				model.addAttribute("listDistricts", listDistricts);
				return "studios/editStudio";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/studios";
	}

	@PostMapping("save")
	public String saveEdit(Model model, @ModelAttribute("studioEdit") Studio studio) {
		try {
			Studio studioReturn = studioService.update(studio);
			model.addAttribute("studio", studioReturn);
			//return "studios/viewStudio";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/studios";
	}

	@GetMapping("new")
	public String newItem(Model model) {
		try {
			Studio studio = new Studio();
			model.addAttribute("studioNew", studio);
			List<District> listDistricts = districtService.getAll();
			model.addAttribute("listDistricts", listDistricts);
			return "studios/newStudio";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}

		return "redirect:/studios";
	}

	@PostMapping("savenew")
	public String saveNew(Model model, @ModelAttribute("studioNew") Studio studio) {
		try {
			Studio studioReturn = studioService.create(studio);
			model.addAttribute("studio", studioReturn);
			return "studios/viewStudio";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}

		return "redirect:/studios";
	}
	
	@GetMapping("{id}/deleteStudio")
	public String deleteStudio(@PathVariable("id") Integer id ) {
		try {
			Optional<Studio> optional = studioService.findById(id);
			if (optional.isPresent()) {
				studioService.deleteById(id);
			}			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/studios";
	}

}
