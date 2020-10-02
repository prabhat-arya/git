package com.arya.admin.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.arya.admin.entities.RolesEntity;
import com.arya.admin.model.AdminAccountModel;
import com.arya.admin.model.PlanModel;
import com.arya.admin.service.AdminService;
import com.arya.admin.service.PlanService;

@Controller
public class PlanView {
	@Autowired
	PlanService service;

	@RequestMapping(value = "/editPlan")
	public String editAccount(@RequestParam("id") Integer id, Model model) {
		PlanModel getplanById = service.getplanById(id);
		model.addAttribute("planModel", getplanById);
		return "addPlan";
	}

	@RequestMapping(value = "/deletePlan")
	public String deleteContactById(@RequestParam("id") Integer id, Model model) {
		boolean idDelete = service.deletePlan(id);

		if (idDelete) {
			return "redirect:/viewPlans";

		}
		return null;
	}

}
