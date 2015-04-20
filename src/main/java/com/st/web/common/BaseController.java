package com.st.web.common;

import java.util.HashMap;
import java.util.Map;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.log.Logger;
import com.jfinal.plugin.activerecord.Model;
import com.st.web.interceptor.SessionInterceptor;
import com.st.web.model.UserModel;

/**
 * 
 * Base controller project.
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

	//
	// @SuppressWarnings("rawtypes")
	// protected void renderToJson(List<Model> resourceList)
	// {
	// List<Map<String, Object>> valueList = new ArrayList<Map<String,
	// Object>>();
	// for (Model obj : resourceList)
	// {
	// valueList.add(converEntityToMap(obj));
	// }
	//
	// String jsonValue = JSONArray.fromObject(
	// valueList).toString();
	// logger.info(jsonValue);
	// renderJson(jsonValue);
	// }

	public String getSessionUserId()
	{
		UserModel user = this.getSessionAttr(WebConstant.USER);
		if (user == null)
		{
		}
		return user.getInt("user_id") + "";
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

}
