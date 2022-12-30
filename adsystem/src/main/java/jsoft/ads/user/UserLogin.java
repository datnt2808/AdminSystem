package jsoft.ads.user;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import jsoft.*;
import jsoft.objects.*;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/user/login")
public class UserLogin extends HttpServlet {

	// Định danh của Servlet
	private static final long serialVersionUID = 1L;

	// Định nghĩa kiểu nội dung xuất về trình khách
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Phương thức thường được dùng để cung cấp một giao diện (GUI) / cấu trúc HTML
	 * <br>
	 * Phương thức này được gọi trong 2 trường hợp:<br>
	 * 1) Thông qua đường dẫn URL, ví dụ: http://localhost:8080/adv/user/login<br>
	 * 2) Thông qua sự kiện của form, ví dụ: method="get"<br>
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * @param request  - Lưu trữ các yêu cầu cần xử lý, dữ liệu cần xử lý <br>
	 * @param response - lưu trữ các kết quả xử lý gửi về trình khách
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// Xác định kiểu nội dung xuất về trình khách
		response.setContentType(CONTENT_TYPE);

		// Tạo đối tượng xuất nội dung (html) về trình khách
		PrintWriter out = response.getWriter();
		
		//Tìm tham số báo lỗi nếu có
		String error = request.getParameter("err");
		String message = "";
		if(error!=null) {
			if(error.equalsIgnoreCase("param")) {
				message = "Chưa chính xác tên tham số lấy giá trị.";
			}else if(error.equalsIgnoreCase("value")) {
				message = "Không có giá trị để đăng nhập";
			}else if(error.equalsIgnoreCase("notok")) {
				message = "Đăng nhập không thành công";
			}else {
				message = "Không thành công";
			}
		}
		
		

		// Thực hiện xuất
		out.print("<!doctype html>");
		out.print("<html lang=\"en\">");
		out.print("<head>");
		out.print("<meta charset=\"utf-8\">");
		out.print("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		out.print("<meta name=\"description\" content=\"\">");
		out.print("<meta name=\"author\" content=\"Quang Huy\">");
		out.print("<meta name=\"generator\" content=\"Version 2\">");
		out.print("<title>Login</title>");
		
		out.print("<link href=\"/adv/css/all.min.css\" rel=\"stylesheet\">");
		out.print("<link href=\"/adv/css/bootstrap.min.css\" rel=\"stylesheet\">");
		out.print("<link href=\"/adv/css/login_v3.css\" rel=\"stylesheet\">");
		out.print("<script language=\"javascript\" src=\"/adv/js/login_v3.js\"></script>");

		out.print("</head>");
		out.print("<body>");
		out.print("<div class=\"container-lg \">");
		out.print("<div class=\"row\">");
		out.print("<div class=\"col-lg-6 offset-lg-3\">");
		out.print("<div class=\"view text-bg-light\">");
		out.print("<form>");
		
		if(!message.equalsIgnoreCase("")) {
			out.print("<div class=\"row mt-5 mb-3\">");
			out.print("<div class=\"col-md-12 text-center\">");
			out.print("<div class=\"text-bg-danger py-3 \"><i class=\"fa-solid fa-circle-exclamation\"></i> "+message+"</div>");
			out.print("</div>");
			out.print("</div>");
		}
		
		out.print("<div class=\"row mt-5 mb-3\">");
		out.print("<div class=\"col-md-12 text-center\">");
		out.print("<div class=\"view-title text-bg-primary py-3 text-uppercase\"><i class=\"fa-solid fa-user-large\"></i> Login</div>");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"row mb-3 align-items-center\">");
		out.print("<div class=\"col-md-4 text-end\">");
		out.print("<label for=\"name\" class=\"form-label\">Username / Email</label>");
		out.print("</div>");
		out.print("<div class=\"col-md-6\">");
		out.print("<input type=\"text\" class=\"form-control\" name=\"txtUserName\" id=\"name\" aria-describedby=\"nameHelp\" onKeyup=\"checkValidLogin()\">");
		out.print("<div id=\"nameHelp\" class=\"form-text\">Bạn cần phải có tài khoản hoặc hộp thư để đăng nhập.</div>");
		out.print("<div id=\"errName\"></div>");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"row mb-3 align-items-center\">");
		out.print("<div class=\"col-md-4 text-end\">");
		out.print("<label for=\"pass\" class=\"form-label\">Password</label>");
		out.print("</div>");
		out.print("<div class=\"col-md-6\">");
		out.print("<input type=\"password\" class=\"form-control\" name=\"txtUserPass\" id=\"pass\" onKeyup=\"checkValidLogin()\">");
		out.print("<div id=\"errPass\"></div>");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"row mb-3 align-items-center\">");
		out.print("<div class=\"col-md-8 offset-md-4 form-check-inline\">");
		out.print("<input type=\"checkbox\" class=\"form-check-input\" id=\"chkSave\">&nbsp;");
		out.print("<label class=\"form-check-label\" for=\"chkSave\">Save information in this PC?</label>");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"row mb-3 align-items-center\">");
		out.print("<div class=\"col-md-12 text-center\">");
		out.print("<a href=\"#\" class=\"text-decoration-none\"><i class=\"fa-solid fa-key\"></i> Forget password?</a>");
		out.print("&nbsp;&nbsp;|&nbsp;&nbsp;");
		out.print("<a href=\"#\" class=\"text-decoration-none\"><i class=\"fa-solid fa-circle-info\"></i> Help!</a>");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"row mb-3 align-items-center\">");
		out.print("<div class=\"col-md-12 text-center\">");
		out.print("<button type=\"button\" class=\"btn btn-primary\" onclick=\"login(this.form)\"><i class=\"fa-solid fa-arrow-right-to-bracket\"></i> Login</button>&nbsp;");
		out.print("<button type=\"button\" class=\"btn btn-primary\" onclick=\"window.close()\"><i class=\"fa-solid fa-arrow-right-from-bracket\"></i> Exit</button>");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"row align-items-center\">");
		out.print("<div class=\"col-md-12 text-center\">");
		out.print("<hr class=\"border border-1	 border-primary\">");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"row mb-3 pb-3 align-items-center\">");
		out.print("<div class=\"col-md-11 text-end\">");
		out.print("<a href=\"#\" class=\"text-decoration-none\"><i class=\"fa-solid fa-language\"></i> Vietnamese</a>");
		out.print("</div>");
		out.print("</div>");

		out.print("</form>");

		out.print("</div>");
		out.print("</div>");
		out.print("</div>");
		out.print("</div>");
		out.print("</body>");
		out.print("</html>");
		
		// Đóng luồng xuất
		out.close();
	}

	/**
	 * Phương thức thường được dùng để xử lý dữ liệu do doGet gửi tới <br>
	 * Được gọi bởi sự kiện của form, ví dụ: method="post"<br>
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
				
		//Lấy thông tin trên giao diện
		String username = request.getParameter("txtUserName");
		String userpass = request.getParameter("txtUserPass");
		
		
		//Kiểm tra sự chính xác của tham số trong form
		if(username!=null && userpass!=null) {
			
			//Kiểm tra sự tồn tại của giá trị
			if(!username.equalsIgnoreCase("") && !userpass.equalsIgnoreCase("")) {
				//Tham chiếu ngữ cảnh ứng dụng
				ServletContext application = getServletConfig().getServletContext();
				//ServletContext application = getServletContext();
				
				//Tìm bộ quản lý kết nối
				ConnectionPool cp = (ConnectionPool)application.getAttribute("CPool");
				
				//Tạo đối tượng thực thi
				UserControl uc = new UserControl(cp);
				if(cp==null) {
					application.setAttribute("CPool", uc.getCP());
				}
				
				//Xử lý dữ liệu
				username = username.trim();
				userpass = userpass.trim();
				
				//Đăng nhập
				UserObject user = uc.getUserObject(username, userpass);
				
				//Trả về kết nối
				uc.releaseConnection();
				
				//Kiểm tra kết quả và chuyển giao diện
				if(user!=null) {
					
					//Tham chiếu phiên làm việc (session)
					HttpSession session = request.getSession(true);
					
					//Đưa thông tin đăng nhập vào phiên
					session.setAttribute("userLogined", user);
					
					
					
					//Trở về giao diện chính
					response.sendRedirect("/adv/view");
				}else {
					response.sendRedirect("/adv/user/login?err=notok");
				}
				
				
			}else {
				response.sendRedirect("/adv/user/login?err=value");
			}
			
		}else {
			//Trở về giao diện để báo lỗi
			//doGet(request, response);
			
			response.sendRedirect("/adv/user/login?err=param");
		}
	}

}
