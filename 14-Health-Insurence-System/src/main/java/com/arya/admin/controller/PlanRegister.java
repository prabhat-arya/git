package com.arya.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.arya.admin.model.AdminAccountModel;
import com.arya.admin.model.PlanModel;
import com.arya.admin.service.PlanService;

@Controller
public class PlanRegister {
	@Autowired
	private PlanService service;

	@RequestMapping(value = { "/addPlan" })
	public String loadForm(Model model) {
		PlanModel planModel = new PlanModel();
		model.addAttribute("planModel", planModel);
		return "addPlan";
	}

	@PostMapping(value = "/savePlan")
	public String handleSubmittButton(@ModelAttribute("planModel") PlanModel pm, Model model) {
		boolean saveAdmin = service.savePlan(pm);
		if (saveAdmin) {
			if (pm.getId() != null) {
				model.addAttribute("updMsg", "Plan is updated");
			} else {
				model.addAttribute("succMsg", "plan is Created");
			}
		} else {
			model.addAttribute("errMsg", "Plan is not created");
		}
		return "addPlan";
	}

	@GetMapping(value = "/viewPlans")
	public String handleViewContactLink(Model modle) {
		List<PlanModel> allPlans = service.getAllPlans();
		modle.addAttribute("plans", allPlans);
		return "viewPlans";
	}

	/*
	 * @GetMapping("/validateEmail")
	 * 
	 * @ResponseBody public String validateEmail(HttpServletRequest req) { String
	 * contactEmail = req.getParameter("email"); String emailStatus =
	 * contactService.findByEmail(contactEmail); return emailStatus; }
	 * 
	 */

}
