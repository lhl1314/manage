package manage.com.utils;

import java.sql.*;

public class DbFactory {
    //数据库地址
    private static final String url = "jdbc:mysql://139.196.125.230:3306/manage";
    private static final String name = "com.mysql.jdbc.Driver";
    private static final String username = "root";
    private static final String password = "131412";
    
    public Connection connection=null;
    public PreparedStatement preparedStatement=null;
    public DbFactory(){
    	
    }
    public DbFactory(String sql){
        try{
            Class.forName(name);
            connection = DriverManager.getConnection(url, username, password);
            preparedStatement = connection.prepareStatement(sql);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void close(){
        try{
            this.connection.close();
            this.preparedStatement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    } 
    
}
