package com.clubadministrator.clubAdmin.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
public class ClientBasicDTO {
    private String firstName;
    private String lastName;
    private LocalDate activeUntilDate;
    private PlanBasicDTO plan;
}
