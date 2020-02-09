package Coding_Exam_B;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CodingExamB {
	/*
	 * This is a logging program for collecting TODO comments in a program. The program will scan
	 * Through all the files in the Coding_Exam_B/classes package, and collect all the comments that start
	 * with //TODO: and write them to their own file. See the TODO_Log_example.txt file for an idea of what 
	 * the final file output will look like.
	 */
	
	
	public static String getLoggingInfo(String fileName, boolean Addline) throws IOException {
		/*
		 * 1. Complete the getLoggingInfoMethod.
		 *    The method takes in a String for a file and returns a String. 
		 *    The method will open the file a read through it. It will then 
		 *    take all the comments that begin with //TODO: and combine them 
		 *    into one large String. The string will also state the file name and
		 *    the line number for where each TODO was found. 
		*/
		String finalName = "";
		
		if (Addline == true) {
			finalName =   "File: " + fileName;
		}else{
			finalName =  "\n" + "File: " + fileName;
		}
		
		try {
			BufferedReader bf = new BufferedReader(new FileReader(fileName));		
			int trueFalse = 1;
			int lineNum = 0;
			while(trueFalse != 0) {
				String line = bf.readLine();
				lineNum+=1;
				if(line == null) {
					trueFalse = 0;
				}else {
					if(line.contains("TODO") && lineNum>10) {
						finalName+= "\n" +lineNum + ":"+ "   " + line.trim();
					}else if(line.contains("TODO")){
						finalName+= "\n" +lineNum + ":"+ "    " + line.trim();
					}
							
				}
			}
			bf.close();
			return finalName + "\n";
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return finalName + "\n";
		
		
	}
	
	public static void main(String[] args) throws IOException {
		String finalLogString = getLoggingInfo("src/Coding_Exam_B/classes/Camera.java", true);
		finalLogString += getLoggingInfo("src/Coding_Exam_B/classes/RayTracedImageViewer.java", false);
		finalLogString += getLoggingInfo("src/Coding_Exam_B/classes/RayTracer.java", false);
		finalLogString += getLoggingInfo("src/Coding_Exam_B/classes/Vector3.java", false);
		
		/*
		 * 2. Write the finalLogString to a file called TODO_Log.txt. The file should match TODO_Log_example.txt. 
		 */
		System.out.println(finalLogString);
		
		try {
			FileWriter fr = new FileWriter("src/Coding_Exam_B/TODO_Log.txt");
			fr.write(finalLogString);
			fr.close();
		} catch (Exception e) {
			System.out.println("Write broke");
		}
		
	}
}
