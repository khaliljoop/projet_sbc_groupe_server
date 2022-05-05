package com.sbc.groupe.sbc_backend.Repository.sys;

import com.sbc.groupe.sbc_backend.Model.sys.M_type_action;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAction extends JpaRepository<M_type_action,Integer> {
}
