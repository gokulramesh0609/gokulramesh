package com.icin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.icin.dao.PrimaryAccountDao;
import com.icin.dao.PrimaryTransactionDao;
import com.icin.dao.SavingsAccountDao;
import com.icin.dao.SavingsTransactionDao;
import com.icin.model.PrimaryAccount;
import com.icin.model.PrimaryTransaction;
import com.icin.model.SavingsAccount;
import com.icin.model.SavingsTransaction;

@RestController
public class TransactionController 
{
	@Autowired
	PrimaryTransactionDao PrimaryTransactionDao;
	
	@Autowired
	SavingsTransactionDao SavingsTransactionDao;
	
	@Autowired
	PrimaryAccountDao PrimaryAccountDao;
	
	@Autowired
	SavingsAccountDao SavingsAccountDao;
	
	@RequestMapping(value = "/accounts/{accountid}/transactionsprimary",method=RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:4200")
	public List<PrimaryTransaction>  getTransactionspimary(@PathVariable("accountid") int accountNumber)
	{
			PrimaryAccount PrimaryAccount=new PrimaryAccount(); 
			PrimaryAccount= PrimaryAccountDao.findByAccountNumber(accountNumber);
			return (List<PrimaryTransaction>) PrimaryTransactionDao.findByPrimaryAccount(PrimaryAccount);
	}
	
	@RequestMapping(value = "/accounts/{accountid}/transactionssavings",method=RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:4200")
	public List<SavingsTransaction>  getTransactionssecondary(@PathVariable("accountid") int accountNumber)
	{
			SavingsAccount SavingsAccount=new SavingsAccount(); 
			SavingsAccount=SavingsAccountDao.findByAccountNumber(accountNumber);
			return (List<SavingsTransaction>) SavingsTransactionDao.findBySavingsAccount(SavingsAccount);
	}
	
	

	
	
	

}
