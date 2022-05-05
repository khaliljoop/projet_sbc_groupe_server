package com.sbc.groupe.sbc_backend.Model.sys;

import javax.persistence.*;

@Entity
@Table(name = "sys_profil")
public class M_type_profil {

    @Id
    @Column(name = "id_profil")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_profil;
    @Column(name = "code_profile",unique = true,nullable = false)
    private String code;
    @Column(name = "libelle",length = 50)
    private String libelle;
    @Column(name = "etat")
    private Integer etat;

    public M_type_profil() {
    }

    public M_type_profil(String code, String libelle, Integer etat) {
        this.code = code;
        this.libelle = libelle;
        this.etat = etat;
    }

    public Integer getId_profil() {
        return id_profil;
    }

    public void setId_profil(Integer id_profil) {
        this.id_profil = id_profil;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Integer getEtat() {
        return etat;
    }

    public void setEtat(Integer etat) {
        this.etat = etat;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
