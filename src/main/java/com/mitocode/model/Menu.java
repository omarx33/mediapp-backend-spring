package com.mitocode.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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


    @ManyToMany(fetch = FetchType.EAGER) //muchos menus tendran muchos roles
    @JoinTable(name = "menu_role", //nombre tabla que va a crear
        joinColumns =  @JoinColumn(name = "id_menu", referencedColumnName = "idMenu"), //idMenu de pk de esta tabla
            inverseJoinColumns = @JoinColumn(name = "id_role", referencedColumnName = "idRole") // de la tabla Role
    )
    private List<Role> roles;

}
