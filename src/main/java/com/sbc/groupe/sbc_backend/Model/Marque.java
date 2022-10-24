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

public class Marque {
    @Id
    @Column(name = "id_marque")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_marque;
    @Column(name = "libelle",length = 100)
    private String libelle;
}
