package service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import Vo.*;

public class PrimitiveMethod {
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
	
	// 1) 매개변수 : 없음
	// ① 어떤값을 입력 받을 것인가? void
	// ② 어떻게 처리(구현) 할 것인가? 0 ~ int최대값 중에 하나를 리턴
	// ③ 어떤값을 반환 할 것인가? int
	public int voidParam() {
		// 최소값 0, 최대값 int타입의 최대값 Integer랩퍼타입이용
		double rNum = Math.random(); // 0.0000000000xx ~ 0.99999999xxx
		long intMax = (long)Integer.MAX_VALUE+1;
		int returnValue = (int)(Math.floor(intMax * rNum));
		return returnValue;
	}
	// 2) 매개변수 : 기본타입
	// ① 어떤값을 입력 받을 것인가? 태어난 년도
	// ② 어떻게 처리(구현) 할 것인가? 성인 true / 아니면 false
	// ③ 어떤값을 반환 할 것인가? boolean 
	public boolean primitiveParam(int birth) {
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		if(birth < 0 || birth > currentYear) {
			
			System.out.println("잘못된입력");
			return false;
		}
		if(currentYear-birth > 18) {
			return true;
		}
		return false;
	}
	// 2) 매개변수 : 기본타입
	// ① 어떤값을 입력 받을 것인가? int, int int값 두개)
	// ② 어떻게 처리(구현) 할 것인가? 두 입력값 중 더 큰값 반환
	// ③ 어떤값을 반환 할 것인가? int
	public int primitive2Param(int num1, int num2) {
		if(num1 > num2) {
			return num1;
		}
		return num2; 
	}
	
	// 3) 매개변수 : String
	// ① 어떤값을 입력 받을 것인가? 문자열 두개
	// ② 어떻게 처리(구현) 할 것인가? firstName과 lastName의 길이를 반환
	// ③ 어떤값을 반환 할 것인가? int
	public int stringParam(String firstName, String lastName) {
		// 문자열길이를 반환하는 기본 API
		// null 유효성 검사
		if(firstName == null || lastName == null) {
			return 0;
		}
		return firstName.length() + lastName.length();
	}
	// 4) 매개변수 : 배열(기본타입 배열)
	// ① 어떤값을 입력 받을 것인가? int[]
	// ② 어떻게 처리(구현) 할 것인가? 배열의 합
	// ③ 어떤값을 반환 할 것인가? int
	public long arrayParam(int[] arr) {
		if(arr == null) {
			return 0;
		}
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			sum = sum + arr[i];
		}
		return sum;
	}
	// 5) 매개변수 : 배열(String 배열)
	// ① 어떤값을 입력 받을 것인가? 이름 배열
	// ② 어떻게 처리(구현) 할 것인가? 입력된 이름중 한명이라도 블랙리스트 명단에 있으면 ture, 아니면 false
	// ③ 어떤값을 반환 할 것인가? boolean
	public boolean strArrParam(String[] names) {
		// 블랙리스트
		final String[] blackList = {"루피", "상디", "조로"};
  		if(names == null) {
			return false;
		}
  		for(String b : blackList) {
  			for(String n : names) {
  				if(b.equals(n)) {
  					return true;
  				}
  			}
  		}
		return false;
	}
	// 6) 매개변수 : 클래스
	// ① 어떤값을 입력 받을 것인가? 학생타입의 번호,이름 속성만 입력
	// ② 어떻게 처리(구현) 할 것인가? 로그인
	// ③ 어떤값을 반환 할 것인가? boolean
	public boolean clsParam(Student student) {
		//학생목록
		Student[] db = new Student[3];
		db[0] = new Student();
		db[0].setId(100); db[0].setPw("1234");
		db[1] = new Student();
		db[1].setId(200); db[0].setPw("1234");
		db[2] = new Student();
		db[2].setId(300); db[0].setPw("1234");
		
		
		
		if(student == null) {
			System.out.println("로그인 하십시오");
			return false;
		}
		if(student.getId() == 0) {
			System.out.println("아이디가 없습니다");
		}
		for(Student s : db) {
			if(s.getId()==student.getId() && s.getPw().equals(student.getPw())) {
				return true;
			}
		}
		
		return false;
	}
	// 7) 매개변수 : 배열(클래스 배열)
	// ① 어떤값을 입력 받을 것인가? 학생배열 Student[]
	// ② 어떻게 처리(구현) 할 것인가? 성별이 여자인분들의 나이 평균(소수점 2자리 까지)
	// ③ 어떤값을 반환 할 것인가? double
	public double clsArrParam(Student[] arr) {
		// 오늘날짜의 년도
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		int sumAge = 0;
		double avgAge = 0;
		int cnt = 0;
		for(Student s : arr) {
			if(s.getGender().equals("여자")) {
				cnt++;
				int age = currentYear - s.getBirth();
				sumAge = sumAge + age;
			}
		}
		avgAge = (double)sumAge / (double)cnt;
		// java의 반올림은 정수까지 반올림 하기 때문에 
		// 소수점 둘쨰자리까지 구하려면 100을 먼저 곱해서 구해준다음에
		// 100을 다시 나눠준다
		avgAge = Math.round(avgAge * 100) / 100;
		return avgAge;
	}
	// 8) 매개변수 : ArrayList
	// ① 어떤값을 입력 받을 것인가? 성적 데이터(4과목 국어,영어,수학,과학), 
	// ex) null 이면 0+0+0+0, 국어한과목 80 이고 나머지 입력 안되면 80+0+0+0
	// ② 어떻게 처리(구현) 할 것인가? 4과목(4과목이 안되면 0점으로 과목추가) 평균 90이상 A, 80이상 B, 70이상 C, 나머지F
	// ③ 어떤값을 반환 할 것인가? char 'A','B','C','F',
	public char listParam(ArrayList<Subject>list) {
		if(list == null) {
			System.out.println("");
			return '\0';
		}
		int sumScore = 0;
		if(list != null) {
			for(Subject s : list) {
				sumScore = s.getScore();
			}
		}
		double avg = (double)sumScore / 4.0;
		char returnValue = '\0';
		if(avg >= 90) {
			returnValue = 'A';
		} else if(avg >= 80){
			returnValue = 'B';
			
		}else if(avg >= 70){
			returnValue = 'C';
			
		}else {
			returnValue = 'F';
		}
		return returnValue;
	}
	
	
	
	
	
	
	// 9) 매개변수 : HashMap
	// ① 어떤값을 입력 받을 것인가? 두개의 리스트(Student, Emp)
	// ② 어떻게 처리(구현) 할 것인가? 총인원(리스트사이즈의 합)을 계산
	// ③ 어떤값을 반환 할 것인가? int
	public int mapParam(HashMap<String, Object> map) {
		
		int studentCnt = 0;
		int empCnt = 0;
		
		// null 유효성 검사

		
		ArrayList<Student> studentList = (ArrayList<Student>)map.get("studentList");
		ArrayList<Emp> empList = (ArrayList<Emp>)map.get("empList");
		studentCnt = studentList.size();
		empCnt = empList.size();
		return studentCnt+empCnt
				;
	
	}
	
}
