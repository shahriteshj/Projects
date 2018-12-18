package com.jp.springwithangular.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.springwithangular.beans.Country;
import com.jp.springwithangular.dao.ICountryDao;
@Service
public class CountryServiceImpl implements ICountryService{
	@Autowired
	ICountryDao countryDao;
	@Override
	public List<Country> getAllCountries() {
		// TODO Auto-generated method stub
		return countryDao.getAllCountries();
	}

	@Override
	public void addCountry(Country country) {
		// TODO Auto-generated method stub
		countryDao.addCountry(country);
	}

	@Override
	public Country deleteCountry(int id) {
		// TODO Auto-generated method stub
		return countryDao.deleteCountry(id);
	}

}
