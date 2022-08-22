package com.iu.home.bankAccount;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.home.bankMembers.BankMembersDTO;
import com.iu.home.bankAccount.BankAccountDAO;
import com.iu.home.bankAccount.BankAccountDTO;

@Repository
public class BankAccountDAO implements AccountDAO{

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.home.bankAccount.BankAccountDAO.";

	public List<BankAccountDTO> getListByUserName(BankMembersDTO bankMembersDTO)throws Exception {
		return sqlSession.selectList(NAMESPACE+"getListByUserName", bankMembersDTO);
	}


	@Override
	public int setAccount(BankAccountDTO bankAccountDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(NAMESPACE+"setAccount", bankAccountDTO);
	}

	public int add(BankAccountDTO bankAccountDTO)throws Exception{

		return 0;


	}
}