package com.mitocode.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ConsultDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetail;
    @ManyToOne
    @JoinColumn(name = "id_consult", nullable = false, foreignKey = @ForeignKey(name = "FK_consulta_detalle"))
    private Consult consult;
    @Column(nullable = false,length = 70)
    private String diagnosis;
    @Column(nullable = false,length = 300)
    private String treatment;


}
