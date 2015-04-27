package com.st.web.interceptor;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;
import com.jfinal.log.Logger;
import com.jfinal.plugin.activerecord.NestedTransactionHelpException;
import com.st.web.common.WebConstant;
import com.st.web.model.UserModel;
import com.st.web.util.ThreadLocalHelper;

public class SessionInterceptor implements Interceptor
{
	private Logger			logger			= Logger.getLogger(this.getClass());

	/**
	 * Define 4 transactionable pattern
	 */
	private static Pattern	patternSave		= Pattern.compile(
												".*save.*",
												Pattern.CASE_INSENSITIVE);

	private static Pattern	patternUpdate	= Pattern.compile(
												".*update.*",
												Pattern.CASE_INSENSITIVE);

	private static Pattern	patternDelete	= Pattern.compile(
												".*delete.*",
												Pattern.CASE_INSENSITIVE);

	private static Pattern	patternAdd		= Pattern.compile(
												".*add.*",
												Pattern.CASE_INSENSITIVE);

	@Override
	public void intercept(ActionInvocation ai)
	{

		logger.info("Start to intercept invocation for [" + ai.getMethodName() + "]");
		// 统一处理exception, 界面只需要监听error的json
		HttpServletRequest request = ai.getController().getRequest();

		// 判断是否ajax请求
		String header = request.getHeader("X-Requested-With");
		boolean isAjax = "XMLHttpRequest".equalsIgnoreCase(header);
		try
		{
			UserModel user = (UserModel)request.getSession().getAttribute(WebConstant.USER);
			ThreadLocalHelper.getInstanse().addUser(
				user);
			
			ai.invoke();
		}
		catch (Exception e)
		{
			e.printStackTrace();

			String msg = e.getMessage();
			if (isAjax)
			{
				msg = new StringBuilder().append(
					"{\"error\":\"").append(
					msg).append(
					"\"}").toString();
				ai.getController().renderJson(
					msg);
			}

			// TODO: must handle page rendering error in another way

			/**
			 * This is workaround for JFinal, use NestedTransactionHelpException
			 * to make sure transaction is rollback. And display current error
			 * message.
			 * 
			 * Only transactionable method need to re-throw nested transaction.
			 */
			if (patternSave.matcher(
				ai.getMethodName()).matches() || patternUpdate.matcher(
				ai.getMethodName()).matches() || patternDelete.matcher(
				ai.getMethodName()).matches() || patternAdd.matcher(
				ai.getMethodName()).matches())
			{
				throw new NestedTransactionHelpException(e.getMessage());
			}
		}
	}
}
