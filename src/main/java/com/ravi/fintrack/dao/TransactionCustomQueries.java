package com.ravi.fintrack.dao;

import java.util.List;
import java.util.Map;

import com.ravi.fintrack.model.SearchCriteria;
import com.ravi.fintrack.model.Transaction;

public interface TransactionCustomQueries {

	List<Transaction> searchTransactionByCriteria(SearchCriteria criteria);
	
	List<Transaction> searchTransactionByCriteria(Map<String, Object> propMap) throws Exception;
}
