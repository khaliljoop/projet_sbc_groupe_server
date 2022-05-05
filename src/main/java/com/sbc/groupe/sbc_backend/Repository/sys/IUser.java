package com.sbc.groupe.sbc_backend.Repository.sys;


import com.sbc.groupe.sbc_backend.Model.sys.M_user;
import org.springframework.data.jpa.repository.JpaRepository;
public interface IUser extends JpaRepository<M_user,Long> {
}
