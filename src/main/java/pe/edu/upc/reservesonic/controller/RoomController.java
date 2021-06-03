package pe.edu.upc.reservesonic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.reservesonic.model.entity.Room;
import pe.edu.upc.reservesonic.service.crud.RoomService;

@Controller
@RequestMapping("/rooms")
public class RoomController {
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
		
		return "rooms/listRooms";
	}
	
	@PostMapping("save")
	public String saveEdit(Model model, @ModelAttribute("roomEdit") Room room) {
		try {
			Room roomReturn = roomService.update(room);
			model.addAttribute("room", roomReturn);
			return "rooms/view";
		} catch(Exception e) {
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
			return "rooms/new";
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
			return "rooms/view";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "redirect:/rooms";
	}
}
