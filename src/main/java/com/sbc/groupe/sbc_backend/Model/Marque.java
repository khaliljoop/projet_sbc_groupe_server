package com.sbc.groupe.sbc_backend.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Marque {
    @Id
    @Column(name = "id_marque")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_marque;
    @Column(name = "libelle",length = 100)
    private String libelle;
    @Column(name = "created")
    @Temporal(TemporalType.DATE)
    private Date created;
    @Column(name = "modified")
    @Temporal(TemporalType.DATE)
    private Date modified;

    public Marque() {
    }

    public Marque(String libelle, Date created, Date modified) {
        this.libelle = libelle;
        this.created = created;
        this.modified = modified;
    }

    public Long getId_marque() {
        return id_marque;
    }

    public void setId_marque(Long id_marque) {
        this.id_marque = id_marque;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }
}
