package com.clubadministrator.clubAdmin.mapper;

import com.clubadministrator.clubAdmin.dtos.PlanBasicDTO;
import com.clubadministrator.clubAdmin.dtos.PlanDTO;
import com.clubadministrator.clubAdmin.entities.PlanEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlanMapper {
    public PlanEntity planDTO2Entity(PlanDTO dto){
        PlanEntity entity = new PlanEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        return entity;
    }
    public PlanDTO planEntity2DTO(PlanEntity entity){
        PlanDTO dto = new PlanDTO();
        dto.setId(entity.getId());
        dto.setPrice(entity.getPrice());
        dto.setName(entity.getName());
        return dto;
    }
    public PlanBasicDTO planEntity2BasicDTO(PlanEntity entity){
        PlanBasicDTO planBasicDTO =  new PlanBasicDTO();
        planBasicDTO.setName(entity.getName());
        planBasicDTO.setPrice(entity.getPrice());
        return planBasicDTO;
    }

    public List<PlanDTO> planEntityList2DTOList(List<PlanEntity> plans){
        List<PlanDTO> dtos = new ArrayList<>();

        for(PlanEntity entity : plans){
            dtos.add(this.planEntity2DTO(entity));
        }
        return dtos;
    }

}
