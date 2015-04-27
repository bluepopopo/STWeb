package com.st.web.controller;

import java.util.List;

import com.jfinal.core.Controller;
import com.st.web.common.WebConstant;
import com.st.web.model.PostModel;

public class ForwardController extends Controller
{
	public void index()
	{
		/**
		 * List all posts by default.
		 */
		PostModel postModel = new PostModel();
		List<PostModel> posts = postModel.getAllPosts();
		this.getRequest().setAttribute(
			WebConstant.ALL_POSTS,
			posts);
		this.renderJsp("/WEB-INF/jsp/index.jsp");
	}

	public void about()
	{
		this.renderJsp("/WEB-INF/jsp/about.jsp");
	}

	public void contact()
	{
		this.renderJsp("/WEB-INF/jsp/contact.jsp");
	}
}
