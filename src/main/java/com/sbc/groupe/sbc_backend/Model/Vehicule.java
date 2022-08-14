package com.sbc.groupe.sbc_backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "vehicule")
public class Vehicule {
    @Id
    @Column(name = "id_vehicule")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_vehicule;
    @Column(name = "matricule",length = 10)
    private String matricule;
    @Column(name = "description")
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
    @Column(name = "id_marque")
    private Long  id_marque;

}
