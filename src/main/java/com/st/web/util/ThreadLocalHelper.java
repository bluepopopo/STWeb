package com.st.web.util;

import com.st.web.model.UserModel;

public class ThreadLocalHelper
{
	private ThreadLocal<UserModel>	userLocal;

	private ThreadLocalHelper()
	{
		userLocal = new ThreadLocal<UserModel>();
	}

	private static ThreadLocalHelper	local	= new ThreadLocalHelper();

	public static ThreadLocalHelper getInstanse()
	{
		return local;
	}

	public void addUser(UserModel user)
	{
		userLocal.set(user);
	}

	public UserModel getUser()
	{
		return userLocal.get();
	}
}
