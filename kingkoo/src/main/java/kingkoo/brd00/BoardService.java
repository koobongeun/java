package kingkoo.brd00;

import java.util.List;

public class BoardService {
	BoardDAO boardDAO;

	public BoardService() {
		boardDAO = new BoardDAO();
	}

	public List<ArticleVO> listArticles() {
		List<ArticleVO> articlesList = boardDAO.selectAllArticles();
		return articlesList;
	}

	public int addArticle(ArticleVO article) {
		return boardDAO.insertNewArticle(article);
	}

	public ArticleVO viewArticle(int articleNO1) {
		ArticleVO article = null;
		article = boardDAO.selectArticle(articleNO1);
		return article;
	}

	public void modArticle(ArticleVO article) {
		boardDAO.updateArticle(article);
	}

	public List<Integer> removeArticle(int  articleNO1) {
		List<Integer> articleNO1List = boardDAO.selectRemovedArticles(articleNO1);
		boardDAO.deleteArticle(articleNO1);
		return articleNO1List;
	}
	
	public int addReply(ArticleVO article) {
		return boardDAO.insertNewArticle(article);
	}

}
