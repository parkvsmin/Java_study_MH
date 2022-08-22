package com.iu.home.bankAccount;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iu.home.bankMembers.BankMembersDTO;

//@Controller
//@RequestMapping(value = "/bankAccount/*")
//public class BankAccountController {
//	
//	private BankAccountDAO bankAccountDAO;
//	
//	@Autowired
//	BankAccountService bankAccountService;
//	
//	@RequestMapping(value = "add", method = RequestMethod.GET)
//	public String setAccount(HttpSession session) throws Exception {
//		
//		bankAccountService.setAccount((BankAccountDTO) session.getAttribute("member"));
//		return "redirect:../bankbook/list";
//	}
//}
@Controller
@RequestMapping("/bankAccount/*")
public class BankAccountController {
	
	private BankAccountDAO bankAccountDAO;
	
	public BankAccountController() {
		this.bankAccountDAO = new BankAccountDAO();
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(BankAccountDTO bankAccountDTO, HttpSession session)throws Exception{
		System.out.println("BankAccoun Add");
		System.out.println(bankAccountDTO.getBookNum());
		BankMembersDTO bankMembersDTO = (BankMembersDTO)session.getAttribute("bankmembers");
		bankAccountDTO.setUserName(bankMembersDTO.getUserName());
		
		//DTO : userName, bookNum
		int result = this.bankAccountDAO.add(bankAccountDTO);
		
		return "redirect:../bankbook/list";
	}

}