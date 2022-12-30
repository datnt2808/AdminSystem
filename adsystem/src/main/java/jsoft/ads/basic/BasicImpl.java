package jsoft.ads.basic;

import java.sql.*;

import jsoft.*;

public class BasicImpl implements Basic {
	// Đối tượng làm việc với Basic
	private String objectName;

	// Bộ quản lý kết nối của riêng Basic
	private ConnectionPool cp;

	// Kết nối để Basic làm việc với CSDL
	protected Connection con;

	public BasicImpl(String objectName, ConnectionPool cp) {
		// Xác định đối tượng làm việc với Basic
		this.objectName = objectName;

		// Xác định bộ quản lý kết nối
		if (cp == null) {
			this.cp = new ConnectionPoolImpl();
		} else {
			this.cp = cp;
		}

		// Xin kết nối để làm việc
		try {
			this.con = this.cp.getConnection(this.objectName);

			// Kiểm tra chế độ thực thi tự động của kết nối
			if (this.con.getAutoCommit()) {
				// Chấm dứt chế độ thực thi tự động
				this.con.setAutoCommit(false);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private synchronized boolean exe(PreparedStatement pre) {

		if (pre != null) {

			try {
				int results = pre.executeUpdate();

				// Nếu không có kết quả thực hiện
				if (results == 0) {
					this.con.rollback();
					return false;
				}

				// Xác nhận thực thi sau cùng
				this.con.commit();
				return true;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

				// Yêu cầu trở về trạng thái an toàn của kết nối
				try {
					this.con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			} finally {
				pre = null;
			}

		}

		return false;
	}

	@Override
	public boolean add(PreparedStatement pre) {
		// TODO Auto-generated method stub
		return this.exe(pre);
	}

	@Override
	public boolean edit(PreparedStatement pre) {
		// TODO Auto-generated method stub
		return this.exe(pre);
	}

	@Override
	public boolean del(PreparedStatement pre) {
		// TODO Auto-generated method stub
		return this.exe(pre);
	}

	@Override
	public ResultSet get(String sql, int value) {
		// TODO Auto-generated method stub
		// Thực hiện biên dịch câu lệnh sql
		try {
			PreparedStatement preGet = this.con.prepareStatement(sql);
			if (value > 0) {
				preGet.setInt(1, value);
			}

			// Trả về kết quả
			return preGet.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} finally {

		}
		return null;
	}

	@Override
	public ResultSet get(String sql, String name, String pass) {
		// TODO Auto-generated method stub

		// Thực hiện biên dịch câu lệnh sql
		try {
			PreparedStatement preGet = this.con.prepareStatement(sql);
			preGet.setString(1, name);
			preGet.setString(2, pass);

			// Trả về kết quả
			return preGet.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} finally {

		}

		return null;
	}

	@Override
	public ResultSet gets(String sql) {
		// TODO Auto-generated method stub
		return this.get(sql, 0);
	}

	@Override
	public ConnectionPool getCP() {
		// TODO Auto-generated method stub
		return this.cp;
	}

	@Override
	public void releaseConnection() {
		// TODO Auto-generated method stub
		try {
			this.cp.releaseConnection(this.con, this.objectName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
