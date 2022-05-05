package com.sbc.groupe.sbc_backend.Model.sys;

import javax.persistence.*;

@Entity
@Table(name = "sys_menu")
public class M_menu {
    @Id
    @Column(name = "id_menu")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_menu;
    @Column(name = "code")
    private String code;
    @Column(name = "libelle")
    private String libelle;
    @Column(name = "etat")
    private Integer  etat;

    public M_menu() {
    }

    public M_menu(String code, String libelle, Integer etat) {
        this.code = code;
        this.libelle = libelle;
        this.etat = etat;
    }

    public Integer getId_menu() {
        return id_menu;
    }

    public void setId_menu(Integer id_menu) {
        this.id_menu = id_menu;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
}
