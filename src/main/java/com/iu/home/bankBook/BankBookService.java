package com.iu.home.bankBook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankBookService {
	
	@Autowired
	BankBookDAO bankBookDAO;
	
	List<BankBookDTO> getList() throws Exception {
		return bankBookDAO.getList();
	}
}
