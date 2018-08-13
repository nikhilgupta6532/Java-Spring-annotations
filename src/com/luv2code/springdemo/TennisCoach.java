package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class TennisCoach implements Coach {
	
	@Autowired // --> only for field injection
	@Qualifier("randomService")
	private FortuneService fortuneService;
	
	//define a default constructor
	public TennisCoach() {
		System.out.println(">> inside default constructor");
	}
	
	//define a setter method
	//@Autowired
//	public void setFortuneService(FortuneService fortuneService) {
//		System.out.println(">> inside setter method - setFortuneService");
//		this.fortuneService = fortuneService;
//	}
	
//	public void doSomeCrazyStuff(FortuneService fortuneService) {
//		System.out.println(">> inside setter method - doSomeCrazyStuff");
//		this.fortuneService = fortuneService;
//	}
//	
	
	/*
	@Autowired
	public TennisCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	} */


	// define my init method
	
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("Tennis coach:inside doMyStartupStuff");
	}
	
	
	// define my destroy method
	
	@PreDestroy
	public void doMyCleanStuff() {
		System.out.println("Tennis coach:inside doMyCleanStuff");
	}

	@Override
	public String getDailyWorkout() {
		
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
