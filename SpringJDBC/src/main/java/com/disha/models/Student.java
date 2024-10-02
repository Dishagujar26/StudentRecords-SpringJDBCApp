package com.disha.models;
import org.springframework.context.annotation.Scope;
//this models is equal to beans 
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Student {
	private int roll;
	private String name;
	private double per;
	public int getRoll() {
		return roll;
	}
	
	@Override
	public String toString() {
		return "roll=" + roll + ", name=" + name + ", per=" + per;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPer() {
		return per;
	}
	public void setPer(double per) {
		this.per = per;
	}
	

}
