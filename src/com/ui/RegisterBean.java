package com.ui;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.business.RegisterService;
import com.domain.Register;

@ManagedBean
@RequestScoped
public class RegisterBean {

	private Register register=new Register();
	private List<Register> registers;
	@EJB
	private RegisterService registerservice;
	

	public String saveRegister()
	{
		registerservice.saveUser(register);
		return "login?faces-redirect=true";
	}
	public Register getRegister() {
		return register;
	}
	public void setRegister(Register register) {
		this.register = register;
	}

	public void login(String email,String password)
	{
		
		this.registers = registerservice.login(email, password);
		
	}
	
	
	
}
