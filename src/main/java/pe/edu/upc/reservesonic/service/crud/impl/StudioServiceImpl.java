package pe.edu.upc.reservesonic.service.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.reservesonic.model.entity.Studio;
import pe.edu.upc.reservesonic.model.repository.StudioRepository;
import pe.edu.upc.reservesonic.service.crud.StudioService;

@Service
public class StudioServiceImpl implements StudioService {

	@Autowired
	private StudioRepository studioRepository;

	@Override
	public JpaRepository<Studio, Integer> getRepository() {
		return studioRepository;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Studio> findByName(String name) throws Exception {
		return studioRepository.findByName(name);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Studio> findByNameStartingWith(String name) {
		return studioRepository.findByNameStartingWith(name);
	}

}
