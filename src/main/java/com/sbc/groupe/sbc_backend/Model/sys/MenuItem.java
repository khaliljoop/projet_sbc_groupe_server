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

   /* public MenuItem(M_menu menu, List<M_smenu> smenu) {
        this.menu = menu;
        this.smenu = smenu;
    }
    public MenuItem() {}

    public M_menu getMenu() {
        return menu;
    }

    public void setMenu(M_menu menu) {
        this.menu = menu;
    }

    public List<M_smenu> getSmenu() {
        return smenu;
    }

    public void setSmenu(List<M_smenu> smenu) {
        this.smenu = smenu;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "menu=" + menu +
                ", smenu=" + smenu +
                '}';
    }*/
}
