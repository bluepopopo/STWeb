/*
 * @(#) PostContent.java 2015年4月19日 下午10:41:38
 *
 * Copyright 2015 ST Web, under Apache License 2.0.
 */package com.st.web.controller;

import com.st.web.common.BaseController;
import com.st.web.common.WebConstant;
import com.st.web.model.DBConstants;
import com.st.web.model.PostModel;

public class PostController extends BaseController
{
	/**
	 * View activity.
	 */
	public void addPost()
	{
		this.renderJsp("/WEB-INF/jsp/post/addpost.jsp");
	}

	/**
	 * View activity.
	 */
	public void viewPost()
	{
		this.renderJsp("/WEB-INF/jsp/post.jsp");
	}

	/**
	 * View activity.
	 */
	public void editPost()
	{
		String id = this.getRequest().getParameter(
			"id");

		PostModel post = PostModel.dao.findById(id);

		this.getRequest().setAttribute(
			WebConstant.ONE_POST,
			post);
		this.renderJsp("/WEB-INF/jsp/post/editpost.jsp");
	}

	/**
	 * Transaction activity.
	 */
	public void save()
	{
		PostModel model = this.getModel(PostModel.class);

		model.save();

		this.renderJsp("/WEB-INF/jsp/index.jsp");
	}

	/**
	 * Transaction activity.
	 */
	public void update()
	{
		PostModel model = this.getModel(PostModel.class);

		model.update();

		this.renderJsp("/WEB-INF/jsp/index.jsp");
	}

	/**
	 * Transaction activity.
	 */
	public void delete()
	{
		PostModel model = this.getModel(PostModel.class);

		model.delete();

		this.renderJsp("/WEB-INF/jsp/index.jsp");
	}

	/**
	 * Show one post by given id.
	 */
	public void getOnePost()
	{
		String id = this.getRequest().getParameter(
			"id");

		PostModel post = PostModel.dao.findById(id);

		this.getRequest().setAttribute(
			WebConstant.ONE_POST,
			post);

		this.renderJsp("/WEB-INF/jsp/post.jsp");
	}
}
