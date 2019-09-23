package com.ravi.fintrack.util;

import java.util.Collection;
import java.util.List;

import com.ravi.fintrack.bean.FinanceTrackBean;
import com.ravi.fintrack.model.Category;
import com.ravi.fintrack.model.Transaction;

public interface CommonUtil {


	public static <T> boolean isNulllOrEmpty(Collection<T> list) {
		return list == null || list.size() == 0;
	}

	public static <T> boolean isNotNullOrEmpty(Collection<T> list) {
		return !isNulllOrEmpty(list);
	}

	public static boolean isStringNullOrEmpty(String str) {
		return str == null || str.length() == 0;
	}

	public static boolean isStringNotNullOrEmpty(String str) {
		return !isStringNullOrEmpty(str);
	}

	public static Transaction convertToModel(FinanceTrackBean bean) {
		Transaction model = new Transaction();
		model.setId(bean.getId());
		model.setAmount(bean.getAmount());
		// model.setCategory(category);
		model.setDescription(bean.getDescription());
		model.setPurchasedDate(bean.getPurchasedDate());
		model.setTrxType(bean.getTrxType());
		return model;
	}

	public static FinanceTrackBean convertToBean(Transaction model) {
		FinanceTrackBean bean = new FinanceTrackBean();
		bean.setId(model.getId());
		bean.setAmount(model.getAmount());
		bean.setCategoryId(model.getCategory().getId());
		bean.setDescription(model.getDescription());
		bean.setPurchasedDate(model.getPurchasedDate());
		bean.setTrxType(model.getTrxType());
		return bean;
	}

	public static Response buildSuccessResponse(List<Transaction> trxnList, List<Category> categoryList,
			String message) {
		Response response = new Response();
		response.setStatus(Constants.SUCCESS);
		response.setStatusMessage(message);
		response.setCategoryList(categoryList);
		response.setTrxnList(trxnList);
		return response;
	}

	public static Response buildSuccessResponse(Transaction transaction, Category category, String message) {
		Response response = new Response();
		response.setStatus(Constants.SUCCESS);
		response.setStatusMessage(message);
		response.setTransaction(transaction);
		response.setCategory(category);
		return response;
	}

	public static Response buildSuccessResponse(FinanceTrackBean finTrxnBean, String message) {
		Response response = new Response();
		response.setStatus(Constants.SUCCESS);
		response.setStatusMessage(message);
		response.setFinTrxnBean(finTrxnBean);
		return response;
	}

	public static Response buildSuccessResponse(String message) {
		Response response = new Response();
		response.setStatus(Constants.SUCCESS);
		response.setStatusMessage(message);
		return response;
	}

	public static Response buildFailureResponse(String failureMessage) {
		Response response = new Response();
		response.setStatus(Constants.FAIL);
		response.setStatusMessage(failureMessage);
		return response;
	}

	public static Response buildFailureResponse(Exception e) {
		Response response = new Response();
		response.setStatus(Constants.FAIL);
		response.setStatusMessage(Constants.EXCEPTION + " : " + e.getMessage());
		return response;
	}

}
