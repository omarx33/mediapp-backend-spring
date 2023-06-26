package com.mitocode.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Consult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idConsult;
    @ManyToOne //fk
    @JoinColumn(name = "id_patient", nullable = false, foreignKey = @ForeignKey(name = "FK_consulta_paciente")) // dara el nombre a la columna fk
    private Patient patient;
    @ManyToOne //fk
    @JoinColumn(name = "id_medic", nullable = false, foreignKey = @ForeignKey(name = "FK_consulta_medica"))
    private Medic medic;
    @ManyToOne //fk
    @JoinColumn(name = "id_speciality", nullable = false, foreignKey = @ForeignKey(name = "FK_consulta_especialidad"))
    private Speciality speciality;
    @Column(nullable = false,length = 3)
    private String numConsult;
    @Column(nullable = false)
    private LocalDateTime consultDate;
}
