package com.effectivetesting.examples;

public class CarDriver {
	public static void main(String[] args) {
		Car myCar = new Car();
		Car myC2 = new Car();
		myC2.isDiesel=true;
		myC2.segment="Suv";
		System.out.println(myCar.type);
		System.out.println(myCar.wheels + myCar.type);
		
		if (myCar.isDiesel == true) {
			System.out.println("Use Infinia Diesel");
		} else {
			System.out.println("Use Infinia Nafta");
		}
		
		if (myC2.isDiesel == true) {
			System.out.println("Use Infinia Diesel");
		} else {
			System.out.println("Use Infinia Nafta");
		}
		
		
		
		switch (myCar.segment) {
		case "A":
			System.out.println("City car");
			break;
		case "B":
		System.out.println("Compact");
			break;
		case "Suv":
		System.out.println("Sport Utility Vehicle");
		break;
		default:
		}
		
		switch (myC2.segment) {
		case "A":
			System.out.println("City car");
			break;
		case "B":
		System.out.println("Compact");
			break;
		case "Suv":
		System.out.println("Sport Utility Vehicle");
		break;
		default:
		}
		
		
	}
}
