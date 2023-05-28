package com.java.algo;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;


public class ARFFCreator 
{
	/*public static void main(String[] args) 
	{
		generateARFFFile("male",1,"be","java", "pune");
		try {
			String rating = MyC45Prediction.predictRating();
			System.out.println("rating:" + rating);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	public static String generateARFFFile(String gender, int exp, String qua,
			String tech, String uni) {

		try
		{			
		    String srcFilePath = "D://resume-unknown-template.arff";
		    String destFilePath = "D://"+System.currentTimeMillis()+"-unknown.arff";

		    File srcFile = new File(srcFilePath);
		    File destFile = new File(destFilePath);
		    
		    Files.copy(srcFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
		    	    		    
		    FileWriter fw = new FileWriter(destFilePath,true); //the true will append the new data
		    
		    String newQuafication = getNormalizeQua(qua);
		    
		    String newLine = gender.toLowerCase() + "," 
		    			   + exp + "," 
		    			   + newQuafication.toLowerCase() + "," 
		    			   + tech.toLowerCase() + ","
		    			   + uni.toLowerCase() + ",?";
		    			   
		    fw.write(newLine);//appends the string to the file
		    fw.close();
		    return destFilePath;
		}
		catch(IOException ioe)
		{
		    System.err.println("IOException: " + ioe.getMessage());
		}
		return "";
		
	}
	
	public static String getNormalizeQua(String qua) {

		qua = qua.toLowerCase();
		
		if(qua.equalsIgnoreCase("be") || qua.equalsIgnoreCase("b.e") || qua.equalsIgnoreCase("b.e.") || qua.equalsIgnoreCase("b-tech") || qua.equalsIgnoreCase("btech") || qua.equalsIgnoreCase("bachelor"))
			return "be";
		else if(qua.equalsIgnoreCase("me") || qua.equalsIgnoreCase("m.e") || qua.equalsIgnoreCase("m.e.") || qua.equalsIgnoreCase("m-tech") || qua.equalsIgnoreCase("mtech") || qua.equalsIgnoreCase("master"))
			return "me";
		else 
			return "be";
	}
}


