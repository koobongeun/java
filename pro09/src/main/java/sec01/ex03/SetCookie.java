package sec01.ex03;

import java.io.IOException;
import java.util.Date;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
/**
 * Servlet implementation class SetCookie
 */
@WebServlet("/set")
public class SetCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Date d = new Date();
		Cookie c = new Cookie("cookieTest", URLEncoder.encode("jsp프로그래밍입니다.", "utf-8"));
		
		//c.setMaxAge(24*60*60);
		c.setMaxAge(-1);
		response.addCookie(c);
		out.println("현재 시간 :"+d);
		out.println("문자열을 Cookie에 저장합니다.");
	}

}
