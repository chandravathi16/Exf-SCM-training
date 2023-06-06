package com.ck.scmproject.model;

import javax.persistence.Entity;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Document(collection = "devicedata")
public class DeviceData {
	
	private int Device_Id;
	private double Battery_Level;
	private double First_Sensor_temperature;
	private String Route_From;
	private String Route_To;
	
	public DeviceData() {
		super();
	}

	// Getters & Setters 
	public int getDevice_Id() {
		return Device_Id;
	}

	public void setDevice_Id(int device_Id) {
		Device_Id = device_Id;
	}

	public double getBattery_Level() {
		return Battery_Level;
	}

	public void setBattery_Level(double battery_Level) {
		Battery_Level = battery_Level;
	}

	public double getFirst_Sensor_temperature() {
		return First_Sensor_temperature;
	}

	public void setFirst_Sensor_temperature(double first_Sensor_temperature) {
		First_Sensor_temperature = first_Sensor_temperature;
	}

	public String getRoute_From() {
		return Route_From;
	}

	public void setRoute_From(String route_From) {
		Route_From = route_From;
	}

	public String getRoute_To() {
		return Route_To;
	}

	public void setRoute_To(String route_To) {
		Route_To = route_To;
	}

	@Override
	public String toString() {
		return "DeviceData [Device_Id=" + Device_Id + ", Battery_Level=" + Battery_Level + ", First_Sensor_temperature="
				+ First_Sensor_temperature + ", Route_From=" + Route_From + ", Route_To=" + Route_To + "]";
	}
	
}
