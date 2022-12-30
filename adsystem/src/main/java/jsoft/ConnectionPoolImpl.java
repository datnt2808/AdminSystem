package jsoft;

import java.sql.Connection;
import java.sql.*;
import java.util.*;

public class ConnectionPoolImpl implements ConnectionPool {

	// Tài khoản làm việc với CSDL
	private String username;
	private String userpass;

	// Trình điều khiển làm việc với MySQL
	private String driver;

	// Đường dẫn thực thi của MySQL
	private String url;

	// Đối tượng lưu trữ kết nối
	private Stack<Connection> pool;

	public ConnectionPoolImpl() {
		// Xác định tài khoản
		this.username = "root";
		this.userpass = "ntd1007";

		// Xác định trình điều khiển
		this.driver = "com.mysql.jdbc.Driver";

		// Xác định đường dẫn thực thi
		this.url = "jdbc:mysql://localhost:3306/jp223_data";

		// Khởi tạo đối tượng lưu trữ
		this.pool = new Stack<>();
		
		//Nạp trình điều khiển
		this.loadDriver();

	}

	private void loadDriver() {
		try {
			Class.forName(this.driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public Connection getConnection(String objectName) throws SQLException {
		// TODO Auto-generated method stub

		if (this.pool.isEmpty()) {
			// Khởi tạo kết nối mới
			System.out.println(objectName + " have created a new Connection.");

			return DriverManager.getConnection(this.url, this.username, this.userpass);
		} else {
			// Lấy kết nối đã được lưu trữ
			System.out.println(objectName + " have popped the Connection.");
			return this.pool.pop();
		}

	}

	@Override
	public void releaseConnection(Connection con, String objectName) throws SQLException {
		// TODO Auto-generated method stub
		// Lưu trữ kết nối
		System.out.println(objectName + " have pushed the Connection.");
		this.pool.push(con);
	}

	protected void finalize() throws Throwable {
		this.url = null;
		this.username = null;
		this.userpass = null;
		this.driver = null;

		this.pool.clear();
		this.pool = null;

		System.gc();

		System.out.println("CP is closed!");

	}

}
