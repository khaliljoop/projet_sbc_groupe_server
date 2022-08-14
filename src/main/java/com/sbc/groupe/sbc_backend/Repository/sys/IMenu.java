package com.sbc.groupe.sbc_backend.Repository.sys;

import com.sbc.groupe.sbc_backend.Model.sys.M_menu;
import com.sbc.groupe.sbc_backend.Model.sys.M_smenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IMenu extends CrudRepository<M_menu,Integer> {
    M_menu findM_menuByCode(String code);
    /*@Query(value = "select sm from M_smenu  sm where sm.menu.id_menu=:id_menu")
    List<M_smenu> getSmenuByMenu(Integer id_menu);*/
}
