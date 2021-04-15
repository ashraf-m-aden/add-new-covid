package com.ashraf.covid.covidDj.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ashraf.covid.covidDj.dao.CaseRepository;
import com.ashraf.covid.covidDj.entity.Case;



@Service
public class CaseServiceImpl implements CaseService {

	private CaseRepository caseRepo;
	
	// inject with the constructor
	@Autowired
	public CaseServiceImpl(CaseRepository caseRepo) {
		this.caseRepo = caseRepo;
	}
	
	
	@Override
	@Transactional
	public List<Case> findAll() {
		
		return caseRepo.findAll();
	}

	@Override
	public Case save(Case Case) {

		return caseRepo.save(Case);
	}

	@Override
	public Case findCase(int id) {

		Optional<Case> result = caseRepo.findById(id);
		Case Case = null;
		if(result.isPresent()) {
			Case = result.get();
		} else {
			throw new RuntimeException("Did not find Case id "+id);
		}
		return Case;
	}

	@Override
	public String deleteCase(int id) {
	/*	Optional<Case> result = caseRepo.findById(id);
		Case Case = null;
		if(result.isPresent()) {
			Case = result.get();
		}*/
		caseRepo.deleteById(id);
		return "Deleted Case id " + id;
}

}
