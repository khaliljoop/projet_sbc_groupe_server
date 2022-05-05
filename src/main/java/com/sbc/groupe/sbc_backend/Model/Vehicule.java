package com.sbc.groupe.sbc_backend.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "vehicule")
public class Vehicule {
    @Id
    @Column(name = "id_vehicule")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_vehicule;
    @Column(name = "matricule",length = 10)
    private String matricule;
    @Column(name = "description",length = 255)
    private String description;

    @Column(name = "created")
    @Temporal(TemporalType.DATE)
    private Date created;
    @Column(name = "modified")
    @Temporal(TemporalType.DATE)
    private Date modified;
    @Column(name = "code_vehicule",length = 10,unique = true)
    private String code_vehicule;

    @Column(name = "type_carburant",length = 30)
    private String type_carburant;

    @Column(name = "statut",length = 10)
    private String statut;
    @Column(name = "url1",length = 200)
    private String url1;
    @Column(name = "url2",length = 200)
    private String url2;
    @Column(name = "url3",length = 200)
    private String url3;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_marque")
    private Marque  marque;

    public Vehicule() {
    }

    public Vehicule(String matricule, String description, Date created, Date modified, String code_vehicule,
                    String type_carburant, String statut, Marque  marque, String url1, String url2, String url3) {
        this.matricule = matricule;
        this.description = description;
        this.created = created;
        this.modified = modified;
        this.code_vehicule = code_vehicule;
        this.type_carburant = type_carburant;
        this.statut = statut;
        this.marque = marque;
        this.url1 = url1;
        this.url2 = url2;
        this.url3 = url3;
    }

    public Long getId_vehicule() {
        return id_vehicule;
    }

    public void setId_vehicule(Long id_vehicule) {
        this.id_vehicule = id_vehicule;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getCode_vehicule() {
        return code_vehicule;
    }

    public void setCode_vehicule(String code_vehicule) {
        this.code_vehicule = code_vehicule;
    }

    public String getType_carburant() {
        return type_carburant;
    }

    public void setType_carburant(String type_carburant) {
        this.type_carburant = type_carburant;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public String getUrl1() {
        return url1;
    }

    public void setUrl1(String url1) {
        this.url1 = url1;
    }

    public String getUrl2() {
        return url2;
    }

    public void setUrl2(String url2) {
        this.url2 = url2;
    }

    public String getUrl3() {
        return url3;
    }

    public void setUrl3(String url3) {
        this.url3 = url3;
    }
}
