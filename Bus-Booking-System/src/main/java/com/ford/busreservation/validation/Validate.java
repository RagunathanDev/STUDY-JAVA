package com.ford.busreservation.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.ford.busreservation.model.BusDetails;
import com.ford.busreservation.model.BusMaster;

public class Validate {

	public static List<BusMaster> busMasterList = new ArrayList<BusMaster>();

	public boolean isValidForBusMaster(BusMaster busMaster) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<BusMaster>> constraintViolations = validator.validate(busMaster);
		if (constraintViolations.size() > 0) {
			System.out.println(constraintViolations.iterator().next().getMessage());
			return false;
		} else {
			return true;
		}

	}

	public boolean isValidForBusDetails(BusDetails busDetails) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<BusDetails>> constraintViolations = validator.validate(busDetails);
		if (constraintViolations.size() > 0) {
			System.out.println(constraintViolations.iterator().next().getMessage());
			return false;
		} else {
			return true;
		}

	}

}