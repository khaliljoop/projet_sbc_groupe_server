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
@Table(name = "sys_action")
public class M_type_action {
    @Id
    @Column(name = "id_ction")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_ction;
    @Column(name = "d_read")
    private Integer d_read;
    @Column(name = "d_add")
    private Integer d_add;
    @Column(name = "d_update")
    private Integer d_update;
    @Column(name = "d_del")
    private Integer d_del;
    @Column(name = "id_smenu")
    private Integer id_smenu;
    @Column(name = "id_profil")
    private Integer id_profil;

}
