package manage.com.utils;

import java.sql.ResultSet;

public class DbDemo {
    public static void main(String[] args){
        String sql = "SELECT * FROM user";
        DbFactory dbManager = new DbFactory(sql);  //实例化

        try{
            ResultSet rs = dbManager.preparedStatement.executeQuery();
            while(rs.next()) {
//                System.out.println("id=" + rs.getObject("id"));
//                System.out.println("name=" + rs.getObject("username"));
//                System.out.println("password=" + rs.getObject("password"));
//                System.out.println("email=" + rs.getObject("email"));
//                System.out.println("birthday=" + rs.getObject("birthday"));
            }
        
            rs.close();
            
            MyUtils.getSqlResult(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
