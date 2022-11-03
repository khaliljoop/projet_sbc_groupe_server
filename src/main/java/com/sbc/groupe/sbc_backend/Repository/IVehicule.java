package com.sbc.groupe.sbc_backend.Repository;

import com.sbc.groupe.sbc_backend.Model.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface IVehicule extends CrudRepository<Vehicule,Long> {

    @Query(value = "SELECT v.* from vehicule v where statut=:statut",nativeQuery = true)
    List<Vehicule> getVehiculeByStatut(String statut);


}
