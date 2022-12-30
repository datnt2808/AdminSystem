package jsoft.ads.user.profiles;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Avatar
 */
@WebServlet("/user/profiles/avatar")
public class Avatar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String CONTENT_TYPE = "text/html; charset=utf-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Avatar() {
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

		out.print("<div class=\"col-xl-4\">");
		
		out.print("<div class=\"card\">");
		out.print("<div class=\"card-body profile-card pt-4 d-flex flex-column align-items-center\">");
		
		out.print("<img src=\"/adv/img/profile-img.jpg\" alt=\"Profile\" class=\"rounded-circle\">");
		out.print("<h2>Kevin Anderson</h2>");
		out.print("<h3>Web Designer</h3>");
		out.print("<div class=\"social-links mt-2\">");
		out.print("<a href=\"#\" class=\"twitter\"><i class=\"bi bi-twitter\"></i></a>");
		out.print("<a href=\"#\" class=\"facebook\"><i class=\"bi bi-facebook\"></i></a>");
		out.print("<a href=\"#\" class=\"instagram\"><i class=\"bi bi-instagram\"></i></a>");
		out.print("<a href=\"#\" class=\"linkedin\"><i class=\"bi bi-linkedin\"></i></a>");
		out.print("</div>");
		out.print("</div>");
		out.print("</div>");
		
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
