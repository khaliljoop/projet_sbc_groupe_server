package com.sbc.groupe.sbc_backend.Controller;

import com.sbc.groupe.sbc_backend.Model.Image;
import com.sbc.groupe.sbc_backend.Model.Vehicule;
import com.sbc.groupe.sbc_backend.Repository.IImage;
import com.sbc.groupe.sbc_backend.Repository.IVehicule;
import com.sbc.groupe.sbc_backend.constante.Constantes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = Constantes.host)
@RestController
public class VehiculeController {
    private final IVehicule vRepo;
    private final IImage imgRpo;

    public VehiculeController(IVehicule vRepo, IImage imgRpo) {
        this.vRepo = vRepo;
        this.imgRpo = imgRpo;
    }

    @GetMapping(path = {"/getVehicules"})
    @ResponseBody
    Iterable<Vehicule> getAllvehicule()
    {
        return vRepo.findAll();
    }

    @GetMapping(path = {"/getVehicule/{id}"})
    public Optional<Vehicule> getVehiculeById(@PathVariable Long id)
    {
        return vRepo.findById(id);
    }

    @GetMapping(path = {"/getVehiculeByStatut/{statut}"})
    public List<Vehicule> getVehiculeByType(@PathVariable String statut)
    {
        return vRepo.getVehiculeByStatut(statut);
    }

    @PostMapping( value = {"/vehicule/add"})
    public ResponseEntity<Vehicule> addVehicule( @RequestBody Vehicule v){
        try {
            Vehicule vs= vRepo.save(v);
            return new ResponseEntity<>(vs, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping( value = {"/vehicule/addimg"})
    public ResponseEntity <Vehicule >addVehiculeandImg(@RequestBody Vehicule v){
        try {
            List<Image> images=new ArrayList<>();
            System.out.println("liste images : "+images.toString());
                for (Image i: v.getImageList() ) {
                    i.setUrl(Constantes.upload(i.getUrl()));
                    images.add(i);
                }
                v.setImageList(images);
            Vehicule vs=vRepo.save(v);
            return new ResponseEntity<>(vs, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete_vehicule/{id}")
    public ResponseEntity<HttpStatus> deleteVehicule(@PathVariable("id") Long id) {
        try {
            vRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
