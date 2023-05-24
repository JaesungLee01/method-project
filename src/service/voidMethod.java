package service;

import Vo.Student;
import Vo.Emp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class VoidMethod {
	// 매개변수 : 없음
	public void voidParm() {
		System.out.print("안녕하세요 구디아카데미입니다.");
	}
	// 매개변수 : 기본타입 (byte, short, int, long, float, double, char, boolean)
	public void intParam(int num) {
		if(num % 2 == 0) {
			System.out.println("입력한 "+num+"은 짝수입니다");
			return;
		}
		System.out.println("입력한 "+num+"은 홀수입니다");
	}
		// 2-1) 두개의 숫자(int)를 입력받아 21을 넘기지 않으면서 21 에 더 가까운 수를 출력하는 메서드
		public void int2Param(int a, int b) {
			// a,b중 21을 넘기지 않으면서 21 에 더 가까운 수
			// 22, 9 -> 9 출력
			// 21, 20 -> 21출력
			if(a > 21 && b > 21) {
		         System.out.println("없음");
		      } else if (a > 21) {
		         System.out.println(b);
		      } else if (b > 21) {
		         System.out.println(a);
		      } else if (a > b){
		         System.out.println(a);
		      } else {
		         System.out.println(b);
		      }
		   }
		
		// 3) 매개변수 : String
		// 매개변수 : String
		public void stringParam(String name) {
			if(name.startsWith("김") || name.startsWith("이") || name.startsWith("박")) {
				System.out.println(name.substring(0, 1)+"씨 입니다");
				
			}else {
				System.out.println("김/이/박 이 아닙니다");
			}
	}
		
		// 4) 매개변수(참조타입) : int 배열
		// int 배열을 입력받아 요소중 가장 큰수를 출력
		public void intArrayParam(int[] arr) {
			if(arr == null || arr.length == 0) {
				System.out.println("입력 error");
				return; // 1) 메소드 종료 2) 호출된 코드부분에 종료후 반환값 남김
 			}
			int max = arr[0]; //ex) 5, 7, 1, 10
			for(int i=0; i<(arr.length); i++){
				if(arr[i] > max) {
					max = arr[i];
				}
					
			}
			System.out.println(max+"입니다");
					
		}
		
		// ※ 기본타입 매개변수 vs 참조타입 매개변수
		public void valueTypeParam(int value) {
			value = 777;
			
		}
		
		public void referTypeParam(int[] refer) {
			refer[0] = 777;
		}
		
		// 5) 매개변수 : 배열 (String 배열)
		// ① 어떤값을 입력 받을 것인가? 사람이름 배열 입력
		// ② 어떻게 처리(구현) 할 것인가? "김"씨 성의 인원을 출력 + 유효성검사
		// ③ 어떤값을 반환 할 것인가? void
		public void strArrParam(String[] names) {
			// 전체 x명 중에 김씨는 y명 입니다
			if(names == null || names.length == 0) {
				System.out.println("이름 배열을 입력하세요");
				return;
			}
			int namesCnt = 0;
			for (String n : names) {
				if(n.startsWith("김")) {
					namesCnt++;
				}
			}
			
			System.out.printf("전체 %d명중 김씨는 %d명입니다\n", names.length, namesCnt);
		}
		
		// 6) 매개변수 : 클래스
		// ① 어떤값을 입력 받을 것인가? 한학생의 정보(Vo)
		// ② 어떻게 처리(구현) 할 것인가? 학생정보 (ex),10, 김xx, 남자, 20살) 를 출력 + 유효성검사
		// ③ 어떤값을 반환 할 것인가? void
		public void clsParam(Student student) {
			// 출력물
			// 입력 - id: 10, name:김홍철, gender:남자, birth:1999
			// 출력 - 10번, 김xx, 남자, 25살
			if(student == null || student.getName() == null || student.getGender() == null) {
				
				return;
			}
			Calendar c = Calendar.getInstance();
			int age = c.get(Calendar.YEAR) - student.getBirth();
			System.out.printf("%d,%sxx,%s,%d살\n",student.getId(),student.getName().substring(0,1), student.getGender(),age);
			
		}
		
		// 7) 매개변수 : 배열(클래스 배열)
		// ① 어떤값을 입력 받을 것인가? 여러학생의 정보(Student[])
		// ② 어떻게 처리(구현) 할 것인가? 남자x명, 여자 x 명
		// ③ 어떤값을 반환 할 것인가? void
		
		public void clsArrParam(Student[] students) {
			
			if(students == null ) {
				return;
			}
			
			int mCnt = 0; // 남자인원
			int fCnt = 0; // 여자인원
			
			for(Student s : students) {
				if(s == null || s.getGender() == null) {
					return;
				} 
				if(s.getGender().equals("남")) {
					mCnt++;
				}else if(s.getGender().equals("여")) {
					fCnt++;
				}
			}
			System.out.println("남자는 "+mCnt+"명, 여자는 "+fCnt+"명");
		}
		// 8) 매개변수 : ArrayList
		// ① 어떤값을 입력 받을 것인가? 여러학생의 정보(List<Student>)
		// ② 어떻게 처리(구현) 할 것인가? 전체 x명, 20대 x명, 30대 x명
		// ③ 어떤값을 반환 할 것인가? void
		public void listParam (ArrayList<Student> list) {
			if(list == null) {
				return;
			}
			int ages20 = 0;
			int ages30 = 0;
			int currentYear = Calendar.getInstance().get(Calendar.YEAR);
			
			for(Student s : list) {
				int age = currentYear - s.getBirth();
				int ages = age/ 10*10;
				if(ages == 20) {
					ages20++;
				}else if(ages == 30) {
					ages30++;
				}
			}
			System.out.printf("전체 %d명, 20대 %d명, 30대 %d명\n", list.size(),ages20,ages30);
		}
		
		// 9) 매개변수 : HashMap
		// ① 어떤값을 입력 받을 것인가? Student 1 + Emp 1명 --> HashMap 하나를 입력
		// ② 어떻게 처리(구현) 할 것인가? 학생이름 xxx이고, 담당직원의 이름은 xxx 입니다
		// ③ 어떤값을 반환 할 것인가? void
		public void mapParam(HashMap<String, Object>map) {
			if(map == null || map.size() == 0) {
				System.out.println("입력이 없습니다");
				return;
			}
			Emp emp = (Emp)(map.get("e1"));
			Student student = (Student)(map.get("s1"));
			
			System.out.printf("학생 %s의 담당 직원은 %s입니다",student.getName(), emp.getEmpName());
			
		}
}

	