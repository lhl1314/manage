package manage.com.test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


import manage.com.dao.UserDao;
import manage.com.dao.impl.UserDaoImpl;
import manage.com.utils.MyUtils;
import manage.com.utils.Page;
import manage.com.vo.User;

public class UserTest {
	public static void main(String[] args) throws SQLException {
		String sql="select *from user";
		UserDao userDao=new UserDaoImpl();
		List<Map<String, Object>> all = userDao.getAll();
		System.out.println(all);
	
		System.out.println("-------------");
		String sql2="select *from user";
		 Map<String, Object> map = userDao.getOneById("10001");
		 Object object = map.get("jobName");
		 Object object2 = map.get("createTime");
		System.out.println(map);
		 System.out.println(object+"--"+object2);
		 
		 User user=new User();
		 user.setMobile("xxfasdfa234234234fsdaaf");
		 String update_sqlString="update user set sex='"+user.getSex()+"', mobile='"+user.getMobile()+"'where id=10002";
		int delete = MyUtils.delete(update_sqlString);
		System.out.println("=---修改"+delete);
		
		int pageId=0;
		int pageSize=3;
		String limit_sqlString="select *from user limit "+pageId+","+pageSize+"";
		List<Map<String,Object>> sqlResult = MyUtils.getSqlResult(limit_sqlString);
		sqlResult.forEach(t->{
			System.out.println(t);
		});
//		System.out.println(sqlResult);
		
		Page page= userDao.getAllUserPage(1, 10);
		System.out.println(page);
		
		
		System.out.println("---------总数量---------------");
		
		String countString="select count(*) from user";
		int size = MyUtils.getCount(countString);
		System.out.println("----总数量"+size);
		
		
		
		System.out.println("-----------------模糊查询测试----------------------");
		String columnName="username";
		String likeValue="小";
		String likeString="select *from user where  "+columnName+" like '%"+likeValue+"%'";
		List<Map<String,Object>> sqlResult2 = MyUtils.getSqlResult(likeString);
		sqlResult2.forEach(t->{
			System.out.println(t);
		});
		
		
		System.out.println("---------------------------");
		
		
		String sqlssssString="select\r\n" + 
				"r.id,r.roleName,r.status,p.permissionName\r\n" + 
				"from role as r left join rolePermission rP on r.id = rP.roleId\r\n" + 
				"left join permission p on rP.permissionId = p.id;\r\n" + 
				"";
		List<Map<String,Object>> sssssssss = MyUtils.getSqlResult(sqlssssString);
		sssssssss.forEach(t->{
			System.out.println(t);
		});
	}
}
