package jsoft.ads.user.profiles;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsoft.ConnectionPool;
import jsoft.ads.user.UserControl;
import jsoft.library.Utilities;
import jsoft.objects.UserObject;

/**
 * Servlet implementation class EditProfiles
 */
@WebServlet("/user/profiles/edit")
public class edit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String CONTENT_TYPE = "text/html; charset=utf-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public edit() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Xác định kiểu nội dung xuất về trình khách
		response.setContentType(CONTENT_TYPE);

		// Tạo đối tượng xuất nội dung (html) về trình khách
		PrintWriter out = response.getWriter();

		// Tìm id để xem chi thiết thông tin
		int id = Utilities.getIntParam(request, "id");
		String name = "", fullname = "", email = "", address = "";
		String created_date = "", mobile = "", phone = "", office = "",notes = "";
		
		//Biến xác nhận chắc chắn tồn tại đối tượng để sửa
		boolean isEdit = false;

		if (id > 0) {
			// Tìm bộ quản lý kết nối
			ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
			// Tạo đối tượng thực thi chức năng
			UserControl uc = new UserControl(cp);
			if (cp == null) {
				getServletContext().setAttribute("CPool", uc.getCP());
			}
			// Lấy đối tượng để xem thông tin
			UserObject user = uc.getUserObject(id);

			// Trả về kết nối
			uc.releaseConnection();

			// Tách thông tin
			if (user != null) {
				name = user.getUser_name();
				fullname = user.getUser_fullname();
				email = user.getUser_email();
				address = user.getUser_address();
				created_date = user.getUser_created_date();
				mobile = user.getUser_mobilephone();
				office = user.getUser_officephone();
				phone = user.getUser_homephone();
				notes = user.getUser_notes();
				
				isEdit = true;//Tồn tại đối tượng để sửa
			}

		}

		//Xác định tab để mở
		String tab = request.getParameter("t");
		String show = "";
		if(tab!=null && tab.equalsIgnoreCase("e")) {
			show = "show active";
		}
		
		out.print("<div class=\"tab-pane fade "+show+" profile-edit pt-3\" id=\"profile-edit\">");

		out.print("<!-- Profile Edit Form -->");
		out.print("<form>");
		out.print("<div class=\"row mb-3\">");
		out.print("<label for=\"profileImage\" class=\"col-md-4 col-lg-3 col-form-label\">Profile Image</label>");
		out.print("<div class=\"col-md-8 col-lg-9\">");
		out.print("<img src=\"assets/img/profile-img.jpg\" alt=\"Profile\">");
		out.print("<div class=\"pt-2\">");
		out.print("<a href=\"#\" class=\"btn btn-primary btn-sm\" title=\"Upload new profile image\"><i class=\"bi bi-upload\"></i></a>");
		out.print("<a href=\"#\" class=\"btn btn-danger btn-sm\" title=\"Remove my profile image\"><i class=\"bi bi-trash\"></i></a>");
		out.print("</div>");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"row mb-3\">");
		out.print("<label for=\"fullName\" class=\"col-md-4 col-lg-3 col-form-label\">Full Name</label>");
		out.print("<div class=\"col-md-5 col-lg-6\">");
		out.print("<input name=\"fullName\" type=\"text\" class=\"form-control\" id=\"fullName\" value=\""+fullname+"\">");
		out.print("</div>");
		out.print("<div class=\"col-md-3 col-lg-3\">");
		out.print("<input name=\"name\" type=\"text\" class=\"form-control\" id=\"name\" disabled value=\""+name+"\">");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"row mb-3\">");
		out.print("<label for=\"about\" class=\"col-md-4 col-lg-3 col-form-label\">About</label>");
		out.print("<div class=\"col-md-8 col-lg-9\">");
		out.print("<textarea name=\"notes\" class=\"form-control\" id=\"about\" style=\"height: 100px\">"+notes+"</textarea>");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"row mb-3\">");
		out.print("<label for=\"company\" class=\"col-md-4 col-lg-3 col-form-label\">Mobile</label>");
		out.print("<div class=\"col-md-8 col-lg-9\">");
		out.print("<input name=\"mobile\" type=\"text\" class=\"form-control\" id=\"company\" value=\""+mobile+"\">");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"row mb-3\">");
		out.print("<label for=\"Job\" class=\"col-md-4 col-lg-3 col-form-label\">Office</label>");
		out.print("<div class=\"col-md-8 col-lg-9\">");
		out.print("<input name=\"office\" type=\"text\" class=\"form-control\" id=\"Job\" value=\""+office+"\">");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"row mb-3\">");
		out.print("<label for=\"Phone\" class=\"col-md-4 col-lg-3 col-form-label\">Phone</label>");
		out.print("<div class=\"col-md-8 col-lg-9\">");
		out.print("<input name=\"phone\" type=\"text\" class=\"form-control\" id=\"Phone\" value=\""+phone+"\">");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"row mb-3\">");
		out.print("<label for=\"Address\" class=\"col-md-4 col-lg-3 col-form-label\">Address</label>");
		out.print("<div class=\"col-md-8 col-lg-9\">");
		out.print("<input name=\"address\" type=\"text\" class=\"form-control\" id=\"Address\" value=\""+address+"\">");
		out.print("</div>");
		out.print("</div>");

		

		out.print("<div class=\"row mb-3\">");
		out.print("<label for=\"Email\" class=\"col-md-4 col-lg-3 col-form-label\">Email</label>");
		out.print("<div class=\"col-md-8 col-lg-9\">");
		out.print("<input name=\"email\" type=\"email\" class=\"form-control\" id=\"Email\" value=\""+email+"\">");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"text-center\">");
		out.print("<button type=\"button\" onclick=\"editProfile(this.form)\" class=\"btn btn-primary\">Save Changes</button>");
		out.print("</div>");
		
		if(isEdit) {
			//Truyền id cho doPost() theo cơ chế biến form ẩn
			out.print("<input type=\"hidden\" name=\"idForPost\" value=\""+id+"\" >");
		}
		
		out.print("</form><!-- End Profile Edit Form -->");

		out.print("</div>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// Xác định tập ký tự mã hóa
		request.setCharacterEncoding("utf-8");

		// Lấy thông tin trên giao diện
		int id = Utilities.getIntParam(request, "idForPost");
		String email = request.getParameter("email");
		
		if (id>0 && email != null && !email.equalsIgnoreCase("")) {
			//Lấy tiếp thông tin
			String fullname = request.getParameter("fullName");
			String address = request.getParameter("address");
			String phone = request.getParameter("phone");
			String mobile = request.getParameter("mobile");
			String office = request.getParameter("office");
			String notes = request.getParameter("notes");
			
			//Tạo đối tượng để lưu trữ
			UserObject eUser = new UserObject();
			eUser.setUser_id(id);
			eUser.setUser_fullname(Utilities.encodeToHtml(fullname));
			eUser.setUser_email(email);
			eUser.setUser_address(Utilities.encodeToHtml(address));
			eUser.setUser_homephone(phone);
			eUser.setUser_officephone(office);
			eUser.setUser_mobilephone(mobile);
			eUser.setUser_notes(Utilities.encodeToHtml(notes));

			// Tìm bộ quản lý kết nối
			ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
			// Tạo đối tượng thực thi chức năng
			UserControl uc = new UserControl(cp);
			if (cp == null) {
				getServletContext().setAttribute("CPool", uc.getCP());
			}
			
			//Thực hiện cập nhật
			boolean result = uc.editUser(eUser);
			
			uc.releaseConnection();
			
			//Thông báo
			if(result) {
				response.sendRedirect("/adv/user/view");
			}else {
				response.sendRedirect("/adv/user/profiles?err=notok&id="+id);
			}
			

		}else {
			response.sendRedirect("/adv/user/profiles?err=param&id="+id);
		}
	}

}
