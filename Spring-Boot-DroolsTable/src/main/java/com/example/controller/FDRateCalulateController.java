package com.example.controller;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.configuration.DroolsEngineConfiguration;
import com.example.model.FDInterestRate;

@RestController
public class FDRateCalulateController {

//	@Autowired
//	private DroolsEngineConfiguration droolsEngineConfiguration;
	
	@Autowired
	private KieContainer kieContainer;

	@PostMapping("/calculate")
	public @ResponseBody FDInterestRate getIntrest(@RequestBody FDInterestRate fdInterestRate) {
//		KieSession kieSession = droolsEngineConfiguration.getKieSession();
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(fdInterestRate);
		kieSession.fireAllRules();
		kieSession.dispose();
		return fdInterestRate;
	}

}
