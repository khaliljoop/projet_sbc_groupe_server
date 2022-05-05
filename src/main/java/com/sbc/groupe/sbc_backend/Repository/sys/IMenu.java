package com.sbc.groupe.sbc_backend.Repository.sys;

import com.sbc.groupe.sbc_backend.Model.sys.M_menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMenu extends JpaRepository<M_menu,Integer> {
}
