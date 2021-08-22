package com.study.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.study.exception.AmountNotSufficentException;

@Component
public class AccountValidation {

	private static Map<String, Double> account = new HashMap<String, Double>();

	{
		account.put("acc1", 12000.00);
		account.put("acc2", 14000.00);
		account.put("acc3", 1000.00);
		account.put("acc4", 53000.00);
		account.put("acc5", 6000.00);
	}

	public boolean validateAmount(String accountName, double amount) throws AmountNotSufficentException {

		if (amount < account.get(accountName)) {
			return true;
		} else {
			throw new AmountNotSufficentException("Insufficient Balance in your account");
		}
	}

}
