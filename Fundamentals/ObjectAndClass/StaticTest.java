
public class StaticTest {

	public static void main(String[] args) {
		StaticEmployee[] staff = new StaticEmployee[3];
		
		staff[0] = new StaticEmployee("Tom", 40000);
		staff[1] = new StaticEmployee("Dick", 60000);
		staff[2] = new StaticEmployee("Harry", 65000);
		
		for (StaticEmployee e: staff)
		{
			e.setId();
			System.out.printf("name:%s\tid:%d\tsalary:%.2f\n", e.getName(), e.getId(), e.getSalary());
		}
		
		int n = StaticEmployee.getNextId();
		System.out.println("Next available id:"+n);

	}

}

class StaticEmployee
{
	private static int nextId=1;
	
	private String name;
	private double salary;
	private int id;
	
	public StaticEmployee(String n, double s)
	{
		name = n;
		salary = s;
		id = 0;
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
	
	public void setId()
	{
		id = nextId;
		nextId++;
	}
	
	public static int getNextId()
	{
		return nextId;
	}
	
	public static void main(String[] args)
	{
		StaticEmployee e = new StaticEmployee("Harry", 50000);
		System.out.printf("%s : %.2f\n", e.getName(), e.getSalary());
	}
	
	
	
	
	
}









