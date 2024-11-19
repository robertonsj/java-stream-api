package src;

import java.util.Arrays;
import java.util.List;

public class StreamPractice01To05 {
	
	
	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
		
		//CHALLANGE 01
		System.out.println("Display the numbers in ascending order: ");
		nums.stream().sorted().distinct()
			.forEach(n -> System.out.print(n + " "));
		
		//CHALLANGE 02: Display the addition of even numbers of the list
		int challange02 = nums.stream().filter( n -> n % 2 == 0).reduce(0, Integer::sum);
		System.out.println("\n\nAddition of all Even Numbers: " + challange02);
		
		//CHALLANGE 03: Check if all numbers are positive
		boolean challange03 = nums.stream().allMatch(n -> n > 0);
		System.out.println("\nAll Elements are Positive? " + challange03);
		
		/*CHALLANGE 04: Remove All Odd*/
		System.out.println("\nThe Even Numbers of the List: ");
		nums.stream().filter(n -> n % 2 == 0).sorted()
			.forEach(n -> System.out.print(n + " "));
		
		/*CHALLANGE 05: Average numbers above 5*/
		double challange05 = nums.stream()
				.filter(n -> n > 5)
				.mapToInt(Integer::intValue) //int value is necessary for numerical operations.
				.average()
				.orElse(0.0);
		System.out.println("\n\nAverage numbers above 5: " + challange05);
		
		
		
	}
}
