package com.st.web.config;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.CaseInsensitiveContainerFactory;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;
import com.st.web.controller.ForwardController;
import com.st.web.controller.UserController;
import com.st.web.model.DBConstants;
import com.st.web.model.UserModel;

public class STWebJFinalConfig extends JFinalConfig
{

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jfinal.config.JFinalConfig#configConstant(com.jfinal.config.Constants
	 * )
	 */
	@Override
	public void configConstant(Constants me)
	{
		// 鍔犺浇灏戦噺蹇呰閰嶇疆锛岄殢鍚庡彲鐢╣etProperty(...)鑾峰彇鍊�
		loadPropertyFile("stweb_config.properties");
		me.setDevMode(getPropertyToBoolean(
			"devMode",
			false));
		me.setViewType(ViewType.JSP);

		me.setError404View("/login");
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jfinal.config.JFinalConfig#configRoute(com.jfinal.config.Routes)
	 */
	@Override
	public void configRoute(Routes me)
	{
		me.add(
			"/",
			ForwardController.class);
		me.add(
			"/user",
			UserController.class);		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jfinal.config.JFinalConfig#configPlugin(com.jfinal.config.Plugins)
	 */
	@Override
	public void configPlugin(Plugins me)
	{
		// 閰嶇疆C3p0鏁版嵁搴撹繛鎺ユ睜鎻掍欢
		C3p0Plugin c3p0Plugin = new C3p0Plugin(getProperty("jdbcUrl"), getProperty("user"), getProperty(
			"password").trim(), getProperty("driverClass"));
		me.add(c3p0Plugin);

		// 閰嶇疆ActiveRecord鎻掍欢
		ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
		// set db column case insenseitive
		arp.setContainerFactory(new CaseInsensitiveContainerFactory(true));
		// set mysql dialect
		arp.setDialect(new MysqlDialect());

		me.add(arp);
		
		/**
		 * Configuration model
		 */
		arp.addMapping(
			DBConstants.TABLE_USER,
			UserModel.class);
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jfinal.config.JFinalConfig#configInterceptor(com.jfinal.config.
	 * Interceptors)
	 */
	@Override
	public void configInterceptor(Interceptors me)
	{
		// 鎵�湁鍖呭惈trans鐨刟ctionkey 閮戒細璁剧疆浜嬪姟澶勭悊
//		me.add(new TxByRegex(".*save.*"));
//		me.add(new TxByRegex(".*update.*"));
//		me.add(new TxByRegex(".*delete.*"));
//		me.add(new TxByRegex(".*add.*"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jfinal.config.JFinalConfig#configHandler(com.jfinal.config.Handlers)
	 */
	@Override
	public void configHandler(Handlers me)
	{
		// TODO Auto-generated method stub

	}

//	/**
//	 * 寤鸿浣跨敤 JFinal 鎵嬪唽鎺ㄨ崘鐨勬柟寮忓惎鍔ㄩ」鐩�杩愯姝�main
//	 * 鏂规硶鍙互鍚姩椤圭洰锛屾main鏂规硶鍙互鏀剧疆鍦ㄤ换鎰忕殑Class绫诲畾涔変腑锛屼笉涓�畾瑕佹斁浜庢
//	 */
//	public static void main(String[] args)
//	{
//		JFinal.start(
//			"target/stweb-0.1",
//			8081,
//			"/stweb",
//			5);
//	}
}
