package event;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class EventTest {

    Event event = new Event();

    @Test
    public void testAddOneEventWithOneAttempt(){



        assertEquals("Long jump", event.addEvent("long jump"));
    }

    @Test
    public void testAddMultipleEvents(){

        String event1 = event.addEvent("long jump");
        String event2 = event.addEvent("high jump");

        List<String> testEventList = new ArrayList<>();
        testEventList.add(event1);
        testEventList.add(event2);

        assertEquals((testEventList), event.getEventList());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEventNoName(){
        event.addEvent("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEventBlankSpaceName(){
        event.addEvent(" ");
    }

    @Test
    public void testEventIncorrectNameFormat(){
        assertEquals("Long jump", event.addEvent("   LoNg JuMp     "));
    }

}