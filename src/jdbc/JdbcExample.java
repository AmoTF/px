package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZTF
 * @version 创建时间：2018年7月11日 上午11:25:57 类说明
 */
public class JdbcExample {

	public void insert(Connection connection) {
		Connection conn = connection;
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "insert into staff(id,name,sex) values(?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 55555);
			pstmt.setString(2, "张5");
			pstmt.setString(3, "男");
			result = pstmt.executeUpdate();
			if (result == 1) {
				System.out.println("插入成功！");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("插入失败！");
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
					pstmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


	
	
	public void update(Connection connection) {
		Connection conn = connection;
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "update staff set name='张2'where id=1";
		try {
			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();
			if (result !=0) {
				System.out.println("更新成功！");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("更新失败！");
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
					pstmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void delete(Connection connection) {
		Connection conn = connection;
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "delete from staff where id=1";
		try {
			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();
			if (result !=0) {
				System.out.println("删除成功！");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("删除失败！");
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
					pstmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<Staff> showData(Connection connection) {
		Connection conn = connection;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Staff> staffList = new ArrayList<Staff>();
		String sql = "select id,name,sex from staff";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Staff staff = new Staff();
				staff.setId(rs.getInt("id"));
				staff.setName(rs.getString("name"));
				staff.setSex(rs.getString("sex"));
				staffList.add(staff);
			}
			System.out.println("查询结果:");
			for(Staff staff:staffList) {
				System.out.println(staff);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("查询失败！");
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) {
					rs.close();
					rs=null;
				}
				if (pstmt != null) {
					pstmt.close();
					pstmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return staffList;
	}
	
	public void checkStaff(Connection connection) {
		Connection conn = connection;
		JdbcExample j = new JdbcExample();
		List<Staff> staffAll=j.showData(conn);
		for(Staff staff:staffAll) {
			int idLength=String.valueOf(staff.getId()).length();
			if(idLength>3) {
				System.out.println("id="+staff.getId()+"，长度大于三位不合法！");
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = ConnUtil.getConnection();
		JdbcExample j = new JdbcExample();
		//j.insert(conn);
		//j.showData(conn);
		//j.update(conn);
		//j.delete(conn);
		j.checkStaff(conn);
	}

}
