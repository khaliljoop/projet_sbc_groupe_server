package com.sbc.groupe.sbc_backend.Model.sys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "sys_smenu")
public class M_smenu {
    @Id
    @Column(name = "id_smenu")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @GeneratedValue(generator="system-uuid")
    //@GenericGenerator(name="system-uuid", strategy = "uuid")
    private Integer id_smenu;
   /* @OneToMany( cascade = {
            CascadeType.ALL
    })
    @JoinColumn(name = "id_smenu",referencedColumnName = "id_smenu")
    private List<M_type_action> actions=new ArrayList<>();*/
    @Column(name = "code")
    private String code;
    @Column(name = "libelle")
    private String libelle;
    @Column(name = "etat")
    private Integer  etat;
    @Column(name = "id_menu")
    private Integer id_menu;

}
