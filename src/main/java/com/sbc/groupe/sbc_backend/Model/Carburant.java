package com.sbc.groupe.sbc_backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Carburant {
    @Id
    @Column(name = "id_carburant")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_carburant;
    private String libelle;
}
