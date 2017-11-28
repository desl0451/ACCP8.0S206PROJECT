package cn.easybuy.dao.news;

import java.util.List;

import cn.easybuy.entity.News;
import cn.easybuy.param.NewsParams;

public interface NewsDao {
	public int add(News news) throws Exception;

	public int update(News news) throws Exception;

	public int deleteById(Integer id) throws Exception;

	public News getNewsById(Integer id) throws Exception;

	public List<News> queryNewsList(NewsParams params) throws Exception;

	public Integer queryNewsCount(NewsParams params) throws Exception;

}
