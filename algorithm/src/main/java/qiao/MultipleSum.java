package qiao;

/**
 * https://projecteuler.net/problem=1
 * 
 * Multiples of 3 and 5
 * 
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we
 * get 3, 5, 6 and 9. The sum of these multiples is 23.
 * 
 * Find the sum of all the multiples of 3 or 5 below 1000.
 * 
 * @author liqiao
 * 
 */
public class MultipleSum {
	public static int sumOfMultiples(int n, int[] divisors) {
		int sum = 0;
		for (int i = 1; i < n; i++) {
			boolean divisible = false;
			for (int j = 0; j < divisors.length; j++) {
				if (i % divisors[j] == 0) {
					divisible = true;
					break;
				}
			}
			if (divisible) {
				sum += i;
			}
		}
		return sum;
	}
}
