package pe.edu.upc.reservesonic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.reservesonic.model.entity.Instrument;
import pe.edu.upc.reservesonic.service.crud.InstrumentService;

@Controller
@RequestMapping("/instruments")
public class InstrumentController {
	@Autowired
	private InstrumentService instrumentService;
	
	@GetMapping
	public String list(Model model) {
		try {
			List<Instrument> instruments = instrumentService.getAll();
			model.addAttribute("instruments", instruments);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "rooms/listInstruments";
	}
	
	@PostMapping("save")
	public String saveEdit(Model model, @ModelAttribute("instrumentEdit") Instrument instrument) {
		try {
			Instrument instrumentReturn = instrumentService.update(instrument);
			model.addAttribute("instrument", instrumentReturn);
			return "instruments/view";
		} catch(Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/instruments";
	}
	
	@GetMapping("new")
	public String newInstrument(Model model) {
		try {
			Instrument instrument = new Instrument();
			model.addAttribute("instrumentNew", instrument);
			return "instruments/new";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "redirect:/instruments";
	}
	
	@PostMapping("savenew")
	public String saveNew(Model model, @ModelAttribute("isntrumentNew") Instrument instrument) {
		try {
			Instrument instrumentReturn = instrumentService.create(instrument);
			model.addAttribute("instrument", instrumentReturn);
			return "instruments/view";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "redirect:/instruments";
	}
}
