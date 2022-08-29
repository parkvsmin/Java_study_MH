package com.iu.home.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.home.board.impl.BoardDTO;
import com.iu.home.util.Pager;


@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "notice";
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
	public String setAdd()throws Exception{
		return "board/add";
	}
	
	@RequestMapping(value="add", method = RequestMethod.POST)
	public ModelAndView setAdd(BoardDTO boardDTO, MultipartFile [] files,HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setAdd(boardDTO,files,session.getServletContext());
		mv.setViewName("redirect:./list");
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
	public String setUpdate(BoardDTO boardDTO)throws Exception{
		int result = noticeService.setUpdate(boardDTO);
		return "redirect:./detail?num="+boardDTO.getNum();
	}
	//글삭제
	@GetMapping("delete")
    public String setDelete(BoardDTO boardDTO)throws Exception {
    	int result = noticeService.setDelete(boardDTO);
    	return "redirect:./list";
    }
}
