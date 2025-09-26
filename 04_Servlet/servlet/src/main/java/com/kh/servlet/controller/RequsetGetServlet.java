package com.kh.servlet.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @WebServlet 어노테이션을 통해 해당 객체가 서블릿이며
 * 		/gettest.do로 요청을 받으면 실행해줄 servlet 이라는 맵핑을 진행함
 * 
 * http://localhost:8001/servlet/gettest.do 로 요청시 응답하는 서블릿
 * servlet 의 요청경로는 contextPath 뒤에 작성된다
 */
@WebServlet("/gettest.do")
public class RequsetGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequsetGetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get 방식으로 요청시 doGet메서드를 실행하여 요청을 처리해 준다(톰캣이 서블릿객체를 생성해서 메서드 호출까지 해줌)
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("서블릿 응답 완료");
		
		/*
		 * HttpServletRequest -> 요청시 전달된 내용들이 담겨있는 객체(사용자가 입력한 값, 요청방식, 요청자의 ip, url 등..)
		 * HttpServletResponse -> 요청을 처리 후 응답할 때 사용되는 객체(어떤 타입으로 응답할지, 어떤값을 응답할지 등을 설정)
		 * 
		 * 요청 처리를 위해서 요청시 전달된 값을 추출
		 * request의 parameter영역안에 전달된 값을 추출
		 * request.getParameter("키");
		 * */
		// userName=최지원&age=55&gender&=M&city=경기&height=188&food=한식&food=일식
		
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
		
		// response 객체를 통해서 응답
		
		// 1) 응답으로 출력할 내용은 html 이고 문자셋은 utf-8 이다 -> 선언
		response.setContentType("text/html; charset=utf-8");
		
		// 2) 응답받는 사용자와의 스트림을 연결
		PrintWriter out = response.getWriter();
		
		System.out.println("<html>");
		System.out.println("<head>");
		System.out.println("</head>");
		
		System.out.println("<body>");
		System.out.println("<h2>개인정보 응답화면</h2>");
		System.out.printf("<span>%s님은</span>", name);
		System.out.printf("<span>%d살이며</span>", age);
		System.out.printf("<span>%s에 살고 있습니다</span>", city);
		System.out.println("성별은 ");
		if(gender == null) {
			out.println("미입력 상태입니다");
		} else if(gender.equals("M")) {
			out.println("남자입니다");
		} else {
			out.println("여자입니다");
		}
		out.println("</body>");
		out.println("</html>");
		/*
		 * <html>
		 *  <head></head>
		 *  <body>
		 *  	<h2>개인정보 응답화면</h2>
		 *  	<span>최지원님은</span>
		 *  	<span>55살이며</span>
		 *  	<span>경기도에 살고 있습니다</span>
		 *  </body>
		 * */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
