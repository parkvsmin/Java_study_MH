package com.iu.home.board.qna;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.home.board.impl.BoardDTO;
import com.iu.home.util.Pager;

import oracle.jdbc.proxy.annotation.Post;

@Controller
@RequestMapping("/qna/*")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "qna";
	}
	
	@PostMapping("reply") //POST
	public String setReply(QnaDTO qnaDTO)throws Exception {
		int result = qnaService.setReply(qnaDTO);
		return "redirect:./list";
	}
	
	@GetMapping("reply") //GET
	public ModelAndView setReply(BoardDTO boardDTO, ModelAndView mv)throws Exception {
		
		mv.addObject("boardDTO", boardDTO);
		mv.setViewName("board/reply");
		return mv;
	}
	
	//글목록
	@RequestMapping(value="list", method = RequestMethod.GET)
	public ModelAndView getList(Pager pager)throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println(pager.getKind());
		System.out.println(pager.getSearch());
		
		List<BoardDTO> ar =qnaService.getList(pager);
		mv.addObject("pager",pager);
		mv.addObject("list",ar);
		mv.addObject("board","Qna");
		mv.setViewName("board/list");
		return mv;
		
		
	}
	//글상세
	@RequestMapping(value="detail", method = RequestMethod.GET)
	public ModelAndView getDetail(BoardDTO boardDTO)throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/detail");
		return mv;
	}
	//글쓰기
	@RequestMapping(value="add", method = RequestMethod.GET)
	public String setAdd()throws Exception {
		return "board/add";
	
	}
	
	@RequestMapping(value="add", method = RequestMethod.POST)
	public ModelAndView setAdd(BoardDTO boardDTO,MultipartFile[]files, HttpSession session)throws Exception {
		ModelAndView mv = new ModelAndView();
		int result =qnaService.setAdd(boardDTO,files,session.getServletContext());
		mv.setViewName("redirect:./list");
		return mv;
		
	}
	//글수정
	@RequestMapping(value="update", method = RequestMethod.GET)
	public ModelAndView setUpdate(BoardDTO boardDTO,ModelAndView mv)throws Exception {
		BoardDTO result =qnaService.getDetail(boardDTO);
		mv.addObject("boardDTO",boardDTO);
		mv.setViewName("board/update");
		return mv;
	}
	
	@RequestMapping(value="update", method = RequestMethod.POST)
	public String setUpdate(BoardDTO boardDTO)throws Exception {
		int result = qnaService.setUpdate(boardDTO);
		return "redirect:./detail?num="+boardDTO.getNum();
	}
	//글삭제
	
	public String setDelete(BoardDTO boardDTO)throws Exception {
		int result = qnaService.setDelete(boardDTO);
		return "redirect./list";
	}
}
