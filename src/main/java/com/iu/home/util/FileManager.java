package com.iu.home.util;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.iu.home.file.FileDTO;
@Component
public class FileManager {

	//	@Autowired
	//	private ServletContext servletContext;

	//delete
	public boolean deleteFile(ServletContext servletContext, String path, FileDTO fileDTO)throws Exception {
		String realPath = servletContext.getRealPath(path);
		System.out.println("realPath"+realPath);
		File file = new File(realPath, fileDTO.getFileName());

		return file.delete();
	}


	//save
	//public void saveFile(ServletContext servletContext, String path)throws Exception
	public String saveFile(ServletContext servletContext,String path, MultipartFile multipartFile)throws Exception{
		//1. 실제경로
		String realPath = servletContext.getRealPath(path);
		System.out.println(realPath);
		//2. 폴더(directory) 체크
		File file = new File(realPath);
		if(!file.exists()) {
			file.mkdirs();
		}
		//3. 저장할 파일명 생성
		String fileName=UUID.randomUUID().toString();
		fileName = fileName+"_"+multipartFile.getOriginalFilename();
		//4. HDD에 저장
		file = new File(file, fileName);
		multipartFile.transferTo(file);

		return fileName;
	}

}
