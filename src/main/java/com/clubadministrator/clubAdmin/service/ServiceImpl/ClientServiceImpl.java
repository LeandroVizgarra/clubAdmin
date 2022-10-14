package com.clubadministrator.clubAdmin.service.ServiceImpl;

import com.clubadministrator.clubAdmin.dtos.ClientBasicDTO;
import com.clubadministrator.clubAdmin.dtos.ClientDTO;
import com.clubadministrator.clubAdmin.entities.ClientEntity;
import com.clubadministrator.clubAdmin.mapper.ClientMapper;
import com.clubadministrator.clubAdmin.repository.ClientRepository;
import com.clubadministrator.clubAdmin.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientMapper clientMapper;
    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientMapper clientMapper, ClientRepository clientRepository) {
        this.clientMapper = clientMapper;
        this.clientRepository = clientRepository;
    }

    public ClientDTO createClient(ClientDTO clientDTO){
        ClientEntity clientEntity = clientMapper.clientDTO2Entity(clientDTO);
        ClientEntity clientSaved = clientRepository.save(clientEntity);
        return clientMapper.clientEntity2DTO(clientSaved);
    }

    public String deleteClient(Long id){
        ClientEntity entity = clientRepository.getById(id);
        String name = entity.getFirstName();
        clientRepository.deleteById(id);
        return "Client "+name+" has been deleted";
    }
    public ClientDTO updateClient(Long id,ClientDTO dto){
        ClientEntity entity = clientRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("No User Found"));
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setStartDate(dto.getStartDate());
        entity.setActiveUntilDate(dto.getActiveUntilDate());
        entity.setIsActive(dto.getIsActive());
        return clientMapper.clientEntity2DTO(entity);
    }

    public List<ClientDTO> getAllClients(){
        List<ClientEntity> clients = clientRepository.findAll();
        return clientMapper.clientsEntityList2DTOList(clients);
    }

    public List<ClientBasicDTO> getAllBasicClients(){
        List<ClientEntity> clients = clientRepository.findAll();
        return clientMapper.clientsEntity2BasicList(clients);
    }
}
