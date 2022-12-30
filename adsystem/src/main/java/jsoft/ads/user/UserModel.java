package jsoft.ads.user;

import jsoft.*;
import jsoft.objects.*;

import java.sql.*;
import java.util.*;

public class UserModel {
	private User u;

	public UserModel(ConnectionPool cp) {
		this.u = new UserImpl(cp);
	}

	protected void finalize() throws Throwable {
		this.u = null;
	}
	
	public ConnectionPool getCP() {
		return this.u.getCP();
	}
	
	public void releaseConnection() {
		this.u.releaseConnection();
	}

	// ---------------------------------------------------------------
	public boolean addUser(UserObject item) {
		return this.u.addUser(item);
	}

	public boolean editUser(UserObject item) {
		return this.u.editUser(item);
	}

	public boolean delUser(UserObject item) {
		return this.u.delUser(item);
	}

	// ---------------------------------------------------------------
	public UserObject getUserObject(int id) {
		UserObject item = null;

		ResultSet rs = this.u.getUser(id);
		if (rs != null) {
			try {
				if (rs.next()) {
					// Khởi tạo bộ nhớ cho đối tượng lưu trữ
					item = new UserObject();
					item.setUser_id(rs.getInt("user_id"));
					item.setUser_name(rs.getString("user_name"));
					item.setUser_fullname(rs.getString("user_fullname"));
					item.setUser_created_date(rs.getString("user_created_date"));
					item.setUser_permission(rs.getByte("user_permission"));
					item.setUser_email(rs.getString("user_email"));
					item.setUser_address(rs.getString("user_address"));
					item.setUser_notes(rs.getString("user_notes"));
					item.setUser_homephone(rs.getString("user_homephone"));
					item.setUser_officephone(rs.getString("user_officephone"));
					item.setUser_mobilephone(rs.getString("user_mobilephone"));

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return item;
	}

	public UserObject getUserObject(String username, String userpass) {
		UserObject item = null;

		ResultSet rs = this.u.getUser(username, userpass);
		if (rs != null) {
			try {
				if (rs.next()) {
					// Khởi tạo bộ nhớ cho đối tượng lưu trữ
					item = new UserObject();
					item.setUser_id(rs.getInt("user_id"));
					item.setUser_name(rs.getString("user_name"));
					item.setUser_fullname(rs.getString("user_fullname"));
					item.setUser_created_date(rs.getString("user_created_date"));
					item.setUser_permission(rs.getByte("user_permission"));
					item.setUser_email(rs.getString("user_email"));
					item.setUser_address(rs.getString("user_address"));
					item.setUser_homephone(rs.getString("user_homephone"));
					item.setUser_officephone(rs.getString("user_officephone"));
					item.setUser_mobilephone(rs.getString("user_mobilephone"));

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return item;
	}

	public ArrayList<UserObject> getUserObjects(UserObject similar, UserSort us, short page, byte total) {

		ArrayList<UserObject> items = new ArrayList<>();

		UserObject item = null;

		int at = (page - 1) * total;

		ResultSet rs = this.u.getUsers(similar, us, at, total);
		if (rs != null) {
			try {
				while (rs.next()) {
					// Khởi tạo bộ nhớ cho đối tượng lưu trữ
					item = new UserObject();
					item.setUser_id(rs.getInt("user_id"));
					item.setUser_name(rs.getString("user_name"));
					item.setUser_fullname(rs.getString("user_fullname"));
					item.setUser_created_date(rs.getString("user_created_date"));
					item.setUser_permission(rs.getByte("user_permission"));
					item.setUser_email(rs.getString("user_email"));
					item.setUser_address(rs.getString("user_address"));
					item.setUser_homephone(rs.getString("user_homephone"));
					item.setUser_officephone(rs.getString("user_officephone"));
					item.setUser_mobilephone(rs.getString("user_mobilephone"));

					// Thêm vào danh sách
					items.add(item);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return items;
	}
	// ---------------------------------------------------------------

}
