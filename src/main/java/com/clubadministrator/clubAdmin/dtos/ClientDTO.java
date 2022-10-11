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
}
