package qiao;

/**
 * Not thread safe.
 * 
 * @author liqiao
 * 
 */

public class Node<T> {
	private String m_name;
	private Node<T>[] m_children;
	private T m_value;
	private Node<T> m_parent;
	private boolean m_parentSet;
	private int m_childIndex;

	public Node(String name, Node<T>[] children) {
		this(name, null, children);
	}

	public Node(String name, T value, Node<T>[] children) {
		m_name = name;
		m_value = value;
		if (children != null) {
			m_children = children;
			int index = 0;
			for (Node<T> child : m_children) {
				child.setChildIndex(index++);
			}
		}
	}

	public String getName() {
		return m_name;
	}

	public boolean isLeaf() {
		return m_children == null || m_children.length == 0;
	}

	/**
	 * 
	 * @return null if this is a leave node
	 */
	public Node<T>[] getChildren() {
		return m_children;
	}

	public T getValue() {
		return m_value;
	}

	public Node<T> getParent() {
		if (m_parentSet) {
			return m_parent;
		} else {
			throw new UnsupportedOperationException("parent not set");
		}

	}

	public void setParent(Node<T> parent) {
		m_parent = parent;
		m_parentSet = true;
	}

	public int getChildIndex() {
		return m_childIndex;
	}

	public void setChildIndex(int index) {
		m_childIndex = index;
	}
}
