package qiao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * 
 * For example, given k = 3, Return [1,3,3,1].
 * 
 * Note: Could you optimize your algorithm to use only O(k) extra space?
 * 
 * @author liqiao
 * 
 */
public class PascalsTriangle {

	/**
	 * Time complexity N!, extra space N!
	 * 
	 * Accepted by the online judge
	 * 
	 * 
	 * @param rowIndex
	 * @return
	 * 
	 */
	public List<Integer> getRow(int rowIndex) {
		if (rowIndex < 0) {
			return Collections.emptyList();
		} else {
			List<Integer> result = new ArrayList<Integer>();
			result.add(1);
			if (rowIndex == 0) {
				return result;
			} else if (rowIndex == 1) {
				;
			} else if (rowIndex == 2) {
				result.add(2);
			} else {
				List<Integer> previousRow = getRow(rowIndex - 1);
				for (int i = 1; i < rowIndex; i++) {
					result.add(previousRow.get(i - 1) + previousRow.get(i));
				}
			}
			result.add(1);
			return result;
		}

	}

	/**
	 * Accepted by the online Judge
	 * 
	 * @param rowIndex
	 * @return
	 */
	public List<Integer> getRow2(int rowIndex) {
		if (rowIndex < 0) {
			return Collections.emptyList();
		} else {
			List<Integer> result = new ArrayList<Integer>();
			result.add(1);
			if (rowIndex == 0) {
				return result;
			}
			result.add(1);
			if (rowIndex == 1) {
				return result;
			}
			List<Integer> newResult = new ArrayList<Integer>();
			while (rowIndex > 1) {
				newResult.removeAll(newResult);
				newResult.add(1);
				for (int i = 1; i < result.size(); i++) {
					newResult.add(result.get(i - 1) + result.get(i));
				}
				newResult.add(1);
				rowIndex--;
				result.removeAll(result);
				result.addAll(newResult);
			}
			return result;
		}
	}
}
