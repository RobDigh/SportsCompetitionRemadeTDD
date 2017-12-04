//rodi0231_sisc7379_arho2993
package event;

import ui.UI;
import java.util.*;


public class Event {

    private UI ui = new UI();
    private List<Event> eventList = new ArrayList<>();
    private String eventName;
    private int attempts;

    public Event(String eventName, int attempts){
        this.eventName = eventName;
        this.attempts = attempts;
    }

    public Event(){

    }

    public Event addEvent(String eventName, int attempts){
        String name = ui.normalizer(eventName);
        int eventAttempts = attempts;
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Names can't be empty!");
        }
        if (getEvent(name) != null){
            throw new IllegalArgumentException(eventName + " has already been added");
        }
        Event event = new Event(name, eventAttempts);
        eventList.add(event);
        return event;
    }

    public List getEventList(){
        return eventList;
    }

    private Event getEvent (String eventName){
        for (Event event : eventList){
            if (event.getEventName().equalsIgnoreCase(eventName)){
                return event;
            }
        }
        return null;
    }

    public String getEventName() {
        return eventName;
    }

    @Override
    public String toString(){
        return eventName + " " + attempts;
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Event)) {
            return false;
        }
        Event event = (Event) o;
        return attempts == event.attempts &&
                Objects.equals(eventName, event.eventName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventName, attempts);
    }

}
