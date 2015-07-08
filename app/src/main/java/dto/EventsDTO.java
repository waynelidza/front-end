package dto;

import java.util.Date;

/**
 * Created by CodeTribe1 on 7/8/2015.
 */
public class EventsDTO {
    private Integer eventID;
    private String eventName;
    private Date date;

    public Integer getEventID() {
        return eventID;
    }

    public void setEventID(Integer eventID) {
        this.eventID = eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
