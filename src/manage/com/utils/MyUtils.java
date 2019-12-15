package manage.com.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyUtils {

	/**
	 * 获取表集合数据
	 * 
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public static List<Map<String, Object>> getSqlResult(String sql) throws SQLException {
		DbFactory dbManager = new DbFactory(sql); // 实例化
		ResultSet rs = dbManager.preparedStatement.executeQuery();
		List<Map<String, Object>> list = new ArrayList();
		ResultSetMetaData md = rs.getMetaData();// 获取键名
		int columnCount = md.getColumnCount();// 获取行的数量
		while (rs.next()) {
			Map rowData = new HashMap();// 声明Map
			for (int i = 1; i <= columnCount; i++) {
				rowData.put(md.getColumnName(i), rs.getObject(i));// 获取键名及值
			}
			list.add(rowData);
		}
		rs.close();
		dbManager.close();
		return list;
	}

	/**
	 * 通过sql删除元素
	 * 
	 * @param sql
	 * @return
	 */
	public static int delete(String sql) {
		DbFactory dbManager = new DbFactory(sql); // 实例化
		try {
			int executeUpdate = dbManager.preparedStatement.executeUpdate();
			dbManager.close();
			return executeUpdate;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	/**
	 * 获取某段sql查询的数量
	 * 
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public static int getCount(String sql) throws SQLException {
		DbFactory dbManager = new DbFactory(sql); // 实例化
		ResultSet rs = dbManager.preparedStatement.executeQuery();
		int rowCount = 0;
		if (rs.next()) {
			// rowCount=rs.getInt("record_");
			rowCount = rs.getInt(1);
		}
		rs.close();
		dbManager.close();
		return rowCount;
	}
}
