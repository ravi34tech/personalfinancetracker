package com.ravi.fintrack.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ravi.fintrack.model.Transaction;

@Repository
public interface ITransactionDao extends JpaRepository<Transaction, Integer>,TransactionCustomQueries {

	List<Transaction> findByPurchasedDateBetween(Date startDate, Date endDate);

}
