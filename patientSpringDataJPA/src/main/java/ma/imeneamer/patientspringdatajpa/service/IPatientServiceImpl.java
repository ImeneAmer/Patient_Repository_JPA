package ma.imeneamer.patientspringdatajpa.service;

import ma.imeneamer.patientspringdatajpa.entities.Consultation;
import ma.imeneamer.patientspringdatajpa.entities.Medecin;
import ma.imeneamer.patientspringdatajpa.entities.Patient;
import ma.imeneamer.patientspringdatajpa.entities.RendesVous;
import ma.imeneamer.patientspringdatajpa.repositories.ConsultationRepository;
import ma.imeneamer.patientspringdatajpa.repositories.MedecinRepository;
import ma.imeneamer.patientspringdatajpa.repositories.PatientRepository;
import ma.imeneamer.patientspringdatajpa.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class IPatientServiceImpl implements IPatientService {

    private PatientRepository patientRepository;

    private MedecinRepository medecinRepository;

    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;

    public IPatientServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {

        return medecinRepository.save(medecin);
    }

    @Override
    public RendesVous saveRDV(RendesVous rendesVous) {
        // créer des ID type String d'une maniere aléatoire
      //  rendesVous.setId((UUID.randomUUID().toString());
        return rendezVousRepository.save(rendesVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {

        return consultationRepository.save(consultation);
    }
}
