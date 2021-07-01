package pe.edu.upc.reservesonic.service.crud;

import java.util.List;

import pe.edu.upc.reservesonic.model.entity.Studio;

public interface StudioService extends CrudService<Studio, Integer>{

	public List<Studio> findByName(String name) throws Exception;
}
