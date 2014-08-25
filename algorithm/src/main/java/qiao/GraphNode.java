package qiao;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author liqiao
 * 
 */

public class GraphNode {
	private String m_name;
	private Set<GraphNode> m_neighbors;

	public GraphNode(String name) {
		m_name = name;
		m_neighbors = new HashSet<GraphNode>();
	}

	public String getName() {
		return m_name;
	}

	public Set<GraphNode> getNeighbors() {
		return m_neighbors;
	}

	public void addNeighbor(GraphNode neighbor) {
		m_neighbors.add(neighbor);
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		} else {
			GraphNode aNode = (GraphNode) o;
			if (m_name != null) {
				return m_name.equals(aNode.m_name);
			} else {
				return aNode.m_name == null;
			}
		}

	}

	@Override
	public int hashCode() {
		if (m_name != null) {
			return m_name.hashCode();
		} else {
			return 0;
		}
	}
}
