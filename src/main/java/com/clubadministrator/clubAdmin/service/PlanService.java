package com.clubadministrator.clubAdmin.service;

import com.clubadministrator.clubAdmin.dtos.PlanDTO;

import java.util.List;

public interface PlanService {
    PlanDTO createPlan(PlanDTO planDTO);
    List<PlanDTO> getAllPlan();
}
