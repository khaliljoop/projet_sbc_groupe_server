package com.sbc.groupe.sbc_backend.Repository;
import com.sbc.groupe.sbc_backend.Model.User_message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface IUser_message extends JpaRepository<User_message,String> {
}
