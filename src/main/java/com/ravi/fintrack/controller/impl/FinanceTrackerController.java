package com.ravi.fintrack.controller.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ravi.fintrack.bean.FinanceTrackBean;
import com.ravi.fintrack.controller.IFinanceTracker;
import com.ravi.fintrack.model.SearchCriteria;
import com.ravi.fintrack.service.IFinanceTrackerService;
import com.ravi.fintrack.util.CommonUtil;
import com.ravi.fintrack.util.Constants;
import com.ravi.fintrack.util.Response;

@RestController
@RequestMapping(value="/pfintrack")
@CrossOrigin
public class FinanceTrackerController implements IFinanceTracker {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FinanceTrackerController.class);
	
	@Autowired
	private IFinanceTrackerService financeTrackerService;
	
	@GetMapping(value="/trxnHistoryData/{monthId}")
	public Response trxnHistoryData(@PathVariable int monthId) {
		Response response = null;
		try {
			response = financeTrackerService.getTransactionByMonth(monthId);
		} catch (Exception e) {
			LOGGER.error(Constants.EXCEPTION+" : ",e.getMessage());
			response = CommonUtil.buildFailureResponse(e);
		}
		
		return response;
	}
	
	@Override
	@PostMapping(value="/saveTrxn")
	public Response saveTransaction(@RequestBody FinanceTrackBean bean) {
		LOGGER.info("Saving transaction...");
		Response response = new Response();
		try {
			response = financeTrackerService.saveTransaction(bean);
		} catch (Exception e) {
			LOGGER.error(Constants.EXCEPTION+" : ",e.getMessage());
			response = CommonUtil.buildFailureResponse(e);
		}
		return response;
	}

	@Override
	@GetMapping(value="/deleteTrxn")
	public Response deleteTransaction(@RequestParam Integer id) {
		try {
			return financeTrackerService.deleteTransaction(id);
		} catch (Exception e) {
			LOGGER.error(Constants.EXCEPTION+" : ",e.getMessage());
			return CommonUtil.buildFailureResponse(e);
		}
	}

	@Override
	@GetMapping(value="/getTrxnByMonth/{monthNumber}")
	public Response getTransactionByMonth(@PathVariable Integer monthNumber) {
		try {
			return financeTrackerService.getTransactionByMonth(monthNumber);
		} catch (Exception e) {
			LOGGER.error(Constants.EXCEPTION+" : ",e.getMessage());
			return CommonUtil.buildFailureResponse(e);
		}
	}

	@Override
	@PostMapping(value="/filterTrxn")
	public Response filterTransactions(@RequestBody SearchCriteria criteria) {
		try {
			return financeTrackerService.filterTransactions(criteria);
		} catch (Exception e) {
			LOGGER.error(Constants.EXCEPTION+" : ",e.getMessage());
			return CommonUtil.buildFailureResponse(e);
		}
	}

	@Override
	@PostMapping(value="/saveCategory")
	public Response saveCategory(@RequestBody FinanceTrackBean bean) {
		try {
			return financeTrackerService.saveCategory(bean);
		} catch (Exception e) {
			LOGGER.error(Constants.EXCEPTION+" : ",e.getMessage());
			return CommonUtil.buildFailureResponse(e);
		}
	}

	@Override
	@GetMapping(value="/deleteCategory/{id}")
	public Response deleteCategory(@PathVariable Integer id) {
		try {
			return financeTrackerService.deleteCategory(id);
		} catch (Exception e) {
			LOGGER.error(Constants.EXCEPTION+" : ",e.getMessage());
			return CommonUtil.buildFailureResponse(e);
		}
	}

	@Override
	@GetMapping(value="/getAllCategory")
	public Response getAllCategories() {
		try {
			return financeTrackerService.getAllCategories();
		} catch (Exception e) {
			LOGGER.error(Constants.EXCEPTION+" : ",e.getMessage());
			return CommonUtil.buildFailureResponse(e);
		}
	}
	
	@Override
	@GetMapping(value="/filterCategory")
	public Response filterCategory(@RequestParam String name) {
		try {
			return financeTrackerService.filterCategory(name);
		} catch (Exception e) {
			LOGGER.error(Constants.EXCEPTION+" : ",e.getMessage());
			return CommonUtil.buildFailureResponse(e);
		}
	}
	
	@Override
	@PostMapping(value="/filterCategory")
	public Response filterCategory(@RequestBody FinanceTrackBean bean) {
		try {
			return financeTrackerService.filterCategory(bean);
		} catch (Exception e) {
			LOGGER.error(Constants.EXCEPTION+" : ",e.getMessage());
			return CommonUtil.buildFailureResponse(e);
		}
	}

}
