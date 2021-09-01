package kingkoo.brd00;

import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
	private DataSource dataFactory;
	Connection conn;
	PreparedStatement pstmt;

	public BoardDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<ArticleVO> selectAllArticles() {
		List<ArticleVO> articlesList = new ArrayList<ArticleVO>();
		try {
			conn = dataFactory.getConnection();
			String query = "SELECT LEVEL,articleNO1,parentNO1,title1,content1,id,writedate1" + " from t_board1"
					+ " START WITH  parentNO1=0" + " CONNECT BY PRIOR articleNO1=parentNO1"
					+ " ORDER SIBLINGS BY articleNO1 DESC";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int level = rs.getInt("level");
				int articleNO1 = rs.getInt("articleNO1");
				int parentNO1 = rs.getInt("parentNO1");
				String title1 = rs.getString("title1");
				String content1 = rs.getString("content1");
				String id = rs.getString("id");
				Date writedate1 = rs.getDate("writedate1");
				ArticleVO article = new ArticleVO();
				article.setLevel(level);
				article.setarticleNO1(articleNO1);
				article.setparentNO1(parentNO1);
				article.settitle1(title1);
				article.setcontent1(content1);
				article.setId(id);
				article.setWriteDate1(writedate1);
				articlesList.add(article);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return articlesList;
	}

	private int getNewarticleNO1() {
		try {
			conn = dataFactory.getConnection();
			String query = "SELECT  max(articleNO1) from t_board1 ";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery(query);
			if (rs.next())
				return (rs.getInt(1) + 1);
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int insertNewArticle(ArticleVO article) {
		int articleNO1 = getNewarticleNO1();
		try {
			conn = dataFactory.getConnection();
			int parentNO1 = article.getparentNO1();
			String title1 = article.gettitle1();
			String content1 = article.getcontent1();
			String id = article.getId();
			String imageFileName1 = article.getimageFileName1();
			String query = "INSERT INTO t_board1 (articleNO1, parentNO1, title1, content1, imageFileName1, id)"
					+ " VALUES (?, ? ,?, ?, ?, ?)";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, articleNO1);
			pstmt.setInt(2, parentNO1);
			pstmt.setString(3, title1);
			pstmt.setString(4, content1);
			pstmt.setString(5, imageFileName1);
			pstmt.setString(6, id);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return articleNO1;
	}

	public ArticleVO selectArticle(int articleNO1) {
		ArticleVO article = new ArticleVO();
		try {
			conn = dataFactory.getConnection();
			String query = "select articleNO1,parentNO1,title1,content1, NVL(imageFileName1, 'null') as imageFileName1, id, writedate1" + " from t_board1"
					+ " where articleNO1=?";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, articleNO1);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			int _articleNO1 = rs.getInt("articleNO1");
			int parentNO1 = rs.getInt("parentNO1");
			String title1 = rs.getString("title1");
			String content1 = rs.getString("content1");
			String imageFileName1 = URLEncoder.encode(rs.getString("imageFileName1"), "UTF-8"); //파일이름에 특수문자가 있을 경우 인코딩합니다.
			if(imageFileName1.equals("null")) {
				imageFileName1 = null;
			}
			
			String id = rs.getString("id");
			Date writedate1 = rs.getDate("writedate1");

			article.setarticleNO1(_articleNO1);
			article.setparentNO1(parentNO1);
			article.settitle1(title1);
			article.setcontent1(content1);
			article.setimageFileName1(imageFileName1);
			article.setId(id);
			article.setWriteDate1(writedate1);
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return article;
	}

	public void updateArticle(ArticleVO article) {
		int articleNO1 = article.getarticleNO1();
		String title1 = article.gettitle1();
		String content1 = article.getcontent1();
		String imageFileName1 = article.getimageFileName1();
		try {
			conn = dataFactory.getConnection();
			String query = "update t_board1  set title1=?,content1=?";
			if (imageFileName1 != null && imageFileName1.length() != 0) {
				query += ",imageFileName1=?";
			}
			query += " where articleNO1=?";

			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, title1);
			pstmt.setString(2, content1);
			if (imageFileName1 != null && imageFileName1.length() != 0) {
				pstmt.setString(3, imageFileName1);
				pstmt.setInt(4, articleNO1);
			} else {
				pstmt.setInt(3, articleNO1);
			}
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteArticle(int  articleNO1) {
		try {
			conn = dataFactory.getConnection();
			String query = "DELETE FROM t_board1 ";
			query += " WHERE articleNO1 in (";
			query += "  SELECT articleNO1 FROM  t_board1 ";
			query += " START WITH articleNO1 = ?";
			query += " CONNECT BY PRIOR  articleNO1 = parentNO1 )";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, articleNO1);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Integer> selectRemovedArticles(int  articleNO1) {
		List<Integer> articleNO1List = new ArrayList<Integer>();
		try {
			conn = dataFactory.getConnection();
			String query = "SELECT articleNO1 FROM  t_board1  ";
			query += " START WITH articleNO1 = ?";
			query += " CONNECT BY PRIOR  articleNO1 = parentNO1";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, articleNO1);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				articleNO1 = rs.getInt("articleNO1");
				articleNO1List.add(articleNO1);
			}
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return articleNO1List;
	}

}