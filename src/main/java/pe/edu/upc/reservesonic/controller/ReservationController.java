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
import pe.edu.upc.reservesonic.service.crud.ReservationService;
import pe.edu.upc.reservesonic.service.crud.RoomService;


@Controller
@RequestMapping("/reservations")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private RoomService roomService;
	
	@GetMapping
	public String listRooms(Model model) {
		try {
			List<Room> rooms = roomService.getAll();
			model.addAttribute("rooms", rooms);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "reservations/listAllRooms";
	}
	
	
	//reserva una sala
	@GetMapping("new/{id}")
	public String newItem(Model model, @PathVariable("id") Integer id ) {
		try {
			Optional<Room> optional = roomService.findById(id);
			if(optional.isPresent()) {
				Reservation reservation = new Reservation();
				model.addAttribute("reservationNew", reservation);
				model.addAttribute("room", optional.get());
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
			Reservation reservationReturn = reservationService.create(reservation);
			model.addAttribute("reservation", reservationReturn);
			//return "reservations/viewReservation";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/myReservations";
	}
	
}
