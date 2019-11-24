package com.ofp.filereader;

/**
 * File reader using 
 * Different Class
 */
public class App 
{
    public static void main( String[] args )
    {
        MyFileReader reader = new MyFileReader();
        String path = "/Users/mdomor.faruque/Desktop/100_Sales_Records.csv";
        reader.processUsingBuffer(path);
        reader.processUsingApache(path);
        reader.processUsingStream(path);      
    }
}
