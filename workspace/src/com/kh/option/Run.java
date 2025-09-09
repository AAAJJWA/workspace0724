package com.kh.option;

import java.util.*;

/*
 * package
 * 클래스간의 공간적 충돌이나 접근방법의 충돌을 막기 위해
 * 저장위치를 구분하여 명확하게 접근 할 수 있도록 해주는 것
 * 
 * 네이밍방식
 * 도메인 : www.kh.com 이라는 가정하에
 * 패키지 : com.kh.팀명(또는 프로젝트명)
 * 
 * static
 * static 변수와 static 메서드는 정적메모리에 저장된다
 * 프로그램 실행 시점에 메모리가 생성되며, 객체생성 없이도 접근이 가능하다
 * 모든 객체가 공유하여 사용한다
 * 
 * static 변수
 * 클래스에 소속된 모든 인스턴스가 공유하는 변수, 한 클래스에서 공통적인 값을 유지해야 할 때 사용
 * 객체생성 없이 클래스명.변수명 형태로 접근이 가능하며, 일반적으로 final 과 함께 많이 사용된다
 * 
 * static 메서드
 * 인스턴스 변수 없이 클래스 단위로 호출할 수 있는 메서드, 객체상태와 무관하게 동작하는 반복적인 기능 구현시 유용
 * 단, 인스턴스 변수나 인스턴스 메서드에 직접 접근불가 -> this 키워드 사용 X
 * 
 * */

public class Run {

	public static void main(String[] args) {
				
		Counter c1 = new Counter("첫번째객체");
		Counter c2 = new Counter("두번째객체");
		
		Counter.showCount();
		
		c1.showCount();
	}

}
