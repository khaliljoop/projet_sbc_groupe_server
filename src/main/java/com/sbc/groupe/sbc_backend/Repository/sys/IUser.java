package com.sbc.groupe.sbc_backend.Repository.sys;


import com.sbc.groupe.sbc_backend.Model.sys.M_user;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.transaction.Transactional;
import java.util.Date;

public interface IUser extends CrudRepository<M_user,Long> {
    @RestResource
    @Transactional
    @Modifying
    @Query(value = "UPDATE M_user u SET u.id_profil=:id_profil where u.unique_id=:uid ")
    Integer updateUser(String uid, Integer id_profil);
}
