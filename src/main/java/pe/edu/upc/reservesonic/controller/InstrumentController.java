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

import pe.edu.upc.reservesonic.model.entity.Instrument;
import pe.edu.upc.reservesonic.model.entity.Room;
import pe.edu.upc.reservesonic.service.crud.InstrumentService;
import pe.edu.upc.reservesonic.service.crud.RoomService;

@Controller
@RequestMapping("/instruments")
@SessionAttributes("instrumentEdit")
public class InstrumentController {
	@Autowired
	private InstrumentService instrumentService;
	
	@Autowired
	private RoomService roomService;

	@GetMapping
	public String list(Model model) {
		try {
			List<Instrument> instruments = instrumentService.getAll();
			model.addAttribute("instruments", instruments);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}

		return "instruments/listInstrument";
	}

	@PostMapping("save")
	public String saveEdit(Model model, @ModelAttribute("instrumentEdit") Instrument instrument) {
		try {
			Instrument instrumentReturn = instrumentService.update(instrument);
			model.addAttribute("instrument", instrumentReturn);
			//return "instruments/viewInstrument";
		} catch (Exception e) {
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
			List<Room> listRooms = roomService.getAll();
			model.addAttribute("listRooms", listRooms);
			return "instruments/newInstrument";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}

		return "redirect:/instruments";
	}

	@PostMapping("savenew")
	public String saveNew(Model model, @ModelAttribute("instrumentNew") Instrument instrument) {
		try {
			Instrument instrumentReturn = instrumentService.create(instrument);
			model.addAttribute("instrument", instrumentReturn);
			//return "instruments/viewInstrument";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}

		return "redirect:/instruments";
	}

	// Id's
	@GetMapping("{id}/viewInstrument") // GET: /instruments/{id}
	public String findById(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<Instrument> optional = instrumentService.findById(id);
			if (optional.isPresent()) {
				model.addAttribute("instrument", optional.get());
				return "instruments/viewInstrument";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/instruments";
	}

	@GetMapping("{id}/editInstrument") // GET: /instruments/{id}/edit
	public String findById2(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<Instrument> optional = instrumentService.findById(id);
			if (optional.isPresent()) {
				model.addAttribute("instrumentEdit", optional.get());
				List<Room> listRooms = roomService.getAll();
				model.addAttribute("listRooms", listRooms);
				return "instruments/editInstrument";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/instruments";
	}
	
	@GetMapping("{id}/deleteInstrument")
	public String deleteInstrument(@PathVariable("id") Integer id ) {
		try {
			Optional<Instrument> optional = instrumentService.findById(id);
			if (optional.isPresent()) {
				instrumentService.deleteById(id);
			}			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/instruments";
	}
}
