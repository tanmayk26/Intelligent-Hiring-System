package com.java.algo;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class TechnologiesParser {

	public static ArrayList<String> getTechnologies (String inputFileName)
	{
		ArrayList<String> techList = new ArrayList<String>();
		List<String> techTagList = new ArrayList<String>();

		try{
			String data = "";
			Scanner scanner = new Scanner(new File("D:/technologies.txt"));
			while(scanner.hasNext())
			{
				data = scanner.nextLine();
				data.toLowerCase();
				techTagList.add(data);
			}
			scanner.close();

			System.out.println("Total Technology Words:" + techTagList.size());

			scanner = new Scanner(new File(inputFileName));
			while(scanner.hasNext())
			{
				data = scanner.nextLine();
								
				List<String> wordsList = Arrays.asList(data.split(" "));

				for(String word : wordsList)
				{
					//word.toLowerCase();
					if(techTagList.contains(word.trim()))
					{
						System.out.println("Tech:" + word);
						techList.add(word);
					}					
				}
			}
			scanner.close();
			System.out.println("Done with technologies...");
		}
		catch(Exception ex){
			ex.getStackTrace();
			System.out.println(ex.getMessage());
		}
		return techList;
	}

	public static void main(String[] args) {
		System.out.println("TechnologiesParser:" + TechnologiesParser.getTechnologies("D:/R1.txt"));
	}

}
