package com.st.web.common;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.jfinal.log.Logger;
import com.jfinal.plugin.activerecord.Model;
import com.st.web.db.ISuperColumn;
import com.st.web.model.UserModel;
import com.st.web.util.ThreadLocalHelper;

@SuppressWarnings("rawtypes")
public class BaseModel<M extends BaseModel> extends Model<M>
{
	private static final long	serialVersionUID	= 1L;

	private static SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
	
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
			Integer userId = model.getUserId();
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
			Integer userId = model.getUserId();
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
	public Integer getId()
	{
		return this.getInt("id");
	}
	
	public Integer getCreateBy()
	{
		return this.getInt(ISuperColumn.create_by);
	}

	public String getFormattedCeationDate()
	{
		Timestamp time = this.getTimestamp(ISuperColumn.creation_date);
		if (time != null)
		{
			return format.format(time);
		}
		return "";
	}

	public Integer getLastUpdateBy()
	{
		return this.getInt(ISuperColumn.last_update_by);
	}

	public String getFormattedLastUpdateDate()
	{
		Timestamp time = this.getTimestamp(ISuperColumn.last_update_date);
		if (time != null)
		{
			return format.format(time);
		}
		return ""; 
	}
}
