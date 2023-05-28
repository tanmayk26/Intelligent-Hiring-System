package com.java.algo;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class WorkExperienceParser 
{

	public static int getWorkExperienceParser (String inputFileName)
	{
		List<String> WorkExperienceWordList = new ArrayList<String>();
		try{
			String data = "";
			Scanner scanner = new Scanner(new File("D:/work_experience.txt"));
			while(scanner.hasNext())
			{
				data = scanner.nextLine();
				WorkExperienceWordList.add(data);
			}
			scanner.close();

			System.out.println("Total work_experience Words:" + WorkExperienceWordList.size());

			scanner = new Scanner(new File(inputFileName));
			while(scanner.hasNext())
			{
				data = scanner.nextLine();
				String [] words = data.split(" ");
				List<String> wordsList = Arrays.asList(words);
				
				for(String word : wordsList)
				{
					if(WorkExperienceWordList.contains(word))
					{
						System.out.println("found WorkExperience word!!!");
						//Now find the number in this line..
						for(String w : wordsList)
						{
							System.out.println("Exp:" + w);
							try 
							{
								String ss = w.replaceAll("\\+", "");
								return Integer.parseInt(ss.trim());
							} 
							catch (Exception e) 
							{
									
							}					
							
						}
						
					}					
				}
				
			}
			scanner.close();
			System.out.println("Done with expirence...");
		}
		catch(Exception ex){
			ex.getStackTrace();
			System.out.println(ex.getMessage());
		}
		return 0;
	}
	
	public static void main(String[] args) {
		System.out.println("WorkExperienceParser:" + WorkExperienceParser.getWorkExperienceParser("D:/R1.txt"));
	}

}
