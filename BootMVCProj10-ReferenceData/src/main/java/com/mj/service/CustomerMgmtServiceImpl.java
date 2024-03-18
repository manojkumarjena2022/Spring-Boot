package com.mj.service;

import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.mj.repository.IHumanActivitiesRepo;
@Service("custService")
public class CustomerMgmtServiceImpl implements ICustomerMgmtService {
	@Autowired
	IHumanActivitiesRepo humanRepo;
	@Autowired
	Environment env;

	@Override
	public Set<String> getAllCountries() {
		Locale[] locale=Locale.getAvailableLocales();
		Set<String> countriesSet=new TreeSet();
		for(Locale l:locale)
		{
			countriesSet.add(l.getDisplayCountry());
		}
		return countriesSet;
	}

	@Override
	public Set<String> getAllLanguages() {
		Locale[] locale=Locale.getAvailableLocales();
		Set<String> languageSet=new TreeSet();
		for(Locale l:locale)
		{
			languageSet.add(l.getDisplayLanguage());
		}
		return languageSet;
	}

	@Override
	public Set<String> getAllHobbies() {
		return humanRepo.fetchAllHobbies();
	}

}
