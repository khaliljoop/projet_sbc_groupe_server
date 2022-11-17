package com.sbc.groupe.sbc_backend.Repository;
import com.sbc.groupe.sbc_backend.Model.Personne;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import java.lang.String;
import java.util.List;


@RepositoryRestResource
@Repository
public interface IPersonne extends CrudRepository<Personne,String> {
    Personne findPersonneByUsernameAndPassword(String username, String password);
    Personne findPersonneByUsername(String username);
    Personne findPersonneByPassword(String p);

    @Query(value = "SELECT p.* from personne p,sys_user u,sys_profil pr where p.unique_id=u.unique_id and pr.id_profil=u.id_profil and pr.code_profile='ASSISTANT'",nativeQuery = true)
    Personne getAssistant();
    @Query(value = "SELECT p.* from personne p,sys_user u,sys_profil pr where p.unique_id=u.unique_id and pr.id_profil=u.id_profil and pr.code_profile='CLIENT' and  p.unique_id in(SELECT DISTINCT (sender_message_id) from user_message where is_blocked=-1) ",nativeQuery = true)
    List<Personne> getPersonneBySender_message_id();
}

