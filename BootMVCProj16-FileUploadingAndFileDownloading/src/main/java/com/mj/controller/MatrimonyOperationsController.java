package com.mj.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mj.entity.MarriageSeekerInfo;
import com.mj.model.MarriageSeeker;
import com.mj.service.IMatrimonyMgmtService;

@Controller
public class MatrimonyOperationsController {
	@Autowired
	private IMatrimonyMgmtService service;
	@Autowired
	private Environment env;
	@Autowired
	private ServletContext sc;
	
	@GetMapping("/")
	public String showHome()
	{
		return "home";
	}
	@GetMapping("/register")
	public String showProfileFormPage(@ModelAttribute("profile") MarriageSeeker seeker)
	{
		return "marriage_seeker_register";
	}
	@PostMapping("/register")
	public String register(@ModelAttribute("profile") MarriageSeeker seeker, Map<String, Object> map) throws Exception
	{
		//get folder location to store files
		String location=env.getProperty("upload.store");
		File locationStore=new File(location);
		//create location folder if it is not already available
		if (!locationStore.exists()) {
			locationStore.mkdir();
		}
		//get original name of uploading files
		MultipartFile resumeFile=seeker.getResume();
		MultipartFile photoFile=seeker.getPhoto();
		
		String originalResumeFileName = resumeFile.getOriginalFilename();
		String resumeFileName = originalResumeFileName != null ? new File(originalResumeFileName).getName() : null;
		String originalPhotoFileName = photoFile.getOriginalFilename();
		String photoFileName = originalPhotoFileName != null ? new File(originalPhotoFileName).getName() : null;
		
		//create InputStreams representing uploaded files
		InputStream resumeInputStream=resumeFile.getInputStream();
		InputStream photoInputStream=photoFile.getInputStream();
		//create OutputStreams pointing destination file on server machine file system
		OutputStream resumeOutputStream=new FileOutputStream(location+"/"+resumeFileName);
		OutputStream photoOutputStream=new FileOutputStream(location+"/"+photoFileName);
		//complete operations among the streams
		IOUtils.copy(resumeInputStream, resumeOutputStream);
		IOUtils.copy(photoInputStream, photoOutputStream);
		//close streams
		resumeInputStream.close();resumeOutputStream.close();
		photoInputStream.close();photoOutputStream.close();
		//create entity class object
		MarriageSeekerInfo info=new MarriageSeekerInfo();
		info.setProfileName(seeker.getProfileName());
		info.setGender(seeker.getGender());
		info.setResumePath(location+"/"+resumeFileName);
		info.setPhotoPath(location+"/"+photoFileName);
		//use service
		String msg=service.registerProfile(info);
		//create model attributes
		map.put("resumeFile", resumeFileName);
		map.put("photoFile", photoFileName);
		map.put("resultMsg", msg);
		//return LVN
		return "show_result";
	}
	@GetMapping("/display")
	public String displayProfiles(Map<String, Object> map)
	{
		Iterable<MarriageSeekerInfo> seekerList=service.getAllProfiles();
		map.put("seekerInfo", seekerList);
		//return LVN
		return "show_profiles";
	}
	@GetMapping("/download")
	public String fileDownload(@RequestParam("file") String filePath, HttpServletResponse res) throws Exception
	{
		System.out.println(filePath);
		//create java.io.File object pointing to the file download
		File file=new File(filePath);
		//get the length of the file and make it as response content length
		res.setContentLengthLong(file.length());
		//get the MIME type of the file to be downloaded and make it as response content type
		String mimeType=sc.getMimeType(filePath);
		mimeType=mimeType!=null?mimeType:"application/octet-stream";
		res.setContentType(mimeType);
		//create inputStream pointing to the file to be downloaded
		InputStream is=new FileInputStream(file);
		//create outputStream pointing to the response object
		OutputStream os=res.getOutputStream();
		//give instruction to browser to make the recieved content as downloadable file
		res.setHeader("Content-Disposition", "attachment;fileName="+file.getName());
		//copy file to download content to response object
		IOUtils.copy(is, os);
		//close streams
		is.close();
		os.close();
		return null;// this indicates response should go to browser directly without taking the support of ViewResolver and view comps
	}

}
