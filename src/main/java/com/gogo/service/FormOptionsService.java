package com.gogo.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class FormOptionsService {
	
	// LinkedHashMaps and Lists that are used in front-end forms 
	
	// movie search options
	public Map<String,String> getSomeOptionsMap(){
		Map<String,String> someOptsMap = new LinkedHashMap<String,String>();
		someOptsMap.put("opt 1", "opt1");
		return someOptsMap;
	}
	
	public List<String> getSomeOptionsList() {
		List<String> someOptsList = new ArrayList<String>();
		Map<String,String> map = getSomeOptionsMap();
		for (String k : map.keySet()) {
			System.out.println(k);
			someOptsList.add(k);
		}
		return someOptsList;
	}
	

	
	// Search Details
	// not sure if using this class this way is a good idea
	// just trying to kill two birds with one stone

	
	private String searchField = null;
	private String searchTerm = null;

	// constructors
	public FormOptionsService() {	}

	public FormOptionsService(String searchField, String searchTerm) {
		super();
		this.searchField = searchField;
		this.searchTerm = searchTerm;
	}
	
	// getters + setters
	public String getSearchField() {
		System.out.println("FormOptionsService getSearchField: " + searchField);
		return searchField;
	}
	public void setSearchField(String searchField) {
		System.out.println("FormOptionsService setSearchField: " + searchField);
		this.searchField = searchField;
	}
	public String getSearchWord() {
		System.out.println("FormOptionsService getSearchWord: " + searchTerm);
		return searchTerm;
	}
	public void setSearchWord(String searchTerm) {
		System.out.println("FormOptionsService setSearchWord: " + searchTerm);
		this.searchTerm = searchTerm;
	}

	@Override
	public String toString() {
		return "FormOptionsService [searchField=" + searchField + ", searchTerm=" + searchTerm + "]";
	}

	
}
