//rodi0231_sisc7379_arho2993
package event;

import participant.Participant;
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

        TreeMap<Result, Event > topList = new TreeMap<>();
        for(Result r : resultArrayList){
            if(r.getEvent().getEventName().equalsIgnoreCase(this.eventName) &&
                    !topList.containsKey(r)){
              //  System.out.println(r.getParticipant().getFirstName() + r.getScore());
                topList.put(r, this);

            }
        }
     //   Collections.sort(topList);
        System.out.println(topList.toString());

    }






    public void testKlassSkrivaUtResultat(){
        for (Result r : resultArrayList) {


            System.out.println(r.getParticipant().getParticipantsBestResult(r.getEvent()));
        }
    }







    /*INKOPIERAD KOD NER TILLS NÄSTA VARNING
    public void eventResult() {
        Collections.sort(resultArrayList);
        Result previousResult = new Result(-1.0,null , this);
        int sharedResultTimes = 0;
        System.out.println("Results for " + eventName);
        ArrayList<Result> tempResult = getBestResults();
        for (Result display : tempResult) {
            if (display.getScore() == previousResult.getScore()) {
                System.out.println(tempResult.indexOf(display) - sharedResultTimes + " "
                        + String.format("%.2f", display.getScore()) + " " + display.getParticipant().getFirstName() + " "
                        + display.getParticipant().getLastName());
                sharedResultTimes++;
            } else {
                System.out.println(tempResult.indexOf(display) + 1 + " " + String.format("%.2f", display.getScore())
                        + " " + display.getParticipant().getFirstName() + " " + display.getParticipant().getLastName());
                sharedResultTimes = 0;
                previousResult = display;
            }
        }
    }
    */
public void getResultForEvent() {
    int placement = 1;
    Result previousPosition = null;
    Collections.sort(resultArrayList);
    ArrayList<Result> tempResult = getBestResults();
    System.out.println("Result for " + this + ":");
    for (int i = 0; i < tempResult.size(); i++) {
        Result currentPosition = tempResult.get(i);
        if (previousPosition != null) {
            if (currentPosition.getScore() != previousPosition.getScore()) {
                placement = i;
                placement++;
            }
        }
        previousPosition = currentPosition;

        if (currentPosition.getScore() > 0) {
            System.out.println((placement) + " " + currentPosition.getScore() + " " + currentPosition.getParticipant().getFirstName());
        }

    }
}

    public void removeResult(Participant p) {
        ArrayList<Result> temp = new ArrayList<>();

        for (Result r : resultArrayList) {
            if (r.getParticipant().equals(p))
                temp.add(r);
        }
        resultArrayList.removeAll(temp);
        temp.clear();

    }



    public ArrayList<Result> getBestResults() {
        ArrayList<Participant> temporaryParticipantList = new ArrayList<>();
        ArrayList<Result> temporaryResultList = new ArrayList<>();
        for (Result r : resultArrayList) {
            if (!temporaryParticipantList.contains(r.getParticipant())) {
                temporaryParticipantList.add(r.getParticipant());
                temporaryResultList.add(r);
            }
        }
        return temporaryResultList;
    }

    //INKOPIERAD KOD NER TILLS NÄSTA VARNING









    public void sortGivenArray(){

        ArrayList<Result> tempResult = new ArrayList<>();
        for(Result r : resultArrayList){
          double max = r.getScore();
          if(r.getScore() > max){

          }


        }


    }

   /* public void printParticipantsBestResults() {
        int placement = 1;
        Result previousPosition = null;
        //  ArrayList<Result> topList = getParticipantsBestResult(e);
        Participant p = null;
        ArrayList<Result> bestResult = new ArrayList<>();
        Double max = -1.0;
        for (Result r : resultArrayList){
            if(r.getEvent() == this && r.getScore() > max ){
                max = r.getScore();
                p = r.getParticipant();


            }

        }
        if(max >= 0.0) {
         //   if(!bestResult.contains(p.getId())) {
                bestResult.add(new Result(max, p, this));
                //  System.out.print(bestResult);
         //   }
        }

        System.out.println(bestResult);
        for (int i = 0; i < bestResult.size(); i++) {
            Result currentPosition = bestResult.get(i);
            if (previousPosition != null) {
                if (currentPosition.getScore() != previousPosition.getScore()) {
                    placement = i;
                    placement++;
                }
            }
            previousPosition = currentPosition;

            if (currentPosition.getScore() > 0) {

                System.out.println((placement) + " " + currentPosition.getScore() + " " + currentPosition.getParticipant().getFirstName());
            }
        }
    }
*/

    public String getEventName() {
        return eventName;
    }

    public int getAttempts(){
        return attempts;
    }

    @Override
    public String toString(){
        return eventName;
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
