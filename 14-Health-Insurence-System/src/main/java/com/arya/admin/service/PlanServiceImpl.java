package com.arya.admin.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arya.admin.entities.AdminAccountEntity;
import com.arya.admin.entities.PlanEntity;
import com.arya.admin.model.AdminAccountModel;
import com.arya.admin.model.PlanModel;
import com.arya.admin.repository.PlanRepository;

@Service
public class PlanServiceImpl implements PlanService {
	
	@Autowired
	private PlanRepository planRepo;

	@Override
	public boolean savePlan(PlanModel plan) {
		PlanEntity planEntity=new PlanEntity();
		BeanUtils.copyProperties(plan, planEntity);
		planRepo.save(planEntity);
		return true;
	}

	@Override
	public List<PlanModel> getAllPlans() {
		List<PlanEntity> findAllPlans = planRepo.findAll();
		
		List<PlanModel> allPlans = findAllPlans.stream().map(plans -> {
			PlanModel planModel=new PlanModel();
			BeanUtils.copyProperties(plans, planModel);
			return planModel;
		}).collect(Collectors.toList());
		return allPlans;
	}

	@Override
	public PlanModel getplanById(Integer id) {
		Optional<PlanEntity> findByIdPlan = planRepo.findById(id);
		
		if (findByIdPlan.isPresent()) {
			PlanEntity planEntity=findByIdPlan.get();
			PlanModel planModel=new PlanModel();
			BeanUtils.copyProperties(planEntity, planModel);
			
			return planModel;
		}
		return null;
	}

	@Override
	public boolean deletePlan(Integer id) {
		planRepo.deleteById(id);
		return true;
	}
	
	

}
