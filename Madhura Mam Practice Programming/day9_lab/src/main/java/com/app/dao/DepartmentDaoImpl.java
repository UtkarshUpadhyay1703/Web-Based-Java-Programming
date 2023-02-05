package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
//not writing the service layer
@Transactional
public class DepartmentDaoImpl implements DepartmentDao {

	@Autowired
	private EntityManager mgr;
	
	@Override
	public List<String> getAllDepartmentNames() {
		String jpql="select d.deptName from Department d";
		return mgr.createQuery(jpql, String.class).getResultList();
	}

}
