//rodi0231_sisc7379_arho2993
package event;

import ui.UI;

import java.util.ArrayList;
import java.util.List;


public class Event {

    UI ui = new UI();
    private List<String> eventList = new ArrayList<>();

    public String addEvent(String name){
        String eventName = ui.normalizer(name);
        if (eventName.isEmpty()) {
            throw new IllegalArgumentException("Names can't be empty!");
        }
        eventList.add(eventName);
        return eventName;
    }

    public List getEventList(){
        return eventList;
    }

}
