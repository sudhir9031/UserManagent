package com.scorer.service.iface;



import java.util.List;

import com.scorer.web.form.UserRegistrationForm;
import com.scorer.web.vo.RegistrationPageVO;

public interface RegistrationServiceIface {
	
	
	public List<RegistrationPageVO> getUserDeatilList();
	
	boolean registerSave(UserRegistrationForm form);
	
	
	
	boolean updateUserDetails(UserRegistrationForm form);

}
