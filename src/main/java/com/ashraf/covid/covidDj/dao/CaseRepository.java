package com.ashraf.covid.covidDj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashraf.covid.covidDj.entity.Case;



public interface CaseRepository extends JpaRepository<Case, Integer> {

	
	//that's it no need to write other stuff
	
	
	// ADD A MEthod to sort by last name
	public List<Case> findAllByOrderByFirstNameAsc();
}
