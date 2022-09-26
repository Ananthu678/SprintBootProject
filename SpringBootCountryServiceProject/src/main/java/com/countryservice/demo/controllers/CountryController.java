package com.countryservice.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.countryservice.demo.beans.Country;
import com.countryservice.demo.services.CountryService;


@RestController
public class CountryController {
	
	@Autowired
	CountryService countryservices;
	
	@GetMapping("/getcountries")
	public List getCountries(){
		return countryservices.getAllCountries();
	}
	
	@GetMapping("/getcountries/{id}")
	public Country getCountryById(@PathVariable int id){
		return countryservices.getCountryById(id);
	}
	
	@GetMapping("/getcountries/countryname")
	public Country getCountryName(@RequestParam(value="name") String CountryName) {
		return countryservices.getCountryByName(CountryName);
	}
	
	@PostMapping("/addcountry")
	public Country addCountry(@RequestBody Country country) {
		return countryservices.addCountry(country);
	}
	
	@PutMapping("/updatecountry")
	public Country updateCountry(@RequestBody Country country) {
		return countryservices.updateCountry(country);
	}
	
	@DeleteMapping("/deletecountry/{id}")
	public AddResponse deleteCountry(@PathVariable(value="id") int id) {
		return countryservices.deleteCountry(id);
	}
	

}
