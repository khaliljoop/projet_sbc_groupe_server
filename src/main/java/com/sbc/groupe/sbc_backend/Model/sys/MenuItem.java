package com.sbc.groupe.sbc_backend.Model.sys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.context.annotation.Bean;

import javax.annotation.ManagedBean;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ManagedBean
public class MenuItem implements Serializable {
    private M_menu menu;
    private List<M_smenu> smenu;
}
