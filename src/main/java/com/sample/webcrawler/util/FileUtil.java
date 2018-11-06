package com.sample.webcrawler.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;

public class FileUtil {

	public static List<String> readInputFile(String path) {
		List<String> lines = null;
		
		try {
			lines = Files.readAllLines(Paths.get(path));
		} catch (IOException ioe) {
			throw new RuntimeException("Application failed to read html");
		}
		return lines;
	}

	public static void writeUrlsToFile(Set<String> webUrls, String outputTextPath) {
		try {
			Path outputPath = Paths.get(outputTextPath);
			Files.write(outputPath,webUrls);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to write to the file");
		}
		
	}

}
