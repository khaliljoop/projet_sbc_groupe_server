package com.sbc.groupe.sbc_backend.Repository.sys;

import com.sbc.groupe.sbc_backend.Model.sys.M_menu;
import com.sbc.groupe.sbc_backend.Model.sys.M_smenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ISmenu extends CrudRepository<M_smenu,Integer> {
    M_smenu findM_smenuByMenu(M_menu m);
}
