package qiao;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LargestPrimeFactorTest {

	@Test
	public void test() {
		assertTrue(LargestPrimeFactor.largestPrimeFactor(13195) == 29);
		long result = LargestPrimeFactor.largestPrimeFactor(600851475143l);
		assertTrue("result: " + result, result == 6857);
	}

}
