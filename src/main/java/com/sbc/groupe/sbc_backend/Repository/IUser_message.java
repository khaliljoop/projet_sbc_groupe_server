package com.sbc.groupe.sbc_backend.Repository;
import com.sbc.groupe.sbc_backend.Model.Personne;
import com.sbc.groupe.sbc_backend.Model.User_message;
import com.sbc.groupe.sbc_backend.Model.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource
@Repository
public interface IUser_message extends CrudRepository<User_message,String> {
    List<User_message> findUser_messageByUid(String uid);
    @Query(value = "SELECT * from user_message  where uid not in :list ",nativeQuery = true)
    List<User_message> getLastMessage(List<String> list);
}
