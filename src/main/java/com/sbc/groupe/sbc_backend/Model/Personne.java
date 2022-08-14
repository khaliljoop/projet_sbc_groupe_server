package com.sbc.groupe.sbc_backend.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "personne")
public class Personne {
    @Id
    /*@GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_personne",length = 20)//nullable = false
    private Long id_personne;*/
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id_personne;
    @Column(name = "unique_id",length = 8,unique = true,nullable = false)
    private String unique_id;
    @Column(name = "prenom",length = 40)
    private String prenom;
    @Column(name = "nom",length = 20)
    private String nom;
    @Column(name = "sexe",length = 1)
    private String sexe;
    @Column(name = "adresse",length = 120)
    private String adresse;
    @Column(name = "telephone",length = 20)
    private String telephone;
    @Column(name = "email",length = 100)
    private String email;
    @Column(name = "username",length = 40)
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "etat_compte",length = 1)
    private int etat_compte;

}

