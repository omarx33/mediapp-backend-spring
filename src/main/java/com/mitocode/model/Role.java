package com.mitocode.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Role {
    //no agregamos el autoincrementable para aserlo manual
    @Id
    @EqualsAndHashCode.Include
    private Integer idRole;
    @Column(nullable = false,length = 50)
    private String name;
    @Column(nullable = false,length = 100)
    private String description;

}
