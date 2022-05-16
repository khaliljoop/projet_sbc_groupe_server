package com.sbc.groupe.sbc_backend.Model.sys;

import javax.persistence.*;

@Entity
@Table(name = "sys_action")
public class M_type_action {
    @Id
    @Column(name = "id_ction")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_ction;
    @ManyToOne
    @JoinColumn(name = "id_profile")
    private M_type_profil profil;
    @ManyToOne
    @JoinColumn(name = "id_smenu")
    private M_smenu smenu;

    @Column(name = "d_read")
    private Integer d_read;
    @Column(name = "d_add")
    private Integer d_add;
    @Column(name = "d_update")
    private Integer d_update;
    @Column(name = "d_del")
    private Integer d_del;
    public  M_type_action (){}

    public M_type_action(M_type_profil profil,M_smenu smenu, Integer d_read, Integer d_add, Integer d_update, Integer d_del) {

        this.profil = profil;
        this.smenu = smenu;
        this.d_read = d_read;
        this.d_add = d_add;
        this.d_update = d_update;
        this.d_del = d_del;
    }

    public Integer getId_ction() {
        return id_ction;
    }

    public void setId_ction(Integer id_ction) {
        this.id_ction = id_ction;
    }

   public M_type_profil getProfil() {
        return profil;
    }

    public void setProfil(M_type_profil profil) {
        this.profil = profil;
    }

    public M_smenu getSmenu() {
        return smenu;
    }

    public void setSmenu(M_smenu smenu) {
        this.smenu = smenu;
    }

    public Integer getD_read() {
        return d_read;
    }

    public void setD_read(Integer d_read) {
        this.d_read = d_read;
    }

    public Integer getD_add() {
        return d_add;
    }

    public void setD_add(Integer d_add) {
        this.d_add = d_add;
    }

    public Integer getD_update() {
        return d_update;
    }

    public void setD_update(Integer d_update) {
        this.d_update = d_update;
    }

    public Integer getD_del() {
        return d_del;
    }

    public void setD_del(Integer d_del) {
        this.d_del = d_del;
    }
}
