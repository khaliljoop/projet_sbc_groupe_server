package com.sbc.groupe.sbc_backend.Controller;

import com.sbc.groupe.sbc_backend.Model.Marque;
import com.sbc.groupe.sbc_backend.Repository.IMarque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:9091")
@Controller
public class MarqueController {
    @Autowired
    private IMarque marqueRepo;

    @PostMapping("/marque/add")
    public ResponseEntity<Marque> addMarque(@RequestBody Marque m)
    {
        try
        {
            Marque _m=(Marque)marqueRepo.save(m);
            return new ResponseEntity<>(_m,HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
