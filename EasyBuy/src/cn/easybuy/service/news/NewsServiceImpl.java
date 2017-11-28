package cn.easybuy.service.news;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import cn.easybuy.dao.news.NewsDao;
import cn.easybuy.dao.news.NewsDaoImpl;
import cn.easybuy.entity.News;
import cn.easybuy.param.NewsParams;
import cn.easybuy.utils.DataSourceUtil;

public class NewsServiceImpl implements NewsService {

	/**
	 * 添加新闻信息
	 */
	@Override
	public void addNews(News news) {
		// TODO Auto-generated method stub
		Connection connection = null;
		try {
			connection = DataSourceUtil.openConnection();
			NewsDao newsDao = new NewsDaoImpl(connection);
			newsDao.add(news);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataSourceUtil.closeConnection(connection);
		}
	}

	/**
	 * 根据条件查询新闻信息
	 */
	@Override
	public News findNewsById(String parameter) {
		// TODO Auto-generated method stub
		Connection connection = null;
		News news = null;
		try {
			connection = DataSourceUtil.openConnection();
			NewsDao newsDao = new NewsDaoImpl(connection);
			news = newsDao.getNewsById(Integer.parseInt(parameter));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DataSourceUtil.closeConnection(connection);
		}
		return news;
	}

	/**
	 * 根据条件删除新闻信息
	 */
	@Override
	public void deleteNews(String parameter) {
		// TODO Auto-generated method stub
		Connection connection = null;
		try {
			connection = DataSourceUtil.openConnection();
			NewsDao newsDao = new NewsDaoImpl(connection);
			newsDao.deleteById(Integer.parseInt(parameter));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataSourceUtil.closeConnection(connection);
		}

	}

	/**
	 * 根据条件查询出新闻信息
	 */
	@Override
	public List<News> queryNewsList(NewsParams param) {
		// TODO Auto-generated method stub
		List<News> newsList = new ArrayList<News>();
		Connection connection = null;
		NewsDao newsDao = null;
		try {
			connection = DataSourceUtil.openConnection();
			newsDao = new NewsDaoImpl(connection);
			newsList = newsDao.queryNewsList(param);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataSourceUtil.closeConnection(connection);
		}
		return newsList;
	}

	/**
	 * 根据条件查询数量
	 */
	@Override
	public Integer queryNewsCount(NewsParams param) {
		// TODO Auto-generated method stub
		Connection connection = null;
		Integer count = 0;
		try {
			connection = DataSourceUtil.openConnection();
			NewsDao newsDao = new NewsDaoImpl(connection);
			count = newsDao.queryNewsCount(param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

}
