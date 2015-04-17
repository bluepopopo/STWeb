/*
 * @(#) BaseModel.java 2014-11-11 下午10:14:53
 *
 * Copyright 2014 Fab Connector, Inc. All rights reserved.
 * Fab Connector PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */package com.fabconnector.common;

import java.util.Date;

import com.fabconnector.common.dbobject.column.ISuperColumn;
import com.fabconnector.common.dbobject.column.configuration.IUserColumn;
import com.fabconnector.model.usermgmt.UserModel;
import com.fabconnector.util.ThreadLocalHelper;
import com.jfinal.log.Logger;
import com.jfinal.plugin.activerecord.Model;

@SuppressWarnings("rawtypes")
public class BaseModel<M extends BaseModel> extends Model<M>
{
	private static final long	serialVersionUID	= 1L;

	protected Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public boolean save()
	{
		UserModel model = ThreadLocalHelper.getInstanse().getUser();
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
		return super.save();
	}

	public boolean update()
	{
		UserModel model = ThreadLocalHelper.getInstanse().getUser();
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
		return super.update();
	}
}
