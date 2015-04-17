/*
 * @(#) IndexController.java 2015年4月17日 下午2:08:44
 *
 * Copyright 2015 ST Web, under Apache License 2.0.
 */package com.st.web.controller;

import com.st.web.common.BaseController;

public class IndexController extends BaseController
{
	public void index()
	{
		this.renderJsonSuccess();
	}
}
