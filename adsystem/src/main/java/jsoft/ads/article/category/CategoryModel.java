package jsoft.ads.article.category;

import jsoft.*;

import jsoft.objects.*;

import java.sql.*;
import java.util.*;

public class CategoryModel {
	private Category c;

	public CategoryModel(ConnectionPool cp) {
		this.c = new CategoryImpl(cp);
	}

	protected void finalize() throws Throwable {
		this.c = null;
	}
	
	public ConnectionPool getCP() {
		return this.c.getCP();
	}
	
	public void releaseConnection() {
		this.c.releaseConnection();
	}

	// --------------------------------------------------------------
	public boolean addCategory(CategoryObject item) {
		return this.c.addCategory(item);
	}

	public boolean editCategory(CategoryObject item) {
		return this.c.editCategory(item);
	}

	public boolean delCategory(CategoryObject item) {
		return this.c.delCategory(item);
	}

	// --------------------------------------------------------------
	public CategoryObject getCategoryObject(short id) {
		CategoryObject item = null;

		ResultSet rs = this.c.getCategory(id);
		if (rs != null) {
			try {
				if (rs.next()) {
					item = new CategoryObject();
					item.setCategory_id(rs.getShort("category_id"));
					item.setCategory_name(rs.getString("category_name"));
					
					item.setSection_name(rs.getString("section_name"));
					item.setSection_id(rs.getShort("section_id"));
					
					item.setCategory_notes(rs.getString("category_notes"));
					item.setCategory_created_date(rs.getString("category_created_date"));
					item.setCategory_created_author_id(rs.getInt("category_created_author_id"));

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return item;
	}

	public ArrayList<CategoryObject> getCategoryObjects(CategoryObject similar, CategorySort cs, short page, byte total) {

		ArrayList<CategoryObject> items = new ArrayList<>();

		CategoryObject item = null;

		int at = (page - 1) * total;
		ResultSet rs = this.c.getCategories(similar, cs, at, total);
		if (rs != null) {
			try {
				while (rs.next()) {
					item = new CategoryObject();
					item.setCategory_id(rs.getShort("category_id"));
					item.setCategory_name(rs.getString("category_name"));
					item.setCategory_notes(rs.getString("category_notes")+"###"+rs.getString("user_name"));
					item.setCategory_created_date(rs.getString("category_created_date"));
					item.setCategory_created_author_id(rs.getInt("category_created_author_id"));
					
					item.setSection_name(rs.getString("section_name"));
					item.setSection_id(rs.getShort("section_id"));
					

					items.add(item);

				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return items;
	}
}
