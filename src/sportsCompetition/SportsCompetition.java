//rodi0231_sisc7379_arho2993
package sportsCompetition;

import ui.UI;
import event.Event;
import participant.Participant;

public class SportsCompetition {

    UI ui = new UI();

    public String message(String message){
        String cmd = message;
        return cmd;
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
        ui.runCommandLoop();
        ui.closeDown();
    }

    public static void main(String[] args) {
        SportsCompetition sportsCompetition = new SportsCompetition();
        sportsCompetition.run();

    }

}
