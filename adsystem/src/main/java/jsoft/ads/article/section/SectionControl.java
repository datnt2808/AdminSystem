package jsoft.ads.article.section;

import jsoft.*;
import jsoft.objects.*;
import java.util.*;

public class SectionControl {
	private SectionModel sm;

	public SectionControl(ConnectionPool cp) {
		this.sm = new SectionModel(cp);
	}

	protected void finalize() throws Throwable {
		this.sm = null;
	}
	
	public ConnectionPool getCP() {
		return this.sm.getCP();
	}
	
	public void releaseConnection() {
		this.sm.releaseConnection();
	}

	// ---------------------------------------------------------------
	public boolean addSection(SectionObject item) {
		return this.sm.addSection(item);
	}

	public boolean editSection(SectionObject item) {
		return this.sm.editSection(item);
	}

	public boolean delSection(SectionObject item) {
		return this.sm.delSection(item);
	}

	// ---------------------------------------------------------------
	public SectionObject getSectionObject(short id) {
		return this.sm.getSectionObject(id);
	}
	
	public String viewSections(SectionObject similar, SectionSort ss, short page, byte total) {
		//Lấy danh sách đối tượng
		ArrayList<SectionObject> items = this.sm.getSectionObjects(similar, ss, page, total);
		
		return SectionLibrary.viewSections(items);
	}
	
	
	public static void main(String[] args) {
		SectionControl sc = new SectionControl(null);
		
		String view = sc.viewSections(null, SectionSort.NAME, (short)1, (byte)10);
		
		System.out.print(view);
	}
	
	
	
}
