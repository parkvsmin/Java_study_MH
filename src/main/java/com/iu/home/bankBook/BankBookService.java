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
	
	int setBook(BankBookDTO bankBookDTO) throws Exception {
		return bankBookDAO.setBook(bankBookDTO);
	}
	
	BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception {
		return bankBookDAO.getDetail(bankBookDTO);
	}
	
	int delete(BankBookDTO bankBookDTO) throws Exception {
		return bankBookDAO.delete(bankBookDTO);
	}
	
	int upBook(BankBookDTO bankBookDTO) throws Exception {
		return bankBookDAO.upBook(bankBookDTO);
	}
}
