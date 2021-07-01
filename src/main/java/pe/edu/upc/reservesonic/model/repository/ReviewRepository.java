package pe.edu.upc.reservesonic.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.reservesonic.model.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
