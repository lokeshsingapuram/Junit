package com.tcs.source;

public class Calculator {

	
	public Integer add(Integer num1,Integer num2) {
		
		return num1+num2;
	}
public Integer multiplication(Integer num1,Integer num2) {
		
		return num1*num2;
	}
public Integer div(int i, int j) {
	
	return i/j;
}
public Integer sub(int i, int j) {
	try {
		Thread.sleep(1100);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return i-j;
}
}
