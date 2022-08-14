package com.sbc.groupe.sbc_backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Infosbc {

    @Id
    private Long id;
    @Column(name="adresse",length = 1000)
    private String adresse;
    private String mail_sbc;
    private Date modified;
}
