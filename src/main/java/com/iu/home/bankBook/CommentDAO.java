package com.iu.home.bankBook;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class CommentDAO {
	
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.home.bankBook.CommentDAO.";
	
	public int commentAdd(BankBookCommentDTO bankBookCommentDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"commentAdd",bankBookCommentDTO);
	}
	
	public List<BankBookCommentDTO> commentList()throws Exception {
		return sqlSession.selectList(NAMESPACE+"commentList");
	}
	
	public int commentUpdate(BankBookCommentDTO bankBookCommentDTO)throws Exception {
		return sqlSession.update(NAMESPACE+"commentUpdate", bankBookCommentDTO);
	}
	
	public int commentDelete(BankBookCommentDTO bankBookCommentDTO)throws Exception {
		return sqlSession.delete(NAMESPACE+"commentDelete", bankBookCommentDTO);
	}
	
	
}
