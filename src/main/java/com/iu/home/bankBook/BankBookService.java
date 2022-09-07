package com.iu.home.bankBook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.home.util.CommentPager;

@Service
public class BankBookService {
	
	
	//--------------comment----------------------
	@Autowired
	private BankBookCommentDAO bankBookCommentDAO;
	
	public List<BankBookCommentDTO> getCommentList(CommentPager commentPager)throws Exception {
		commentPager.getRowNum();
		Long totalCount = bankBookCommentDAO.getCommentListTotalCount(commentPager);
		commentPager.makePage(totalCount);
		return bankBookCommentDAO.getCommentList(commentPager);
	}
	
	
	public int setCommentAdd(BankBookCommentDTO bankBookCommentDTO)throws Exception {
		return bankBookCommentDAO.setCommentAdd(bankBookCommentDTO);
		
	}
	
	int setCommentUpdate(BankBookCommentDTO bankBookCommentDTO) throws Exception {
		return bankBookCommentDAO.setCommentUpdate(bankBookCommentDTO);
	}
	
	int setCommentDelete(BankBookCommentDTO bankBookCommentDTO) throws Exception {
		return bankBookCommentDAO.setCommentDelete(bankBookCommentDTO);
	}
	
	
	//-------------------------------------------
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
