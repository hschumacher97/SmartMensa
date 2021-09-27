package de.stl.saar.internetentw1.Converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.omnifaces.util.Faces;

import ch.qos.logback.core.net.SyslogOutputStream;
import de.stl.saar.internetentw1.model.Room;

@FacesConverter ("roomConverter")
public class RoomConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        int building = Character.getNumericValue(value.charAt(0));
        int floor = Character.getNumericValue(value.charAt(1));
        int roomNumber1= Character.getNumericValue(value.charAt(2));
        int roomNumber2= Character.getNumericValue(value.charAt(3));
        String roomNumberTotal = ""+roomNumber1+roomNumber2;
        int roomNumber= Integer.parseInt(roomNumberTotal);

        System.out.println("*******************************************************************************************************");
        System.out.println(""+building);
        System.out.println(""+floor);
        System.out.println(""+roomNumber);
        System.out.println("*******************************************************************************************************");        
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