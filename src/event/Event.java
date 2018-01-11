//rodi0231_sisc7379_arho2993
package event;

//import ui.UI;
import result.Result;

import java.util.*;


public class Event {

    private List<Result> resultArrayList = new ArrayList<>();
    private String eventName;
    private int attempts;

    public Event(String eventName, int attempts){
        this.eventName = eventName;
        this.attempts = attempts;
        this.resultArrayList = new ArrayList<>();
    }

    public void addResult(Result result){
        resultArrayList.add(result);
    }

    public void resultEvent(){

        Map<Event, Result> topList = new HashMap<Event, Result>();
        for(Result r : resultArrayList){
            if(r.getEvent().getEventName().equalsIgnoreCase(this.eventName)){
              //  System.out.println(r.getParticipant().getFirstName() + r.getScore());
                topList.put(this, r);

            }
        }
     //   Collections.sort(topList);
        System.out.println(topList.toString());




    }
    public void sortGivenArray(){

        ArrayList<Result> tempResult = new ArrayList<>();
        for(Result r : resultArrayList){
          double max = r.getScore();
          if(r.getScore() > max){

          }


        }


    }




    public String getEventName() {
        return eventName;
    }

    public int getAttempts(){
        return attempts;
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
