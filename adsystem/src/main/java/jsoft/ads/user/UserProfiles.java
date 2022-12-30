package jsoft.ads.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import jsoft.*;
import jsoft.objects.*;
import jsoft.library.*;

import java.util.*;

/**
 * Servlet implementation class View
 */
@WebServlet("/user/profiles")
public class UserProfiles extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Định nghĩa kiểu nội dung xuất về trình khách
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserProfiles() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Tìm thông tin đăng nhập trong phiên làm việc
		UserObject user = (UserObject) request.getSession().getAttribute("userLogined");
		if (user != null) {
			view(request, response);
		} else {
			response.sendRedirect("/adv/user/login");
		}
	}

	protected void view(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// Xác định kiểu nội dung xuất về trình khách
		response.setContentType(CONTENT_TYPE);

		// Tạo đối tượng xuất nội dung (html) về trình khách
		PrintWriter out = response.getWriter();

		// Tìm servlet thông qua đối tượng RequestDispatcher
		RequestDispatcher header = request.getRequestDispatcher("/header");
		if (header != null) {
			header.include(request, response);
		}

		out.print("<main id=\"main\" class=\"main\">");

		out.print("<div class=\"pagetitle\">");
		out.print("<h1>User Management</h1>");
		out.print("<nav>");
		out.print("<ol class=\"breadcrumb\">");
		out.print("<li class=\"breadcrumb-item\"><a href=\"/adv/view\">Home</a></li>");
		out.print("<li class=\"breadcrumb-item\">User management</li>");
		out.print("<li class=\"breadcrumb-item active\">User profiles</li>");
		out.print("</ol>");
		out.print("</nav>");
		out.print("</div><!-- End Page Title -->");

		out.print("<section class=\"section profile\">");
		out.print("<div class=\"row\">");
		
		RequestDispatcher avatar = request.getRequestDispatcher("/user/profiles/avatar");
		if(avatar!=null) {
			avatar.include(request, response);
		}

		out.print("<div class=\"col-xl-8\">");

		out.print("<div class=\"card\">");
		out.print("<div class=\"card-body pt-3\">");
		out.print("<!-- Bordered Tabs -->");
		out.print("<ul class=\"nav nav-tabs nav-tabs-bordered\">");
		
		//Xác định tab cần hiển thị
		String tab = request.getParameter("t");
		
		//Khai báo đối tượng xác nhận mở tab
		HashMap<String, String> actives = new HashMap<>();
		
		if(tab!=null && !tab.equalsIgnoreCase("")) {
			actives.put(tab, "active");
		}
		

		out.print("<li class=\"nav-item\">");
		out.print("<button class=\"nav-link "+actives.getOrDefault("o", "")+"\" data-bs-toggle=\"tab\" data-bs-target=\"#profile-overview\">Overview</button>");
		out.print("</li>");

		out.print("<li class=\"nav-item\">");
		out.print("<button class=\"nav-link "+actives.getOrDefault("e", "")+" \" data-bs-toggle=\"tab\" data-bs-target=\"#profile-edit\">Edit Profile</button>");
		out.print("</li>");

		out.print("<li class=\"nav-item\">");
		out.print("<button class=\"nav-link "+actives.getOrDefault("s", "")+"\" data-bs-toggle=\"tab\" data-bs-target=\"#profile-settings\">Settings</button>");
		out.print("</li>");

		out.print("<li class=\"nav-item\">");
		out.print("<button class=\"nav-link "+actives.getOrDefault("c", "")+"\" data-bs-toggle=\"tab\" data-bs-target=\"#profile-change-password\">Change Password</button>");
		out.print("</li>");

		out.print("</ul>");
		out.print("<div class=\"tab-content pt-2\">");
		
		RequestDispatcher overview = request.getRequestDispatcher("/user/profiles/overview");
		if(overview!=null) {
			overview.include(request, response);
		}
		
		RequestDispatcher edit = request.getRequestDispatcher("/user/profiles/edit");
		if(edit!=null) {
			edit.include(request, response);
		}
		
		RequestDispatcher settings = request.getRequestDispatcher("/user/profiles/settings");
		if(settings!=null) {
			settings.include(request, response);
		}
		
		RequestDispatcher changepass = request.getRequestDispatcher("/user/profiles/changepass");
		if(changepass!=null) {
			changepass.include(request, response);
		}

		out.print("</div><!-- End Bordered Tabs -->");

		out.print("</div>");
		out.print("</div>");

		out.print("</div>");
		out.print("</div>");
		out.print("</section>");

		out.print("</main><!-- End #main -->");

		RequestDispatcher footer = request.getRequestDispatcher("/footer");
		if (footer != null) {
			footer.include(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// Xác định tập ký tự cần lấy
		request.setCharacterEncoding("utf-8");

		// Lấy toàn bộ thông tin
		String name = request.getParameter("txtUserName");
		String pass = request.getParameter("txtUserPass");
		String email = request.getParameter("txtUserEmail");

		if (name != null && pass != null) {
			if (email == null) {
				email = name;
			}

			if (!name.equalsIgnoreCase("") && !pass.equalsIgnoreCase("") && !email.equalsIgnoreCase("")) {
				// Lấy tiếp thông tin
				String fullname = request.getParameter("txtFullname");

				// Tìm bộ quản lý kết nối
				ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
				// Tạo đối tượng thực thi chức năng
				UserControl uc = new UserControl(cp);
				if (cp == null) {
					getServletContext().setAttribute("CPool", uc.getCP());
				}

				// Tạo đối tượng lưu trữ thông tin
				UserObject nUser = new UserObject();
				nUser.setUser_name(name);
				nUser.setUser_pass(pass);
				nUser.setUser_email(email);
				nUser.setUser_fullname(Utilities.encodeToHtml(fullname));
				nUser.setUser_created_date("06/11/2022");
				nUser.setUser_parent_id(20);

				// Thực hiện thêm mới
				boolean results = uc.addUser(nUser);

				// Trả về kết nối
				uc.releaseConnection();

				if (results) {
					response.sendRedirect("/adv/user/view");
				} else {
					response.sendRedirect("/adv/user/add?err=notok");
				}

			} else {
				response.sendRedirect("/adv/user/add?err=value");
			}

		} else {
			response.sendRedirect("/adv/user/add?err=param");
		}

	}

}
