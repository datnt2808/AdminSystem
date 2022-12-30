package jsoft.ads.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import jsoft.*;
import jsoft.objects.*;
import jsoft.library.*;

/**
 * Servlet implementation class View
 */
@WebServlet("/user/add")
public class UserAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Định nghĩa kiểu nội dung xuất về trình khách
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserAdd() {
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
		out.print("<li class=\"breadcrumb-item active\">User add</li>");
		out.print("</ol>");
		out.print("</nav>");
		out.print("</div><!-- End Page Title -->");

		out.print("<section class=\"section\">");
		out.print("<div class=\"row\">");
		out.print("<div class=\"col-lg-12\">");

		out.print("<div class=\"card\">");
		out.print("<div class=\"card-body\">");
		out.print("<h5 class=\"card-title\"><i class=\"fa-solid fa-user-group\"></i> &nbsp; ACCOUNT INFORMATION</h5>");

		out.print("<form>");

		out.print("<div class=\"row mb-3 align-items-center\">");
		out.print("<div class=\"col-md-2 text-end\">");
		out.print("<label for=\"name\" class=\"form-label\">Username / Email</label>");
		out.print("</div>");
		out.print("<div class=\"col-md-4\">");
		out.print(
				"<input type=\"text\" class=\"form-control\" id=\"name\" name=\"txtUserName\" aria-describedby=\"nameHelp\" onKeyup=\"checkName()\">");
		out.print("<div id=\"nameHelp\" class=\"form-text\">Nhập thông tin tên tài khoản vào hệ thống</div>");
		out.print("</div>");

		out.print("<div class=\"col-md-4\">");
		out.print("<div id=\"errName\"></div>");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"row mb-3 align-items-center\">");
		out.print("<div class=\"col-md-2 text-end\">");
		out.print("<label for=\"pass\" class=\"form-label\">Userpass </label>");
		out.print("</div>");
		out.print("<div class=\"col-md-4\">");
		out.print(
				"<input type=\"password\" class=\"form-control\" id=\"pass\" name=\"txtUserPass\" onKeyup=\"checkPass()\">");
		out.print("</div>");

		out.print("<div class=\"col-md-1 text-end\">");
		out.print("<label for=\"pass2\" class=\"form-label\">Confirm  </label>");
		out.print("</div>");
		out.print("<div class=\"col-md-4\">");
		out.print(
				"<input type=\"password\" class=\"form-control\" id=\"pass2\" name=\"txtUserPass2\" onKeyup=\"checkPass()\">");
		out.print("<div id=\"errPass\"></div>");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"row mb-3 align-items-center\">");
		out.print("<div class=\"col-md-2 text-end\">");
		out.print("<label for=\"email\" class=\"form-label\">Email </label>");
		out.print("</div>");
		out.print("<div class=\"col-md-4\">");
		out.print("<div class=\"input-group \">");
		out.print(
				"<input type=\"text\" class=\"form-control\" id=\"email\" name=\"txtUserEmail\" placeholder=\"Recipient's username\" aria-label=\"Recipient's username\" aria-describedby=\"basic-addon2\" onKeyup=\"checkEmail()\">");
		out.print("<span class=\"input-group-text\" id=\"basic-addon2\">@java.com</span>");
		out.print("</div>");
		out.print("</div>");
		out.print("<div class=\"col-md-4\">");
		out.print("<div id=\"errEmail\"></div>");
		out.print("</div>");

		out.print("</div>");

		out.print("<div class=\"row mb-3 align-items-center\">");
		out.print("<div class=\"col-md-2 text-end\">");
		out.print("<label for=\"permis\" class=\"form-label\">Permision</label>");
		out.print("</div>");
		out.print("<div class=\"col-md-4\">");
		out.print("<script language=\"javascript\">");
		out.print("generatePermis();");
		out.print("</script>");
		out.print("</div>");

		out.print("<div class=\"col-md-4 offset-md-1\">");
		out.print("<div id=\"errPermis\"></div>");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"row mb-3 align-items-center\">");
		out.print("<div class=\"col-md-2 text-end\">");
		out.print("<label for=\"fullname\" class=\"form-label\">Fullname</label>");
		out.print("</div>");
		out.print("<div class=\"col-md-4\">");
		out.print("<input type=\"text\" class=\"form-control\" id=\"fullname\" name=\"txtFullname\" aria-describedby=\"nameHelp\">");
		out.print("<div id=\"nameHelp\" class=\"form-text\">Tên đầy đủ cho tài khoản</div>");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"row align-items-center\">");
		out.print("<div class=\"col-md-12 text-center\">");
		out.print("<hr class=\"border border-1 border-primary\">");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"row mb-3 align-items-center\">");
		out.print("<div class=\"col-md-12 text-center\">");
		out.print(
				"<button type=\"button\" class=\"btn btn-primary\" onClick=\"createAccount(this.form)\"><i class=\"fa-solid fa-arrow-right-to-bracket\"></i> Create account</button>&nbsp;");
		out.print(
				"<button type=\"button\" class=\"btn btn-primary\"><i class=\"fa-solid fa-arrow-right-from-bracket\"></i> Cancel</button>");
		out.print("</div>");
		out.print("</div>");

		out.print("</form>");

		out.print("</div>");
		out.print("</div>");// Card

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
		
		//Xác định tập ký tự cần lấy
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
				//Lấy tiếp thông tin
				String fullname = request.getParameter("txtFullname");
				byte permis = Utilities.getBytearam(request, "permis");
				
				// Tìm bộ quản lý kết nối
				ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
				// Tạo đối tượng thực thi chức năng
				UserControl uc = new UserControl(cp);
				if (cp == null) {
					getServletContext().setAttribute("CPool", uc.getCP());
				}
				
				//Tạo đối tượng lưu trữ thông tin
				UserObject nUser = new UserObject();
				nUser.setUser_name(name);
				nUser.setUser_pass(pass);
				nUser.setUser_email(email);
				nUser.setUser_fullname(Utilities.encodeToHtml(fullname));
				nUser.setUser_created_date("06/11/2022");
				nUser.setUser_parent_id(20);
				nUser.setUser_permission(permis);
				
				//Thực hiện thêm mới
				boolean results = uc.addUser(nUser);

				// Trả về kết nối
				uc.releaseConnection();
				
				if(results) {
					response.sendRedirect("/adv/user/view");
				}else {
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
