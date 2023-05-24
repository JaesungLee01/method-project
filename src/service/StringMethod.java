package service;

public class StringMethod {
	/*
	 ﻿2. 리턴타입 : 기본타입
		1) 매개변수 : 없음
		2) 매개변수 : 기본타입(byte, short, int, long, float, double, char, boolean)
		3) 매개변수 : String
		4) 매개변수 : 배열(기본타입 배열)
		5) 매개변수 : 배열(String 배열)
		6) 매개변수 : 클래스
		7) 매개변수 : 배열(클래스 배열)
		8) 매개변수 : ArrayList
		9) 매개변수 : HashMap
	 */
	
	// 1) 매개변수 : String
	// ① 어떤값을 입력 받을 것인가? 파일이르(확장자 포함)
	// ② 어떻게 처리(구현) 할 것인가? 파일이름을 입력하면 파일의 확장자만 추출하여 반환
	// ③ 어떤값을 반환 할 것인가? 확장자만 반환
	public String stringParam(String filename) {
		/*
		 "school.jpg" -> "jpg"
		 "보고서.hwp" -> "hwp"
		 "극장.영수증.pdf" -> "pdf"
		 test -> ""
		 */
		if(filename == null || filename.length() == 0) {
			
			return "파일이없습니다";
		}
		if(filename.lastIndexOf(".") == -1){
			return "";
		}
		
		
		String ext = filename.substring(filename.lastIndexOf(".")+1);
		
			return ext;
		
	}
	
}
