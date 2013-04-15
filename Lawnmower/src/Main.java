import java.util.*;
import java.io.*;

public class Main {

	
	private static String inputFile = "B-large.in.txt";
	private static String outputFile = "output.txt";
	private static int sampleSize;
	private static List<Lawn> lawnList = new ArrayList<Lawn>(sampleSize);
	
	public static void main(String[] args) throws IOException
	{
		getShitFromFile();
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
		
		for(int i = 0; i < sampleSize; ++i)
		{
			System.out.print("Case #" + (i + 1) + ": ");
			if( lawnList.get(i).isPossible() )
			{
				System.out.println("YES");
			}
			else
			{
				System.out.println("NO");
			}
		}
		
	}
}
