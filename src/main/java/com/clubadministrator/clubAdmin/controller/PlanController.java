package com.clubadministrator.clubAdmin.controller;

import com.clubadministrator.clubAdmin.service.PlanService;
import com.clubadministrator.clubAdmin.utils.FinalPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plan")
public class PlanController {
    private final PlanService planService;
    @Autowired
    public PlanController(PlanService planService) {
        this.planService = planService;
    }
    @GetMapping
    public ResponseEntity<FinalPage> getAll(@RequestParam(required = false,defaultValue = "1")int page,
                                            @RequestParam(required = false) String name,
                                            @RequestParam(required = false) Long price){
        FinalPage plans = planService.getAllPlanByPage(page,name,price);
        return new ResponseEntity<>(plans, HttpStatus.OK);
    }
}
