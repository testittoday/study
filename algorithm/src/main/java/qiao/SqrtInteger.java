package qiao;

/**
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x.
 * 
 * @author liqiao
 * 
 */
public class SqrtInteger {
	/**
	 * My solution: finding out each digit starting from the highest
	 * 
	 * Accepted by the Online Judge
	 * 
	 * @param x
	 * @return
	 */
	public static int sqrt(int x) {
		if (x == 0 || x == 1) {
			return x;
		}

		int digitLength = 0;
		int xx = x;
		while (xx > 1) {
			xx = xx / 10;
			digitLength++;
		}
		digitLength = digitLength > 1 ? digitLength / 2 : digitLength;
		int result = 0;
		while (digitLength > 0) {
			int i = 1;
			int tenFold = digitLength;
			while (tenFold-- > 1) {
				i *= 10;
			}
			int j = 1;
			while ((result + i * j) <= x / (result + i * j)) {
				++j;
			}
			result += i * (j - 1);
			digitLength--;
		}
		return result;
	}

	/**
	 * 
	 * bit manipulation
	 * 
	 * Copied from Accepted solution by leetcode
	 * 
	 * @param x
	 * @return
	 */
	public static int sqrt1(int x) {
		if (x == 0)
			return 0;
		int h = 0;
		while ((long) (1 << h) * (long) (1 << h) <= x)
			// firstly, find the most significant bit
			h++;
		h--;
		int b = h - 1;
		int res = (1 << h);
		while (b >= 0) { // find the remaining bits
			if ((long) (res | (1 << b)) * (long) (res | (1 << b)) <= x)
				res |= (1 << b);
			b--;
		}
		return res;
	}

	/**
	 * binary search
	 * 
	 * Copied from Accepted solution by leetcode
	 * 
	 * @param x
	 * @return
	 */
	public static int sqrt2(int x) {
		if (0 == x)
			return 0;
		int left = 1, right = x, ans = 0;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (mid <= x / mid) {
				left = mid + 1;
				ans = mid;
			} else {
				right = mid - 1;
			}
		}
		return ans;
	}
}
