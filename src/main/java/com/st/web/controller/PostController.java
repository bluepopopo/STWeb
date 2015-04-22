/*
 * @(#) PostContent.java 2015年4月19日 下午10:41:38
 *
 * Copyright 2015 ST Web, under Apache License 2.0.
 */package com.st.web.controller;

import com.st.web.common.BaseController;
import com.st.web.model.PostModel;

public class PostController extends BaseController
{
	public void addPost()
	{
		this.renderJsp("/WEB-INF/jsp/post/addpost.jsp");
	}
	
	public void viewPost()
	{
		this.renderJsp("/WEB-INF/jsp/post.jsp");
	}
	
	public void save()
	{
		PostModel model = this.getModel(PostModel.class);
		
		model.save();
		
		this.renderJsp("/WEB-INF/jsp/index.jsp");
	}
	
	public void deletePost()
	{
		
	}
	
	public void getAllPosts()
	{

	}
	
	public void getOnePost()
	{
		
	}
}
