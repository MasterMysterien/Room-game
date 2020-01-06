package Game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
	public File file;
	public Scanner reader;

	public FileReader() {
		File file = new File("Files/Level 1.txt");

		try {
			reader = new Scanner(file);
			if(reader.hasNext()){
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		}

	}

}
