package com.sbc.groupe.sbc_backend.Repository.sys;

import com.sbc.groupe.sbc_backend.Model.sys.M_smenu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISmenu extends JpaRepository<M_smenu,Integer> {
}