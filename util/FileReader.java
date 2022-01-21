package util;

import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class FileReader {
	public static String get_file_contents(String filename) {
		String contents = "";

		try (Scanner scan = new Scanner(new File(filename))) {
			contents = scan.useDelimiter("\\Z").next();
		}
		catch (FileNotFoundException e) {
			System.out.printf("File (%s) was not found; closing app%n", filename);
			System.exit(-1);
		}

		return contents;
	}
}