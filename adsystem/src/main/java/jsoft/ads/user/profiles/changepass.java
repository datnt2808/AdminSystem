package jsoft.ads.user.profiles;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChangePass
 */
@WebServlet("/user/profiles/changepass")
public class changepass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String CONTENT_TYPE = "text/html; charset=utf-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public changepass() {
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

		//Xác định tab để mở
		String tab = request.getParameter("t");
		String show = "";
		if(tab!=null && tab.equalsIgnoreCase("c")) {
			show = "show active";
		}
		
		out.print("<div class=\"tab-pane fade "+show+" pt-3\" id=\"profile-change-password\">");
		out.print("<!-- Change Password Form -->");
		out.print("<form>");

		out.print("<div class=\"row mb-3\">");
		out.print("<label for=\"currentPassword\" class=\"col-md-4 col-lg-3 col-form-label\">Current Password</label>");
		out.print("<div class=\"col-md-8 col-lg-9\">");
		out.print("<input name=\"password\" type=\"password\" class=\"form-control\" id=\"currentPassword\">");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"row mb-3\">");
		out.print("<label for=\"newPassword\" class=\"col-md-4 col-lg-3 col-form-label\">New Password</label>");
		out.print("<div class=\"col-md-8 col-lg-9\">");
		out.print("<input name=\"newpassword\" type=\"password\" class=\"form-control\" id=\"newPassword\">");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"row mb-3\">");
		out.print(
				"<label for=\"renewPassword\" class=\"col-md-4 col-lg-3 col-form-label\">Re-enter New Password</label>");
		out.print("<div class=\"col-md-8 col-lg-9\">");
		out.print("<input name=\"renewpassword\" type=\"password\" class=\"form-control\" id=\"renewPassword\">");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"text-center\">");
		out.print("<button type=\"submit\" class=\"btn btn-primary\">Change Password</button>");
		out.print("</div>");
		out.print("</form><!-- End Change Password Form -->");

		out.print("</div>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
