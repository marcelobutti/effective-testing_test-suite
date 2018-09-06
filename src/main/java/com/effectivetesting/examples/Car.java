package com.effectivetesting.examples;

public class Car extends MotorVehicle {
	private Transmission transmission;
	private String message = "Current Gear: ";
	private TireSensor tireSensor = new TireSensor();
	
	public Car() {
		transmission = new AutomaticTransmission();
	}
	public String getType() {
		return "sedan";
	}
    
	public String getTireSensorCriteria() {
		return tireSensor.getMeassurementUnit();
	}
	public void goForward() {
		transmission.setMode("DRIVE");
		System.out.println("Going forward. " + message + transmission.showCurrentGear());
	}
	
	public void accelerate(int rpm) {
		transmission.gearUp();
		System.out.println("Accelerating: " + rpm + " rpms. " + message + transmission.showCurrentGear());
	}
}
