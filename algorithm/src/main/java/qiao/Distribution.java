package qiao;

/**
 * 
 * @author liqiao
 * 
 */
public class Distribution {

	/**
	 * There are N children standing in a line. Each child is assigned a rating
	 * value.
	 * 
	 * You are giving candies to these children subjected to the following
	 * requirements:
	 * 
	 * Each child must have at least one candy. Children with a higher rating
	 * get more candies than their neighbors. What is the minimum candies you
	 * must give?
	 * 
	 * @param ratings
	 * @return
	 */
	public static int candy(int[] ratings) {
		if (ratings == null || ratings.length == 0) {
			return 0;
		}
		int result = 0;
		int[] candies = new int[ratings.length];
		return result;
	}
}
