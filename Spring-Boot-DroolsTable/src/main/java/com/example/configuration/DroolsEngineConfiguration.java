package com.example.configuration;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DroolsEngineConfiguration {
	public static final String DRLFILE = "drools/Discount.xlsx";
	
	/**
	 * this is configuration it slowing my response time so i changed to this configuration
	 * 
	 */

//	KieServices kieServices = KieServices.Factory.get();
//
//	private KieFileSystem getKieFileSystem() throws IOException {
//		KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
//		List<String> rules = Arrays.asList(DRLFILE);
//		for (String rule : rules) {
//			kieFileSystem.write(ResourceFactory.newClassPathResource(rule));
//		}
//		return kieFileSystem;
//	}
//
//	public KieContainer getKieContainer() throws IOException {
//		getKieRepository();
//		KieBuilder kb = kieServices.newKieBuilder(getKieFileSystem());
//		kb.buildAll();
//		KieModule kieModule = kb.getKieModule();
//		KieContainer kContainer = kieServices.newKieContainer(kieModule.getReleaseId());
//		return kContainer;
//	}
//
//	private void getKieRepository() {
//		final KieRepository kieRepository = kieServices.getRepository();
//		kieRepository.addKieModule(new KieModule() {
//			public ReleaseId getReleaseId() {
//				return kieRepository.getDefaultReleaseId();
//			}
//		});
//	}
//
//	public KieSession getKieSession() {
//
//		KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
//		kieFileSystem.write(ResourceFactory.newClassPathResource(DRLFILE));
//		KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
//		kieBuilder.buildAll();
//		KieModule kieModule = kieBuilder.getKieModule();
//		KieContainer kContainer = kieServices.newKieContainer(kieModule.getReleaseId());
//		return kContainer.newKieSession();
//	}

	@Bean
	public KieContainer kieContainer() {
		KieServices kieServices = KieServices.Factory.get();
		KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
		kieFileSystem.write(ResourceFactory.newClassPathResource(DRLFILE));
		KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
		kieBuilder.buildAll();
		KieModule kieModule = kieBuilder.getKieModule();
		return kieServices.newKieContainer(kieModule.getReleaseId());
	}
}
