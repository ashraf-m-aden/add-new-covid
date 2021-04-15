package com.ashraf.covid.covidDj.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ashraf.covid.covidDj.entity.District;
import com.ashraf.covid.covidDj.services.CaseService;
import com.ashraf.covid.covidDj.services.DistrictService;

@Controller
@RequestMapping("/djibouti")
public class MainController {
	
	
	private CaseService caseService;
	private DistrictService districtService;
	
	@Autowired
	public MainController(CaseService thecaseService, DistrictService districtService) {
		this.caseService = thecaseService;
		this.districtService = districtService;
	}
	@GetMapping("/dashboard")
	public String acceuil(Model theModel) {
		
		List<District> districts = this.districtService.findAll();
		theModel.addAttribute("districts",districts);
		return "dashboard";
	}



}
