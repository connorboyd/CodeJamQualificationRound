import java.util.*;
import java.io.*;

public class NewMain {

	
	private static String inputFile = "B-large.in.txt";
	private static String outputFile = "output.txt";
	private static int sampleSize;
	private static List<Lawn> lawnList = new ArrayList<Lawn>(sampleSize);
	
	public static void main(String[] args) throws IOException
	{
		for(int i = 0; i < 5; ++i)
		{
			long time1 = System.currentTimeMillis();
			getShitFromFile();
			long time2 = System.currentTimeMillis();
			System.out.println(  (double)(time2 - time1) / 1000.0d + " Seconds" );
		}

	}

	private static void getShitFromFile() throws IOException
	{
		Scanner myScanner = new Scanner(new FileReader(inputFile));
		sampleSize = myScanner.nextInt();
		
		for(int i = 0; i < sampleSize; ++i)
		{
			int rows = myScanner.nextInt();
			int cols = myScanner.nextInt();
			int[][] lawnMatrix = new int[rows][cols];
			for(int r = 0; r < rows; ++r)
			{
				for(int c = 0; c < cols; ++c)
				{
					lawnMatrix[r][c] = myScanner.nextInt();
				}
			}
			lawnList.add(new Lawn(rows, cols, lawnMatrix));
		}
		myScanner.close();
		
		FileWriter myFW = new FileWriter(outputFile);
		for(int i = 0; i < sampleSize; ++i)
		{
			myFW.write("Case #" + (i + 1) + ": ");
			if( lawnList.get(i).isPossible() )
			{
				myFW.write("YES\n");
			}
			else
			{
				myFW.write("NO\n");
			}
		}
		
		myFW.close();
		
	}
}
