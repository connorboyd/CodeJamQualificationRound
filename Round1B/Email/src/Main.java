import java.io.*;
import java.util.*;

public class Main {

	
	private static List<String> myDict;
	private static String dictName = "garbled_email_dictionary.txt";
	private static int dictSize = 521196;
	private static String in  = "input.txt" ;
	private static String out = "output.txt";
	private static int sampleSize;
	private static List<String> words;
	
	public static void main(String[] args) throws IOException
	{
		System.out.println("Starting...");
		getDictionary();
		System.out.println("Dict done!");
		
		
	}
	
	private static void getDictionary() throws IOException
	{
		Scanner dictScanner = new Scanner(new FileReader(dictName));
		
		myDict = new ArrayList<String>(dictSize);
		
		while(dictScanner.hasNext())
		{
			myDict.add(dictScanner.next());
		}
		dictScanner.close();

	}
	
	private static void getWords() throws IOException
	{
		Scanner myScanner = new Scanner(new FileReader(in));
		sampleSize = myScanner.nextInt();
		words = new ArrayList<String>(sampleSize);
		
		for(int i = 0; i < sampleSize; ++i)
		{
			words.add(myScanner.next());
		}
		
		myScanner.close();
		
		
	}

	
	
}
