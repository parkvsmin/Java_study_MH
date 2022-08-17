package com.iu.home.bankAccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAccountService {
	
	@Autowired
	BankAccountDAO bankAccountDAO;

	int setAccount(BankAccountDTO bankAccountDTO) throws Exception {
		return bankAccountDAO.setAccount(bankAccountDTO);
	}
}
