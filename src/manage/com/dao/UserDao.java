package manage.com.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import manage.com.utils.Page;
import manage.com.vo.User;

public interface UserDao {
	/**
	 * 获取所有的管理员用户
	 * @return
	 * @throws SQLException
	 */
	List<Map<String, Object>> getAll() throws SQLException;
	
	/**
	 * 获取用户的分页数据
	 * @param pageId
	 * @param pageSize
	 * @return
	 * @throws SQLException
	 */
	Page getAllUserPage(int pageNum, int pageSize) throws SQLException;
	
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
	 * 通过Id获取一个元素
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	Map<String, Object>getOneById(String id) throws SQLException;
	
	/**
	 * 登录
	 * @param username
	 * @param password
	 * @return
	 * @throws SQLException 
	 */
	Map<String, Object>userLogin(String username,String password) throws SQLException;
	
	/**
	 * 添加一个用户
	 * @param user
	 * @return
	 */
	int addUser(User user);
	
	
	/**
	 * 修改一个用户
	 * @param user
	 * @return
	 */
	int update(User user);
	
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	int delete(String id);
}
