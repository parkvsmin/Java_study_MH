package com.iu.home.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.home.board.impl.BoardDTO;


@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	//글목록
	@RequestMapping(value="list.iu", method = RequestMethod.GET)
	public ModelAndView getList()throws Exception {
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> ar =noticeService.getList();
		mv.addObject("list",ar);
		mv.setViewName("notice/list");
		return mv;
	}
	//글상세
	@RequestMapping(value="detail.iu", method = RequestMethod.GET)
	public String getDetail(BoardDTO boardDTO, Model model)throws Exception {
		boardDTO = noticeService.getDetail(boardDTO);
		model.addAttribute("boardDTO",boardDTO);
		return "notice/detail";
	}
	//글작성
	@RequestMapping(value="add.iu", method = RequestMethod.GET)
	public String setAdd()throws Exception{
		return "notice/add";
	}
	
	@RequestMapping(value="add.iu", method = RequestMethod.POST)
	public ModelAndView setAdd(BoardDTO boardDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setAdd(boardDTO);
		mv.setViewName("redirect:./list.iu");
		return mv;
		
	}
	//글수정
	@RequestMapping(value="update.iu")
	public ModelAndView setUpdate(BoardDTO boardDTO, ModelAndView mv)throws Exception {
		boardDTO = noticeService.getDetail(boardDTO);
		mv.addObject("boardDTO",boardDTO);
		mv.setViewName("notice/update");
		return mv;
		
	}
	
	@RequestMapping(value="update.iu", method = RequestMethod.POST)
	public String setUpdate(BoardDTO boardDTO)throws Exception{
		int result = noticeService.setUpdate(boardDTO);
		return "redirect:./notice/detail.iu?num="+boardDTO.getNum();
	}
	//글삭제
    public String setDelete(BoardDTO boardDTO)throws Exception {
    	int result = noticeService.setDelete(boardDTO);
    	return "redirect:./list.iu";
    }
}
