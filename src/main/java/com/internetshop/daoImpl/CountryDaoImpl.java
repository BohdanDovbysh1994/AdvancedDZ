package com.internetshop.daoImpl;



import java.util.List;

import com.internetshop.dao.CountryDao;
import com.internetshop.entity.Country;
import com.internetshop.entity.maker;

public class CountryDaoImpl extends GenericDaoIplementation<Country, String> implements CountryDao {

	public void addMakerToCountry(Country country, maker maker) {
		getEntityManager().getTransaction().begin();
		maker.setCountry(country);
		getEntityManager().getTransaction().commit();
		
	}
	@Override
	 public void delete(String fieldName, String fieldValue) 
	 {
	  Country country = super.getOne(fieldName, fieldValue);
	  List<maker> makers = country.getMakers();
	  for (maker maker : makers) {
		maker.setCountry(null);
		getEntityManager().merge(maker);
	}
	  super.delete(fieldName, fieldValue);
	 }

}
