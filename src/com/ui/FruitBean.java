package com.ui;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.business.RegisterService;
import com.domain.Fruit;
import com.domain.Register;


@ManagedBean
@RequestScoped
public class FruitBean {

private Fruit fruit=new Fruit();

private List<Fruit> fruits;

private List<String> error = new ArrayList<String>();
	@EJB
	private RegisterService registerservice;

	@ManagedProperty("#{loginBean}")
	private LoginBean loginBean;
	
	
	
	
	
	@PostConstruct
	public void getAllFruit()
	{
	
		if(!loginBean.login().equals(""))
		{
		this.fruits= registerservice.getAllFruit();
		}else{
			this.error.add("You should login first");
		}
	}

	
	
	
	
	public Fruit getFruit() {
		return fruit;
	}
	

	public void setFruit(Fruit fruit) {
		this.fruit = fruit;
	}

	public List<Fruit> getFruits() {
		return fruits;
	}

	public void setFruits(List<Fruit> fruits) {
		this.fruits = fruits;
	}

	public RegisterService getRegisterservice() {
		return registerservice;
	}

	public void setRegisterservice(RegisterService registerservice) {
		this.registerservice = registerservice;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}





	public List<String> getError() {
		return error;
	}





	public void setError(List<String> error) {
		this.error = error;
	}

	
	
	
	
	
	
	
	
	
	
}
