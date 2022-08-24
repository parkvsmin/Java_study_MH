package com.iu.home.notice;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.home.MyAbstractTest;
import com.iu.home.board.impl.BoardDTO;
import com.iu.home.board.notice.NoticeDAO;
import com.iu.home.board.notice.NoticeDTO;

public class NoticeDAOTest extends MyAbstractTest {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Test
	public void getCountTest()throws Exception {
		long count = noticeDAO.getCount();
		assertEquals(203, count);
	}

//	@Test
	public void getListTest()throws Exception {
//		List<BoardDTO> ar = noticeDAO.getList();
//		assertNotEquals(0,ar.size());
		
	}
//	@Test
	public void getDetailTest()throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(1L);
		BoardDTO ar = (BoardDTO) noticeDAO.getDetail(noticeDTO);
		assertNotEquals(0,ar);
		
	}
//	@Test
	public void setAddTest()throws Exception {
		
		for(int i=0;i<100;i++) {
			
		
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setTitle("Test"+i);
		noticeDTO.setWriter("Writer"+i);
		noticeDTO.setContents("Contents"+i);
		
		int result = noticeDAO.setAdd(noticeDTO);
		
		if(i%10==0) {
			Thread.sleep(500);
		}
		
		}
		
		System.out.println("Finish!!!");
		
	}
	
	
	

}
