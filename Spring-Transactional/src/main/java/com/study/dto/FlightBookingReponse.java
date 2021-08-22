package com.study.dto;

import com.study.model.PassengerInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingReponse {

	private String status;
	private String totalfare;
	private String pnrNo;
	private PassengerInfo passengerInfo;
}
