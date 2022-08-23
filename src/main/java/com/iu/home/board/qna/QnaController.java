package com.iu.home.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.home.board.impl.BoardDTO;

@Controller
@RequestMapping("./qna/*")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	//글목록
	@RequestMapping(value="list.iu")
	public ModelAndView getList()throws Exception {
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> ar =qnaService.getList();
		mv.addObject("list",ar);
		mv.setViewName("qna/list");
		return mv;
		
		
	}
	//글상세
	@RequestMapping(value="detail.iu")
	public ModelAndView getDetail()throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("qna/detail");
		return mv;
	}
	//글쓰기
	@RequestMapping(value="add.iu", method = RequestMethod.GET)
	public String setAdd()throws Exception {
		return "qna/add";
	
	}
	
	@RequestMapping(value="add.iu", method = RequestMethod.POST)
	public ModelAndView setAdd(BoardDTO boardDTO)throws Exception {
		ModelAndView mv = new ModelAndView();
		int result =qnaService.setAdd(boardDTO);
		mv.setViewName("redirect:./list.iu");
		return mv;
		
	}
	//글수정
	@RequestMapping(value="update.iu", method = RequestMethod.GET)
	public ModelAndView setUpdate(BoardDTO boardDTO,ModelAndView mv)throws Exception {
		int result =qnaService.setUpdate(boardDTO);
		mv.addObject("boardDTO",boardDTO);
		mv.setViewName("qna/update");
		return mv;
	}
	
	@RequestMapping(value="update.iu", method = RequestMethod.POST)
	public String setUpdate(BoardDTO boardDTO)throws Exception {
		int result = qnaService.setUpdate(boardDTO);
		return "redirect:./qna/detail.iu?num="+boardDTO.getNum();
	}
	//글삭제
	
	public String setDelete(BoardDTO boardDTO)throws Exception {
		int result = qnaService.setDelete(boardDTO);
		return "redirect./list.iu";
	}
}
