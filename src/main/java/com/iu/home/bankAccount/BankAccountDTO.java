package com.iu.home.bankAccount;

import java.sql.Date;

import com.iu.home.bankBook.BankBookDTO;
import com.iu.home.bankMembers.BankMembersFileDTO;

public class BankAccountDTO {
	private Integer accountNum;
	private String userName;
	private Long bookNum;
	private Date accountDate;
	private BankBookDTO bankBookDTO;

	public BankBookDTO getBankBookDTO() {
		return bankBookDTO;
	}
	public void setBankBookDTO(BankBookDTO bankBookDTO) {
		this.bankBookDTO = bankBookDTO;
	}
	public Integer getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(Integer accountNum) {
		this.accountNum = accountNum;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getBookNum() {
		return bookNum;
	}
	public void setBookNum(Long bookNum) {
		this.bookNum = bookNum;
	}
	public Date getAccountDate() {
		return accountDate;
	}
	public void setAccountDate(Date accountDate) {
		this.accountDate = accountDate;
	}
}