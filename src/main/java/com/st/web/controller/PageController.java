package com.st.web.controller;

import com.jfinal.core.Controller;

public class PageController extends Controller
{
	public void index()
	{
		this.renderJsp("/WEB-INF/jsp/index.jsp");
	}

	public void about()
	{
		this.renderJsp("/WEB-INF/jsp/aboutme.jsp");
	}
}
