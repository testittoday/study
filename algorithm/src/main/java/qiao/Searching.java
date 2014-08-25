package qiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author liqiao
 * 
 */

public class Searching {

	/**
	 * An array contains integers with the property that a particular number,
	 * called the majority element, appears more than 50% of the time. Give an
	 * algo to find this majority number
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
	
	
	/**
	 * Accepted by the Online Judge
	 * @param num
	 * @return
	 */
	public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        Set<String> rStrings = new HashSet<String>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int n=0; n<num.length-2; n++){
            for(int i = n+1; i<num.length-1; i++){
                for(int j = i+1; j<num.length; j++){
                    if(isTriplet(num[n], num[i], num[j])){
                        List<Integer> aResult = new ArrayList<Integer>(3);
                        aResult.add(Integer.valueOf(num[n]));
                        aResult.add(Integer.valueOf(num[i]));
                        aResult.add(Integer.valueOf(num[j]));
                        StringBuilder sb = new StringBuilder();
                        sb.append(num[n]).append(num[i]).append(num[j]);
                        String s = sb.toString();
                        if(!rStrings.contains(s)){
                            result.add(aResult);
                            rStrings.add(s);
                        }
                        break;
                    }
                }
            }
        }
        return result;
    }
    
    private boolean isTriplet(int a, int b, int c){
        return (a+b+c)==0;
    }
}
