package com.mj.runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mj.entity.MarriageSeeker;
import com.mj.service.IMarriageSeekerMgmtService;
@Component
public class MarriageSeekerRunner implements CommandLineRunner {
	@Autowired
	IMarriageSeekerMgmtService service;
	@Override
	public void run(String... args) throws Exception {
		/*Scanner scn=new Scanner(System.in);
		System.out.println("Enter name :");
		String name=scn.next();
		System.out.println("Enter Address :");
		String address=scn.next();
		System.out.println("Is indian ? true or false");
		Boolean indian=scn.nextBoolean();
		System.out.println("Enter your photo complete path :");
		String photoPath=scn.next().replace("?", "");
		System.out.println("Enter Biodata file complete path :");
		String bioDataPath=scn.next().replace("?", "");
		//prepare byte[] for photo path
		InputStream is=new FileInputStream(photoPath);
		byte[] photoDataContent=new byte[is.available()];
		//prepare char[] for bioData path
		File file=new File(bioDataPath);
		Reader reader=new FileReader(file);
		char[] bioDataContent=new char[(int)file.length()];
		reader.read(bioDataContent);
		MarriageSeeker seeker=new MarriageSeeker(name, 
				address, 
				indian,
				LocalDateTime.of(1996, 4, 29, 11, 10),
				photoDataContent, bioDataContent);
		System.out.println(service.registerMarrigeSeeker(seeker));*/
		System.out.println("=========================================");
		Optional<MarriageSeeker> opt=service.searchMarriageSeekerById(41L);
		if(opt.isPresent())
		{
			MarriageSeeker seeker=opt.get();
			System.out.println(seeker.getName()+" "+seeker.getAddrs()+" "+seeker.getIndian());
			OutputStream os=new FileOutputStream("retrieved_photo.jpg");
			os.write(seeker.getPhoto());
			os.flush();
			Writer writer=new FileWriter("retrieved_txt.txt");
			writer.write(seeker.getBiodata());
			writer.flush();
			writer.close();
			os.close();
			System.out.println("Data fetched");
		}
		else
		{
			System.out.println("No record found.");
		}
	}

}
