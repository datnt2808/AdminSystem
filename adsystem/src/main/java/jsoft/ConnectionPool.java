package jsoft;

import java.sql.*;

public interface ConnectionPool {
	
	//Khởi tạo và cung cấp kết nối
	public Connection getConnection(String objectName) throws SQLException;
	
	//Thu hồi kết nối, yêu cầu trả lại kết nối
	public void releaseConnection(Connection con, String objectName) throws SQLException;
	
}
