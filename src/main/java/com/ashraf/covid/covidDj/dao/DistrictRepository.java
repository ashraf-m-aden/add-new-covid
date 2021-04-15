package com.ashraf.covid.covidDj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashraf.covid.covidDj.entity.District;




public interface DistrictRepository extends JpaRepository<District, Integer> {

	
}
