package com.sbc.groupe.sbc_backend.Repository;

import com.sbc.groupe.sbc_backend.Model.Activite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface IActivite extends JpaRepository<Activite,Integer> {
}
