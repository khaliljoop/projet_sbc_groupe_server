package com.sbc.groupe.sbc_backend.Repository;

import com.sbc.groupe.sbc_backend.Model.Marque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IMarque extends CrudRepository<Marque,Integer> {

}
