package com.icin.serviceImpl;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icin.dao.PrimaryAccountDao;
import com.icin.dao.PrimaryTransactionDao;
import com.icin.model.PrimaryAccount;
import com.icin.model.PrimaryTransaction;
import com.icin.model.User;
import com.icin.service.PrimaryAccountService;
import com.icin.service.UserService;

@Service
public class PrimaryAccountServiceImpl implements PrimaryAccountService {

	 @Autowired
	 private PrimaryAccountDao primaryAccountDao;
	   
	 @Autowired
	 private UserService userService;
     private static int nextAccountNumber = 22113344;
     
     @Autowired
     private PrimaryTransactionDao PrimaryTransactionDao; 
     
     
     
     
	@Override
	public PrimaryAccount createPrimaryAccount() {
		PrimaryAccount primaryAccount = new PrimaryAccount();
        primaryAccount.setAccountBalance(new Long(0));
        primaryAccount.setAccountNumber(++nextAccountNumber);
        primaryAccountDao.save(primaryAccount);
        return primaryAccountDao.findByAccountNumber(primaryAccount.getAccountNumber());
	}

	@Override
	public List<PrimaryAccount> getAllPrimaryAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deposit(Integer accNo, Long amount) 
	{
		PrimaryTransaction PrimaryTransaction =new PrimaryTransaction(); 
		//System.out.println(accNo);
      	PrimaryAccount primaryAccount = primaryAccountDao.findByAccountNumber(accNo);
        primaryAccount.setAccountBalance((long) (primaryAccount.getAccountBalance() + amount) );
        primaryAccountDao.save(primaryAccount);
               
        Date date = new Date();
        PrimaryTransaction.setDate(date);
        PrimaryTransaction.setCredit(amount);
        PrimaryTransaction.setBalance(primaryAccount.getAccountBalance());
        PrimaryTransaction.setPrimaryAccount(primaryAccount);
        PrimaryTransactionDao.save(PrimaryTransaction);
		
	}

	@Override
	public String withdraw(Integer accNo, Long amount)
	{
		PrimaryTransaction PrimaryTransaction =new PrimaryTransaction(); 
		PrimaryAccount primaryAccount = primaryAccountDao.findByAccountNumber(accNo);
		if(primaryAccount.getAccountBalance()>=amount) {
	        primaryAccount.setAccountBalance((long) (primaryAccount.getAccountBalance() - amount) );
	        primaryAccountDao.save(primaryAccount);
	        
	        Date date = new Date();
	        PrimaryTransaction.setDate(date);
	        PrimaryTransaction.setDebit(amount);
	        PrimaryTransaction.setBalance(primaryAccount.getAccountBalance());
	        PrimaryTransaction.setPrimaryAccount(primaryAccount);
	        PrimaryTransactionDao.save(PrimaryTransaction);
	        return "Done";
		} else {
			return "Insufficient Balance";
		}

		
	}

	@Override
	public PrimaryAccount getAccount(int accNo) {
		return primaryAccountDao.findByAccountNumber(accNo);
	}



}
