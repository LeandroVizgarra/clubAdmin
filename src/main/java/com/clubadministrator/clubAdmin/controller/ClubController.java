package com.clubadministrator.clubAdmin.controller;

import com.clubadministrator.clubAdmin.dtos.ClientBasicDTO;
import com.clubadministrator.clubAdmin.dtos.ClientDTO;
import com.clubadministrator.clubAdmin.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/club")
public class ClubController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity getAllClients(){
        List<ClientDTO> clientDTOList = clientService.getAllClients();
        return ResponseEntity.ok().body(clientDTOList);
    }

    @GetMapping
    @RequestMapping("/basic")
    public ResponseEntity getAllBasicClients(){
        List<ClientBasicDTO> clientDTOList = clientService.getAllBasicClients();
        return ResponseEntity.ok().body(clientDTOList);
    }
}
