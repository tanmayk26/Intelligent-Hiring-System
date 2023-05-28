package com.java.algo;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class GenderParser {

	public static String getGender (String inputFileName)
	{
		List<String> WorkExperienceWordList = new ArrayList<String>();
		try{
			String data = "";
			Scanner scanner = new Scanner(new File("D:/gender.txt"));
			while(scanner.hasNext())
			{
				data = scanner.nextLine();
				WorkExperienceWordList.add(data);
			}
			scanner.close();

			System.out.println("Total Gender Words:" + WorkExperienceWordList.size());

			scanner = new Scanner(new File(inputFileName));
			while(scanner.hasNext())
			{
				data = scanner.nextLine();
				data.replaceAll(":"," ");
				data.replaceAll("-"," ");
				data.replaceAll(":-"," ");
				String [] words = data.split(" ");
				List<String> wordsList = Arrays.asList(words);
				
				for(String word : wordsList)
				{
					//System.out.println("word:" + word);
					if(WorkExperienceWordList.contains(word))
					{
						//System.out.println("found Gender word!!!");
						//Now find the number in this line..
						for(String w : wordsList)
						{
							try 
							{
								if(w.equalsIgnoreCase("male"))
								{
									System.out.println("Male");
									return "Male";
								}
								else if(w.equalsIgnoreCase("female"))
								{
									System.out.println("Female");
									return "Female";
								}
							}
							catch (Exception e) 
							{}					
						}
					}					
				}
			}
			scanner.close();
			System.out.println("Done with gender...");
		}
		catch(Exception ex){
			ex.getStackTrace();
			System.out.println(ex.getMessage());
		}
		return "Male";
	}
	
	public static void main(String[] args) {
		System.out.println("Gender Parser:" + GenderParser.getGender("D:/b.txt"));
	}

}
