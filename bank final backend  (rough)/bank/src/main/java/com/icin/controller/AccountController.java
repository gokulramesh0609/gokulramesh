package com.icin.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.icin.dao.PrimaryAccountDao;
import com.icin.dao.SavingsAccountDao;
import com.icin.model.PrimaryAccount;
import com.icin.model.SavingsAccount;
import com.icin.model.TransactionBetweenAccounts;
import com.icin.service.PrimaryAccountService;
import com.icin.service.SavingsAccountService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController

public class AccountController
{
	String reply="successful";
	
	@Autowired
	PrimaryAccountDao primaryAccountDao;
	
	@Autowired
	SavingsAccountDao SavingsAccountDao;
	
	@Autowired
	private PrimaryAccountService primaryAccountService;
	
	@Autowired
	private SavingsAccountService savingsAccountService;
	
//	@PostMapping("/deposit" )
	@RequestMapping(value = "/deposit/{acctype}/{accno}/{amount}",method=RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:4200")
//    public Object deposit(@RequestParam String accType, @RequestParam String accNo, @RequestParam String amount)
	public Object deposit(@PathVariable("acctype") String accType, @PathVariable("accno") String accNo, @PathVariable("amount") String amount)
	{
	
		if(accType.equals("Primary")) {
			System.out.println(accType);
			primaryAccountService.deposit(Integer.parseInt(accNo) , Long.parseLong(amount));
			PrimaryAccount primaryAcc = primaryAccountService.getAccount(Integer.parseInt(accNo));
			return primaryAcc;
		}	
		else {
			System.out.println(accType);
			savingsAccountService.deposit(Integer.parseInt(accNo) , Long.parseLong(amount));
			SavingsAccount savingsAcc = savingsAccountService.getAccount(Integer.parseInt(accNo));
			return savingsAcc;
		}
			
    }
	
//	@PostMapping("/withdraw" )
	@RequestMapping(value = "/withdraw/{acctype}/{accno}/{amount}",method=RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:4200")
//    public Object withdraw(@RequestParam String accType, @RequestParam String accNo, @RequestParam String amount)
     public Object withdraw(@PathVariable("acctype") String accType, @PathVariable("accno") String accNo, @PathVariable("amount") String amount)
	{
		if(accType.equals("Primary"))
		{
			System.out.println(accType);
			String val = primaryAccountService.withdraw(Integer.parseInt(accNo) , Long.parseLong(amount));
			if(val.equals("Done"))
				{
				PrimaryAccount primaryAcc = primaryAccountService.getAccount(Integer.parseInt(accNo));
				return primaryAcc;
				}
			else 
				{
				return "Insufficient Balance";
				}
		}	
		else 
		{
			System.out.println(accType);
			String val = savingsAccountService.withdraw(Integer.parseInt(accNo) , Long.parseLong(amount));
			if(val.equals("Done")) 
			{
			SavingsAccount savingsAcc = savingsAccountService.getAccount(Integer.parseInt(accNo));
			return savingsAcc;
			}
			else
			{
				return "Insufficient Balance";
			}
		}
	}
	
	 
	
	
//    @GetMapping(path = "/accounts/{accountId}/balance")
	@RequestMapping(value = "/accounts/{accountid}/balance",method=RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:4200")
    public Long retrieveAccountBalance(@PathVariable("accountid") int accountNumber) 
    {
		if(primaryAccountDao.findByAccountNumber(accountNumber)!=null)
			{
			PrimaryAccount account1=primaryAccountDao.findByAccountNumber(accountNumber);
			return account1.getAccountBalance();
			}
		else
		{
			SavingsAccount account2=SavingsAccountDao.findByAccountNumber(accountNumber);
			return account2.getAccountBalance();
		}
    }
		

	@RequestMapping(value = "/transfer",method=RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:4200")
	public TransactionBetweenAccounts transactionBetweenAccounts(@RequestBody TransactionBetweenAccounts obj)
	{
		//int data
		int srcAccountNumber=obj.getSourceAccountnumber();
		int desAccountNumber=obj.getDestinationAccountnumber();
		int amountToTransfer=obj.getTransactionAmount();
		
		//string data
		String srcAc=String.valueOf(srcAccountNumber);
		String desAc=String.valueOf(desAccountNumber);
		String amtToTrans=String.valueOf(amountToTransfer);
		
		System.out.println("srcac: "+srcAc);
		System.out.println("desac: "+desAc);
		System.out.println("amount: "+amountToTransfer);
	
		if(primaryAccountDao.findByAccountNumber(srcAccountNumber)!=null)
		{
			withdraw("Primary", srcAc, amtToTrans);
			if(primaryAccountDao.findByAccountNumber(desAccountNumber)!=null)
			{
			deposit("Primary", desAc, amtToTrans);
			}
			else
			{ 
				deposit("Savings", desAc, amtToTrans);
			}
		}
		else
		{
			withdraw("Savings", srcAc, amtToTrans);
			if(primaryAccountDao.findByAccountNumber(desAccountNumber)!=null)
			{
			deposit("Primary", desAc, amtToTrans);
			}
			else
			{
				deposit("Savings", desAc, amtToTrans);
			}
		}
		
		return obj;
		
	}
	  
}
