package jsoft.ads.article.section;

import jsoft.*;
import jsoft.objects.*;

import java.sql.*;
import java.util.*;

public class SectionModel {

	private Section s;

	public SectionModel(ConnectionPool cp) {
		this.s = new SectionImpl(cp);
	}

	protected void finalize() throws Throwable {
		this.s = null;
	}
	
	public ConnectionPool getCP() {
		return this.s.getCP();
	}
	
	public void releaseConnection() {
		this.s.releaseConnection();
	}

	// --------------------------------------------------------------
	public boolean addSection(SectionObject item) {
		return this.s.addSection(item);
	}

	public boolean editSection(SectionObject item) {
		return this.s.editSection(item);
	}

	public boolean delSection(SectionObject item) {
		return this.s.delSection(item);
	}

	// --------------------------------------------------------------
	public SectionObject getSectionObject(short id) {
		SectionObject item = null;

		ResultSet rs = this.s.getSection(id);
		if (rs != null) {
			try {
				if (rs.next()) {
					item = new SectionObject();
					item.setSection_id(rs.getShort("section_id"));
					item.setSection_name(rs.getString("section_name"));
					item.setSection_notes(rs.getString("section_notes"));
					item.setSection_created_date(rs.getString("section_created_date"));
					item.setSection_created_author_id(rs.getInt("section_created_author_id"));

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return item;
	}

	public ArrayList<SectionObject> getSectionObjects(SectionObject similar, SectionSort ss, short page, byte total) {

		ArrayList<SectionObject> items = new ArrayList<>();

		SectionObject item = null;

		int at = (page - 1) * total;
		ResultSet rs = this.s.getSections(similar, ss, at, total);
		if (rs != null) {
			try {
				while (rs.next()) {
					item = new SectionObject();
					item.setSection_id(rs.getShort("section_id"));
					item.setSection_name(rs.getString("section_name"));
					item.setSection_notes(rs.getString("section_notes") +"###"+rs.getString("user_name"));
					item.setSection_created_date(rs.getString("section_created_date"));
					item.setSection_created_author_id(rs.getInt("section_created_author_id"));

					items.add(item);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return items;
	}

	// --------------------------------------------------------------

}
