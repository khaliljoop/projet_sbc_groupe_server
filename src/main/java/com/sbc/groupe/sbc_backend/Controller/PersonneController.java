package com.sbc.groupe.sbc_backend.Controller;
import com.sbc.groupe.sbc_backend.Model.Personne;
import com.sbc.groupe.sbc_backend.Repository.IPersonne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:9091")
@RestController
//@RequestMapping("/api")
public class PersonneController {
    @Autowired
    private IPersonne personneRepo;

    public PersonneController() {}
    List<Personne> pers = new ArrayList<Personne>();

    @GetMapping(path = {"/getPersonnes"})
    @ResponseBody
    Iterable<Personne> getAllPersonne()
    {
        return personneRepo.findAll();
    }

    @GetMapping(path = {"/personne/{id_personne}"})
    public Optional<Personne> getPersonneById(@PathVariable("id_personne") Long id_personne) {
        return personneRepo.findById(id_personne);}

    @GetMapping(path = {"/getLoginPersonne"})
    public Personne getPersonneByUsername(@RequestParam String username) {
        return personneRepo.findPersonneByUsername(username);}

    @GetMapping({"/personne/findLogin"})
    public Personne getPersonneByLogin(@RequestParam String username, @RequestParam String password) {
        return  personneRepo.findPersonneByUsernameAndPassword(username,password);}

    @PostMapping({"/personne/add"})
    public ResponseEntity<Personne> addPersonne(@RequestBody Personne p){
        try {
            //p.getId_personne(),
            Personne _pers=(Personne) personneRepo.save(p);
            return new ResponseEntity<>(_pers, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
