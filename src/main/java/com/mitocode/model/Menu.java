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
public class Menu {
    //no agregamos el autoincrementable para aserlo manual
    @Id
    @EqualsAndHashCode.Include
    private Integer idMenu;
    @Column(nullable = false,length = 20)
    private String icon;
    @Column(nullable = false,length = 20)
    private String name;
    // private String name = "omar"; esto si quiero darle un valor por default
    @Column(nullable = false,length = 50)
    private String url;

}
