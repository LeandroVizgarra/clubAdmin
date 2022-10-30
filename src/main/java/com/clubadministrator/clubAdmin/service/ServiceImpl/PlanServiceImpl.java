package com.clubadministrator.clubAdmin.service.ServiceImpl;

import com.clubadministrator.clubAdmin.dtos.PlanDTO;
import com.clubadministrator.clubAdmin.entities.PlanEntity;
import com.clubadministrator.clubAdmin.mapper.PlanMapper;
import com.clubadministrator.clubAdmin.repository.PlanRepository;
import com.clubadministrator.clubAdmin.service.PlanService;
import com.clubadministrator.clubAdmin.utils.CreatePage;
import com.clubadministrator.clubAdmin.utils.FinalPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanServiceImpl implements PlanService {
    private final PlanMapper planMapper;
    private final PlanRepository planRepository;
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

    public List<PlanDTO> getAllPlan(){
        List<PlanEntity> list = planRepository.findAll();
        return planMapper.planEntityList2DTOList(list);
    }

    public FinalPage getAllPlanByPage(int page, String name, Long price) {
        Pageable pageable = PageRequest.of(page - 1, 10);
        CreatePage createPage = new CreatePage();
        Boolean isNotNull = notNull(name, price);
        if (isNotNull) {
            Page<PlanEntity> planEntities = planRepository.findAllByNameOrPrice(name, price, pageable);
            createPage.paginateResult(planEntities).loadList(planEntities.getContent().stream().map(
                    planMapper::planEntity2BasicDTO).collect(Collectors.toList()));
        } else {
            Page<PlanEntity> plans = planRepository.findAll(pageable);


        createPage.paginateResult(plans).loadList(plans.getContent().stream()
                .map(planMapper::planEntity2BasicDTO).collect(Collectors.toList()));
    }
        return createPage.build();
    }
        private Boolean notNull(String name, Long price)
        {return (name != null) || (price != null);
    }




}
