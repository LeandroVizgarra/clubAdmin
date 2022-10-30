package com.clubadministrator.clubAdmin.controller;

import com.clubadministrator.clubAdmin.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plan")
public class PlanController {
    private final PlanService planService;
    @Autowired
    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    //TODO continue controller.
}
