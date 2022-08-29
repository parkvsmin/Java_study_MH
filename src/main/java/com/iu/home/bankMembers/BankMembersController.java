package com.iu.home.bankMembers;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.home.bankAccount.BankAccountDTO;
import com.iu.home.bankAccount.BankAccountService;
import com.iu.home.bankMembers.BankMembersDTO;

@Controller
@RequestMapping(value="/bankmembers/*")
public class BankMembersController {

	@Autowired
	private BankMembersService bankMembersService;
	//	@Autowired
	//	private BankAccountService bankAccountService;

	@RequestMapping(value="myPage", method = RequestMethod.GET)
	public ModelAndView myPage(HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		BankMembersDTO bankMembersDTO = (BankMembersDTO)session.getAttribute("bankmembers");
		bankMembersDTO=bankMembersService.getMyPage(bankMembersDTO);
		//List<BankAccountDTO> ar = bankAccountService.getListByUserName(bankMembersDTO);
		//mv.addObject("list", ar);
		mv.addObject("dto",bankMembersDTO);
		mv.setViewName("bankmembers/myPage");
		return mv;
	}

	@RequestMapping(value="login",method = RequestMethod.GET)
	public String login() {
		System.out.println("로그인");
		return "bankmembers/login";
	}

	@RequestMapping(value="login",method = RequestMethod.POST)
	public String login(HttpSession session,BankMembersDTO bankMembersDTO,Model model)throws Exception{
		bankMembersDTO = bankMembersService.getLogin(bankMembersDTO);
		session.setAttribute("bankmembers", bankMembersDTO);
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
	public String join(BankMembersDTO bankMembersDTO, MultipartFile photo, HttpSession session) throws Exception {
		System.out.println(photo);
		
		System.out.println("upload 파일명 : "+photo.getOriginalFilename());
		System.out.println("upload 파라미터명 : "+photo.getName());
		System.out.println("upload 파일크기 : "+photo.getSize());
		int result = bankMembersService.setJoin(bankMembersDTO, photo, session.getServletContext());

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
