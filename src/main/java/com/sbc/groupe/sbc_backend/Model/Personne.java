package com.sbc.groupe.sbc_backend.Model;
import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "personne")
public class Personne {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_personne",length = 20)//nullable = false
    private Long id_personne;
    @Column(name = "unique_id",length = 8,unique = true,nullable = false)
    private String unique_id;
    @Column(name = "prenom",length = 40)
    private String prenom;
    @Column(name = "nom",length = 20)
    private String nom;
    @Column(name = "sexe",length = 1)
    private String sexe;
    @Column(name = "adresse",length = 100)
    private String adresse;
    @Column(name = "telephone",length = 20)
    private String telephone;
    @Column(name = "email",length = 100)
    private String email;
    @Column(name = "username",length = 40)
    private String username;
    @Column(name = "password",length = 255)
    private String password;
    @Column(name = "etat_compte",length = 1)
    private int etat_compte;

    public Personne() { }
    public Personne( String unique_id, String prenom, String nom, String sexe, String adresse, String telephone, String email, String username, String password, Integer etat_compte) {
        this.unique_id = unique_id;
        this.prenom = prenom;
        this.nom = nom;
        this.sexe = sexe;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
        this.username = username;
        this.password = password;
        this.etat_compte = etat_compte;
    }


    public Long getId_personne() {
        return id_personne;
    }

    public void setId_personne(Long id_personne) {
        this.id_personne = id_personne;
    }


    public String getUnique_id() {
        return unique_id;
    }

    public void setUnique_id(String unique_id) {
        this.unique_id = unique_id;
    }


    public String getPrenom() {
        return prenom;
    }


    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }


    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Integer getEtat_compte() {
        return etat_compte;
    }

    public void setEtat_compte(Integer etat_compte) {
        this.etat_compte = etat_compte;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "id_personne=" + id_personne +
                ", unique_id='" + unique_id + '\'' +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", sexe='" + sexe + '\'' +
                ", adresse='" + adresse + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", etat_compte=" + etat_compte +
                '}';
    }
}

