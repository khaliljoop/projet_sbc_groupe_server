package com.sbc.groupe.sbc_backend.Controller.sys;


import com.sbc.groupe.sbc_backend.Model.sys.*;
import com.sbc.groupe.sbc_backend.Repository.sys.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@CrossOrigin(origins = "http://localhost:9091")
@RestController
public class C_securite {
    @Autowired
    private IMenu menuRepo;
    @Autowired
    private ISmenu smenuRepo;
    @Autowired
    private IProfil profilRepo;
    @Autowired
    private IAction actionRepo;
    @Autowired
    private IUser userRepo;
    public C_securite(){}

    /*************** ------- Menu --------- ***************/
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
    @GetMapping(path = {"/getMenuByCode"})
    public M_menu getMenuByIdMenu(@RequestParam String code) {
        return menuRepo.findM_menuByCode(code);}

    @GetMapping(path = {"/getMenuById"})
    public Optional<M_menu> getMenuById(@RequestParam Integer id) {
        return menuRepo.findById(id);}
    /*************** ------- Sous menu --------- ***************/
    @GetMapping(path = {"/getSmenus"})
    @ResponseBody
    public Iterable<M_smenu> getSmenus()
    {
        //List all = secRepo.findAll();
        return smenuRepo.findAll();
    }

    @PostMapping(path = {"/smenu/add"})
    public ResponseEntity<M_smenu> addSMenu(@RequestBody M_smenu sm){

        try {
            M_smenu _menu=(M_smenu) smenuRepo.save(sm);
            return new ResponseEntity<>(_menu, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = {"/getSmenuByMenu"})
    public M_smenu getSmenuByMenu(@RequestParam M_menu m) {
        return smenuRepo.findM_smenuByMenu(m);}


    /*************** ------- Profil --------- ***************/
    @GetMapping(path = {"/getProfils"})
    @ResponseBody
    public Iterable<M_type_profil> getProfils()
    {
        //List all = secRepo.findAll();
        return profilRepo.findAll();
    }

    @PostMapping(path = {"/profil/add"})
    public ResponseEntity<M_type_profil> addProfil(@RequestBody M_type_profil profil){

        try {
            M_type_profil _profil=(M_type_profil) profilRepo.save(profil);
            return new ResponseEntity<>(_profil, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*************** ------- Action --------- ***************/
    @GetMapping(path = {"/getActions"})
    @ResponseBody
    public Iterable<M_type_action> getActions()
    {
        //List all = secRepo.findAll();
        return actionRepo.findAll();
    }

    @PostMapping(path = {"/action/add"})
    public ResponseEntity<M_type_action> addAction(@RequestBody M_type_action action){

        try {
            M_type_action _action=(M_type_action) actionRepo.save(action);
            return new ResponseEntity<>(_action, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update_action/{id}")
    public ResponseEntity<M_type_action> updateTutorial(@PathVariable("id") Integer id, @RequestBody M_type_action action) {
        Optional<M_type_action> actionData = actionRepo.findById(id);

        if (actionData.isPresent()) {
            M_type_action _action = actionData.get();
            _action.setD_read(action.getD_read());
            _action.setD_add(action.getD_add());
            _action.setD_update(action.getD_update());
            _action.setD_del(action.getD_del());
            _action.setSmenu(action.getSmenu());
            _action.setProfil(action.getProfil());
            return new ResponseEntity<>(actionRepo.save(_action), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete_action/{id}")
    public ResponseEntity<HttpStatus> deleteAction(@PathVariable("id") Integer id) {
        try {
            actionRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete_actions")
    public ResponseEntity<HttpStatus> deleteActions() {
        try {
            actionRepo.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /*************** ------- USER --------- ***************/
    @GetMapping(path = {"/getUsers"})
    @ResponseBody
    public Iterable<M_user> getUsers()
    {
        //List all = secRepo.findAll();
        return userRepo.findAll();
    }

    @PostMapping(path = {"/user/add"})
    public ResponseEntity<M_user> addUser(@RequestBody M_user user){

        try {
            M_user _user=(M_user) userRepo.save(user);
            return new ResponseEntity<>(_user, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
