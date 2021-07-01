package pe.edu.upc.reservesonic.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.reservesonic.model.entity.Room;
import pe.edu.upc.reservesonic.model.entity.Studio;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
	public List<Room> findByStudio(Studio studio);
}
