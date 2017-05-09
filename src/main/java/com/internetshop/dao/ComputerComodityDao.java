package com.internetshop.dao;

import com.internetshop.entity.ComputerComodity;
import com.internetshop.entity.maker;

public interface ComputerComodityDao extends GenericDao<ComputerComodity, String>{
	
	void AddComputerComodityToMaker(maker maker, ComputerComodity computerComodity);

}
