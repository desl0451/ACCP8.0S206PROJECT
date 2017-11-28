package cn.easybuy.param;

import cn.easybuy.entity.User;

public class UserParams extends User {

	public void openPage(Integer startIndex, Integer pageSize) {
		this.isPage = true;
		this.startIndex = startIndex;
		this.pageSize = pageSize;
	}

	/**
	 * 开始索引
	 */
	private Integer startIndex;
	/**
	 * 每页数量
	 */
	private Integer pageSize;
	/**
	 * 是否分页
	 */
	private boolean isPage = false;
	/**
	 * 排序条件
	 */
	private String sort;

	public Integer getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public boolean isPage() {
		return isPage;
	}

	public void setPage(boolean isPage) {
		this.isPage = isPage;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
}
