package com.clubadministrator.clubAdmin.repository;

import com.clubadministrator.clubAdmin.dtos.ClientBasicDTO;
import com.clubadministrator.clubAdmin.entities.ClientEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ClientRepository extends JpaRepository<ClientEntity,Long> {
    Page<ClientEntity> findAllByFirstNameOrLastName(String fistName, String lastName, Pageable pageable);
    ClientEntity findClientEntityByFirstNameAndLastName(String firstName, String lastName);
    List<ClientEntity> findClientEntitiesByActiveUntilDate(LocalDate date);

}
