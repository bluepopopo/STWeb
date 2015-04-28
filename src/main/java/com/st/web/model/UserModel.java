package com.st.web.model;

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
	 * @throws exception if password is not matched.
	 */
	public UserModel verifiedByNameAndPassword()
	{
		if (JFinal.me().getConstants().getDevMode() == true)
		{
			// logger.info("The user name = " + getStr(UserModel.user_name) +
			// " password = " + getStr(UserModel.password));
		}

		UserModel user = dao.findFirst("select * from " + DBConstants.TABLE_USER + " where USER_NAME = '" + getStr(UserModel.user_name) + "' and PASSWORD = '" + getStr(UserModel.password) + "'");

		if(user == null)
		{
			throw new RuntimeException("User name or password is not matched!");
		}
		
		return user;
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
		return getInt(id);
	}
}
