package graph;

import structures.Pair;
import graph.actors.ConnectedChecker;

public class Graph {
	public NodesList nodes_list;

	// Constructor
	private Graph() {
		nodes_list = new NodesList();
	}

	// Static Constructor
	public static Graph from_string(String serialized_graph) {
		// Split multiline string into an array of single lines
		String[] lines = serialized_graph.split("\\r?\\n");
		
		// Empty graph constructor
		Graph graph = new Graph();

		// Format: __first line__
		// EdgeCount
		int edge_count = Integer.parseInt(lines[0]);
		
		for (int i = 0; i < edge_count; i++) {
			// __remaining lines__: (there areEdgeCount count remaining lines)
			// SrcId DstId
			String[] next_line = lines[1 + i].split(" ");
			char src_id = next_line[0].charAt(0);
			char dst_id = next_line[1].charAt(0);

			graph.add_edge(src_id, dst_id);
		}

		return graph;
	}

	private void add_edge(char src_id, char dst_id) {
		// Create the nodes (if doesn't exist; otherwise fetch existing) & tell them about each other to add to their Nodes object
		Pair<Node> connected_nodes = nodes_list.create_edge_and_nodes_if_dont_exist(src_id, dst_id);

		// Add nodeA & nodeB to graph's Nodes object
		nodes_list.add_node_if_doesnt_exist(connected_nodes.left);
		nodes_list.add_node_if_doesnt_exist(connected_nodes.right);
	}
	
	public boolean is_connected() {
		return new ConnectedChecker(this).result();
	}
}