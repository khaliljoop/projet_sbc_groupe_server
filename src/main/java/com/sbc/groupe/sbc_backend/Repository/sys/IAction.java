package com.sbc.groupe.sbc_backend.Repository.sys;

import com.sbc.groupe.sbc_backend.Model.sys.M_smenu;
import com.sbc.groupe.sbc_backend.Model.sys.M_type_action;
import com.sbc.groupe.sbc_backend.Model.sys.M_type_profil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface IAction extends JpaRepository<M_type_action,Integer> {
    M_type_action findMTypeActionBySmenuAndProfil(Integer smenu, Integer profil);
    @RestResource
    M_type_action getMTypeActionBySmenu(Integer id);
    M_type_action getMTypeActionByProfil(Integer id);
}
