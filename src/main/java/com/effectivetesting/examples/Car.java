package com.effectivetesting.examples;

public class Car {
	private int rpm;
	private TireSensor tireSensor;
	
    public Car() {
    	rpm = 0;
	}
	
	public int getCurrentRmp() {
		return rpm;
	}
	
	public void startEngine() {
		rpm = 1000;
		System.out.println("Engine started.");
		tireSensor=new TireSensor();
		System.out.println("Tire pressure level:" + tireSensor.getTirePressure());
	}
}
