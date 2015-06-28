package com.business;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.domain.Fruit;
import com.domain.Register;

@Stateless
public class RegisterService {

	@PersistenceContext
	private EntityManager entitymanager;
	
	public void saveUser(Register register)
	{
		entitymanager.persist(register);
	}
	
	public List<Fruit> getAllFruit()
	{
		return entitymanager.createQuery("select f from Fruit f").getResultList();
		
	}
	
	 public List<Register> login(String email,String password) {

	        

	      return entitymanager.createQuery(

	           "select r from Register r where r.email=:email and r.password=:password")

	           .setParameter("email", email)

	           .setParameter("password", password)

	           .getResultList();

	        

	    }

	
}
