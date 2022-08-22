package com.iu.home.bankAccount;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.home.bankMembers.BankMembersDAO;
import com.iu.home.bankMembers.BankMembersDTO;

@Service
public class BankAccountService {
	
	@Autowired
	BankAccountDAO bankAccountDAO;
	@Autowired
	BankMembersDAO bankMembersDAO;
	
	public List<BankAccountDTO> getListByUserName (BankMembersDTO bankMembersDTO)throws Exception{
		return bankAccountDAO.getListByUserName(bankMembersDTO);
	}

	int setAccount(BankAccountDTO bankAccountDTO) throws Exception {
		return bankAccountDAO.setAccount(bankAccountDTO);
	}
}
