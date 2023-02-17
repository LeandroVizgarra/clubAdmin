package com.clubadministrator.clubAdmin.dtos;

import com.clubadministrator.clubAdmin.entities.PlanType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PlanDTO {
    private Long id;
    private String name;
    private Long price;

    private PlanType planType;
}
