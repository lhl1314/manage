package manage.com.dao.impl;

import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import manage.com.dao.UserDao;
import manage.com.utils.MyUtils;
import manage.com.utils.Page;
import manage.com.vo.User;

public class UserDaoImpl implements UserDao {
	@Override
	public Page getPageByLike(int pageNum, int pageSize, String columnName, String likeValue) throws SQLException {
		// TODO Auto-generated method stub
		String sqlLiSt = null;
		String countSql = null;
		if (columnName == null) {
			sqlLiSt = "select *from user limit " + pageNum * pageSize + "," + pageSize + "";
			countSql = "select count(*) from user";
		} else {
			sqlLiSt = "select *from user where " + columnName + " like '%" + likeValue + "%' limit "
					+ pageNum * pageSize + "," + pageSize + "";
			countSql = "select count(*) from user where " + columnName + " like '%" + likeValue + "%'";
		}
		int pageTotal = 0;
		int sqlCount = MyUtils.getCount(countSql);// 获取总数量
		if (sqlCount > 0) {
			if (sqlCount < pageSize) {
				pageTotal = 1;
			} else {
				pageTotal = (int) Math.ceil((double)sqlCount / pageSize);// 页码总数
			}
		} else {
			pageTotal = 0;
		}

		String limit_sqlString = "select *from user limit " + pageNum * pageSize + "," + pageSize + "";
		List<Map<String, Object>> sqlResult = MyUtils.getSqlResult(sqlLiSt);
		Page getPage = Page.getPage(pageNum, pageTotal, sqlCount, sqlResult);
		return getPage;
	}

	@Override
	public List<Map<String, Object>> getAll() throws SQLException {
		String sql = "select *from user";
		List<Map<String, Object>> list = MyUtils.getSqlResult(sql);
		return list;
	}

	@Override
	public Map<String, Object> getOneById(String id) throws SQLException {
		String sql = "select *from user where id=" + id;
		List<Map<String, Object>> list = MyUtils.getSqlResult(sql);
		if (list!=null&&!list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}



	@Override
	public Map<String, Object> userLogin(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select *from user where username='" + username+"' and password='"+password+"'";
		List<Map<String, Object>> list = MyUtils.getSqlResult(sql);
		if (list!=null&&!list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Page getAllUserPage(int pageNum, int pageSize) throws SQLException {
		// TODO Auto-generated method stub
		String countString = "select count(*) from user";
		int sqlCount = MyUtils.getCount(countString);// 获取总数量
		int pageTotal = (int) Math.ceil(sqlCount / pageSize);// 页码总数
		String limit_sqlString = "select *from user limit " + pageNum * pageSize + "," + pageSize + "";
		List<Map<String, Object>> sqlResult = MyUtils.getSqlResult(limit_sqlString);
		if (sqlResult != null && !sqlResult.isEmpty()) {

			Page getPage = Page.getPage(pageNum, pageTotal, sqlResult);
			return getPage;
		}
		return null;
	}

	@Override
	public int update(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}
}
