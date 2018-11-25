package arrayList;

import java.util.*;

public class ListTest {
	public static void main(String[] args) 
	{
		ArrayList<Employee> staff = new ArrayList<>();
		
		staff.add(new Employee("Carl Cracker", 75000, 1987, 12, 15));
		staff.add(new Employee("Harry Hacker", 85000, 1997, 9, 25));
		staff.add(new Employee("Tony Tester", 75000, 1985, 1, 18));
		
		for(Employee e: staff)
		{
			e.raiseSalary(5);
		}
		
		for(Employee e: staff)
		{
			System.out.printf("name:%s, salary:%.2f, hireDay:%s\n", e.getName(), e.getSalary(), e.getHireDay().toString());
		}
		
		
	}
}
