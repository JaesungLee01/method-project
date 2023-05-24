import java.util.ArrayList;
import java.util.HashMap;

import Vo.Student;
import Vo.Emp;
import service.VoidMethod;

public class VoidMain {

	public static void main(String[] args) {
		VoidMethod vm = new VoidMethod();
		vm.voidParm();
		
		int num = 8;
		vm.intParam(num);
		
		String name = "이철수";
		vm.stringParam(name);
		
		int a = 20;
		int b = 10;
		vm.int2Param(a, b);
		
		int[] arr = {50, 1 ,10, 7, 0, 21};
		vm.intArrayParam(arr);
		
		int value = 100;
		vm.valueTypeParam(value);
		System.out.println(value);
		System.out.println("======");
		int[] refer = {1,2,3};
		System.out.println(refer[0]);
		System.out.println(refer);
		vm.referTypeParam(refer);
		System.out.println(refer[0]);
		System.out.println(refer);
		
		// 
		String[] names = {"정현","오빈","김은","송지","김은"};
		vm.strArrParam(names);
		
		Student ch = new Student();
		ch.setId(3);
		ch.setName("최동욱");
		ch.setGender("남");
		ch.setBirth(1999);
		vm.clsParam(ch);
		
		Student s1 = new Student();
		s1.setId(3);
		s1.setName("최동욱");
		s1.setGender("남");
		s1.setBirth(1999);
		Student s2 = new Student();
		s2.setId(4);
		s2.setName("최명진");
		s2.setGender("남");
		s2.setBirth(1995);
		Student s3 = new Student();
		s3.setId(5);
		s3.setName("최미진");
		s3.setGender("여");
		s3.setBirth(2000);
		vm.clsParam(ch);
		Student[] students = new Student[3];
		students[0] = s1;
		students[1] = s2;
		students[2] = s3;
		vm.clsArrParam(students);
		
		//
		
		
		ArrayList<Student> list = new ArrayList<>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		vm.listParam(list);
		
		Emp emp = new Emp();
		emp.setEmpName("루피");
		Student hkd = new Student();
		hkd.setName("홍길동");
		HashMap<String, Object> map = new HashMap<>();
		map.put("e1",emp);
		map.put("s1",hkd);
		vm.mapParam(map);
		
		
		
		
	}
	
	

}
