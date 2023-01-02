package com.sbc.groupe.sbc_backend.Controller;

import com.sbc.groupe.sbc_backend.Model.Personne;
import com.sbc.groupe.sbc_backend.Model.User_message;
import com.sbc.groupe.sbc_backend.Model.Vehicule;
import com.sbc.groupe.sbc_backend.Repository.IPersonne;
import com.sbc.groupe.sbc_backend.Repository.IUser_message;
import com.sbc.groupe.sbc_backend.constante.Constantes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import java.awt.print.Pageable;
import org.springframework.data.domain.Pageable;
import java.util.*;

@CrossOrigin(origins = Constantes.host)
@RestController
public class MessageController {
    private final IUser_message messageRepo;
    private final IPersonne persRepo;
    int page=0;
    int sizes=6;
    public MessageController(IUser_message messageRepo, IPersonne persRepo) {
        this.messageRepo = messageRepo;
        this.persRepo = persRepo;
    }

    Pageable pageable= PageRequest.of(page,sizes);

    @GetMapping(path = {"/getMessages"})
    @ResponseBody
    Iterable<User_message> getMessages()
    {
        //Page<User_message> messages=messageRepo.findAll(pageable);
        return messageRepo.findAll(pageable);
    }

    @GetMapping(path = {"/getListUser"})
    @ResponseBody
    Iterable<Personne> getListUid()
    {
        return persRepo.getPersonneBySender_message_id();
    }

    @GetMapping(path = {"/getLastMessage/{uid}/{list}"})
    @ResponseBody
    Iterable<User_message> getMessageByUid(@PathVariable String uid,@PathVariable List<String> list)
    {
       // List<String> liste ={""};
        System.out.println("taille liste "+list.size());
        return !list.isEmpty()? messageRepo.getLastMessage(uid,list):null;
    }
    @GetMapping(path = {"/getMessageByUid/{uid}"})
    @ResponseBody
    Iterable<User_message> getMessageByUid(@PathVariable String uid)
    {
        return messageRepo.findUser_messageByUid(uid);
    }

    @PostMapping(value = {"/Message/add"})
    public ResponseEntity<User_message> addMessage(@RequestBody User_message m){
        try {
            User_message ms= messageRepo.save(m);
            return new ResponseEntity<>(ms, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
