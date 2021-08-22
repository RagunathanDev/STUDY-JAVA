package com.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.dto.FlightBookingReponse;
import com.study.dto.FlightBookingRequest;
import com.study.service.FlightService;

@RestController
@RequestMapping("/flight")
public class FlightBookingController {

	@Autowired
	private FlightService service;

	@PostMapping("/booking")
	public FlightBookingReponse bookTicket(@RequestBody FlightBookingRequest bookingRequest) {
		FlightBookingReponse bookingResponse = null;

		bookingResponse = service.flightBookingService(bookingRequest);

		return bookingResponse;

	}

}
