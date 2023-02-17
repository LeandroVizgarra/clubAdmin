package com.clubadministrator.clubAdmin.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class ClientDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate startDate;
    private LocalDate activeUntilDate;
    private Boolean isActive;
    private PlanDTO plan;

    public ClientDTO(Long id, String firstName, String lastName, LocalDate startDate, LocalDate activeUntilDate, Boolean isActive) {
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
