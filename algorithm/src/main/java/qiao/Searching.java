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
	 * 
	 * @param num
	 * @return
	 */
	public List<List<Integer>> threeSum(int[] num) {
		Arrays.sort(num);
		Set<String> rStrings = new HashSet<String>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int n = 0; n < num.length - 2; n++) {
			for (int i = n + 1; i < num.length - 1; i++) {
				for (int j = i + 1; j < num.length; j++) {
					if (isTriplet(num[n], num[i], num[j])) {
						List<Integer> aResult = new ArrayList<Integer>(3);
						aResult.add(Integer.valueOf(num[n]));
						aResult.add(Integer.valueOf(num[i]));
						aResult.add(Integer.valueOf(num[j]));
						StringBuilder sb = new StringBuilder();
						sb.append(num[n]).append(num[i]).append(num[j]);
						String s = sb.toString();
						if (!rStrings.contains(s)) {
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

	public static int maxPoints(Point[] points) {
		if (points == null || points.length < 1) {
			return 0;
		} else if (points.length == 1) {
			return 1;
		} else if (points.length == 2) {

			return 2;
		}
		Map<String, Set<Point>> resultMap = new HashMap<String, Set<Point>>();
		for (int i = 0; i < points.length - 1; i++) {
			for (int j = i + 1; j < points.length; j++) {
				String slope = getSlope(points[i], points[j]);
				String intercept = getIntercept(points[i], points[j]);
				// if(intercept!=null){
				String key = slope + "-" + intercept;
				if (resultMap.containsKey(key)) {
					Set<Point> linePoints = resultMap.get(key);
					linePoints.add(points[i]);
					linePoints.add(points[j]);
				} else {
					Set<Point> linePoints = new HashSet<Point>();
					linePoints.add(points[i]);
					linePoints.add(points[j]);
					resultMap.put(key, linePoints);
				}
				// }
			}
		}
		int max = 0;
		for (Set<Point> linePoints : resultMap.values()) {
			if (linePoints.size() > max) {
				max = linePoints.size();
			}
		}
		return max;
	}

	public static String getSlope(Point a, Point b) {
		if (b.x - a.x != 0) {
			return String.valueOf((b.y - a.y) / (b.x - a.x));
		} else {
			return "~";
		}
	}

	public static String getIntercept(Point a, Point b) {
		if (b.x - a.x != 0) {
			return String.valueOf((b.x * a.y - a.x * b.y) / (b.x - a.x));
		} else {
			if (a.y == b.y) {
				return String.valueOf(a.y);
			} else {
				return null;
			}
		}
	}

	private boolean isTriplet(int a, int b, int c) {
		return (a + b + c) == 0;
	}

	/**
	 * Implement regular expression matching with support for '.' and '*'.
	 * 
	 * '.' Matches any single character. '*' Matches zero or more of the
	 * preceding element.
	 * 
	 * The matching should cover the entire input string (not partial).
	 * 
	 * The function prototype should be: bool isMatch(const char *s, const char
	 * *p)
	 * 
	 * Some examples:
	 * 
	 * isMatch("aa","a") → false
	 * 
	 * isMatch("aa","aa") → true
	 * 
	 * isMatch("aaa","aa") → false
	 * 
	 * isMatch("aa", "a*") → true
	 * 
	 * isMatch("aa", ".*") → true
	 * 
	 * isMatch("ab", ".*") → true
	 * 
	 * isMatch("aab", "c*a*b") → true
	 * 
	 * 
	 * Accepted Solution in C++ got from leetcode.com:
	 * 
	 * 
	 * bool isMatch(const char *s, const char *p) {
	 * 
	 * assert(s && p);
	 * 
	 * if (*p == '\0') return *s == '\0';
	 * 
	 * // next char is not '*': must match current character
	 * 
	 * if (*(p+1) != '*') {
	 * 
	 * assert(*p != '*');
	 * 
	 * return ((*p == *s) || (*p == '.' && *s != '\0')) && isMatch(s+1, p+1);
	 * 
	 * }
	 * 
	 * // next char is '*'
	 * 
	 * while ((*p == *s) || (*p == '.' && *s != '\0')) {
	 * 
	 * if (isMatch(s, p+2)) return true;
	 * 
	 * s++;
	 * 
	 * }
	 * 
	 * return isMatch(s, p+2);
	 * 
	 * }
	 * 
	 * @param s
	 * @param p
	 * @return
	 */
	public static boolean isMatch(String s, String p) {
		if (s == null || p == null) {
			return false;
		}
		if (p.length() == 1 && p.charAt(0) == '*') {
			return true;
		}
		return isMatchFromC2(s.toCharArray(), 0, p.toCharArray(), 0);
		// return isMatchFromC(s, p);
	}

	/**
	 * Passed the unit test but rejected by the Online Judge, because of the
	 * time limit when the input is ("baccbbcbcacacbbc", "c*.*b*c*ba*b*b*.a*")
	 * 
	 * @param s
	 * @param p
	 * @return
	 */
	public static boolean isMatchFromC(String s, String p) {
		if (p == null || p.length() == 0) {
			return s == null || s.length() == 0;
		}
		if ((p.length() >= 2 && p.charAt(1) != '*') || p.length() == 1) {
			if (s == null) {
				return false;
			}
			if (p.charAt(0) == s.charAt(0)
					|| ((p.charAt(0) == '.') && (s != null && s.length() > 0))) {
				s = s.length() > 1 ? s.substring(1, s.length()) : null;
				p = p.length() > 1 ? p.substring(1, p.length()) : null;
				return isMatchFromC(s, p);
			} else {
				return false;
			}

		}
		while (s != null && s.length() > 0 && p.charAt(0) == s.charAt(0)
				|| (p.charAt(0) == '.' && s != null && s.length() > 0)) {
			String newP = p.length() > 2 ? p.substring(2, p.length()) : null;
			if (isMatchFromC(s, newP)) {
				return true;
			}
			s = s.length() > 1 ? s.substring(1, s.length()) : null;
		}
		p = p.length() > 2 ? p.substring(2, p.length()) : null;
		return isMatchFromC(s, p);
	}

	/**
	 * Accepted by the online Judge
	 * 
	 * @param s
	 * @param sIndex
	 * @param p
	 * @param pIndex
	 * @return
	 */
	private static boolean isMatchFromC2(char[] s, int sIndex, char[] p,
			int pIndex) {
		if (pIndex > p.length - 1) {
			return sIndex > s.length - 1;
		}
		if ((pIndex < p.length - 1 && p[pIndex + 1] != '*')
				|| pIndex == p.length - 1) {
			if (sIndex > s.length - 1) {
				return false;
			}
			if (sIndex < s.length && p[pIndex] == s[sIndex]
					|| (p[pIndex] == '.' && sIndex < s.length)) {
				return isMatchFromC2(s, sIndex + 1, p, pIndex + 1);
			} else {
				return false;
			}

		}
		while (sIndex < s.length && p[pIndex] == s[sIndex]
				|| (p[pIndex] == '.' && sIndex < s.length)) {
			if (isMatchFromC2(s, sIndex, p, pIndex + 2)) {
				return true;
			}
			sIndex++;
		}
		return isMatchFromC2(s, sIndex, p, pIndex + 2);
	}
}
