package com.fabconnector.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.fabconnector.i18n.FabResourceBundle;
import com.fabconnector.i18n.ResourceBundleFactory;
import com.fabconnector.interceptor.SessionInterceptor;
import com.fabconnector.model.usermgmt.UserModel;
import com.fabconnector.util.Util;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.log.Logger;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;

/*
 * @(#) BaseController.java Aug 12, 2014
 *
 * Copyright 2014 Fab Connector. All rights reserved.
 * Fab Connector PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * 
 * Base controller of Fab Controller project.
 * <p>
 * 
 * @author Shawn Tao, Aug 12, 2014 10:13:57 PM
 */
@Before(SessionInterceptor.class)
public class BaseController extends Controller
{
	protected static Logger	logger	= Logger.getLogger(BaseController.class);

	/**
	 * Convert entity object to map for JSon.
	 * 
	 * @param model
	 * @return
	 */
	protected static Map<String, Object> converEntityToMap(Model<?> model)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		String[] keys = model.getAttrNames();
		for (String key : keys)
		{
			map.put(
				key,
				model.get(key));
		}
		return map;
	}

	@SuppressWarnings("rawtypes")
	protected void renderToJson(List<Model> resourceList)
	{
		List<Map<String, Object>> valueList = new ArrayList<Map<String, Object>>();
		for (Model obj : resourceList)
		{
			valueList.add(converEntityToMap(obj));
		}

		String jsonValue = JSONArray.fromObject(
			valueList).toString();
		logger.info(jsonValue);
		renderJson(jsonValue);
	}

	public String getSessionUserId()
	{
		UserModel user = this.getSessionAttr(WebConstant.USER);
		if (user == null)
		{
		}
		return user.getInt("user_id") + "";
	}
	
	public String getSessionDataSetId(){
		Integer dataId = this.getSessionAttr(WebConstant.DATASET_ID);
		if(dataId == null){
			return "-1";
		}else{
			return dataId+"";
		}
	}

	/**
	 * 获取指定key的国际化数据
	 * 
	 * @param key
	 * @return
	 */
	@Override
	public String getText(String key)
	{
		FabResourceBundle fabBundle = getBundle();
		return Util.defaultString(
			fabBundle.getBundle().getString(
				key),
			"");
	}

	/**
	 * 获取session中国家的数据,如果没有就设置内存中的数据为默认国家的,并且返回默认国家的数据
	 * 
	 * @return
	 */
	public FabResourceBundle getBundle()
	{
		FabResourceBundle fabBundle = (FabResourceBundle) this.getSession().getAttribute(
			WebConstant.RESOURCE_BUNDLE_LABEL);
		if (fabBundle == null)
		{
			fabBundle = ResourceBundleFactory.instance.retrieveFabResourceBundle(ResourceBundleFactory.instance.getDefaultLocaleType());
			this.getSession().setAttribute(
				WebConstant.RESOURCE_BUNDLE_LABEL,
				fabBundle);
		}
		return fabBundle;
	}

	/**
	 * 设置数据属于哪个国家,如果值为null,就设置内存中的数据为默认国家的,并且返回默认国家的数据
	 * 
	 * @param fabBundle
	 */
	public void setBundle(FabResourceBundle fabBundle)
	{
		if (fabBundle == null)
		{
			fabBundle = ResourceBundleFactory.instance.retrieveFabResourceBundle(ResourceBundleFactory.instance.getDefaultLocaleType());
			this.getSession().setAttribute(
				WebConstant.RESOURCE_BUNDLE_LABEL,
				fabBundle);
		}
		else
		{
			this.getSession().setAttribute(
				WebConstant.RESOURCE_BUNDLE_LABEL,
				fabBundle);
		}
	}

	/**
	 * 根据国家的语言和国家的缩写,设置数据属于哪个国家
	 * 
	 * @param localeType
	 */
	public void setBundleByLocaleType(String localeType)
	{
		FabResourceBundle bundle = ResourceBundleFactory.instance.retrieveFabResourceBundle(localeType);
		if (bundle == null)
		{
			bundle = ResourceBundleFactory.instance.retrieveFabResourceBundle(ResourceBundleFactory.instance.getDefaultLocaleType());
		}
		this.getSession().setAttribute(
			WebConstant.RESOURCE_BUNDLE_LABEL,
			bundle);
	}

	@Override
	public void renderJsp(String str)
	{
		super.renderJsp(Util.jspPrefix(str));
	}

	/**
	 * Common function to render success JSon message.
	 */
	public void renderJsonSuccess()
	{
		this.renderJson(
			"success",
			"success");
	}

	
	public void renderEasyUiPageForAllOrderAndDelayedOrder(String sql, int pageSize, int pageNumber)
	{
		Map<String, Object> returnMap = Util.newHashMap();
		Record total = Db.findFirst("select count(*) as count from ("+sql+") temp"); 
		returnMap.put(
			"total",
			total.getInt("count"));
		
		String generateSql = "SELECT TOP "+pageSize+" * FROM (SELECT ROW_NUMBER() OVER (ORDER BY order_no) AS RowNumber,* FROM ("+sql+") temp) temp2 WHERE RowNumber > "+(pageNumber-1)*pageSize;
		
		List<Record> returnList = Db.find(generateSql);
		
		logger.info("sql:"+generateSql);
		
		returnMap.put(
			"rows",
			returnList);
		this.renderJson(returnMap);
	}
	
	
	/**
	 * Common render for page
	 */
	public void renderEasyUiPage(String sql, int pageSize, int pageNumber)
	{
		Map<String, Object> returnMap = Util.newHashMap();
		List<Record> list = Db.find(sql);
		returnMap.put(
			"total",
			list.size());
		
		int startIndex = (pageNumber - 1) * pageSize;
		int endIndex = (pageNumber) * pageSize -1;
		List<Record> returnList = Util.newArrayList();
		for(int i=0;i<list.size();i++){
			if(i>= startIndex && i<= endIndex){
				returnList.add(list.get(i));
			}
		}
		returnMap.put(
			"rows",
			returnList);
		this.renderJson(returnMap);
	}
	
	public void renderEasyUiPage(List<Record> list, int pageSize, int pageNumber)
	{
		Map<String, Object> returnMap = Util.newHashMap();
		returnMap.put(
			"total",
			list.size());
		
		int startIndex = (pageNumber - 1) * pageSize;
		int endIndex = (pageNumber) * pageSize -1;
		List<Record> returnList = Util.newArrayList();
		for(int i=0;i<list.size();i++){
			if(i>= startIndex && i<= endIndex){
				returnList.add(list.get(i));
			}
		}
		returnMap.put(
			"rows",
			returnList);
		this.renderJson(returnMap);
	}
	
	
	public void renderEasyUiPage(Page<?> page){
		Map<String, Object> returnMap = Util.newHashMap();
		returnMap.put("total", page.getTotalRow());
		returnMap.put("rows", page.getList());
		this.renderJson(returnMap);
	}
}
