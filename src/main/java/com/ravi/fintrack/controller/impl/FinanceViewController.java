package com.ravi.fintrack.controller.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ravi.fintrack.service.IFinanceTrackerService;

@Controller
@RequestMapping(value = "/pfintrack")
public class FinanceViewController {

	private static final Logger LOGGER = LoggerFactory.getLogger(FinanceViewController.class);

	@Autowired
	private IFinanceTrackerService financeTrackerService;

	@GetMapping(value = "/")
	public String login() {
		return "login";
	}
	
	@GetMapping(value = "/home")
	public String home() {
		return "home";
	}

	@GetMapping(value = "/newTrxn")
	public String newTransaction(Model model) {
		try {
			model.addAttribute("categories", financeTrackerService.getAllCategories());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "transaction";
	}

	@GetMapping(value = "/category")
	public String newCategory() {
		return "category";
	}

	@GetMapping(value="/trxnHistory")
	public String trxnHistory(Model model) {
		return "transactionHistory";
	}
	
	@GetMapping(value = "/budget")
	public String budget() {
		return "budget";
	}

	@GetMapping(value = "/graphs")
	public String graph() {
		return "graphs";
	}


}
