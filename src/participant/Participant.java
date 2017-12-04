// /rodi0231_sisc7379_arho2993
package participant;

import ui.UI;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Participant {

    private static int next_id = 99;
    private String firstName;
    private String lastName;
    private String teamName;
    private int id;
    private List<Participant> participantList = new ArrayList<>();
    private UI ui = new UI();

    public Participant(String firstName, String lastName, String teamName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.teamName = teamName;
        this.id = ++next_id;
    }

    //For testing
    public Participant(String firstName, String lastName, String teamName, int id){
        this.firstName = firstName;
        this.lastName = lastName;
        this.teamName = teamName;
        this.id = id;
    }

    public Participant(){

    }

    public Participant addParticipant(String firstName, String lastName, String teamName){

        String fName = ui.normalizer(firstName);
        String lName = ui.normalizer(lastName);
        String tName = ui.normalizer(teamName);

        if (fName.isEmpty() || lName.isEmpty() || tName.isEmpty()){
            throw new IllegalArgumentException("Names can't be empty!");
        }

        Participant participant = new Participant(fName, lName, tName);
        participantList.add(participant);
        return participant;
    }

    public List getParticipantList (){
        return participantList;
    }

    public boolean removeParticipant(){
        return true;
    }

    //For testing
    public void clearParticipantListAndResetId(){
        participantList.clear();
        next_id = 99;
    }

    @Override
    public String toString(){
        return firstName + " " + lastName + " " + teamName + " " + id;
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Participant)) {
            return false;
        }
        Participant participant = (Participant) o;
        return id == participant.id &&
                Objects.equals(firstName, participant.firstName) &&
                Objects.equals(lastName, participant.lastName) &&
                Objects.equals(teamName, participant.teamName);
    }

}
