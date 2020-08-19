package com.icin.model;

public class TransactionBetweenAccounts 
{
	
	  private  int transactionAmount;
	  private  int sourceAccountnumber;
	  private  int destinationAccountnumber;
	  private String description;
	  private String IFSC;
	  
	public int getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(int transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public int getSourceAccountnumber() {
		return sourceAccountnumber;
	}
	public void setSourceAccountnumber(int sourceAccountnumber) {
		this.sourceAccountnumber = sourceAccountnumber;
	}
	public int getDestinationAccountnumber() {
		return destinationAccountnumber;
	}
	public void setDestinationAccountnumber(int destinationAccountnumber) {
		this.destinationAccountnumber = destinationAccountnumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIFSC() {
		return IFSC;
	}
	public void setIFSC(String iFSC) {
		IFSC = iFSC;
	}
	  
	  

}
