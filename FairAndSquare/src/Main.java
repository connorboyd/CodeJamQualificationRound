import java.util.*;
import java.io.*;


public class Main {

	private static String inputFile  = "C-large-1.in.txt";
	private static String outputFile = "output.txt";
	private static int sampleSize;
	private static List<Interval> intervals;
	
	public static void main(String[] args) throws IOException
	{
		long time1 = System.currentTimeMillis();
		
		getShitFromFile();
//		System.out.println("Sample size = " + sampleSize);
//		System.out.println("Size = " + intervals.size());
		printShitToFile();
		long time2 = System.currentTimeMillis();
		System.out.println("Done!");
		double elapsed = ((double)(time2 - time1)) / 1000.0d;
		System.out.println(elapsed + " seconds");
		
	}
	
	private static void getShitFromFile() throws IOException
	{
		Scanner myScanner = new Scanner(new FileReader(inputFile));
		sampleSize = myScanner.nextInt();
		intervals = new ArrayList<Interval>(sampleSize);
		for(long i = 0; i < sampleSize; ++i)
		{
			intervals.add(new Interval(myScanner.nextLong(), myScanner.nextLong()));
		}
	}
	
	private static void printShitToFile() throws IOException
	{
		FileWriter myFW = new FileWriter(outputFile);
		
		for(int i = 0; i < sampleSize; ++i)
		{
			myFW.write("Case #" + (i + 1) +": " + intervals.get(i).countInInterval() + "\n");
		}
		
		
		
		myFW.close();
	}

}
