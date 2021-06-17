package pe.edu.upc.reservesonic.service.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.reservesonic.model.entity.Room;
import pe.edu.upc.reservesonic.model.entity.Studio;
import pe.edu.upc.reservesonic.model.repository.RoomRepository;
import pe.edu.upc.reservesonic.service.crud.RoomService;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomRepository roomRepository;
	
	@Override
	public JpaRepository<Room, Integer> getRepository() {
		return roomRepository;
	}

	@Override
	public List<Room> findByStudio(Studio studio) throws Exception {
		return roomRepository.findByStudio(studio);
	}

}
