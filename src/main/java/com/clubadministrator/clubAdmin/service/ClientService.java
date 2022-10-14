package com.clubadministrator.clubAdmin.service;

import com.clubadministrator.clubAdmin.dtos.ClientBasicDTO;
import com.clubadministrator.clubAdmin.dtos.ClientDTO;

import java.util.List;

public interface ClientService {

    ClientDTO createClient(ClientDTO clientDTO);
    String deleteClient(Long id);
    ClientDTO updateClient(Long id,ClientDTO dto);
    List<ClientDTO> getAllClients();
    List<ClientBasicDTO> getAllBasicClients();
}
