package by.htp.library.main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class TestMain {
	
	public static void main(String[] args) {
		try {
			System.out.println(Files.lines(Paths.get("data/empty.txt")).count() == 0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
