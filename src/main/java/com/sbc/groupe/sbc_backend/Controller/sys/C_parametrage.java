package com.sbc.groupe.sbc_backend.Controller.sys;
import com.sbc.groupe.sbc_backend.Model.Carburant;
import com.sbc.groupe.sbc_backend.Model.Marque;
import com.sbc.groupe.sbc_backend.Model.sys.M_menu;
import com.sbc.groupe.sbc_backend.Repository.ICarburant;
import com.sbc.groupe.sbc_backend.Repository.IMarque;
import com.sbc.groupe.sbc_backend.constante.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = Constantes.host)
@Controller
public class C_parametrage {
    @Autowired
    private IMarque marqueRepo;
    @Autowired
    private ICarburant carburant;

    /*************************** Param Marque ****************************************/

    @PostMapping("/marque/add")
    public ResponseEntity<Marque> addMarque(@RequestBody Marque m)
    {
        try
        {
            Marque _m=marqueRepo.save(m);
            return new ResponseEntity<>(_m, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping(path = {"/getMarques"})
    @ResponseBody
    public List<Marque> getMarques()
    {
        return (List<Marque>) marqueRepo.findAll();
    }

    /*************************** Param Carburant ****************************************/
    @PostMapping("/carburant/add")
    public ResponseEntity<Carburant> addCarburant(@RequestBody Carburant c)
    {
        try
        {
            Carburant _c=carburant.save(c);
            return new ResponseEntity<>(_c, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping(path = {"/getCarburants"})
    @ResponseBody
    public List<Carburant> getCarburants()
    {
        return  carburant.findAll();
    }


}
