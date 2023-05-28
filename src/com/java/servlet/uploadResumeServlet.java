package com.java.servlet;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.algo.ARFFCreator;
import com.java.algo.GenderParser;
import com.java.algo.MyC45Prediction;
import com.java.algo.QualificationParser;
import com.java.algo.TechnologiesParser;
import com.java.algo.UniversityParser;
import com.java.algo.WorkExperienceParser;
import com.java.util.Constant;

/**
 * Servlet implementation class uploadResumeServlet
 */
@WebServlet("/uploadResumeServlet")
public class uploadResumeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public uploadResumeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		FileInputStream fis=null;
		String contentType = request.getContentType();
		//here we are checking the content type is not equal to Null and
		//as well as the passed data from mulitpart/form-data is greater than or
		//equal to 0

		if ((contentType != null) && (contentType.indexOf("multipart/form-data") >= 0))
		{
			DataInputStream in = new DataInputStream(request.getInputStream());
			//we are taking the length of Content type data
			int formDataLength = request.getContentLength();
			byte dataBytes[] = new byte[formDataLength];
			int byteRead = 0;
			int totalBytesRead = 0;
			//this loop converting the uploaded file into byte code
			while (totalBytesRead < formDataLength)
			{
				byteRead = in.read(dataBytes, totalBytesRead, formDataLength);
				totalBytesRead += byteRead;
			}
			String file = new String(dataBytes);
			//for saving the file name
			System.out.print("FileNamemayank:" + file.toString());
			String saveFile = file.substring(file.indexOf("filename=\"") + 10);

			System.out.print("FileName xxx:" + saveFile.toString());

			saveFile = saveFile.substring(0, saveFile.indexOf("\n"));

			System.out.print("FileName yyy:" + saveFile.toString());

			saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1,saveFile.indexOf("\""));

			System.out.print("FileName:" + saveFile.toString());
			//System.out.print(dataBytes);

			int lastIndex = contentType.lastIndexOf("=");
			String boundary = contentType.substring(lastIndex + 1,contentType.length());
			int pos;
			//extracting the index of file
			pos = file.indexOf("filename=\"");
			pos = file.indexOf("\n", pos) + 1;
			pos = file.indexOf("\n", pos) + 1;
			pos = file.indexOf("\n", pos) + 1;
			int boundaryLocation = file.indexOf(boundary, pos) - 4;
			int startPos = ((file.substring(0, pos)).getBytes()).length;
			int endPos = ((file.substring(0, boundaryLocation)).getBytes()).length;

			saveFile = Constant.TEMP_DIC_PATH + File.separator + saveFile;
			// creating a new file with the same name and writing the content in new file
			System.out.println("Save File Path:"+saveFile);
			FileOutputStream fileOut = new FileOutputStream(saveFile);
			fileOut.write(dataBytes, startPos, (endPos - startPos));
			fileOut.flush();
			fileOut.close();
			System.out.println("You have successfully upload the file by the name of:"+saveFile);

			String unzipPath = Constant.ZIP_FILE_PATH + File.separator + System.currentTimeMillis();
			File unzipDir = new File(unzipPath);
			unzipDir.mkdirs();
			
			unzip(saveFile,unzipPath);

			///Now run NLP Part..
			File [] files = unzipDir.listFiles();
			
			Map<String, Integer> map = new TreeMap<String, Integer>();
			
			for(File f : files)
			{
				ArrayList<String> techList =  TechnologiesParser.getTechnologies(f.getAbsolutePath());
				String gender = GenderParser.getGender(f.getAbsolutePath());
				ArrayList<String> quaList = QualificationParser.getQualification(f.getAbsolutePath());
				int exp = WorkExperienceParser.getWorkExperienceParser(f.getAbsolutePath());
				String university = UniversityParser.getUniversity(f.getAbsolutePath());
				
				//Now C4.5..
				
				String rating = "0";
				String arffPath = ARFFCreator.generateARFFFile(gender,exp,quaList.get(0),techList.get(0),university);
				try {
					rating = MyC45Prediction.predictRating(arffPath);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				System.out.println("Rating :" + rating);
				
				//if(Integer.parseInt(rating) > 3)
					map.put(f.getAbsolutePath(), Integer.parseInt(rating));
			}
			
			Set set = map.entrySet();
		    Iterator i = set.iterator();

		    while(i.hasNext()) {
		      Map.Entry me = (Map.Entry)i.next();
		      System.out.print(me.getKey() + ": ");
		      System.out.println(me.getValue());
		    }
			
		    
		    HttpSession session = request.getSession();
		    session.setAttribute("resume", map);
			System.out.println("Uploaded successfully !");
			request.setAttribute("flag","success");
			ServletContext ctx = this.getServletContext();
			RequestDispatcher rd = ctx.getRequestDispatcher("/showResume.jsp");
			rd.include(request, response);
			System.out.println("success");
		}
	}
	private static void unzip(String zipFilePath, String destDir) {
		File dir = new File(destDir);
		// create output directory if it doesn't exist
		if(!dir.exists()) dir.mkdirs();
		FileInputStream fis;
		//buffer for read and write data to file
		byte[] buffer = new byte[1024];
		try {
			fis = new FileInputStream(zipFilePath);
			ZipInputStream zis = new ZipInputStream(fis);
			ZipEntry ze = zis.getNextEntry();
			while(ze != null){
				String fileName = ze.getName();
				File newFile = new File(destDir + File.separator + fileName);
				System.out.println("Unzipping to "+newFile.getAbsolutePath());
				//create directories for sub directories in zip
				new File(newFile.getParent()).mkdirs();
				FileOutputStream fos = new FileOutputStream(newFile);
				int len;
				while ((len = zis.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}
				fos.close();
				//close this ZipEntry
				zis.closeEntry();
				ze = zis.getNextEntry();
			}
			//close last ZipEntry
			zis.closeEntry();
			zis.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
