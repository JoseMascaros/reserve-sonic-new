package pe.edu.upc.reservesonic.service.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.reservesonic.model.entity.Instrument;
import pe.edu.upc.reservesonic.model.repository.InstrumentRepository;
import pe.edu.upc.reservesonic.service.crud.InstrumentService;

@Service
public class InstrumentServiceImpl implements InstrumentService {

	@Autowired
	private InstrumentRepository instrumentRepository;

	@Override
	public JpaRepository<Instrument, Integer> getRepository() {
		return instrumentRepository;
	}

}
