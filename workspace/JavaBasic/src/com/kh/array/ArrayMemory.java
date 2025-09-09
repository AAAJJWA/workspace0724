package com.kh.array;

public class ArrayMemory {

	public static void main(String[] args) {
//		int i = 10;
//		int[] iArr = new int[5];
//		
//		System.out.println(iArr.hashCode());
//		System.out.println(iArr);
		// 기본적으로 자바는 메모리의 주소를 확인할 수 없다
		// 객체 메모리 주소의 암호화된 해시값을 hashCode()로 가져올 수 있다
		
//		double[] dArr = new double[3];
//		System.out.println(dArr.hashCode());
		
		/*
		 * 실제 리터럴 값을 곧바로 담을 수 있는 변수를 일반변수
		 * 다른 메모리의 주소값을 담고 있는 변수를 참조변수 라고 함
		 * 
		 * 기본자료형(원시타입) : int, double, float, char, long...
		 * -> 실제 리터럴 값을 바로 담을 수 있음
		 * 
		 * 그 외 자료형(String, Scanner, int[], double[]...) -> 참조타입
		 * -> 필요한 메모리의 크기가 가변적이기 때문에 사용
		 * */
		
		// iArr 전체 출력
//		for(int num = 0; num < iArr.length; num++) {
//			System.out.print(iArr[num] + " ");
//		}
		
		// dArr 전체 출력(for-each)
//		for(double num : dArr) {
//			System.out.print(num + " ");
//		}
		
		// 배열 생성시 따로 초기화 하지 않아도 기본값이 담겨있음
		// Heap 이라는 메모리공간은 절대 빈공간을 허용하지 않기 때문
		// -> 메모리가 할당될 때 JVM 이 기본값으로 모두 초기화
		
//		System.out.println(iArr);
//		iArr = null;
//		System.out.println(iArr);
		
//		iArr.hashCode();
		
		// . : 접근 연산자
		// iArr.hashCode();
		// NullPointerException -> 참조변수가 가지고 있는 주소값이 없다
		
		int[] arr = new int[5];
		//System.out.println(arr[5]);
		// ArrayIndexOutOfBoundsException
		
		// 배열의 크기를 벗어난 index를 제시하면 발생하는 에러
		
		// 배열의 가장 큰 단점
		// 배열은 한번 지정하면 크기변경이 불가
		
		System.out.println(arr.hashCode());
		arr = new int[10];
		System.out.println(arr.hashCode());
		// 주소값이 변경된 걸 볼 수 있음 -> 수정이 불가하여 새로운 메모리 공간을 할당한다
		
		/*
		 * 연결이 끊어진 기존 배열의 메모리 공간은 Heap 영역에 남아있다(어떤 변수에도 참조되지 않는 상태)
		 * -> 일정 시간이 지나면 "GC (가비지컬렉터)" 가 알아서 회수한다
		 * -> 자바에서의 "자동메모리관리" 특징 -> 개발자는 코드에 집중할 수 있음
		 * */
		
		arr = null;
		// 배열을 더이상 사용하지 않을 때 null 을 대입하면 메모리를 반환
		
		int[] arr4 = {1, 1, 1, 1, 1};
		int[] arr5 = {1, 1, 1, 1, 1};
		
		System.out.println(arr4 == arr5);
		// false -> 각 참조변수는 == 통해서 비교시 주소값 비교를 하기 때문에
		
		arr4 = arr5;
		System.out.println(arr4 == arr5);
		
		arr4[0] = 100;
		arr5[1] = 200;

		for(int num : arr4) {
			System.out.print(num + " ");
		}
		
		System.out.println();
		
		for(int num : arr5) {
			System.out.print(num + " ");
		}
		
		
		
	}

}
