package cn.easybuy.web;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.easybuy.utils.EmptyUtils;
import cn.easybuy.utils.PrintUtil;

/**
 * Servlet implementation class AbstractServlet
 */
@WebServlet("/AbstractServlet")
public abstract class AbstractServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public abstract Class getServletClass();

	/**
	 * @see doGet
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO doGet方法
		this.doPost(request, response);
	}

	/**
	 * @see doPost
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO doPost方法
		String actionIndicator = request.getParameter("action");
		Method method = null;
		Object result = null;
		try {
			if (EmptyUtils.isEmpty(actionIndicator)) {
				result = execute(request, response);
			} else {
				method = getServletClass().getDeclaredMethod(actionIndicator, HttpServletRequest.class,
						HttpServletResponse.class);
				result = method.invoke(this, request, response);
			}
			toView(request, response, result);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	protected void toView(HttpServletRequest request, HttpServletResponse response, Object result)
			throws IOException, ServletException {
		// TODO toView
		if (!EmptyUtils.isEmpty(result)) {
			if (result instanceof String) {
				String viewName = result.toString() + ".jsp";
				request.getRequestDispatcher(viewName).forward(request, response);
			} else {
				PrintUtil.write(result, response);
			}
		}
	}

	public Object execute(HttpServletRequest req, HttpServletResponse resp) {
		return "pre/index";
	}
}
