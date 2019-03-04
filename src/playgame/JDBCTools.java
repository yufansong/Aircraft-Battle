package playgame;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTools {

//	public static Connection getConnection(){  
//        String driver="com.mysql.jdbc.Driver";   //获取mysql数据库的驱动类  
//        String url="jdbc:mysql://localhost/planegame"; //连接数据库（xskc是数据库名）  
//        String name="root";//连接mysql的用户名  
//        String pwd="123456";//连接mysql的密码  
//        try{  
//            Class.forName(driver);  //1. 加载驱动程序
//            Connection conn=DriverManager.getConnection(url,name,pwd);//2. 打开数据库连接 
//            return conn;  
//        }catch(ClassNotFoundException e){  
//            e.printStackTrace();  
//            return null;  
//        }catch(SQLException e){  
//            e.printStackTrace();  
//            return null;  
//        }  
//    }  

	public static Connection getConnection() throws Exception {
		// TODO Auto-generated method stub
           Properties properties = new Properties();
           
           InputStream inStream = JDBCTools.class.getClassLoader()
        		   .getResourceAsStream("jdbc.properties");  
           properties.load(inStream);
           
           String user = properties.getProperty("user");
           String password = properties.getProperty("password");
           String url = properties.getProperty("url");
           String jdbcDriver = properties.getProperty("jdbcDriver");
           
           Class.forName(jdbcDriver);
           
           Connection connection = DriverManager.getConnection(url,user,password);
           return connection;
	}
	public static void releaseDB(ResultSet resultSet,Statement statement,Connection connection){
		
		if(resultSet !=null){
			try{
				resultSet.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		if(statement !=null){
			try{
				statement.close();
			}catch(SQLException e){
				e.printStackTrace();
		}
	}

}
}
