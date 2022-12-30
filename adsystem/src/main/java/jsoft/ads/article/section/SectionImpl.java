package jsoft.ads.article.section;

import java.sql.*;

import jsoft.*;
import jsoft.ads.basic.*;

import jsoft.objects.SectionObject;

public class SectionImpl extends BasicImpl implements Section {

	public SectionImpl(ConnectionPool cp) {
		super("Section", cp);
	}
	
	public SectionImpl(String objectName, ConnectionPool cp) {
		super(objectName, cp);
	}

	@Override
	public boolean addSection(SectionObject item) {
		// TODO Auto-generated method stub

		String sql = "INSERT INTO tblsection(";
		sql += "section_name, section_notes, section_created_date,";
		sql += "section_manager_id, section_enable, section_delete, ";
		sql += "section_last_modified, section_created_author_id, ";
		sql += "section_name_en, section_language) ";
		sql += "VALUES(?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			pre.setString(1, item.getSection_name());
			pre.setString(2, item.getSection_notes());
			pre.setString(3, item.getSection_created_date());
			pre.setInt(4, item.getSection_manager_id());
			pre.setBoolean(5, item.isSection_enable());
			pre.setBoolean(6, item.isSection_delete());
			pre.setString(7, item.getSection_last_modified());
			pre.setInt(8, item.getSection_created_author_id());
			pre.setString(9, item.getSection_name_en());
			pre.setByte(10, item.getSection_language());

			return this.add(pre);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean editSection(SectionObject item) {
		// TODO Auto-generated method stub

		String sql = "UPDATE tblsection SET ";
		sql += "section_name=?, section_notes=?, ";
		sql += "section_manager_id=?, section_enable=?, section_delete=?, ";
		sql += "section_last_modified=?,  ";
		sql += "section_name_en=?, section_language=? ";
		sql += "WHERE section_id=?";

		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			pre.setString(1, item.getSection_name());
			pre.setString(2, item.getSection_notes());

			pre.setInt(3, item.getSection_manager_id());
			pre.setBoolean(4, item.isSection_enable());
			pre.setBoolean(5, item.isSection_delete());
			pre.setString(6, item.getSection_last_modified());

			pre.setString(7, item.getSection_name_en());
			pre.setByte(8, item.getSection_language());

			pre.setShort(9, item.getSection_id());

			return this.edit(pre);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean delSection(SectionObject item) {
		// TODO Auto-generated method stub

		if (!this.isEmpty(item)) {
			return false;
		}

		String sql = "DELETE FROM tblsection WHERE section_id=?";

		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			pre.setShort(1, item.getSection_id());

			return this.del(pre);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	private boolean isEmpty(SectionObject item) {
		boolean flag = true;

		String sql1 = "SELECT article_id FROM tblarticle WHERE article_section_id=?";
		String sql2 = "SELECT category_id FROM tblcategory WHERE category_section_id=?";

		ResultSet rs1 = this.get(sql1, item.getSection_id());
		ResultSet rs2 = this.get(sql2, item.getSection_id());

		if (rs1 != null || rs2 != null) {
			try {
				if (rs1.next() || rs2.next()) {
					flag = false;
				}
				rs1.close();
				rs2.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return flag;
	}

	@Override
	public ResultSet getSection(short id) {
		// TODO Auto-generated method stub

		String sql = "SELECT * FROM tblsection WHERE section_id=?";
		return this.get(sql, id);
	}

	@Override
	public ResultSet getSections(SectionObject similar, int at, byte total) {
		// TODO Auto-generated method stub

		return this.getSections(similar, SectionSort.NAME, at, total);
	}

	@Override
	public ResultSet getSections(SectionObject similar, SectionSort ss, int at, byte total) {
		// TODO Auto-generated method stub

		String sql = "SELECT * FROM tblsection ";
		sql += "LEFT JOIN tbluser ON section_created_author_id=user_id ";
		sql += "";
		switch (ss) {
		case ID:
			sql += "ORDER BY section_id DESC ";
			break;
		case NAME:
			sql += "ORDER BY section_name ASC ";
			break;
		case DATE:
			sql += "ORDER BY section_created_date ASC ";

		}
		sql += "LIMIT " + at + ", " + total;

		return this.gets(sql);
	}
	
	
	public static void main(String[] args) {
		//Tạo đối tượng thực thi chức năng
		Section s = new SectionImpl(null);
		
		//Tạo đối tượng lưu trữ thôn tin mới
		SectionObject nSection = new SectionObject();
		nSection.setSection_name("Sản phẩm");
		nSection.setSection_created_author_id(20);
		nSection.setSection_created_date("16/10/2022");
		nSection.setSection_manager_id(23);
		nSection.setSection_notes("Chuyên mục lưu trữ  các bài viết về sản phẩm");
		
		boolean result = s.addSection(nSection);
		//Trả về kết nối
		s.releaseConnection();
		
		if(!result) {
			System.out.println("\n---------------------KHÔNG THÀNH CÔNG------------------------\n");
		}
		
		//Lấy danh sách chuyên mục và hiển thị
		ResultSet rs = s.getSections(nSection, SectionSort.ID, 0, (byte)20);
		String row;
		if(rs!=null) {
			try {
				while(rs.next()) {
					row = "ID: "+rs.getShort("section_id");
					row += "\tNAME: "+rs.getString("section_name");
					row += "\tNOTES: "+rs.getString("section_notes");
					
					System.out.println(row);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	

}
