package jsoft.ads.article;

import java.sql.ResultSet;

import jsoft.objects.ArticleObject;

import jsoft.*;
import jsoft.ads.article.category.*;

public class ArticleImpl extends CategoryImpl implements Article {
	
	public ArticleImpl(ConnectionPool cp) {
		super("Article", cp);
	}

	@Override
	public boolean addArticle(ArticleObject item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editArticle(ArticleObject item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delArticle(ArticleObject item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResultSet getArticle(int id) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM tblarticle a ";
		sql += "LEFT JOIN tblcategory c ON a.article_category_id=c.category_id ";
		sql += "LEFT JOIN tblsection s ON c.category_section_id=s.section_id ";
		sql += "WHERE a.article_id=?";
		
		return this.get(sql, id);
	}

	@Override
	public ResultSet getArticles(ArticleObject similar, ArticleSort as, int at, byte total) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM tblarticle a ";
		sql += "LEFT JOIN tblcategory c ON a.article_category_id=c.category_id ";
		sql += "LEFT JOIN tblsection s ON c.category_section_id=s.section_id ";
		sql += "";
		switch(as) {
		case ID:
			sql += "ORDER BY article_id DESC ";
			break;
		case TITLE:
			sql += "ORDER BY article_title ASC ";
			break;
		case CATEGORY:
			sql += "ORDER BY article_category_id DESC ";
			break;
		case SECTION:
			sql += "ORDER BY article_section_id DESC ";
			break;
		case AUTHOR:
			sql += "ORDER BY article_author_name ASC ";
			break;
		case MANAGER:
			sql += "ORDER BY article_manager_id DESC ";
			break;
		case VISITED:
			sql += "ORDER BY article_visited DESC ";
			break;
		}
		sql += "LIMIT "+at+", "+total;
		
		return this.gets(sql);
	}

}
