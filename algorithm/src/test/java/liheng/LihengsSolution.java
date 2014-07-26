package liheng;

public class LihengsSolution {
	private static int s_total;

	public static void main(String[] args) {

		int input[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8 },
				{ 9, 10, 11, 12 }, { 0, 13 }, };
		execute(input, 0, new int[input.length]);
		System.out.println("total # of combinations: " + s_total);
	}

	public static void execute(int[][] input, int targetIndex, int[] target) {
		if (targetIndex == input.length) {
			s_total++;
			printArray(target);
		} else {
			int[] oneArray = input[targetIndex];
			for (int oneElement : oneArray) {
				target[targetIndex] = oneElement;
				execute(input, targetIndex + 1, target);
			}
		}
	}

	public static void printArray(int[] array) {
		for (int i : array) {
			System.out.print(i);
			System.out.print(",");
		}
		System.out.println("");
	}

}
