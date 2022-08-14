package com.sbc.groupe.sbc_backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Location {
    @Id
    @Column(name = "id_location")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_location;
    private Date date_debut;
    private Date date_fin;
    @Column(name ="motif",length = 500)
    private String motif;
    private String code_client;
    private int etat_location;//-1( demande location en attente pas encore valider) , 1 (valide : en cours de location ), 0 (si dispo)
    private String code_vehicule;
    private String code_personnel;


}
