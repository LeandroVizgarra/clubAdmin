package com.clubadministrator.clubAdmin.mapper;

import com.clubadministrator.clubAdmin.dtos.ClientBasicDTO;
import com.clubadministrator.clubAdmin.dtos.ClientDTO;
import com.clubadministrator.clubAdmin.entities.ClientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ClientMapper {
    @Autowired
    private PlanMapper planMapper;

    public ClientEntity clientDTO2Entity(ClientDTO dto){
        ClientEntity entity = new ClientEntity();
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setStartDate(dto.getStartDate());
        entity.setActiveUntilDate(dto.getActiveUntilDate());
        entity.setIsActive(dto.getIsActive());
        entity.setPlan(planMapper.planDTO2Entity(dto.getPlan()));
        return entity;
    }

    public ClientDTO clientEntity2DTO(ClientEntity clientEntity){
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(clientEntity.getId());
        clientDTO.setFirstName(clientEntity.getFirstName());
        clientDTO.setLastName(clientEntity.getLastName());
        clientDTO.setStartDate(clientEntity.getStartDate());
        clientDTO.setActiveUntilDate(clientEntity.getActiveUntilDate());
        clientDTO.setIsActive(clientEntity.getIsActive());
        clientDTO.setPlan(planMapper.planEntity2DTO(clientEntity.getPlan()));
        return clientDTO;
    }
    /*
    public Set<ClientDTO> clientEntitySet2DTOSet(Set<ClientEntity> entities){
        return entities.stream().map(client -> new ClientDTO(
                client.getId(),
                client.getFirstName(),
                client.getLastName(),
                client.getStartDate(),
                client.getActiveUntilDate(),
                client.getIsActive()
        )).collect(Collectors.toSet());
    }

  */

     public List<ClientDTO> clientsEntityList2DTOList(List<ClientEntity> clients){
        List<ClientDTO> dtos = new ArrayList<>();

        for(ClientEntity entity : clients){
            dtos.add(this.clientEntity2DTO(entity));
        }
        return dtos;
    }

    public ClientBasicDTO client2Basic(ClientEntity entity){
        ClientBasicDTO clientBasicDTO = new ClientBasicDTO();
        clientBasicDTO.setFirstName(entity.getFirstName());
        clientBasicDTO.setLastName(entity.getLastName());
        clientBasicDTO.setActiveUntilDate(entity.getActiveUntilDate());
        clientBasicDTO.setPlan(planMapper.planEntity2BasicDTO(entity.getPlan()));
        return clientBasicDTO;
    }

    public List<ClientBasicDTO> clientsEntity2BasicList(List<ClientEntity> clients){
         List<ClientBasicDTO> clientsList = new ArrayList<>();
         for(ClientEntity entity : clients){
             clientsList.add(this.client2Basic(entity));
         }
         return clientsList;
    }

}
