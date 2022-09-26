package com.countryservice.demo.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.countryservice.demo.beans.Country;
import com.countryservice.demo.controllers.AddResponse;

public class CountryService {

static HashMap<Integer, Country> countryIdMap;
	
	public CountryService() {
		
		countryIdMap= new HashMap<Integer, Country>();
		
		Country indiacountry= new Country(1, "India", "Delhi");
		Country usacountry= new Country(1, "US", "Washington");
		Country ukcountry= new Country(1, "UK", "London");
		
		countryIdMap.put(1, indiacountry);
		countryIdMap.put(2, usacountry);
		countryIdMap.put(3, ukcountry);
		
	}
	
	public List getAllCountries() {
		List Countries= new ArrayList(countryIdMap.values());
		return Countries;
	}
	
	public Country getCountryById(int id){
		
		Country country = countryIdMap.get(id);
		return country;
	}
	
	public Country getCountryByName(String CountryName){
		
		Country country= null;
		
		for(int i :countryIdMap.keySet()) {
			if(countryIdMap.get(i).getCountryName().equals(CountryName)) {
				country=countryIdMap.get(i);
			}
		}
		
		return country;
	}
	
	 public Country addCountry(Country country){
		 
		 country.setId(getMaxId());
		 countryIdMap.put(country.getId(), country);
		 return country;
	 }
	 
	 
	 
	 public static int getMaxId() {
		 
		 int max=0;
		 for(int id : countryIdMap.keySet())
		 if(max<id)
			 max=id;
		 
		 return max+1;
	 }
	 
     public Country updateCountry(Country country){
		 
		 if(country.getId()>0)
		      countryIdMap.put(country.getId(), country);
		 return country;
	 }
	
     public AddResponse deleteCountry(int id) {
    	  
    	 countryIdMap.remove(id);
    	 AddResponse rs=new AddResponse();
    	 rs.setMsg("Country deleted....");
    	 rs.setId(id);
    	 return rs;
    	 
     }

}
