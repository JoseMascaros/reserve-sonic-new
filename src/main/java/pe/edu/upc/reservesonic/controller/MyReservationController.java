package pe.edu.upc.reservesonic.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.reservesonic.model.entity.Reservation;
import pe.edu.upc.reservesonic.service.crud.ReservationService;

@Controller
@RequestMapping("/myReservations")
public class MyReservationController {


	@Autowired
	private ReservationService reservationService;

	@GetMapping
	public String listReservations(Model model) {
		try {
			List<Reservation> reservations = reservationService.getAll();
			model.addAttribute("reservations", reservations);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "myReservations/listReservation";
	}
	
	@GetMapping("{id}")
	public String findById(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<Reservation> optional = reservationService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("reservation", optional.get());
				return "myReservations/viewReservation";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/myReservations";
	}
}
