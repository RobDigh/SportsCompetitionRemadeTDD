/*package event;

import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

public class EventTest {

    private Event event = new Event();
    private List<Event> testEventList  = new ArrayList<>();
    Event eventLongJump = new Event("Long jump", 1);
    Event eventHighJump = new Event("High jump", 3);

    @Test
    public void testAddOneEventWithOneAttempt(){
        assertEquals(eventLongJump, event.addEvent("Long jump", 1));
    }

    @Test
    public void testAddMultipleEventsWithDifferentAttempts(){

        testEventList.add(eventLongJump);
        testEventList.add(eventHighJump);

        event.addEvent("long jump", 1);
        event.addEvent("high jump", 3);
        assertEquals((testEventList), event.getEventList());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEventNoName(){
        event.addEvent("", 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEventBlankSpaceName(){
        event.addEvent(" ", 1);
    }

    @Test
    public void testEventIncorrectNameFormat(){
        assertEquals(eventLongJump, event.addEvent("   LoNg JuMp     ", 1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNotAllowingDuplicatesWithDifferentAttempts(){
        event.addEvent("Long jump", 1);
        event.addEvent("Long jump", 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNotAllowingDuplicatesWithSameAttempts(){
        event.addEvent("Long jump", 1);
        event.addEvent("Long jump", 1);
    }
}*/