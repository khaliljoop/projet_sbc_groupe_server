package com.sbc.groupe.sbc_backend.Controller;

import com.sbc.groupe.sbc_backend.Model.Personne;
import com.sbc.groupe.sbc_backend.Model.User_message;
import com.sbc.groupe.sbc_backend.Model.Vehicule;
import com.sbc.groupe.sbc_backend.Repository.IPersonne;
import com.sbc.groupe.sbc_backend.Repository.IUser_message;
import com.sbc.groupe.sbc_backend.constante.Constantes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = Constantes.host)
@RestController
public class MessageController {
    private final IUser_message messageRepo;
    private final IPersonne persRepo;

    public MessageController(IUser_message messageRepo, IPersonne persRepo) {
        this.messageRepo = messageRepo;
        this.persRepo = persRepo;
    }

    @GetMapping(path = {"/getMessages"})
    @ResponseBody
    Iterable<User_message> getMessages()
    {
        return messageRepo.findAll();
    }

    @GetMapping(path = {"/getListUser"})
    @ResponseBody
    Iterable<Personne> getListUid()
    {
        return persRepo.getPersonneBySender_message_id();
    }

    @GetMapping(path = {"/getLastMessage/{list}"})
    @ResponseBody
    Iterable<User_message> getMessageByUid(@PathVariable List<String> list)
    {
        return !list.isEmpty()? messageRepo.getLastMessage(list):null;
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
