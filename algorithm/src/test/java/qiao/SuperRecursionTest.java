package qiao;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class SuperRecursionTest {

	@Test
	public void test() {
		SuperRecursion sr = new SuperRecursion();
		List<String> result = sr.letterCombinations("23");
		for (String s : result) {
			System.out.println(s);
		}
		Set<String> uniqueResult = new HashSet<String>();
		uniqueResult.addAll(result);
		assertTrue(uniqueResult.size() == 9);
	}

}
