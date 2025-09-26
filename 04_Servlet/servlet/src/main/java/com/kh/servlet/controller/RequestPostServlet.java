package com.kh.servlet.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class RequestPostServlet
 */
@WebServlet("/posttest.dot")
public class RequestPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST 방식 같은 경우에도 동일하게 데이터를 사용하면 됨
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String name = request.getParameter("userName");				// 최지원 | ""
		String gender = request.getParameter("gender");				// M | F | NULL
		int age = Integer.parseInt(request.getParameter("age"));	// "55" -> 55 | ""
		String city = request.getParameter("city");					// "경기" | "서울" | "대구" 등...
		double height = Double.parseDouble(request.getParameter("height"));	// "180.0" -> 180.0
		
		// 체크박스와 같이 여러개의 값을 추출하고자 할 때
		String[] foods = request.getParameterValues("food");	// ["한식", "일식"] || null
		
		System.out.println("name : " + name);
		System.out.println("gender : " + gender);
		System.out.println("age : " + age);
		System.out.println("city : " + city);
		System.out.println("height : " + height);
		System.out.println("foods : " + String.join(", ", foods));
		
		// service > dao > db
		// 회원 추가에 대한 서비스 로직을 완료했다는 가정하에
		// 결과는 1 또는 0으로 반환
		
		// 위와 같은 결과에 따라 응답페이지(html)을 만들어서 응답
		// 즉, 여기 java코드내에 사용자가 보게 될 응답html을 작성
		
		// 응답 HTML 을 생성하는 과정을 JSP 템플릿 엔진에 위임
		// 단, 응답화면에서 필요로 하는 데이터를 잘 담아서 전달해줘야 한다
		// 데이터를 전달하기 위한 공간 -> request의 attribute영역
		// request,setAttribute("키", "값");
		
		request.setAttribute("name", name);
		request.setAttribute("gender", gender);
		request.setAttribute("age", age);
		request.setAttribute("city", city);
		request.setAttribute("height", height);
		request.setAttribute("foods", foods);
		
		// 현재 요청을 responsePage.jsp 로 전달
		// RequestDispatcher -> 서블릿에서 다른 리소스(jsp, 또다른 서블릿)로 요청을 전달(포워드) 하거나
		// 기존 응답에 내용을 추가할 수 있게 해주는 객ㅊ쳋
		RequestDispatcher view = request.getRequestDispatcher("/views/responsePage.jsp");
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST 요청이나 GET 요청에 대해서 동일하게 응답을 하겠다
		// GET과 POST를 정하기 이전에 특정 url 로 요청이 되었다는 것은 특정 기능을 수행하겠다는 의미
		// 결과가 같은 페이지를 출력, 응답하는 입장에서 다르게 코드를 작성할 이유가 없다
		doGet(request, response);
	}

}
