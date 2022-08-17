package com.iu.home.bankBook;

import java.util.List;

public interface BookDAO {

	List<BankBookDTO> getList() throws Exception;
	
	int setBook(BankBookDTO bankBookDTO) throws Exception;
	
	BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception;
	
	int delete(BankBookDTO bankBookDTO) throws Exception;
	
	int upBook(BankBookDTO bankBookDTO) throws Exception;
}
