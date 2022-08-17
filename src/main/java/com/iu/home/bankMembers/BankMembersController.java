package com.iu.home.bankMembers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
public class BankMembersController {
	
	@Autowired
	private BankMembersService bankMembersService;
	
	@RequestMapping(value="login",method = RequestMethod.GET)
	public String login() {
		System.out.println("로그인");
		return "./member/login";
	}
	
	@RequestMapping(value="login",method = RequestMethod.POST)
	public String login(BankMembersDTO bankMembersDTO,Model model)throws Exception{
		
		bankMembersDTO = bankMembersService.getLogin(bankMembersDTO);
		return "redirect:../";
		
	}

}
