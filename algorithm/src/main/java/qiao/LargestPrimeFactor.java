package qiao;

import java.util.Set;

/**
 * 
 * Largest prime factor
 * 
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * 
 * What is the largest prime factor of the number 600851475143 ?
 * 
 * @author liqiao
 * 
 */
public class LargestPrimeFactor {
	public static long largestPrimeFactor(long n) {
		long max = 0;
		// the largest prime factor is less than the square root of n
		for (long i = 2; i * i < n; i++) {
			if (n % i == 0) {
				if (isPrime(i)) {
					max = max < i ? i : max;
				}
			}
		}
		return max;
	}

	private static boolean isPrime(long n) {
		if (n == 2 || n == 3 || n == 5) {
			return true;
		} else {
			for (long i = 2; i < n; i++) {
				if (n % i == 0) {
					return false;
				}
			}
			return true;
		}
	}
}
