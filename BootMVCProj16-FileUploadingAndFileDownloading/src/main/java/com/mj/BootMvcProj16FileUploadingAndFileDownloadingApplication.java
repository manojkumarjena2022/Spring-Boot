package com.mj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@SpringBootApplication
public class BootMvcProj16FileUploadingAndFileDownloadingApplication {

	@Bean("multipartResolver")
	public CommonsMultipartResolver createCMResolver()
	{
		System.out.println("BootMvcProj16FileUploadingAndFileDownloadingApplication.createCMResolver()");
		CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(-1);//-1 indicates no limit
		multipartResolver.setMaxUploadSizePerFile(20*1024*1024);//-1 indicates no limit
		multipartResolver.setPreserveFilename(true);
		return multipartResolver;
	}
	public static void main(String[] args) {
		SpringApplication.run(BootMvcProj16FileUploadingAndFileDownloadingApplication.class, args);
	}

}
