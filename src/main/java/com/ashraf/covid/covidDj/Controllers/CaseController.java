package com.ashraf.covid.covidDj.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ashraf.covid.covidDj.entity.Case;
import com.ashraf.covid.covidDj.entity.District;
import com.ashraf.covid.covidDj.services.CaseService;
import com.ashraf.covid.covidDj.services.DistrictService;


@Controller
@RequestMapping("cases")
public class CaseController {

	private CaseService caseService;
	private DistrictService districtService;
	
	@Autowired
	public CaseController(CaseService thecaseService, DistrictService districtService) {
		this.caseService = thecaseService;
		this.districtService = districtService;
	}
	
	@GetMapping("/list")
	public String listCases(Model model) {
		
		//get the Case from the db
		List<Case> theCases = this.caseService.findAll();
		//add Cases to the model
		model.addAttribute("cases",theCases);
		
		return "cases/list-cases";
	}
	
	@GetMapping("/showFormAdd")
	public String showFormAdd(Model model) {
		
		//get the Case from the db
		Case newCase = new Case();
		List<District> districts = this.districtService.findAll();
		newCase.setHealed(false);
		//add Cases to the model
		model.addAttribute("case",newCase);
		model.addAttribute("districts",districts);
		
		return "cases/show-form-add";
	}
	
	
	@PostMapping("/save")
	public String save(@ModelAttribute("case") Case theCase, Model model) {

		if (theCase.getIdDistrict() == 0) {
			model.addAttribute("case",theCase);
			return "redirect:/cases/update?caseId="+theCase.getId();} ;
		
		District district = this.districtService.findDistrict(theCase.getIdDistrict());
		// set the district
		theCase.setDistrict(district);
		//save the Case
		this.caseService.save(theCase);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/cases/list";
	}
	
	@GetMapping("/update")
	public String update(@RequestParam("caseId") int id, Model model) {
		
		Case Case = this.caseService.findCase(id);
		List<District> districts = this.districtService.findAll();

		model.addAttribute("case",Case);
		model.addAttribute("districts",districts);

		
		return "cases/show-form-add";
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("caseId") int id) {
		
		Case Case = this.caseService.findCase(id);
		
		this.caseService.deleteCase(id);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/cases/list";
	}
	
}
