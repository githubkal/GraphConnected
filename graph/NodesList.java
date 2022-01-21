package graph;

import structures.Pair;

import java.util.List;
import java.util.ArrayList;

public class NodesList {
	public List<Node> nodes;

	// Constructor
	public NodesList() {
		nodes = new ArrayList<Node>();
	}

	public boolean add_node_if_doesnt_exist(Node new_node) {
		if (nodes.contains(new_node)) {
			return false;
		}

		nodes.add(new_node);
		return true;
	}

	/**
	 * Given two identifiers (names of nodes), link them (and create if not yet exist)
	 *	Return the newly created or already existing nodes in the following order:
	 *  (SrcNode, DstNode)
	 */
	public Pair<Node> create_edge_and_nodes_if_dont_exist(char src_id, char dst_id) {
		Node src_node = fetch_with_id_or_create(src_id);
		Node dst_node = fetch_with_id_or_create(dst_id);

		src_node.link_node(dst_node);

		return new Pair<Node>(src_node, dst_node);
	}

	/**
	 * Checks if the nodes-list contains a node with a given id;
	 * 	if so, return NodeReference
	 *  otherwise, create a new one & return NodeReference
	 */
	private Node fetch_with_id_or_create(char id) {
		for (int i = 0; i < nodes.size(); i++) {
			Node current = nodes.get(i);

			if (current.identifier == id) {
				return current;
			}
		}

		return new Node(id);
	}

	public boolean is_empty() {
		return nodes.isEmpty();
	}

	public Node get_first_node() {
		return nodes.get(0);
	}
}