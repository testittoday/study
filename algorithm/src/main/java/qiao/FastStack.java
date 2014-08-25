package qiao;

import java.util.Stack;

/**
 * 
 * @author liqiao
 * 
 *         Design a stack that supports push, pop, and retrieving the minimum
 *         element in constant time. Can you do this?
 * 
 *         Implemented after reading the hint
 * 
 */
public class FastStack {
	private Stack<Integer> m_minimum = new Stack<Integer>();
	private Stack<Integer> m_data = new Stack<Integer>();

	public void push(Integer n) {
		if (n != null) {
			Integer i = m_minimum.peek();
			if (i == null) {
				m_minimum.push(n);
			} else {
				if (n < i) {
					m_minimum.push(n);
				}
			}
		}
	}

	public Integer pop() {
		Integer d = m_data.pop();
		Integer i = m_minimum.peek();
		if (i != null && i == d) {
			m_minimum.pop();
		}
		return d;
	}

	public Integer getMinimum() {
		return m_minimum.peek();
	}

}
