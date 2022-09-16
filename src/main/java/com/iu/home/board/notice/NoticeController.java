package com.iu.home.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.home.bankMembers.BankMembersDTO;
import com.iu.home.board.impl.BoardDTO;
import com.iu.home.board.impl.BoardFileDTO;
import com.iu.home.util.Pager;


@Controller
@RequestMapping("/notice/*")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	private HttpSession session;

	@ModelAttribute("board")
	public String getBoard() {
		return "notice";
	}

	@PostMapping("fileDelete")
	@ResponseBody
	public int setFileDelete(BoardFileDTO boardFileDTO, HttpSession session)throws Exception {
		int result = noticeService.setFileDelete(boardFileDTO, session.getServletContext());
		return result;
	}

	//글목록
	@RequestMapping(value="list", method = RequestMethod.GET)
	public ModelAndView getList(Pager pager)throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println(pager);
		//		System.out.println("page : " + page);
		System.out.println(pager.getKind());
		System.out.println(pager.getSearch());
		//		
		List<BoardDTO> ar =noticeService.getList(pager);
		mv.addObject("pager", pager);
		mv.addObject("list",ar);
		mv.setViewName("board/list");

		//		if(ar.size() !=0) {
		//			throw new Exception();
		//		}
		return mv;
	}
	//글상세
	@RequestMapping(value="detail", method = RequestMethod.GET)
	public String getDetail(BoardDTO boardDTO, Model model)throws Exception {
		boardDTO = noticeService.getDetail(boardDTO);
		model.addAttribute("boardDTO",boardDTO);
		return "board/detail";
	}
	//글작성
	@RequestMapping(value="add", method = RequestMethod.GET)
	public String setAdd(HttpSession session)throws Exception{
		BankMembersDTO bankMembersDTO=(BankMembersDTO)session.getAttribute("bankmembers");
		if(bankMembersDTO != null) {
			return "board/add";
		}else {
			return "redirect:../bankmembers/login";
		}


	}

	@RequestMapping(value="add", method = RequestMethod.POST)
	public ModelAndView setAdd(BoardDTO boardDTO, MultipartFile [] files,HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setAdd(boardDTO,files,session.getServletContext());
		//mv.setViewName("redirect:./list");
		String message="등록실패";

		if(result > 0) {
			message="등록성공";	
		}
		mv.addObject("result", result);
		mv.addObject("message", message);
		mv.addObject("url", "list");
		mv.setViewName("common/result");

		return mv;

	}

	//글수정
	@RequestMapping(value="update")
	public ModelAndView setUpdate(BoardDTO boardDTO, ModelAndView mv)throws Exception {
		boardDTO = noticeService.getDetail(boardDTO);
		mv.addObject("boardDTO",boardDTO);
		mv.setViewName("board/update");
		return mv;

	}

	@RequestMapping(value="update", method = RequestMethod.POST)
	public String setUpdate(BoardDTO boardDTO, MultipartFile[]files, HttpSession session)throws Exception{
		int result = noticeService.setUpdate(boardDTO,files, session.getServletContext());
		return "redirect:./detail?num="+boardDTO.getNum();
	}
	
	//글삭제
	@GetMapping("delete")
	public String setDelete(BoardDTO boardDTO)throws Exception {
		int result = noticeService.setDelete(boardDTO);
		return "redirect:./list";
	}
}
