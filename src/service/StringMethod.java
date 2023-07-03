package service;
	
import java.lang.reflect.Member;
import java.util.*;
import Vo.*;
	
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
	
	public Member m66(Member m) {
		if(m == null || m.getpw() == null) {
			System.out.println("멤버 정보가 없습니다");
				return null;
		}
		ArrayList<Member> mlist = new ArrayList<>();
		
		Member m1 = new Member();
		m1.setid(100);
		
	}
	
	
	
	
	
	
	
	
	
	
	public String[] m78(ArrayList<String> list) {
	      if(list == null) {
	         System.out.println("입력 리스트가 없습니다.");
	         return null;
	      }
	      int listSize = list.size();
	      String[] array = new String[listSize];
	      int currIdx = 0;
	      
	      for(String s : list) {
	         array[currIdx] = s;
	         currIdx++;
	      }
	      return array;
	   }
	
	public ArrayList<String> m84(int[] arr){
		if(arr == null) {
			return null;
		}
		
		ArrayList<String> list = new ArrayList<String>();
		
		for(int n : arr) {
			if(n%2 == 0) {
			list.add(""+n);
			}
		}
		
		return list;
	}
	
	
	public HashMap<String, Object> m96(int empNo, String ename, boolean retirer, int deptNo, String dname){
		 
		
		HashMap<String, Object> map = new HashMap<>();
		
		Emp2 emp = new Emp2();
		emp.setEmpNo(empNo);
		emp.setEname(ename);
		emp.setRetirer(retirer);
		
		Dept dept = new Dept();
		dept.setDeptNo(deptNo);
		dept.setDname(dname);
		
		return map;
	}
	
	// test code 추가하는 방법
	// 1) 테스트용 클래스를 만들고 테스트 클래스 안에 static main() 에서
	// 테스트 하고자 하는 메소드를 테스트
	// 2) 테스트 하고자 하는 메소드의 클래스안에 static main()을 만들어서 호출
	public static void main(String[] args) {
		MapReturnMethod mrm = new MapReturnMethod();
		HashMap<String, Object>map = mrm.m910(1,"구디", false, 100, "운영");
		
		Emp2 emp = (Emp2)(map.get("emp"));
		Dept dept = (Dept)(map.get("dept"));
		
		System.out.printf("%s님의 부서는 %s 입니다%n" , emp.getEname(),dept.getDname());
	}
}

	