package com.icin.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icin.model.PrimaryAccount;
import com.icin.model.PrimaryTransaction;

@Repository
public interface PrimaryTransactionDao extends JpaRepository<PrimaryTransaction,Long>
{

	List<PrimaryTransaction> findByPrimaryAccount(PrimaryAccount primaryAccount);
}
