package manage.com.dao;

import java.sql.SQLException;

import manage.com.utils.Page;

public interface DepDao {
	/**
	 * 模糊查询获取分页数据
	 * @param pageNum
	 * @param pageSize
	 * @param columnName
	 * @param likeValue
	 * @return
	 * @throws SQLException 
	 */
	Page getPageByLike(int pageNum,int pageSize,String columnName,String likeValue) throws SQLException;

}
