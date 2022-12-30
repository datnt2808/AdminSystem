package jsoft.ads.article.category;

import jsoft.*;
import jsoft.objects.*;
import java.util.*;

public class CategoryControl {
	private CategoryModel cm;

	public CategoryControl(ConnectionPool cp) {
		this.cm = new CategoryModel(cp);
	}

	protected void finalize() throws Throwable {
		this.cm = null;
	}
	
	public ConnectionPool getCP() {
		return this.cm.getCP();
	}
	
	public void releaseConnection() {
		this.cm.releaseConnection();
	}

	// ---------------------------------------------------------------
	public boolean addCategory(CategoryObject item) {
		return this.cm.addCategory(item);
	}

	public boolean editCategory(CategoryObject item) {
		return this.cm.editCategory(item);
	}

	public boolean delCategory(CategoryObject item) {
		return this.cm.delCategory(item);
	}

	// ---------------------------------------------------------------
	public CategoryObject getCategoryObject(short id) {
		return this.cm.getCategoryObject(id);
	}
	
	public String viewCategories(CategoryObject similar, CategorySort cs, short page, byte total) {
		//Lấy danh sách đối tượng
		ArrayList<CategoryObject> items = this.cm.getCategoryObjects(similar, cs, page, total);
		
		return CategoryLibrary.viewCategories(items);
	}
	
	
	public static void main(String[] args) {
		CategoryControl cc = new CategoryControl(null);
		
		String view = cc.viewCategories(null, CategorySort.NAME, (short)1, (byte)10);
		
		System.out.print(view);
	}
	
	
	
}
