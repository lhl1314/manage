package manage.com.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import manage.com.utils.Page;

public interface RolePermissionDao {

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
	
	
	
	/**
	 * 获取角色权限信息
	 * @param userId
	 * @return
	 * @throws SQLException 
	 */
	 List<Map<String, Object>> getUserRolePermissionList(String userId) throws SQLException;
	
}
