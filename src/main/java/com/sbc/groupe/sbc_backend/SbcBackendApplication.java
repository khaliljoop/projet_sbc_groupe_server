package com.sbc.groupe.sbc_backend;

import com.sbc.groupe.sbc_backend.Controller.PersonneController;
import com.sbc.groupe.sbc_backend.Model.Personne;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;

@SpringBootApplication
public class SbcBackendApplication {

	static PersonneController p;

	public static void main(String[] args) {

		SpringApplication.run(SbcBackendApplication.class, args);
	}

}
