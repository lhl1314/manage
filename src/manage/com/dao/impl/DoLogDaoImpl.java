package manage.com.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import manage.com.dao.DoLogDao;
import manage.com.utils.MyUtils;
import manage.com.utils.Page;

public class DoLogDaoImpl  implements DoLogDao{

	@Override
	public Page getPageByLike(int pageNum, int pageSize, String columnName, String likeValue) throws SQLException {
		// TODO Auto-generated method stub
		String sqlLiSt = null;
		String countSql = null;
		if (columnName == null) {
			sqlLiSt = "select *from doLog limit " + pageNum * pageSize + "," + pageSize + "";
			countSql = "select count(*) from doLog";
		} else {
			sqlLiSt = "select *from doLog where " + columnName + " like '%" + likeValue + "%' limit "
					+ pageNum * pageSize + "," + pageSize + "";
			countSql = "select count(*) from doLog where " + columnName + " like '%" + likeValue + "%'";
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

}
