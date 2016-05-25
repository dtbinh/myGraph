package myGraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {	
	Scanner file;
	
	public ReadFile(String file) throws FileNotFoundException{
		this.file = new Scanner(new File(file+".txt"));
	}	
	
	public boolean hasNextInt(){
		return this.file.hasNextInt();
	}
	public int readInt(){
		return this.file.nextInt();
	}
	public void close(){
		this.file.close();
	}
}
