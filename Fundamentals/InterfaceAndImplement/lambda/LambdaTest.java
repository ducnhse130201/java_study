package lambda;

import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class LambdaTest {
	public static void main(String[] args)
	{
		String[] planets = new String[] {"Mercury", "Venus", "Earth", "Mars",
				"Jupiter", "Saturn", "Uranus", "Neptune"};
		System.out.println("init : ");
		System.out.println(Arrays.toString(planets));
		System.out.println("Sorted in dict order:");
		Arrays.parallelSort(planets);
		System.out.println(Arrays.toString(planets));
		System.out.println("Sorted by length:");
		Arrays.parallelSort(planets, (first, second) -> first.length() - second.length());
		System.out.println(Arrays.toString(planets));
		
		Timer t = new Timer(1000, event ->
				System.out.println("The tims is "+new Date()));
		t.start();
		
		JOptionPane.showMessageDialog(null, "Quit?");
		System.exit(0);
		
		
		
	}
}
