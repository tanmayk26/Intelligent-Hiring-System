package com.java.algo;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class QualificationParser 
{

	public static ArrayList<String> getQualification (String inputFileName)
	{
		ArrayList<String> techList = new ArrayList<String>();
		List<String> qualificationList = new ArrayList<String>();

		try{
			String data = "";
			Scanner scanner = new Scanner(new File("D:/qualification.txt"));
			while(scanner.hasNext())
			{
				data = scanner.nextLine();
				data.toLowerCase();
				qualificationList.add(data);
			}
			scanner.close();

			System.out.println("Total qualification Words:" + qualificationList.size());

			scanner = new Scanner(new File(inputFileName));
			while(scanner.hasNext())
			{
				data = scanner.nextLine();
								
				List<String> wordsList = Arrays.asList(data.split(" "));

				for(String word : wordsList)
				{
					if(qualificationList.contains(word.trim()))
					{
						System.out.println("Qualification:" + word);
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
		System.out.println("QualificationParser:" + QualificationParser.getQualification("D:/R1.txt"));
	}

}
