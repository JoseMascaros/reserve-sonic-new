package pe.edu.upc.reservesonic.service.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.reservesonic.model.entity.Reservation;
import pe.edu.upc.reservesonic.model.repository.ReservationRepository;
import pe.edu.upc.reservesonic.service.crud.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService{

	@Autowired
	private ReservationRepository reservationRepository;
	
	@Override
	public JpaRepository<Reservation, Integer> getRepository() {
		return reservationRepository;
	}
	
}
