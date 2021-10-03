package de.stl.saar.internetentw1.Converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.validator.ValidatorException;
import javax.validation.ValidationException;

import org.omnifaces.util.Faces;

import ch.qos.logback.core.net.SyslogOutputStream;
import de.stl.saar.internetentw1.model.Room;

@FacesConverter ("roomConverter")
public class RoomConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value){
        
        if(value.length() != 4){
            FacesMessage message = new FacesMessage("Raumnummer muss aus 4 Ziffern bestehen");
            context.addMessage(component.getClientId(), message);
        }
        

        int building = Character.getNumericValue(value.charAt(0));
        int floor = Character.getNumericValue(value.charAt(1));
        int roomNumber1= Character.getNumericValue(value.charAt(2));
        int roomNumber2= Character.getNumericValue(value.charAt(3));
        String roomNumberTotal = ""+roomNumber1+roomNumber2;
        int roomNumber= Integer.parseInt(roomNumberTotal);
     
        Room room = new Room(building, floor, roomNumber);
        return room;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Room){
            Room room = (Room)value;
            return ""+room.getBuilding()+room.getFloor()+room.getRoom();
        }
        //Fehler
        else return "Kein Raum";

        

        
        
    }
    
}
