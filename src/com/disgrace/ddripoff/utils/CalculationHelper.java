package com.disgrace.ddripoff.utils;

import java.util.concurrent.ThreadLocalRandom;

public class CalculationHelper {

	private CalculationHelper(){}
	
	public static int getRandomIntInRange(int min,int max){
		return ThreadLocalRandom.current().nextInt(min, max + 1);
	}
	
	public static int calcRandomIntWithPercent(int value,double percent){
		return ThreadLocalRandom.current().nextInt((int)(value*(1-percent)), (int)(value*(1+percent)) + 1);
	}
	
	
}
