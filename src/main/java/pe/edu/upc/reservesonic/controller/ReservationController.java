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

import pe.edu.upc.reservesonic.model.entity.Reservation;
import pe.edu.upc.reservesonic.model.entity.Room;
import pe.edu.upc.reservesonic.model.entity.Studio;
import pe.edu.upc.reservesonic.service.crud.ReservationService;
import pe.edu.upc.reservesonic.service.crud.RoomService;
import pe.edu.upc.reservesonic.service.crud.StudioService;

@Controller
@RequestMapping("/reservations")
public class ReservationController {

	Studio studioaux;

	@Autowired
	private ReservationService reservationService;

	@Autowired
	private StudioService studioService;

	@Autowired
	private RoomService roomService;

	@GetMapping
	public String listStudios(Model model) {
		try {
			List<Studio> studios = studioService.getAll();
			model.addAttribute("studios", studios);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "reservations/listAllStudios";
	}

	@GetMapping("studios")
	public String studioSearch(Model model, @ModelAttribute("studioSearch") Studio studioSearch) {
		studioSearch.setName(studioSearch.getName());
		List<Studio> studiosFound = null;
		try {
			studiosFound = studioService.findByName(studioSearch.getName());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		model.addAttribute("studiosFound", studiosFound);
		model.addAttribute("studioSearch", studioSearch);
		return "reservations/studios-result";
	}

	// reserva una sala
	@GetMapping("new/{id}")
	public String newItem(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<Studio> optional = studioService.findById(id);
			if (optional.isPresent()) {
				Reservation reservation = new Reservation();
				List<Room> listRooms = roomService.findByStudio(optional.get());
				studioaux = optional.get();
				model.addAttribute("listRooms", listRooms);
				model.addAttribute("reservationNew", reservation);
				return "reservations/newReservation";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/reservations";
	}

	@PostMapping("savenew")
	public String saveNew(Model model, @ModelAttribute("reservationNew") Reservation reservation) {
		try {
			reservation.setPrice(studioaux);
			Reservation reservationReturn = reservationService.create(reservation);
			model.addAttribute("reservation", reservationReturn);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/myReservations";
	}

	@GetMapping("{id}/deleteReservation")
	public String deleteStudio(@PathVariable("id") Integer id) {
		try {
			Optional<Reservation> optional = reservationService.findById(id);
			if (optional.isPresent()) {
				reservationService.deleteById(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/myReservations";
	}
}
