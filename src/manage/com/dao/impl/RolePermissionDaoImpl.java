package manage.com.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import manage.com.dao.RolePermissionDao;
import manage.com.utils.MyUtils;
import manage.com.utils.Page;

public class RolePermissionDaoImpl implements RolePermissionDao {

	@Override
	public Page getPageByLike(int pageNum, int pageSize, String columnName, String likeValue) throws SQLException {
		// TODO Auto-generated method stub
		String sqlLiSt = null;
		String countSql = null;
		if (columnName == null) {
			sqlLiSt = "select\r\n" + 
					"r.id,r.roleName,r.createTime,r.status,p.permissionName\r\n" + 
					"from role as r left join rolePermission rP on r.id = rP.roleId\r\n" + 
					"left join permission p on rP.permissionId = p.id  limit " + pageNum * pageSize + "," + pageSize + "";
			countSql = "select\r\n" + 
					"    count(*)\r\n" + 
					"from role as r left join rolePermission rP on r.id = rP.roleId\r\n" + 
					"               left join permission p on rP.permissionId = p.id";
		} else {
			sqlLiSt = "select\r\n" + 
					"r.id,r.roleName,r.createTime,r.status,p.permissionName\r\n" + 
					"from role as r left join rolePermission rP on r.id = rP.roleId\r\n" + 
					"left join permission p on rP.permissionId = p.id where " + columnName + " like '%"
					+ likeValue + "%' limit " + pageNum * pageSize + "," + pageSize + "";
			countSql = "select\r\n" + 
					"    count(*)\r\n" + 
					"from role as r left join rolePermission rP on r.id = rP.roleId\r\n" + 
					"               left join permission p on rP.permissionId = p.id where " + columnName
					+ " like '%" + likeValue + "%'";
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
		List<Map<String, Object>> sqlResult = MyUtils.getSqlResult(sqlLiSt);
		Page getPage = Page.getPage(pageNum, pageTotal, sqlCount, sqlResult);
		return getPage;
	}

	@Override
	public List<Map<String, Object>> getUserRolePermissionList(String userId) throws SQLException {
		// TODO Auto-generated method stub
		String sqlString = "select\r\n" + "u.id userId,r.roleName,p.permissionName,r.id roleId,r.status\r\n"
				+ "from role as r left join rolePermission rP on r.id = rP.roleId\r\n"
				+ "left join permission p on rP.permissionId = p.id\r\n"
				+ "left join userRole uR on r.id = uR.roleId\r\n" + "left join user u on uR.userId = u.id where u.id="
				+ userId;
		List<Map<String, Object>> sqlResult = MyUtils.getSqlResult(sqlString);
		return sqlResult;
	}
}
