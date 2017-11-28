package cn.easybuy.dao.news;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.easybuy.dao.BaseDaoImpl;
import cn.easybuy.entity.News;
import cn.easybuy.param.NewsParams;
import cn.easybuy.utils.EmptyUtils;

public class NewsDaoImpl extends BaseDaoImpl implements NewsDao {

	public NewsDaoImpl(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 新加新闻信息
	 */
	@Override
	public int add(News news) throws Exception {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO easybuy.easybuy_news(title, content, createTime)VALUES(?,?,?);";
		Object[] param = { news.getTitle(), news.getContent(), news.getCreateTime() };
		return this.executeInsert(sql, param);
	}

	/**
	 * 将表转换为类对象
	 */
	@Override
	public Object tableToClass(ResultSet rs) throws Exception {
		// TODO Auto-generated method stub
		News news = new News();
		news.setId(rs.getInt("id"));
		news.setTitle(rs.getString("title"));
		news.setContent(rs.getString("content"));
		news.setCreateTime(rs.getDate("createTime"));
		return news;
	}

	/**
	 * 更新新闻信息
	 */
	@Override
	public int update(News news) throws Exception {
		// TODO Auto-generated method stub
		String sql = "UPDATE easybuy_news SET title = ?, content =? , createTime = ? WHERE	id = ? ";
		Object[] param = { news.getTitle(), news.getContent(), news.getCreateTime(), news.getId() };
		return this.executeUpdate(sql, param);
	}

	/**
	 * 根据ID删除新闻信息
	 */
	@Override
	public int deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM easybuy_news WHERE id = ?";
		Object[] param = { id };
		return this.executeUpdate(sql, param);
	}

	/**
	 * 根据ID查询新闻信息
	 */
	@Override
	public News getNewsById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		News news = null;
		String sql = "select * from easybuy_news where id=?";
		Object[] param = { id };
		try {
			rs = this.executeQuery(sql, param);
			while (rs.next()) {
				news = (News) tableToClass(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeResource(rs);
			this.closeResource();
		}
		return news;
	}

	@Override
	public List<News> queryNewsList(NewsParams params) throws Exception {
		// TODO Auto-generated method stub
		List<Object> paramsList = new ArrayList<Object>();
		List<News> newsList = new ArrayList<News>();
		StringBuffer sql = new StringBuffer("select id,title,content,createTime from easybuy_news where 1=1 ");
		// 判断标题是否为空
		if (EmptyUtils.isNotEmpty(params.getTitle())) {
			sql.append(" and title like ?");
			paramsList.add(params.getTitle());
		}
		// 判断是否排序
		if (EmptyUtils.isNotEmpty(params.getSort())) {
			sql.append(" order by " + params.getSort());
			paramsList.add(params.getSort());
		}
		// 判断是否分页
		if (params.isPage()) {
			sql.append(" limit " + params.getStartIndex() + "," + params.getPageSize());
		}
		ResultSet rs = this.executeQuery(sql.toString(), paramsList.toArray());
		try {
			while (rs.next()) {
				News news = (News) tableToClass(rs);
				newsList.add(news);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeResource(rs);
			this.closeResource();
		}
		return newsList;
	}

	@Override
	public Integer queryNewsCount(NewsParams params) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
