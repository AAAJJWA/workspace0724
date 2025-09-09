package com.kh.example.exception1;

public class CharacterController {

	public CharacterController() {
		super();
	}
	
	public int countAlpha(String s) throws CharCheckException {
		
		if(s.contains(" "))
			throw new CharCheckException("체크할 문자열 안에 공백이 포함되어 있습니다.");
		
		int num = 0;
		
		for(int i=0; i<s.length(); i++) {
			if(Character.isUpperCase(s.charAt(i)) || Character.isLowerCase(s.charAt(i)))
				num++;
		}
		
		return num;
	}
	
}
