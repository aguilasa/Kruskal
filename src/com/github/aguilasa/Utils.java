package com.github.aguilasa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utils {

	public static StringBuilder loadFileToStr(String fileName) {
		StringBuilder content = new StringBuilder();
		try (FileReader file = new FileReader(fileName); BufferedReader in = new BufferedReader(file);) {
			boolean done = false;
			while (!done) {
				String line = in.readLine();
				if (line == null) {
					done = true;
				} else {
					content.append(line.trim() + "\r\n");
				}
			}
		} catch (IOException e1) {
		}
		return content;
	}

	public static List<String> loadFileToList(String fileName) {
		List<String> content = new ArrayList<>();
		try (FileReader file = new FileReader(fileName); BufferedReader in = new BufferedReader(file);) {
			boolean done = false;
			while (!done) {
				String line = in.readLine();
				if (line == null) {
					done = true;
				} else {
					content.add(line.trim());
				}
			}
		} catch (IOException e1) {
		}
		return content;
	}
}
