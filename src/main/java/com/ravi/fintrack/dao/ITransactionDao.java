package com.ravi.fintrack.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ravi.fintrack.model.Transaction;

@Repository
public interface ITransactionDao extends JpaRepository<Transaction, Integer> {

}
