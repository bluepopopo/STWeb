package com.st.web.common;

import java.util.Date;

import com.jfinal.log.Logger;
import com.jfinal.plugin.activerecord.Model;
import com.st.web.db.ISuperColumn;
import com.st.web.db.IUserColumn;
import com.st.web.model.UserModel;
import com.st.web.util.ThreadLocalHelper;

@SuppressWarnings("rawtypes")
public class BaseModel<M extends BaseModel> extends Model<M>
{
	private static final long	serialVersionUID	= 1L;

	protected Logger			logger				= Logger.getLogger(this.getClass());

	@Override
	public boolean save()
	{
		UserModel model = ThreadLocalHelper.getInstanse().getUser();

		if (model == null)
		{

		}
		else
		{
			String userId = model.getInt(IUserColumn.user_id) + "";
			/**
			 * Populate common filed of create by and creation date
			 */
			this.set(
				ISuperColumn.create_by,
				userId);
			this.set(
				ISuperColumn.creation_date,
				new java.sql.Date(new Date().getTime()));
		}
		return super.save();
	}

	public boolean update()
	{
		UserModel model = ThreadLocalHelper.getInstanse().getUser();
		if (model == null)
		{

		}
		else
		{
			String userId = model.getInt(IUserColumn.user_id) + "";
			/**
			 * Populate common filed of last update by and last update date
			 */
			this.set(
				ISuperColumn.last_update_by,
				userId);
			this.set(
				ISuperColumn.last_update_date,
				new java.sql.Date(new Date().getTime()));
		}
		return super.update();
	}

	// common attribute
	public int getId()
	{
		return this.getInt("id");
	}
	
	public String getCreateBy()
	{
		return this.getStr(ISuperColumn.create_by);
	}

	public String getCeationDate()
	{
		return this.getStr(ISuperColumn.creation_date);
	}

	public String getLastUpdateBy()
	{
		return this.getStr(ISuperColumn.last_update_by);
	}

	public String getLastUpdateDate()
	{
		return this.getStr(ISuperColumn.last_update_date);
	}
}
