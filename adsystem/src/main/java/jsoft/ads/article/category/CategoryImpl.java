package jsoft.ads.article.category;

import java.sql.*;

import jsoft.objects.CategoryObject;
import jsoft.objects.SectionObject;
import jsoft.ads.article.section.*;
import jsoft.*;

public class CategoryImpl extends SectionImpl implements Category {

	public CategoryImpl(ConnectionPool cp) {
		super("Category", cp);
	}
	
	public CategoryImpl(String objectName, ConnectionPool cp) {
		super(objectName, cp);
	}

	@Override
	public boolean addCategory(CategoryObject item) {
		// TODO Auto-generated method stub

		String sql = "INSERT INTO tblcategory(";
		sql += "category_name, category_notes, category_created_date,";
		sql += "category_manager_id, category_enable, category_delete, ";
		sql += "category_last_modified, category_created_author_id, ";
		sql += "category_name_en, category_language, category_section_id) ";
		sql += "VALUES(?,?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			pre.setString(1, item.getCategory_name());
			pre.setString(2, item.getCategory_notes());
			pre.setString(3, item.getCategory_created_date());
			pre.setInt(4, item.getCategory_manager_id());
			pre.setBoolean(5, item.isCategory_enable());
			pre.setBoolean(6, item.isCategory_delete());
			pre.setString(7, item.getCategory_last_modified());
			pre.setInt(8, item.getCategory_created_author_id());
			pre.setString(9, item.getCategory_name_en());
			pre.setByte(10, item.getCategory_language());
			pre.setShort(11, item.getCategory_section_id());

			return this.add(pre);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean editCategory(CategoryObject item) {
		// TODO Auto-generated method stub
		String sql = "UPDATE tblcategory SET ";
		sql += "category_name=?, category_notes=?, ";
		sql += "category_manager_id=?, category_enable=?, category_delete=?, ";
		sql += "category_last_modified=?,  ";
		sql += "category_name_en=?, category_language=?, category_section_id=? ";
		sql += "WHERE category_id=?";

		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			pre.setString(1, item.getCategory_name());
			pre.setString(2, item.getCategory_notes());

			pre.setInt(3, item.getCategory_manager_id());
			pre.setBoolean(4, item.isCategory_enable());
			pre.setBoolean(5, item.isCategory_delete());
			pre.setString(6, item.getCategory_last_modified());

			pre.setString(7, item.getCategory_name_en());
			pre.setByte(8, item.getCategory_language());
			pre.setShort(9, item.getCategory_section_id());

			pre.setShort(10, item.getCategory_id());

			return this.edit(pre);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean delCategory(CategoryObject item) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean isEmpty(CategoryObject item) {
		boolean flag = true;

		String sql1 = "SELECT article_id FROM tblarticle WHERE article_category_id=?";
		ResultSet rs1 = this.get(sql1, item.getCategory_id());
		if (rs1 != null) {
			try {
				if (rs1.next()) {
					flag = false;
				}
				rs1.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return flag;
	}

	@Override
	public ResultSet getCategory(short id) {
		// TODO Auto-generated method stub

		String sql = "SELECT * FROM tblcategory ";
		sql += "LEFT JOIN tblsection ON category_section_id=section_id ";
		sql += "WHERE category_id=?";

		return this.get(sql, id);
	}

	@Override
	public ResultSet getCategories(CategoryObject similar, CategorySort cs, int at, byte total) {
		// TODO Auto-generated method stub

		String sql = "SELECT * FROM tblcategory c ";
		sql += "LEFT JOIN tblsection s ON c.category_section_id=s.section_id ";
		sql += "LEFT JOIN tbluser u ON c.category_created_author_id=u.user_id ";
		sql += "";
		switch (cs) {
		case ID:
			sql += "ORDER BY category_id DESC ";
			break;
		case NAME:
			sql += "ORDER BY category_name ASC ";
			break;
		case SECTION:
			sql += "ORDER BY category_section_id DESC ";
			break;
		case DATE:
			sql += "ORDER BY category_created_date ASC ";
			break;
		case MANAGER:
			sql += "ORDER BY category_manager_id DESC ";
			break;
		}
		sql += "LIMIT " + at + ", " + total;

		return this.gets(sql);
	}

}
