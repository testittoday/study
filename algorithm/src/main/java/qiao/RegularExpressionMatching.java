package qiao;

/**
 * 
 * Implement regular expression matching with support for '.' and '*'.
 * 
 * '.' Matches any single character. '*' Matches zero or more of the preceding
 * element.
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be: bool isMatch(const char *s, const char *p)
 * 
 * Some examples:
 * 
 * isMatch("aa","a") : false
 * 
 * isMatch("aa","aa") : true
 * 
 * isMatch("aaa","aa") : false
 * 
 * isMatch("aa", "a*") : true
 * 
 * isMatch("aa", ".*") : true
 * 
 * isMatch("ab", ".*") : true
 * 
 * isMatch("aab", "c*a*b") : true
 * 
 * @author liqiao
 * 
 */
public class RegularExpressionMatching {

	/**
	 * 
	 * Translated from the C++ solution on leetcode.com
	 * 
	 * Accepted by the Online Judge
	 * 
	 * @param s
	 * @param p
	 * @return
	 */
	public static boolean isMatch(String s, String p) {
		if (s == null || p == null) {
			return false;
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
