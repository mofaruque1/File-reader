package com.ofp.filereader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class StreamReader implements Reader {

	public void readFile(String path) {
		long beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		long startTime = System.currentTimeMillis();
		FileInputStream inputStream = null;
		Scanner sc = null;
		int lineCounter = 0;
		try {
			inputStream = new FileInputStream(path);
			sc = new Scanner(inputStream, "UTF-8");
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				lineCounter++;
				System.out.println("Line processed : " + lineCounter);
			}
			if (sc.ioException() != null) {
				throw sc.ioException();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (sc != null) {
				sc.close();
			}
		}

		long afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		long endTime = System.currentTimeMillis();

		System.out.println("|---- STREAM FILE READER ----|");
		System.out.println("Total no of lines : " + lineCounter);
		System.out.println("Memory used : " + (afterUsedMem - beforeUsedMem));
		System.out.println("elapsed time : " + (endTime - startTime) + "ms");

	}

}
