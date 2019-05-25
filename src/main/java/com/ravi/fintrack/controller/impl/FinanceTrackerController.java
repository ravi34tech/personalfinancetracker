package com.ravi.fintrack.controller.impl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ravi.fintrack.controller.IFinanceTracker;
import com.ravi.fintrack.model.Category;
import com.ravi.fintrack.model.SearchCriteria;
import com.ravi.fintrack.model.Transaction;
import com.ravi.fintrack.util.Response;

@RestController
public class FinanceTrackerController implements IFinanceTracker {

	@Override
	@PostMapping(value="/saveTrxn")
	public Response saveTransaction(Transaction trxn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping(value="/deleteTrxn")
	public Response deleteTransaction(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping(value="/getTrxnByMonth")
	public Response getTransactionByMonth(Integer monthNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@PostMapping(value="/filterTrxn")
	public Response filterTransactions(SearchCriteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@PostMapping(value="/saveCategory")
	public Response saveCategory(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping(value="/deleteCategory")
	public Response deleteCategory(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping(value="/getAllCategory")
	public Response getAllCategories() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	@GetMapping(value="/filterCategory")
	public Response filterCategory(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
