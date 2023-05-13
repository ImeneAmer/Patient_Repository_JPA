package ma.imeneamer.patientspringdatajpa;

import ma.imeneamer.patientspringdatajpa.entities.*;
import ma.imeneamer.patientspringdatajpa.repositories.ConsultationRepository;
import ma.imeneamer.patientspringdatajpa.repositories.MedecinRepository;
import ma.imeneamer.patientspringdatajpa.repositories.PatientRepository;
import ma.imeneamer.patientspringdatajpa.repositories.RendezVousRepository;
import ma.imeneamer.patientspringdatajpa.service.IPatientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class PatientSpringDataJpaApplication  {
    private final ConsultationRepository consultationRepository;

    public PatientSpringDataJpaApplication(ConsultationRepository consultationRepository) {
        this.consultationRepository = consultationRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(PatientSpringDataJpaApplication.class, args);


    }


    /* @Bean
    CommandLineRunner start(/*PatientRepository patientRepository,
                            MedecinRepository medecinRepository,
                            RendezVousRepository rendezVousRepository,
                            ConsultationRepository consultationRepository){ */
    // or
  @Bean
    CommandLineRunner start(IPatientService patientService,
                            PatientRepository patientRepository,
                            RendezVousRepository rendezVousRepository,
                            MedecinRepository medecinRepository){
        return args -> {
            Stream.of("Mohamed","Hassan","Najat")
                    .forEach(name->{
                        Patient patient=new Patient();
                        patient.setNom(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(false);
                      //  patientRepository.save(patient);
                        patientService.savePatient(patient);

                    });
         //   patientRepository.save(new Patient(null,"Hassab",new Date(),false,null));

            Stream.of("Dr.Kamal","Dr.Nawal","Dr.Imane")
                    .forEach(name->{

                        Medecin medecin=new Medecin();
                        medecin.setNom(name);
                        medecin.setEmail(name+"@gmail.com");
                        medecin.setSpecialite(Math.random()>0.5?"Cardio":"Generaliste");
                    //    medecinRepository.save(medecin);
                        patientService.saveMedecin(medecin);

                    });

                  Patient patient=patientRepository.findById(1L).orElse(null);
                  Patient patient1=patientRepository.findByNom("Hassan");

                  Medecin medecin=medecinRepository.findByNom("Dr.Kamal");
            RendesVous rendesVous = new RendesVous();
            rendesVous.setDateRendezVous(new Date());
            rendesVous.setStatusRDV(StatusRDV.PENDING);
            rendesVous.setPatient(patient);
            rendesVous.setMedecin(medecin);
            RendesVous saveDRDV=patientService.saveRDV(rendesVous);
            System.out.println(saveDRDV.getId());
          //  rendezVousRepository.save(rendesVous);


            //RendesVous rendesVous1=rendezVousRepository.findById(1L).orElse(null);

            // relatif à la partie UUID
            //  RendesVous rendesVous2=rendezVousRepository.findAll().get(0);
            Consultation consultation=new Consultation();
            consultation.setDateConsultation(rendesVous.getDateRendezVous());
            consultation.setRendesVous(rendesVous);
            consultation.setRapport("le rapport de la consultation ....");
           // consultationRepository.save(consultation);
            patientService.saveConsultation(consultation);

        };
    }
}
