package com.clubadministrator.clubAdmin.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ClientDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private Date startDate;
    private Date activeUntilDate;
    private Boolean isActive;

    public ClientDTO(Long id, String firstName, String lastName, Date startDate, Date activeUntilDate, Boolean isActive) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.startDate = startDate;
        this.activeUntilDate = activeUntilDate;
        this.isActive = isActive;
    }

    public ClientDTO() {
    }
}
