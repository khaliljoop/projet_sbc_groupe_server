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
public class Nous_ecrire {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date _date;
    private String nom ;
    private String email;
    private String telephone;
    private String adresse;
    @Column(length = 2000)
    private String motif;

}
