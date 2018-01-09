import event.Event;
import participant.Participant;
import result.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    Event event;
    Participant participant;
    Result result;
    private Scanner keyboard = new Scanner(System.in);

    List<Participant> participantList = new ArrayList<>();
    List<Event> eventList = new ArrayList<>();

    private void writeMenu(){
        System.out.println("Following commands are possible:");
        System.out.println(" Add event");
        System.out.println(" Add participant");
        System.out.println(" Remove participant");
        System.out.println(" Add result");
        System.out.println(" Participant");
        System.out.println(" Event result (write the name of the event");
        System.out.println(" Teams");
        System.out.println(" Message (followed by your message)");
        System.out.println(" Exit");
    }

    public void runCommandLoop() {
        writeMenu();

        boolean running = true;
        while (running) {
            System.out.println("Command> ");
            String cmd = keyboard.nextLine().toLowerCase();

            if (cmd.matches("message.+")) {
                message(cmd);
            } else {
                switch (cmd) {
                    case "add event":
                        addEvent();
                        break;
                    case "add participant":
                        addParticipant();
                        break;
                    case "remove participant":
                        removeParticipant();
                        break;
//                case "add result":
//                    result.addResult();
//                    break;
//                case "participant":
//                    result.getResultByParticipant();
//                    break;
//                case "result event":
//                    result.getResultByEvent();
//                    break;
//                case "teams":
//                    result.getResultByTeam();
//                    break;
                    case "message":
                        message(cmd);
                        break;
////                case "exit":
////                    sportsCompetition.exit();
////                    break;
                    default:
                        System.out.println("Unknown command: " + cmd);
                }
            }
        }
    }

    public void addEvent(){

        String eventName;
        int attempts;

        System.out.println("Event name: ");
        eventName = keyboard.nextLine();
        String name = normalizer(eventName);
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Names can't be empty!");
        }
        if (getEvent(name) != null){
            throw new IllegalArgumentException(eventName + " has already been added");
        }

        System.out.println("Attempt: ");
        attempts = keyboard.nextInt();
        if (attempts < 1 ){ //ev whileloop
            throw new IllegalArgumentException("Attempts can't be less than 1");
        }

        Event event = new Event(eventName, attempts);
        eventList.add(event);
//        return event;
    }

    public Participant addParticipant(){

        String firstName;
        String lastName;
        String teamName;

        System.out.println("First name: ");
        firstName = keyboard.nextLine();
        String fName = normalizer(firstName);

        System.out.println("Last name: ");
        lastName = keyboard.nextLine();
        String lName = normalizer(lastName);

        System.out.println("Team name: ");
        teamName = keyboard.nextLine();
        String tName = normalizer(teamName);

        if (fName.isEmpty() || lName.isEmpty() || tName.isEmpty()){
            throw new IllegalArgumentException("Names can't be empty!");
        }

        Participant participant = new Participant(fName, lName, tName);
        participantList.add(participant);
        return participant;
    }

    public Participant removeParticipant(){

        int id;
        System.out.println("Id of participant to be removed: ");
        id = keyboard.nextInt();
        if (id < 100 ){ //ev whileloop
            throw new IllegalArgumentException("Id can't be less than 100");
        }
        participantList.remove(getParticipantById(id));
        return participant;
    }

    public Event getEvent (String eventName){
        for (Event event : eventList){
            if (event.getEventName().equalsIgnoreCase(eventName)){
                return event;
            }
        }
        return null;
    }

    public Participant getParticipantById(int id){

        for (int i=0; i < participantList.size(); i++){
            if (participantList.get(i).getId() == id){
                return participantList.get(i);
            }
        }
        return null;
    }

    public List getParticipantList (){
        return participantList;
    }

    public String normalizer(String s) {

        s = s.toLowerCase().trim();
        if (s.isEmpty()){
            throw new IllegalArgumentException("");
        }
        char[] name = s.toCharArray();
        name[0] = ("" + (name[0])).toUpperCase().charAt(0);
        s = new String(name);
        return s;
    }

    public void message(String message){

        message = message.replaceFirst("message", "");

        if (message.length() > 56) {
            message = message.substring(0, 56);
        }

        char fill = ' ';

        String toPad = "#";
        String specialInLine = new String(new char[toPad.length() + 56 - message.length()]).replace('\0', fill) + toPad;
        System.out.println("");
        printSign(60, '#');
        System.out.println("");
        System.out.println("#                                                          #");
        System.out.print("# " + message.toUpperCase());
        System.out.println(specialInLine);
        System.out.println("#                                                          #");
        printSign(60, '#');
        System.out.println("");

    }

    private void printSign(int ammount, char type){
        for (int x = 0; x < ammount; x++){
            System.out.print(type);
        }
    }

    public void exit(){
        System.out.println("Good bye!");
        System.exit(0);
    }

    public void setUp(){
        System.out.println("Welcome");
    }

    private void run() {
        setUp();
        runCommandLoop();
//        closeDown();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.run();

    }

}
