package com.sbc.groupe.sbc_backend.Model.sys;

import javax.persistence.*;

@Entity
@Table(name = "sys_smenu")
public class M_smenu {
    @Id
    @Column(name = "id_smenu")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_smenu;
    @ManyToOne
    @JoinColumn(name = "id_menu")
    private M_menu menu;
    @Column(name = "code")
    private String code;
    @Column(name = "libelle")
    private String libelle;
    @Column(name = "etat")
    private Integer  etat;

    public M_smenu() {
    }

    public M_smenu(M_menu menu, String code, String libelle, Integer etat) {
        this.menu = menu;
        this.code = code;
        this.libelle = libelle;
        this.etat = etat;
    }

    public Integer getId_smenu() {
        return id_smenu;
    }

    public void setId_smenu(Integer id_smenu) {
        this.id_smenu = id_smenu;
    }

    public M_menu getMenu() {
        return menu;
    }

    public void setMenu(M_menu menu) {
        this.menu = menu;
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
