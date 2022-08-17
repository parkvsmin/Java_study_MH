package com.iu.home.bankBook;

import java.util.List;

public interface BookDAO {

	List<BankBookDTO> getList() throws Exception;
	
	int setBook(BankBookDTO bankBookDTO) throws Exception;
}
