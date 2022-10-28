package com.clubadministrator.clubAdmin.service.ServiceImpl;

import com.clubadministrator.clubAdmin.dtos.PlanDTO;
import com.clubadministrator.clubAdmin.entities.PlanEntity;
import com.clubadministrator.clubAdmin.mapper.PlanMapper;
import com.clubadministrator.clubAdmin.repository.PlanRepository;
import com.clubadministrator.clubAdmin.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanServiceImpl implements PlanService {
    private PlanMapper planMapper;
    private PlanRepository planRepository;
    @Autowired
    public PlanServiceImpl(PlanMapper planMapper, PlanRepository planRepository) {
        this.planMapper = planMapper;
        this.planRepository = planRepository;
    }

    public PlanDTO createPlan(PlanDTO planDTO){
        PlanEntity planEntity = planMapper.planDTO2Entity(planDTO);
        PlanEntity planSaved = planRepository.save(planEntity);
        return planMapper.planEntity2DTO(planSaved);
    }


}
