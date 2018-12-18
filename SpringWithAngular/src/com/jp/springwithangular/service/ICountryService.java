package com.jp.springwithangular.service;

import java.util.List;

import com.jp.springwithangular.beans.Country;



public interface ICountryService {
	public List<Country> getAllCountries();
	public void addCountry(Country country);
	public Country deleteCountry(int id);
}
