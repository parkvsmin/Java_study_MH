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
		//1. HDD νμΌμ μ μ₯
		// νμΌμ μ₯μμ κ²½λ‘λ TomcatκΈ°μ€μ΄ μλλΌ OSμ κΈ°μ€μΌλ‘ μ€μ 
		// 1) νμΌμ μ₯ μμΉ
		//	/resources/upload/member
//		// 2) μ μ₯ν  ν΄λμ μ€μ κ²½λ‘ λ°ν(OSκΈ°μ€)
//		String realPath=servletContext.getRealPath("resources/upload/member");
//		System.out.println("realPath : "+ realPath);
//		// 3) μ μ₯ν  ν΄λμ μ λ³΄λ₯Ό κ°μ§λ μλ° κ°μ²΄ μμ±
//		File file = new File(realPath);
//		
//		// File μ²¨λΆκ° μμ λ κ΅¬λΆ
//				if(! photo.isEmpty()) {
//					
//		
//		if(! file.exists()) {
//			file.mkdirs();
//		}
//		
//		// 4) μ€λ³΅λμ§ μλ νμΌλͺ μμ±
//		//		--μκ°, java api,...
//		// java api
//		String fileName=UUID.randomUUID().toString();
//		System.out.println(fileName);
//		
//		//μκ°
//		Calendar ca = Calendar.getInstance();
//		Long time = ca.getTimeInMillis();
//		
//		fileName = fileName+"-"+photo.getOriginalFilename();
//		System.out.println(fileName);
//		
//		// 5. HDDμ νμΌ μ μ₯
//		// μ΄λ ν΄λμ μ΄λ€ μ΄λ¦μΌλ‘ μ μ₯ν  File κ°μ²΄ μμ±
//		file = new File(file, fileName);
//		
//		
//		// 1) MultipartFile ν΄λμ€μ transferTo λ©μλ μ¬μ©
//		photo.transferTo(file);
//		// 2) FileCopyUtils ν΄λμ€μ copy λ©μλ μ¬μ©
//		
//		//2. μ μ₯λ νμΌμ λ³΄λ₯Ό DBμ μ μ₯
//		BankMembersFileDTO membersFileDTO = new BankMembersFileDTO();
//		membersFileDTO.setFileName(fileName);
//		membersFileDTO.setOriName(photo.getOriginalFilename());
//		membersFileDTO.setUserName(bankMembersDTO.getUserName());
//		bankMembersDAO.setAddFile(membersFileDTO);
//		
//	}//isEmpty λ
		
		return result;
	}

	public List<BankMembersDTO> getSearchByID(String search)throws Exception {
		// TODO Auto-generated method stub
		return bankMembersDAO.getSearchByID(search);
	}

}