package pe.edu.upc.reservesonic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.reservesonic.model.entity.Review;
import pe.edu.upc.reservesonic.model.entity.Room;
import pe.edu.upc.reservesonic.service.crud.ReviewService;
import pe.edu.upc.reservesonic.service.crud.RoomService;

@Controller
@RequestMapping("/reviews")
@SessionAttributes("reviewEdit")
public class ReviewController {

	@Autowired
	private RoomService roomService;

	@Autowired
	private ReviewService reviewService;

	@GetMapping
	public String listReview(Model model) {
		try {
			List<Review> reviews = reviewService.getAll();
			model.addAttribute("reviews", reviews);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "reviews/listAllReview";
	}

	@GetMapping("new")
	public String newReview(Model model) {
		try {
			Review review = new Review();
			model.addAttribute("reviewNew", review);
			List<Room> listRooms = roomService.getAll();
			model.addAttribute("listRooms", listRooms);
			return "reviews/newReview";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}

		return "redirect:/reviews";
	}

	@PostMapping("savenew")
	public String saveNew(Model model, @ModelAttribute("reviewNew") Review review) {
		try {
			Review reviewReturn = reviewService.create(review);
			model.addAttribute("review", reviewReturn);
			return "reviews/viewReview";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}

		return "redirect:/reviews";
	}
}
