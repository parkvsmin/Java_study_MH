package com.iu.home.qna;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.home.MyAbstractTest;
import com.iu.home.board.impl.BoardDTO;
import com.iu.home.board.qna.QnaDAO;
import com.iu.home.board.qna.QnaDTO;

public class QnaDAOTest extends MyAbstractTest {
	
	@Autowired
	private QnaDAO qnaDAO;

	@Test
	public void getListTest()throws Exception {
		List<BoardDTO>ar = qnaDAO.getList();
		assertNotEquals(0,ar.size());
	}
	
	@Test
	public void getDetailTest()throws Exception {
		QnaDTO qnaDTO = new QnaDTO();
		QnaDTO ar =(QnaDTO) qnaDAO.getDetail(qnaDTO);
		assertNotEquals(0, ar);
	}
	
	@Test
	public void setAddTest()throws Exception {
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setTitle("title");
		qnaDTO.setContents("contents");
		qnaDTO.setWriter("writer");
		int result = qnaDAO.setAdd(qnaDTO);
		assertNotEquals(1, result);
}

}
