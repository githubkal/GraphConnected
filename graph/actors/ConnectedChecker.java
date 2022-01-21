package graph.actors;

import java.util.Stack; //   https://docs.oracle.com/javase/7/docs/api/java/util/Stack.html
import java.util.HashMap; // https://docs.oracle.com/javase/7/docs/api/java/util/HashMap.html

import graph.*;

public class ConnectedChecker {
	private Graph graph;

	public ConnectedChecker(Graph graph) {
		this.graph = graph;
	}

	public boolean result() {
		if (graph.nodes_list.is_empty()) {
			System.out.println("graph is empty; cannot check for connectedness");
			return false;
		}

		// Initialize stack<Node> T & Map<Node, Boolean> M
		Stack<Node> T = new Stack<>();
		HashMap<Node, Boolean> M = new HashMap<>();

		// Save first element 'a' of g.nodes
		Node a = graph.nodes_list.get_first_node();

		// Add 'a' into stack T
		T.push(a);

		// Initialize map's values to all nodes from G.nodes --> false
		add_nodes_to_map_false(M);

		// M[a] := true
		M.put(a, true);
		
		// While T is nonempty {
		while (!T.empty()) {
			// let e := T.pop()
			Node n = T.pop();
			
			// for each neighbor in e.nodes {
			for (Node neighbor : n.edge_connections.nodes) {
				// if M[x] == false {
				if (M.get(neighbor) == false) {
					// T.push(neighbor)
					T.push(neighbor);

					// M[x] := true
					M.put(neighbor, true);
				}	
			}
		}

		// return whether or not all nodes have been visited
		return have_all_nodes_been_visited(M);
	}

	private void add_nodes_to_map_false(HashMap<Node, Boolean> visited) {
		for (Node n : graph.nodes_list.nodes) {
			visited.put(n, false);
		}
	}

	private boolean have_all_nodes_been_visited(HashMap<Node, Boolean> visited) {
		for (Node n : graph.nodes_list.nodes) {
			if (visited.get(n) == false) {
				return false;
			}
		}
		return true;
	}
}