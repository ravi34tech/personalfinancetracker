package com.ravi.fintrack.service.impl;

import static com.ravi.fintrack.util.CommonUtil.buildFailureResponse;
import static com.ravi.fintrack.util.CommonUtil.buildSuccessResponse;
import static com.ravi.fintrack.util.CommonUtil.isNotNullOrEmpty;
import static com.ravi.fintrack.util.CommonUtil.convertToModel;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.fintrack.bean.FinanceTrackBean;
import com.ravi.fintrack.dao.ICategoryDao;
import com.ravi.fintrack.dao.ITransactionDao;
import com.ravi.fintrack.model.Category;
import com.ravi.fintrack.model.SearchCriteria;
import com.ravi.fintrack.model.Transaction;
import com.ravi.fintrack.service.IFinanceTrackerService;

import com.ravi.fintrack.util.Constants;
import com.ravi.fintrack.util.Response;

@Service
public class FinanceTrackerService implements IFinanceTrackerService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FinanceTrackerService.class);

	@Autowired
	private ICategoryDao categoryDao;
	
	@Autowired
	private ITransactionDao transactionDao;
	
	@Override
	public Response saveTransaction(FinanceTrackBean bean) throws Exception {
		Transaction trxn = convertToModel(bean);
		trxn.setCategory(categoryDao.getOne(bean.getCategoryId()));
		transactionDao.save(trxn);
		return buildSuccessResponse(trxn, trxn.getCategory(), Constants.SUCCESS_SAVED);
	}
	
	@Override
	public Transaction findTransactionById(Integer id) {
		Optional<Transaction> optionCate = transactionDao.findById(id);
		return optionCate.isPresent() ? optionCate.get():null;
	}
	
	@Override
	public Response deleteTransaction(Integer id) throws Exception {
		transactionDao.deleteById(id);
		return buildSuccessResponse(Constants.SUCCESS_DELETE);
	}

	@Override
	public Response getTransactionByMonth(Integer monthNumber) throws Exception {
		if(monthNumber == null || monthNumber == 0) {
			return buildFailureResponse("Invalid month...");
		}else {
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.MONTH, monthNumber);
			cal.set(Calendar.DATE,1);
			cal.setTimeInMillis(0);
			Date startDate = cal.getTime();
			cal.set(Calendar.MONTH, monthNumber+1);
			cal.set(Calendar.DATE,1);
			cal.setTimeInMillis(0);
			Date endDate = cal.getTime();
			System.out.println("Start Date : "+startDate+", End date : "+endDate);
			List<Transaction> list = transactionDao.findByPurchasedDateBetween(startDate, endDate);
			return buildTransactionResponse(list);
		}
	}

	@Override
	public Response filterTransactions(SearchCriteria criteria) throws Exception {
		Response response = null;
		if(criteria == null) {
			response = buildSuccessResponse(transactionDao.findAll(),null, ""); 
		}
		return response;
	}

	
/*	 =================================================================
								Category Calls 
	 =================================================================
*/
	
	@Override
	public Response saveCategory(FinanceTrackBean bean) throws Exception {
		Category cat = new Category(bean);
		try {
			if(bean.getCategoryId() == null && isNotNullOrEmpty(categoryDao.findByNameAndDeleted(bean.getCategoryName(), false))){
				return buildFailureResponse("Duplicate category name : "+bean.getCategoryName());
			}
			categoryDao.save(cat);
		}catch (Exception e) {
			LOGGER.error("Error while saving the reocord : ",e);
			return buildFailureResponse(e);
		}
		return buildSuccessResponse(null, cat, 
				bean.getCategoryId() == null ? Constants.SUCCESS_SAVED: Constants.SUCCESS_UPDATE);
	}
	
	@Override
	public Category findCatgoryById(Integer id) {
		Optional<Category> optionCate = categoryDao.findById(id);
		return optionCate.isPresent() ? optionCate.get():null;
	}

	@Override
	public Response deleteCategory(Integer id) throws Exception {
		Category entity = findCatgoryById(id);
		entity.setDeleted(true);
		categoryDao.save(entity);
		return buildSuccessResponse(Constants.SUCCESS_DELETE);
	}

	@Override
	public Response getAllCategories() throws Exception {
		List<Category> categoryList = categoryDao.getActiveCategories();
		return buildSuccessResponse(null, categoryList, Constants.RETRIVED_RECORDS);
	}

	@Override
	public Response filterCategory(FinanceTrackBean bean) throws Exception {
		return buildCategoryResponse(categoryDao.findByCriteria(bean.getCategoryName(),
				bean.getCategoryColor()));
	}

	@Override
	public Response filterCategory(String name) throws Exception {
		return buildCategoryResponse(categoryDao.findByNameAndDeleted(name,false));
	}
	
	private Response buildCategoryResponse(List<Category> categoryList) {
		if(isNotNullOrEmpty(categoryList)) {
			return buildSuccessResponse(null, categoryList, Constants.RETRIVED_RECORDS);
		}
		return buildFailureResponse(Constants.NO_RECORDS);
	}
	
	private Response buildTransactionResponse(List<Transaction> trxnList) {
		if(isNotNullOrEmpty(trxnList)) {
			return buildSuccessResponse(trxnList, null, Constants.RETRIVED_RECORDS);
		}
		return buildFailureResponse(Constants.NO_RECORDS);
	}

}
