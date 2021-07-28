package com.example.services;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Fare;
import com.example.model.TaxiRide;

@Service
public class TaxiRateCalculator {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TaxiRateCalculator.class);
	
	@Autowired
	private KieContainer kieContainer;
	
	public Long calculateFare(TaxiRide taxiRide, Fare rideFare) {
		
		KieSession kieSession = kieContainer.newKieSession();
		
		kieSession.setGlobal("rideFare", rideFare);
		
		kieSession.insert(taxiRide);
		
		kieSession.fireAllRules();
		
		kieSession.dispose();
		Long totalFare = rideFare.getRideFare() + rideFare.getNightSurcharge();
		LOGGER.info(" RIDE FARE IS : {} ",totalFare);
		
		return totalFare;
		
	}

}
