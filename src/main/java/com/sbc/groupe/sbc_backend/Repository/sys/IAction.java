package com.sbc.groupe.sbc_backend.Repository.sys;

import com.sbc.groupe.sbc_backend.Model.sys.M_type_action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAction extends JpaRepository<M_type_action,Integer> {
    //M_type_action findMTypeActionBySmenuAndProfil(Integer smenu, Integer profil);
   // @RestResource
   // M_type_action getMTypeActionBySmenu(Integer id);
    //M_type_action getMTypeActionByProfil(Integer id);
    //List<M_type_action> getM_type_actionById_profil(Integer id_profil);
    @Query(value = "select a from M_type_action  a where a.id_profil=:id_profil")
    List<M_type_action> getM_type_actionById_profil(Integer id_profil);

    @Modifying
    @Query(value = "delete from M_type_action  a where a.id_smenu=:id_smenu")
    void delelete_actionById_smenu(Integer id_smenu);
}
