package com.kh.jsp.controller.member;

import java.io.IOException;

import com.kh.jsp.model.vo.Board;
import com.kh.jsp.model.vo.Member;
import com.kh.jsp.service.BoardService;
import com.kh.jsp.service.MemberService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class DeleteController
 */
@WebServlet(urlPatterns = {"/delete.me", "/deleteForm.bo"})
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();

        if (uri.endsWith("delete.me")) {
            deleteMember(request, response);
        } else if (uri.endsWith("deleteForm.bo")) {
            deleteBoard(request, response);
        }
	
	}

	private void deleteMember(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		String userPwd = request.getParameter("userPwd");
		
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		if(loginMember == null || !loginMember.getMemberPwd().equals(userPwd)) {
			request.setAttribute("errorMsg", "정상적인 접근이 아닙니다.");
			request.getRequestDispatcher("views/common/error.jsp").forward(request, response);
			return;
		}
		
		int result = new MemberService().deleteMember(loginMember.getMemberId());
		
		if(result == 0) { //업데이트 실패
			request.setAttribute("errorMsg", "회원탈퇴에 실패하였습니다");
			request.getRequestDispatcher("views/common/error.jsp").forward(request, response);
		} else {
			session.removeAttribute("loginMember");
			session.setAttribute("alertMsg", "성공적으로 탈퇴하였습니다.");
			
			response.sendRedirect(request.getContextPath());
		}
	}
	
	private void deleteBoard(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int boardNo = Integer.parseInt(request.getParameter("bno"));
        HttpSession session = request.getSession();
        
        Member loginMember = (Member) session.getAttribute("loginMember");

        if (loginMember == null) {
            request.setAttribute("errorMsg", "로그인 후 이용 가능합니다.");
            request.getRequestDispatcher("views/common/error.jsp").forward(request, response);
            return;
        }
        
        Board board = new BoardService().selectBoard(boardNo);
        
        if (loginMember.getMemberNo() != board.getBoardWriter()) {
            session.setAttribute("alertMsg", "작성자만 삭제할 수 있습니다.");
            response.sendRedirect(request.getContextPath() + "/detail.bo?bno=" + boardNo);
            return;
        }

        int result = new BoardService().deleteBoard(boardNo);

        if (result > 0) {
            session.setAttribute("alertMsg", "게시글이 성공적으로 삭제되었습니다.");
            response.sendRedirect(request.getContextPath() + "/list.bo");
        } else {
            request.setAttribute("errorMsg", "게시글 삭제에 실패했습니다.");
            request.getRequestDispatcher("views/common/error.jsp").forward(request, response);
        }
    }
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}