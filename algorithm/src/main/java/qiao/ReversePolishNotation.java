package qiao;

import java.util.Stack;

/**
 * 
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * 
 * Valid operators are +, -, *, /. Each operand may be an integer or another
 * expression.
 * 
 * Some examples: ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9 ["4", "13", *
 * "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * 
 * Accepted by the Online Judge
 * 
 * @author liqiao
 * 
 */
public class ReversePolishNotation {
	public int evalRPN(String[] tokens) {
		if (tokens == null || tokens.length == 0) {
			return 0;
		}
		if (tokens.length == 1) {
			return Integer.parseInt(tokens[0]);
		}
		if (tokens.length < 3) {
			throw new IllegalArgumentException();
		}
		Stack<Integer> numbers = new Stack<Integer>();
		Integer result = null;
		for (String token : tokens) {
			try {
				Integer n = Integer.valueOf(token);
				numbers.push(n);
			} catch (NumberFormatException nfe) {
				int n1 = numbers.pop();
				int n2 = numbers.pop();
				result = cal(token, n1, n2);
				numbers.push(result);
			}
		}
		return result;
	}

	public int cal(String operator, int n1, int n2) {
		if (operator == null || operator.length() == 0) {
			throw new IllegalArgumentException();
		}
		switch (operator) {
		case "+":
			return n1 + n2;
		case "-":
			return n2 - n1;
		case "*":
			return n1 * n2;
		case "/":
			return n2 / n1;
		default:
			throw new IllegalArgumentException("unsupported operator"
					+ operator);
		}
	}
}
