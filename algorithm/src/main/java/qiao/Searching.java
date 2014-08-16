package qiao;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author liqiao
 * 
 */

public class Searching {

	/**
	 * “An array contains integers with the property that a particular number,
	 * called the majority element, appears more than 50% of the time. Give an
	 * algo to find this majority number”
	 * 
	 * @param array
	 * @return
	 */
	public static Integer getMajorityElement(int[] elements) {
		if (elements == null || elements.length == 0) {
			return null;
		} else {
			Map<Integer, Integer> frequencies = new HashMap<Integer, Integer>();
			int length = elements.length / 2;
			for (int element : elements) {
				if (frequencies.containsKey(element)) {
					int counter = frequencies.get(element) + 1;
					if (counter > length) {
						return element;
					}
					frequencies.put(element, counter);
				} else {
					frequencies.put(element, 1);
				}
			}
			return null;
		}
	}
}
