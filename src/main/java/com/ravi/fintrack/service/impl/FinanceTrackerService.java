package com.ravi.fintrack.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.fintrack.bean.FinanceTrackBean;
import com.ravi.fintrack.dao.ICategoryDao;
import com.ravi.fintrack.dao.ITransactionDao;
import com.ravi.fintrack.model.Category;
import com.ravi.fintrack.model.SearchCriteria;
import com.ravi.fintrack.model.Transaction;
import com.ravi.fintrack.service.IFinanceTrackerService;
import com.ravi.fintrack.util.CommonUtil;
import com.ravi.fintrack.util.Response;

@Service
public class FinanceTrackerService implements IFinanceTrackerService {

	@Autowired
	private ICategoryDao categoryDao;
	
	@Autowired
	private ITransactionDao transactionDao;
	
	@Override
	public Response saveTransaction(FinanceTrackBean bean) throws Exception {
		Transaction trxn = CommonUtil.convertToModel(bean);
		trxn.setCategory(categoryDao.getOne(bean.getCategory()));
		transactionDao.save(trxn);
		return null;
	}
	

	@Override
	public Response deleteTransaction(Integer id) throws Exception {
		transactionDao.deleteById(id);
		return null;
	}

	@Override
	public Response getTransactionByMonth(Integer monthNumber) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response filterTransactions(SearchCriteria criteria) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response saveCategory(FinanceTrackBean bean) throws Exception {
		Category cat = new Category(bean.getCategoryName(),bean.getCategoryColor());
		categoryDao.save(cat);
		return null;
	}

	@Override
	public Response deleteCategory(Integer id) throws Exception {
		categoryDao.deleteById(id);
		return null;
	}

	@Override
	public Response getAllCategories() throws Exception {
		List<Category> categoryList = categoryDao.findAll();
		return null;
	}

	@Override
	public Response filterCategory(FinanceTrackBean bean) throws Exception {
		return null;
	}

}
