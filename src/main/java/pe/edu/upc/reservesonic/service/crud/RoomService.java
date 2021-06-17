package pe.edu.upc.reservesonic.service.crud;

import java.util.List;

import pe.edu.upc.reservesonic.model.entity.Room;
import pe.edu.upc.reservesonic.model.entity.Studio;

public interface RoomService extends CrudService<Room, Integer>{
	public List<Room> findByStudio(Studio studio) throws Exception;
}
