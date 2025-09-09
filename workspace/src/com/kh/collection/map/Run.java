package com.kh.collection.map;

import java.nio.channels.AsynchronousSocketChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.kh.collection.list.Human;

public class Run {
	
	/*
	 * Map
	 * key 와 value 를 쌍으로 저장하는 자료구조
	 * key 는 중복불가, value 는 중복가능
	 * HashMap(가장 보편적이고 속도향상), LinkedHashMap(입력순서보장), TreeMap(정렬된 key순서 유지)
	 * */

	public static void main(String[] args) {
		
		Map<Integer, Human> hMap = new HashMap<>();
		
		// 1. put() map 에 key, value 쌍으로 값을 추가
		hMap.put(10,  new Human("최지원", 20));
		hMap.put(20,  new Human("최지투", 30));
		hMap.put(30,  new Human("최지삼", 40));
		hMap.put(40,  new Human("최지사", 50));
		hMap.put(50,  new Human("최지오", 50));
		hMap.put(40,  new Human("최지육", 50)); // 동일한 key 사용시 값을 덮어씀
		System.out.println(hMap);	// 저장되는 순서 유지 안됨
		
		// 2. get(key) 해당 key의 value를 반환
		System.out.println(hMap.get(30));
		
		// 3. .size() 담겨있는 객체수
		System.out.println("size : " + hMap.size());
		
		// 4. remove(key) 해당 key 의 값을 찾아서 쌍으로 제거
		hMap.remove(40);
		System.out.println(hMap);
		
		// map 에 전체요소를 탐색하는 방법
		// Iterator 이용 x
		// for each 이용 x
		
		// 다른 자료구조로 변경 후 반복
		// 1. key 를 모아서 Set 자료구조 형태로 반환
		Set keySet = hMap.keySet();	// 모든 key를 Set에 담아서 반환
		System.out.println(keySet);
		for(Object key : keySet) {
			System.out.println("키 : " + key + " 값 : " + hMap.get(key));
		}
		
		// 2. entrySet 을 이용한 전체 탐색
		// Map 은 key와 value를 쌍으로 저장하기 때문에 keySet(), values()만으로는
		// 한번에 key와 값을 가져올 수 없음
		// Set<Map.Entry<K, V>>
		Set entrySet = hMap.entrySet();
		for(Object entry : entrySet ) {
			Entry = (Entry)entry;
			System.out.println(e.getKey() + " " + e.getValue());
		}
		
	}

}
