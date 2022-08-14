package com.sbc.groupe.sbc_backend.Model.sys;

import com.sbc.groupe.sbc_backend.Model.Personne;
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
@Table(name = "sys_user")
public class M_user {
    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;
    @Column(name = "unique_id")
    private String unique_id;
    @Column(name = "id_profil")
    private int id_profil;
}
