package qiao;

import static org.junit.Assert.*;

import org.junit.Test;

import qiao.Permutation;

public class Permutation2Test {

	@Test
	public void testPermutate() {
		Permutation permutation2 = new Permutation(new int[] { 1, 2, 3, 4 });
		int[][] b = permutation2.getPermutations();
		for (int[] c : b) {
			for (int i : c) {
				System.out.print(i);
				System.out.print(",");
			}
			System.out.println("");
		}
	}

}
