package ex02;

import java.io.IOException;
import java.util.HashMap;

import ex01.MemberDAO;
import ex01.MemberVO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login/*")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberDAO memberDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
    	memberDAO = new MemberDAO();
    }

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
		// TODO Auto-generated method stub
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String action = request.getPathInfo();
		
		if (action.equals("/login.do") && request.getMethod().equalsIgnoreCase("GET")) {
			forwardReq(request, response, "/login.jsp");
		} else if (action.equals("/login.do") && request.getMethod().equalsIgnoreCase("POST")) {
			processLogin(request, response);
		}
	}
	
	protected void forwardReq(HttpServletRequest request, HttpServletResponse response, String nextPage) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
	}
	
	protected void processLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HashMap<String, Boolean> errors = new HashMap<>();
		String email = request.getParameter("email"), password = request.getParameter("password");
		
		if (email == null || email.isEmpty())
			errors.put("email", true);
		if (password == null || password.isEmpty())
			errors.put("password", true);
		
		if (!errors.isEmpty()) {
			request.setAttribute("errors", errors);
			forwardReq(request, response, "/login.jsp");
			return;
		}
		
		MemberVO member = memberDAO.getMemberByEmail(email);
		// member == null 부분은 강의 시간에 한 내용이 아님
		if (member == null || !password.equals(member.getPassword())) {
			System.out.println("mispatch");
			errors.put("mispatch", true);
			request.setAttribute("errors", errors);
			forwardReq(request, response, "/login.jsp");
			return;
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("member", member);
		forwardReq(request, response, "/index.jsp");
	}
}
