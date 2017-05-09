package com.internetshop.daoImpl;

import com.internetshop.dao.ComputerComodityDao;
import com.internetshop.entity.ComputerComodity;
import com.internetshop.entity.maker;

public class ComputerComodityImpl extends GenericDaoIplementation<ComputerComodity, String> implements ComputerComodityDao{


	
	public void AddComputerComodityToMaker(maker maker, ComputerComodity computerComodity) {
		getEntityManager().getTransaction().begin();

		computerComodity.setMaker(maker);

		getEntityManager().getTransaction().commit();
		
	}
	

}
