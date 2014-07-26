package liheng;

import java.util.Stack;

public class GaryTest {
	public static void main(String[] args) {

		int input[][] = 
				{ 
					{ 1, 2, 3 }, 
					{ 4, 5, 6 }, 
					{ 7, 8 },
					{ 9, 10, 11, 12 }, 
					{ 0, 13 }, 
				};
		new GaryTest().execute(input);
	}

	int totalFound = 0;

	public void execute(int[][] input) {

		if (input.length == 0) {
			System.out.println("Wrong input");
			return;	
		}
		
		int level1_length = input.length;
		Stack<Integer> result = new Stack<Integer>();

		int[] cursorIndexs = new int[level1_length];
		for (int i = 0; i < cursorIndexs.length; i++) {
			cursorIndexs[i] = -1;
		}
		

		int level = 0;
		cursorIndexs[0] = 0;
		while (!isEnd(cursorIndexs, input)) {
			if (result.size() == input.length) {
				gotOne(result, input);
				result.pop();
				level--;
				moveToNextCursor(cursorIndexs, level);
			} else if (cursorIndexs[level] == input[level].length) {
				result.pop();
				level--;
				moveToNextCursor(cursorIndexs, level);
			} else {
				int temp = input[level][cursorIndexs[level]];
				result.push(temp);
				level++;
				if (level < cursorIndexs.length) {
					moveToNextCursor(cursorIndexs, level);
				}
			}

		}
		result.push(input[level][cursorIndexs[level]]);
		gotOne(result, input);
		
		System.out.println("Totally I found " + totalFound);
	}
	
	private void gotOne(Stack<Integer> result, int[][] input) {
		if (result.size() == input.length ) {
			System.err.println(result);
			totalFound++;
		}
	}

	private void moveToNextCursor(int[] cursor, int level) {
		cursor[level]++;
		for (int i = level + 1; i < cursor.length; i++) {
			cursor[i] = -1;
		}

	}

	private boolean isEnd(int[] cursor, int[][] a) {
		for (int i = 0; i < a.length; i++) {
			if (a[i].length - 1 > cursor[i]) {
				return false;
			}
		}

		return true;
	}
	
}
