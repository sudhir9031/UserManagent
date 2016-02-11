package com.scorer.usercontroller.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.scorer.service.iface.UserServiceIface;
import com.scorer.service.impl.UserServiceImpl;
import com.scorer.web.form.UserLoginForm;
import com.scorer.web.vo.UserPageVO;

public class UserAction extends ActionSupport  implements ModelDriven<UserLoginForm>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	HttpServletRequest request = ServletActionContext.getRequest();
	UserServiceIface userServiceIface=new UserServiceImpl(); 
	
	UserPageVO userPageVO;
	UserLoginForm userLoginForm;
	
	
	public String execute() {
		System.out.println("success");
	return SUCCESS;

	
	}
	
	
/* public String user()
 {
	 userPageVO=userServiceIface.getUserPage();
	 request.setAttribute("userData", userPageVO);
	 
	 return SUCCESS;
 }
	*/
 // for user login data information
 public String userInsert()
 {
	 try
	 {
		 String userName=userLoginForm.getUserName();
		 System.out.println("UserName"+userName);
		 
		 userServiceIface.save(userLoginForm);
		 request.setAttribute("userData", userLoginForm);
		 System.out.println(" User has been updated"); 
		 	
		
	 }catch(Exception e)
	 {
		 System.out.println("Exception in user insert data");
	 }
	 
	 addActionMessage("user added in database");
	 return SUCCESS;
 }
 
 // for change Password 
 public String changeUserPass()
 { 
	 try
	 {
	 String userName=userLoginForm.getUserName();
	 System.out.println("email id "+userName);
	 userServiceIface.updatePass(userLoginForm);
	 request.setAttribute("updatePass",userLoginForm);
	 
	 }catch(Exception e)
	 {
		 System.out.println("Exception in password Update");
	 }
	 
	 addActionMessage("your password has been changed");
	 return SUCCESS;
 }

// for user login
 
	public String userLogin()
	{
		if(request.getSession().getAttribute("userlogin")==null)
		{
			try
			{
				UserPageVO userPageVO=userServiceIface.getUserPage(userLoginForm);
				if(userPageVO!=null)
				{
					System.out.println("user exist");
					
					if(userPageVO.getUserPass().equals(userLoginForm.getUserPass()))
					{
						System.out.println("user logged in");
						request.getSession().setAttribute("userlogin",userPageVO);
						addActionMessage(" Hi ..You are logged in.");
						return SUCCESS;
					}
					
					else 
					{
						System.out.println("password does not match");
						addActionError("password does not match please check your password");
					}
					
					
				}
				
				else
				{
				   System.out.println("Email id not exist in Database");
				   addActionError("please check your emailid it does not match your email id ");
				}
				
						
						
											
						
			}catch(Exception e)
			{
				System.out.println("user login exception");
			}
		}
		
		return SUCCESS;
			
		
	}
	
	public String logout()
	{
	
		@SuppressWarnings("rawtypes")
		Map session=ActionContext.getContext().getSession();
		session.remove("userlogin");
		session.clear();
		
	    addActionMessage("you are logout successful");
		
		return SUCCESS;
	}
	
	
	
	

	public UserLoginForm getModel() {
		userLoginForm=new UserLoginForm();
		return userLoginForm;
	}
	

}
