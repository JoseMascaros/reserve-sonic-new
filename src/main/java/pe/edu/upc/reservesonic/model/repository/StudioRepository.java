package pe.edu.upc.reservesonic.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.reservesonic.model.entity.Studio;

@Repository
public interface StudioRepository extends JpaRepository<Studio, Integer> {

	public List<Studio> findByName(String name);
}
