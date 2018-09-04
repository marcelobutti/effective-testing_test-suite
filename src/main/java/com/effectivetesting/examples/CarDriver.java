package com.effectivetesting.examples;

public class CarDriver {
	public static void main(String[] args) {
		Car myCar = new Car();
		System.out.println("Current rpms: " + myCar.getCurrentRmp());
		myCar.startEngine();
		System.out.println("Current rpms: " + myCar.getCurrentRmp());
	}
}
