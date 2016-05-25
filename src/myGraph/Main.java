package myGraph;

import java.io.FileNotFoundException;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		try {
			Graph g = new Graph("test/bi");
			System.out.println("Regular: " + g.isRegular());
			System.out.println("Simple: " + g.isSimple());
			System.out.println("Complete: " + g.isComplete());
			System.out.println("Eulerian: " + g.isEulerian());
			System.out.println("Connected: " + g.isConnected());
			System.out.println("Bipartite: " + g.isBipartiti());
			System.out.println("Tree: " + g.isTree());
			System.out.println("Isolated Vertex: " + g.isIsolatedVertex());
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "File not found, is not necessary to put the file extension, if you have"
					+ "a file 'file.txt' , put just 'file' ");
		} catch (ArrayIndexOutOfBoundsException e){
			JOptionPane.showMessageDialog(null, "Probable your file dont follow the pattern to be read, see the pattern in <link github>");
		}

	}

}
