package com.jp.springwithangular.dao;

import java.util.List;

import com.jp.springwithangular.beans.Country;

;

public interface ICountryDao {
	public List<Country> getAllCountries();
	public void addCountry(Country country);
	public Country deleteCountry(int id);
}
