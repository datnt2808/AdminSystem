package jsoft.ads.article.section;

import java.util.*;
import jsoft.objects.*;
import jsoft.library.*;

public class SectionLibrary {
	public static String viewSections(ArrayList<SectionObject> items) {
		String tmp = "";

		tmp += "<div class=\"card\">";
		tmp += "<div class=\"card-body\">";
		tmp += "<h5 class=\"card-title\">DANH SÁCH CHUYÊN MỤC</h5>";

		tmp += "<table class=\"table table-striped\">";
		tmp += "<thead>";
		tmp += "<tr>";
		tmp += "<th scope=\"col\">ID</th>";
		tmp += "<th scope=\"col\">Ngày tạo</th>";
		tmp += "<th scope=\"col\">Tên chuyên mục</th>";
		tmp += "<th scope=\"col\">Người tạo</th>";
		tmp += "<th scope=\"col\">Mô tả</th>";
		tmp += "<th scope=\"col\" colspan=2 >Thực hiện</th>";
		tmp += "</tr>";
		tmp += "</thead>";
		tmp += "<tbody>";

		for (SectionObject item : items) {
			tmp += "<tr>";
			tmp += "<th scope=\"row\">" + item.getSection_id() + "</th>";
			tmp += "<td>" + item.getSection_created_date() + "</td>";
			tmp += "<td>" + item.getSection_name() + "</td>";
			tmp += "<td>" + Utilities.getInfo(item.getSection_notes(), (byte)1) + "</td>";
			tmp += "<td>" + Utilities.getInfo(item.getSection_notes(), (byte)0) + "</td>";
			tmp += "<td><a href=\"#\" class=\"btn btn-primary btn-sm\" ><i class=\"fa-solid fa-user-pen\"></i></a></td>";
			tmp += "<td><a href=\"#\" class=\"btn btn-danger btn-sm\" ><i class=\"fa-solid fa-trash-can\"></i></a></td>";
			tmp += "</tr>";
		}

		tmp += "</tbody>";
		tmp += "</table>";

		tmp += "</div>";
		tmp += "</div>";

		return tmp;
	}


}
