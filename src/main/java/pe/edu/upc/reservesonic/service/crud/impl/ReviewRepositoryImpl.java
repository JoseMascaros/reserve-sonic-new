package pe.edu.upc.reservesonic.service.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.reservesonic.model.entity.Review;
import pe.edu.upc.reservesonic.model.repository.ReviewRepository;
import pe.edu.upc.reservesonic.service.crud.ReviewService;

@Service
public class ReviewRepositoryImpl implements ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;
	
	@Override
	public JpaRepository<Review, Integer> getRepository() {
		return reviewRepository;
	}

}
