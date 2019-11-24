package com.ofp.filereader;

public class MyFileReader {

	private Reader bufferedFileReader;
	private Reader streamFileReader;
	private Reader apacheFileReader;

	public MyFileReader() {
		this.bufferedFileReader = new BufferedFileReader();
		this.streamFileReader = new StreamReader();
		this.apacheFileReader = new ApacheCommonReader();
	}

	public void processUsingBuffer(String path) {
		this.bufferedFileReader.readFile(path);
	}

	public void processUsingApache(String path) {
		this.streamFileReader.readFile(path);
	}

	public void processUsingStream(String path) {
		this.apacheFileReader.readFile(path);
	}
}
