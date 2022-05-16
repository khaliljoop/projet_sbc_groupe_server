package com.sbc.groupe.sbc_backend.Repository.sys;


import com.sbc.groupe.sbc_backend.Model.sys.M_user;
import org.springframework.data.repository.CrudRepository;

public interface IUser extends CrudRepository<M_user,Long> {
}
