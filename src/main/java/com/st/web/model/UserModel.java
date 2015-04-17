/*
 * @(#) User.java Aug 12, 2014
 *
 * Copyright 2014 Fab Connector. All rights reserved.
 * Fab Connector PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */package com.st.web.model;

import com.jfinal.core.JFinal;
import com.jfinal.log.Logger;
import com.st.web.common.BaseModel;
import com.st.web.db.IUserColumn;

@SuppressWarnings("serial")
public class UserModel extends BaseModel<UserModel> implements IUserColumn
{
	protected Logger		logger	= Logger.getLogger(this.getClass());

	public static UserModel	dao		= new UserModel();

	/**
	 * 
	 * @return true 濡傛灉鐢ㄦ埛鍚嶅拰瀵嗙爜鍖归厤锛屽垯杩斿洖true.
	 */
	public boolean isVerifiedByNameAndPassword()
	{
		if (JFinal.me().getConstants().getDevMode() == true)
		{
			// logger.info("The user name = " + getStr(UserModel.user_name) +
			// " password = " + getStr(UserModel.password));
		}

		UserModel user = dao.findFirst("select * from " + DBConstants.TABLE_USER + " where USER_NAME = N'" + getStr(UserModel.user_name) + "' and PASSWORD = '" + getStr(UserModel.password) + "'");

		return user == null ? false : true;
	}

	/**
	 * 
	 * @return true 濡傛灉鐢ㄦ埛鍚嶅瓨鍦紝鍒欒繑鍥瀟rue.
	 */
	public boolean exists()
	{
		if (JFinal.me().getConstants().getDevMode() == true)
		{
			// TODO: 鏆傛椂涓嶅仛鍔犲瘑澶勭悊
			logger.info("The user name = " + getStr(UserModel.user_name));
		}
		String sql = "select * from " + DBConstants.TABLE_USER + " where USER_NAME = N'" + getStr(UserModel.user_name) + "'";
		logger.info(sql);
		UserModel user = dao.findFirst(sql);

		return user == null ? false : true;
	}

	public void injectUserByUserName()
	{
		String user_name = this.getStr(IUserColumn.user_name);
		UserModel model = dao.findFirst("select * from " + DBConstants.TABLE_USER + " where user_name = '" + user_name + "'");
		this.setAttrs(model);
	}

	public String getUserName()
	{
		return getStr(user_name);
	}

	public Integer getUserId()
	{
		return getInt(user_id);
	}

	/**
	 * Set password.
	 * 
	 * @param defaultPassword
	 */
	public void setPassWord(String defaultPassword)
	{
		set(
			password,
			defaultPassword);
	}
}
