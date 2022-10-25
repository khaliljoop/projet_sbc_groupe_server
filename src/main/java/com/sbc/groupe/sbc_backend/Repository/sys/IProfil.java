package com.sbc.groupe.sbc_backend.Repository.sys;

import com.sbc.groupe.sbc_backend.Model.sys.M_type_profil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IProfil extends CrudRepository<M_type_profil,Integer> {

    @Query(value = "SELECT p.* FROM sys_profil p,sys_user u, personne pers  WHERE p.id_profil=u.id_profil AND u.unique_id=pers.unique_id AND pers.unique_id=:id",nativeQuery = true)
    M_type_profil getProfilByUid(String id);

}
