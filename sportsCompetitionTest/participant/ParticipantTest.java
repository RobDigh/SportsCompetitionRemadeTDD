/*package participant;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ParticipantTest {

    private Participant participant = new Participant();
    private List<Participant> testParticipantList = new ArrayList<>();
    Participant testAdaParticipant = new Participant("Ada",
            "Lovelace", "Computing", 100);
    Participant testHawkeyeParticipant = new Participant("Hawkeye",
            "Pierce", "Mash", 101);

    @Before
    public void initialize(){
        participant.clearParticipantListAndResetId();
    }

    @Test
    public void testAddOneParticipant(){
//        participant.clearParticipantListAndResetId();
        assertEquals(testAdaParticipant, participant.addParticipant("Ada",
                "Lovelace", "Computing"));
    }

    @Test
    public void testAddMultipleParticipants(){
//        participant.clearParticipantListAndResetId();
        testParticipantList.add(testAdaParticipant);
        testParticipantList.add(testHawkeyeParticipant);

        participant.addParticipant("Ada",
                "Lovelace", "Computing");
        participant.addParticipant("Hawkeye",
                "Pierce", "Mash");

        assertEquals(testParticipantList, participant.getParticipantList());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParticipantNoFirstName(){
        participant.addParticipant("", "Lovelace", "Computing");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParticipantNoLastName(){
        participant.addParticipant("Ada", "", "Computing");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParticipantNoTeamName(){
        participant.addParticipant("Ada", "Lovelace", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParticipantBlankSpaceFirstName(){
        participant.addParticipant(" ", "Lovelace", "Computing");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParticipantBlankSpaceLastName(){
        participant.addParticipant("Ada", " ", "Computing");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParticipantBlankSpaceTeamName(){
        participant.addParticipant("Ada", "Lovelace", " ");
    }

    @Test
    public void testParticipantIncorrectNameFormatFirstName(){
        assertEquals(testAdaParticipant, participant.addParticipant("   aDa    ",
                "Lovelace", "Computing"));
    }

    @Test
    public void testParticipantIncorrectNameFormatLastName(){
        assertEquals(testAdaParticipant, participant.addParticipant("Ada",
                "   LoVelaCE     ", "Computing"));
    }

    @Test
    public void testParticipantIncorrectNameFormatTeamName(){
        assertEquals(testAdaParticipant, participant.addParticipant("Ada",
                "Lovelace", "computing"));
    }

    @Test
    public void testRemoveParticipant(){
        assertTrue(participant.removeParticipant());
    }

}*/