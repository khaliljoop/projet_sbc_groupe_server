package com.sbc.groupe.sbc_backend.Model.sys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "sys_profil")
public class M_type_profil {
    @Id
    @Column(name = "id_profil")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_profil;
   /* @OneToMany( cascade = {
            CascadeType.ALL
    })
    @JoinColumn(name = "id_profil",referencedColumnName = "id_profil")
    private List<M_type_action> actions=new ArrayList<>();*/
    @Column(name = "code_profile",unique = true,nullable = false)
    private String code;
    @Column(name = "libelle",length = 50)
    private String libelle;
    @Column(name = "etat")
    private Integer etat;
}
