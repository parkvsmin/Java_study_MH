package com.iu.home.bankMembers;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BankMembersDAO implements MembersDAO {

	@Autowired
	private SqlSession sqlSession;

	private final String NAMESPACE="com.iu.home.bankMembers.BankMembersDAO";

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
		return sqlSession.selectList(NAMESPACE+"search");
	}


}