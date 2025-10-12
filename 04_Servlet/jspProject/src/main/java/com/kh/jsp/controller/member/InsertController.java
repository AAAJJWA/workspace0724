package com.kh.jsp.controller.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.kh.jsp.model.vo.Board;
import com.kh.jsp.model.vo.Member;
import com.kh.jsp.service.BoardService;
import com.kh.jsp.service.MemberService;

/**
 * Servlet implementation class InsertController
 */
@MultipartConfig(
		maxFileSize = 1024 * 1024 * 10,
		maxRequestSize = 1024 * 1024 * 50
)
@WebServlet(urlPatterns = {"/insert.me", "/insertBoard.bo"})
public class InsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String uri = request.getRequestURI();
		
		 if (uri.endsWith("insert.me")) {
	            insertMember(request, response);
	        } else if (uri.endsWith("insertBoard.bo")) {
	            insertBoard(request, response);
	        }
	    }
	
	private void insertMember(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String[] interestArr = request.getParameterValues("interest");
		
		String interest = "";
		if(interestArr != null) {
			interest = String.join(",", interestArr);
		}
		
		Member m = Member.insertCreateMember(userId, userPwd, userName, phone, email, address, interest);
		
		int result = new MemberService().insertMember(m);
		
		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "성공적으로 회원가입을 완료하였습니다");
			
			response.sendRedirect(request.getContextPath());
		} else {
			request.setAttribute("errorMsg", "회원가입에 실패하였습니다");
			request.getRequestDispatcher("views/common/error.jsp").forward(request, response);
		}
	}
	
	private void insertBoard(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		String savePath = request.getServletContext().getRealPath("/resources/uploadFiles/");
		
		java.io.File uploadDir = new java.io.File(savePath);
	    if (!uploadDir.exists()) uploadDir.mkdirs();
		
		int categoryNo = Integer.parseInt(request.getParameter("category"));
	    String title = request.getParameter("title");
	    String content = request.getParameter("content");

	    Member loginMember = (Member) request.getSession().getAttribute("loginMember");
	    int writerNo = (loginMember != null) ? loginMember.getMemberNo() : 1;

	    Board b = Board.createInsertBoard(categoryNo, title, content, writerNo);
	    
	    jakarta.servlet.http.Part filePart = request.getPart("upfile");
	    if (filePart != null && filePart.getSize() > 0) {
	    	
	    	String originName = filePart.getSubmittedFileName();
	    	
	    	String currentTime = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
	        String ext = originName.substring(originName.lastIndexOf("."));
	        String changeName = currentTime + ext;
	        
	        filePart.write(savePath + changeName);
	        
	        b.setOriginName(originName);
	        b.setChangeName(changeName);
	        b.setFilePath("/resources/uploadFiles/");
	    	
	    }
        
        int result = new BoardService().insertBoard(b);
        
        if (result > 0) {
            request.getSession().setAttribute("alertMsg", "게시글이 등록되었습니다.");
            response.sendRedirect(request.getContextPath() + "/list.bo");
        } else {
            request.setAttribute("errorMsg", "게시글 등록에 실패했습니다.");
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
