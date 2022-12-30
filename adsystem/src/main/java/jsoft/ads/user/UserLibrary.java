package jsoft.ads.user;

import jsoft.objects.*;
import java.util.*;

import jsoft.library.*;
public class UserLibrary {

	public static String viewUsers(ArrayList<UserObject> items, UserObject user) {
		String tmp ="";
		
		tmp += "<div class=\"card\">";
		tmp += "<div class=\"card-body\">";
		tmp += "<h5 class=\"card-title\">DANH SÁCH NGƯỜI SỬ DỤNG</h5>";
	
		tmp += "<table class=\"table table-striped table-sm\">";
		tmp += "<thead>";
		tmp += "<tr>";
		tmp += "<th scope=\"col\">ID</th>";
		tmp += "<th scope=\"col\">Ngày tạo</th>";
		tmp += "<th scope=\"col\">Tên đăng nhập</th>";
		tmp += "<th scope=\"col\">Tên đầy đủ</th>";
		tmp += "<th scope=\"col\">Hộp thư</th>";
		tmp += "<th scope=\"col\">Điện thoại</th>";
		tmp += "<th scope=\"col\">Lần đăng nhập</th>";
		tmp += "<th scope=\"col\" colspan=2 >Thực hiện</th>";
		tmp += "</tr>";
		tmp += "</thead>";
		tmp += "<tbody>";
		
		for(UserObject item: items) {
			tmp += "<tr>";
			tmp += "<th scope=\"row\">"+item.getUser_id()+"</th>";
			tmp += "<td>"+item.getUser_created_date()+"</td>";
			tmp += "<td>"+item.getUser_name()+"</td>";
			tmp += "<td>"+item.getUser_fullname()+"</td>";
			tmp += "<td>"+item.getUser_email()+"</td>";
			tmp += "<td>"+item.getUser_mobilephone()+"</td>";
			tmp += "<td>"+item.getUser_logined()+"</td>";
			tmp += "<td><a href=\"/adv/user/profiles?t=e&id="+item.getUser_id()+"\" class=\"btn btn-primary btn-sm\" ><i class=\"fa-solid fa-user-pen\"></i></a></td>";
			if(item.getUser_id()!= user.getUser_id()){
				tmp += "<td><a href=\"#\" class=\"btn btn-danger btn-sm\" data-bs-toggle=\"modal\" data-bs-target=\"#modal"+item.getUser_id()+"\" ><i class=\"fa-solid fa-trash-can\"></i></a></td>";
			}else {
				tmp += "<td><button class=\"btn btn-danger btn-sm\" disable ><i class=\"fa-solid fa-trash-can\"></i></button></td>";
			}
		
			tmp += "</tr>";
			tmp += UserLibrary.viewModal(item);
			
		}
		
		tmp += "</tbody>";
		tmp += "</table>";

		tmp += "</div>";
		tmp += "</div>";
		
		tmp += UserLibrary.viewChart(items);
		
		return tmp;
	}
	
	private static String viewModal(UserObject item) {
		
		
		String tmp = "";
		
		tmp += "<div class=\"modal fade\" id=\"modal"+item.getUser_id()+"\" tabindex=\"-1\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">";
		tmp += "<div class=\"modal-dialog\">";
		tmp += "<div class=\"modal-content\">";
		tmp += "<div class=\"modal-header\">";
		tmp += "<h1 class=\"modal-title fs-5\" id=\"exampleModalLabel\"><i class=\"fa-solid fa-triangle-exclamation\"></i> Xác nhận xóa</h1>";
		tmp += "<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>";
		tmp += "</div>";
		tmp += "<div class=\"modal-body\">";
		tmp += "Bạn có chắc chắn xóa Tài khoản: <b>"+item.getUser_fullname()+" ("+item.getUser_name()+")</b>";
		tmp += "</div>";
		tmp += "<div class=\"modal-footer\">";
		tmp += "<a href=\"/adv/user/del?id="+item.getUser_id()+"\" class=\"btn btn-danger\"><i class=\"fa-regular fa-trash-can\"></i> Xóa</a>";
		tmp += "<button type=\"button\" class=\"btn btn-secondary\" data-bs-dismiss=\"modal\"><i class=\"fa-solid fa-xmark\"></i> Hủy</button>";
		
		tmp += "</div>";
		tmp += "</div>";
		tmp += "</div>";
		tmp += "</div>";
		
		return tmp;
	}
	
	
	private static String viewChart(ArrayList<UserObject> items) {
		
		String title = "";
		String value = "";
		for(UserObject u: items) {
			title += "'"+Utilities.decodeFromHtml(u.getUser_fullname())+"("+Utilities.decodeFromHtml(u.getUser_name())+")',";
			value += u.getUser_logined()+ ",";
		}
		//Loại bỏ dấu phẩy ở cuối
		title = title.substring(0, title.length()-1);	
		value = value.substring(0, value.length()-1);
		
		String tmp ="";
		
		tmp += "<div class=\"card\">";
		tmp += "<div class=\"card-body\">";
		tmp += "<h5 class=\"card-title\">Biểu đồ đăng nhập</h5>";
		tmp += "";
		tmp += "<!-- Vertical Bar Chart -->";
		tmp += "<div id=\"verticalBarChart\" style=\"min-height: 400px;\" class=\"echart\"></div>";
		tmp += "";
		tmp += "<script>";
		tmp += "document.addEventListener(\"DOMContentLoaded\", () => {";
		tmp += "echarts.init(document.querySelector(\"#verticalBarChart\")).setOption({";
		tmp += "title: {";
		tmp += "text: 'SỐ lần đăng nhập',";
		tmp += "textStyple:{";
		tmp += "fontFamily: 'Open Sans',";
		tmp += "fontSize: 16,";
		tmp += "fontStyle: 'normal',";
		tmp += "fontWeight: 'bold'";
		tmp += "}";
		tmp += "},";
		tmp += "tooltip: {";
		tmp += "trigger: 'axis',";
		tmp += "axisPointer: {";
		tmp += "type: 'shadow'";
		tmp += "}";
		tmp += "},";
		tmp += "legend: {},";
		tmp += "grid: {";
		tmp += "left: '3%',";
		tmp += "right: '4%',";
		tmp += "bottom: '3%',";
		tmp += "containLabel: true";
		tmp += "},";
		tmp += "xAxis: {";
		tmp += "type: 'value',";
		tmp += "boundaryGap: [0, 0.01]";
		tmp += "},";
		tmp += "yAxis: {";
		tmp += "type: 'category',";
		tmp += "data: ['"+title+"]";
		tmp += "},";
		tmp += "series: [{";
		tmp += "name: 'Ẩn/hiện',";
		tmp += "type: 'bar',";
		tmp += "data: ["+value+"]";
		tmp += "}";
		tmp += "]";
		tmp += "});";
		tmp += "});";
		tmp += "</script>";
		tmp += "<!-- End Vertical Bar Chart -->";
		tmp += "";
		tmp += "</div>";
		tmp += "</div>";
		
		return tmp;
	}
	
	
	
}
