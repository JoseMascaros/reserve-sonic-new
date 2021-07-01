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

import pe.edu.upc.reservesonic.model.entity.Room;
import pe.edu.upc.reservesonic.model.entity.Studio;
import pe.edu.upc.reservesonic.service.crud.RoomService;
import pe.edu.upc.reservesonic.service.crud.StudioService;

@Controller
@RequestMapping("/rooms")
@SessionAttributes("roomEdit")
public class RoomController {

	@Autowired
	private StudioService studioService;
	
	@Autowired
	private RoomService roomService;

	@GetMapping
	public String list(Model model) {
		try {
			List<Room> rooms = roomService.getAll();
			model.addAttribute("rooms", rooms);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}

		return "rooms/listRoom";
	}

	@PostMapping("save")
	public String saveEdit(Model model, @ModelAttribute("roomEdit") Room room) {
		try {
			Room roomReturn = roomService.update(room);
			model.addAttribute("room", roomReturn);
			//return "rooms/viewRoom";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/rooms";
	}

	@GetMapping("new")
	public String newRoom(Model model) {
		try {
			Room room = new Room();
			model.addAttribute("roomNew", room);
			List<Studio> listStudios = studioService.getAll();
			model.addAttribute("listStudios", listStudios);
			return "rooms/newRoom";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}

		return "redirect:/rooms";
	}

	@PostMapping("savenew")
	public String saveNew(Model model, @ModelAttribute("roomNew") Room room) {
		try {
			Room roomReturn = roomService.create(room);
			model.addAttribute("room", roomReturn);
			//return "rooms/viewRoom";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}

		return "redirect:/rooms";
	}

	// Id's
	@GetMapping("{id}/viewRoom") // GET: /rooms/{id}
	public String findById(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<Room> optional = roomService.findById(id);
			if (optional.isPresent()) {
				model.addAttribute("room", optional.get());
				return "rooms/viewRoom";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/rooms";
	}

	@GetMapping("{id}/editRoom") // GET: /rooms/{id}/edit
	public String findById2(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<Room> optional = roomService.findById(id);
			if (optional.isPresent()) {
				model.addAttribute("roomEdit", optional.get());

				List<Studio> listStudios = studioService.getAll();
				model.addAttribute("listStudios", listStudios);
				return "rooms/editRoom";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/rooms";
	}
	
	@GetMapping("{id}/deleteRoom")
	public String deleteRoom(@PathVariable("id") Integer id ) {
		try {
			Optional<Room> optional = roomService.findById(id);
			if (optional.isPresent()) {
				roomService.deleteById(id);
			}			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/rooms";
	}
}
