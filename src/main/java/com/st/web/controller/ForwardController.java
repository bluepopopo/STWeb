package com.st.web.controller;

import com.jfinal.core.Controller;

public class ForwardController extends Controller
{
	public void index()
	{
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
