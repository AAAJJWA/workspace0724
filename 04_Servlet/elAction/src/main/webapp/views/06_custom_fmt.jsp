<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>1. fmt:formatNumber</h3>
	<p>
		숫자 데이터의 표시형식을 지정한다 <br>
		(fmt:formatNumber value="출력할 값" 
			[
				groupingUsed="true | false"		<!-- 천 단위 구분자(,) 사용여부 -->
				type="number|percent|currency"	<!-- 출력형식 -->
				currencySymbol="문자"				<!-- type=currency일 경우 통화기호를 강제로 지정 -->
				currencyCode="통화"				<!-- 통화문자대신 통화코드기반 포맷 : KRW, UDS, JPY 등 -->
			]
		)
	</p>
	<c:set value="num1" value="123456789" />
	<c:set value="num2" value="0.75" />
	<c:set value="num3" value="50000" />
	
	출력 : ${num1} <br>
	세 자리 구분 출력 : <fmt:formatNumber value="${num1}" /> <br>
	세 자리 구분 없이 : <fmt:formatNumber value="${num1}" groupingUsed="false" /> <br>
	
	퍼센트(기본) : <fmt:formatNumber value="${num2}" type="percent" /> <br>
	퍼센트(소수 1자리 고정) : <fmt:formatNumber value="${num2}" type="percent" minFractionDigits="1" /> <br>
	
	통화 : <fmt:formatNumber value="${num3}" type="currency" currencySymbol="$" /> <br>
	통화 : <fmt:formatNumber value="${num3}" type="currency" currencyCode="KRW" /> <br>
	
	<h3>2. formatDate</h3>
	<p>날짜 및 시간데이터의 포맷지정(단, java.util.Date 객체 사용) </p>
	
	<c:set var="current" value="<%=new java.util.Date() %>" />
	출력 : ${current}
	
	<ul>
		<li>현재 날짜 : <fmt:formatDate value="${currnet}" type="date" /> </li>
		<li>현재 시간 : <fmt:formatDate value="${currnet}" type="time" /> </li>
		<li>현재 둘다 : <fmt:formatDate value="${currnet}" type="both" /> </li>
		<li>medium : <fmt:formatDate value="${currnet}" type="both" dateStyle="medium" timestyle="medium" /> </li>
		<li>long : <fmt:formatDate value="${currnet}" type="both" dateStyle="long" timestyle="long" /> </li>
		<li>short : <fmt:formatDate value="${currnet}" type="both" dateStyle="short" timestyle="short" /> </li>
		<li>full : <fmt:formatDate value="${currnet}" type="both" dateStyle="full" timestyle="full" /> </li>
		<li>pattern : <fmt:formatDate value="${currnet}" type="both" pattern="yyyy년 MM월 dd일 E요일 a HH:MM:SS" /> </li>
		<!-- 
			parttern :  yyyy-MM-DD(E) a HH:MM:SS
						yyyy년 MM월 dd일 E요일 a HH:MM:SS
			
		 -->
		
	</ul>
	
</body>
</html>