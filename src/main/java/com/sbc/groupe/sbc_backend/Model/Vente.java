package com.sbc.groupe.sbc_backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Vente {
    @Id
    @Column(name = "id_vente",length = 32)
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id_vente;
    private Date decision;
    private String code_client;
    private int etat_vente;//-1( demande location en attente pas encore valider) , 1 (valide : en cours de location ), 0 (si dispo)
    private String code_vehicule;
    private String code_personnel;
}
