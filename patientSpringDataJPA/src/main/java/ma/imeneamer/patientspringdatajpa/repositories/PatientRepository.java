package ma.imeneamer.patientspringdatajpa.repositories;

import ma.imeneamer.patientspringdatajpa.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

// spring DATA
public interface PatientRepository extends JpaRepository<Patient,Long> {

Patient findByNom(String name);
}
