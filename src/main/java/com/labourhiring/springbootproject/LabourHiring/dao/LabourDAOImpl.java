package com.labourhiring.springbootproject.LabourHiring.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import jakarta.persistence.EntityManager;

@Repository
public abstract class LabourDAOImpl implements LabourDAO 
{
	@Autowired
	private EntityManager entityManager;
	
//	public List<Labour> findByVillageIdAndSpecialization(Integer villageId,Integer id)
//	{
//		Query query = entityManager.createQuery("select * from labour where id in (select spec.labour_id from specializationoflabour as spec where specialization_id=101) and village_id = 2")
//		return null;
//	}

}
