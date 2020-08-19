package com.icin.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PrimaryTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date date;
    private Long credit;
    private Long debit;
    private Long balance;

    public PrimaryTransaction() {}

    
	@ManyToOne
    @JoinColumn(name = "primaryaccountid")
    private PrimaryAccount primaryAccount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCredit() {
		return credit;
	}

	public void setCredit(Long credit) {
		this.credit = credit;
	}

	public Long getDebit() {
		return debit;
	}

	public void setDebit(Long debit) {
		this.debit = debit;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	public PrimaryAccount getPrimaryAccount() {
        return primaryAccount;
    }

    public void setPrimaryAccount(PrimaryAccount primaryAccount) {
        this.primaryAccount = primaryAccount;
    }

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


    
    

}
