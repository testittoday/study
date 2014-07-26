package liheng;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import zhan.Permutation;

public class PermutationTest {

	@Test
	public void testPermute() {
		Integer[] a = new Integer[] { 1, 2, 3, 4 };
		Permutation<Integer> permutation = new Permutation<Integer>();
		Set<Integer[]> arrays = permutation.getPermutation(a);
		for (Integer[] array : arrays) {
			for (Integer s : array) {
				System.out.print(s);
				System.out.print(",");
			}
			System.out.println("");
		}
	}

}
