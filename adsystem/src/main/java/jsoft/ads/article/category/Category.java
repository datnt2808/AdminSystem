package jsoft.ads.article.category;

import java.sql.*;
import jsoft.objects.*;

import jsoft.*;

public interface Category extends ShareControl {
	public boolean addCategory(CategoryObject item);
	public boolean editCategory(CategoryObject item);
	public boolean delCategory(CategoryObject item);
	
	public ResultSet getCategory(short id);
	public ResultSet getCategories(CategoryObject similar, CategorySort cs, int at, byte total);
}
