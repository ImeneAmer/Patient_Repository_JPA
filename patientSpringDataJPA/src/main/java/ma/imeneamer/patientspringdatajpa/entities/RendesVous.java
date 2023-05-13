package ma.imeneamer.patientspringdatajpa.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class RendesVous {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    // On peut definir id de type string
    private Long id;
    private Date dateRendezVous;
    @Enumerated(EnumType.STRING)
    private StatusRDV statusRDV;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Patient patient;
    @ManyToOne
    private Medecin medecin;
    @OneToOne(mappedBy = "rendesVous")
  //  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private Consultation consultation;


}
