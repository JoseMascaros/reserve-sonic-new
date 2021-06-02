package pe.edu.upc.reservesonic.service.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.reservesonic.model.entity.Region;
import pe.edu.upc.reservesonic.model.repository.RegionRepository;
import pe.edu.upc.reservesonic.service.crud.RegionService;

@Service
public class RegionServiceImpl implements RegionService{
	
	@Autowired
	private RegionRepository regionRepository;
	
	@Override
	public JpaRepository<Region, Integer> getRepository() {
		return regionRepository;
	}
}
