package com.arya.admin.service;

import java.util.List;

import com.arya.admin.model.PlanModel;

public interface PlanService {
	
	public boolean savePlan(PlanModel plan);
	public List<PlanModel> getAllPlans();
	public PlanModel getplanById(Integer id);
	boolean deletePlan(Integer id);

}
