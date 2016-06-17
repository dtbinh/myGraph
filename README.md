# myGraph
## This library was created to help students to learn graph and maybe to be used in java birectional graph projects using adjacency matrix.


### File Pattern

The graph file need to follow the below pattern, the vertex have to start on zero.

```
vertex-number-on-graph edge-number-on-graph
origin-vertex destiny-vertex value-vertex
origin-vertex destiny-vertex value-vertex
...
```

Look the graph image and the right file to this graph for an example

![alt text](https://github.com/mateusduraes/myGraph/blob/master/src/myGraph/graph.png)

```
4 4
0 1 1
0 2 1
2 3 1
3 1 1
```

### A guide to use myGraph

If you already have the file graph following the pattern above. You must execute the following code
```java
// imports
public static void main (String[] args){
	try {
			Graph g = new Graph("path/anygraph"); //no need to input the file extension here, is .txt by default on ReadFile constructor
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
			JOptionPane.showMessageDialog(null, "Probable your file dont follow the pattern to be read, see the pattern in github.com/mateusduraes/mygraph");
		}
}
```

### If you have suggestions for this project, your code is welcome! 
### Thank you.
