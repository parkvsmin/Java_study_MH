package com.iu.home.bankBook;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BankBookDAO implements BookDAO{

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.home.bankBook.BankBookDAO.";
	
	@Override
	public List<BankBookDTO> getList() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+"getList");
	}

	@Override
	public int setBook(BankBookDTO bankBookDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(NAMESPACE+"setBook", bankBookDTO);
	}
}