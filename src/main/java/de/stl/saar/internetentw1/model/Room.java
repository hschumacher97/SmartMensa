package de.stl.saar.internetentw1.model;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.validation.ValidationException;


public class Room {
	private int building;
	private int floor;
	private int room;

	public Room (int building, int floor, int room){
		this.building=building;
		this.floor = floor;
		this.room = room;
	}
	

	public int getBuilding() {
		return building;
	}
	
	public void setBuilding(int building) {
		this.building = building;
	}
	
	public int getFloor() {
		return floor;
	}
	
	public void setFloor(int floor) {
		this.floor = floor;
	}
	
	public int getRoom() {
		return room;
	}
	
	public void setRoom(int room) {
		this.room = room;
	}

	
	public String toString(){
		
		if(room<10){
			return ""+building+floor+"0"+room;
		}
		return ""+building+floor+room;
	}
	
}
