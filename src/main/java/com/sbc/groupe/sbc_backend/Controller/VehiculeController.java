package com.sbc.groupe.sbc_backend.Controller;

import com.sbc.groupe.sbc_backend.Model.Personne;
import com.sbc.groupe.sbc_backend.Model.Vehicule;
import com.sbc.groupe.sbc_backend.Repository.IVehicule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:9091")
@RestController
public class VehiculeController {
    @Autowired
    private IVehicule vRepo;

    @GetMapping(path = {"/getVehicules"})
    @ResponseBody
    Iterable<Vehicule> getAllvehicule()
    {
        return vRepo.findAll();
    }
    @PostMapping({"/vehicule/add"})
    public ResponseEntity<Vehicule> addVehicule(@RequestBody Vehicule v){
        try {
            Vehicule vs= (Vehicule) vRepo.save(v);
            return new ResponseEntity<>(vs, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
