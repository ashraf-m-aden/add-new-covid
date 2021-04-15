package com.ashraf.covid.covidDj.services;

import java.util.List;

import com.ashraf.covid.covidDj.entity.District;



public interface DistrictService {

	public List<District> findAll();
	public District findDistrict(int id);
}
