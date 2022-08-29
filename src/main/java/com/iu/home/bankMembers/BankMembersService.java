package com.iu.home.bankMembers;

import java.io.File;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.home.bankAccount.BankAccountDAO;
import com.iu.home.bankMembers.BankMembersDTO;
import com.iu.home.board.impl.BoardFileDTO;
import com.iu.home.util.FileManager;

@Service
public class BankMembersService {

	@Autowired
	private BankMembersDAO bankMembersDAO;
	@Autowired
	private FileManager fileManager;
//	@Autowired
//	private ServletContext servletContext;
//	@Autowired
//	private BankAccountDAO bankAccountDAO;
	
//	public BankMembersDTO getMyPage(BankMembersDTO bankMembersDTO)throws Exception{
//		Map<String, Object> map = new HashMap<String, Object>();
//		List<BankAccountDTO> ar = bankAccountDAO.getListByUserName(bankMembersDTO);
//		bankMembersDTO = bankMembersDAO.getMyPage(bankMembersDTO);
//		
//		return bankMembersDAO.getMyPage(bankMembersDTO);
	
	
	
	public BankMembersDTO getMyPage(BankMembersDTO bankMembersDTO)throws Exception{
		return bankMembersDAO.getMyPage(bankMembersDTO);
	}

	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO)throws Exception{
		// TODO Auto-generated method stub
		return bankMembersDAO.getLogin(bankMembersDTO);
	}

	public int setJoin(BankMembersDTO bankMembersDTO,MultipartFile photo, ServletContext servletContext)throws Exception{
		int result = bankMembersDAO.setJoin(bankMembersDTO);
		String path="resources/upload/member";
		
			if(! photo.isEmpty()) {
			
			String fileName=fileManager.saveFile(servletContext, path,photo);
			BankMembersFileDTO membersFileDTO = new BankMembersFileDTO();
			membersFileDTO.setFileName(fileName);
			membersFileDTO.setOriName(photo.getOriginalFilename());
			membersFileDTO.setUserName(bankMembersDTO.getUserName());
			bankMembersDAO.setAddFile(membersFileDTO);
			
		}
		//1. HDD 파일을 저장
		// 파일저장시에 경로는 Tomcat기준이 아니라 OS의 기준으로 설정
		// 1) 파일저장 위치
		//	/resources/upload/member
//		// 2) 저장할 폴더의 실제경로 반환(OS기준)
//		String realPath=servletContext.getRealPath("resources/upload/member");
//		System.out.println("realPath : "+ realPath);
//		// 3) 저장할 폴더의 정보를 가지는 자바 객체 생성
//		File file = new File(realPath);
//		
//		// File 첨부가 없을 때 구분
//				if(! photo.isEmpty()) {
//					
//		
//		if(! file.exists()) {
//			file.mkdirs();
//		}
//		
//		// 4) 중복되지 않는 파일명 생성
//		//		--시간, java api,...
//		// java api
//		String fileName=UUID.randomUUID().toString();
//		System.out.println(fileName);
//		
//		//시간
//		Calendar ca = Calendar.getInstance();
//		Long time = ca.getTimeInMillis();
//		
//		fileName = fileName+"-"+photo.getOriginalFilename();
//		System.out.println(fileName);
//		
//		// 5. HDD에 파일 저장
//		// 어느 폴더에 어떤 이름으로 저장할 File 객체 생성
//		file = new File(file, fileName);
//		
//		
//		// 1) MultipartFile 클래스의 transferTo 메서드 사용
//		photo.transferTo(file);
//		// 2) FileCopyUtils 클래스의 copy 메서드 사용
//		
//		//2. 저장된 파일정보를 DB에 저장
//		BankMembersFileDTO membersFileDTO = new BankMembersFileDTO();
//		membersFileDTO.setFileName(fileName);
//		membersFileDTO.setOriName(photo.getOriginalFilename());
//		membersFileDTO.setUserName(bankMembersDTO.getUserName());
//		bankMembersDAO.setAddFile(membersFileDTO);
//		
//	}//isEmpty 끝
		
		return result;
	}

	public List<BankMembersDTO> getSearchByID(String search)throws Exception {
		// TODO Auto-generated method stub
		return bankMembersDAO.getSearchByID(search);
	}

}