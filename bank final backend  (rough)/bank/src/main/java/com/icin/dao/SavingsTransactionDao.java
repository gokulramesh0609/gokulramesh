package com.icin.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icin.model.SavingsAccount;
import com.icin.model.SavingsTransaction;

@Repository
public interface SavingsTransactionDao extends JpaRepository<SavingsTransaction,Long>
{

	List<SavingsTransaction> findBySavingsAccount(SavingsAccount savingsAccount);
}
