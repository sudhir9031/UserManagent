package com.scorer.usercontroller.action;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.scorer.service.iface.RegistrationServiceIface;
import com.scorer.service.impl.RegistrationServiceImpl;
import com.scorer.web.form.UserRegistrationForm;
import com.scorer.web.vo.RegistrationPageVO;

public class UserRegistrationAction extends ActionSupport implements ModelDriven<UserRegistrationForm> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	HttpServletRequest request = ServletActionContext.getRequest();
	RegistrationServiceIface registrationServiceIface=new RegistrationServiceImpl();
	RegistrationPageVO registrationPageVo;
	UserRegistrationForm userRegistrationForm;
	List<RegistrationPageVO> userList = new ArrayList<RegistrationPageVO>();
	
	
	public String execute() {
		 
    System.out.println("success");
	return SUCCESS;
	}
	
	



	public String registrationDetails()
	{
		try
		{
        String name=userRegistrationForm.getFirstName();
        System.out.println("Registration Details"+name);
        
         userList=registrationServiceIface.getUserDeatilList();
		
		 request.setAttribute("userRegister", userList);
		 System.out.println(" User Registartion details has been updated"); 		
		}catch(Exception e)
		{
			System.out.println("Exception in user Regitration page");
		}
		return SUCCESS;
	}
	

	public String registrationSave()
	{
		try
		{
			String firstName=userRegistrationForm.getFirstName();
			System.out.println("user first Name"+firstName);
			registrationServiceIface.registerSave(userRegistrationForm);
			 request.setAttribute("userRegister", userRegistrationForm);
			 System.out.println(" User Registartion has been updated"); 
			
			
			
		}catch(Exception e)
		{
		  System.out.println("Exception user Registartion");
		}
		 addActionMessage("your Registration page has been successfull updated");
		return SUCCESS;
	}
	
	
	
	public List<RegistrationPageVO> getUserList() {
		return userList;
	}





	public void setUserList(List<RegistrationPageVO> userList) {
		this.userList = userList;
	}





	public String registrationUpdate()
	{
		try
		{
		String firstName=userRegistrationForm.getFirstName();
		System.out.println("first name"+firstName);
	    registrationServiceIface.updateUserDetails(userRegistrationForm);
	    request.setAttribute("updateRegisterData",userRegistrationForm);
		
		}catch(Exception e)
		{
			System.out.println("Exception in userregistration Update"+e);
		}
		
		addActionMessage("your profile page is updated successfully");
		return SUCCESS;
	}
	
	
	
		public UserRegistrationForm getModel() {
		userRegistrationForm=new UserRegistrationForm();
		
		return userRegistrationForm;
	}
		





		
		
	
}
