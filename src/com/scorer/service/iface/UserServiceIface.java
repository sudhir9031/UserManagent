package com.scorer.service.iface;

import com.scorer.web.form.UserLoginForm;
import com.scorer.web.vo.UserPageVO;

public interface UserServiceIface {
	
  UserPageVO getUserPage(UserLoginForm form);
	
	
	
	boolean save(UserLoginForm form);
	
	boolean updatePass(UserLoginForm form);

}
