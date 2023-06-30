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

@Table(name = "user_data")
public class User {
    @Id
    @EqualsAndHashCode.Include
    private Integer idUser;
    @Column(nullable = false,length = 60, unique = true)
    private String username;
    @Column(nullable = false,length = 60)
    private String password;
    @Column(nullable = false)
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER) //muchos menus tendran muchos roles
    @JoinTable(name = "user_role", //nombre tabla que va a crear
            joinColumns =  @JoinColumn(name = "id_user", referencedColumnName = "idUser"), //idMenu de pk de esta tabla
            inverseJoinColumns = @JoinColumn(name = "id_role", referencedColumnName = "idRole") // de la tabla Role
    )
    private List<Role> roles;
}
