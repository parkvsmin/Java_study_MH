package com.iu.home.bankMembers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.home.bankAccount.BankAccountDAO;
import com.iu.home.bankMembers.BankMembersDTO;

@Service
public class BankMembersService {

	@Autowired
	private BankMembersDAO bankMembersDAO;
//	@Autowired
//	private BankAccountDAO bankAccountDAO;
	
//	public BankMembersDTO getMyPage(BankMembersDTO bankMembersDTO)throws Exception{
//		Map<String, Object> map = new HashMap<String, Object>();
//		List<BankAccountDTO> ar = bankAccountDAO.getListByUserName(bankMembersDTO);
//		bankMembersDTO = bankMembersDAO.getMyPage(bankMembersDTO);
//		
//		return bankMembersDAO.getMyPage(bankMembersDTO);
	
	
	
	public BankMembersDTO getMyPage(BankMembersDTO bankMembersDTO)throws Exception{
		return bankMembersDAO.getMyPage(bankMembersDTO);
	}

	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO)throws Exception{
		// TODO Auto-generated method stub
		return bankMembersDAO.getLogin(bankMembersDTO);
	}

	public int setJoin(BankMembersDTO bankMembersDTO)throws Exception{

		return bankMembersDAO.setJoin(bankMembersDTO);
	}

	public List<BankMembersDTO> getSearchByID(String search)throws Exception {
		// TODO Auto-generated method stub
		return bankMembersDAO.getSearchByID(search);
	}

}