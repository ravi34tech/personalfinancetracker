package com.ravi.fintrack.service;

import com.ravi.fintrack.bean.FinanceTrackBean;
import com.ravi.fintrack.model.Category;
import com.ravi.fintrack.model.SearchCriteria;
import com.ravi.fintrack.model.Transaction;
import com.ravi.fintrack.util.Response;

public interface IFinanceTrackerService {

	// Transactions....
	Response saveTransaction(FinanceTrackBean trxn) throws Exception;

	Response deleteTransaction(Integer id) throws Exception;

	Response getTransactionByMonth(Integer monthNumber) throws Exception;

	Response filterTransactions(SearchCriteria criteria) throws Exception;
	
	Transaction findTransactionById(Integer id);

	// Category....
	Response saveCategory(FinanceTrackBean category) throws Exception;

	Response deleteCategory(Integer id) throws Exception;

	Response getAllCategories() throws Exception;

	Response filterCategory(FinanceTrackBean bean) throws Exception;
	
	Response filterCategory(String name) throws Exception;

	Category findCatgoryById(Integer id);
}
