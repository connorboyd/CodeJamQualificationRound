import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
//import Game

public class Solver {

	private static int size;
	private static List<Game> gamesList;
	private static FileWriter myFileWriter;
	
	public static void main(String[] args) throws IOException
	{
		String outputFileName = "output.txt";
		myFileWriter = new FileWriter(outputFileName);
		readFromFile();
		myFileWriter.close();
		System.out.println("Done!");
	}
	
	public static FileWriter getFileWriter()
	{
		return myFileWriter;
	}
	
	private static void readFromFile() throws IOException
	{
		String fileName = "A-large.in.txt";
		Scanner myScanner = new Scanner(new FileReader(fileName));
		size = myScanner.nextInt();
//		System.out.println(size);
//		List<String> games = new ArrayList<String>(size);
		gamesList = new ArrayList<Game>(size);
		
		for(int i = 0; i < size; ++i)	//Create game objects and put them into gamesList
		{
			String gameString = "";
			for(int j = 0; j <= 4; ++j)
			{
				gameString += myScanner.nextLine();
			}
			gamesList.add(new Game(gameString, i + 1));
		}
		
		for(int i = 0; i < size; ++i)
		{
			gamesList.get(i).checkGame();
		}
	}


}
