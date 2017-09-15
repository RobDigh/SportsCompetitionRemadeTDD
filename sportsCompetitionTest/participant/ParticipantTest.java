package participant;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParticipantTest {

    Participant participant = new Participant();

    @Test
    public void testAddParticipant(){
    assertTrue(participant.addParticipant());
    }

    @Test
    public void testRemoveParticipant(){
        assertTrue(participant.removeParticipant());
    }

}