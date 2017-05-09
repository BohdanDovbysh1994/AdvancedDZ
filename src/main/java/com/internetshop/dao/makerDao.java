package com.internetshop.dao;

import java.util.List;

import com.internetshop.entity.ComputerComodity;
import com.internetshop.entity.Country;
import com.internetshop.entity.householdAppliances;
import com.internetshop.entity.maker;

public interface makerDao extends GenericDao<maker, String> {
	void addCountryToMaker(Country country , maker maker);
	void addComputerComodutyTomaker(maker maker, ComputerComodity computerComodity);
	void addhouseholdAppTomaker(maker maker , householdAppliances householdAppliances);

}
