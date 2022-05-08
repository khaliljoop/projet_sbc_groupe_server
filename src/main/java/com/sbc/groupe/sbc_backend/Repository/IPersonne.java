package com.sbc.groupe.sbc_backend.Repository;
import com.sbc.groupe.sbc_backend.Model.Personne;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import java.lang.String;


@RepositoryRestResource
@Repository
public interface IPersonne extends CrudRepository<Personne,Long> {
    Personne findPersonneByUsernameAndPassword(String username, String password);
    Personne findPersonneByUsername(String username);
    Personne findPersonneByPassword(String p);
}

