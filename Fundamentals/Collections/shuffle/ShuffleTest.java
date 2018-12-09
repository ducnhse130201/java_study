package shuffle;

import java.util.*;

public class ShuffleTest {
	public static void main(String[] args)
	{
		List<Integer> numbers = new ArrayList<>();
		
		for(int i=1; i<=50; i++)
		{
			numbers.add(i);
		}
//		System.out.println(numbers);
		Collections.shuffle(numbers);
//		System.out.println(numbers);
		List<Integer> winningCombination = numbers.subList(0, 10);
		Collections.sort(winningCombination);
		System.out.println(winningCombination);
		
		
	}
}
