/*
 * @(#) PostModel.java 2015年4月21日 下午11:10:03
 *
 * Copyright 2015 ST Web, under Apache License 2.0.
 */package com.st.web.model;

import java.util.List;

import com.st.web.common.BaseModel;
import com.st.web.db.IPostColumn;

/**
 * TODO Please enter the description of this type. This is mandatory!
 * <p>
 * @author shtao, 2015年4月21日 下午11:10:03
 */
public class PostModel extends BaseModel<PostModel> implements IPostColumn
{

	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long	serialVersionUID	= 1L;
	
	public static PostModel dao = new PostModel();
	
	private String sqlText = "select p.*, u.user_name from "+DBConstants.TABLE_POST
						   +" p left join "+DBConstants.TABLE_USER+" u on p.create_by= u.id";
				 
	
	/**
	 * 
	 * @return all post object
	 */
	public List<PostModel> getAllPosts()
	{
		List<PostModel> posts = dao.find(sqlText);
		return posts;
	}
	
	public String getTitle()
	{
		return this.getStr(title);
	}
	
	public String getContent()
	{
		return this.getStr(content);
	}
	
	/**
	 * Find model by id.
	 * @param id the id value of the model
	 */
	public PostModel findById(Object id) {
		return dao.findFirst(sqlText+" where p.id="+id);
	}
}
