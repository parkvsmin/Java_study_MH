package com.iu.home.bankMembers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iu.home.bankMembers.BankMembersDTO;

@Controller
@RequestMapping(value="/bankmembers/*")
public class BankMembersController {

	@Autowired
	private BankMembersService bankMembersService;

	@RequestMapping(value="login",method = RequestMethod.GET)
	public String login() {
		System.out.println("로그인");
		return "bankmembers/login";
	}

	@RequestMapping(value="login",method = RequestMethod.POST)
	public String login(BankMembersDTO bankMembersDTO,Model model)throws Exception{

		bankMembersDTO = bankMembersService.getLogin(bankMembersDTO);
		return "redirect:../";

	}

	@RequestMapping(value="logout", method = RequestMethod.GET)
	public String logout(HttpSession session)throws Exception{
		session.invalidate();
		return "redirect:../";
	}

	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String join() {

		return "bankmembers/join";
	}

	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(BankMembersDTO bankMembersDTO) throws Exception {

		int result = bankMembersService.setJoin(bankMembersDTO);

		return "redirect:./login";
	}

	@RequestMapping(value="search",method=RequestMethod.GET)
	public void getSearchByID() throws Exception {

	}

	@RequestMapping(value="search",method=RequestMethod.POST)
	public String getSearchByID(String search, Model model)throws Exception {
		
		BankMembersDTO bankMembersDTO = new BankMembersDTO();
		List<BankMembersDTO> ar =bankMembersService.getSearchByID(search);
		model.addAttribute("list",ar);
		return "bankmembers/list";
	}
}
