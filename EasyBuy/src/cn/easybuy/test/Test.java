package cn.easybuy.test;

import java.util.List;

import cn.easybuy.entity.News;
import cn.easybuy.param.NewsParams;
import cn.easybuy.service.news.NewsService;
import cn.easybuy.service.news.NewsServiceImpl;
import cn.easybuy.utils.Pager;

public class Test {
	public static void main(String[] args) {
		NewsDaoTest();
	}

	public static void NewsDaoTest() {
		/**
		 * 新闻添加
		 */
		System.out.println("1.新闻添加");

		NewsService dao = new NewsServiceImpl();
		NewsParams params = new NewsParams();
		Pager pager = new Pager(5, 5, 1);
		try {
			List<News> ulist = dao.queryNewsList(params);
			for (News news : ulist) {
				System.out.println(news.getTitle());
				System.out.println(news.getContent());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void chaxun() {

	}
}
