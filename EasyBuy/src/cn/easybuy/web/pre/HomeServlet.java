package cn.easybuy.web.pre;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.easybuy.entity.News;
import cn.easybuy.param.NewsParams;
import cn.easybuy.service.news.NewsService;
import cn.easybuy.service.news.NewsServiceImpl;
import cn.easybuy.service.product.ProductCategoryService;
import cn.easybuy.service.product.ProductService;
import cn.easybuy.utils.Pager;
import cn.easybuy.web.AbstractServlet;

/**
 * 首页Servlet
 */

@WebServlet(urlPatterns = { "/Home" }, name = "Home")
public class HomeServlet extends AbstractServlet {
	private static final long serialVersionUID = 1L;
	private ProductService productService;
	private NewsService newsService;
	private ProductCategoryService productCategoryService;

	/**
	 * 初始化对象
	 */
	public void init() throws ServletException {
		newsService = new NewsServiceImpl();
	}

	public String index(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 查询新闻信息
		NewsService dao = new NewsServiceImpl();
		NewsParams params = new NewsParams();
		Pager pager = new Pager(5, 5, 1);
		List<News> nlist = dao.queryNewsList(params);
		//
		// 封装返回
		// System.out.println(nlist.size()+"======================================================");
		request.setAttribute("news", nlist);
		// request.getSession().setAttribute("news", nlist);
		return "/pre/index";
	}

	@Override
	public Class getServletClass() {
		return HomeServlet.class;
	}
}
