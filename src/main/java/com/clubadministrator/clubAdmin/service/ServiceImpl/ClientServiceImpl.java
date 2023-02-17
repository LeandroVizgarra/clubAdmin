package com.clubadministrator.clubAdmin.service.ServiceImpl;

import com.clubadministrator.clubAdmin.dtos.ClientBasicDTO;
import com.clubadministrator.clubAdmin.dtos.ClientDTO;
import com.clubadministrator.clubAdmin.entities.ClientEntity;
import com.clubadministrator.clubAdmin.mapper.ClientMapper;
import com.clubadministrator.clubAdmin.repository.ClientRepository;
import com.clubadministrator.clubAdmin.service.ClientService;
import com.clubadministrator.clubAdmin.utils.CreatePage;
import com.clubadministrator.clubAdmin.utils.FinalPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
    public ClientEntity findClientByID(Long id){
        ClientEntity client = clientRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Client not found")
        );
        return client;
    }

    public String deleteClient(Long id){
        ClientEntity entity = clientRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("No Client Found")
        );
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


    public FinalPage getAll(int page, String firstName, String lastName){
        Pageable pageable = PageRequest.of(page-1,3);
        CreatePage createPage = new CreatePage();
        Boolean isNotNull = notNull(firstName, lastName);
        if (isNotNull){
            Page<ClientEntity> clientsFilters = clientRepository.findAllByFirstNameOrLastName(firstName,lastName,pageable);
            createPage.paginateResult(clientsFilters).loadList(clientsFilters.getContent().stream().map(
                    clientMapper::client2Basic).collect(Collectors.toList()));
        }
        else{
            Page<ClientEntity> clients = clientRepository.findAll(pageable);
            createPage.paginateResult(clients).loadList(clients.getContent().stream()
                    .map(clientMapper::client2Basic).collect(Collectors.toList()));
        }

        return createPage.build();
    }

    private Boolean notNull(String firstName, String lastName){
        return (firstName != null) || (lastName != null);
    }


    public List<ClientBasicDTO> getClientsNearToPayment(){
        List<ClientEntity> clients = clientRepository.findAll();
        List<ClientBasicDTO> clientsNearToPayment = new ArrayList<>();
        int date = LocalDate.now().getDayOfYear();

        for(ClientEntity client : clients){
            if(client.getActiveUntilDate().getDayOfYear() - date < 5){
                clientsNearToPayment.add(clientMapper.client2Basic(client));
            }
        }

        return clientsNearToPayment;
    }


    //TODO Add renew plan
    //TODO Finish getClientsNearToPayment

    public LocalDate payMonth(Long id){
        ClientEntity client = this.findClientByID(id);
        LocalDate actualDate = client.getActiveUntilDate();
        LocalDate newDate = actualDate.plusMonths(1);
        client.setActiveUntilDate(newDate);
        clientRepository.save(client);
        return newDate;
    }

}
