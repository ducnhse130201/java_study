import java.util.*;

public class ConstructorTest {

	public static void main(String[] args) {
		ConEmployee[] staff = new ConEmployee[3];
		
		staff[0] = new ConEmployee("Harry", 40000);
		staff[1] = new ConEmployee(60000);
		staff[2] = new ConEmployee();
		
		for (ConEmployee e: staff)
		{
			System.out.printf("name=%-15s, id=%d, salary=%.2f\n", e.getName(), e.getId(), e.getSalary());
		}

	}

}

class ConEmployee
{
	private static int nextId;
	
	private int id;
	private String name = "";
	private double salary;
	
	static
	{
		Random gen = new Random();
		nextId = gen.nextInt(10000);
	}
	
	{
		id = nextId;
		nextId++;
	}
	
	public ConEmployee(String n, double s)
	{
		name = n;
		salary = s;
	}
	
	public ConEmployee(double s)
	{
		this("Employee #"+nextId, s);
	}
	
	public ConEmployee()
	{
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getSalary()
	{
		return salary;
	}
	
	public int getId()
	{
		return id;
	}
	
	
	
	
	
	
	
	
	
	
}
