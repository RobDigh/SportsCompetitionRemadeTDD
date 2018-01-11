// /rodi0231_sisc7379_arho2993
import event.Event;
import participant.Participant;
import result.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

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
            }
            else if (getEvent(cmd) != null){
                resultEvent(cmd);
            }else {
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
                case "add result":
                    addResult();
                    break;
                case "participant":
                    getParticipantResult();
                    break;
 //              case "result event":
 //                   getResultByEvent();
 //                   break;
//                case "teams":
//                    result.getResultByTeam();
//                    break;
                    case "message":
                        message(cmd);
                        break;
                    case "exit":
                    exit();
                   break;
                    default:
                        System.out.println("Unknown command: " + cmd);
                }
            }
        }
    }

    private void resultEvent(String cmd) {
        Event e = getEvent(cmd);
        System.out.println("Results for: " + cmd);
        e.resultEvent();

    }

    private void getParticipantResult() {
        Participant p = participantControl();
        if(p != null){
            p.printResults();
        }

    }

    private void addResult() {

        Participant p = participantControl();
        if(p == null){
            return;
        }
        Event e = getEvent(stringRead("Enter event: "));
        if(e == null){
            return;
        }

        if(p.hasRemainingAttempts(e)){
            double score;
            while ((score = doubleRead("Results for " + p.getFirstName() + " " + p.getLastName() + " from " +
                    p.getTeamName() + " in " + e.getEventName() +": ")) < 0) {
                System.out.println("Attempts can't be smaller than 0!");
            }
            Result r = new Result(score, p, e);
            e.addResult(r);
            p.addResult(r);

        }




    }

    public Event getEvent (String eventName){
        boolean found = false;
        for (Event event : eventList){
            if (event.getEventName().equalsIgnoreCase(eventName)){
                found = true;
                return event;
            }
        }
        if(!eventList.isEmpty()){
            System.out.println("No event called " + eventName + " found.");
        }
        return null;
    }

    private int intRead(String prompt) {
        System.out.println(prompt);
        int readInt = keyboard.nextInt();
        keyboard.nextLine();
        return readInt;
    }

    private double doubleRead(String prompt) {
        System.out.println(prompt);
        double readDouble = keyboard.nextDouble();
        keyboard.nextLine();
        return readDouble;
    }
    private String stringRead(String prompt) {
        System.out.println(prompt);
        String s = keyboard.nextLine();
        return normalizer(s);
    }

    public void addEvent(){

        int attempts;
        String eventName;

        while((eventName = stringRead("Event name: ")) == null){
            System.out.println("PLACEHOLDER WARNING");
        }
        if (getEvent(eventName) != null){
            System.out.println(eventName + " has already been added.");
            return;
        }
        while ((attempts = intRead("Attempts allowed: ")) < 1) {
            System.out.println("Attempts can't be smaller than 1!");
        }
        Event event = new Event(eventName, attempts);
        eventList.add(event);
        System.out.println(event.getEventName() + " has been added.");
    }

    public void addParticipant(){

        String firstName;
        String lastName;
        String teamName;

        while((firstName = stringRead("First name: ")) == null){
            System.out.println("PLACEHOLDER WARNING");
        }
        while((lastName = stringRead("Last name: ")) == null){
            System.out.println("PLACEHOLDER WARNING");
        }
        while((teamName = stringRead("Team name: ")) == null){
            System.out.println("PLACEHOLDER WARNING");
        }


        Participant participant = new Participant(firstName, lastName, teamName);
        participantList.add(participant);
        System.out.println(participant.getFirstName() + " " + participant.getLastName() + " from " + participant.getTeamName()
        + " has been added.");
    }

    private void removeParticipant(){

        Participant p = participantControl();

        participantList.remove(p);
        /*


        int id;
        while ((id = intRead("ID of participant to be removed: ")) < 100) {
            System.out.println("ID can't be lower than 100.");
        }



        System.out.println("Id of participant to be removed: ");
        id = keyboard.nextInt();
        if (id < 100 ){ //ev whileloop
            throw new IllegalArgumentException("Id can't be less than 100");
        }
        participantList.remove(getParticipantById(id)); */
    }

    private Participant participantControl() {
        int idCheck = intRead("ID: ");
        Participant p = null;
        for (Participant temp : participantList) {
            if (temp.getId() == idCheck)
                p = temp;
        }
        if (p == null) {
            System.out.println("No participant with ID: " + idCheck + " exists.");
        }
        return p;
    }


    public String normalizer(String s) {

        s = s.toLowerCase().trim();
        if (s.isEmpty()){
//            throw new IllegalArgumentException("");
            System.out.println("String is empty.");

        }
        else {
            char[] name = s.toCharArray();
            name[0] = ("" + (name[0])).toUpperCase().charAt(0);
            s = new String(name);
            return s;
        }
        return null;
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
