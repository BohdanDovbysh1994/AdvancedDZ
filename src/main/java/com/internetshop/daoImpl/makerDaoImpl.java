package com.internetshop.daoImpl;
import java.util.List;

import com.internetshop.dao.makerDao;
import com.internetshop.entity.ComputerComodity;
import com.internetshop.entity.Country;
import com.internetshop.entity.householdAppliances;
import com.internetshop.entity.maker;

public class makerDaoImpl extends GenericDaoIplementation<maker, String> implements makerDao {


	public makerDaoImpl() {
	}


	public void addComputerComodutyTomaker(maker maker, ComputerComodity computerComodity) {
		getEntityManager().getTransaction().begin();

		computerComodity.setMaker(maker);

		getEntityManager().getTransaction().commit();

	}

	public void addhouseholdAppTomaker(maker maker, householdAppliances householdAppliances) {
		getEntityManager().getTransaction().begin();
		householdAppliances.setMaker(maker);
		getEntityManager().getTransaction().commit();

	}


	public void addCountryToMaker(Country country, maker maker) {
		getEntityManager().getTransaction().begin();
		maker.setCountry(country);
		getEntityManager().getTransaction().commit();
		
	}
	@Override
	 public void delete(String fieldName, String fieldValue) 
	 {
	  maker maker = super.getOne(fieldName, fieldValue);
	  List<ComputerComodity> computerComoditys = maker.getComputerComodities();
	  for (ComputerComodity computerComodity : computerComoditys) 
	  {
	   computerComodity.setMaker(null);
	   getEntityManager().merge(computerComodity);
	  }
	  List<householdAppliances> householdAppliances = maker.getHouseholdAppliances();
	  for (householdAppliances householdAppliance : householdAppliances) {
		householdAppliance.setMaker(null);
		getEntityManager().merge(householdAppliance);
	}
	  super.delete(fieldName, fieldValue);
	 }

}
