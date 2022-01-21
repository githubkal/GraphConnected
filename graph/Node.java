package graph;

public class Node {
	public char identifier;
	public NodesList edge_connections;

	// Constructor
	public Node(char identifier) {
		this.identifier = identifier;
		this.edge_connections = new NodesList();
	}

	public boolean link_node(Node other_node) {
		if (other_node == null) {
			return false;
		}

		this.edge_connections.add_node_if_doesnt_exist(other_node);
		other_node.edge_connections.add_node_if_doesnt_exist(this);

		return true;
	}
}