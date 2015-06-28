package com.ui;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.business.RegisterService;
import com.domain.Register;

@ManagedBean
@SessionScoped
public class LoginBean {

	
	private String email;
	private String password;
	
	private List<Register> registers;
	
	
	@EJB
	private RegisterService registerservice;
	

	

	public String login()
	{
		
		this.registers = registerservice.login(this.email, this.password);
		
		if(!this.registers.isEmpty())
		{
			
			return "fruit";
			
		}
		
		return "";
		
		
	}

	 public void info() {
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Wrong email or password", ""));
	    }


	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public List<Register> getRegisters() {
		return registers;
	}




	public void setRegisters(List<Register> registers) {
		this.registers = registers;
	}




	
	
	
	
}
