package com.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.dto.FlightBookingReponse;
import com.study.dto.FlightBookingRequest;
import com.study.exception.AmountNotSufficentException;
import com.study.model.PassengerInfo;
import com.study.model.PaymentInfo;
import com.study.repository.PassengerRepo;
import com.study.repository.PaymentRepo;
import com.study.utils.AccountValidation;

@Service
public class FlightService {

	@Autowired
	private PassengerRepo passengerRepo;

	@Autowired
	private AccountValidation validate;

	@Autowired
	private PaymentRepo paymentRepo;

	@Transactional
	public FlightBookingReponse flightBookingService(FlightBookingRequest bookingRequest)
			throws AmountNotSufficentException {
		FlightBookingReponse response = null;
		boolean accountValidate = false;

		response = new FlightBookingReponse();

		PassengerInfo passengerInfo = bookingRequest.getPassengerInfo();

		passengerRepo.save(passengerInfo);

		PaymentInfo paymentInfo = bookingRequest.getPaymentInfo();
		paymentInfo.setPessengerId(passengerInfo.getPId());
		paymentInfo.setAmount(passengerInfo.getFare());

		accountValidate = validate.validateAmount(paymentInfo.getAccountNo(), paymentInfo.getAmount());

		if (accountValidate) {
			paymentRepo.save(paymentInfo);
			response = new FlightBookingReponse("Success", String.valueOf(paymentInfo.getAmount()),
					String.valueOf((int) (Math.random() * (20 - 11 + 1) + 11)), passengerInfo);
		}

		// Used for random number gen between the given digit -> (Math.random() *
		// ((max)20 - (min)11 + 1) + (min)11)

		return response;

	}
}
