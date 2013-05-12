import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChinaMain {


	private static String in  = "input.txt" ;
	private static String out = "output.txt";
	private static int sampleSize;
	private static ArrayList<TestCase> cases;
	
	public static void main(String[] args)
	{
		System.out.println("Starting! Reading...");
		
		readFromFile();
		
		System.out.println("Done reading!\nStarting writing...");
		
		long time1 = System.currentTimeMillis();
		writeToFile();
		long time2 = System.currentTimeMillis();
		
		System.out.println("Done!");
		
		System.out.println((time2 - time1)/1000.0D + " Seconds");
	}
	
	private static void readFromFile()
	{
		Scanner myScanner;
		try{
			myScanner = new Scanner(new FileReader(in));
			
			sampleSize = myScanner.nextInt();
			cases = new ArrayList<TestCase>(sampleSize);
			
			for(int i = 0; i < sampleSize; ++i)
			{
				int numTribes = myScanner.nextInt();
				ArrayList<Tribe> tribes = new ArrayList<Tribe>(numTribes);
				for(int j = 0; j < numTribes; ++j)
				{
					int di,ni,wi,ei,si,deltad,deltap,deltas;
					di = myScanner.nextInt();
					ni = myScanner.nextInt();
					wi = myScanner.nextInt();
					ei = myScanner.nextInt();
					si = myScanner.nextInt();
					deltad = myScanner.nextInt();
					deltap = myScanner.nextInt();
					deltas = myScanner.nextInt();
					tribes.add(new Tribe(di,ni,wi,ei,si,deltad,deltap,deltas));
				}
				cases.add(new TestCase(tribes));
				
				
				
			}
			
			myScanner.close();
		}
		catch(FileNotFoundException e)
		{
			System.err.println("File not found!");
			System.exit(0);
		}

	}

	private static void writeToFile()
	{
		try
		{
			FileWriter myFW = new FileWriter(out);
			
			for(int i = 0; i < sampleSize; ++i)
			{
				myFW.write("Case #" + (i + 1) + ": ");
				myFW.write("" + cases.get(i).doTestCase());	
				myFW.write("\n");	//Add newline
				
			}
			
			
			myFW.close();
		}
		catch(IOException e)
		{
			System.err.println("IOException in writeToFile! Stack trace:");
			e.printStackTrace();
			System.exit(0);
		}
		
	}
	
}
