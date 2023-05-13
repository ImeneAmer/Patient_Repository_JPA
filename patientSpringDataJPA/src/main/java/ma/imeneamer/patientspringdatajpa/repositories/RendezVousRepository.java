package ma.imeneamer.patientspringdatajpa.repositories;

import ma.imeneamer.patientspringdatajpa.entities.RendesVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendesVous,Long> {
}

// relatif à la partie UUID faut changer le type de ID sur le JpaRepository
/*
public interface RendezVousRepository extends JpaRepository<RendesVous,String> {
}

 */
