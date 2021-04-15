package com.ashraf.covid.covidDj.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ashraf.covid.covidDj.dao.DistrictRepository;
import com.ashraf.covid.covidDj.entity.Case;
import com.ashraf.covid.covidDj.entity.District;



@Service
public class DistrictServiceImpl implements DistrictService {

	private DistrictRepository districtRepo;
	
	// inject with the constructor
	@Autowired
	public DistrictServiceImpl(DistrictRepository districtRepo) {
		this.districtRepo = districtRepo;
	}
	
	
	@Override
	@Transactional
	public List<District> findAll() {
		
		return districtRepo.findAll();
	}


	@Override
	public District findDistrict(int id) {

		Optional<District> result = districtRepo.findById(id);
		District district = null;
		if(result.isPresent()) {
			district = result.get();
		} else {
			throw new RuntimeException("Did not find District id "+id);
		}
		return district;
	}


}
