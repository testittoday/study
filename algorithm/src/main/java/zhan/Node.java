/**
 *
 * 
 *
 * $Id: $
 *
 */

package zhan;

/**
 *
 * @author liqiao
 */
public class Node {

    private String m_name;
	private Node[] m_children;

	public Node(String name, Node[] children) {
		m_name = name;
		if (children != null) {
			m_children = children;
		} else {
			m_children = new Node[0];
		}

	}

	public String getName() {
		return m_name;
	}

	public boolean isLeaf() {
		return m_children.length == 0;
	}

	public Node[] getChildren() {
		return m_children;
	}
}
