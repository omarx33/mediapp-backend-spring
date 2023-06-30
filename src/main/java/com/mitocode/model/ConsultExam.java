package com.mitocode.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@IdClass(ConsultExamPK.class)

public class ConsultExam {
    // pk conpuesta
    @Id
    private Consult consult;
    @Id
    private Exam exam;


}
