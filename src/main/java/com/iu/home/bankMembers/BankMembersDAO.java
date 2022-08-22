package com.iu.home.bankMembers;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BankMembersDAO implements MembersDAO {

	@Autowired
	private SqlSession sqlSession;

	private final String NAMESPACE="com.iu.home.bankMembers.BankMembersDAO.";

	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO)throws Exception{

		return sqlSession.selectOne(NAMESPACE+"getLogin", bankMembersDTO);		
	}

	public int setJoin(BankMembersDTO bankMembersDTO)throws Exception{
		// TODO Auto-generated method stub
		return sqlSession.insert(NAMESPACE+"setJoin", bankMembersDTO);
	}

	@Override
	public List<BankMembersDTO> getSearchByID(String search) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+"getSearchByID",search);
	}

	public BankMembersDTO getMyPage(BankMembersDTO bankMembersDTO)throws Exception{

		return sqlSession.selectOne(NAMESPACE+"getMyPage", bankMembersDTO);
	}

	@Autowired
	private BankMembersDAO bankMembersDAO;

	public void getMyPage()throws Exception{
		BankMembersDTO bankMembersDTO = new BankMembersDTO();
		bankMembersDTO.setUserName("id1");
		bankMembersDTO=bankMembersDAO.getMyPage(bankMembersDTO);

	}


}