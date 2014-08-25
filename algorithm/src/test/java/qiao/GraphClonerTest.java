package qiao;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author liqiao
 * 
 */
public class GraphClonerTest {

	private Set<GraphNode> m_printedNodes;

	@Before
	public void init() {
		m_printedNodes = new HashSet<GraphNode>();
	}

	/**
	 * A->B->C->A A->E->B->C->A A->B->D->E->B->C->A
	 */
	@Test
	public void testCloneGraphNode() {
		GraphNode a = new GraphNode("A");
		GraphNode b = new GraphNode("B");
		a.addNeighbor(b);
		GraphNode c = new GraphNode("C");
		c.addNeighbor(a);
		b.addNeighbor(c);
		GraphNode d = new GraphNode("D");
		b.addNeighbor(d);
		GraphNode e = new GraphNode("E");
		e.addNeighbor(b);
		a.addNeighbor(e);
		d.addNeighbor(e);
		System.out.println("original graph:");
		printGraph(a);

		m_printedNodes.removeAll(m_printedNodes);
		GraphCloner cloner = new GraphCloner();
		GraphNode clone = cloner.clone(a);
		System.out.println("clone graph:");
		printGraph(clone);

	}

	public void printGraph(GraphNode graph) {
		if (graph != null) {
			if (m_printedNodes.contains(graph)) {
				System.out.print(graph.getName());
				System.out.println(";");
			} else {
				m_printedNodes.add(graph);
				if (graph.getNeighbors() != null
						&& graph.getNeighbors().size() > 0) {
					for (GraphNode neighbor : graph.getNeighbors()) {
						System.out.print(graph.getName());
						System.out.print("->");
						printGraph(neighbor);
					}
				} else {
					System.out.print(graph.getName());
					System.out.println(";");
				}
			}
		}

	}

}
