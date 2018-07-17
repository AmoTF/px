package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
*@author ZTF
*@version 创建时间：2018年7月11日 上午10:59:37
* 类说明
*/
public class ConnUtil {

	public static Connection getConnection(){
		Connection conn=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");//找到oracle驱动器所在的类
			String url="jdbc:oracle:thin:@localhost:1521:orcl"; //URL地址
			String username="ztf";
			String password="ztf123";
			conn=DriverManager.getConnection(url, username, password);
            System. out.println("创建数据库连接成功！" );  
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
            System. out.println("加载数据库驱动失败！" );  
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
            System. out.println("加载数据库驱动失败！" );  
			e.printStackTrace();
		}
		return conn;
	}
	
	
}
