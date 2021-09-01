package kingkoo.brd00;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("/board2/*")
public class BoardController extends HttpServlet {
	private static String ARTICLE_IMAGE_REPO = "C:\\board\\article_image";
	BoardService boardService;
	ArticleVO articleVO;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		boardService = new BoardService();
		articleVO = new ArticleVO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = "";
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		HttpSession session;
		String action = request.getPathInfo();
		System.out.println("action:" + action);
		try {
			List<ArticleVO> articlesList = new ArrayList<ArticleVO>();
			if (action == null) {
				articlesList = boardService.listArticles();
				request.setAttribute("articlesList", articlesList);
				nextPage = "/board01/listArticles.jsp";
			} else if (action.equals("/listArticles.do")) {
				articlesList = boardService.listArticles();
				request.setAttribute("articlesList", articlesList);
				nextPage = "/board01/listArticles.jsp";
			} else if (action.equals("/articleForm.do")) {
				nextPage = "/board01/articleForm.jsp";
			} else if (action.equals("/addArticle.do")) {
				int articleNO1=0;
				Map<String, String> articleMap = upload(request, response);
				String title1 = articleMap.get("title1");
				String content1 = articleMap.get("content1");
				String imageFileName1 = articleMap.get("imageFileName1");
				
				articleVO.setparentNO1(0);
				articleVO.setId("hong");
				articleVO.settitle1(title1);
				articleVO.setcontent1(content1);
				articleVO.setimageFileName1(imageFileName1);
				articleNO1= boardService.addArticle(articleVO);
				if(imageFileName1!=null && imageFileName1.length()!=0) {
				    File srcFile = new 	File(ARTICLE_IMAGE_REPO +"\\"+"temp"+"\\"+imageFileName1);
					File destDir = new File(ARTICLE_IMAGE_REPO +"\\"+articleNO1);
					destDir.mkdirs();
					FileUtils.moveFileToDirectory(srcFile, destDir, true);
					srcFile.delete();
				}
				PrintWriter pw = response.getWriter();
				pw.print("<script>" 
				         +"  alert('새글을 추가했습니다.');" 
						 +" location.href='"+request.getContextPath()+"/board2/listArticles.do';"
				         +"</script>");

				return;
			}else if(action.equals("/viewArticle.do")){
				String articleNO1 = request.getParameter("articleNO1");
				articleVO=boardService.viewArticle(Integer.parseInt(articleNO1));
				request.setAttribute("article",articleVO);
				nextPage = "/board01/viewArticle.jsp";
				
			}else if (action.equals("/modArticle.do")) {
				Map<String, String> articleMap = upload(request, response);
				int articleNO1 = Integer.parseInt(articleMap.get("articleNO1"));
				articleVO.setarticleNO1(articleNO1);
				String title1 = articleMap.get("title1");
				String content1 = articleMap.get("content1");
				String imageFileName1 = articleMap.get("imageFileName1");
				articleVO.setparentNO1(0);
				articleVO.setId("hong");
				articleVO.settitle1(title1);
				articleVO.setcontent1(content1);
				articleVO.setimageFileName1(imageFileName1);
				boardService.modArticle(articleVO);
				if (imageFileName1 != null && imageFileName1.length() != 0) {
					String originalFileName = articleMap.get("originalFileName");
					File srcFile = new File(ARTICLE_IMAGE_REPO + "\\" + "temp" + "\\" + imageFileName1);
					File destDir = new File(ARTICLE_IMAGE_REPO + "\\" + articleNO1);
					destDir.mkdirs();
					FileUtils.moveFileToDirectory(srcFile, destDir, true);
					
					File oldFile = new File(ARTICLE_IMAGE_REPO + "\\" + articleNO1 + "\\" + originalFileName);
					oldFile.delete();
				}
				PrintWriter pw = response.getWriter();
				pw.print("<script>" + "  alert('글을 수정했습니다.');" + " location.href='" + request.getContextPath()
						+ "/board2/viewArticle.do?articleNO1=" + articleNO1 + "';" + "</script>");
			} else if (action.equals("/removeArticle.do")) {
				int articleNO1 = Integer.parseInt(request.getParameter("articleNO1"));
				List<Integer> articleNO1List = boardService.removeArticle(articleNO1);
				for (int _articleNO1 : articleNO1List) {
					File imgDir = new File(ARTICLE_IMAGE_REPO + "\\" + _articleNO1);
					if (imgDir.exists()) {
						FileUtils.deleteDirectory(imgDir);
					}
				}

				PrintWriter pw = response.getWriter();
				pw.print("<script>" + "  alert('글을 삭제했습니다.');" + " location.href='" + request.getContextPath()
						+ "/board2/listArticles.do';" + "</script>");
				return;
			
			}else if (action.equals("/replyForm.do")) {
				int parentNO1 = Integer.parseInt(request.getParameter("parentNO1"));
				session = request.getSession();
				session.setAttribute("parentNO1", parentNO1);
				nextPage = "/board01/replyForm.jsp";
			} else if (action.equals("/addReply.do")) {
				session = request.getSession();
				int parentNO1 = (Integer) session.getAttribute("parentNO1");
				session.removeAttribute("parentNO1");
				Map<String, String> articleMap = upload(request, response);
				String title1 = articleMap.get("title1");
				String content1 = articleMap.get("content1");
				String imageFileName1 = articleMap.get("imageFileName1");
				articleVO.setparentNO1(parentNO1);
				articleVO.setId("lee");
				articleVO.settitle1(title1);
				articleVO.setcontent1(content1);
				articleVO.setimageFileName1(imageFileName1);
				int articleNO1 = boardService.addReply(articleVO);
				if (imageFileName1 != null && imageFileName1.length() != 0) {
					File srcFile = new File(ARTICLE_IMAGE_REPO + "\\" + "temp" + "\\" + imageFileName1);
					File destDir = new File(ARTICLE_IMAGE_REPO + "\\" + articleNO1);
					destDir.mkdirs();
					FileUtils.moveFileToDirectory(srcFile, destDir, true);
				}
				PrintWriter pw = response.getWriter();
				pw.print("<script>" + "  alert('답글을 추가했습니다.');" + " location.href='" + request.getContextPath()
						+ "/board2/viewArticle.do?articleNO1="+articleNO1+"';" + "</script>");
				return;
			
			}else {
				nextPage = "/board01/listArticles.jsp";
			}
			

			RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
			dispatch.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Map<String, String> upload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> articleMap = new HashMap<String, String>();
		String encoding = "utf-8";
		File currentDirPath = new File(ARTICLE_IMAGE_REPO);
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentDirPath);
		factory.setSizeThreshold(1024 * 1024);
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List items = upload.parseRequest(request);
			for (int i = 0; i < items.size(); i++) {
				FileItem fileItem = (FileItem) items.get(i);
				if (fileItem.isFormField()) {
					System.out.println(fileItem.getFieldName() + "=" + fileItem.getString(encoding));
					articleMap.put(fileItem.getFieldName(), fileItem.getString(encoding));
				} else {
					System.out.println("파라미터명:" + fileItem.getFieldName());
					//System.out.println("파일명:" + fileItem.getName());
					System.out.println("파일크기:" + fileItem.getSize() + "bytes");
					//articleMap.put(fileItem.getFieldName(), fileItem.getName());
					if (fileItem.getSize() > 0) {
						int idx = fileItem.getName().lastIndexOf("\\");
						if (idx == -1) {
							idx = fileItem.getName().lastIndexOf("/");
						}

						String fileName = fileItem.getName().substring(idx + 1);
						System.out.println("파일명:" + fileName);
						articleMap.put(fileItem.getFieldName(), fileName);  //익스플로러에서 업로드 파일의 경로 제거 후 map에 파일명 저장
						File uploadFile = new File(currentDirPath + "\\temp\\" + fileName);
						fileItem.write(uploadFile);

					} // end if
				} // end if
			} // end for
		} catch (Exception e) {
			e.printStackTrace();
		}
		return articleMap;
	}

}
