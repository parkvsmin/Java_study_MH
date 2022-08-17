package com.iu.home.bankBook;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/bankbook/*")
public class BankBookController {

	@Autowired
	private BankBookService bankBookService;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getList(Model model) throws Exception {
		List<BankBookDTO> list = bankBookService.getList();
		model.addAttribute("list",list);
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String setBook() throws Exception {
		return "bankbook/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String setBook(BankBookDTO bankBookDTO) throws Exception {
		Calendar ca = Calendar.getInstance();
		bankBookDTO.setBookNum(ca.getTimeInMillis());
		bankBookService.setBook(bankBookDTO);
		return "redirect:list";
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String getDetail(BankBookDTO bankBookDTO, Model model) throws Exception {
		bankBookDTO = bankBookService.getDetail(bankBookDTO);
		model.addAttribute("detail", bankBookDTO);
		
		return "bankbook/detail";
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(BankBookDTO bankBookDTO) throws Exception {
		bankBookService.delete(bankBookDTO);
		return "redirect:list";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String upBook(BankBookDTO bankBookDTO, Model model) throws Exception {
		model.addAttribute("num", bankBookDTO.getBookNum());
		return "bankbook/update";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String upBook(BankBookDTO bankBookDTO) throws Exception {
		bankBookService.upBook(bankBookDTO);
		return "redirect:list";
	}
}