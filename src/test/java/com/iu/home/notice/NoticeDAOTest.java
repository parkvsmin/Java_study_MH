package com.iu.home.notice;

import static org.junit.Assert.*;

import java.util.List;

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
	public void getListTest()throws Exception {
		List<BoardDTO> ar = noticeDAO.getList();
		assertNotEquals(0,ar.size());
		
	}
	@Test
	public void getDetailTest()throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(1L);
		BoardDTO ar = (BoardDTO) noticeDAO.getDetail(noticeDTO);
		assertNotEquals(0,ar);
		
	}
	@Test
	public void setAddTest()throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setTitle("Test");
		noticeDTO.setWriter("Writer");
		noticeDTO.setContents("Contents");
		int ar = noticeDAO.setAdd(noticeDTO);
		assertNotEquals(0,ar);
		
	}
	@Test
	public void setUpdateTest()throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(1L);
		int ar = noticeDAO.setUpdate(noticeDTO);
		assertNotEquals(0,ar);
	}
	@Test
	public void setDeleteTest()throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setTitle("Test");
		noticeDTO.setWriter("Writer");
		noticeDTO.setContents("Contents");
		int ar = noticeDAO.setDelete(noticeDTO);
		assertNotEquals(0,ar);
	}
	

}
