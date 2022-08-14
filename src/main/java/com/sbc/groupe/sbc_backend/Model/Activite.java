package com.sbc.groupe.sbc_backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.ValueGenerationType;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Activite {
    @Id
    @Column(name = "id_activite")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_activite;
    private int type_activite;
    @Column(name="description",length = 3000)
    private String description;
    private String libelle;

}
