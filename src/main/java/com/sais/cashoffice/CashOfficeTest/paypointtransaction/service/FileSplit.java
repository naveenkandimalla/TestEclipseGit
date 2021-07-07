package com.sais.cashoffice.CashOfficeTest.paypointtransaction.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sais.cashoffice.CashOfficeTest.CashOfficeTestApplication;

public class FileSplit {
	public static final Path tempDebits = Paths.get("Tempdebits");
	public static final Path premDebits = Paths.get("PremiumDebits");
	public static final Path splitFiles = Paths.get("Split_FilesDir");

	public static final String SPLIT_SOURCE_DIR_KEY = "splitSourceDir";
	public static final String SPLIT_DESTN_DIR_KEY = "splitDestnDir";
	

	private static final Logger LOGGER = LogManager.getLogger(FileSplit.class);

	public static Map<String, String> getSplitFilePath() {

		LOGGER.info("SplitFilePath Method Invoked");
		
		System.out.println("reading existing file positons");
//		System.out.println(premDebits);
//		System.out.println(premDebits.toString());
//		System.out.println(splitFiles);
//		System.out.println(splitFiles.toString());
		System.out.println(premDebits+File.separator+splitFiles.toString()); // very important related to position were our folder path to be files will store
		

		File splitFileDir = new File(premDebits+File.separator+splitFiles.toString());

		if (!splitFileDir.exists()) {
			boolean createSplitFileDir = splitFileDir.mkdir();
			LOGGER.debug("Created Split Files Dir : " + createSplitFileDir);
			System.out.println(" folder is created just now ");
		}
        
		System.out.println("already folder is created ");
		LOGGER.debug("Split File Dir Absolute Path : " + splitFileDir.getAbsolutePath());
		System.out.println(splitFileDir.getAbsolutePath()+"---absolute path");  // actual path where our file stores
		System.out.println(splitFileDir.toString());
		System.out.println(premDebits.toString());
		
		Map<String, String> filePathMap = new HashMap<String, String>();
		filePathMap.put(SPLIT_DESTN_DIR_KEY, splitFileDir.toString());
		filePathMap.put(SPLIT_SOURCE_DIR_KEY, premDebits.toString());
		return filePathMap;

	}

	public static Collection<String> splitFiles(int fileLimit, String fileForSplit, Map<String, String> splitFileMap)
			throws IOException {

		LOGGER.info("splitFiles Method Invoked");
		
		//System.out.println("fileLimit --->"+fileLimit);

		Collection<String> splitfileNames = new ArrayList<String>();
		
		LOGGER.debug("FileName of the file to be split : " + fileForSplit);
	
		String sourceFilePath = splitFileMap.get(SPLIT_SOURCE_DIR_KEY);
		String destinationFilePath = splitFileMap.get(SPLIT_DESTN_DIR_KEY);
		
		System.out.println("source file sourceFilePath from were it should read the data--->"+sourceFilePath);
		System.out.println("destination file  destinationFilePath from were it should write the data--->"+destinationFilePath);

		File inputFile = new File(sourceFilePath + File.separator + fileForSplit);
		
		System.out.println("final absolute file position which we need to read--->"+inputFile.getAbsolutePath());

		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;

		try {
			
			// step 1 we are reading the data from the input given file
			FileReader fileReader = new FileReader(inputFile);
			bufferedReader = new BufferedReader(fileReader);

			int currentFileLimit = 1;
			int fileNumber = 1;
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
			Date date = new Date();
			System.out.println(dateFormat.format(date)+"---formateddate");
			

			File outputFile = new File(destinationFilePath + File.separator + fileNumber + "_" + dateFormat.format(date)
					+ "_" + fileForSplit);
			
			System.out.println("printing absolute path positon were read files need to be write--->"+destinationFilePath + File.separator + fileNumber + "_" + dateFormat.format(date)+ "_" + fileForSplit);
			System.out.println("absolut write file position ---->"+outputFile.getAbsolutePath());
			
			
			// step 2 we are assigning write file
			FileWriter fileWriter = new FileWriter(outputFile);
			bufferedWriter = new BufferedWriter(fileWriter);

			splitfileNames.add(outputFile.getName());

			String readLine = null;
			
			//checking  whether last line is readed or bufferedReader.readLine()
			while ((readLine = bufferedReader.readLine()) != null) {

				bufferedWriter.write(readLine);  // writing the data 
			
				bufferedWriter.write("\n");  	// add space inside the final '\n'

				if (currentFileLimit == fileLimit) {
					currentFileLimit = 0;
					fileNumber++;
					bufferedWriter.close();

					outputFile = new File(destinationFilePath + File.separator + fileNumber + "_"
							+ dateFormat.format(date) + "_" + fileForSplit);
					fileWriter = new FileWriter(outputFile);
					bufferedWriter = new BufferedWriter(fileWriter);
					LOGGER.debug("Creating new file : " + outputFile.getName());

					splitfileNames.add(outputFile.getName());
					continue;
				}

				currentFileLimit++;
			}

			return splitfileNames;
		}

		finally {
			LOGGER.debug("Cleaning up file resources");
			if (bufferedReader != null) {
				bufferedReader.close();
			}

			if (bufferedWriter != null) {
				bufferedWriter.close();
			}
		}

	}

	public static void main(String[] args) {
		FileSplit split = new FileSplit();
		Map<String, String> splitFileMap = new HashMap<String, String>();
//		splitFileMap.put(SPLIT_SOURCE_DIR_KEY,
//				"C:\\Documents and Settings\\admin\\Desktop\\split_test");
//		splitFileMap.put(SPLIT_DESTN_DIR_KEY,
//				"C:\\Documents and Settings\\admin\\Desktop\\split_test");
		
		splitFileMap.put(SPLIT_SOURCE_DIR_KEY,
				"D:\\testingsplit");
		splitFileMap.put(SPLIT_DESTN_DIR_KEY,
				"D:\\testingsplit");
		
		try {
			//Collection<String> fileNames = split.splitFiles(3, "DRTEST01-MAY-2010.txt", splitFileMap);
			Collection<String> fileNames = split.splitFiles(3, "D3380319.txt", splitFileMap);
			LOGGER.debug(fileNames);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
