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
@Table(name = "sys_menu")
public class M_menu {
    @Id
    @Column(name = "id_menu")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_menu;
   /* @OneToMany( cascade = {
            CascadeType.ALL
    })
    @JoinColumn(name = "id_menu",referencedColumnName = "id_menu")
    private List<M_smenu> smenu=new ArrayList<>();*/
    @Column(name = "code")
    private String code;
    @Column(name = "libelle")
    private String libelle;
    @Column(name = "etat")
    private Integer  etat;
}
