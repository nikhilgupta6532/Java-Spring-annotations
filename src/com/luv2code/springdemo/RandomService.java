package com.luv2code.springdemo;

import java.util.Random;

import javax.xml.crypto.Data;

import org.springframework.stereotype.Component;

@Component
public class RandomService implements FortuneService {
	
	//create an array of strings
	private String[] data = {
			"Beware please",
			"Help please",
			"do nothing"
	};
	
	//create a random number generator
	private Random myRandom = new Random();
	
	@Override
	public String getFortune() {
		int index = myRandom.nextInt(data.length);
		
		String theFortune = data[index];
		
		return theFortune;
	}

}
