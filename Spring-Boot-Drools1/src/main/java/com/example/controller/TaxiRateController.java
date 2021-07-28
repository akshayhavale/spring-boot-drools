package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Fare;
import com.example.model.TaxiRide;
import com.example.services.TaxiRateCalculator;

@RestController
public class TaxiRateController {
	
	@Autowired
	private TaxiRateCalculator taxiRateCalculator;
	
	@PostMapping("/taxi/rate/calculate")
	public Long calculateRate(@RequestBody TaxiRide taxiRide) {
		return taxiRateCalculator.calculateFare(taxiRide, new Fare());
	}

}
