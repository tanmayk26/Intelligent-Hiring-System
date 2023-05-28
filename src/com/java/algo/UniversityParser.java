package com.java.algo;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class UniversityParser 
{

	public static String getUniversity (String inputFileName)
	{
		List<String> universityList = new ArrayList<String>();

		try{
			String data = "";
			Scanner scanner = new Scanner(new File("D:/university.txt"));
			while(scanner.hasNext())
			{
				data = scanner.nextLine();
				data.toLowerCase();
				universityList.add(data);
			}
			scanner.close();

			System.out.println("Total University Words:" + universityList.size());

			scanner = new Scanner(new File(inputFileName));
			while(scanner.hasNext())
			{
				data = scanner.nextLine();
				data = data.replaceAll("\t", " ");
				List<String> wordsList = Arrays.asList(data.split(" "));

				for(String word : wordsList)
				{
					
					//if(universityList.contains(word.trim()))
					if(universityList.contains(word.trim()))
					{
						System.out.println("word:" + word);
						for(String uword : wordsList)
						{
							System.out.println("uword:" + uword);
							uword = uword.trim().toLowerCase();
							if(uword.trim().contains("university") || uword.trim().contains("University"))
							{
								System.out.println("Uniersity" + word);
								scanner.close();
								return word.toLowerCase();
							}
						}
					}					
				}
			}
			scanner.close();
			System.out.println("Done with University...");
		}
		catch(Exception ex){
			ex.getStackTrace();
			System.out.println(ex.getMessage());
		}
		return "pune";
	}
	
	public static void main(String[] args) {
		System.out.println("UniversityParser:" + UniversityParser.getUniversity("D:/R1.txt"));
	}

}
