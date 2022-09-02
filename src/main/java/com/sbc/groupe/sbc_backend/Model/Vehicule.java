package com.sbc.groupe.sbc_backend.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private int type_carburant;
    @Column(name = "statut",length = 10) // statut='vente','location','transport'
    private String statut;
    @OneToMany( cascade = {CascadeType.ALL})
    @JoinColumn(name = "code_vehicule",referencedColumnName = "id_vehicule")
    private List<Image> imageList=new ArrayList<>();
    @Column(name = "id_marque")
    private int  id_marque;

}
