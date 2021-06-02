package pe.edu.upc.reservesonic.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.reservesonic.model.entity.Instrument;

@Repository
public interface InstrumentRepository extends JpaRepository<Instrument, Integer> {

}
