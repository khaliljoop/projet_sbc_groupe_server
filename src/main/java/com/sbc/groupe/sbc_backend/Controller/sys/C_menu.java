
package com.sbc.groupe.sbc_backend.Controller.sys;
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sbc.groupe.sbc_backend.Model.sys.M_menu;
import com.sbc.groupe.sbc_backend.Repository.sys.IMenu;

@CrossOrigin(origins = "http://localhost:9091")
@RestController
public class C_menu {
    @Autowired
    private IMenu menuRepo;

    public C_menu (){}
    @GetMapping(path = {"/getMenus"})
    @ResponseBody
    public Iterable<M_menu> getMenus()
    {
        return menuRepo.findAll();
    }

    @PostMapping(path = {"/menu/add"})
    public ResponseEntity<M_menu> addMenu(@RequestBody M_menu m){

        try {
            M_menu _menu=(M_menu) menuRepo.save(m);
            return new ResponseEntity<>(_menu, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
*/