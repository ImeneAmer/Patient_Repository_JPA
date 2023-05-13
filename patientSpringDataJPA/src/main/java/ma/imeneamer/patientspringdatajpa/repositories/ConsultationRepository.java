package ma.imeneamer.patientspringdatajpa.repositories;

import ma.imeneamer.patientspringdatajpa.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {

}
