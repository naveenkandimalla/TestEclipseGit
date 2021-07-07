package com.sais.cashoffice.CashOfficeTest.paypointmaster.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {
	public static final Path templatesLocation = Paths.get("DebitFilesTemplates");
	public static final Path creditFilesLocation = Paths.get("PremiumCredits");
	public static final Path resources = Paths.get("Resources");
	
	// this below code is used for store file into server location
	public void store(MultipartFile file,Path dirLocation) {
		try {
			File fileDir=new File(dirLocation.toString());
			if (!fileDir.exists()) {
				boolean createReportDir = fileDir.mkdir();				
			}
			
			// deleting the old file from the server location 
			String filename = file.getOriginalFilename();
			
			System.out.println(filename);
			
			File createnewfile = new File(fileDir,filename);
			
			if (createnewfile.exists()) {
				
				System.out.println("Already file exist");
				boolean deleteexistingfile =  createnewfile.delete();
				System.out.println("we are deleteing the old file---->"+deleteexistingfile);
			}
			
			// below code represents how to move uploaded file to required folder
			Files.copy(file.getInputStream(), dirLocation.resolve(file.getOriginalFilename()));
		} catch (Exception e) {
			throw new RuntimeException("failed to Save the file to server!");
		}
	}
}
