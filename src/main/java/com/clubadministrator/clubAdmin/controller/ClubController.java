package com.clubadministrator.clubAdmin.controller;

import com.clubadministrator.clubAdmin.dtos.ClientBasicDTO;
import com.clubadministrator.clubAdmin.dtos.ClientDTO;
import com.clubadministrator.clubAdmin.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/club")
public class ClubController {
    private final ClientService clientService;
    @Autowired
    public ClubController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<?> getAllClients(){
        List<ClientDTO> clientDTOList = clientService.getAllClients();
        return ResponseEntity.ok().body(clientDTOList);
    }

    @GetMapping
    @RequestMapping("/basic")
    public ResponseEntity<?> getAllBasicClients(){
        List<ClientBasicDTO> clientDTOList = clientService.getAllBasicClients();
        return ResponseEntity.ok().body(clientDTOList);
    }

    @PostMapping
    public ResponseEntity<ClientDTO> createClient(@RequestBody ClientDTO clientDTO){
        return new ResponseEntity<>(clientService.createClient(clientDTO), HttpStatus.CREATED);
    }
    @DeleteMapping
    public ResponseEntity<String> deleteClient(@RequestBody Long id){
        return new ResponseEntity<>(clientService.deleteClient(id),HttpStatus.OK);
    }
    @PutMapping("{client_id}")
    public ResponseEntity<ClientDTO> updateClient(@PathVariable Long client_id,
                                                  @RequestBody ClientDTO clientDTO){
        return new ResponseEntity<>(clientService.updateClient(client_id, clientDTO),HttpStatus.OK);
    }
}
