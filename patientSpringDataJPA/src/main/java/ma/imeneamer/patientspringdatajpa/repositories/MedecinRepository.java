package ma.imeneamer.patientspringdatajpa.repositories;

import ma.imeneamer.patientspringdatajpa.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {


    Medecin findByNom(String name);
}
