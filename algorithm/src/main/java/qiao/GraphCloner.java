package qiao;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author liqiao
 * 
 */
public class GraphCloner {
	private Map<GraphNode, GraphNode> m_cloneMap;

	public GraphCloner() {
		m_cloneMap = new HashMap<GraphNode, GraphNode>();
	}

	public GraphNode clone(GraphNode source) {
		if (source == null) {
			return null;
		}
		GraphNode clone = clone(source, null);
		return clone;
	}

	private GraphNode clone(GraphNode source, GraphNode clone) {
		if (source != null) {
			GraphNode aClone = null;
			if (m_cloneMap.containsKey(source)) {
				aClone = m_cloneMap.get(source);
			} else {
				aClone = new GraphNode(source.getName());
				m_cloneMap.put(source, aClone);
				Set<GraphNode> neighbors = source.getNeighbors();
				if (neighbors != null && neighbors.size() > 0) {
					for (GraphNode neighbor : neighbors) {
						clone(neighbor, aClone);
					}
				}
			}
			if (clone != null) {
				clone.addNeighbor(aClone);
			} else {
				clone = aClone;
			}
		}
		return clone;
	}
}
