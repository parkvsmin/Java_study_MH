package com.iu.home.bankAccount;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/account/*")
public class BankAccountController {
	
	@Autowired
	BankAccountService bankAccountService;
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String setAccount(HttpSession session) throws Exception {
		
		bankAccountService.setAccount((BankAccountDTO) session.getAttribute("member"));
		return "redirect:../bankbook/list";
	}
}