package com.ofp.filereader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedFileReader implements Reader {

	public void readFile(String path) {
		long beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		long startTime = System.currentTimeMillis();

		BufferedReader reader = null;
		String line = null;
		int lineCounter = 0;

		try {
			reader = new BufferedReader(new FileReader(path));
			while ((line = reader.readLine()) != null) {
				lineCounter++;
				System.out.println("Line processed : " + lineCounter);
			}

		} catch (FileNotFoundException e) {
			System.out.println("File doesnot exist");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		long afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		long endTime = System.currentTimeMillis();

		System.out.println("|---- BUFFERED FILE READER ----|");
		System.out.println("Total no of lines : " + lineCounter);
		System.out.println("Memory used : " + (afterUsedMem - beforeUsedMem));
		System.out.println("elapsed time : " + (endTime - startTime) + "ms");

	}

}
