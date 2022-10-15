package ex01;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/member/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberDAO memberDAO;
	private MemberVO memberVO = null;
	
	public MemberController() {
		this.memberDAO = new MemberDAO();
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
		doGet(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String action = request.getPathInfo();
		
		if (action == null || action.equals("/listMembers.do")) {
			ArrayList<MemberVO> list = memberDAO.getMembersList();
			request.setAttribute("list", list);
			
			forwardReq(request, response, "/list.jsp");
		} else if (action.equals("/insert.do") && request.getMethod().equalsIgnoreCase("GET")) {
			request.setAttribute("date", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			
			forwardReq(request, response, "/insert.jsp");
		} else if (action.equals("/insert.do") && request.getMethod().equalsIgnoreCase("POST")) {
			memberVO = new MemberVO();
			memberVO.setEmail(request.getParameter("email"));
			memberVO.setName(request.getParameter("name"));
			memberVO.setPassword(request.getParameter("password"));
			memberVO.setRegdate(request.getParameter("regdate"));
			memberDAO.insertMember(memberVO);
			
			forwardReq(request, response, "/member");
		} else if (action.equals("/updateReq.do")) {
			memberVO = memberDAO.getMemberById(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("member", memberVO);
			
			forwardReq(request, response, "/update.jsp");
		} else if (action.equals("/update.do")) {
			memberVO = new MemberVO();
			memberVO.setId(Integer.parseInt(request.getParameter("id")));
			memberVO.setName(request.getParameter("name"));
			memberVO.setPassword(request.getParameter("password"));
			memberVO.setEmail(request.getParameter("email"));
			memberVO.setRegdate(request.getParameter("regdate"));
			memberDAO.updateMember(memberVO);
			
			forwardReq(request, response, "/member");
		} else if (action.equals("/delete.do")) {
			memberDAO.deleteMember(Integer.parseInt(request.getParameter("id")));
			forwardReq(request, response, "/member");
		}
	}
	
	protected void forwardReq(HttpServletRequest request, HttpServletResponse response, String nextPage) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
	}

}
