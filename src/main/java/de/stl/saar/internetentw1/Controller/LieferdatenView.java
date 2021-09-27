package de.stl.saar.internetentw1.Controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.validation.ValidationException;

import de.stl.saar.internetentw1.model.Room;

@ManagedBean
@SessionScoped
public class LieferdatenView {
    private Room room;
    private String name;
    private String response;
    


public Room getRoom(){
    return room;
}

public String getName(){
    return this.name;
}

public String getResponse(){
    return this.response;
}

public void setRoom(Room room){
    this.room = room;
}

public void setName(String name){
    this.name=name;
}

public void setResponse(String response){
    this.response=response;
}

public void validateRoom(FacesContext facesontext, UIComponent component, Object value) throws ValidationException{
    Room room = (Room) value;
    if(room.getBuilding() < 1 || room.getBuilding() > 8){
        throw new ValidatorException(new FacesMessage("Gebäudenummer muss zwischen 1 und 8 liegen"));
    }
    if(room.getFloor() < 0 || room.getFloor() >2){
        throw new ValidatorException(new FacesMessage("Flurnummer muss zwischen 0 und 2 liegen"));
        
    }
    if(room.getRoom() < 1 || room.getRoom() > 20){
        throw new ValidatorException(new FacesMessage("Raumnummer muss zwischen 1 und 20 liegen"));

    }
}

public void bestellBtn(){

    String answer="Ihre Bestellung ist auf dem Weg zu Raum ";
    String room = this.room.toString();
    this.response = answer+room;
}

}





