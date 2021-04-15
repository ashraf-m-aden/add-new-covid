package com.ashraf.covid.covidDj.services;

import java.util.List;

import com.ashraf.covid.covidDj.entity.Case;


public interface CaseService {

	public List<Case> findAll();
	public Case save(Case Case);
	public Case findCase(int id);
	public String deleteCase(int id);
}
