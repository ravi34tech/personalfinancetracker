package com.ravi.fintrack.controller;

import com.ravi.fintrack.model.Category;
import com.ravi.fintrack.model.SearchCriteria;
import com.ravi.fintrack.model.Transaction;
import com.ravi.fintrack.util.Response;

public interface IFinanceTracker {

	// Transactions....
	
	Response saveTransaction(Transaction trxn);
	
	Response deleteTransaction(Integer id);
	
	Response getTransactionByMonth(Integer monthNumber);
	
	Response filterTransactions(SearchCriteria criteria);
	
	
	// Category....
	
	Response saveCategory(Category category);
	
	Response deleteCategory(Integer id);
	
	Response getAllCategories();
	
	Response filterCategory(String name);
	
	
}
