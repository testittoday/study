package qiao;

/**
 * Validate if a given string is numeric.
 * 
 * Some examples:
 * 
 * "0" => true " 0.1 " => true
 * 
 * "abc" => false
 * 
 * "1 a" => false
 * 
 * "2e10" => true
 * 
 * Note: It is intended for the problem statement to be ambiguous. You should
 * gather all requirements up front before implementing one.
 * 
 * More scenarios: 2f, -1.0d, .5, 5., 0x1234, 78l, 0101
 * 
 * 
 * 
 * @author liqiao
 * 
 */
public class ValidNumber {
	float f = .5f;
	double d = 5.;
	int a = 0x23;
	int i = 0101;
	byte b = 0111;
	double d1 = 20000000000000000000000000000000e34;
	float f1 = -788f;
	public static boolean isNumber(String s) {
		if (s == null) {
			return false;
		}
		s = s.trim();
		if (s.isEmpty()) {
			return false;
		}
		char[] chars = s.toCharArray();
		if (chars.length == 1) {
			return isDigit(chars[0]);
		} else if (chars.length == 2) {
			if (isSign(chars[0]) || chars[0] == '.') {
				return isDigit(chars[1]);
			} else {
				if (isDigit(chars[0])) {
					return isDigit(chars[1]) || isType(chars[1])
							|| chars[1] == '.';
				} else {
					return false;
				}
			}
		}
		for (int i = 0; i < chars.length; i++) {
			if (!isDigit(chars[i])) {
				if (i == 0) {
					if (!isSign(chars[i]) && chars[i] != '.') {
						return false;
					} else if (chars[i] == '.') {
						if (!isAllDigitsExceptOneE(chars, 1, chars.length)) {
							return false;
						}
					}
				} else if (i == 1) {
					if (chars[i] == 'x' && chars[0] != '0') {
						return false;
					} else if (chars[i] == 'e') {
						if (!isDigit(chars[0])
								|| !isAllDigitsExceptSign(chars, 2,
										chars.length)) {
							return false;
						}
					} else if (chars[i] == '.') {
						if (!isSign(chars[0]) && !isDigit(chars[0])) {
							return false;

						}
					} else {
						return false;
					}
				} else if (i > 1 && i < chars.length - 1) {
					if (chars[i] == 'e') {
						if (!isAllDigitsExceptOneDotAndSign(chars, 0, i)
								|| !isAllDigitsExceptSign(chars, i + 1,
										chars.length)) {
							return false;
						}
					} else if (chars[i] == '.') {
						if (!isAllDigitsExceptSign(chars, 0, i)
								|| !isAllDigitsExceptOneE(chars, i + 1,
										chars.length)) {
							return false;
						}
					} else if (isSign(chars[i])) {
						if(chars[i-1]!='e'){
							return false;
						}
					} else {
						return false;
					}
				} else if (i == chars.length - 1) {
					if ((!isType(chars[i]) && chars[i] != '.')) {
						return false;
					} else if (chars[i] == '.') {
						if (isSign(chars[0])) {
							if (!isAllDigitsExceptSign(chars, 1, i)) {
								return false;
							}
						} else {
							if (!isAllDigitsExceptSign(chars, 0, i)) {
								return false;
							}
						}
					}
				}
			}

		}
		return true;
	}

	private static boolean isAllDigitsExceptSign(char[] chars, int start,
			int end) {
		for (int j = start; j < end; j++) {
			if (!isDigit(chars[j])) {
				if (j == start && isSign(chars[j])) {
					continue;
				}
				return false;
			}
		}
		return true;
	}

	private static boolean isAllDigitsExceptOneE(char[] chars, int start,
			int end) {
		boolean hasE = false;
		for (int j = start; j < end; j++) {
			if (!isDigit(chars[j])) {
				if (chars[j] == 'e') {
					if (!hasE) {
						hasE = true;
						return isAllDigitsExceptSign(chars, j+1, end);
					}
				}
				return false;
			}
		}
		return true;
	}

	private static boolean isAllDigitsExceptOneDotAndSign(char[] chars,
			int start, int end) {
		boolean hasDot = false;
		for (int j = start; j < end; j++) {
			if (!isDigit(chars[j])) {
				if (j == start && isSign(chars[j])) {
					continue;
				}
				if (chars[j] == '.') {
					if (!hasDot) {
						hasDot = true;
						return isAllDigitsExceptOneE(chars, j+1, end);
					}
				}
				return false;
			}
		}
		return true;
	}

	private static boolean isDigit(char c) {
		return c >= '0' && c <= '9';
	}

	/**
	 * The first char
	 */
	private static boolean isSign(char c) {
		return c == '-' || c == '+';
	}

	/**
	 * the last char
	 * 
	 */
	private static boolean isType(char c) {
		return c == 'f' || c == 'd' || c == 'l';
	}
}
