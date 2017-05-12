package cn.easybuy.dao.news;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.easybuy.dao.BaseDaoImpl;
import cn.easybuy.entity.News;
import cn.easybuy.param.NewsParams;
import cn.easybuy.utils.EmptyUtils;

public class NewsDaoImpl extends BaseDaoImpl implements NewsDao {

	public NewsDaoImpl(Connection connection) {
		super(connection);
	}

	@Override
	public void add(News news) throws Exception {// 保存新闻
		String sql = " INSERT into easybuy_news(title,content,createTime) values( ?, ?, ?) ";
		Object[] params = new Object[] { news.getTitle(), news.getContent(), new Date() };
		this.executeUpdate(sql, params);
	}

	@Override
	public void update(News news) throws Exception {// 修改新闻
		String sql = " update easybuy_news set title=?,content=? where id=? ";
		Object[] params = new Object[] { news.getTitle(), news.getContent(), news.getId() };
		this.executeUpdate(sql, params);

	}

	@Override
	public void deleteById(Integer id) throws Exception { // 删除新闻
		String sql = " delete from easybuy_news where id = ? ";
		Object params[] = new Object[] { id };
		this.executeUpdate(sql.toString(), params);
	}

	@Override
	public News getNewsById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		String sql = " select * from easybuy_news where id = ? ";
		ResultSet rs = null;
		News news = null;
		try {
			Object params[] = new Object[] { id };
			rs = this.executeQuery(sql, params);
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
		StringBuffer sql = new StringBuffer(" select id,title,content,createTime FROM easybuy_news where 1=1 ");
		if (EmptyUtils.isNotEmpty(params.getTitle())) {
			sql.append(" and title like ?");
			paramsList.add(params.getTitle());
		}
		if (EmptyUtils.isNotEmpty(params.getSort())) {
			sql.append(" order by " + params.getSort());
		}
		if (params.isPage()) {
			sql.append(" limit  " + params.getStartIndex() + "," + params.getPageSize());
		}
		ResultSet rs = this.executeQuery(sql.toString(), paramsList.toArray());
		try {
			while (rs.next()) {
				News news = this.tableToClass(rs);
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
		List<Object> paramsList = new ArrayList<Object>();
		Integer count = 0;
		StringBuffer sql = new StringBuffer("select count(*) as count  from easybuy_news where 1=1 ");
		if (EmptyUtils.isNotEmpty(params.getTitle())) {
			sql.append(" and title like ?");
			paramsList.add(params.getTitle());
		}
		ResultSet rs = this.executeQuery(sql.toString(), paramsList.toArray());
		try {
			while (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeResource(rs);
			this.closeResource();
		}
		return count;
	}

	/**
	 * 读取数据到实体中
	 */
	@Override
	public News tableToClass(ResultSet rs) throws Exception {
		// TODO Auto-generated method stub
		News news = new News();
		news.setId(rs.getInt("id"));
		news.setTitle(rs.getString("title"));
		news.setContent(rs.getString("content"));
		news.setCreateTime(rs.getDate("createTime"));
		return news;
	}

}
