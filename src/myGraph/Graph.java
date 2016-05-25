package myGraph;

import java.io.FileNotFoundException;

/**
 * 
 * @author Mateus Durães This class was created to help in bidirectional graph
 *         problems and create bidirectional graph applications using adjacency
 *         matrix.
 *
 */
public class Graph {
	public int vertexNumber;
	public int edgeNumber;
	private int[][] graph;
	private int[] vertexDegrees;
	private boolean[] visited;
	public VertexType[] vertexType;
	private ReadFile file;

	/**
	 * This constructor method initialize the graph.
	 * 
	 * @param file
	 * @throws FileNotFoundException
	 */
	public Graph(String file) throws FileNotFoundException { // here, i need to
																// receive the
																// file name and
																// read the file
		this.file = new ReadFile(file);
		this.vertexNumber = this.file.readInt();
		this.edgeNumber = this.file.readInt();
		graph = new int[vertexNumber][vertexNumber];
		while (this.file.hasNextInt()) {
			int origin = this.file.readInt();
			int destiny = this.file.readInt();
			int value = this.file.readInt();
			graph[origin][destiny] = graph[destiny][origin] = value;
		}
		this.file.close();
		vertexDegrees = new int[vertexNumber];
		getDegrees();		
	}

	/**
	 * This private method is used to get the degree of each vertex in Graph.
	 * 
	 * @return void, nothing.
	 */
	private void getDegrees() {

		for (int i = 0; i < graph.length; i++) {
			int degree = 0;
			for (int j = 0; j < graph[i].length; j++) {
				if (graph[i][j] != 0) {
					degree++;
				}
			}
			vertexDegrees[i] = degree;
		}
	}

	/**
	 * This method show the Graph Array in console.
	 * 
	 * @return void, nothing.
	 */
	public void showGraphArray() {
		for (int i = 0; i < graph.length; i++) {
			System.out.print("\n");
			for (int j = 0; j < graph[i].length; j++) {
				System.out.print("\t" + graph[i][j]);
			}
		}
	}

	/**
	 * This method is used to verify if the graph is Simple Graph or not.
	 * 
	 * @return boolean, if Graph is simple, returns true, else, returns false.
	 */
	public boolean isSimple() {

		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[i].length; j++) {
				if (i == j && graph[i][j] != 0) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * This method is used to verify if the graph is Complete Graph or not.
	 * 
	 * @return boolean, if Graph is complete, returns true, else, returns false.
	 */
	public boolean isComplete() {

		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[i].length; j++) {
				if (i == j && graph[i][j] != 0) {
					return false;
				} else if (i != j && graph[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * This method is used to verify if the graph is Regular Graph or not.
	 * 
	 * @return boolean, if Graph is regular, returns true, else, returns false.
	 */
	public boolean isRegular() {
		int firstVertexDegree = vertexDegrees[0];

		for (int i = 1; i < vertexDegrees.length; i++) {
			if (vertexDegrees[i] != firstVertexDegree) {
				return false;
			}
		}
		return true;
	}

	/**
	 * This method is used to verify if the graph is an Eulerian Graph or not.
	 * 
	 * @return boolean, if Graph is an Eulerian Graph, returns true, else,
	 *         returns false.
	 */
	public boolean isEulerian() {
		for (int i = 0; i < vertexDegrees.length; i++) {
			if (vertexDegrees[i] % 2 != 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * This method is used to verify if the graph is a Hamiltonian Graph or not.
	 * 
	 * @return boolean, if Graph is a Hamiltonian Graph, returns true, else,
	 *         returns false.
	 */
	public boolean isHamiltonian() {
		return false;
	}

	/**
	 * This private method is used to visit a vertex.
	 * 
	 * @param vertex
	 */
	private void visit(int vertex) {
		visited[vertex] = true;
		for (int i = 0; i < visited.length; i++) {
			if (graph[vertex][i] != 0 && !visited[i]) {
				visit(i);
			}
		}
	}

	/**
	 * This method is used to verify if the graph is a Connected Graph or not.
	 * 
	 * @return boolean, if Graph is a Connected Graph, returns true, else,
	 *         returns false.
	 */
	public boolean isConnected() {
		visited = new boolean[vertexNumber];
		int component = 0;
		for (int i = 0; i < graph.length; i++) {
			if (!visited[i]) {
				visit(i);
				component++;
			}
		}
		return (component != 1) ? false : true;
	}

	/**
	 * This method is used to verify if the graph is a Bipartiti Graph too.
	 * 
	 * @return boolean, if Graph is a Bipartiti Graph, returns true, else,
	 *         returns false.
	 */
	public boolean isBipartiti() {
		if (!this.isConnected()) {
			return false;
		}

		vertexType = new VertexType[vertexNumber];

		for (int i = 0; i < graph.length; i++) {
			VertexType aux = null;
			if (vertexType[i] == null) {
				vertexType[i] = VertexType.BALL;
				aux = VertexType.SQUARE;
			} else {
				aux = (vertexType[i] == VertexType.BALL) ? VertexType.SQUARE : VertexType.BALL;
			}
			for (int j = 0; j < graph[i].length; j++) {
				if (graph[i][j] != 0) {
					if (vertexType[j] == null) {
						vertexType[j] = aux;
					} else {
						if (vertexType[j] != aux) {
							return false;
						}
					}
				}

			}
		}

		return true;
	}

	/**
	 * This method is used to verify if the graph have an isolated vertex.
	 * 
	 * @return boolean, if Graph have an isolated vertex, returns true, else,
	 *         returns false
	 */
	public boolean isIsolatedVertex() {
		for (int i = 0; i < vertexDegrees.length; i++) {
			if (vertexDegrees[i] == 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * This method is used to verify if the graph have an isolated vertex.
	 * 
	 * @return boolean, if Graph is a Tree, returns true, else, returns false
	 */
	public boolean isTree() {
		if (!this.isConnected()) {
			return false;
		}
		
		
		return (edgeNumber == (vertexNumber - 1));
	}

}
