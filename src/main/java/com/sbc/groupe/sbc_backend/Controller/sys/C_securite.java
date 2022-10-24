package com.sbc.groupe.sbc_backend.Controller.sys;


import com.sbc.groupe.sbc_backend.Model.sys.*;
import com.sbc.groupe.sbc_backend.Repository.sys.*;
import com.sbc.groupe.sbc_backend.constante.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = Constantes.host)
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
    public List<M_menu> getMenus()
    {
        return (List<M_menu>) menuRepo.findAll();
    }

    @GetMapping(path = "/getAllMenus")
    public List<MenuItem> getAllMenu()
    {
        List<MenuItem> list=new ArrayList<>();
        List<M_menu> menus= (List<M_menu>) menuRepo.findAll();

        for (M_menu menu : menus) {
            list.add(new MenuItem(menu,smenuRepo.getSmenuIdmenu(menu.getId_menu())));
        }
        return list;
    }

    @PostMapping(path = {"/menu/add"})
    public ResponseEntity<M_menu> addMenu(@RequestBody M_menu m){
        try {
            M_menu _menu= menuRepo.save(m);
            return new ResponseEntity<>(_menu, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(path = {"/getMenuByCode"})
    public M_menu getMenuByIdMenu(@RequestParam String code) {
        return menuRepo.findM_menuByCode(code);
    }

    @GetMapping(path = {"/getMenuById"})
    public Optional<M_menu> getMenuById(@RequestParam Integer id) {
        return menuRepo.findById(id);}
    @DeleteMapping("/delete_menu/{id}")
    public ResponseEntity<HttpStatus> deleteMenu(@PathVariable("id") Integer id) {
        try {
            menuRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    /*************** ------- Sous menu --------- ***************/
    @GetMapping(path = {"/getSmenus"})
    @ResponseBody
    public Iterable<M_smenu> getSmenus()
    {
        //List all = secRepo.findAll();
        return smenuRepo.findAll();
    }

    @GetMapping(path = "/getSMenusByIdmenu/{id}")
    public List<M_smenu> getSMenusBy(@PathVariable Integer id)
    {
        return smenuRepo.getSmenuIdmenu(id);
    }

    @PostMapping(path = {"/smenu/add"})
    public ResponseEntity<M_smenu> addSMenu(@RequestBody M_smenu sm){
        try {
            M_smenu _menu=smenuRepo.save(sm);
            return new ResponseEntity<>(_menu, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/delete_smenu/{id}")
    public ResponseEntity<HttpStatus> deleteSmenu(@PathVariable("id") Integer id) {
        try {
             smenuRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete_smenu_menu/{id_menu}")
    public ResponseEntity<HttpStatus> deleteSmenuMenu(@PathVariable("id_menu") Integer id_menu) {
        try {
            smenuRepo.deleteSmenuByMenu(id_menu);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /*************** ------- Profil --------- ***************/
    @GetMapping(path = {"/getProfils"})
    @ResponseBody
    public Iterable<M_type_profil> getProfils()
    {
        return profilRepo.findAll();
    }
    @GetMapping(path = {"/getProfilById"})
    public Optional<M_type_profil> getProfilById(@RequestParam Integer id) {
        return profilRepo.findById(id);}

    @PostMapping(path = {"/profil/add"})
    public ResponseEntity<M_type_profil> addProfil(@RequestBody M_type_profil profil){

        try {
            M_type_profil _profil= profilRepo.save(profil);
            return new ResponseEntity<>(_profil, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete_profil/{id}")
    public ResponseEntity<HttpStatus> deleteProfil(@PathVariable("id") Integer id_profil) {
        try {
            profilRepo.deleteById(id_profil);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
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

    @GetMapping(path = {"/getActionByProfil/{id_profil}"})
    public List<M_type_action> getActionByProfil(@PathVariable Integer id_profil) {
        return (List<M_type_action>)actionRepo.getM_type_actionById_profil(id_profil);
    }

    /*@GetMapping(path = {"/getActionSmenuAndProfil/{profil}"})
    public M_type_action getActionSmenuAndProfil(@PathVariable Integer profil) {
        return actionRepo.getMTypeActionByProfil(profil);
    }*/

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

    @PutMapping("/update_action/{id_action}")
    public ResponseEntity<M_type_action> updateAction(@PathVariable("id_action") Integer id_action, @RequestBody M_type_action action) {
        Optional<M_type_action> actionData = actionRepo.findById(id_action);

       /* if (actionData.isPresent()) {
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
        }*/
        return null;
    }

    @DeleteMapping("/delete_action/{id_action}")
    public ResponseEntity<HttpStatus> deleteAction(@PathVariable("id_action") Integer id_action) {
        try {
            actionRepo.deleteById(id_action);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete_action_sm/{id_smenu}")
    public ResponseEntity<HttpStatus> deleteAction_sm(@PathVariable("id_smenu") Integer id_smenu) {
        try {
            actionRepo.delelete_actionById_smenu(id_smenu);
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
