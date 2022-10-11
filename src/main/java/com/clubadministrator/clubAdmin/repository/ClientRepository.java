package com.clubadministrator.clubAdmin.repository;

import com.clubadministrator.clubAdmin.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
