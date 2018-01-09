////rodi0231_sisc7379_arho2993
//package sportsCompetition;
//
//import ui.UI;
//import event.Event;
//import participant.Participant;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class SportsCompetition {
//
//    UI ui = new UI();
//    List<Participant> participantList = new ArrayList<>();
//    List<Event> eventList = new ArrayList<>();
//
//    public SportsCompetition getSportsCompetition(){
//        return this;
//    }
//
//    public void addEvent(String eventName, int attempts){
//
//        Event event = new Event(eventName, attempts);
//        eventList.add(event);
////        return event;
//    }
//
//    public Participant getParticipantById(int id){
//
//        for (int i=0; i < participantList.size(); i++){
//            if (participantList.get(i).getId() == id){
//                return participantList.get(i);
//            }
//        }
//        return null;
//    }
//
//    public Event getEvent (String eventName){
//        for (Event event : eventList){
//            if (event.getEventName().equalsIgnoreCase(eventName)){
//                return event;
//            }
//        }
//        return null;
//    }
//
//    public List getParticipantList (){
//        return participantList;
//    }
//
////    public Participant removeParticipant(int id){
////
////        participantList.remove(getParticipantById(id));
//////        return participant;
////    }
//
////    //For testing
////    public void clearParticipantListAndResetId(){
////        participantList.clear();
////        participant.next_id = 99;
////    }
//
//    public String message(String message){
//        String cmd = message;
//        return cmd;
//    }
//
//    public void exit(){
//        System.out.println("Good bye!");
//        System.exit(0);
//    }
//
//    public void setUp(){
//        System.out.println("Welcome");
//    }
//
//    private void run() {
//        setUp();
//        ui.runCommandLoop();
//        ui.closeDown();
//    }
//
//    public static void main(String[] args) {
//        SportsCompetition sportsCompetition = new SportsCompetition();
//        sportsCompetition.run();
//
//    }
//
//}
