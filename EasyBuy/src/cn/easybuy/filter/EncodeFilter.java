package cn.easybuy.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Servlet Filter implementation class EncodeFilter
 */
@WebFilter(urlPatterns = { "/*" }, filterName = "EncodeFilter", initParams = {
		@WebInitParam(name = "encode", value = "utf-8") })
public class EncodeFilter implements Filter {
	private String encode = null;

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO 销毁
		encode = null;
	}

	/**
	 * 
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		if (request.getCharacterEncoding() == null) {
			request.setCharacterEncoding(encode);
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO 初始化
		String encode = fConfig.getInitParameter("encode");
		if (this.encode == null) {
			this.encode = encode;
		}
	}

}
