package jsoft.ads.user;

import jsoft.*;
import jsoft.objects.*;

import java.util.*;

public class UserControl {
	
	private UserModel um;
	
	public UserControl(ConnectionPool cp) {
		this.um = new UserModel(cp);
	}

	protected void finalize() throws Throwable {
		this.um = null;
	}
	
	public ConnectionPool getCP() {
		return this.um.getCP();
	}
	
	public void releaseConnection() {
		this.um.releaseConnection();
	}

	// ---------------------------------------------------------------
	public boolean addUser(UserObject item) {
		return this.um.addUser(item);
	}

	public boolean editUser(UserObject item) {
		return this.um.editUser(item);
	}

	public boolean delUser(UserObject item) {
		return this.um.delUser(item);
	}
	
	// ---------------------------------------------------------------
	public UserObject getUserObject(int id) {
		return this.um.getUserObject(id);
	}
	
	public UserObject getUserObject(String username, String userpass) {
		return this.um.getUserObject(username, userpass);
	}
	
	// ---------------------------------------------------------------
	public String viewUsers(UserObject similar, UserSort us, short page, byte total) {
		//Lấy danh sách đối tượng
		ArrayList<UserObject> items = this.um.getUserObjects(similar, us, page, total);
		
		return UserLibrary.viewUsers(items, similar);
	}
	
	public static void main(String[] args) {
		//Khởi tạo đối tượng thực thi chức năng mức COntrol
		UserControl uc = new UserControl(null);
		
		//Lấy cấu trúc hiển thị dang HTML
		String view = uc.viewUsers(null, UserSort.NAME, (short)1, (byte)20);
		
		//Trả về kết nối
		uc.releaseConnection();
		
		//Hiển thị
		System.out.println(view);
	}
	
	
	
	
}
