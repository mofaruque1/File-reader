package com.ofp.filereader;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

public class ApacheCommonReader implements Reader {

	public void readFile(String path) {
		long beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		long startTime = System.currentTimeMillis();
		File file = new File(path);
		int lineCounter = 0;
		try {
			LineIterator it = FileUtils.lineIterator(file);
			while (it.hasNext()) {
			      String line = it.nextLine();
			      lineCounter++;
			      System.out.println("Line processed : "+lineCounter);
			      
			   }
		} catch (IOException e) {
			e.printStackTrace();
		}
		long afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		long endTime = System.currentTimeMillis();
		
		System.out.println("|---- APACHE COMMON FILE READER ----|");
		System.out.println("Total no of lines : "+ lineCounter);
		System.out.println("Memory used : " + (afterUsedMem - beforeUsedMem));
		System.out.println("elapsed time : " + (endTime - startTime) + "ms");
	}

	
}
