package qiao;

public class Game {

	/**
	 * Given a 2D binary matrix filled with 0's and 1's, find the largest
	 * rectangle containing all ones and return its area.
	 */

	public static int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return 0;
		}
		int maxArea = 0;
		int startRow = 0;
		int startCol = 0;
		int endRow = 0;
		int endCol = 0;
		boolean inRectangleRow = false;
		boolean inRectangleCol = false;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j <= endCol; j++) {
				if (matrix[i][j] == '1') {
					if (!inRectangleRow) {
						inRectangleRow = true;
						startRow = i;
						startCol = j;
					}
					if (i >= startRow && j >= startCol) {
						endRow = i;
						endCol = j;
					}
				} else if (matrix[i][j] == '0') {
					if (inRectangleRow) {
						if (j == 0) {
							endRow = i - 1;
						} else {
							if (j == endCol) {

							}
							endCol = j - 1;
						}

					}
				}
			}
		}
		return maxArea;
	}
}
