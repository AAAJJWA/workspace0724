package com.kh.jsp.controller.board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.kh.jsp.model.vo.Board;
import com.kh.jsp.service.BoardService;

/**
 * Servlet implementation class DetailController
 */
@WebServlet("/detail.bo")
public class DetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int boardNo = Integer.parseInt(request.getParameter("bno"));
		
		Board b = new BoardService().selectBoard(boardNo);
		
		if (b != null) {
            request.setAttribute("board", b);
            request.getRequestDispatcher("views/board/detailView.jsp").forward(request, response);
        } else {
            request.setAttribute("errorMsg", "게시글 조회에 실패했습니다.");
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
