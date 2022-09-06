package com.iu.home.bankBook;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.iu.home.util.CommentPager;

@Controller
@RequestMapping(value = "/bankbook/*")
public class BankBookController {

	@Autowired
	private BankBookService bankBookService;
	//-----------comment--------------------
//	@PostMapping("commentAdd")
//	public ModelAndView setCommentAdd(BankBookCommentDTO bankBookCommentDTO)throws Exception {
//		ModelAndView mv = new ModelAndView();
//		
//		System.out.println(bankBookCommentDTO.getBookNum());
//		System.out.println(bankBookCommentDTO.getWriter());
//		System.out.println(bankBookCommentDTO.getContents());
//		
//		int result = bankBookService.setCommentAdd(bankBookCommentDTO);
//		mv.addObject("result", result);
//		mv.setViewName("common/ajaxResult");
//		return mv;
//	}
	
	@PostMapping("commentAdd")
	@ResponseBody //return data body로
	public String setCommentAdd(BankBookCommentDTO bankBookCommentDTO)throws Exception {
		ModelAndView mv = new ModelAndView();

		int result = bankBookService.setCommentAdd(bankBookCommentDTO);
		//{}
		String jsonResult="{\"result\":\""+result+"\"}";
		return jsonResult;
	}
	
	//1. JSP에 출력 하고 결과물을 응답으로 전송
//	@GetMapping("commentList")
//	public ModelAndView getCommentList(CommentPager commentPager)throws Exception {
//		ModelAndView mv = new ModelAndView();
//		List<BankBookCommentDTO> ar = bankBookService.getCommentList(commentPager);
//		System.out.println("CommentList");
//		System.out.println(ar.size());
//		mv.addObject("commentList",ar);
//		mv.setViewName("common/commentList");
//		return mv;
	
	@GetMapping("commentList")
	@ResponseBody
	public List<BankBookCommentDTO> getCommentList(CommentPager commentPager)throws Exception {
		List<BankBookCommentDTO> ar = bankBookService.getCommentList(commentPager);
		System.out.println("CommentList");
		System.out.println(ar.size());
		//json{} key value
		//DTO == {}
		// num=1 =={"num":1, "bookNum":123, "writer":"name"}
		
		
		
		return ar;
		
	
	}
	
	
	//--------------------------------------
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