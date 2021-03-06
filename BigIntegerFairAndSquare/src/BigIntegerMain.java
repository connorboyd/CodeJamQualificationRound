import java.util.*;
import java.io.*;


public class BigIntegerMain {

	private static String inputFile  = "C-small-attempt0.in.txt";
	private static String outputFile = "output.txt";
	private static int sampleSize;
	private static List<BigIntegerInterval> intervals;
	
	public static void main(String[] args) throws IOException
	{
		long time1 = System.currentTimeMillis();
		getShitFromFile();
		System.out.println("Sample size = " + sampleSize);
		System.out.println("Size = " + intervals.size());
		printShitToFile();
		System.out.println("Done!");
		long time2 = System.currentTimeMillis();
		System.out.println((time2 - time1) / 1000 + " Seconds");
		
		
	}
	
	private static void getShitFromFile() throws IOException
	{
		Scanner myScanner = new Scanner(new FileReader(inputFile));
		sampleSize = myScanner.nextInt();
		intervals = new ArrayList<BigIntegerInterval>(sampleSize);
		for(long i = 0; i < sampleSize; ++i)
		{
			intervals.add(new BigIntegerInterval(myScanner.nextBigInteger(), myScanner.nextBigInteger()));
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
