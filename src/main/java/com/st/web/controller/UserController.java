/*
 * @(#) UserController.java 2015年4月19日 下午10:28:02
 *
 * Copyright 2015 ST Web, under Apache License 2.0.
 */package com.st.web.controller;

import com.st.web.common.BaseController;
import com.st.web.common.WebConstant;
import com.st.web.model.UserModel;
import com.st.web.util.ThreadLocalHelper;

/**
 * <p>
 * @author shtao, 2015年4月19日 下午10:28:02
 */
public class UserController extends BaseController
{
	public void index()
	{
		this.renderJsp("/WEB-INF/jsp/user/login.jsp");
	}
	
	public void login()
	{
		UserModel user = this.getModel(UserModel.class);
		user.verifiedByNameAndPassword();
		// store the user object into session
		this.getSession().setAttribute(WebConstant.USER, user);
		
		this.renderJsp("/WEB-INF/jsp/index.jsp");
	}
	
	public void logout()
	{
		this.getSession().invalidate();
	}	
}
