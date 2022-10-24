package com.sbc.groupe.sbc_backend.Repository.sys;

import com.sbc.groupe.sbc_backend.Model.sys.M_menu;
import com.sbc.groupe.sbc_backend.Model.sys.M_smenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ISmenu extends CrudRepository<M_smenu,Integer> {
    //M_smenu findM_smenuByMenu(M_menu m);
    @Query(value = "select sm from M_smenu  sm where sm.id_smenu=:id_menu")
    List<M_smenu> findM_smenuByMenu(Integer id_menu);
    //List<M_smenu> findM_smenuByMenu(M_menu menu);
    @Query(value = "select sm from M_smenu  sm where sm.id_menu=:id_menu")
    List<M_smenu> getSmenuIdmenu(Integer id_menu);
    @Modifying
    @Query(value = "delete from M_smenu  sm where sm.id_menu=:id_menu")
    void deleteSmenuByMenu(Integer id_menu);
}
