package qiao;

import static org.junit.Assert.*;

import org.junit.Test;

public class EvenFibonacciNumbersTest {

	@Test
	public void test() {
		int result = EvenFibonacciNumbers.sumOfEvenFibonacciNumbers(4000000);
		assertTrue("result: " + result, result == 0);
	}

}
