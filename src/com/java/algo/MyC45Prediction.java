package com.java.algo;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

import weka.classifiers.trees.J48;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

import com.java.bean.EmployeeProfileBean;
import com.java.dbhelper.EmployeeProfileDbhelper;

public class MyC45Prediction 
{
	public static String predictRating(String arffPath) throws Exception
	{		
		String arffFile = generateResumeArffFile();
		//DataSource source = new DataSource("D:\\1523373243946.arff");
		DataSource source = new DataSource(arffFile);
		Instances traindata = source.getDataSet();
		traindata.setClassIndex(traindata.numAttributes()-1);
		int numClasses = traindata.numClasses();
		for (int i=0;i<numClasses;i++){
			String classValue = traindata.classAttribute().value(i);
			System.out.println("the "+i+"th class value:"+classValue);
		}

		J48 j48 = new J48();
		//LibSVM j48 = new LibSVM();
		j48.buildClassifier(traindata);
		
				
		/**
		 * load test data
		 */
		//DataSource source2 = new DataSource("D:\\1523373243936-unknown.arff");
		DataSource source2 = new DataSource(arffPath);
		Instances testdata = source2.getDataSet();
		testdata.setClassIndex(testdata.numAttributes()-1);
		/**
		 * make prediction
		 */
		String predString = "2";
		for (int j=0;j<testdata.numInstances();j++)
		{
			double actualClass = testdata.instance(j).classValue();

			String actual = testdata.classAttribute().value((int) actualClass);
			Instance newInst = testdata.instance(j);

			double preNB = j48.classifyInstance(newInst);

			predString = testdata.classAttribute().value((int) preNB);
			System.out.println(actual+","+predString);

			System.out.println("Predection Rating: "+predString);
			return predString;
			//System.out.println("preNB:" + preNB + ", " + "actualClass:" + actualClass);
		}
		return predString;
	}

	private static String generateResumeArffFile() 
	{
		EmployeeProfileDbhelper helDbhelper = new EmployeeProfileDbhelper();
		ArrayList<EmployeeProfileBean> emps = helDbhelper.ViewEmployeeProfile();

		try
		{
			String srcFilePath = "D://resume-unknown-template.arff";
			String destFilePath = "D://"+System.currentTimeMillis()+".arff";

			File srcFile = new File(srcFilePath);
			File destFile = new File(destFilePath);

			Files.copy(srcFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

			FileWriter fw = new FileWriter(destFilePath,true); //the true will append the new data

			for(EmployeeProfileBean empBean : emps)
			{
				String newQuafication = ARFFCreator.getNormalizeQua(empBean.getQualification());

				String newLine = empBean.getGender().toLowerCase() + "," 
						+ empBean.getTotal_experience() + "," 
						+ newQuafication.toLowerCase() + "," 
						+ empBean.getTechnology().toLowerCase() + ","
						+ empBean.getUniversity().toLowerCase() + ","
						+ empBean.getRating() + " \n";

				fw.write(newLine);//appends the string to the file
				//fw.write("\n");
			}
			fw.close();
			Thread.sleep(1000);
			return destFilePath;
			
		}
		catch(Exception ioe)
		{
			System.err.println("Exception: " + ioe.getMessage());
		}
		return null;
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(MyC45Prediction.predictRating(""));
	}
}
