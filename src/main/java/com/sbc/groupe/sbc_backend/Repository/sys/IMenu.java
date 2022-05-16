package com.sbc.groupe.sbc_backend.Repository.sys;

import com.sbc.groupe.sbc_backend.Model.sys.M_menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IMenu extends CrudRepository<M_menu,Integer> {
    M_menu findM_menuByCode(String id);
}
