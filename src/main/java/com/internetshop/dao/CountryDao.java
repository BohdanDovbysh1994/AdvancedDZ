package com.internetshop.dao;

import com.internetshop.entity.Country;
import com.internetshop.entity.maker;

public interface CountryDao extends GenericDao<Country, String> {
	
	void addMakerToCountry (Country country, maker maker);
	

}
