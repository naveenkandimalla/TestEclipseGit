package com.sais.cashoffice.CashOfficeTest.admin.repository;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.sais.cashoffice.CashOfficeTest.paypointmaster.service.FileService;

@Service
public class testingcsvfile {
	
	public static final Path templatesLocation = Paths.get("DebitFilesTemplates");
	public static final Path creditFilesLocation = Paths.get("PremiumCredits");
	public static final Path resources = Paths.get("Resources");
	
	public boolean savecsv(MultipartFile file) throws Exception {
		
	         Path dirLocation=Paths.get("PremiumCredits");
		
		try{
			
		// step -1 reading the uploded file data 
			String fileName = file.getOriginalFilename();
			InputStream is = file.getInputStream();
			
	  // step -2 		
			 Files.copy(is, dirLocation.resolve(file.getOriginalFilename()),
	                    StandardCopyOption.REPLACE_EXISTING);
			 
			 
	
		}catch(NullPointerException e){
			
		}
				
		
	
		
		
		
		return false;
		
	}
	
	
	public static void main(String[] args){
		
		   Reader reader;
		try {
			reader = new BufferedReader(new FileReader("D:\\backendcode_cashoffice_test\\CashOffice-Test\\PremiumCredits\\C1470219.csv"));
		
			CSVReader csvReader  = new CSVReader(reader);
			 String[] nextRecord;
			while ((nextRecord = csvReader.readNext()) != null) {
				
				 System.out.println("nextRecord : " +nextRecord[0] );
		  
				
			}
			
			 
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
					
		                
		          
		
		
	}

}
