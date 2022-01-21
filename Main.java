import util.FileReader;
import graph.*;

class Main {
	public static void main(String[] args) {
		final String filename = "./data/demo.txt";

		String file_contents = FileReader.get_file_contents(filename);
		Graph g = Graph.from_string(file_contents);
		print_results(g);
	}

	private static void print_results(Graph graph) {
		if (graph.is_connected()) {
			System.out.println("Yay! it's a connected graph!!");
		}
		else {
			System.out.println("This is not a connected graph ):");
		}
	}
}