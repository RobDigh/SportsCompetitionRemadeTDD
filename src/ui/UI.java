//rodi0231_sisc7379_arho2993
package ui;

import event.Event;
import participant.Participant;
import result.Result;
import sportsCompetition.SportsCompetition;

import java.util.Scanner;

public class UI {

    Event event;
    Participant participant;
    Result result;
    SportsCompetition sportsCompetition;
    private Scanner keyboard = new Scanner(System.in);

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

    public void runCommandLoop(){
        writeMenu();

        boolean running = true;
        while(running){
            System.out.println("Command> ");
            String cmd = keyboard.nextLine().toLowerCase();

            switch(cmd){
                case "add event":
                    event.addEvent(cmd);
                    break;
                case "add participant":
                    participant.addParticipant();
                    break;
                case "remove participant":
                    participant.removeParticipant();
                    break;
                case "add result":
                    result.addResult();
                    break;
                case "participant":
                    result.getResultByParticipant();
                    break;
                case "result event":
                    result.getResultByEvent();
                    break;
                case "teams":
                    result.getResultByTeam();
                    break;
                case "message":
                    sportsCompetition.message(cmd);
                    break;
//                case "exit":
//                    sportsCompetition.exit();
//                    break;
                default:
                    System.out.println("Unknown command: " + cmd);
            }
        }
    }

    public void closeDown(){
        keyboard.close();
    }

    public String readString(String prompt){
        System.out.println("> " + prompt);
        return keyboard.nextLine();
    }

    public int readInt(String prompt){
        System.out.println(prompt);
        int i = keyboard.nextInt();
        keyboard.nextLine();
        return i;
    }

    public double readDouble(String prompt){
        System.out.println(prompt);
        double d = keyboard.nextInt();
        keyboard.nextLine();
        return d;
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

}
