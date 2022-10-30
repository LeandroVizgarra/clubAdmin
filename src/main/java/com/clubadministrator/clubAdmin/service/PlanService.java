package com.clubadministrator.clubAdmin.service;

import com.clubadministrator.clubAdmin.dtos.PlanDTO;
import com.clubadministrator.clubAdmin.utils.FinalPage;

import java.util.List;

public interface PlanService {
    PlanDTO createPlan(PlanDTO planDTO);
    List<PlanDTO> getAllPlan();
    FinalPage getAllPlanByPage(int page, String name, Long price);
}
