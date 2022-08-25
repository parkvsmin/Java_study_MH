package com.iu.home.board.notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.home.board.impl.BoardDTO;
import com.iu.home.board.impl.BoardService;
import com.iu.home.util.Pager;

@Service
public class NoticeService implements BoardService {

	@Autowired
	private NoticeDAO noticeDAO;

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		
		Long totalCount = noticeDAO.getCount();
		pager.getNum(totalCount);
		pager.getRowNum();
		// TODO Auto-generated method stub
//		System.out.println("Service page :" + page);
//
//		Long perPage=10L;
//		// 페이지에 10개씩 출력 기준 
//		// page		startRow 		lastRow
//		// 1		1				10
//		// 2		11				20
//		// 3		21				30
//		Long startRow=(page-1)*perPage+1;
//		Long lastRow=page*perPage;
//
//		System.out.println("StartRow :" + startRow);
//		System.out.println("lastRow :" + lastRow);
//
//		Map<String, Long> map= new HashMap<String, Long>();
//		map.put("startRow", startRow);
//		map.put("lastRow", lastRow);
//
//		/***************************
//		 * JSP에 페이지번호를 출력 1 ~ ?
//		 * 1. 글의 총갯수
//		 * 2. 총 페이지수 구하기
//		 * 3. totalBlock 갯수 구하기
//		 * Block  : 1-5 block 6-10 block 11-15 block
//		 * 3. perBlock : 한페이지에 출력할 번호의수
//		 * 4. page로 현재 Block 번호 찾기
//		 * page                curBlock
//		 *  5. curBlock로 시작번호와 끝번호 알아 오기				
//		 * 	
//		 * 	curBlock	startNum 	lastNum
//		 * 	1			1			5
//		 * 	2			6			10
//		 * 	3			11			15
//		 * 
//		 * */
//		Long totalCount = noticeDAO.getCount(); //1.글의 총갯수
//		Long totalPage = totalCount/perPage; //2. 총 페이지수
//		if(totalCount%perPage != 0) {
//			totalPage = totalPage+1;
//			//totalPage++;
//		}
//
//		Long perBlock=5L;						//3.totalBlock 갯수
//		Long totalBlock = totalPage/perBlock;
//		if(totalPage%perBlock != 0) {
//			totalBlock = totalBlock++;
//		}
//
//		Long curBlock = page/perBlock;		//4.page로 현재block번호찾기
//		if(page%perBlock != 0) {
//			curBlock++;
//		}
//
//		Long startNum= (curBlock-1)*perBlock+1; //5.curBlock 시작번호 끝번호
//		Long lastNum = curBlock*perBlock;



		return noticeDAO.getList(pager);

	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.getDetail(boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.setAdd(boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.setDelete(boardDTO);
	}
}
