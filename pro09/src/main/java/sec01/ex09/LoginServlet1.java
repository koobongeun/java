package sec01.ex09;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet1
 */
@WebServlet("/login1")
public class LoginServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String user_id = request.getParameter("user_id");
		String user_pwd = request.getParameter("user_pwd");
		MemberVO memberVO = new MemberVO();
		memberVO.setId(user_id);
		memberVO.setPwd(user_pwd);
		MemberDAO dao = new MemberDAO();
		boolean result = dao.isExisted(memberVO);
		if (result) {
			HttpSession session = request.getSession();
			session.setAttribute("isLogon", true);
			session.setAttribute("login.id", user_id);
			session.setAttribute("login.pwd", user_pwd);
			out.print("<html><body>");
			out.print("안녕하세요"+user_id+"님!!!<br>");
			out.print("<a href = 'show'>회원정보 보기</a>");
			out.print("</body></html>");
		}else {
			out.print("<html><body><center>회원아이디가 틀렸습니다.");
			out.print("<a href = 'login3.html'>다시 로그인하기</a>");
			out.print("</body></html>");
		}
		
//		out.print("<html><body>");
//		out.print("<table border = '1'> <tr align='center' bgcolor = 'lightgreen'>");
//		out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td></tr>");
//		List<MemberVO> list = dao.listMembers();
//		for (int i = 0; i<list.size(); i++)
//		{
//			String id = memberVO.getId();
//			String pwd = memberVO.getPwd();
//			String name = memberVO.getName();
//			String email = memberVO.getEmail();
//			Date joinDate = memberVO.getJoinDate();
//			out.print("<tr><td>"+id+"</td><td>"+pwd+"</td><td>"+name+"</td><td>"+email+"</td><td>"+joinDate+"</td></tr>");
//		}
//		out.print("</table></body></html>");
		
	}

}
