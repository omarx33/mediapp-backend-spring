package com.mitocode.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "Paciente")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPatient;
    @Column(name = "idPaciente", length = 70, nullable = false)
    private String firstName;
    @Column( length = 70, nullable = false)
    private String lasttName;
    @Column( length = 8, nullable = false)
    private String dni;
    @Column( length = 150)
    private String address;
    @Column( length = 9, nullable = false)
    private String phone;
    @Column( length = 55, nullable = false)
    private String email;


}
