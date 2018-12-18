package com.jp.springwithangular.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jp.springwithangular.beans.Country;
import com.jp.springwithangular.staticdb.CountryDb;
@Repository
public class CountryDaoImpl implements ICountryDao {

	@Override
	public List<Country> getAllCountries() {
		// TODO Auto-generated method stub
		return CountryDb.getCountryList();
	}

	@Override
	public void addCountry(Country country) {
		// TODO Auto-generated method stub
		CountryDb.getCountryList().add(country);
	}

	@Override
	public Country deleteCountry(int id) {
		// TODO Auto-generated method stub
		return CountryDb.getCountryList().remove(id);
	}

}
