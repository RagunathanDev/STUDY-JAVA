package com.study.dto;

import com.study.model.PassengerInfo;
import com.study.model.PaymentInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingRequest {
	private PassengerInfo passengerInfo;
	private PaymentInfo paymentInfo;

}
