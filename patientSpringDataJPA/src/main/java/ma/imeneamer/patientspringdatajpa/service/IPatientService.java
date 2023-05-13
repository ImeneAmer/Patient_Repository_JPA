package ma.imeneamer.patientspringdatajpa.service;

import ma.imeneamer.patientspringdatajpa.entities.Consultation;
import ma.imeneamer.patientspringdatajpa.entities.Medecin;
import ma.imeneamer.patientspringdatajpa.entities.Patient;
import ma.imeneamer.patientspringdatajpa.entities.RendesVous;

public interface IPatientService {

    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendesVous saveRDV(RendesVous rendesVous);
    Consultation saveConsultation(Consultation consultation);


}
