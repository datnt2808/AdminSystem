package jsoft.ads.user;

import java.sql.*;
import jsoft.objects.*;

import jsoft.*;

public interface User extends ShareControl {
	
	//Các chức năng cập nhật đối tượng Người sử dụng
	public boolean addUser(UserObject item);
	public boolean editUser(UserObject item);
	public boolean delUser(UserObject item);
	
	//Các chức năng lấy thông tin đối tượng Người sử dụng
	public ResultSet getUser(int id);
	public ResultSet getUser(String username, String userpass);
	
	public ResultSet getUsers(UserObject similar, int at, byte total);
	
	public ResultSet getUsers(UserObject similar, UserSort us, int at, byte total);
	
	//public boolean changePassword(UserObject item);
	
}
