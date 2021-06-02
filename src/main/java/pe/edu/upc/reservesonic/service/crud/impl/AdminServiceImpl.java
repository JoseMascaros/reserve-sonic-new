package pe.edu.upc.reservesonic.service.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.reservesonic.model.entity.Admin;
import pe.edu.upc.reservesonic.model.repository.AdminRepository;
import pe.edu.upc.reservesonic.service.crud.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public JpaRepository<Admin, Integer> getRepository() {
		return adminRepository;
	}

}
