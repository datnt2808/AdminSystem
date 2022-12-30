package jsoft.ads.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;

/**
 * Servlet implementation class header
 */
@WebServlet("/menu")
public class menu extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public menu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType(CONTENT_TYPE);

		// Tạo đối tượng xuất nội dung (html) về trình khách
		PrintWriter out = response.getWriter();
		
		//Xác định vị trí của menu
		String pos = request.getRequestURI();
		
		//Khai báo collapsed lưu trữ vị trí menu cấp 1
		HashMap<String, String> collapsed = new HashMap<>();
		
		//Menu cấp 2
		HashMap<String, String> show = new HashMap<>();
		HashMap<String, String> active = new HashMap<>();
		
		if(pos.contains("user")) {
			collapsed.put("user", "");
			show.put("user", "show");
			if(pos.contains("profiles")) {
				active.put("p", " class=\"active\" ");
			}else if(pos.contains("add")) {
				active.put("add", " class=\"active\" ");
			}else {
				active.put("view", " class=\"active\" ");
			}
			
		}else if(pos.contains("section")){
			collapsed.put("secion", "");
		}else {
			collapsed.put("home", "");
		}
		
		
		out.print("<!-- ======= Sidebar ======= -->");
		out.print("<aside id=\"sidebar\" class=\"sidebar\">");

		out.print("<ul class=\"sidebar-nav\" id=\"sidebar-nav\">");

		out.print("<li class=\"nav-item\">");
		out.print("<a class=\"nav-link "+collapsed.getOrDefault("home","collapsed")+"\" href=\"/adv/view\">");
		out.print("<i class=\"bi bi-grid\"></i>");
		out.print("<span>Dashboard</span>");
		out.print("</a>");
		out.print("</li><!-- End Dashboard Nav -->");

		out.print("<li class=\"nav-item\">");
		out.print("<a class=\"nav-link "+collapsed.getOrDefault("user", "collapsed")+"\" data-bs-target=\"#user-nav\" data-bs-toggle=\"collapse\" href=\"#\">");
		out.print("<i class=\"fa-solid fa-user-group\"></i><span>User management</span><i class=\"bi bi-chevron-down ms-auto\"></i>");
		out.print("</a>");
		out.print("<ul id=\"user-nav\" class=\"nav-content collapse "+show.getOrDefault("user", "")+" \" data-bs-parent=\"#sidebar-nav\">");
		out.print("<li>");
		out.print("<a href=\"/adv/user/view\"  "+active.getOrDefault("view", "")+">");
		out.print("<i class=\"fa-solid fa-user\"></i><span>User accounts</span>");
		out.print("</a>");
		out.print("</li>");
		
		out.print("<li>");
		out.print("<a href=\"/adv/user/add\"  "+active.getOrDefault("add", "")+">");
		out.print("<i class=\"fa-solid fa-user-plus\"></i><span>Add user</span>");
		out.print("</a>");
		out.print("</li>");
		
		out.print("<li>");
		out.print("<a href=\"/adv/user/profiles\"  "+active.getOrDefault("p", "")+">");
		out.print("<i class=\"fa-solid fa-user-plus\"></i><span>Update</span>");
		out.print("</a>");
		out.print("</li>");
		
		out.print("<li>");
		out.print("<a href=\"/adv/user/trash\"  "+active.getOrDefault("trash", "")+">");
		out.print("<i class=\"fa-solid fa-trash-can\"></i><span>Trash</span>");
		out.print("</a>");
		out.print("</li>");
		
		out.print("</ul>");
		out.print("</li><!-- End User Nav -->");

		out.print("<li class=\"nav-item\">");
		out.print("<a class=\"nav-link "+collapsed.getOrDefault("section", "collapsed")+"\" data-bs-target=\"#section-nav\" data-bs-toggle=\"collapse\" href=\"#\">");
		out.print("<i class=\"bi bi-journal-text\"></i><span>Section management</span><i class=\"bi bi-chevron-down ms-auto\"></i>");
		out.print("</a>");
		out.print("<ul id=\"section-nav\" class=\"nav-content collapse \" data-bs-parent=\"#sidebar-nav\">");
		out.print("<li>");
		out.print("<a href=\"/adv/section/view\">");
		out.print("<i class=\"bi bi-circle\"></i><span>Section list</span>");
		out.print("</a>");
		out.print("</li>");
		
		out.print("<li>");
		out.print("<a href=\"/adv/section/add\">");
		out.print("<i class=\"bi bi-circle\"></i><span>Add section</span>");
		out.print("</a>");
		out.print("</li>");
		
		out.print("<li>");
		out.print("<a href=\"/adv/section/catelist\">");
		out.print("<i class=\"bi bi-circle\"></i><span>Category list of Section</span>");
		out.print("</a>");
		out.print("</li>");
		
		out.print("<li>");
		out.print("<a href=\"/adv/section/trash\">");
		out.print("<i class=\"bi bi-circle\"></i><span>Trash</span>");
		out.print("</a>");
		out.print("</li>");
		out.print("</ul>");
		out.print("</li><!-- End Section Nav -->");

		out.print("<li class=\"nav-item\">");
		out.print(
				"<a class=\"nav-link collapsed\" data-bs-target=\"#tables-nav\" data-bs-toggle=\"collapse\" href=\"#\">");
		out.print(
				"<i class=\"bi bi-layout-text-window-reverse\"></i><span>Tables</span><i class=\"bi bi-chevron-down ms-auto\"></i>");
		out.print("</a>");
		out.print("<ul id=\"tables-nav\" class=\"nav-content collapse \" data-bs-parent=\"#sidebar-nav\">");
		out.print("<li>");
		out.print("<a href=\"tables-general.html\">");
		out.print("<i class=\"bi bi-circle\"></i><span>General Tables</span>");
		out.print("</a>");
		out.print("</li>");
		out.print("<li>");
		out.print("<a href=\"tables-data.html\">");
		out.print("<i class=\"bi bi-circle\"></i><span>Data Tables</span>");
		out.print("</a>");
		out.print("</li>");
		out.print("</ul>");
		out.print("</li><!-- End Tables Nav -->");

		out.print("<li class=\"nav-heading\">Pages</li>");

		
		out.print("<li class=\"nav-item\">");
		out.print("<a class=\"nav-link \" href=\"pages-blank.html\">");
		out.print("<i class=\"bi bi-file-earmark\"></i>");
		out.print("<span>Blank</span>");
		out.print("</a>");
		out.print("</li><!-- End Blank Page Nav -->");

		out.print("</ul>");

		out.print("</aside><!-- End Sidebar-->");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
