package com.sbc.groupe.sbc_backend.Model.sys;

import com.sbc.groupe.sbc_backend.Model.Personne;

import javax.persistence.*;

@Entity
@Table(name = "sys_user")
public class M_user {
    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;
    @ManyToOne
    @JoinColumn(name = "unique_id")
    private Personne personne;
    @ManyToOne
    @JoinColumn(name = "code")
    private M_type_profil profil;

    public  M_user() {}
}
