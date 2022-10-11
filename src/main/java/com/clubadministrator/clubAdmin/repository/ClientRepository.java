package com.clubadministrator.clubAdmin.repository;

import com.clubadministrator.clubAdmin.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity,Long> {
}
