package src;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StreamPractice06To10{
	
	
	public static void main(String[] args) {
		
		
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
		
		/*CHALLANGE 06: Check if the list contains any numbers greater than 10*/
		boolean challange06 = nums.stream().anyMatch(n -> n > 10);
		System.out.println("\nThe List Contains any Numbers greater than 10? " 
				+ challange06);
		
		/*CHALLANGE 07: Find the second highest number on the list
		 * Take the highest number and ignores it using a filter*/
		Integer secondMax = nums.stream().distinct() // Remove duplicates
				.sorted((a, b) -> b.compareTo(a)) //Sort in descending order
				.skip(1)
				.findFirst().orElse(null);
		System.out.println("\nThe Second highest number in List: " + secondMax);
		
		/*CHALLANGE 08: Calculate the sum of the digits of all numbers in list.*/
		int totalSumofDigits = nums.stream()
				.flatMapToInt(n -> String.valueOf(n) // Convert each number to string
						.chars() // Get the IntStream of character codes
						.map(Character::getNumericValue)) // Convert character codes to their numeric value
				.sum();
		System.out.println("\nSum of all digits: " + totalSumofDigits);
		
		/*CHALLANGE 09: 
		 * Check if all numbers are unique, whether they don't repete*/
		boolean allDistinct = nums.stream()
				.distinct()
				.count()
				== nums.size();
		System.out.println("\nAre All the Numbers Distinct each other? " + allDistinct);
		
		/*CHALLANGE 10: Group the odd numbers multiples of 3 or 5*/
		List<Integer> oddNums = nums.stream()
				.filter( new Predicate<Integer>() {
					public boolean test(Integer n) {					
						return n % 2 == 1 && (n % 3 == 0 || n % 5 == 0);
					}
				})
				.sorted()
				.toList();
		System.out.println("\nOdd Numbers Multiple of 3 or 5: " + oddNums);
	}
}
